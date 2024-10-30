package mosbach.dhbw.de.schichtplaner.util;

import mosbach.dhbw.de.schichtplaner.data.impl.UserManagerImpl;

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
     * Creates a dummy user in the database without hashed password.
     */
    public static void createDummyUser() {
        try {
            UserManagerImpl userManager = UserManagerImpl.getInstance();
            // Using plaintext password for demonstration purpose
            String plainPassword = "TestAdmin"; // Store as plaintext in the database

            // Create the dummy user without hashing the password
            userManager.updateUser(new mosbach.dhbw.de.schichtplaner.data.impl.UserImpl(
                    100,
                    "TestAdmin",
                    plainPassword,
                    "Admin",
                    null
            ));
            logger.log(Level.INFO, "TestAdmin created successfully with plaintext password.");
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error creating dummy user: ", e);
        }
    }
}
