import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DetailHelper {

    /**
     * 根据党员ID查询党员详细信息。
     *
     * @param partyVolunteerId 党员ID
     * @return PartyMember 对象，如果查询成功；null则查询失败或党员不存在
     */
    public static PartyMember getMemberDetailsById(String partyVolunteerId) {
        try (Connection conn = MyDbUtils.getConnection()) {

            String sql = "SELECT * FROM partymember WHERE partyVolunteerId = ?";
            //System.out.println(partyVolunteerId);
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, partyVolunteerId); // 设置查询条件，党员ID

                try (ResultSet rs = pstmt.executeQuery()) {
                    if (rs.next()) {
                        // 从ResultSet中构建PartyMember对象
                        PartyMember member = new PartyMember(
                                rs.getString("partyVolunteerId"),
                                rs.getString("partyName"),
                                rs.getString("gender"),
                                rs.getString("astatus")
                        );
                        //System.out.println(member);
                        return member;
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("查询党员详细信息时出错：" + e.getMessage());
        }
        return null; // 查询失败或党员不存在时返回null
    }
}