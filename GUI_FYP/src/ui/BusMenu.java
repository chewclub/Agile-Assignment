package ui;

import control.*;
import domain.*;
import da.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BusMenu extends JFrame{
    private ControlBus BusC= new ControlBus();
    private ControlStaff StaffC= new ControlStaff();
     private String[] BusArray = BusC.getNoBus();
    ImageIcon Bus = new ImageIcon(getClass().getResource("/images/bus.png"));
    ImageIcon ADD = new ImageIcon(getClass().getResource("/images/add.png"));
    JButton add = new JButton(ADD);
    JButton[] BUTTON = new JButton[BusArray.length];
    Font Font1 = new Font("TimesRoman",Font.BOLD,25);
    private JComboBox combo1 = new JComboBox(BusArray);

        public BusMenu(){
            setLocationRelativeTo(null);
        JPanel top = new JPanel();
        top.setLayout(new GridLayout(3, 4));

        for(int x=0;x<BusArray.length;x++){
            BUTTON[x]=new JButton(BusArray[x],Bus);
            BUTTON[x].setFont(Font1);
            BUTTON[x].setForeground(Color.BLACK);
            BUTTON[x].setVerticalAlignment(SwingConstants.BOTTOM);
            top.add(BUTTON[x]);
            };
            add(top);
            if(BusArray.length<12){
                top.add(add);
                add.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new AddBus();
                setVisible(false);
            }});
            }
        
        
        


        setUndecorated(false);
        setTitle("Add Bus Table");
        setSize(1100,700);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/v.png")));
}
       
      public static void main(String[] args) {
        new BusMenu();
    }
    
}

