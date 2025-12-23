import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ShenpiHelper {

        public static List<PartyMember> fetchPartyMembers() {
            List<PartyMember> partyMemberList = new ArrayList<>();
            try (Connection conn = MyDbUtils.getConnection();
                 Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery("SELECT PartyVolunteerId, PartyName FROM PartyMember where astatus='0'")) {
                while (rs.next()) {
                    String partyVolunteerId = rs.getString("PartyVolunteerId");
                    String partyName = rs.getString("PartyName");

                    PartyMember member = new PartyMember(partyVolunteerId, partyName);
                    partyMemberList.add(member);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return partyMemberList;
        }
    }
