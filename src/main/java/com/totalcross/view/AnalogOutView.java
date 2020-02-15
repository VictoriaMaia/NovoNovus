package com.totalcross.view;

import com.totalcross.util.*;
import com.totalcross.view.components.*;
import com.totalcross.view.components.gauge.*;

import totalcross.ui.Container;
import totalcross.ui.ImageControl;
import totalcross.ui.Label;
import totalcross.ui.MainWindow;
import totalcross.ui.ScrollBar;
import totalcross.ui.Slider;
import totalcross.ui.event.UpdateListener;

public class AnalogOutView extends SideMenuContainerView {
    // Declaring the variables.
    Label lTitle;
    ImageControl icLogo;
    UpdateListener updateListener;
    Slider slBar;

    @Override
    public void onView(Container content) {

        Gauge energyGauge = new EnergyGauge(0, 80, 180);
        energyGauge.section(80, Colors.COLOR_1_GREEN_ENERGYGAUGE);
        energyGauge.section(80, Colors.COLOR_2_LIGHT_BLUE_ENERGYGAUGE);
        energyGauge.section(80, Colors.COLOR_3_BLUE_ENERGYGAUGE);
        energyGauge.setMajorTickInterval(20);
        energyGauge.setMinorTickInterval(5);
        // energyGauge.setValueLabelFont(Font.getFont(25));
        energyGauge.setValueSuffix(" °C");
        energyGauge.setForeColor(0x0);
        energyGauge.setValue(60);

        // Initializing the variables.

        // IMAGE CONTROLL

        icLogo = new ImageControl(Images.iTotalCrossLogoHorizontal);
        icLogo.scaleToFit = true;

        // LABEL

        lTitle = new Label("ANALOG OUTPUT");
        // lTitle.setFont(Fonts.MontserratExtraBolt24);
        // Montserrat Extra Bold tam 24px
        lTitle.setForeColor(Colors.COLOR_WHITE);

        // SLIDER
        slBar = new Slider(ScrollBar.HORIZONTAL);
        slBar.appId = 1;
        slBar.setLiveScrolling(true);
        slBar.setBackColor(Colors.COLOR_WHITE);
        slBar.sliderColor = Colors.COLOR_WHITE;
        slBar.setValue(50);


        // ADDING THE ELEMENTS IN SCREEN
        content.add(lTitle, CENTER, TOP+MaterialConstants.GAP55);
        content.add(energyGauge, CENTER, AFTER, SCREENSIZE+MaterialConstants.GAP40, SCREENSIZE+MaterialConstants.GAP50);
        content.add(slBar,CENTER, AFTER+MaterialConstants.GAP90, SCREENSIZE+MaterialConstants.GAP30, PREFERRED);
        content.add(icLogo, RIGHT-MaterialConstants.GAP55, TOP+MaterialConstants.GAP40);

        updateListener = new UpdateListener() {

            int count = -1;

            @Override
            public void updateListenerTriggered(int elapsedMilliseconds) {

                if (++count % 3 == 0) {
                    double ratio = slBar.getValue()/100.0;

                    energyGauge.setValue((int) ((energyGauge.getMax() - energyGauge.getMin()) * ratio) - energyGauge.getMin());
                    energyGauge.repaintNow();
                }
            }
        };
        MainWindow.getMainWindow().addUpdateListener(updateListener);
    }
}