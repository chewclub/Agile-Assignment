package ui;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import javax.swing.border.*;
import control.*;
import da.*;
import domain.*;

public class mainMenu extends JFrame{
    
    ImageIcon a = new ImageIcon(getClass().getResource("/images/busBG.png"));
    
    ImageIcon q = new ImageIcon(getClass().getResource("/images/logouticon.png"));
    private JButton Quit = new JButton(q);
    ImageIcon q2 = new ImageIcon(getClass().getResource("/images/logouticon2.png"));
    private JButton Quit1 = new JButton(q2);
    ImageIcon hlp = new ImageIcon(getClass().getResource("/images/help.png"));
    private JButton Help = new JButton(hlp);
    ImageIcon hlp2 = new ImageIcon(getClass().getResource("/images/help.fw.png"));
    private JButton Help2 = new JButton(hlp2);
    
    ImageIcon staff = new ImageIcon(getClass().getResource("/images/staff.png"));
    private JButton stf = new JButton("Staff",staff);
    ImageIcon staff1 = new ImageIcon(getClass().getResource("/images/staff2.fw.png"));
    private JButton stf1 = new JButton("Staff",staff1);
    
    
    ImageIcon member = new ImageIcon(getClass().getResource("/images/member.png"));
    private JButton mbr = new JButton("Member",member);
    ImageIcon member1 = new ImageIcon(getClass().getResource("/images/member2.fw.png"));
    private JButton mbr1 = new JButton("Member",member1);
    
    ImageIcon bus = new ImageIcon(getClass().getResource("/images/bus.png"));
    private JButton bs = new JButton("Bus",bus);
    ImageIcon bus1 = new ImageIcon(getClass().getResource("/images/bus2.fw.png"));
    private JButton bs1 = new JButton("Bus",bus1);
    
    ImageIcon ticket = new ImageIcon(getClass().getResource("/images/ticket.png"));
    private JButton tct = new JButton("Ticket",ticket);
    ImageIcon ticket1 = new ImageIcon(getClass().getResource("/images/ticket2.fw.png"));
    private JButton tct1 = new JButton("Ticket",ticket1);
    
    ImageIcon payment = new ImageIcon(getClass().getResource("/images/payment.png"));
    private JButton pyt = new JButton("Payment",payment);
    ImageIcon payment1 = new ImageIcon(getClass().getResource("/images/payment2.fw.png"));
    private JButton pyt1 = new JButton("Payment",payment1);
    
    ImageIcon schedule = new ImageIcon(getClass().getResource("/images/schedule.png"));
    private JButton scd = new JButton("Schedule",schedule);
    ImageIcon schedule1 = new ImageIcon(getClass().getResource("/images/schedule2.fw.png"));
    private JButton scd1 = new JButton("Schedule",schedule1);
    
    ImageIcon report = new ImageIcon(getClass().getResource("/images/report.png"));
    private JButton rpt = new JButton("Report",report);
    ImageIcon report1 = new ImageIcon(getClass().getResource("/images/report2.fw.png"));
    private JButton rpt1 = new JButton("Report",report1);
    
