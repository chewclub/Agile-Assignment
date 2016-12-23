package da;

import domain.Member;
import javax.swing.table.AbstractTableModel;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class MemberTable extends AbstractTableModel{
    private String host = "jdbc:derby://localhost:1527/FYPDB";
    private String user = "nbuser";
    private String password = "nbuser";
    private String tableName = "MEMBER";
    private JTable jtable = new JTable();
    private String query = "SELECT * FROM "+tableName;
    private Connection conn;
    private Statement stmt;
    private ResultSet rs;
    private MemberTable tableModel;
    private ResultSetMetaData metaData;
    private int numberOfRows;
    private boolean connectedToDatabase = false;
    
    
    public MemberTable() throws SQLException{
        connect();
        connectedToDatabase = true;
        setQuery(query);
    }
    
    public void connect(){
        try {
            conn = DriverManager.getConnection(host, user, password);
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        };
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

/*package da;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import da.StaffDA;
import javax.swing.border.TitledBorder;
import da.AllTableModel;
import java.util.regex.PatternSyntaxException;

public class MemberTable extends JFrame{

    static final String DATABASE_URL = "jdbc:derby://localhost:1527/BusSystem";
    static final String USERNAME = "nbuser";
    static final String PASSWORD = "nbuser";
    static final String DEFAULT = "SELECT * FROM STAFF";
    private AllTableModel tableModel;
    private JTable resultTable;
    private TableRowSorter<TableModel> sorter;
    
    private JTextField filterText = new JTextField(95);
    private JButton Read = new JButton("Read Staff ID");
    private JButton Reset = new JButton("Reset");
    private JButton Back = new JButton("Back");
    
    
    public MemberTable(){
        tableModel = new AllTableModel(DATABASE_URL, USERNAME, PASSWORD,DEFAULT);
        resultTable = new JTable(tableModel);
        JPanel r = new JPanel(new FlowLayout());
        r.setBorder(new TitledBorder("Staff Information"));
        r.add(filterText);
        r.add(Read);
        r.add(Reset);
        add(r,BorderLayout.NORTH);
        Read.addActionListener(new ReadListener());
        filterText.addActionListener(new searchFunction());
        Reset.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                filterText.setText("");
                tableModel.setQuery(DEFAULT);
            }
        });
        Back.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                setVisible(false);
            }
        });
        add(new JScrollPane(resultTable), BorderLayout.CENTER);
        sorter = new TableRowSorter<TableModel>(tableModel);
        resultTable.setRowSorter(sorter);
        addWindowListener(new WindowCloseListener());
        JPanel backButton = new JPanel();
        backButton.add(Back);
        add(backButton, BorderLayout.SOUTH);
        
        setTitle("Staff Information");
        setSize(1300,200);
        setLocationRelativeTo(null);
        setUndecorated(true);
        //setExtendedState(JFrame.MAXIMIZED_BOTH); 
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/v.png")));
    }
    
    private class ReadListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
       try{ 
            
            
            String query=DEFAULT;
            String a = (filterText.getText());
             a.toUpperCase();
            if(!filterText.getText().equals(""))
            query = "SELECT * FROM STAFF WHERE StaffID= '"+filterText.getText()+ "'";
            
            
            
            tableModel.setQuery(query);
       }catch(IllegalArgumentException ex){
                    if(filterText.getText().equals(""))
                    {
                        JOptionPane.showMessageDialog(null, "Staff ID can't be empty !", "INVALID TYPE", JOptionPane.ERROR_MESSAGE);
                        filterText.setText("");
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "ID Does Not Exits", "ID NOT FOUND", JOptionPane.ERROR_MESSAGE);
                        filterText.setText("");
                    }
       }
    }
    }
    private class searchFunction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String text = filterText.getText();
            if (text.length() == 0) {
                sorter.setRowFilter(null);
            } else {
                try {
                    sorter.setRowFilter(RowFilter.regexFilter(text));
                } catch (PatternSyntaxException pse) {
                    JOptionPane.showMessageDialog(null, "Bad regex pattern", "Bad regex pattern", JOptionPane.ERROR_MESSAGE);
                }
                
            }
        }
    }
     
    private class WindowCloseListener extends WindowAdapter {

        @Override
        public void windowClosed(WindowEvent event) {
            tableModel.disconnectFromDatabase();
            System.exit(0);
        }
    }
    public static void main(String[] args) {
        new MemberTable();
    }
}

/*import java.sql.*;
import javax.swing.table.AbstractTableModel;

public class ResultSetTableModel extends AbstractTableModel {

    private Connection conn;
    private Statement stmt;
    private ResultSet rs;
    private ResultSetMetaData metaData;
    private int numberOfRows;
    private boolean connectedToDatabase = false;

    public ResultSetTableModel(String url, String username, String password, 
            String query) throws SQLException {
        conn = DriverManager.getConnection(url, username, password);
        stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, 
                ResultSet.CONCUR_READ_ONLY);
        connectedToDatabase = true;
        setQuery(query);
    }

    public Class getColumnClass(int column) throws IllegalStateException {
        if (!connectedToDatabase) {
            throw new IllegalStateException("Not Connected to Database");
        }

        try {
            String className = metaData.getColumnClassName(column + 1);
            return Class.forName(className);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return Object.class;
    }

    @Override
    public int getColumnCount() {
        if (!connectedToDatabase) {
            throw new IllegalStateException("Not Connected to Database");
        }

        try {
            return metaData.getColumnCount();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    public String getColumnName(int column) throws IllegalStateException {
        if (!connectedToDatabase) {
            throw new IllegalStateException("Not Connected to Database");
        }

        try {
            return metaData.getColumnName(column + 1);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return "";
    }

    @Override
    public int getRowCount() {
        if (!connectedToDatabase) {
            throw new IllegalStateException("Not Connected to Database");
        }

        return numberOfRows;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) 
            throws IllegalStateException {
        if (!connectedToDatabase) {
            throw new IllegalStateException("Not Connected to Database");
        }

        try {
            rs.absolute(rowIndex + 1);
            return rs.getObject(columnIndex + 1);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return "";
    }

    public void setQuery(String query) 
            throws IllegalStateException, SQLException {
        if (!connectedToDatabase) {
            throw new IllegalStateException("Not Connected to Database");
        }

        rs = stmt.executeQuery(query);
        metaData = rs.getMetaData();

        // determine number of rows in ResultSet
        rs.last();                      // move to last row
        numberOfRows = rs.getRow();     // get row number
        
        // notify JTable that model has changed
        fireTableStructureChanged();    
    }

    public void disconnectFromDatabase() {
        if (connectedToDatabase) {
            try {
                rs.close();
                stmt.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            } finally {
                connectedToDatabase = false;
            }
        }
    }
}*/
