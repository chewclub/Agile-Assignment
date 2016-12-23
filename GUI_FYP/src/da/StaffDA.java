package da;

import domain.Staff;
import java.sql.*;
import javax.swing.*;


public class StaffDA {
    private String host = "jdbc:derby://localhost:1527/FYPDB";
    private String user = "nbuser";
    private String password = "nbuser";
    private String tableName = "STAFF";
    private Connection conn;
    private PreparedStatement stmt;
    private ResultSet rs;
    private String sqlQuery = "SELECT * FROM" + tableName;
    
    public StaffDA(){
        createConnection();
    }
    
    public Staff getRecord(String SID) {
        String queryStr = "SELECT * FROM " + tableName + " WHERE SID = ?";
        Staff staff = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, SID);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                staff = new Staff(rs.getString("SID"), rs.getString("SName"), rs.getString("SPassword"), rs.getString("SGender"), rs.getString("SPosition"), rs.getInt("SContact"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return staff;
    }
    
    public Staff getName(String SName) {
        String queryStr = "SELECT * FROM " + tableName + " WHERE SNAME = ?";
        Staff staff = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, SName);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                staff = new Staff(rs.getString("SID"), SName, rs.getString("SPassword"), rs.getString("SGender"), rs.getString("SPosition"), rs.getInt("SContact"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return staff;
    }
        
    public void addRecord(Staff staffMember) {
      
        try {
              //insert a new table row refer chap 5 slides 28, change .getText to getCode refer programme.java in domain
                stmt = conn.prepareStatement("INSERT INTO STAFF VALUES(?, ?, ?, ?, ?, ?)");
                stmt.setString(1, staffMember.getSID());
                stmt.setString(2, staffMember.getSName());
                stmt.setString(3, staffMember.getSPassword());
                stmt.setString(4, staffMember.getSGender());
                stmt.setString(5, staffMember.getSPosition());
                stmt.setString(6, String.valueOf(staffMember.getSContact()));
                stmt.executeUpdate();
        } 
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void updateRecord(Staff staffMember){
        
        try{
                stmt = conn.prepareStatement("UPDATE STAFF SET SName = ?, SPassword = ?, SGender = ?, SPosition = ?, SContact = ? WHERE SID = ?");
                stmt.setString(1, staffMember.getSName());
                stmt.setString(2, staffMember.getSPassword());
                stmt.setString(3, staffMember.getSGender());
                stmt.setString(4, staffMember.getSPosition());
                stmt.setString(5, String.valueOf(staffMember.getSContact()));
                stmt.setString(6, staffMember.getSID());
                stmt.executeUpdate();
                
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void deleteRecord(Staff staffMember){ 
        try{
            int yesno;
            yesno = JOptionPane.showConfirmDialog(null, "Are you sure to delete?", "YES OR NO", JOptionPane.YES_NO_OPTION);
            if(yesno==0)
            {
                stmt = conn.prepareStatement("DELETE FROM STAFF WHERE SID = ?");
                stmt.setString(1, staffMember.getSID()); 
                stmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Staff has been deleted!");  
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
            stmt = conn.prepareStatement("SELECT SID FROM STAFF", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
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
   
   public String[] getDriverID() {
        int count=0;
        String[] DriverName={};
        try {
              
            stmt = conn.prepareStatement("SELECT * FROM STAFF");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                String position1 = rs.getString(5);
                if("Driver".equals(position1)){
                count++;}
            }
            DriverName = new String[count];
            ResultSet rs1 = stmt.executeQuery();
            int x=0;
            while(rs1.next()){
                String position = rs1.getString(5);
                if("Driver".equals(position)){
                  DriverName[x] = rs1.getString(1);
                x++;
                }
            }  
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return DriverName;
    }
   
   public String[] getReceptionistID() {
        int count=0;
        String[] DriverName={};
        try {
              
            stmt = conn.prepareStatement("SELECT * FROM STAFF");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                String position1 = rs.getString(5);
                if("Receptionist".equals(position1)){
                count++;}
            }
            DriverName = new String[count];
            ResultSet rs1 = stmt.executeQuery();
            int x=0;
            while(rs1.next()){
                String position = rs1.getString(5);
                if("Receptionist".equals(position)){
                  DriverName[x] = rs1.getString(1);
                x++;
                }
            }  
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return DriverName;
    }
   public static void main(String[] args) {
        StaffDA da = new StaffDA();
        Staff staff = da.getRecord("S1003");
    }


}
