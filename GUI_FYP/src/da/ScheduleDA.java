package da;
import domain.*;
import java.sql.*;
import static java.time.Clock.system;
import javax.swing.*;

public class ScheduleDA {

    private String host = "jdbc:derby://localhost:1527/FYPDB";
    private String user = "nbuser";
    private String password = "nbuser";
    private String tableName = "Schedule";
    private Connection conn;
    private BusDA BusDA;
    private PreparedStatement stmt;
    
    public ScheduleDA(){
        createConnection();
        BusDA = new BusDA();
    }
    
    
        
    public void addRecord(Schedule schedule) {
      
        try {
              //insert a new table row refer chap 5 slides 28, change .getText to getCode refer programme.java in domain
                stmt = conn.prepareStatement("INSERT INTO Schedule VALUES(?, ?, ?, ?, ?, ?, ?, ?)");
                stmt.setString(1, schedule.getScheduleNo());
                stmt.setString(2, schedule.getDate1());
                stmt.setString(3,schedule.getTime1());
                stmt.setString(4, schedule.getStartingPoint());
                stmt.setString(5, schedule.getDestination());
                stmt.setInt(6, schedule.getBus().getBusNo());
                stmt.setDouble(7, schedule.getPrice());
                stmt.setInt(8, schedule.getavailable());
                stmt.executeUpdate();
                
        } 
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public Schedule getRecord(String scheduleno) {
        String queryStr = "SELECT * FROM NBUSER.SCHEDULE WHERE \"ScheduleNO\" = ?";
        Schedule schedule = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, scheduleno);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Bus bus = BusDA.getRecord(rs.getInt("BUSNO"));
                schedule = new Schedule(scheduleno, rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),bus,rs.getDouble(7),rs.getInt(8));
                
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return schedule;
    }
    public String getlastrecord(){
          String number="";
           try {
            stmt = conn.prepareStatement("SELECT * FROM Schedule", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmt.executeQuery();
            rs.last();
            number = rs.getString(1);
            
           } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
           return number;
           
    }
    
    public void updateRecord(Schedule schedule){
        
        try{
                stmt = conn.prepareStatement("UPDATE schedule SET \"Date1\"= ? , \"Time1\"=?, \"Startingpoint\"=?,\"Destination\"=?,\"BUSNO\"=?,\"Price\"=?,\"Available\"=? WHERE \"ScheduleNO\" = ?");
                stmt.setString(1,schedule.getDate1());
                stmt.setString(2,schedule.getTime1());
                stmt.setString(3,schedule.getStartingPoint());
                stmt.setString(4,schedule.getDestination());
                stmt.setInt(5,schedule.getBus().getBusNo());
                stmt.setDouble(6,schedule.getPrice());
                stmt.setInt(7,schedule.getavailable());
                stmt.setString(8,schedule.getScheduleNo());
                stmt.executeUpdate();
                
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void deleteRecord(Schedule schedule){
        
        try{
            
            
                stmt = conn.prepareStatement("DELETE FROM schedule WHERE \"ScheduleNO\" = ?");
                stmt.setString(1, schedule.getScheduleNo());
                stmt.executeUpdate();                                  
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

        
    
    public String[] getScheduleNO() {
        int count=0;
        String[] NOB={};
        try {
              
            stmt = conn.prepareStatement("SELECT * FROM Schedule");
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
        ScheduleDA da = new ScheduleDA();
    }

    private void printf(String dasd) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

