package com.totalcross.view;

import com.totalcross.util.*;
import com.totalcross.view.components.InfoModbvusViewContainer;

import totalcross.ui.Button;
import totalcross.ui.Container;
import totalcross.ui.ImageControl;
import totalcross.ui.Label;
import totalcross.util.UnitsConverter;

public class ModbusView extends SideMenuContainerView{
    // Declaring the variables.
    Label lTitle;
    Label lSubTitle;
    Button bConnect;
    ImageControl icLogo;
    InfoModbvusViewContainer infoTemperature;
    InfoModbvusViewContainer infoRelativeHumidy;
    InfoModbvusViewContainer infoWetBTemperature;
    InfoModbvusViewContainer infoDewPoin;

    @Override
    public void onView(Container content) {
        // Initializing the variables.

        // IMAGE CONTROLL

        icLogo = new ImageControl(Images.iTotalCrossLogoHorizontal);
        icLogo.scaleToFit = true;

        // LABEL

        lTitle = new Label("MODBUS");
         lTitle.setFont(Fonts.MontserratExtraBold24);
        lTitle.setForeColor(Colors.COLOR_WHITE);

        lSubTitle = new Label("Simulated ModBus Device");
        lSubTitle.setForeColor(Colors.COLOR_WHITE);
        lSubTitle.setFont(Fonts.MontserratRegular20);

        // INFO MODBVUS VIEW CONTAINER
        infoTemperature = new InfoModbvusViewContainer("Temperature", "-6.92° C", Colors.COLOR_GREEN_TEMP);
        infoRelativeHumidy = new InfoModbvusViewContainer("Relative Humidity", "46.46 %", Colors.COLOR_BLUE_HUMIDITY);
        infoWetBTemperature = new InfoModbvusViewContainer("Wet Bulb Temperature", "-10.45° C", Colors.COLOR_GREEN_WBTEMP);
        infoDewPoin = new InfoModbvusViewContainer("Dew Point", "-2.56° C", Colors.COLOR_YELLOW);

        bConnect = new Button("Connect");
        bConnect.setFont(Fonts.MontserratRegular17);
        bConnect.setBackForeColors(Colors.COLOR_GREEN_BUTTON, Colors.COLOR_WHITE);
        bConnect.setBorder(BORDER_ROUNDED);
        bConnect.setDoEffect(false);


        // ADDING THE ELEMENTS IN SCREEN
        content.add(lTitle, CENTER, TOP+MaterialConstants.GAP55);

        content.add(lSubTitle, CENTER, AFTER+MaterialConstants.GAP20);

        content.add(bConnect, CENTER, AFTER+MaterialConstants.GAP70, SCREENSIZE+MaterialConstants.GAP10, SCREENSIZE+MaterialConstants.GAP5);

        content.add(infoRelativeHumidy, CENTER - UnitsConverter.toPixels(DP + 124), AFTER+MaterialConstants.GAP50, DP + 224, DP + 53);
        content.add(infoTemperature, CENTER + UnitsConverter.toPixels(DP + 124), SAME, DP + 224, DP + 53);

        content.add(infoWetBTemperature, CENTER - UnitsConverter.toPixels(DP + 124), AFTER+MaterialConstants.GAP30, DP + 224, DP + 53);
        content.add(infoDewPoin, CENTER + UnitsConverter.toPixels(DP + 124), SAME, DP + 224, DP + 53);

        content.add(icLogo, RIGHT-MaterialConstants.GAP55, TOP+MaterialConstants.GAP40);
    }
}