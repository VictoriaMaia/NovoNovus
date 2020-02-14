package com.totalcross.view;

import com.totalcross.util.*;

import com.totalcross.view.components.SideButtons;
import totalcross.ui.*;
import totalcross.util.UnitsConverter;

public class HomeView extends Container{
    private Label lInit;
    private ImageControl icLogoTotalCross;
    private Button bStart;

    public void initUI() {
        // Initializing the images.
        // Images.loadImages();

        // Declaring components
        icLogoTotalCross = new ImageControl(Images.iTotalCrossLogoVertical);
        icLogoTotalCross.scaleToFit = true;

        lInit = new Label("TotalCross running in Toradex");
        //lInit.setFont(Fonts.MontserratRegular19);
        lInit.setForeColor(Colors.COLOR_LIGHT_GRAY);
        // Monteserrat Regular tam 19px

        bStart = new Button("START");
        //bStart.setFont(Fonts.MontserratBold17);
        // Montserrat Bold tam 17px
        bStart.setBackForeColors(Colors.COLOR_GREEN_BUTTON, Colors.COLOR_WHITE);
        bStart.setBorder(BORDER_ROUNDED);
		bStart.setDoEffect(false);
		bStart.addPressListener((c) -> {
            MainWindow.getMainWindow().swap(new ModbusView());
        });

        // Components in the screen
        add(icLogoTotalCross, CENTER, CENTER-MaterialConstants.GAP60);
        add(lInit, CENTER, AFTER);
        add(bStart, CENTER, AFTER+MaterialConstants.GAP45, SCREENSIZE+MaterialConstants.GAP10, SCREENSIZE+MaterialConstants.GAP5);
    }
}
