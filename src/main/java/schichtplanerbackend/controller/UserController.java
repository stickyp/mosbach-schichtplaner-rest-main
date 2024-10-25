package schichtplanerbackend.controller;


import org.springframework.web.bind.annotation.*;
import schichtplanerbackend.entities.User;
import schichtplanerbackend.repository.UserRepository;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserRepository userRepository = new UserRepository();

    @GetMapping
    public List<User> getAllUsers() throws SQLException {
        return userRepository.findAllUsers();
    }

    @PostMapping("/register")
    public void registerUser(@RequestBody User user) throws SQLException {
        userRepository.saveUser(user);
    }

    @GetMapping("/{username}")
    public User getUserByUsername(@PathVariable String username) throws SQLException {
        return userRepository.findUserByUsername(username);
    }
}

