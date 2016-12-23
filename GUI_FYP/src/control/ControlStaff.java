package control;

import domain.Staff;
import da.StaffDA;

public class ControlStaff {

    private StaffDA staffDA;

    public ControlStaff() {
        staffDA = new StaffDA();
    }

    public Staff selectRecord(String SID){
        return staffDA.getRecord(SID);
    }
    
    public String getlast(){
            return staffDA.getlastrecord();
    }
        
    public Staff getSName(String staffName){
        return staffDA.getName(staffName);
    }

    public void addRecord(Staff staffMember) {
        staffDA.addRecord(staffMember);
    }
    
    public void getRecord(Staff staffMember) {
        staffDA.addRecord(staffMember);
    }
    
    public void updateRecord(Staff staffMember) {
        staffDA.updateRecord(staffMember);
    }
    
    public void deleteRecord(Staff staffMember) {
        staffDA.deleteRecord(staffMember);
    } 

    public Staff getRecord(String staffId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public String[] getDriverID(){
        return staffDA.getDriverID();
    }
    
    public String[] getReceptionistID(){
        return staffDA.getReceptionistID();
    }
    
}