/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1;

import Elements.PieChart;
import java.awt.Point;
import Utils.*;
import java.awt.event.KeyEvent;
import javax.swing.UIManager;
import javax.swing.plaf.basic.BasicArrowButton;

/**
 *
 * @author Silma Thoron
 */
public class Ex11_SuperPie extends javax.swing.JFrame {

    private enum State {
        INIT, NO_DOWN, OK, NO_UP, DOWN, EDITING
    }

    private State state;
    private int n;

    /**
     * Creates new form Ex11_SuperPie
     */
    public Ex11_SuperPie() {
        initComponents();
        init();
        percentTextField.requestFocus();
    }

    private void init() {
        state = State.INIT;
        showStop();
        n = 0;
    }

    private int enteredPercent() {
        return Integer.parseInt(percentTextField.getText());
    }

    private void setValue(int percent) {
        pieChart.setPercent(percent);
        percentTextField.setText("" + percent);
    }

    private void setValue(Point point) {
        pieChart.setAngle(point);
        percentTextField.setText("" + pieChart.getPercent());
    }

    private void showStop() {
        deactivateAll();
        Utils.activate(startButton);
    }

    private void showStart() {
        deactivateAll();
        Utils.activate(stopButton, stopButton, upButton, downButton, percentTextField);
    }

