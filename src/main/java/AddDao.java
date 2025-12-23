import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddDao {

    public boolean addPartyMember(PartyMember member) {
        try (Connection conn = MyDbUtils.getConnection()) {
            String sql = "INSERT INTO partymember (partyvolunteerid, partyname, gender, astatus) VALUES (?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, member.getPartyVolunteerId());
            pstmt.setString(2, member.getPartyName());
            pstmt.setString(3, member.getGender());
            pstmt.setString(4, member.getAStatus());

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}