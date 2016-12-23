package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import da.StaffDA;
import javax.swing.border.TitledBorder;
import da.ReadTableModel;

public class ReadBus extends JFrame{

    static final String DATABASE_URL = "jdbc:derby://localhost:1527/FYPDB";
    static final String USERNAME = "nbuser";
    static final String PASSWORD = "nbuser";
    static final String DEFAULT = "SELECT * FROM BUS";
    private ReadTableModel tableModel;
    private JTable resultTable;
    private TableRowSorter<TableModel> sorter;
    
    private JTextField filterText = new JTextField(95);
    private JButton Read = new JButton("Read Bus NO");
    private JButton Reset = new JButton("Reset");
    private JButton Back = new JButton("Back");
    
    
    public ReadBus(){
        setLocationRelativeTo(null);
        try {
            tableModel = new ReadTableModel(DATABASE_URL, USERNAME, PASSWORD,DEFAULT);
            resultTable = new JTable(tableModel);
            
            JPanel r = new JPanel(new FlowLayout());
            r.setBorder(new TitledBorder("Bus Information"));
            r.add(filterText);
            r.add(Read);
            r.add(Reset);
            
            add(r,BorderLayout.NORTH);
                filterText.addActionListener(new ReadListener());
                Read.addActionListener(new ReadListener());
            
            Reset.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                filterText.setText("");
                try{
                tableModel.setQuery(DEFAULT);
                }catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Database Error1", JOptionPane.ERROR_MESSAGE);
                }
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
            // ensure database connection is closed when user quits application
            addWindowListener(new WindowCloseListener());
            
            JPanel backButton = new JPanel();
            backButton.add(Back);
            add(backButton, BorderLayout.SOUTH);
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
            tableModel.disconnectFromDatabase();
            System.exit(1);
        }
        
        setTitle("Bus Information");
        setSize(1300,200);
        setLocationRelativeTo(null);
        setUndecorated(true);
        //setExtendedState(JFrame.MAXIMIZED_BOTH); 
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/v.png")));
    }
    
    private class ReadListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            try{
                int i = Integer.parseInt(filterText.getText());
                
                String query=DEFAULT;
                    if(!filterText.getText().equals(""))
                    {
                        query = "SELECT * FROM BUS WHERE BUSNO= "+i;
                        try{
                            tableModel.setQuery(query);
                        } catch (SQLException ex) {
                            JOptionPane.showMessageDialog(null, ex.getMessage(), "Database Error1", JOptionPane.ERROR_MESSAGE);
                                try {
                                    tableModel.setQuery(DEFAULT);
                                    } 
                                catch (SQLException ex2) {
                                    JOptionPane.showMessageDialog(null, ex2.getMessage(), "Database Error2", JOptionPane.ERROR_MESSAGE);
                                    tableModel.disconnectFromDatabase();
                                    System.exit(1);
                                }
                        }   
                    }
                }catch(NumberFormatException ex){
                    if(filterText.getText().equals(""))
                    {
                        JOptionPane.showMessageDialog(null, "BUS NO can't be empty !", "INVALID BUS", JOptionPane.ERROR_MESSAGE);
                        filterText.setText("");
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Non-numeric operand(s)", "INVALID BUS", JOptionPane.ERROR_MESSAGE);
                        filterText.setText("");
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
        new ReadBus();
    }
}