    ImageIcon insurance = new ImageIcon(getClass().getResource("/images/insurance.png"));
    private JButton ins = new JButton("Insurance",insurance);
    ImageIcon insurance1 = new ImageIcon(getClass().getResource("/images/insurance2.fw.png"));
    private JButton ins1 = new JButton("Insurance",insurance1);
    Staff stfStaff = new Staff();
    
public mainMenu(Staff stfStaff) {
        this.stfStaff = stfStaff;
        //ControlStaff staff = new ControlStaff();
        //Staff staff = staff.getSPosition();
        if(stfStaff.getSPosition().equals("Manager")){
            stf.setEnabled(true);
            mbr.setEnabled(true);
            bs.setEnabled(true);
            scd.setEnabled(true);
            tct.setEnabled(true);
            ins.setEnabled(true);
            pyt.setEnabled(true);
            rpt.setEnabled(true);
        }
        if(stfStaff.getSPosition().equals("Driver")){
            stf.setEnabled(false);
            mbr.setEnabled(false);
            bs.setEnabled(false);
            scd.setEnabled(true);
            tct.setEnabled(false);
            ins.setEnabled(false);
            pyt.setEnabled(false);
            rpt.setEnabled(false);
        }
        if(stfStaff.getSPosition().equals("Receptionist")){
            stf.setEnabled(false);
            mbr.setEnabled(false);
            bs.setEnabled(false);
            scd.setEnabled(false);
            tct.setEnabled(true);
            ins.setEnabled(false);
            pyt.setEnabled(true);
            rpt.setEnabled(false);
        }
        if(stfStaff.getSPosition().equals("Clerk")){
            stf.setEnabled(true);
            mbr.setEnabled(true);
            bs.setEnabled(true);
            scd.setEnabled(true);
            tct.setEnabled(false);
            ins.setEnabled(true);
            pyt.setEnabled(false);
            rpt.setEnabled(false);
        }
    
        setTitle("Main Menu");
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
        p2.add(Help);
        Help.addActionListener(new help());
        Help.setContentAreaFilled(false);
        Help.setRolloverIcon(hlp2);
        Help.setBorder(null);
        p2.add(Quit);
        Quit.addActionListener(new quit());
        Quit.setContentAreaFilled(false);
        Quit.setRolloverIcon(q2);
        Quit.setBorder(null);
        add(p2, BorderLayout.NORTH);
        
        
        JPanel p = new JPanel(new GridLayout(2,3));
         //p.setLayout(new FlowLayout(FlowLayout.LEFT,80,250));
         p.setOpaque(false);
         p.add(stf);
         stf.setMnemonic('S');
         p.add(mbr);
         mbr.setMnemonic('M');
         p.add(bs);
         bs.setMnemonic('B');
         p.add(scd);
         scd.setMnemonic('C');
         p.add(tct);
         tct.setMnemonic('T');
         p.add(ins);
         ins.setMnemonic('I');
         p.add(pyt);
         pyt.setMnemonic('P');
         p.add(rpt);
         rpt.setMnemonic('E');
         add(p, BorderLayout.CENTER);
         
    stf.setHorizontalTextPosition(SwingConstants.CENTER);
    stf.setVerticalTextPosition(SwingConstants.BOTTOM);
    mbr.setHorizontalTextPosition(SwingConstants.CENTER);
    mbr.setVerticalTextPosition(SwingConstants.BOTTOM);
    bs.setHorizontalTextPosition(SwingConstants.CENTER);
    bs.setVerticalTextPosition(SwingConstants.BOTTOM);
    tct.setHorizontalTextPosition(SwingConstants.CENTER);
    tct.setVerticalTextPosition(SwingConstants.BOTTOM);
    pyt.setHorizontalTextPosition(SwingConstants.CENTER);
    pyt.setVerticalTextPosition(SwingConstants.BOTTOM);
    scd.setHorizontalTextPosition(SwingConstants.CENTER);
    scd.setVerticalTextPosition(SwingConstants.BOTTOM);
    rpt.setHorizontalTextPosition(SwingConstants.CENTER);
    rpt.setVerticalTextPosition(SwingConstants.BOTTOM);
    ins.setHorizontalTextPosition(SwingConstants.CENTER);
    ins.setVerticalTextPosition(SwingConstants.BOTTOM);
    
    stf.setForeground(Color.black);
    mbr.setForeground(Color.black);
    bs.setForeground(Color.black);
    tct.setForeground(Color.black);
    pyt.setForeground(Color.black);
    scd.setForeground(Color.black);
    rpt.setForeground(Color.black);
    ins.setForeground(Color.black);
    //stf.setOpaque(false);
    stf.setContentAreaFilled(false);
    stf.setRolloverIcon(staff1);
    stf.setBorder(null);
    mbr.setContentAreaFilled(false);
    mbr.setRolloverIcon(member1);
    mbr.setBorder(null);
    bs.setContentAreaFilled(false);
    bs.setRolloverIcon(bus1);
    bs.setBorder(null);
    tct.setContentAreaFilled(false);
    tct.setRolloverIcon(ticket1);
    tct.setBorder(null);
    pyt.setContentAreaFilled(false);
    pyt.setRolloverIcon(payment1);
    pyt.setBorder(null);
    scd.setContentAreaFilled(false);
    scd.setRolloverIcon(schedule1);
    scd.setBorder(null);
    rpt.setContentAreaFilled(false);
    rpt.setRolloverIcon(report1);
    rpt.setBorder(null);
    ins.setContentAreaFilled(false);
    ins.setRolloverIcon(insurance1);
    ins.setBorder(null);    
    
    stf.addActionListener(new staffMenu());
    mbr.addActionListener(new memberMenu());
    bs.addActionListener(new busMenu());        
    tct.addActionListener(new ticketMenu());
    pyt.addActionListener(new goPayment());
    scd.addActionListener(new ScheduleMenu());

    ins.addActionListener(new insMenu());
    
    setSize(1279,780);
    setLocationRelativeTo(null);
    setUndecorated(true);
    setVisible(true);
    setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/v.png")));

}

private class staffMenu implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            new ManageStaff().setVisible(true);
        }
}

private class memberMenu implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            new ManageMember().setVisible(true);
        }
}
private class busMenu implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            new BusUI().setVisible(true); 
        }
}



private class ticketMenu implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            new TicketUI().setVisible(true); 
        }
}

private class ScheduleMenu implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            new ScheduleUI().setVisible(true); 
        }
}

 private class goPayment implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            new PaymentUI().setVisible(true); 
        }
}
 
private class insMenu implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            new ManageInsurance().setVisible(true); 
        }
}

private class help implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
             new HelpMenu().setVisible(true);
        }
}

private class quit implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
             setVisible(false);
             new LoginPage();
        }
}

    public static void main(String[] args) {
        //new mainMenu();
    }
}


