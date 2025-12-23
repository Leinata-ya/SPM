import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class UserDao {

    public Optional<User> findByUsername(String username) {
        try (Connection conn = MyDbUtils.getConnection();
             PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM ads WHERE username = ?")) {
            //System.out.println("Executing query: SELECT * FROM ads WHERE username = " + username);
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                User user = new User(rs.getString("username"), rs.getString("password"));
                return Optional.of(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving user from the database", e);
        }
        return Optional.empty();
    }

}