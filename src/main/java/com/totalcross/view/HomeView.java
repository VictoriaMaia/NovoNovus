package com.totalcross.view;

import com.totalcross.util.*;

import totalcross.ui.*;

public class HomeView extends Container{
    private Label lInit;
    private ImageControl icLogoTotalCross;
    private Button bStart;

    public void initUI() {

        icLogoTotalCross = new ImageControl(Images.iTotalCrossLogoVertical);
        icLogoTotalCross.scaleToFit = true;

        lInit = new Label("TotalCross running in Toradex");
        lInit.setForeColor(Colors.COLOR_LIGHT_GRAY);

        bStart = new Button("START");
        bStart.setBackForeColors(Colors.COLOR_GREEN_BUTTON, Colors.COLOR_WHITE);
        bStart.setBorder(BORDER_ROUNDED);
		bStart.setDoEffect(false);
		bStart.addPressListener((c) -> {
            MainWindow.getMainWindow().swap(new AnalogInputView());
        });

        // Components in the screen
        add(icLogoTotalCross, CENTER, CENTER-MaterialConstants.GAP60);
        add(lInit, CENTER, AFTER);
        add(bStart, CENTER, AFTER+MaterialConstants.GAP45, SCREENSIZE+MaterialConstants.GAP10, SCREENSIZE+MaterialConstants.GAP5);
    }
    
}
