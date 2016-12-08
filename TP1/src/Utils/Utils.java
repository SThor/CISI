/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import javax.swing.JComponent;
import javax.swing.Timer;

/**
 *
 * @author 21301646
 */
public class Utils {
    
    public static void activate(JComponent ... components){
        for (JComponent component : components) {
            component.setEnabled(true);
        }
    }
    
    public static void deactivate(JComponent ... components){
        for (JComponent component : components) {
            component.setEnabled(false);
        }
    }
    
    public static void stopTimers(Timer ... timers){
        for (Timer timer : timers) {
            timer.stop();
        }
    }
    
}
