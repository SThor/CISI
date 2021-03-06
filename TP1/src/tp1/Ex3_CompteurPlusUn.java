package tp1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 21301646
 */
public class Ex3_CompteurPlusUn extends javax.swing.JFrame {
    private enum Etat{
        MARCHE, ARRET
    }
    
    private int cpt;
    private String pouf;
    private Etat etat;
    

    /**
     * Creates new form Ex3
     */
    public Ex3_CompteurPlusUn() {
        initComponents();
        init();
    }
    
    private void init(){
        etat = Etat.ARRET;
        resetCpt();
        presentationArret();
        afficherCpt();
    }
    
    private void presentationMarche(){
        startButton.setEnabled(false);
        plusOneButton.setEnabled(true);
        stopButton.setEnabled(true);
    }
    
    private void afficherCpt(){
        jLabel1.setText(""+cpt);        
    }
    
    private void afficherPouf(){
        jLabel1.setText("Pouf");        
    }
    
    private void presentationArret(){
        startButton.setEnabled(true);
        plusOneButton.setEnabled(false);
        stopButton.setEnabled(false);
    }
    
    private void resetCpt(){
        cpt = 0;
    }
    
    private void incrementeCpt(){
        cpt++;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        startButton = new javax.swing.JButton();
        plusOneButton = new javax.swing.JButton();
        stopButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        startButton.setText("Start");
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });
        jPanel1.add(startButton);

        plusOneButton.setText("+1");
        plusOneButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                plusOneButtonActionPerformed(evt);
            }
        });
        jPanel1.add(plusOneButton);

        stopButton.setText("Stop");
        stopButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopButtonActionPerformed(evt);
            }
        });
        jPanel1.add(stopButton);

        getContentPane().add(jPanel1, java.awt.BorderLayout.SOUTH);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("0");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
        switch(etat){
            case ARRET:
                etat = Etat.MARCHE;
                presentationMarche();
                afficherCpt();
                break;
            case MARCHE: // interdit
                break;
        }
    }//GEN-LAST:event_startButtonActionPerformed

    private void stopButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopButtonActionPerformed
        switch(etat){
            case ARRET: // interdit
                break;
            case MARCHE:
                etat = Etat.ARRET;
                presentationArret();
                resetCpt();
                afficherPouf();
                break;
        }
    }//GEN-LAST:event_stopButtonActionPerformed

    private void plusOneButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_plusOneButtonActionPerformed
        switch(etat){
            case ARRET: // interdit
                break;
            case MARCHE:
                if(cpt<3){
                    etat = Etat.MARCHE;
                    presentationMarche();
                    incrementeCpt();
                    afficherCpt();
                }else{
                    etat = Etat.ARRET;
                    presentationArret();
                    resetCpt();
                    afficherPouf();
                }
                
                break;
        }
    }//GEN-LAST:event_plusOneButtonActionPerformed

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
            java.util.logging.Logger.getLogger(Ex3_CompteurPlusUn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ex3_CompteurPlusUn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ex3_CompteurPlusUn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ex3_CompteurPlusUn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ex3_CompteurPlusUn().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton plusOneButton;
    private javax.swing.JButton startButton;
    private javax.swing.JButton stopButton;
    // End of variables declaration//GEN-END:variables
}
