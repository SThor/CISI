/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Elements;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;

/**
 *
 * @author 21301646
 */
public class Light extends JPanel {

    private Color onColor = Color.BLUE;
    private final Color offColor = Color.DARK_GRAY;

    public static void turnOn(Light... lights) {
        for (Light light : lights) {
            light.setOn(true);
        }
    }

    public static void turnOff(Light... lights) {
        for (Light light : lights) {
            light.setOn(false);
        }
    }

    private boolean on = true;

    private void setOn(boolean bool) {
        on = bool;
        repaint();
    }

    public Light(Color c) {
        super();
        this.onColor = c;
    }

    public Light() {
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        if (on) {
            g2.setColor(onColor);
        } else {
            g2.setColor(offColor);
        }
        int diam = Math.min(getWidth(), getHeight());
        int x = (getWidth() - diam) / 2;
        int y = (getHeight() - diam) / 2;
        g2.fillOval(x, y, diam, diam);
    }
}
