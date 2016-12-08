/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC_PieChart;

import javax.swing.JTextField;

/**
 *
 * @author 21301646
 */
public class JTextFieldPercent extends JTextField implements View{
    private PercentModel model;
    
    public void setModel(Model model){
        this.model = (PercentModel)model;
    }
    
    @Override
    public void notif(){
        setText(model.getValue() + "");
    }
}
