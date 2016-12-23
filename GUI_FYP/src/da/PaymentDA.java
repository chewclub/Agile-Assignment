package da;
import domain.*;
import java.sql.*;
import javax.swing.*;

public class PaymentDA {

    private String host = "jdbc:derby://localhost:1527/FYPDB";
    private String user = "nbuser";
    private String password = "nbuser";
    private String tableName = "Payment";
    private Connection conn;
    private PurchaseDA PurchaseDA;
    private StaffDA StaffDA;
    private PreparedStatement stmt;
    
    public PaymentDA(){
        createConnection();
        PurchaseDA = new PurchaseDA();
        StaffDA = new StaffDA();
    }
    
    public Payment getRecord(String PaymentID) {
        String queryStr = "SELECT * FROM " + tableName + " WHERE \"PaymentID\" = ?";
        Payment payment = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, PaymentID);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                Purchase purchase = PurchaseDA.getRecord(rs.getString("PurchaseID"));
                Staff staff = StaffDA.getRecord(rs.getString("SID"));
                payment = new Payment(rs.getString(1), purchase, rs.getString(3), rs.getDouble(4),staff, rs.getString(6));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return payment;
    }
        
    public void addRecord(Payment payment) {
      
        try {
              //insert a new table row refer chap 5 slides 28, change .getText to getCode refer programme.java in domain
                stmt = conn.prepareStatement("INSERT INTO Payment VALUES(?, ?, ?,?,?,?)");
                stmt.setString(1, payment.getPaymentID());
                stmt.setString(2, payment.getPurchaseID().getPurchaseID());
                stmt.setString(3, payment.getPaymentMethod());
                stmt.setDouble(4, payment.getAmount());               
                stmt.setString(5, payment.getStaff().getSID());
                stmt.setString(6, payment.getPDate());
                stmt.executeUpdate();
                
        } 
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public String getlastrecord(){
          String number="";
           try {
            stmt = conn.prepareStatement("SELECT * FROM Payment", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmt.executeQuery();
            rs.last();
            number = rs.getString(1);
            
           } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
           return number;
           
    }
    
    public String[] getPPurchaseID() {
        int count=0;
        String[] NOB={};
        try {
              
            stmt = conn.prepareStatement("SELECT * FROM Payment");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                count++;
            }
            NOB = new String[count];
            ResultSet rs1 = stmt.executeQuery();
            int x=0;
            while(rs1.next()){
                NOB[x] = rs1.getString(2);
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
        PaymentDA da = new PaymentDA();
    }
    
}
