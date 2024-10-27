package mosbach.dhbw.de.schichtplaner.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:postgresql://localhost:5432/scheduleDB";
    private static final String USERNAME = "your_db_username";
    private static final String PASSWORD = "your_db_password";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}