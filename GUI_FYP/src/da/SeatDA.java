package da;

import domain.*;
import java.sql.*;
import javax.swing.*;


public class SeatDA {
    private String host = "jdbc:derby://localhost:1527/FYPDB";
    private String user = "nbuser";
    private String password = "nbuser";
    private String tableName = "Seat";
    private Connection conn;
    private PreparedStatement stmt;
    private ResultSet rs;
    private String sqlQuery = "SELECT * FROM" + tableName;
    
    public SeatDA(){
        createConnection();
    }
    
    public Seat getRecord(String SeatID) {
        String queryStr = "SELECT * FROM " + tableName + " WHERE \"SeatID\" = ?";
        Seat seat = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, SeatID);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                seat = new Seat(rs.getString("SeatID"), rs.getBoolean(2), rs.getBoolean(3), rs.getBoolean(4), rs.getBoolean(5), rs.getBoolean(6), rs.getBoolean(7), rs.getBoolean(8), rs.getBoolean(9), rs.getBoolean(10),
                 rs.getBoolean(11), rs.getBoolean(12), rs.getBoolean(13), rs.getBoolean(14), rs.getBoolean(15), rs.getBoolean(16), rs.getBoolean(17), rs.getBoolean(18), rs.getBoolean(19), rs.getBoolean(20),rs.getBoolean(21));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return seat;
    }
    
    public Seat getName(String SeatID) {
        String queryStr = "SELECT * FROM " + tableName + " WHERE SeatID = ?";
        Seat seat = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, SeatID);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                seat = new Seat(rs.getString("SID"), rs.getBoolean(1), rs.getBoolean(2), rs.getBoolean(3), rs.getBoolean(4), rs.getBoolean(5), rs.getBoolean(6), rs.getBoolean(7), rs.getBoolean(8), rs.getBoolean(9), rs.getBoolean(10),
                 rs.getBoolean(11), rs.getBoolean(12), rs.getBoolean(13), rs.getBoolean(14), rs.getBoolean(15), rs.getBoolean(16), rs.getBoolean(17), rs.getBoolean(18), rs.getBoolean(19), rs.getBoolean(20));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return seat;
    }
        
    public void addRecord(Seat seat) {
      
        try {
              //insert a new table row refer chap 5 slides 28, change .getText to getCode refer programme.java in domain
                stmt = conn.prepareStatement("INSERT INTO Seat VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
                stmt.setString(1, seat.getSeatID());
                stmt.setBoolean(2, true);
                stmt.setBoolean(3, true);
                stmt.setBoolean(4, true);
                stmt.setBoolean(5, true);
                stmt.setBoolean(6, true);
                stmt.setBoolean(7, true);
                stmt.setBoolean(8, true);
                stmt.setBoolean(9, true);
                stmt.setBoolean(10, true);
                stmt.setBoolean(11, true);
                stmt.setBoolean(12, true);
                stmt.setBoolean(13, true);
                stmt.setBoolean(14, true);
                stmt.setBoolean(15, true);
                stmt.setBoolean(16, true);
                stmt.setBoolean(17, true);
                stmt.setBoolean(18, true);
                stmt.setBoolean(19, true);
                stmt.setBoolean(20, true);
                stmt.setBoolean(21, true);
                stmt.executeUpdate();
        } 
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void updateRecord(Seat seat){
        
        try{
                stmt = conn.prepareStatement("UPDATE Seat SET S01 = ?, S02 = ?, S03 = ?, S04 = ?, S05 = ?, S06 = ?, S07 = ?, S08 = ?, S09 = ?, S10 = ?, S11 = ?, S12 = ?, S13 = ?, S14 = ?, S15 = ?, S16 = ?, S17 = ?, S18 = ?, S19 = ?, S20 = ? WHERE \"SeatID\" = ?");
                stmt.setBoolean(1, seat.getS01());
                stmt.setBoolean(2, seat.getS02());
                stmt.setBoolean(3, seat.getS03());
                stmt.setBoolean(4, seat.getS04());
                stmt.setBoolean(5, seat.getS05());
                stmt.setBoolean(6, seat.getS06());
                stmt.setBoolean(7, seat.getS07());
                stmt.setBoolean(8, seat.getS08());
                stmt.setBoolean(9, seat.getS09());
                stmt.setBoolean(10, seat.getS10());
                stmt.setBoolean(11, seat.getS11());
                stmt.setBoolean(12, seat.getS12());
                stmt.setBoolean(13, seat.getS13());
                stmt.setBoolean(14, seat.getS14());
                stmt.setBoolean(15, seat.getS15());
                stmt.setBoolean(16, seat.getS16());
                stmt.setBoolean(17, seat.getS17());
                stmt.setBoolean(18, seat.getS18());
                stmt.setBoolean(19, seat.getS19());
                stmt.setBoolean(20, seat.getS20());
                stmt.setString(21, seat.getSeatID());
                stmt.executeUpdate();
                
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
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
   
   public String[] getSeatNo() {
        int count=20;
        String[] Seatno={};
        try {
              
            stmt = conn.prepareStatement("SELECT * FROM Seat");
            ResultSet rs = stmt.executeQuery();
            Seatno = new String[count];
            ResultSet rs1 = stmt.executeQuery();

            for(int x=2;x<22;x++){
                Seatno[x-2] = "Seat "+(x-1);
            }               
  
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return Seatno;
    }
   
   public void deleteRecord(Seat seat){ 
        try{
            
                stmt = conn.prepareStatement("DELETE FROM Seat WHERE \"SeatID\" = ?");
                stmt.setString(1, seat.getSeatID()); 
                stmt.executeUpdate(); 
            
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
   
   public static void main(String[] args) {
        SeatDA da = new SeatDA();
    }
}
