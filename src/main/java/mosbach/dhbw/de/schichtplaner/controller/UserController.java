package mosbach.dhbw.de.schichtplaner.controller;

import mosbach.dhbw.de.schichtplaner.data.api.User;
import mosbach.dhbw.de.schichtplaner.data.api.UserManager;
import mosbach.dhbw.de.schichtplaner.data.impl.UserImpl;
import mosbach.dhbw.de.schichtplaner.data.impl.UserManagerImpl;
import mosbach.dhbw.de.schichtplaner.model.*;
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
@CrossOrigin(origins = "https://eventcalender-sleepy-wallaby-ri.apps.01.cf.eu01.stackit.cloud/", allowedHeaders = "*")
public class UserController {

    private static final Logger logger = Logger.getLogger(UserController.class.getName());
    private final UserManager userManager = UserManagerImpl.getInstance();
    private final PasswordEncoder passwordEncoder;

    public UserController(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity<CreateUserResponse> createUser(@RequestBody CreateUserRequest request) {
        logger.log(Level.INFO, "Creating a new user: " + request.getName());

        int generatedId = userManager.generateID();
        String hashedPassword = passwordEncoder.encode(request.getPassword());

        User user = new UserImpl(generatedId, request.getName(), hashedPassword, request.getRole(), null);
        userManager.createUser(user);

        CreateUserResponse response = new CreateUserResponse("User created successfully", user.getId(), user.getRole());
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping(
            path = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity<UpdateUserResponse> updateUser(@PathVariable int id, @RequestBody UpdateUserRequest request) {
        logger.log(Level.INFO, "Updating user with ID: " + id);

        User user = userManager.getUserById(id);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        user.setName(request.getName());
        String hashedPassword = passwordEncoder.encode(request.getPassword());
        user.setPasswordHash(hashedPassword);
        user.setRole(request.getRole());
        userManager.updateUser(user);

        UpdateUserResponse response = new UpdateUserResponse("User updated successfully");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
