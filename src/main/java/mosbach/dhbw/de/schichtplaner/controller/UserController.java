package mosbach.dhbw.de.schichtplaner.controller;

import mosbach.dhbw.de.schichtplaner.data.api.User;
import mosbach.dhbw.de.schichtplaner.data.api.UserManager;
import mosbach.dhbw.de.schichtplaner.data.impl.UserImpl;
import mosbach.dhbw.de.schichtplaner.data.impl.UserManagerImpl;
import mosbach.dhbw.de.schichtplaner.model.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<CreateUserResponse> createUser(@RequestBody CreateUserRequest request) {
        logger.log(Level.INFO, "Creating a new user: " + request.getName());

        // Assuming an ID generator logic in your manager or user implementation
        int generatedId = UserManagerImpl.getInstance().generateID();
        User user = new UserImpl(generatedId, request.getName(), request.getPassword(), request.getRole(), null);
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
        user.setPasswordHash(request.getPassword());
        user.setRole(request.getRole());
        userManager.updateUser(user);

        UpdateUserResponse response = new UpdateUserResponse("User updated successfully");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteUserResponse> deleteUser(@PathVariable int id) {
        logger.log(Level.INFO, "Deleting user with ID: " + id);

        User user = userManager.getUserById(id);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        userManager.deleteUser(id);
        DeleteUserResponse response = new DeleteUserResponse("User deleted successfully");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<GetAllUserResponse>> getAllUsers() {
        logger.log(Level.INFO, "Fetching all users");

        List<User> users = userManager.getAllUsers();
        List<GetAllUserResponse> responses = users.stream()
                .map(user -> new GetAllUserResponse(user.getId(), user.getName(), null, null)) // Handle LastLogin and absence separately if needed
                .collect(Collectors.toList());

        return new ResponseEntity<>(responses, HttpStatus.OK);
    }

    @GetMapping("/{id}/events")
    public ResponseEntity<GetUserEventsResponse> getUserEvents(@PathVariable int id) {
        logger.log(Level.INFO, "Fetching events for user ID: " + id);

        // Placeholder logic, should be updated to integrate with your event manager logic
        GetUserEventsResponse response = new GetUserEventsResponse();
        // Add your implementation here to fetch events for the user using the EventManager

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
