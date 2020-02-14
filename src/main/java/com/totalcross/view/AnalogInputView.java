package com.totalcross.view;

import com.totalcross.util.Fonts;
import com.totalcross.view.components.Graphic;
import com.totalcross.view.components.Thermometer;

import totalcross.ui.Container;
import totalcross.ui.gfx.Color;
import totalcross.util.UnitsConverter;

public class AnalogInputView extends SideMenuContainerView {

    Graphic graphic;
    Thermometer thermo;

    public AnalogInputView() {
        setBackColor(Color.getRGB("1A1A1A"));
        this.graphic = new Graphic(100, 4, 12);
        int[] values = new int[12];
        for (int i = 0; i < values.length; i ++) {
            values[i] = 9*i;
        }
        graphic.setFont(Fonts.MontserratMedium14);
        graphic.setValues(values);
        graphic.setIntervalBarsColor(Color.getRGB("C7C4C4"));
        graphic.setLineAndPointsColor(Color.getRGB("6B3193"));
        graphic.setSideTextColor(Color.getRGB("716D6D"));
        thermo = new Thermometer(0, 100, 10);
        thermo.setFont(Fonts.MontserratMedium8);
        thermo.setValue(50);
    }


    @Override
    public void onView(Container content) {
        content.add(graphic, UnitsConverter.toPixels(DP + 54), UnitsConverter.toPixels(DP + 263), DP + 451, DP + 200);
        content.add(thermo, AFTER + UnitsConverter.toPixels(DP + 111), UnitsConverter.toPixels(DP + 146), DP + 61, DP + 329);
    }

}