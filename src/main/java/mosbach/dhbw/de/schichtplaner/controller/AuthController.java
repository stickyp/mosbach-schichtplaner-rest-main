package mosbach.dhbw.de.schichtplaner.controller;

import mosbach.dhbw.de.schichtplaner.data.api.User;
import mosbach.dhbw.de.schichtplaner.data.api.UserManager;
import mosbach.dhbw.de.schichtplaner.data.impl.UserManagerImpl;
import mosbach.dhbw.de.schichtplaner.model.LoginRequest;
import mosbach.dhbw.de.schichtplaner.model.LoginResponse;
import mosbach.dhbw.de.schichtplaner.util.TokenUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AuthController {

    private static final Logger logger = Logger.getLogger(AuthController.class.getName());
    private final UserManager userManager = UserManagerImpl.getInstance();
    private final TokenUtil tokenUtil = new TokenUtil(); // Assuming a utility class exists for JWT

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
        logger.log(Level.INFO, "User attempting to log in: " + request.getName());

        // Retrieve the user by name
        User user = userManager.getUserByName(request.getName());
        if (user == null || !user.getPasswordHash().equals(request.getPassword())) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED); // Invalid credentials
        }

        // Generate JWT token
        String token = tokenUtil.generateToken(user);
        LoginResponse response = new LoginResponse(token, tokenUtil.getExpiryTime(), user);
        return ResponseEntity.ok(response);
    }
}
