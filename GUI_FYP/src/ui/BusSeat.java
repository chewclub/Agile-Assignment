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
public class BusSeat extends javax.swing.JFrame {

    private ControlSeat SeatC = new ControlSeat();
    public BusSeat(String seat1) {
        initComponents();
        setLocationRelativeTo(null);
        Seat seat = SeatC.selectRecord(seat1);
            if(seat.getS01().equals(false)){
                s1.setSelected(true);
                }
            if(seat.getS02().equals(false)){
                s2.setSelected(true);
                }
            if(seat.getS03().equals(false)){
                s3.setSelected(true);
                }
            if(seat.getS04().equals(false)){
                s4.setSelected(true);
                }
            if(seat.getS05().equals(false)){
                s5.setSelected(true);
                }
            if(seat.getS06().equals(false)){
                s6.setSelected(true);
                }
            if(seat.getS07().equals(false)){
                s7.setSelected(true);
                }
            if(seat.getS08().equals(false)){
                s8.setSelected(true);
                }
            if(seat.getS09().equals(false)){
                s9.setSelected(true);
                }
            if(seat.getS10().equals(false)){
                s10.setSelected(true);
                }
            if(seat.getS11().equals(false)){
                s11.setSelected(true);
                }
            if(seat.getS12().equals(false)){
                s12.setSelected(true);
                }
            if(seat.getS13().equals(false)){
                s13.setSelected(true);
                }
            if(seat.getS14().equals(false)){
                s14.setSelected(true);
                }
            if(seat.getS15().equals(false)){
                s15.setSelected(true);
                }
            if(seat.getS16().equals(false)){
                s16.setSelected(true);
                }
            if(seat.getS17().equals(false)){
                s17.setSelected(true);
                }
            if(seat.getS18().equals(false)){
                s18.setSelected(true);
                }
            if(seat.getS19().equals(false)){
                s19.setSelected(true);
                }
            if(seat.getS20().equals(false)){
                s20.setSelected(true);
                }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        s1 = new javax.swing.JToggleButton();
        s2 = new javax.swing.JToggleButton();
        s4 = new javax.swing.JToggleButton();
        s6 = new javax.swing.JToggleButton();
        s3 = new javax.swing.JToggleButton();
        s5 = new javax.swing.JToggleButton();
        s7 = new javax.swing.JToggleButton();
        s9 = new javax.swing.JToggleButton();
        s8 = new javax.swing.JToggleButton();
        s11 = new javax.swing.JToggleButton();
        s10 = new javax.swing.JToggleButton();
        s13 = new javax.swing.JToggleButton();
        s12 = new javax.swing.JToggleButton();
        s15 = new javax.swing.JToggleButton();
        s14 = new javax.swing.JToggleButton();
        s16 = new javax.swing.JToggleButton();
        s17 = new javax.swing.JToggleButton();
        s18 = new javax.swing.JToggleButton();
        s19 = new javax.swing.JToggleButton();
        s20 = new javax.swing.JToggleButton();
        jButton7 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(386, 530));
        setMinimumSize(new java.awt.Dimension(386, 550));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(386, 530));
        getContentPane().setLayout(null);

        s1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/blue.fw.png"))); // NOI18N
        s1.setBorder(null);
        s1.setBorderPainted(false);
        s1.setContentAreaFilled(false);
        s1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/red.fw.png"))); // NOI18N
        s1.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/red.fw.png"))); // NOI18N
        s1.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/red.fw.png"))); // NOI18N
        s1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s1ActionPerformed(evt);
            }
        });
        getContentPane().add(s1);
        s1.setBounds(120, 460, 50, 40);

        s2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/blue.fw.png"))); // NOI18N
        s2.setBorder(null);
        s2.setBorderPainted(false);
        s2.setContentAreaFilled(false);
        s2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/red.fw.png"))); // NOI18N
        s2.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/red.fw.png"))); // NOI18N
        s2.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/red.fw.png"))); // NOI18N
        s2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s2ActionPerformed(evt);
            }
        });
        getContentPane().add(s2);
        s2.setBounds(50, 410, 50, 40);

        s4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/blue.fw.png"))); // NOI18N
        s4.setBorder(null);
        s4.setBorderPainted(false);
        s4.setContentAreaFilled(false);
        s4.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/red.fw.png"))); // NOI18N
        s4.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/red.fw.png"))); // NOI18N
        s4.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/red.fw.png"))); // NOI18N
        s4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s4ActionPerformed(evt);
            }
        });
        getContentPane().add(s4);
        s4.setBounds(50, 360, 40, 40);

        s6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/blue.fw.png"))); // NOI18N
        s6.setBorder(null);
        s6.setBorderPainted(false);
        s6.setContentAreaFilled(false);
        s6.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/red.fw.png"))); // NOI18N
        s6.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/red.fw.png"))); // NOI18N
        s6.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/red.fw.png"))); // NOI18N
        s6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s6ActionPerformed(evt);
            }
        });
        getContentPane().add(s6);
        s6.setBounds(50, 320, 40, 40);

        s3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/blue.fw.png"))); // NOI18N
        s3.setBorder(null);
        s3.setBorderPainted(false);
        s3.setContentAreaFilled(false);
        s3.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/red.fw.png"))); // NOI18N
        s3.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/red.fw.png"))); // NOI18N
        s3.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/red.fw.png"))); // NOI18N
        s3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s3ActionPerformed(evt);
            }
        });
        getContentPane().add(s3);
        s3.setBounds(120, 410, 50, 40);

        s5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/blue.fw.png"))); // NOI18N
        s5.setBorder(null);
        s5.setBorderPainted(false);
        s5.setContentAreaFilled(false);
        s5.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/red.fw.png"))); // NOI18N
        s5.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/red.fw.png"))); // NOI18N
        s5.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/red.fw.png"))); // NOI18N
        s5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s5ActionPerformed(evt);
            }
        });
        getContentPane().add(s5);
        s5.setBounds(120, 370, 50, 40);

        s7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/blue.fw.png"))); // NOI18N
        s7.setBorder(null);
        s7.setBorderPainted(false);
        s7.setContentAreaFilled(false);
        s7.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/red.fw.png"))); // NOI18N
        s7.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/red.fw.png"))); // NOI18N
        s7.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/red.fw.png"))); // NOI18N
        s7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s7ActionPerformed(evt);
            }
        });
        getContentPane().add(s7);
        s7.setBounds(120, 320, 50, 40);

        s9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/blue.fw.png"))); // NOI18N
        s9.setBorder(null);
        s9.setBorderPainted(false);
        s9.setContentAreaFilled(false);
        s9.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/red.fw.png"))); // NOI18N
        s9.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/red.fw.png"))); // NOI18N
        s9.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/red.fw.png"))); // NOI18N
        s9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s9ActionPerformed(evt);
            }
        });
        getContentPane().add(s9);
        s9.setBounds(120, 280, 50, 40);

        s8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/blue.fw.png"))); // NOI18N
        s8.setBorder(null);
        s8.setBorderPainted(false);
        s8.setContentAreaFilled(false);
        s8.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/red.fw.png"))); // NOI18N
        s8.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/red.fw.png"))); // NOI18N
        s8.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/red.fw.png"))); // NOI18N
        s8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s8ActionPerformed(evt);
            }
        });
        getContentPane().add(s8);
        s8.setBounds(50, 280, 50, 40);

        s11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/blue.fw.png"))); // NOI18N
        s11.setBorder(null);
        s11.setBorderPainted(false);
        s11.setContentAreaFilled(false);
        s11.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/red.fw.png"))); // NOI18N
        s11.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/red.fw.png"))); // NOI18N
        s11.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/red.fw.png"))); // NOI18N
        s11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s11ActionPerformed(evt);
            }
        });
        getContentPane().add(s11);
        s11.setBounds(120, 240, 50, 40);

        s10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/blue.fw.png"))); // NOI18N
        s10.setBorder(null);
        s10.setBorderPainted(false);
        s10.setContentAreaFilled(false);
        s10.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/red.fw.png"))); // NOI18N
        s10.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/red.fw.png"))); // NOI18N
        s10.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/red.fw.png"))); // NOI18N
        s10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s10ActionPerformed(evt);
            }
        });
        getContentPane().add(s10);
        s10.setBounds(50, 230, 50, 40);

        s13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/blue.fw.png"))); // NOI18N
        s13.setBorder(null);
        s13.setBorderPainted(false);
        s13.setContentAreaFilled(false);
        s13.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/red.fw.png"))); // NOI18N
        s13.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/red.fw.png"))); // NOI18N
        s13.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/red.fw.png"))); // NOI18N
        s13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s13ActionPerformed(evt);
            }
        });
        getContentPane().add(s13);
        s13.setBounds(120, 190, 50, 40);

        s12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/blue.fw.png"))); // NOI18N
        s12.setBorder(null);
        s12.setBorderPainted(false);
        s12.setContentAreaFilled(false);
        s12.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/red.fw.png"))); // NOI18N
        s12.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/red.fw.png"))); // NOI18N
        s12.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/red.fw.png"))); // NOI18N
        s12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s12ActionPerformed(evt);
            }
        });
        getContentPane().add(s12);
        s12.setBounds(50, 190, 50, 40);

        s15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/blue.fw.png"))); // NOI18N
        s15.setBorder(null);
        s15.setBorderPainted(false);
        s15.setContentAreaFilled(false);
        s15.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/red.fw.png"))); // NOI18N
        s15.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/red.fw.png"))); // NOI18N
        s15.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/red.fw.png"))); // NOI18N
        s15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s15ActionPerformed(evt);
            }
        });
        getContentPane().add(s15);
        s15.setBounds(120, 150, 50, 40);

        s14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/blue.fw.png"))); // NOI18N
        s14.setBorder(null);
        s14.setBorderPainted(false);
        s14.setContentAreaFilled(false);
        s14.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/red.fw.png"))); // NOI18N
        s14.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/red.fw.png"))); // NOI18N
        s14.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/red.fw.png"))); // NOI18N
        s14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s14ActionPerformed(evt);
            }
        });
        getContentPane().add(s14);
        s14.setBounds(50, 140, 50, 40);

        s16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/blue.fw.png"))); // NOI18N
        s16.setBorder(null);
        s16.setBorderPainted(false);
        s16.setContentAreaFilled(false);
        s16.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/red.fw.png"))); // NOI18N
        s16.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/red.fw.png"))); // NOI18N
        s16.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/red.fw.png"))); // NOI18N
        s16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s16ActionPerformed(evt);
            }
        });
        getContentPane().add(s16);
        s16.setBounds(60, 100, 30, 40);

        s17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/blue.fw.png"))); // NOI18N
        s17.setBorder(null);
        s17.setBorderPainted(false);
        s17.setContentAreaFilled(false);
        s17.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/red.fw.png"))); // NOI18N
        s17.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/red.fw.png"))); // NOI18N
        s17.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/red.fw.png"))); // NOI18N
        s17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s17ActionPerformed(evt);
            }
        });
        getContentPane().add(s17);
        s17.setBounds(120, 100, 50, 40);

        s18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/blue.fw.png"))); // NOI18N
        s18.setBorder(null);
        s18.setBorderPainted(false);
        s18.setContentAreaFilled(false);
        s18.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/red.fw.png"))); // NOI18N
        s18.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/red.fw.png"))); // NOI18N
        s18.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/red.fw.png"))); // NOI18N
        s18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s18ActionPerformed(evt);
            }
        });
        getContentPane().add(s18);
        s18.setBounds(50, 60, 50, 40);

        s19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/blue.fw.png"))); // NOI18N
        s19.setBorder(null);
        s19.setBorderPainted(false);
        s19.setContentAreaFilled(false);
        s19.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/red.fw.png"))); // NOI18N
        s19.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/red.fw.png"))); // NOI18N
        s19.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/red.fw.png"))); // NOI18N
        s19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s19ActionPerformed(evt);
            }
        });
        getContentPane().add(s19);
        s19.setBounds(120, 60, 50, 40);

        s20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/blue.fw.png"))); // NOI18N
        s20.setBorder(null);
        s20.setBorderPainted(false);
        s20.setContentAreaFilled(false);
        s20.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/red.fw.png"))); // NOI18N
        s20.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/red.fw.png"))); // NOI18N
        s20.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/red.fw.png"))); // NOI18N
        s20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s20ActionPerformed(evt);
            }
        });
        getContentPane().add(s20);
        s20.setBounds(50, 10, 50, 40);

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/CloseTicket.fw.png"))); // NOI18N
        jButton7.setBorder(null);
        jButton7.setContentAreaFilled(false);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton7);
        jButton7.setBounds(270, 70, 80, 70);
        getContentPane().add(jTextField1);
        jTextField1.setBounds(220, 160, 130, 330);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/FinalSeat.png"))); // NOI18N
        jLabel1.setInheritsPopupMenu(false);
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 386, 530);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void s1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s1ActionPerformed

    private void s2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s2ActionPerformed

    private void s4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s4ActionPerformed

    private void s6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s6ActionPerformed

    private void s3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s3ActionPerformed

    private void s5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s5ActionPerformed

    private void s7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s7ActionPerformed

    private void s9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s9ActionPerformed

    private void s8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s8ActionPerformed

    private void s11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s11ActionPerformed

    private void s10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s10ActionPerformed

    private void s13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s13ActionPerformed

    private void s12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s12ActionPerformed

    private void s15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s15ActionPerformed

    private void s14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s14ActionPerformed

    private void s16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s16ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s16ActionPerformed

    private void s17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s17ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s17ActionPerformed

    private void s18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s18ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s18ActionPerformed

    private void s19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s19ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s19ActionPerformed

    private void s20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s20ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s20ActionPerformed

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
            java.util.logging.Logger.getLogger(BusSeat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BusSeat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BusSeat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BusSeat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BusSeat("S0001").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jTextField1;
    private javax.swing.JToggleButton s1;
    private javax.swing.JToggleButton s10;
    private javax.swing.JToggleButton s11;
    private javax.swing.JToggleButton s12;
    private javax.swing.JToggleButton s13;
    private javax.swing.JToggleButton s14;
    private javax.swing.JToggleButton s15;
    private javax.swing.JToggleButton s16;
    private javax.swing.JToggleButton s17;
    private javax.swing.JToggleButton s18;
    private javax.swing.JToggleButton s19;
    private javax.swing.JToggleButton s2;
    private javax.swing.JToggleButton s20;
    private javax.swing.JToggleButton s3;
    private javax.swing.JToggleButton s4;
    private javax.swing.JToggleButton s5;
    private javax.swing.JToggleButton s6;
    private javax.swing.JToggleButton s7;
    private javax.swing.JToggleButton s8;
    private javax.swing.JToggleButton s9;
    // End of variables declaration//GEN-END:variables
}
