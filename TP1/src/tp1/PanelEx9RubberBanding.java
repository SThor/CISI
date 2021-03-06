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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 21301646
 */
public class PanelEx9RubberBanding extends javax.swing.JPanel {
    private Point origin;
    private Point current;
    private List<Point> starts = new ArrayList<>();
    private List<Point> ends = new ArrayList<>();
    private boolean drawing;
    private Graphics2D g2;
    private final static Color WORKING_COLOR = Color.RED;
    private final static Color COLOR = Color.BLACK;
    
    private enum State{
        INIT, DRAW
    }
    
    private State state;

    /**
     * Creates new form Panel_Ex9_RubberBanding
     */
    public PanelEx9RubberBanding() {
        initComponents();
        init();
    }
    
    private void init(){
        state = State.INIT;
    }

    private void saveLine(Point start, Point end) {
        starts.add(start);
        ends.add(end);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        if(drawing){
            g2.setColor(WORKING_COLOR);
            g2.drawLine(origin.x, origin.y, current.x, current.y);            
        }
        for (int i = 0; i < starts.size(); i++) {
            Point start = starts.get(i);
            Point end = ends.get(i);
            g2.setColor(COLOR);
            g2.drawLine(start.x, start.y, end.x, end.y);    
            
        }
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
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                formMouseReleased(evt);
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

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        System.out.println("tp1.Panel_Ex9_RubberBanding.formMousePressed()");
        switch(state){
            case INIT:
                state = State.DRAW;
                origin = evt.getPoint();
                break;
            case DRAW://forbidden
                break;
        }
    }//GEN-LAST:event_formMousePressed

    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased
        System.out.println("tp1.Panel_Ex9_RubberBanding.formMouseReleased()");
        switch(state){
            case INIT://forbidden
                break;
            case DRAW:
                state = State.INIT;
                drawing = false;
                saveLine(origin,current);
                break;
        }
    }//GEN-LAST:event_formMouseReleased

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        switch(state){
            case INIT://forbidden
                break;
            case DRAW:
                state = State.DRAW;
                current = evt.getPoint();
                drawing = true;
                repaint();
                break;
        }
    }//GEN-LAST:event_formMouseDragged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
