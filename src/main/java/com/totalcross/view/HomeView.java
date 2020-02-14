package com.totalcross.view;

import com.totalcross.util.*;

import totalcross.ui.Label;
import totalcross.ui.Button;
import totalcross.ui.Container;
import totalcross.ui.ImageControl;

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


        // Components in the screen
        add(icLogoTotalCross, CENTER, CENTER-MaterialConstants.GAP60);
        add(lInit, CENTER, AFTER);
        add(bStart, CENTER, AFTER+MaterialConstants.GAP45, SCREENSIZE+MaterialConstants.GAP10, SCREENSIZE+MaterialConstants.GAP5);

    }
}
