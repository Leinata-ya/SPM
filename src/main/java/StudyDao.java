import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudyDao implements StudyService {

    @Override
    public boolean registerStudy(Study study) {
        try (Connection conn = MyDbUtils.getConnection()) {
            String sql = "INSERT INTO StudyRecords (PartyVolunteerId, records) VALUES (?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, study.getPartyVolunteerId());
            pstmt.setString(2, study.getRecords()); // 实际应用中应对密码进行加密处理
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}