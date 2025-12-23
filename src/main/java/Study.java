public class Study {

    private String PartyVolunteerId;
    private String Records;

    public Study() {
    }

    public Study(String PartyVolunteerId, String Records) {
        this.PartyVolunteerId = PartyVolunteerId;
        this.Records = Records;
    }

    public String getPartyVolunteerId() {
        return PartyVolunteerId;
    }

    public void setPartyVolunteerId(String PartyVolunteerId) {
        this.PartyVolunteerId = PartyVolunteerId;
    }

    public String getRecords() {
        return Records;
    }

    public void setRecords(String Records) {
        this.Records = Records;
    }

}

