public interface RegisterService {
    boolean registerUser(User user);

    public class UserService implements RegisterService {
        @Override
        public boolean registerUser(User user) {
            return false;
        }
    }
}