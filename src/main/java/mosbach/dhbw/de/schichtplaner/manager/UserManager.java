package mosbach.dhbw.de.schichtplaner.manager;

import mosbach.dhbw.de.schichtplaner.data.api.User;
import java.util.List;

public interface UserManager {

    void createUser(User user);

    void updateUser(User user);

    void deleteUser(int userId);

    User getUserById(int userId);

    List<User> getAllUsers();
}
