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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;
public class Receipt extends javax.swing.JFrame {
private ControlPayment PaymentC = new ControlPayment();
    public Receipt(String paymentid) {
        initComponents();
        setLocationRelativeTo(null);
        Payment payment = PaymentC.selectRecord(paymentid);
        Paymentid.setText(payment.getPaymentID());
        Purchaseid.setText(payment.getPurchaseID().getPurchaseID());
        Memberid.setText(payment.getPurchaseID().getMember().getMID());
        Insuranceid.setText(payment.getPurchaseID().getInsurance().getInsuranceID());
        Date.setText(payment.getPurchaseID().getSchedule().getDate1());
        Time.setText(payment.getPurchaseID().getSchedule().getTime1());
        Seatno.setText(payment.getPurchaseID().getSeatID());
        Price.setText(String.format("RM %.2f",payment.getPurchaseID().getSchedule().getPrice()));
        String des = payment.getPurchaseID().getSchedule().getStartingPoint()+" - "+payment.getPurchaseID().getSchedule().getDestination();
        Destination.setText(des);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel11 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        Memberid = new javax.swing.JLabel();
        Insuranceid = new javax.swing.JLabel();
        Destination = new javax.swing.JLabel();
        Purchaseid = new javax.swing.JLabel();
        Date = new javax.swing.JLabel();
        Time = new javax.swing.JLabel();
        Seatno = new javax.swing.JLabel();
        Price = new javax.swing.JLabel();
        Paymentid = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        jLabel11.setText("jLabel11");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximizedBounds(new java.awt.Rectangle(0, 0, 750, 390));
        setMaximumSize(new java.awt.Dimension(750, 390));
        setMinimumSize(new java.awt.Dimension(750, 390));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(750, 390));
        getContentPane().setLayout(null);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setText("Time : ");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(380, 190, 60, 30);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel3.setText("Purchase ID : ");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(380, 130, 150, 30);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel4.setText("Payment ID    : ");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(90, 130, 140, 30);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel5.setText("Destination     : ");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(90, 270, 140, 30);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel6.setText("Price : ");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(380, 240, 80, 30);

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel7.setText("Member ID     : ");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(90, 160, 140, 30);

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel8.setText("Insurance ID   : ");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(90, 190, 140, 30);

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel9.setText("Date : ");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(380, 160, 70, 30);

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel10.setText("Seat NO          :");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(90, 240, 150, 30);

        Memberid.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        getContentPane().add(Memberid);
        Memberid.setBounds(220, 160, 120, 30);

        Insuranceid.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        getContentPane().add(Insuranceid);
        Insuranceid.setBounds(220, 190, 120, 30);

        Destination.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        getContentPane().add(Destination);
        Destination.setBounds(220, 270, 320, 30);

        Purchaseid.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        getContentPane().add(Purchaseid);
        Purchaseid.setBounds(500, 130, 120, 30);

        Date.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        getContentPane().add(Date);
        Date.setBounds(430, 160, 120, 30);

        Time.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        getContentPane().add(Time);
        Time.setBounds(430, 190, 120, 30);

        Seatno.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        getContentPane().add(Seatno);
        Seatno.setBounds(220, 240, 120, 30);

        Price.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        getContentPane().add(Price);
        Price.setBounds(440, 240, 120, 30);

        Paymentid.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        getContentPane().add(Paymentid);
        Paymentid.setBounds(220, 130, 120, 30);

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/CloseTicket.fw.png"))); // NOI18N
        jButton7.setBorder(null);
        jButton7.setContentAreaFilled(false);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton7);
        jButton7.setBounds(660, 10, 80, 70);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/FinalTicket.fw.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 750, 351);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
       dispose();
    }//GEN-LAST:event_jButton7ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Receipt("T0001").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Date;
    private javax.swing.JLabel Destination;
    private javax.swing.JLabel Insuranceid;
    private javax.swing.JLabel Memberid;
    private javax.swing.JLabel Paymentid;
    private javax.swing.JLabel Price;
    private javax.swing.JLabel Purchaseid;
    private javax.swing.JLabel Seatno;
    private javax.swing.JLabel Time;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
}
