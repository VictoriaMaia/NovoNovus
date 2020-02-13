package com.totalcross.view.components;

import totalcross.sys.Settings;
import totalcross.ui.Control;
import totalcross.ui.gfx.Color;
import totalcross.ui.gfx.Graphics;
import totalcross.util.UnitsConverter;

public class Thermometer extends Control {


    int minValue;
    int maxValue;
    int value;
    int steps;
    public Thermometer(int minValue, int maxValue, int steps) {
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.steps = steps;
    }

    @Override
    public void onPaint(Graphics g) {
        //Thermometer
        // int smallerSpacing = Settings.screenHeight/100;
        // int spacing = smallerSpacing*5;
        // int thermometerHeight = spacing*steps;
        // if(smallerSpacing * steps * 5 != thermometerHeight) {
        //     thermometerHeight = smallerSpacing * steps * 5;
        // }
        // int sideValue = maxValue;
        // int decreaseValue = maxValue/steps;
        // int drawY;
        // int oldForeColor = g.foreColor;
        // double percentage = value/(double)maxValue;
        // g.backColor = Color.getRGB(198, 54, 64);
        // int fillAmount = (int)(percentage*thermometerHeight);
        // g.fillRect(width/2 , thermometerHeight + UnitsConverter.toPixels(DP + 1) + fm.height/2 - fillAmount, UnitsConverter.toPixels(DP + 10), fillAmount);
        // g.foreColor = Color.getRGB(199, 199, 199);
        // for(drawY = UnitsConverter.toPixels(DP + 1) + fm.height/2; drawY < thermometerHeight + 1 + fm.height/2; drawY += smallerSpacing) {
        //     if((drawY - (UnitsConverter.toPixels(DP + 1) + fm.height/2)) % (smallerSpacing*5) == 0) {
        //         g.drawText(sideValue + "", width/2 - UnitsConverter.toPixels(DP + 2) - fm.stringWidth(sideValue + ""), drawY - fm.height/2);
        //         sideValue -= decreaseValue;
        //         g.drawThickLine(width/2, drawY, width/2 + UnitsConverter.toPixels(DP + 10), drawY, UnitsConverter.toPixels(DP + 2));
        //     } else {
        //         g.drawLine(width/2 + UnitsConverter.toPixels(DP + 3), drawY, width/2 + UnitsConverter.toPixels(DP + 10), drawY);
        //     }
        // }
        // g.drawText(sideValue + "", width/2 - UnitsConverter.toPixels(DP + 2) - fm.stringWidth(sideValue + ""), drawY - fm.height/2);
        // sideValue -= decreaseValue;
        // g.drawThickLine(width/2, drawY, width/2 + UnitsConverter.toPixels(DP + 10), drawY, UnitsConverter.toPixels(DP + 2));
        // g.foreColor = oldForeColor;
        int radius = 1;
        g.fillCircle(width/2, radius, radius);
        //different color
        g.fillCircle(width/2, radius, radius - UnitsConverter.toPixels(DP + 1));
        int thermometerHeight = 1;
        g.fillRect(width/2 - radius, radius, radius * 2, thermometerHeight);
        //different color
        g.fillRect(width/2 - radius + UnitsConverter.toPixels(DP + 1), radius, radius * 2 - UnitsConverter.toPixels(DP + 2), thermometerHeight);
        g.fillCircle(width/2, width/2, width/2);
        //different color
        g.fillCircle(width/2, width/2, width/2 - UnitsConverter.toPixels(DP + 1));
        //different color
        g.fillCircle(width/2, width/2, width/2 - UnitsConverter.toPixels(DP + 9));
        
    }

    /**
     * @param value the value to set
     */
    public void setValue(int value) {
        this.value = value;
        repaint();
    }
    /**
     * @return the value
     */
    public int getValue() {
        return value;
    }
}