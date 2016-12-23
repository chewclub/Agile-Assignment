package domain;

public class Member {
    private String MID;
    private String MName;
    private String MIC;
    private String MGender;
    private int MContact;
    
    public Member(){
    }
    
    public Member(String MID, String MName, String MIC, String MGender, int MContact) {
        this.MID = MID;
        this.MName = MName;
        this.MIC = MIC;
        this.MGender = MGender;
        this.MContact = MContact;
    }
    
    public String getMID() {
        return MID;
    }

    public void setMID(String MID) {
        this.MID = MID;
    }
    
    public String getMName() {
        return MName;
    }

    public void setMName(String MName) {
        this.MName = MName;
    }
    
    public String getMIC() {
        return MIC;
    }

    public void setMIC(String MIC) {
        this.MIC = MIC;
    }
    
    public String getMGender() {
        return MGender;
    }

    public void setMGender(String MGender) {
        this.MGender = MGender;
    }
    
    public int getMContact() {
        return MContact;
    }

    public void setMContact(int MContact) {
        this.MContact = MContact;
    }
    
}
