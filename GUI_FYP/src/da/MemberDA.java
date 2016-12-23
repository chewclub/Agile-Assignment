package da;

import domain.Member;
import java.sql.*;
import javax.swing.*;


public class MemberDA {
    private String host = "jdbc:derby://localhost:1527/FYPDB";
    private String user = "nbuser";
    private String password = "nbuser";
    private String tableName = "MEMBER";
    private Connection conn;
    private PreparedStatement stmt;
    private ResultSet rs;
    private String sqlQuery = "SELECT * FROM" + tableName;
    
    public MemberDA(){
        createConnection();
    }
    
    public Member getRecord(String MID) {
        String queryStr = "SELECT * FROM " + tableName + " WHERE MID = ?";
        Member member = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, MID);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                member = new Member(rs.getString("MID"), rs.getString("MName"), rs.getString("MIC"), rs.getString("MGender"), rs.getInt("MContact"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return member;
    }
    
    
    public Member getName(String MName) {
        String queryStr = "SELECT * FROM " + tableName + " WHERE MNAME = ?";
        Member member = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, MName);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                member = new Member(rs.getString("MID"), MName, rs.getString("MIC"), rs.getString("MGender"), rs.getInt("MContact"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return member;
    }
        
    public void addRecord(Member staffMember) {
      
        try {
              //insert a new table row refer chap 5 slides 28, change .getText to getCode refer programme.java in domain
                stmt = conn.prepareStatement("INSERT INTO MEMBER VALUES(?, ?, ?, ?, ?)");
                stmt.setString(1, staffMember.getMID());
                stmt.setString(2, staffMember.getMName());
                stmt.setString(3, staffMember.getMIC());
                stmt.setString(4, staffMember.getMGender());
                stmt.setString(5, String.valueOf(staffMember.getMContact()));
                stmt.executeUpdate();
        } 
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void updateRecord(Member staffMember){
        
        try{
                stmt = conn.prepareStatement("UPDATE MEMBER SET MName = ?, MIC = ?, MGender = ?, MContact = ? WHERE MID = ?");
                stmt.setString(1, staffMember.getMName());
                stmt.setString(2, staffMember.getMIC());
                stmt.setString(3, staffMember.getMGender());
                stmt.setString(4, String.valueOf(staffMember.getMContact()));
                stmt.setString(5, staffMember.getMID());
                stmt.executeUpdate();
                
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void deleteRecord(Member staffMember){ 
        try{
            int yesno;
            yesno = JOptionPane.showConfirmDialog(null, "Are you sure to delete?", "YES OR NO", JOptionPane.YES_NO_OPTION);
            if(yesno==0)
            {
                stmt = conn.prepareStatement("DELETE FROM MEMBER WHERE MID = ?");
                stmt.setString(1, staffMember.getMID()); 
                stmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Member has been deleted!");  
            }
            /*else{
                JOptionPane.showMessageDialog(null, "You have cancel delete!", "CANCEL", JOptionPane.ERROR_MESSAGE);
            }*/
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public String getlastrecord(){
          String number="";
           try {
            stmt = conn.prepareStatement("SELECT MID FROM MEMBER", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmt.executeQuery();
            rs.last();
            number = rs.getString(1);
            
           } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
           return number;
    }
    
    private void createConnection(){
        try {
            conn = DriverManager.getConnection(host, user, password);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
   private void shutDown() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
   
   public String[] getMemberID() {
        int count=0;
        String[] DriverName={};
        try {
              
            stmt = conn.prepareStatement("SELECT * FROM Member");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {                
                count++;
            }
            DriverName = new String[count];
            ResultSet rs1 = stmt.executeQuery();
            int x=0;
            while(rs1.next()){
                  DriverName[x] = rs1.getString(1);
                x++;
                
            }  
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return DriverName;
    }

}
