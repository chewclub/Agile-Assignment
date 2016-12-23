package da;

import domain.Insurance;
import javax.swing.table.AbstractTableModel;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class InsuranceTable extends AbstractTableModel{
    private String host = "jdbc:derby://localhost:1527/FYPDB";
    private String user = "nbuser";
    private String password = "nbuser";
    private String tableName = "INSURANCE";
    private JTable jtable = new JTable();
    private String query = "SELECT * FROM "+tableName;
    private Connection conn;
    private Statement stmt;
    private ResultSet rs;
    private InsuranceTable tableModel;
    private ResultSetMetaData metaData;
    private int numberOfRows;
    private boolean connectedToDatabase = false;
    
    
    public InsuranceTable() throws SQLException{
        connect();
        setQuery(query);
    }
    
    public void connect(){
        try {
            conn = DriverManager.getConnection(host, user, password);
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    public Class getColumnClass(int column){
        try {
            String className = metaData.getColumnClassName(column + 1);
            return Class.forName(className);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return Object.class;
    }

    public int getColumnCount() {
        try {
            return metaData.getColumnCount();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    public String getColumnName(int column){
        try {
            return metaData.getColumnName(column + 1);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return "";
    }

    public int getRowCount() {
        return numberOfRows;
    }

    public Object getValueAt(int rowIndex, int columnIndex){
        try {
            rs.absolute(rowIndex + 1);
            return rs.getObject(columnIndex + 1);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return "";
    }

    public void setQuery(String query) throws IllegalStateException, SQLException {
        rs = stmt.executeQuery(query);
        metaData = rs.getMetaData();
        rs.last();                      
        numberOfRows = rs.getRow();     
        fireTableStructureChanged();    
    }
    
  

}

