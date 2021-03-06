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
public class PaymentReceipt extends javax.swing.JFrame {
    
    private ControlPayment PaymentC = new ControlPayment();
    public PaymentReceipt(String paymentid1) {
        initComponents();
        setLocationRelativeTo(null);
        Payment payment = PaymentC.selectRecord(paymentid1);
        paymentid.setText(payment.getPaymentID());
        purchaseid.setText(payment.getPurchaseID().getPurchaseID());
        memberid.setText(payment.getPurchaseID().getMember().getMID());
        staffid.setText(payment.getPurchaseID().getStaff().getSID());
        ticketprice.setText(String.format("RM %.2f", payment.getPurchaseID().getSchedule().getPrice()));
        insuranceprice.setText(String.format("RM %.2f", payment.getPurchaseID().getInsurance().getPrice()));
        double abc=payment.getPurchaseID().getSchedule().getPrice()+payment.getPurchaseID().getInsurance().getPrice();
        subtotal.setText(String.format("RM %.2f", abc));
        gst.setText(String.format("RM %.2f", abc*0.06));
        double ppoo = abc*1.06;
        total.setText(String.format("RM %.2f", Math.ceil(ppoo*10)/10));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        paymentid = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        purchaseid = new javax.swing.JLabel();
        staffid = new javax.swing.JLabel();
        memberid = new javax.swing.JLabel();
        ticketprice = new javax.swing.JLabel();
        insuranceprice = new javax.swing.JLabel();
        subtotal = new javax.swing.JLabel();
        gst = new javax.swing.JLabel();
        total = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximizedBounds(new java.awt.Rectangle(0, 0, 500, 650));
        setMaximumSize(new java.awt.Dimension(500, 650));
        setMinimumSize(new java.awt.Dimension(530, 700));
        setUndecorated(true);
        getContentPane().setLayout(null);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Purchase ID : ");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(30, 230, 220, 30);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Receptionist ID : ");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(30, 270, 220, 30);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Member ID : ");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(30, 310, 220, 30);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Ticket Price : ");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(30, 350, 220, 30);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Insurance Price : ");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(30, 390, 220, 30);

        jLabel7.setFont(new java.awt.Font("Times New Roman", 2, 24)); // NOI18N
        jLabel7.setText("Signature : _______");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(50, 530, 230, 120);

        paymentid.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        paymentid.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(paymentid);
        paymentid.setBounds(240, 190, 220, 30);

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("GST (6%) : ");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(30, 470, 220, 30);

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Total : ");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(30, 510, 220, 30);

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Sub Total : ");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(30, 430, 220, 30);

        purchaseid.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        purchaseid.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(purchaseid);
        purchaseid.setBounds(240, 230, 220, 30);

        staffid.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        staffid.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(staffid);
        staffid.setBounds(240, 270, 220, 30);

        memberid.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        memberid.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(memberid);
        memberid.setBounds(240, 310, 220, 30);

        ticketprice.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ticketprice.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(ticketprice);
        ticketprice.setBounds(240, 350, 220, 30);

        insuranceprice.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        insuranceprice.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(insuranceprice);
        insuranceprice.setBounds(240, 390, 220, 30);

        subtotal.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        subtotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(subtotal);
        subtotal.setBounds(240, 430, 220, 30);

        gst.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        gst.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(gst);
        gst.setBounds(240, 470, 220, 30);

        total.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        total.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        total.setText("Payment ID : ");
        getContentPane().add(total);
        total.setBounds(240, 510, 220, 30);

        jLabel20.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Payment ID : ");
        getContentPane().add(jLabel20);
        jLabel20.setBounds(30, 190, 220, 30);

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/CloseTicket.fw.png"))); // NOI18N
        jButton7.setBorder(null);
        jButton7.setContentAreaFilled(false);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton7);
        jButton7.setBounds(380, 10, 80, 70);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/FinalRecept.fw.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 500, 650);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton7ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PaymentReceipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PaymentReceipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PaymentReceipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PaymentReceipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PaymentReceipt("T0001").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel gst;
    private javax.swing.JLabel insuranceprice;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel memberid;
    private javax.swing.JLabel paymentid;
    private javax.swing.JLabel purchaseid;
    private javax.swing.JLabel staffid;
    private javax.swing.JLabel subtotal;
    private javax.swing.JLabel ticketprice;
    private javax.swing.JLabel total;
    // End of variables declaration//GEN-END:variables
}
