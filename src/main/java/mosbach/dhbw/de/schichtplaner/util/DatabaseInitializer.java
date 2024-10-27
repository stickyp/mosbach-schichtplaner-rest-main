package mosbach.dhbw.de.schichtplaner.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInitializer {

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
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Executes the given SQL statements.
     *
     * @param connection The database connection.
     * @param sql The SQL statements to execute.
     * @throws SQLException If an SQL error occurs.
     */
    private static void executeSQL(Connection connection, String sql) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
        }
    }
}
