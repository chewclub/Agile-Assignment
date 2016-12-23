package control;

import domain.Member;
import da.MemberDA;

public class ControlMember {

    private MemberDA memberDA;

    public ControlMember() {
        memberDA = new MemberDA();
    }

    public Member selectRecord(String MID){
        return memberDA.getRecord(MID);
    }
    
    public String getlast(){
            return memberDA.getlastrecord();
    }
    
    public Member getMName(String memberName){
        return memberDA.getName(memberName);
    }

    public void addRecord(Member staffMember) {
        memberDA.addRecord(staffMember);
    }
    
    public void getRecord(Member staffMember) {
        memberDA.addRecord(staffMember);
    }
    
    public void updateRecord(Member staffMember) {
        memberDA.updateRecord(staffMember);
    }
    
    public void deleteRecord(Member staffMember) {
        memberDA.deleteRecord(staffMember);
    } 
    
    public String[] getMemberID(){
        return memberDA.getMemberID();
    }
    
}