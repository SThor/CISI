/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC_PieChart;

/**
 *
 * @author 21301646
 */
public interface Model {
    public void setValue(int value);
    public int getValue();
    public void addModelListener(View ... views);    
}
