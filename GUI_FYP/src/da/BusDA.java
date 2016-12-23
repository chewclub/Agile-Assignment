package da;
import domain.*;
import java.sql.*;
import javax.swing.*;

public class BusDA {

    private String host = "jdbc:derby://localhost:1527/FYPDB";
    private String user = "nbuser";
    private String password = "nbuser";
    private String tableName = "BUS";
    private Connection conn;
    private StaffDA StaffDA;
    private PreparedStatement stmt;
    
    public BusDA(){
        createConnection();
        StaffDA = new StaffDA();
    }
    
    
        
    public void addRecord(Bus bus) {
      
        try {
              //insert a new table row refer chap 5 slides 28, change .getText to getCode refer programme.java in domain
                stmt = conn.prepareStatement("INSERT INTO Bus VALUES(?, ?, ?,?)");
                stmt.setInt(1, bus.getBusNo());
                stmt.setInt(2, bus.getNumberofSeat());
                stmt.setString(3, bus.getStaff().getSID());
                stmt.setString(4, bus.getBPlate());
                stmt.executeUpdate();
                
        } 
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public Bus getRecord(int busno) {
        String queryStr = "SELECT * FROM " + tableName + " WHERE BusNO = ?";
        Bus bus = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setInt(1, busno);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                Staff staff = StaffDA.getRecord(rs.getString("SID"));
                
                bus = new Bus(busno, rs.getInt("NumberofSeat"), staff, rs.getString("BPlate"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return bus;
    }
    
    public void updateRecord(Bus bus){
        
        try{
                stmt = conn.prepareStatement("UPDATE Bus SET numberofseat = ? , SID=?, \"BPlate\"=? WHERE BusNO = ?");
                stmt.setInt(1,bus.getNumberofSeat());
                stmt.setString(2,bus.getStaff().getSID());
                stmt.setString(3,bus.getBPlate());
                stmt.setInt(4,bus.getBusNo());
                stmt.executeUpdate();
                
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void deleteRecord(Bus bus){
        
        try{
            
            
                stmt = conn.prepareStatement("DELETE FROM Bus WHERE BusNO = ?");
                stmt.setInt(1, bus.getBusNo());
                stmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Bus has been deleted!");
                        
            
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
      public int getlastrecord1(){
          int number=0;
           try {
            stmt = conn.prepareStatement("SELECT BusNO FROM Bus", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmt.executeQuery();
            rs.last();
            number = rs.getInt(1);
            
           } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
           return number;
    }
        
    
    public String[] getNOBus() {
        int count=0;
        String[] NOB={};
        try {
              
            stmt = conn.prepareStatement("SELECT BusNO FROM Bus");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                count++;
            }
            NOB = new String[count];
            ResultSet rs1 = stmt.executeQuery();
            int x=0;
            while(rs1.next()){
                NOB[x] = rs1.getString(1);
                x++;
            }
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return NOB;
    }

    
    private void createConnection() {
        try {
            conn = DriverManager.getConnection(host, user, password);
            System.out.println("***TRACE: Connection established.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void shutDown() {
        if (conn != null)
            try {
            conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    public static void main(String[] args) {
        BusDA da = new BusDA();
    }
    
}
