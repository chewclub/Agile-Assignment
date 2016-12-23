package ui;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import javax.swing.border.*;
import control.ControlStaff;
import da.StaffDA;
import domain.Staff;
//import javafx.scene.layout.Border;

public class LoginPage extends JFrame{

    ImageIcon a = new ImageIcon(getClass().getResource("/images/busBG.png"));
    ImageIcon greenIcon = new ImageIcon(getClass().getResource("/images/Doraemon_logo1.fw.png"));
    ImageIcon q = new ImageIcon(getClass().getResource("/images/exit.fw.png"));
    private JButton Quit = new JButton(q);
    ImageIcon q2 = new ImageIcon(getClass().getResource("/images/exitIcon.fw.png"));
    private JButton Quit1 = new JButton(q2);
    
    private JLabel jlbl = new JLabel(greenIcon);
    private JLabel jlblID = new JLabel("                       Staff ID         ", JLabel.CENTER);
    private JTextField jtfID = new JTextField(20);
    private JLabel jlblPw = new JLabel("                        Password    ", JLabel.CENTER);
    private JPasswordField jtfPw = new JPasswordField(20);
    private JButton jbtLogin = new JButton("Login");
    private JButton jbtReset = new JButton("Reset");
    private JButton jbtForget = new JButton("Forget Password?");
    Staff stfStaff = new Staff();

    public void action(){
        String staffId =jtfID.getText();
                    String staffPass =jtfPw.getText();

                    ControlStaff staff = new ControlStaff();
                    Staff stf = staff.selectRecord(staffId);
        
                    try{
                            if(staffId.equals(stf.getSID())&& staffPass.equals(stf.getSPassword())){
                                    if(stf.getSPosition().equals("Manager")){
                                            JOptionPane.showMessageDialog(null,"Login successfully ! Welcome, Manager  "+ stf.getSName());
                                            new mainMenu(stf);
                                            setVisible(false);
                                    }
                                    if(stf.getSPosition().equals("Clerk")){
                                            JOptionPane.showMessageDialog(null,"Login successfully ! Welcome, " + stf.getSPosition()+","+ stf.getSName());
                                            //dispose();
                                            new mainMenu(stf);
                                            setVisible(false);
                                            
                                    }
                                    if(stf.getSPosition().equals("Receptionist")){
                                            JOptionPane.showMessageDialog(null,"Login successfully ! Welcome, " + stf.getSPosition()+","+ stf.getSName());
                                            //dispose();
                                            new mainMenu(stf);
                                            setVisible(false);
                                    }
                                    if(stf.getSPosition().equals("Driver")){
                                            JOptionPane.showMessageDialog(null,"Login successfully ! Welcome, " + stf.getSPosition()+","+ stf.getSName());
                                            //dispose();
                                            new mainMenu(stf);
                                            setVisible(false);
                                    } 
                            }
                            else{
                                        JOptionPane.showMessageDialog(null, "Invalid Password , Please Retry !" , "Error" , JOptionPane.ERROR_MESSAGE);
                                        jtfPw.setText("");
                            }
                            }catch(NullPointerException ex){
                                    JOptionPane.showMessageDialog(null,"   Invalid ID or Password !  ", "Error Enter" , JOptionPane.ERROR_MESSAGE);
                                    jtfID.setText("");
                                    jtfPw.setText("");
                            }
                    
}
    
    public LoginPage(){
        
        setTitle("Login");
        setContentPane(new JLabel(a));
        setLayout(new FlowLayout());
        
        JPanel p2 = new JPanel(new GridLayout(1,10)); 
        p2.setOpaque(false);
        p2.add(new JLabel(""));
        p2.add(new JLabel(""));
        p2.add(new JLabel(""));
        p2.add(new JLabel(""));
        p2.add(new JLabel(""));
        p2.add(new JLabel(""));
        p2.add(new JLabel(""));
        p2.add(new JLabel(""));
        p2.add(new JLabel(""));
        p2.add(new JLabel(""));
        p2.add(Quit);
        Quit.addActionListener(new quit());
        Quit.setContentAreaFilled(false);
        Quit.setRolloverIcon(q2);
        Quit.setBorder(null);
        add(p2, BorderLayout.NORTH);
        
        JPanel panel1 = new JPanel();
        panel1.add(jlbl);
        panel1.setOpaque(false);
        add(panel1);
        
        JPanel panel2 = new JPanel(new GridLayout(5,2));
        panel2.add(new JLabel(""));
        panel2.add(new JLabel(""));
        panel2.add(jlblID);
                    jlblID.setForeground(Color.black);
        panel2.add(jtfID);
        panel2.add(new JLabel(""));
        panel2.add(new JLabel(""));
        panel2.add(jlblPw);
                    jlblPw.setForeground(Color.black);
        panel2.add(jtfPw);
        jtfPw.addActionListener(new ActionListener(){
                            public void actionPerformed(ActionEvent e){
                                    action();
                            }});
        panel2.add(new JLabel(""));
        panel2.add(new JLabel(""));
        panel2.setOpaque(false);
        add(panel2);
        
        JPanel panel3 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panel3.add(jbtLogin);
        panel3.add(jbtForget);
        panel3.add(jbtReset);
        panel3.setOpaque(false);
        add(panel3);
        
        JPanel BigPanel = new JPanel(new GridLayout(4,2));
        BigPanel.add(new JLabel(""));
        BigPanel.add(panel1);
        BigPanel.add(panel2);
        BigPanel.add(panel3);
        BigPanel.setOpaque(false);
        add(BigPanel);
        
        jbtLogin.addActionListener(new ButtonClass());
        jbtReset.addActionListener(new ButtonClass());
        jbtForget.addActionListener(new ButtonClass());
        
        setSize(1279,780);
        setLocationRelativeTo(null);
        setUndecorated(true);
        setVisible(true);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/v.png")));
        
        jbtLogin.setMnemonic('L');
        jbtReset.setMnemonic('R');
        jbtForget.setMnemonic('F');
    }

    public class ButtonClass implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            if(e.getSource()==jbtLogin) 
            {
                    action();
            }
            else if(e.getSource()==jbtReset)
            {
                jtfID.setText("");
                jtfPw.setText("");
            }
            else if(e.getSource()==jbtForget){
                String staffId =jtfID.getText();
        
                ControlStaff staff = new ControlStaff();
                Staff stf = staff.selectRecord(staffId);
        
                try{
                        if(staffId.equals(stf.getSID())){
          
                        String inputname = JOptionPane.showInputDialog("Please enter your name for verification");
                        if(inputname.equals(stf.getSName())){
                             String name =stf.getSName();
                             String post =stf.getSPosition();
                             String gender =stf.getSGender();
                             int contact =stf.getSContact();
                             String pass =JOptionPane.showInputDialog("Hi "+ stf.getSName() + "  Please set new password :");
             
                            Staff employee = new Staff(staffId,name,pass,gender,post,contact);
                            staff.updateRecord(employee);
                            JOptionPane.showMessageDialog(null, "Thank you , Password successfully Changed");  
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "Wrong name compare with ID");
                        }
                        }
            
                }catch(NullPointerException ex){
                        JOptionPane.showMessageDialog(null,"Invalid ID !");     
                }
            }
        }
    }
 
    private class quit implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
             setVisible(false);
             System.exit(0);
        }
}
    
    public static void main(String[] args) {
        new LoginPage();
    }
    
}
