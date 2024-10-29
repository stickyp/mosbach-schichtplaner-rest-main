package mosbach.dhbw.de.schichtplaner.controller;

import mosbach.dhbw.de.schichtplaner.data.api.User;
import mosbach.dhbw.de.schichtplaner.data.api.UserManager;
import mosbach.dhbw.de.schichtplaner.data.impl.AbsenceManagerImpl;
import mosbach.dhbw.de.schichtplaner.data.impl.UserImpl;
import mosbach.dhbw.de.schichtplaner.data.impl.UserManagerImpl;
import mosbach.dhbw.de.schichtplaner.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {

    private static final Logger logger = Logger.getLogger(UserController.class.getName());
    private final UserManager userManager = UserManagerImpl.getInstance();

    @Autowired
    private PasswordEncoder passwordEncoder; // Autowired PasswordEncoder

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<CreateUserResponse> createUser(@RequestBody CreateUserRequest request) {
        logger.log(Level.INFO, "Creating a new user: " + request.getName());

        // Assuming an ID generator logic in your manager or user implementation
        int generatedId = UserManagerImpl.getInstance().generateID();
        String hashedPassword = passwordEncoder.encode(request.getPassword()); // Hash the password

        User user = new UserImpl(generatedId, request.getName(), hashedPassword, request.getRole(), null); // Store hashed password
        userManager.createUser(user);

        CreateUserResponse response = new CreateUserResponse("User created successfully", user.getId(), user.getRole());
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UpdateUserResponse> updateUser(@PathVariable int id, @RequestBody UpdateUserRequest request) {
        logger.log(Level.INFO, "Updating user with ID: " + id);

        User user = userManager.getUserById(id);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        user.setName(request.getName());
        user.setPasswordHash(passwordEncoder.encode(request.getPassword())); // Hash the new password
        user.setRole(request.getRole());
        userManager.updateUser(user);

        UpdateUserResponse response = new UpdateUserResponse("User updated successfully");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
