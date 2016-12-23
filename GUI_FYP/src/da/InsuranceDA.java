package da;

import domain.Insurance;
import java.sql.*;
import javax.swing.*;


public class InsuranceDA {
    private String host = "jdbc:derby://localhost:1527/FYPDB";
    private String user = "nbuser";
    private String password = "nbuser";
    private String tableName = "INSURANCE";
    private Connection conn;
    private PreparedStatement stmt;
    private ResultSet rs;
    private String sqlQuery = "SELECT * FROM" + tableName;
    
    public InsuranceDA(){
        createConnection();
    }
    
    public Insurance getRecord(String InsuranceID) {
        String queryStr = "SELECT * FROM " + tableName + " WHERE InsuranceID = ?";
        Insurance insurance = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, InsuranceID);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                insurance = new Insurance(rs.getString("InsuranceID"), rs.getString("Description"), rs.getDouble("Price"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return insurance;
    }
  
    public Insurance getName(String Description) {
        String queryStr = "SELECT * FROM " + tableName + " WHERE MNAME = ?";
        Insurance insurance = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, Description);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                insurance = new Insurance(rs.getString("InsuranceID"), Description, rs.getDouble("Price"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return insurance;
    }
    
    public void addRecord(Insurance ins) {
      
        try {
              //insert a new table row refer chap 5 slides 28, change .getText to getCode refer programme.java in domain
                stmt = conn.prepareStatement("INSERT INTO INSURANCE VALUES(?, ?, ?)");
                stmt.setString(1, ins.getInsuranceID());
                stmt.setString(2, ins.getDescription());
                stmt.setString(3, String.valueOf(ins.getPrice()));
                stmt.executeUpdate();
        } 
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void updateRecord(Insurance ins){
        
        try{
                stmt = conn.prepareStatement("UPDATE INSURANCE SET Description = ?,Price = ? WHERE InsuranceID = ?");
                stmt.setString(1, ins.getDescription());
                stmt.setString(2, String.valueOf(ins.getPrice()));
                stmt.setString(3, ins.getInsuranceID());
                stmt.executeUpdate();
                
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void deleteRecord(Insurance ins){ 
        try{
            int yesno;
            yesno = JOptionPane.showConfirmDialog(null, "Are you sure to delete?", "YES OR NO", JOptionPane.YES_NO_OPTION);
            if(yesno==0)
            {
                stmt = conn.prepareStatement("DELETE FROM INSURANCE WHERE InsuranceID = ?");
                stmt.setString(1, ins.getInsuranceID()); 
                stmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Insurance has been deleted!");  
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
            stmt = conn.prepareStatement("SELECT InsuranceID FROM INSURANCE");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
            number = rs.getString("InsuranceID");
           // JOptionPane.showMessageDialog(null, number);
           }
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
   
  public String[] getInsuranceID() {
        int count=0;
        String[] InsuranceID={};
        try {
              
            stmt = conn.prepareStatement("SELECT * FROM Insurance");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {                
                count++;
            }
            InsuranceID = new String[count];
            ResultSet rs1 = stmt.executeQuery();
            int x=0;
            while(rs1.next()){
                  InsuranceID[x] = rs1.getString(1);
                x++;
                }  
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return InsuranceID;
    }
}
