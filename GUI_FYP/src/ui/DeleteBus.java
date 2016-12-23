package ui;

import control.*;
import domain.*;
import da.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DeleteBus extends JFrame{
      private ControlBus BusC= new ControlBus();
    private ControlStaff StaffC= new ControlStaff();
     private String[] BusArray = BusC.getNoBus();
    ImageIcon Bus = new ImageIcon(getClass().getResource("/images/Deletebus.fw.png"));

    JButton[] BUTTON = new JButton[BusArray.length];
    Font Font1 = new Font("TimesRoman",Font.BOLD,40);
    private JComboBox combo1 = new JComboBox(BusArray);
    //private String[] seatplace;

        public DeleteBus(){
         setLocationRelativeTo(null);   
        JPanel top = new JPanel();
        top.setLayout(new GridLayout(3, 4));
        for(int x=0;x<BusArray.length;x++){
            BUTTON[x]=new JButton(BusArray[x],Bus);
            BUTTON[x].setFont(Font1);
            BUTTON[x].setForeground(Color.RED);
            BUTTON[x].setHorizontalTextPosition(SwingConstants.CENTER);
            top.add(BUTTON[x]);
            
            BUTTON[x].addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
            for(int w=0;w<BUTTON.length;w++){
           if(e.getSource()==BUTTON[w]){
               
                 int i = JOptionPane.showConfirmDialog(null, "Are you sure delete Bus?","Record Delete",JOptionPane.YES_NO_CANCEL_OPTION);
 
           if(i==0){
             Bus bus = new Bus(Integer.parseInt(BusArray[w]));
            
                
              BusC.deleteRecord(bus);
              dispose();
              setVisible(false);
             }}}}}
                    
            );
            
            add(top);


        }
            setTitle("Delete Seat Table");
            setSize(1100,700);
            setVisible(true);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
            setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/v.png")));
        }
       
      public static void main(String[] args) {
            new DeleteBus();
    }
    
}


