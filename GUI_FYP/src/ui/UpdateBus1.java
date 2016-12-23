package ui;

import control.*;
import domain.*;
import da.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class UpdateBus1 extends JFrame {

    private ControlBus BusC= new ControlBus();
    private ControlStaff StaffC= new ControlStaff();
    private JTextField FBusNO = new JTextField();
    private JTextField FPlateNumbes = new JTextField();
    private JTextField FDriverID = new JTextField();
    private JTextField FBusNO1 = new JTextField();
    private JTextField FPlateNumbes1 = new JTextField();
    private JButton jbtUpdate = new JButton("Update");
    private JButton jbtBack = new JButton("Back");
    private String[] DriverID = StaffC.getDriverID();
    private JComboBox DriverID1 = new JComboBox(DriverID);
    
    
    public UpdateBus1(int NO) {
        setLocationRelativeTo(null);
       Bus bus = BusC.selectRecord(NO);

        
        JPanel f = new JPanel(new GridLayout(3, 2));
        f.setBorder(new TitledBorder("Current Data"));
        f.add(new JLabel("BusNO"));
        f.add(FBusNO);
        FBusNO.setEditable(false);
        f.add(new JLabel("Driver ID"));
        f.add(FDriverID);
        FPlateNumbes.setEditable(false);
        f.add(new JLabel("Plate Number"));
        f.add(FPlateNumbes);
        FDriverID.setEditable(false);
       

        
       JPanel f1 = new JPanel(new GridLayout(3, 2));
        f1.setBorder(new TitledBorder("Update Data"));
        f1.add(new JLabel("BusNO"));
        f1.add(FBusNO1);
        f1.add(new JLabel("Driver ID"));
        f1.add(DriverID1);
        f1.add(new JLabel("Plate Number"));
        f1.add(FPlateNumbes1);
       
        JPanel all = new JPanel(new GridLayout(1,2));
        all.add(f);
        all.add(f1);
        add(all);
       JPanel jpSouth = new JPanel();
        jpSouth.add(jbtUpdate);
        jpSouth.add(jbtBack);
        add(jpSouth, BorderLayout.SOUTH);
       FBusNO.setText(String.format("%s",bus.getBusNo()));
       FPlateNumbes.setText(String.format("%s",bus.getBPlate()));
       FDriverID.setText(String.format("%s",bus.getStaff().getSID()));
       FBusNO1.setText(String.format("%s",bus.getBusNo()));
       FBusNO1.setEditable(false);
       DriverID1.setSelectedItem(FDriverID.getText());

        
        jbtUpdate.addActionListener(new UpdateListener());
        jbtBack.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                setVisible(false);
            }
        });
        
        setTitle("Update Bus");
        setUndecorated(true);
        setSize(800,200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/v.png")));
    }
    private class UpdateListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
           
            Bus bus = BusC.selectRecord(Integer.parseInt(FBusNO.getText()));
            if(FPlateNumbes1.getText().equals("")){
                FPlateNumbes1.setText(FPlateNumbes.getText());
            }
            
            
            if (bus != null) {
             int a = JOptionPane.showConfirmDialog(null,"Are you sure want to update the new information of bus??","conformation",JOptionPane.YES_NO_CANCEL_OPTION);
             if(a==JOptionPane.YES_OPTION){
                 int no = DriverID1.getSelectedIndex();
                 String no1 = DriverID[no];
                 Staff staff = StaffC.selectRecord(DriverID[no]);
                bus.setStaff(staff);
                bus.setBPlate(FPlateNumbes1.getText());
             
                BusC.updateRecord(bus);
                 
              JOptionPane.showMessageDialog(null, "New Bus Information updated");
              dispose();
             }
            } else {
                
               JOptionPane.showMessageDialog(null, "Bus ID are not exist","Food ID not found",JOptionPane.ERROR_MESSAGE);
             
            }
            
             
        }
    }

      
     
    public static void main(String[] args) {
        new UpdateBus1(5);
    }
}
