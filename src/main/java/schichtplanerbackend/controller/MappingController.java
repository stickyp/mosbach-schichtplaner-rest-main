package schichtplanerbackend.controller;


import org.springframework.web.bind.annotation.*;
import schichtplanerbackend.entities.User;
import schichtplanerbackend.repository.UserRepository;
import schichtplanerbackend.util.DatabaseConnection;
import schichtplanerbackend.util.JwtUtil;
import schichtplanerbackend.util.PasswordUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


@RestController
@RequestMapping("/api")
public class MappingController {
    private final UserRepository userRepository = new UserRepository();

    @PostMapping("/create-tables")
    public String createTables() {
        String result;
        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement()) {

            // SQL commands to create users table
            String createUserTableSQL = "CREATE TABLE IF NOT EXISTS users (" +
                    "id SERIAL PRIMARY KEY, " +
                    "username VARCHAR(100) UNIQUE NOT NULL, " +
                    "password VARCHAR(100) NOT NULL, " +
                    "role VARCHAR(50) NOT NULL" +
                    ");";

            // SQL commands to create events table
            String createEventTableSQL = "CREATE TABLE IF NOT EXISTS events (" +
                    "id SERIAL PRIMARY KEY, " +
                    "title VARCHAR(100) NOT NULL, " +
                    "start_date_time TIMESTAMP NOT NULL, " +
                    "end_date_time TIMESTAMP NOT NULL, " +
                    "location VARCHAR(100), " +
                    "description TEXT, " +
                    "assigned_user_id INT REFERENCES users(id) ON DELETE SET NULL" +
                    ");";

            // SQL commands to create absences table
            String createAbsenceTableSQL = "CREATE TABLE IF NOT EXISTS absences (" +
                    "id SERIAL PRIMARY KEY, " +
                    "start_date_time TIMESTAMP NOT NULL, " +
                    "end_date_time TIMESTAMP NOT NULL, " +
                    "reason TEXT, " +
                    "user_id INT REFERENCES users(id) ON DELETE SET NULL" +
                    ");";

            // Execute the SQL commands
            statement.execute(createUserTableSQL);
            statement.execute(createEventTableSQL);
            statement.execute(createAbsenceTableSQL);

            result = "Tables created successfully.";
        } catch (SQLException e) {
            e.printStackTrace();
            result = "Error creating tables: " + e.getMessage();
        }
        return result;
    }

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

