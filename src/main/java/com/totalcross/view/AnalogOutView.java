package com.totalcross.view;

import com.totalcross.util.*;
import com.totalcross.view.components.*;
import com.totalcross.view.components.gauge.*;

import totalcross.ui.Container;
import totalcross.ui.ImageControl;
import totalcross.ui.Label;
import totalcross.ui.MainWindow;
import totalcross.ui.event.UpdateListener;

public class AnalogOutView extends Container {
    // Declaring the variables.
    Label lTitle;
    ImageControl icLogo;
    UpdateListener updateListener;
    
    public void initUI() {
    
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

       
        // ADDING THE ELEMENTS IN SCREEN
        add(lTitle, CENTER, TOP+MaterialConstants.GAP55);
        add(energyGauge, CENTER, AFTER, SCREENSIZE+MaterialConstants.GAP40, SCREENSIZE+MaterialConstants.GAP50);
        add(icLogo, RIGHT-MaterialConstants.GAP55, TOP+MaterialConstants.GAP40);

        updateListener = new UpdateListener() {
            AnimationFunctions af = new AnimationFunctions();
            int rpmTotalTime = 3000;
            int currentime = 0;

            int count = -1;

            @Override
            public void updateListenerTriggered(int elapsedMilliseconds) {
                currentime += elapsedMilliseconds;

                if (++count % 3 == 0) {
                    double ratio = rpmAnimationFunction(currentime % rpmTotalTime, rpmTotalTime);

                    energyGauge.setValue((int) ((energyGauge.getMax() - energyGauge.getMin()) * ratio) - energyGauge.getMin());
                    energyGauge.repaintNow();
                }
            }

            public double rpmAnimationFunction(int time, int totalTime) {
                double ratio = time / (double) totalTime;
                if (ratio < .30) {
                    ratio = ratio / 0.30;
                    return af.easeOutQuad(ratio);
                } else {
                    ratio = (ratio - 0.30) / 0.70;
                    return 1.0 - af.easeOutSine(ratio);
                }
            }
        };
        MainWindow.getMainWindow().addUpdateListener(updateListener);

    }
}