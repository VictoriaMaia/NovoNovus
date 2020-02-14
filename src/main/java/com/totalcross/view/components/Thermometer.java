package com.totalcross.view.components;

import totalcross.sys.Settings;
import totalcross.sys.Vm;
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
        height = height - 1;
        int radius = UnitsConverter.toPixels(DP + 14);
        g.backColor = Color.getRGB("CEC4C4");
        g.fillCircle(width/2, radius, radius);
        g.backColor = Color.getRGB("FFFFFF");
        g.fillCircle(width/2, radius, radius - UnitsConverter.toPixels(DP + 1));
        int thermometerHeight = height - UnitsConverter.toPixels(DP + 52);
        g.backColor = Color.getRGB("CEC4C4");
        g.fillRect(width/2 - radius, radius, radius * 2, thermometerHeight);
        g.fillCircle(width/2, height - width/2, width/2);
        g.backColor = Color.getRGB("FFFFFF");
        g.fillRect(width/2 - radius + UnitsConverter.toPixels(DP + 1), radius, radius * 2 - UnitsConverter.toPixels(DP + 2), thermometerHeight);
        g.fillCircle(width/2, height - width/2, width/2 - UnitsConverter.toPixels(DP + 1));
        g.backColor = Color.getRGB("FF4A4A");
        g.fillCircle(width/2, height - width/2, width/2 - UnitsConverter.toPixels(DP + 8));

        int valueStartPoint = height - width - UnitsConverter.toPixels(DP + 2);
        int majorDivisions = 10;
        int minorDivisions = 5;
        int pointsHeight = valueStartPoint;
        int incr = pointsHeight / (majorDivisions * minorDivisions);
        int pointY = radius;
        int pointsXStart = UnitsConverter.toPixels(DP + 39);
        int pointsXEnd = width/2  + radius;
        int drawValue = maxValue;
        String valueText = "" + drawValue;
        g.foreColor = Color.getRGB("CEC4C4");
        for(int i = 0, j = 0; i <= majorDivisions; j = (j + 1) % minorDivisions) {
            if(j == 0) {
                g.drawThickLine(pointsXStart, pointY, pointsXEnd, pointY, UnitsConverter.toPixels(DP + 2));
                g.drawText(valueText, pointsXEnd + UnitsConverter.toPixels(DP + 3), pointY - font.fm.height/2);
                i++;
                Vm.debug(valueText);
                drawValue = maxValue - (int) (1.0 * i/majorDivisions*maxValue);
                valueText = "" + drawValue;
            } else {
                g.drawThickLine(pointsXStart, pointY, pointsXEnd - UnitsConverter.toPixels(DP + 2), pointY, UnitsConverter.toPixels(DP + 1));
            }
            pointY += incr;
        }

        g.backColor = Color.getRGB("FF4A4A");
        int barBottom = height - width;
        int barTop = (int) (1.0 * value / maxValue * (barBottom - radius)) + UnitsConverter.toPixels(DP + 5) + radius;
        g.fillRect(UnitsConverter.toPixels(DP + 25), barTop, UnitsConverter.toPixels(DP + 10), barBottom - barTop + UnitsConverter.toPixels(DP + 12));
        g.fillCircle(UnitsConverter.toPixels(DP + 30), barTop, UnitsConverter.toPixels(DP + 5));
        height = height + 1;
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