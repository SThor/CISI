/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import Utils.*;
import java.awt.Color;

/**
 *
 * @author 21301646
 */
public class Ex6_FeuTricolore extends javax.swing.JFrame {
    private static final int DELAY_RED = 2000;
    private static final int DELAY_ORANGE = 1000;
    private static final int DELAY_GREEN = 3000;
    private static final int DELAY_FAILON = 1500;
    private static final int DELAY_FAILOFF = 500;
    
    private Timer timerRed;
    private Timer timerOrange;
    private Timer timerGreen;
    private Timer timerFailOn;
    private Timer timerFailOff;
    
    public enum State{
        OFF,RED,ORANGE,GREEN,FAILON,FAILOFF
    }
    
    private State state;

    /**
     * Creates new form Ex6_FeuTricolore
     */
    public Ex6_FeuTricolore() {
        initComponents();
        init();
    }
    
    private void initTimers(){
        timerRed = new Timer(DELAY_RED, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tickTimerRed();
            }
        });
        timerOrange = new Timer(DELAY_ORANGE, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tickTimerOrange();
            }
        });
        timerGreen = new Timer(DELAY_GREEN, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tickTimerGreen();
            }
        });
        timerFailOn = new Timer(DELAY_FAILON, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tickTimerFailOn();
            }
        });
        timerFailOff = new Timer(DELAY_FAILOFF, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tickTimerFailOff();
            }
        });
    }
    
    private void showRed(){
        Utils.stopTimers(timerOrange,timerGreen,timerFailOn,timerFailOff);
        timerRed.start();
        Utils.activate(stopButton,failButton);
        Utils.deactivate(startButton);
        Light.turnOn(red);
        Light.turnOff(orange, green);
    }
    
    private void showGreen(){
        Utils.stopTimers(timerOrange,timerRed,timerFailOn,timerFailOff);
        timerGreen.start();
        Utils.activate(stopButton,failButton);
        Utils.deactivate(startButton);
        Light.turnOn(green);
        Light.turnOff(orange, red);
    }
    
    private void showOrange(){
        Utils.stopTimers(timerGreen,timerRed,timerFailOn,timerFailOff);
        timerOrange.start();
        Utils.activate(stopButton,failButton);
        Utils.deactivate(startButton);
        Light.turnOn(orange);
        Light.turnOff(green, red);
    }
    
    private void showFailOn(){
        Utils.stopTimers(timerOrange,timerRed,timerGreen,timerFailOff);
        timerFailOn.start();
        Utils.activate(stopButton,startButton);
        Utils.deactivate(failButton);
        Light.turnOn(orange);
        Light.turnOff(green, red);
    }
    
    private void showFailOff(){
        Utils.stopTimers(timerOrange,timerRed,timerGreen,timerFailOn);
        timerFailOff.start();
        Utils.activate(stopButton,startButton);
        Utils.deactivate(failButton);
        Light.turnOff(green, red, orange);
    }
    
    private void showOff(){
        Utils.stopTimers(timerRed,timerOrange,timerGreen,timerFailOn,timerFailOff);
        Utils.activate(startButton);
        Utils.deactivate(stopButton,failButton);
        Light.turnOff(green, red, orange);
    }
    
    private void init(){
        initTimers();
        state = State.OFF;
        showOff();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lightsPanel = new javax.swing.JPanel();
        red = new tp1.Light(Color.RED);
        orange = new tp1.Light(Color.ORANGE);
        green = new tp1.Light(Color.GREEN);
        buttonsPanel = new javax.swing.JPanel();
        startButton = new javax.swing.JButton();
        stopButton = new javax.swing.JButton();
        failButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lightsPanel.setLayout(new java.awt.GridLayout(3, 2, 10, 10));
        lightsPanel.add(red);
        lightsPanel.add(orange);
        lightsPanel.add(green);

        getContentPane().add(lightsPanel, java.awt.BorderLayout.CENTER);

        buttonsPanel.setLayout(new java.awt.GridLayout(3, 1));

        startButton.setText("Start");
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });
        buttonsPanel.add(startButton);

        stopButton.setText("Stop");
        stopButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopButtonActionPerformed(evt);
            }
        });
        buttonsPanel.add(stopButton);

        failButton.setText("Failure");
        failButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                failButtonActionPerformed(evt);
            }
        });
        buttonsPanel.add(failButton);

        getContentPane().add(buttonsPanel, java.awt.BorderLayout.EAST);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
        switch(state){
            case OFF:
                state = State.RED;
                showRed();
                break;
            case RED://Forbidden
                break;
            case ORANGE://Forbidden
                break;
            case GREEN://Forbidden
                break;
            case FAILON:
                state = State.RED;
                showRed();
                break;
            case FAILOFF:
                state = State.RED;
                showRed();
                break;
        }
    }//GEN-LAST:event_startButtonActionPerformed

    private void stopButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopButtonActionPerformed
        switch(state){
            case OFF://Forbidden
                break;
            case RED:
                state = State.OFF;
                showOff();
                break;
            case ORANGE:
                state = State.OFF;
                showOff();
                break;
            case GREEN:
                state = State.OFF;
                showOff();
                break;
            case FAILON:
                state = State.OFF;
                showOff();
                break;
            case FAILOFF:
                state = State.OFF;
                showOff();
                break;
        }
    }//GEN-LAST:event_stopButtonActionPerformed

    private void failButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_failButtonActionPerformed
        switch(state){
            case OFF://Forbidden
                break;
            case RED:
                state = State.FAILON;
                showFailOn();
                break;
            case ORANGE:
                state = State.FAILON;
                showFailOn();
                break;
            case GREEN:
                state = State.FAILON;
                showFailOn();
                break;
            case FAILON://Forbidden
                break;
            case FAILOFF://Forbidden
                break;
        }
    }//GEN-LAST:event_failButtonActionPerformed

    private void tickTimerRed(){
        switch(state){
            case OFF://Forbidden
                break;
            case RED:
                state = State.GREEN;
                showGreen();
                break;
            case ORANGE://Forbidden
                break;
            case GREEN://Forbidden
                break;
            case FAILON://Forbidden
                break;
            case FAILOFF://Forbidden
                break;
        }
    }
    
    private void tickTimerOrange(){
        switch(state){
            case OFF://Forbidden
                break;
            case RED://Forbidden
                break;
            case ORANGE:
                state = State.RED;
                showRed();
                break;
            case GREEN://Forbidden
                break;
            case FAILON://Forbidden
                break;
            case FAILOFF://Forbidden
                break;
        }
    }
    
    private void tickTimerGreen(){
        switch(state){
            case OFF://Forbidden
                break;
            case RED://Forbidden
                break;
            case ORANGE://Forbidden
                break;
            case GREEN:
                state = State.ORANGE;
                showOrange();
                break;
            case FAILON://Forbidden
                break;
            case FAILOFF://Forbidden
                break;
        }
    }
    
    private void tickTimerFailOn(){
        switch(state){
            case OFF://Forbidden
                break;
            case RED://Forbidden
                break;
            case ORANGE://Forbidden
                break;
            case GREEN://Forbidden
                break;
            case FAILON:
                state = State.FAILOFF;
                showFailOff();
                break;
            case FAILOFF://Forbidden
                break;
        }
    }
    
    private void tickTimerFailOff(){
        switch(state){
            case OFF://Forbidden
                break;
            case RED://Forbidden
                break;
            case ORANGE://Forbidden
                break;
            case GREEN://Forbidden
                break;
            case FAILON://Forbidden
                break;
            case FAILOFF:
                state = State.FAILON;
                showFailOn();
                break;
        }
    }
    
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
            java.util.logging.Logger.getLogger(Ex6_FeuTricolore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ex6_FeuTricolore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ex6_FeuTricolore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ex6_FeuTricolore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ex6_FeuTricolore().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel buttonsPanel;
    private javax.swing.JButton failButton;
    private tp1.Light green;
    private javax.swing.JPanel lightsPanel;
    private tp1.Light orange;
    private tp1.Light red;
    private javax.swing.JButton startButton;
    private javax.swing.JButton stopButton;
    // End of variables declaration//GEN-END:variables
}
