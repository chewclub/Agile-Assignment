package ui;

import control.*;
import domain.*;
import da.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class UpdateBus extends JFrame{
    private ControlBus BusC= new ControlBus();
    private ControlStaff StaffC= new ControlStaff();
     private String[] BusArray = BusC.getNoBus();
    ImageIcon Bus1 = new ImageIcon(getClass().getResource("/images/bus.png"));
    JButton[] BUTTON = new JButton[BusArray.length];
    Font Font1 = new Font("TimesRoman",Font.BOLD,40);
    private JComboBox combo1 = new JComboBox(BusArray);

        public UpdateBus(){
            setLocationRelativeTo(null);
        JPanel top = new JPanel();
        top.setLayout(new GridLayout(3, 4));

        for(int x=0;x<BusArray.length;x++){
            BUTTON[x]=new JButton("NO: "+BusArray[x],Bus1);
            BUTTON[x].setFont(Font1);
            BUTTON[x].setForeground(Color.BLACK);
            BUTTON[x].setVerticalAlignment(SwingConstants.BOTTOM);
            top.add(BUTTON[x]);
            
            BUTTON[x].addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
            for(int w=0;w<BUTTON.length;w++){
           if(e.getSource()==BUTTON[w]){
               
                 Bus bus = BusC.selectRecord(Integer.parseInt(BusArray[w]));
                 dispose();
                 new UpdateBus1(Integer.parseInt(BusArray[w]));
 
           }}}}
                    
            );
            
            add(top);


        }
            
        
        
        


        setTitle("Add Bus Table");
        setSize(1100,700);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/v.png")));
}
       
      public static void main(String[] args) {
        new UpdateBus();
    }
    
}