    private void deactivateAll() {
        Utils.deactivate(startButton, stopButton, upButton, downButton, percentTextField);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        percentPanel = new javax.swing.JPanel();
        percentTextField = new javax.swing.JFormattedTextField();
        percentLabel = new javax.swing.JLabel();
        pieChart = new Elements.PieChart();
        buttonsPanel = new javax.swing.JPanel();
        upDownPanel = new javax.swing.JPanel();
        upButton = new BasicArrowButton(BasicArrowButton.NORTH);
        downButton = new BasicArrowButton(BasicArrowButton.SOUTH);
        startStopPanel = new javax.swing.JPanel();
        startButton = new javax.swing.JButton();
        stopButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SuperPie");

        mainPanel.setLayout(new java.awt.BorderLayout());

        percentTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));
        percentTextField.setMinimumSize(new java.awt.Dimension(10, 20));
        percentTextField.setPreferredSize(new java.awt.Dimension(40, 20));
        percentTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                percentTextFieldKeyTyped(evt);
            }
        });
        percentPanel.add(percentTextField);

        percentLabel.setText("%");
        percentPanel.add(percentLabel);

        mainPanel.add(percentPanel, java.awt.BorderLayout.SOUTH);

        pieChart.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                pieChartMouseDragged(evt);
            }
        });
        pieChart.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pieChartMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                pieChartMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout pieChartLayout = new javax.swing.GroupLayout(pieChart);
        pieChart.setLayout(pieChartLayout);
        pieChartLayout.setHorizontalGroup(
            pieChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 322, Short.MAX_VALUE)
        );
        pieChartLayout.setVerticalGroup(
            pieChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 296, Short.MAX_VALUE)
        );

        mainPanel.add(pieChart, java.awt.BorderLayout.CENTER);

        getContentPane().add(mainPanel, java.awt.BorderLayout.CENTER);

        buttonsPanel.setLayout(new java.awt.GridLayout(2, 1));

        upDownPanel.setLayout(new java.awt.GridLayout(2, 1));

        upButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                upButtonActionPerformed(evt);
            }
        });
        upDownPanel.add(upButton);

        downButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                downButtonActionPerformed(evt);
            }
        });
        upDownPanel.add(downButton);

        buttonsPanel.add(upDownPanel);

        startStopPanel.setLayout(new java.awt.GridLayout(2, 1));

        startButton.setText("Start");
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });
        startStopPanel.add(startButton);

        stopButton.setText("Stop");
        stopButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopButtonActionPerformed(evt);
            }
        });
        startStopPanel.add(stopButton);

        buttonsPanel.add(startStopPanel);

        getContentPane().add(buttonsPanel, java.awt.BorderLayout.EAST);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void upButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_upButtonActionPerformed
        switch (state) {
            case INIT: //forbidden
                break;
            case NO_DOWN:
                state = State.OK;
                showStart();
                n = 1;
                setValue(n);
                break;
            case OK:
                if (n < 99) {
                    state = State.OK;
                    showStart();
                    n++;
                    setValue(n);
                } else if (n >= 99) {
                    state = State.NO_UP;
                    showStart();
                    n = 100;
                    setValue(n);
                }
                break;
            case NO_UP: //forbidden
                break;
            case DOWN: //impossible
                break;
            case EDITING: //forbidden
                break;
        }
    }//GEN-LAST:event_upButtonActionPerformed

    private void downButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_downButtonActionPerformed
        switch (state) {
            case INIT: //forbidden
                break;
            case NO_DOWN: //forbidden
                break;
            case OK:
                if (n <= 1) {
                    state = State.NO_DOWN;
                    showStart();
                    n = 0;
                    setValue(0);
                } else if (n > 1) {
                    state = State.OK;
                    showStart();
                    n--;
                    setValue(n);
                }
                break;
            case NO_UP:
                state = State.OK;
                showStart();
                n = 99;
                setValue(n);
                break;
            case DOWN: //impossible
                break;
            case EDITING: //forbidden
                break;
        }
    }//GEN-LAST:event_downButtonActionPerformed

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
        switch (state) {
            case INIT:
                state = State.NO_DOWN;
                showStart();
                n = 0;
                // no action
                break;
            case NO_DOWN: //forbidden
                break;
            case OK: //forbidden
                break;
            case NO_UP: //forbidden
                break;
            case DOWN: //impossible
                break;
            case EDITING: //forbidden
                break;
        }
    }//GEN-LAST:event_startButtonActionPerformed

    private void stopButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopButtonActionPerformed
        switch (state) {
            case INIT: //forbidden
                break;
            case NO_DOWN:
                state = State.INIT;
                showStop();
                n = 0;
                setValue(0);
                break;
            case OK:
                state = State.INIT;
                showStop();
                n = 0;
                setValue(0);
                break;
            case NO_UP:
                state = State.INIT;
                showStop();
                n = 0;
                setValue(0);
                break;
            case DOWN: //impossible
                break;
            case EDITING: //forbidden
                break;
        }
    }//GEN-LAST:event_stopButtonActionPerformed

    private void pieChartMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pieChartMousePressed
        switch (state) {
            case INIT: //forbidden
                break;
            case NO_DOWN:
                state = State.DOWN;
                showStart();
                n = n;
                setValue(evt.getPoint());
                break;
            case OK:
                state = State.DOWN;
                showStart();
                n = n;
                setValue(evt.getPoint());
                break;
            case NO_UP:
                state = State.DOWN;
                showStart();
                n = n;
                setValue(evt.getPoint());
                break;
            case DOWN: //impossible
                break;
            case EDITING: //forbidden
                break;
        }
    }//GEN-LAST:event_pieChartMousePressed

    private void pieChartMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pieChartMouseDragged
        switch (state) {
            case INIT: //impossible
                break;
            case NO_DOWN: //impossible
                break;
            case OK: //impossible
                break;
            case NO_UP: //impossible
                break;
            case DOWN:
                state = State.DOWN;
                showStart();
                n = pieChart.pointToPercentage(evt.getPoint());
                setValue(evt.getPoint());
                break;
            case EDITING: //impossible
                break;
        }
    }//GEN-LAST:event_pieChartMouseDragged

    private void pieChartMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pieChartMouseReleased
        switch (state) {
            case INIT: //impossible
                break;
            case NO_DOWN: //impossible
                break;
            case OK: //impossible
                break;
            case NO_UP: //impossible
                break;
            case DOWN:
                if (n <= 0) {
                    state = State.NO_DOWN;
                    showStart();
                    n = 0;
                    setValue(0);
                } else if (n > 0 && n < 100) {
                    state = State.OK;
                    showStart();
                    n = n;
                    setValue(n);
                } else if (n >= 100) {
                    state = State.NO_UP;
                    showStart();
                    n = 100;
                    setValue(evt.getPoint());
                }
                break;
            case EDITING: //impossible
                break;
        }
    }//GEN-LAST:event_pieChartMouseReleased

    private void percentTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_percentTextFieldKeyTyped
        switch (state) {
            case INIT: //forbidden
                break;
            case NO_DOWN: //forbidden
                break;
            case OK: //forbidden
                break;
            case NO_UP: //forbidden
                break;
            case DOWN: // forbidden
                break;
            case EDITING: //TODO
                if (evt.getKeyCode() != KeyEvent.VK_ENTER) {
                    state = State.EDITING;
                    showStart();
                    n = enteredPercent();
                    //no action
                } else if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                    if (n <= 0) {
                        state = State.NO_DOWN;
                        showStart();
                        n = 0;
                        setValue(n);
                    } else if (n < 100 && n > 0) {
                        state = State.OK;
                        showStart();
                        n = n;
                        setValue(n);
                    } else if (n >= 100) {
                        state = State.NO_UP;
                        showStart();
                        n = 100;
                        setValue(n);
                    }
                }
                break;
        }
    }//GEN-LAST:event_percentTextFieldKeyTyped

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
            javax.swing.UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ex11_SuperPie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ex11_SuperPie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ex11_SuperPie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ex11_SuperPie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ex11_SuperPie().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel buttonsPanel;
    private javax.swing.JButton downButton;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel percentLabel;
    private javax.swing.JPanel percentPanel;
    private javax.swing.JFormattedTextField percentTextField;
    private Elements.PieChart pieChart;
    private javax.swing.JButton startButton;
    private javax.swing.JPanel startStopPanel;
    private javax.swing.JButton stopButton;
    private javax.swing.JButton upButton;
    private javax.swing.JPanel upDownPanel;
    // End of variables declaration//GEN-END:variables
}
