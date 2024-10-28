package mosbach.dhbw.de.schichtplaner.data.impl;

import mosbach.dhbw.de.schichtplaner.data.api.User;
import mosbach.dhbw.de.schichtplaner.data.api.UserManager;
import mosbach.dhbw.de.schichtplaner.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserManagerImpl implements UserManager {

    private static final Logger logger = Logger.getLogger(UserManagerImpl.class.getName());

    // SQL Queries
    private static final String GET_ALL_USERS_QUERY = "SELECT * FROM group19users";
    private static final String GET_USER_BY_ID_QUERY = "SELECT * FROM group19users WHERE id = ?";
    private static final String CREATE_USER_QUERY = "INSERT INTO group19users (name, password_hash, role) VALUES (?, ?, ?)";
    private static final String UPDATE_USER_QUERY = "UPDATE group19users SET name = ?, password_hash = ?, role = ? WHERE id = ?";
    private static final String DELETE_USER_QUERY = "DELETE FROM group19users WHERE id = ?";

    // Singleton instance
    private static UserManagerImpl instance;

    // Private constructor to prevent instantiation
    private UserManagerImpl() {}

    // Public method to provide access to the singleton instance
    public static UserManagerImpl getInstance() {
        if (instance == null) {
            synchronized (UserManagerImpl.class) {
                if (instance == null) {
                    instance = new UserManagerImpl();
                }
            }
        }
        return instance;
    }

    @Override
    public void createUser(User user) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(CREATE_USER_QUERY)) {
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getPasswordHash());
            stmt.setString(3, user.getRole());
            stmt.executeUpdate();
            logger.log(Level.INFO, "User created successfully: " + user.getName());
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error creating user: " + user.getName(), e);
        }
    }

    @Override
    public void updateUser(User user) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(UPDATE_USER_QUERY)) {
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getPasswordHash());
            stmt.setString(3, user.getRole());
            stmt.setInt(4, user.getId());
            stmt.executeUpdate();
            logger.log(Level.INFO, "User updated successfully: " + user.getName());
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error updating user: " + user.getName(), e);
        }
    }

    @Override
    public void deleteUser(int userId) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(DELETE_USER_QUERY)) {
            stmt.setInt(1, userId);
            stmt.executeUpdate();
            logger.log(Level.INFO, "User deleted successfully with ID: " + userId);
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error deleting user with ID: " + userId, e);
        }
    }

    @Override
    public User getUserById(int userId) {
        User user = null;
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(GET_USER_BY_ID_QUERY)) {
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                user = new UserImpl(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("password_hash"),
                        rs.getString("role"),
                        rs.getString("jwt_token")
                );
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error fetching user with ID: " + userId, e);
        }
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(GET_ALL_USERS_QUERY)) {
            while (rs.next()) {
                users.add(new UserImpl(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("password_hash"),
                        rs.getString("role"),
                        rs.getString("jwt_token")
                ));
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error fetching all users", e);
        }
        return users;
    }
}
