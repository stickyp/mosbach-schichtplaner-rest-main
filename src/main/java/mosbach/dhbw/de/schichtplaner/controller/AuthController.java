package mosbach.dhbw.de.schichtplaner.controller;

import mosbach.dhbw.de.schichtplaner.data.api.UserManager;
import mosbach.dhbw.de.schichtplaner.data.impl.UserManagerImpl;
import mosbach.dhbw.de.schichtplaner.model.LoginRequest;
import mosbach.dhbw.de.schichtplaner.model.LoginResponse;
import mosbach.dhbw.de.schichtplaner.util.DatabaseInitializer;
import mosbach.dhbw.de.schichtplaner.util.TokenUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "https://eventcalender-sleepy-wallaby-ri.apps.01.cf.eu01.stackit.cloud/", allowedHeaders = "*")
public class AuthController {

    @GetMapping
    public String getAuthServerAlive() {
        return
                "The Mosbach Task Organiser is alive.";
    }

    private static final Logger logger = Logger.getLogger(AuthController.class.getName());
    private final UserManager userManager = UserManagerImpl.getInstance();
    private final TokenUtil tokenUtil = new TokenUtil();

    @PostMapping(
            path = "/login",
            consumes = {MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
        logger.log(Level.INFO, "User attempting to log in: " + request.getName());

        // Retrieve the user by name
        mosbach.dhbw.de.schichtplaner.data.api.User user = userManager.getUserByName(request.getName());
        if (user == null || !user.getPasswordHash().equals(request.getPassword())) {
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

    // New GET endpoint to create tables
    @GetMapping("/create-tables")
    public ResponseEntity<String> createTables() {
        try {
            String sqlFilePath = "src/main/resources/sql/create_tables.sql"; // Update the path to your SQL file
            DatabaseInitializer.createTablesFromSQLFile(sqlFilePath);
            logger.log(Level.INFO, "Database tables created successfully.");
            return ResponseEntity.ok("Tables created successfully.");
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error creating tables: ", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating tables: " + e.getMessage());
        }
    }
}
