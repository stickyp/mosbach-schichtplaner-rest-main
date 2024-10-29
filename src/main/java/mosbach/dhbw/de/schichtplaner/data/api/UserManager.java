package mosbach.dhbw.de.schichtplaner.data.api;

import java.util.List;

public interface UserManager {

    /**
     * Generates a unique ID for a new user.
     * @return int - a unique user ID.
     */
    int generateID(); // Changed from createID()

    /**
     * Creates a new user.
     * @param user - the user to be created.
     */
    void createUser(User user);

    /**
     * Updates an existing user.
     * @param user - the user with updated information.
     */
    void updateUser(User user);

    /**
     * Deletes an existing user.
     * @param userId - the ID of the user to be deleted.
     */
    void deleteUser(int userId);

    /**
     * Gets a user by their ID.
     * @param userId - the ID of the user.
     * @return User - the user found with the specified ID.
     */
    User getUserById(int userId);

    /**
     * Gets a user by their name.
     * @param name - the name of the user.
     * @return User - the user found with the specified name.
     */
    User getUserByName(String name);

    /**
     * Gets all users.
     * @return List<User> - a list of all users.
     */
    List<User> getAllUsers();
}
