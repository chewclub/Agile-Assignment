package ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import control.*;
import domain.*;
import da.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AddBus extends JFrame {

    private JLabel LBusNO = new JLabel("Bus NO.");
    private JLabel LDriverID = new JLabel("Driver ID");
    private JLabel LNoS = new JLabel("Number of Seat");
    private JLabel LPlate = new JLabel("Plate Number");
    
    private JTextField TBusNO = new JTextField();    
    private JTextField TNoS = new JTextField("20");
    private JTextField TPlate = new JTextField();
    ImageIcon BusI = new ImageIcon(getClass().getResource("/images/bus.png"));
    private JLabel Bus1= new JLabel(BusI);
    
    
    private ControlBus BusC= new ControlBus();
    private ControlStaff StaffC= new ControlStaff();
    
    private String[] DriverID = StaffC.getDriverID();
    private JComboBox DriverID1 = new JComboBox(DriverID);
    
    private JButton Confirm = new JButton("Confirm");
    private JButton Clear = new JButton("Clear");
    private JButton Exit = new JButton("Exit");
    

    public AddBus() {
        setLocationRelativeTo(null);
        int l = BusC.getlast();
        l++;
        TBusNO.setText(String.format("%s",l));
        TBusNO.setEditable(false);
        TNoS.setEditable(false);
        JPanel top = new JPanel();
        top.setLayout(new GridLayout(3, 2));
        top.add(LBusNO);
        top.add(TBusNO);
        top.add(LNoS);
        top.add(TNoS);
        top.add(LPlate);
        top.add(TPlate);
        add(top, BorderLayout.NORTH);
        
        JPanel mid2 = new JPanel();
        mid2.setLayout(new GridLayout(5,1));
        mid2.add(LDriverID);
        mid2.add(DriverID1);
        add(mid2, BorderLayout.WEST);
        
        JPanel mid1 = new JPanel();
        mid1.add(Bus1);
        add(mid1, BorderLayout.EAST);
        

        
        JPanel bottom = new JPanel();
        bottom.setLayout(new GridLayout(1,3));
        bottom.add(Confirm);
        bottom.add(Clear);
        bottom.add(Exit);
        add(bottom, BorderLayout.SOUTH);
        
        Confirm.addActionListener(new Confirm());
        Clear.addActionListener(new Clear());
        Exit.addActionListener(new Exit());
        
        setUndecorated(true);
        setSize(300,350);
        setTitle("Check out system");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    
    private class Confirm implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e){
                int abc = DriverID1.getSelectedIndex();
                if(!TPlate.getText().matches("[A-Z a-z]+.[0-9]+")&&!TPlate.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Bus No format invalid. eg.ASD123");
                TPlate.setText("");}else{
                Staff staff = StaffC.selectRecord(DriverID[abc]);
                int w = Integer.parseInt(TBusNO.getText());
                    Bus bus = new Bus(w,20,staff,TPlate.getText());
                    BusC.addRecord(bus);
                    JOptionPane.showMessageDialog(null, "New Bus added");
                    setVisible(false);
                }
            }
        }
        
        
        private class Clear implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e){
                    TPlate.setText("");
                    DriverID1.setSelectedItem("S1001");
            }
        }
        
        private class Exit implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e){
                new BusMenu();
                setVisible(false);
            }
        }

    


    public static void main(String[] args) {
        AddBus frame = new AddBus();
    }
}