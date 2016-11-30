/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.util.List;

/**
 *
 * @author 21301646
 */
public class Panel_Ex10_ComplexDrawing extends javax.swing.JPanel {
    private List<Point> workingPolyline;
    private List<List<Point>> polylines;
    private Point workingPoint;
    
    private boolean drawing;
    private Graphics2D g2;
    private final static Color FINAL_COLOR = Color.BLACK;
    private final static Color WORKING_POLY_COLOR = Color.GRAY;
    private final static Color WORKING_LINE_COLOR = Color.RED;
    
    private enum State{
        INIT, UNI, POLY
    }
    
    private State state;

    /**
     * Creates new form Panel_Ex9_RubberBanding
     */
    public Panel_Ex10_ComplexDrawing() {
        initComponents();
        init();
    }
    
    private void init(){
        state = State.INIT;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        g2.setColor(FINAL_COLOR);
        for (List<Point> polyline : polylines) {
            for (int i = 0; i < polyline.size(); i++) {
                Point p1 = polyline.get(i);
                Point p2 = polyline.get(i+1);
                g2.drawLine(p1.x, p1.y, p2.x, p2.y);
            }
        }
        
        g2.setColor(WORKING_POLY_COLOR);
        for (int i = 0; i < workingPolyline.size()-1; i++) {
            Point p1 = workingPolyline.get(i);
            Point p2 = workingPolyline.get(i+1);
            g2.drawLine(p1.x, p1.y, p2.x, p2.y);    
        }
        
        g2.setColor(WORKING_LINE_COLOR);
        Point p = workingPolyline.get(workingPolyline.size()-1);
        g2.drawLine(p.x, p.y, workingPoint.x,workingPoint.y);  
    }
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        switch(evt.getButton()){
            case MouseEvent.BUTTON1:
                switch (state){
                    case INIT://forbidden
                        break;
                    case UNI://forbidden
                        break;
                    case POLY://forbidden
                        break;
                }
                break;
            case MouseEvent.BUTTON2:
                switch (state){
                    case INIT://forbidden
                        break;
                    case UNI://forbidden
                        break;
                    case POLY://forbidden
                        break;
                }
                break;
        }
    }//GEN-LAST:event_formMouseClicked

    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved
        switch (state){
            case INIT://forbidden
                break;
            case UNI:
                workingPoint = evt.getPoint();
                break;
            case POLY:
                workingPoint = evt.getPoint();                
                break;
        }
    }//GEN-LAST:event_formMouseMoved

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        switch (state){
            case INIT://forbidden
                break;
            case UNI://forbidden
                break;
            case POLY://forbidden
                break;
        }
    }//GEN-LAST:event_formKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}