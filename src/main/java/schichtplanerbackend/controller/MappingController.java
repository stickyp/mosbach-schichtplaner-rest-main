package schichtplanerbackend.controller;

import org.springframework.web.bind.annotation.*;
import schichtplanerbackend.entities.User;
import schichtplanerbackend.repository.UserRepository;
import schichtplanerbackend.util.JwtUtil;
import schichtplanerbackend.util.PasswordUtil;

import java.sql.SQLException;

@RestController
@RequestMapping("/api/auth")
public class MappingController {
    private final UserRepository userRepository = new UserRepository();

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) throws SQLException {
        User user = userRepository.findUserByUsername(request.getUsername());
        if (user != null && PasswordUtil.verifyPassword(request.getPassword(), user.getPassword())) {
            return JwtUtil.generateToken(user.getUsername());
        } else {
            throw new RuntimeException("Invalid credentials");
        }
    }

    public class LoginRequest {
        private String username;
        private String password;

        // Default constructor
        public LoginRequest() {}

        // Parameterized constructor for convenience
        public LoginRequest(String username, String password) {
            this.username = username;
            this.password = password;
        }

        // Getter for username
        public String getUsername() {
            return username;
        }

        // Setter for username
        public void setUsername(String username) {
            this.username = username;
        }

        // Getter for password
        public String getPassword() {
            return password;
        }

        // Setter for password
        public void setPassword(String password) {
            this.password = password;
        }
    }

}

