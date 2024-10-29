package mosbach.dhbw.de.schichtplaner.controller;

import mosbach.dhbw.de.schichtplaner.data.api.UserManager;
import mosbach.dhbw.de.schichtplaner.data.impl.UserManagerImpl;
import mosbach.dhbw.de.schichtplaner.model.LoginRequest;
import mosbach.dhbw.de.schichtplaner.model.LoginResponse;
import mosbach.dhbw.de.schichtplaner.util.DatabaseInitializer;
import mosbach.dhbw.de.schichtplaner.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AuthController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    private static final Logger logger = Logger.getLogger(AuthController.class.getName());
    private final UserManager userManager = UserManagerImpl.getInstance();
    private final TokenUtil tokenUtil = new TokenUtil();

    // New POST endpoint to seed an initial user
    @PostMapping("/seed-initial-user")
    public ResponseEntity<String> seedInitialUser() {
        try {
            // Create an initial admin user with a predefined hashed password
            String hashedPassword = passwordEncoder.encode("TestAdmin"); // Always hash the password!
            mosbach.dhbw.de.schichtplaner.data.api.User initialUser = new mosbach.dhbw.de.schichtplaner.data.impl.UserImpl(
                    100, "TestAdmin", hashedPassword, "Admin", null);

            // Add the user to the database using UserManager
            userManager.createUser(initialUser);

            logger.log(Level.INFO, "Initial admin user created.");
            return ResponseEntity.ok("Initial admin user created successfully.");
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error creating initial admin user: ", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating initial admin user: " + e.getMessage());
        }
    }

    // Other existing methods...

    @PostMapping(
            path = "/login",
            consumes = {MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
        logger.log(Level.INFO, "User attempting to log in: " + request.getName());

        // Create a dummy user without checking the database
        mosbach.dhbw.de.schichtplaner.model.User dummyUser = new mosbach.dhbw.de.schichtplaner.model.User(100, "TestAdmin", "admin");
        String token = tokenUtil.generateToken(dummyUser.getName());

        // Send response with token and expiry time
        LoginResponse response = new LoginResponse(token, (int) tokenUtil.getExpiryTime(), dummyUser);
        return ResponseEntity.ok(response);
    }

    // New GET endpoint to create tables and dummy user
    @GetMapping("/create-tables")
    public ResponseEntity<String> createTablesAndDummyUser() {
        try {
            String sqlFilePath = "src/main/resources/sql/create_tables.sql"; // Update the path to your SQL file
            DatabaseInitializer.createTablesFromSQLFile(sqlFilePath);
            DatabaseInitializer.createDummyUser();
            logger.log(Level.INFO, "Database tables and dummy user created successfully.");
            return ResponseEntity.ok("Tables and dummy user created successfully.");
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error creating tables or dummy user: ", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating tables or dummy user: " + e.getMessage());
        }
    }


    /*
    @PostMapping(
            path = "/login",
            consumes = {MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
        logger.log(Level.INFO, "User attempting to log in: " + request.getName());

        // Retrieve the user by name
        mosbach.dhbw.de.schichtplaner.data.api.User user = userManager.getUserByName(request.getName());
        if (user == null || !passwordEncoder.matches(request.getPassword(), user.getPasswordHash())) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED); // Invalid credentials
        }

        // Generate JWT token with the user's name
        String token = tokenUtil.generateToken(user.getName());

        // Convert the retrieved User from data.api to model.User
        mosbach.dhbw.de.schichtplaner.model.User userModel = new mosbach.dhbw.de.schichtplaner.model.User(user.getId(), user.getName(), user.getRole());

        // Send response with token and expiry time
        LoginResponse response = new LoginResponse(token, (int) tokenUtil.getExpiryTime(), userModel);
        return ResponseEntity.ok(response);
    }
    */
}
