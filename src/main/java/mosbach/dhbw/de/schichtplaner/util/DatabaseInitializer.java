package mosbach.dhbw.de.schichtplaner.util;

import mosbach.dhbw.de.schichtplaner.data.impl.UserManagerImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseInitializer {

    private static final Logger logger = Logger.getLogger(DatabaseInitializer.class.getName());
    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(); // PasswordEncoder instance

    /**
     * Reads the SQL file and executes each statement to create the tables.
     *
     * @param filePath The path to the SQL file.
     */
    public static void createTablesFromSQLFile(String filePath) {
        try (Connection connection = DatabaseConnection.getConnection();
             BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            StringBuilder sql = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                sql.append(line).append("\n");
            }
            executeSQL(connection, sql.toString());
            logger.log(Level.INFO, "Tables created successfully.");
        } catch (SQLException | IOException e) {
            logger.log(Level.SEVERE, "Error creating tables: ", e);
            e.printStackTrace();
        }
    }

    /**
     * Executes the given SQL statements.
     *
     * @param connection The database connection.
     * @param sql        The SQL statements to execute.
     * @throws SQLException If an SQL error occurs.
     */
    private static void executeSQL(Connection connection, String sql) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
        }
    }

    /**
     * Creates a dummy user in the database with hashed password.
     */
    public static void createDummyUser() {
        try {
            UserManagerImpl userManager = UserManagerImpl.getInstance();
            // Generate a hashed password using the PasswordEncoder
            String hashedPassword = passwordEncoder.encode("TestAdmin"); // Secure hashed password

            // Create the dummy user with hashed password
            userManager.updateUser(new mosbach.dhbw.de.schichtplaner.data.impl.UserImpl(
                    100,
                    "TestAdmin",
                    hashedPassword,
                    "Admin",
                    null
            ));
            logger.log(Level.INFO, "TestAdmin created successfully with hashed password.");
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error creating dummy user: ", e);
        }
    }
}
