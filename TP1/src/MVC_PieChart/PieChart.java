/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC_PieChart;

import MVC_PieChart.Model;
import MVC_PieChart.PercentModel;
import MVC_PieChart.View;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import javax.swing.JPanel;

/**
 *
 * @author Racim
 */
public class PieChart extends JPanel implements View{
    private Color colorFilled;
    private Color colorEmpty;
    private final static Color DEFAULT_COLOR_FILLED = Color.ORANGE;
    private final static Color DEFAULT_COLOR_EMPTY = Color.LIGHT_GRAY;
    private int percent;
    
    private PercentModel model;

    public PieChart() {
        this(DEFAULT_COLOR_FILLED, DEFAULT_COLOR_EMPTY);
    }

    public PieChart(Color colorFilled, Color colorEmpty) {
        this.colorFilled = colorFilled;
        this.colorEmpty = colorEmpty;
        this.percent = 0;
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.clearRect(0, 0, this.getWidth(), this.getHeight());
        g2.setColor(colorEmpty);
        int diam = getDiam();
        int x = (getWidth() - diam) / 2;
        int y = (getHeight() - diam) / 2;
        g2.fillOval(x, y, diam, diam);
        g2.setColor(colorFilled);
        g2.fillArc(x, y, diam, diam, 0, computeAngle());
    }
    
    @Override
    public void notif(){
        setPercent(model.getValue());
    }
    
    public void setPercent(int percent){
        this.percent = model.getValue();
        repaint();
    }
    
    public void setAngle(Point point){
        if(isPointInCircle(point)){
            setPercent(pointToPercentage(point));
        }
    }
    
    public void setModel(Model model){
        this.model = (PercentModel)model;
    }
    
    public boolean isPointInCircle(Point point) {
        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;
        int radius = getDiam() / 2;
        return (Math.pow(point.x - centerX, 2) + Math.pow(point.y - centerY, 2) < Math.pow(radius, 2));
    }
    
    public int pointToPercentage(Point point) {
        Point center = new Point(getWidth() / 2, getHeight() / 2);
        Point zero = new Point(getWidth(), getHeight() / 2);
        double angle = Math.atan2(center.y - zero.y, center.x - zero.x) - Math.atan2(center.y - point.y, center.y - point.x);
        return (int) (Math.ceil(Math.toDegrees(angle)) * 100 / 360);
    }

    private int getDiam() {
        return Math.min(getWidth(), getHeight());
    }

    private int computeAngle() {        
        return (360 * percent / 100);
    }
    
    public int getPercent(){
        return percent;
    }
}
