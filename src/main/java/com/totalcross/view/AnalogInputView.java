package com.totalcross.view;

import com.totalcross.view.components.Graphic;

import totalcross.ui.Container;
import totalcross.ui.gfx.Color;

public class AnalogInputView extends SideMenuContainerView {

    Graphic graphic;

    public AnalogInputView() {
        setBackColor(Color.getRGB("1A1A1A"));
        this.graphic = new Graphic(100, 4, 12);
        int[] values = new int[12];
        for (int i = 0; i < values.length; i ++) {
            values[i] = 9*i;
        }
        graphic.setValues(values);
        graphic.setIntervalBarsColor(Color.getRGB("C7C4C4"));
        graphic.setLineAndPointsColor(Color.getRGB("6B3193"));
        graphic.setSideTextColor(Color.getRGB("716D6D"));
    }


    @Override
    public void onView(Container content) {
        content.
                add(graphic, CENTER, CENTER, DP + 451, DP + 200);
    }

}