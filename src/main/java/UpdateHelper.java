import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateHelper {

    public static boolean updateApprovalStatus(String partyVolunteerId) {
        try (Connection conn = MyDbUtils.getConnection()) {
            // SQL更新语句，假设你的表名为party_members，假设aStatus是审批状态字段
            String sql = "UPDATE partymember SET aStatus = 1 WHERE partyVolunteerId = ?";

            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, partyVolunteerId); // 设置党员ID

                // 执行更新操作
                int rowsAffected = pstmt.executeUpdate();
                return rowsAffected > 0; // 更新成功的行数大于0表示成功
            }
        } catch (SQLException e) {
            System.out.println("更新党员审批状态时出错：" + e.getMessage());
            return false; // 出现异常则认为更新失败
        }
    }
}