package mosbach.dhbw.de.schichtplaner.data.api;

import java.util.List;

public interface UserManager {
    int createID();

    void createUser(User user);

    void updateUser(User user);

    void deleteUser(int userId);

    User getUserById(int userId);

    List<User> getAllUsers();
}
