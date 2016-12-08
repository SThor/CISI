/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC_PieChart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author 21301646
 */
public class PercentModel implements Model{
    private int percent;
    private List<View> views = new ArrayList<>();
    
    public void addView(View v){
        views.add(v);
    }

    @Override
    public void setValue(int value) {
        this.percent = value;
        for (View view : views) {
            view.notif();
        }
    }

    @Override
    public int getValue() {
        return percent;
    }

    @Override
    public void addModelListener(View... views) {
        this.views.addAll(Arrays.asList(views));
    }
    
}
