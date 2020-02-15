package com.totalcross.view;

import java.util.Random;

import com.totalcross.util.Colors;
import com.totalcross.util.Fonts;
import com.totalcross.util.Images;
import com.totalcross.util.MaterialConstants;
import com.totalcross.view.components.Graphic;
import com.totalcross.view.components.TemperatureValueLabel;
import com.totalcross.view.components.Thermometer;

import totalcross.ui.Container;
import totalcross.ui.ImageControl;
import totalcross.ui.Label;
import totalcross.ui.MainWindow;
import totalcross.ui.event.UpdateListener;
import totalcross.ui.gfx.Color;
import totalcross.util.UnitsConverter;

public class AnalogInputView extends SideMenuContainerView {

    Graphic graphic;
    Thermometer thermo;
    TemperatureValueLabel temperatureValue;
    int[] yValues;
    int refreshTime = 2000;
    int elapsedRefreshTime = 0;
    Random randomGenerator = new Random();

    UpdateListener updateListener = new UpdateListener(){

        public void updateListenerTriggered(int elapsedMiliseconds) {
            elapsedRefreshTime += elapsedMiliseconds;
            if(elapsedRefreshTime >= refreshTime) {
                int value = randomGenerator.nextInt(100);
                setThermometerValue(value);
                elapsedRefreshTime = 0;
            }
        }
    };
    public AnalogInputView() {
        setBackColor(Color.getRGB("1A1A1A"));
        this.graphic = new Graphic(100, 4, 12);
        yValues = new int[12];
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
        MainWindow.getMainWindow().addUpdateListener(updateListener);
    }


    @Override
    public void onView(Container content) {
        ImageControl icLogo = new ImageControl(Images.iTotalCrossLogoHorizontal);
        icLogo.scaleToFit = true;
        // LABEL
        Label lTitle = new Label("ANALOG INPUT");
        lTitle.setFont(Fonts.MontserratExtraBold24);
        lTitle.setForeColor(Colors.COLOR_WHITE);
        Label graphTitle = new Label("Thermocouple T Type");
        graphTitle.setFont(Fonts.MontserratExtraBold24);
        graphTitle.setForeColor(Colors.COLOR_WHITE);
        content.add(lTitle, CENTER, TOP+MaterialConstants.GAP55);
        Label temperature = new Label("TEMPERATURE", CENTER);
        temperature.setFont(Fonts.MontserratBold17);
        temperature.setForeColor(Colors.COLOR_WHITE);
        temperatureValue = new TemperatureValueLabel(thermo.getValue());
        temperatureValue.setFont(Fonts.MontserratExtraBold19);
        temperatureValue.setBackForeColors(Color.getRGB("21C437"), Colors.COLOR_WHITE);
        content.add(graphTitle, UnitsConverter.toPixels(DP + 157), TOP + UnitsConverter.toPixels(DP + 197));
        content.add(graphic, UnitsConverter.toPixels(DP + 54), UnitsConverter.toPixels(DP + 263), DP + 451, DP + 200);
        content.add(thermo, AFTER + UnitsConverter.toPixels(DP + 111), UnitsConverter.toPixels(DP + 146), DP + 61, DP + 329);
        content.add(temperature, AFTER, TOP + UnitsConverter.toPixels(DP + 278), DP + 221, DP + 25);
        content.add(temperatureValue, CENTER_OF, AFTER, DP + 114, DP + 40);
        content.add(icLogo, RIGHT-MaterialConstants.GAP55, TOP+MaterialConstants.GAP40);
    }

    public void setThermometerValue(int value) {
        thermo.setValue(value);
        for(int i = 1; i < yValues.length; i++) {
            yValues[i - 1] = yValues[i];
        }
        yValues[yValues.length - 1] = value;
        graphic.setValues(yValues);
        temperatureValue.setValue(value);
        repaint();
    }
}