package domain;

public class Staff {
    private String SID;
    private String SName;
    private String SPassword;
    private String SGender;
    private String SPosition;
    private int SContact;
    
    public Staff(){
    }
    
    public Staff(String SID, String SName, String SPassword, String SGender, String SPosition, int SContact) {
        this.SID = SID;
        this.SName = SName;
        this.SPassword = SPassword;
        this.SGender = SGender;
        this.SPosition = SPosition;
        this.SContact = SContact;
    }
    
    public String getSID() {
        return SID;
    }

    public void setSID(String SID) {
        this.SID = SID;
    }
    
    public String getSName() {
        return SName;
    }

    public void setSName(String SName) {
        this.SName = SName;
    }
    
    public String getSPassword() {
        return SPassword;
    }

    public void setSPassword(String SPassword) {
        this.SPassword = SPassword;
    }
    
    public String getSGender() {
        return SGender;
    }

    public void setSGender(String SGender) {
        this.SGender = SGender;
    }
    
    public String getSPosition() {
        return SPosition;
    }

    public void setSPosition(String SPosition) {
        this.SPosition = SPosition;
    }
    
    public int getSContact() {
        return SContact;
    }

    public void setSContact(int SContact) {
        this.SContact = SContact;
    }
    
}
