

public class PartyMember {
    private String partyVolunteerId;
    private String partyName;
    private String gender;
    private String aStatus;

    // 构造方法
    public PartyMember(String partyVolunteerId, String partyName, String gender,  String aStatus) {
        this.partyVolunteerId = partyVolunteerId;
        this.partyName = partyName;
        this.gender = gender;

        this.aStatus = aStatus;
    }


    public PartyMember(String partyVolunteerId, String partyName) {
        this.partyVolunteerId = partyVolunteerId;
        this.partyName = partyName;

    }
    // Getters and Setters

    public String getPartyVolunteerId() {
        return partyVolunteerId;
    }

    public void setPartyVolunteerId(String partyVolunteerId) {
        this.partyVolunteerId = partyVolunteerId;
    }

    public String getPartyName() {
        return partyName;
    }

    public void setPartyName(String partyName) {
        this.partyName = partyName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAStatus() {
        return aStatus;
    }

    public void setAStatus(String aStatus) {


        this.aStatus = aStatus;
    }


    @Override
    public String toString() {
        return "PartyMember{" +
                "partyVolunteerId='" + partyVolunteerId + '\'' +
                ", partyName='" + partyName + '\'' +
                ", gender='" + gender + '\'' +
                ", aStatus='" + aStatus + '\'' +
                '}';
    }
}