package da;
import domain.*;
import java.sql.*;
import static java.time.Clock.system;
import javax.swing.*;

public class PurchaseDA {

    private String host = "jdbc:derby://localhost:1527/FYPDB";
    private String user = "nbuser";
    private String password = "nbuser";
    private String tableName = "Schedule";
    private Connection conn;
    private MemberDA MemberDA;
    private StaffDA StaffDA;
    private InsuranceDA InsuranceDA;
    private ScheduleDA ScheduleDA;
    private PreparedStatement stmt;
    
    public PurchaseDA(){
        createConnection();
        MemberDA = new MemberDA();
        StaffDA = new StaffDA();
        InsuranceDA = new InsuranceDA();
        ScheduleDA = new ScheduleDA();
    }
    
    
        
    public void addRecord(Purchase purchase) {
      
        try {
              //insert a new table row refer chap 5 slides 28, change .getText to getCode refer programme.java in domain
                stmt = conn.prepareStatement("INSERT INTO Purchase VALUES(?, ?, ?, ?, ?, ?, ?, ?)");
                stmt.setString(1, purchase.getPurchaseID());
                stmt.setString(2, purchase.getMember().getMID());
                stmt.setString(3,purchase.getStaff().getSID());
                stmt.setString(4, purchase.getInsurance().getInsuranceID());
                stmt.setString(5, purchase.getSchedule().getScheduleNo());
                stmt.setDouble(6, purchase.getPrice());
                stmt.setString(7, purchase.getSeatID());
                stmt.setString(8, purchase.getPDate());
                stmt.executeUpdate();
                
        } 
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public Purchase getRecord(String purchaseid) {
        String queryStr = "SELECT * FROM purchase WHERE PURCHASEID = ?";
        Purchase purchase = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, purchaseid);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Member member = MemberDA.getRecord(rs.getString("MID"));
                Staff staff = StaffDA.getRecord(rs.getString("SID"));
                Insurance insurance = InsuranceDA.getRecord(rs.getString("InsuranceID"));
                Schedule schedule = ScheduleDA.getRecord(rs.getString("ScheduleNo"));
                purchase = new Purchase(purchaseid, member,staff,insurance,schedule,rs.getDouble("Price"),rs.getString("SeatID"),rs.getString("PDate"));
                
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return purchase;
    }
    public String getlastrecord(){
          String number="";
           try {
            stmt = conn.prepareStatement("SELECT * FROM Purchase", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmt.executeQuery();
            rs.last();
            number = rs.getString(1);
            
           } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
           return number;
           
    }
    
    public void updateRecord(Purchase purchase){
        
        try{
                stmt = conn.prepareStatement("UPDATE Purchase SET MID= ? , SID=?, INSURANCEID=?,\"ScheduleNO\"=?,\"Price\"=?,\"SeatID\"=?,PDate=? WHERE PURCHASEID = ?");
                stmt.setString(1, purchase.getMember().getMID());
                stmt.setString(2,purchase.getStaff().getSID());
                stmt.setString(3, purchase.getInsurance().getInsuranceID());
                stmt.setString(4, purchase.getSchedule().getScheduleNo());
                stmt.setDouble(5, purchase.getPrice());
                stmt.setString(6, purchase.getSeatID());
                stmt.setString(7, purchase.getPDate());
                stmt.setString(8, purchase.getPurchaseID());
                stmt.executeUpdate();
                
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void deleteRecord(Purchase purchase){
        
        try{
            
            
                stmt = conn.prepareStatement("DELETE FROM purchase WHERE PurchaseID = ?");
                stmt.setString(1, purchase.getPurchaseID());
                stmt.executeUpdate();                                  
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

        
    
    public String[] getPurchaseID() {
        int count=0;
        String[] NOB={};
        try {
              
            stmt = conn.prepareStatement("SELECT * FROM purchase");
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
        PurchaseDA da = new PurchaseDA();
        /*
        MemberDA Mda = new MemberDA();
        StaffDA Sda = new StaffDA();
        ScheduleDA SCda = new ScheduleDA();
        InsuranceDA Ida = new InsuranceDA();
        String m = "M0001";
        Member member = Mda.getRecord(m);
        String st="S1001";
        Staff staff = Sda.getRecord(st);
        String sc ="S0001";
        Schedule schedule = SCda.getRecord(sc);
        String i="I0001";
        Insurance insurance = Ida.getRecord(i);
        double price = 12.9;
        Purchase purchase = new Purchase("P0001",member,staff,insurance,schedule, 1,"ds");                    
                    
        da.updateRecord(purchase);*/
    }

    private void printf(String dasd) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

