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
    private static final String GET_ALL_USERS_QUERY = "SELECT * FROM group19users";
    private static final String GET_USER_BY_ID_QUERY = "SELECT * FROM group19users WHERE id = ?";
    private static final String GET_USER_BY_NAME_QUERY = "SELECT * FROM group19users WHERE name = ?";
    private static final String CREATE_USER_QUERY = "INSERT INTO group19users (id, name, password_hash, role) VALUES (?, ?, ?, ?)";
    private static final String UPDATE_USER_QUERY = "UPDATE group19users SET name = ?, password_hash = ?, role = ? WHERE id = ?";
    private static final String DELETE_USER_QUERY = "DELETE FROM group19users WHERE id = ?";
    private static final String GET_HIGHEST_ID_QUERY = "SELECT MAX(id) AS max_id FROM group19users";

    private static UserManagerImpl instance = null;

    // Private constructor for singleton pattern
    private UserManagerImpl() {}

    public static UserManagerImpl getInstance() {
        if (instance == null) {
            instance = new UserManagerImpl();
        }
        return instance;
    }

    @Override
    public int createID() {
        int newID = 100; // Start with the smallest 3-digit number

        try (Connection connection = DatabaseConnection.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(GET_HIGHEST_ID_QUERY)) {
            if (rs.next()) {
                int highestID = rs.getInt("max_id");
                if (highestID >= 100) {
                    newID = highestID + 1;
                }
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error fetching highest user ID", e);
        }

        return newID;
    }

    @Override
    public void createUser(User user) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(CREATE_USER_QUERY)) {
            stmt.setInt(1, user.getId());
            stmt.setString(2, user.getName());
            stmt.setString(3, user.getPasswordHash());
            stmt.setString(4, user.getRole());
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
    public User getUserByName(String name) {
        User user = null;
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(GET_USER_BY_NAME_QUERY)) {
            stmt.setString(1, name);
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
            logger.log(Level.SEVERE, "Error fetching user with name: " + name, e);
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
