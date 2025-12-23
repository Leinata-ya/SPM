import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PartyMemberHelper {

    public static List<PartyMember> fetchAllPartyMembers() {
        List<PartyMember> partyMemberList = new ArrayList<>();
        try (Connection conn = MyDbUtils.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT PartyVolunteerId, PartyName FROM PartyMember ")) {

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