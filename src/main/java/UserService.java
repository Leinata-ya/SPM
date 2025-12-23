import java.util.Optional;

public class UserService {

    private final UserDao userDao = new UserDao();

    public Optional<User> login(String username, String password) {
        Optional<User> foundUser = userDao.findByUsername(username);
        return foundUser.filter(user -> user.getPassword().equals(password));
    }


}