package com.totalcross.view;

import com.totalcross.util.*;
import com.totalcross.view.components.InfoModbvusViewContainer;

import totalcross.ui.Button;
import totalcross.ui.Container;
import totalcross.ui.ImageControl;
import totalcross.ui.Label;

public class ModbusView extends Container{
    // Declaring the variables.
    Label lTitle;
    Label lSubTitle;
    Button bConnect;
    ImageControl icLogo;
    InfoModbvusViewContainer infoTemperature;
    InfoModbvusViewContainer infoRelativeHumidy;
    InfoModbvusViewContainer infoWetBTemperature;
    InfoModbvusViewContainer infoDewPoin;

    public void initUI() {
        // Initializing the variables.
        
        // IMAGE CONTROLL
        
        icLogo = new ImageControl(Images.iTotalCrossLogoHorizontal);
        icLogo.scaleToFit = true;

        // LABEL
        
        lTitle = new Label("MODBUS");
        // lTitle.setFont(Fonts.MontserratExtraBolt24);
        // Montserrat Extra Bold tam 24px
        lTitle.setForeColor(Colors.COLOR_WHITE);

        lSubTitle = new Label("Simulated MobBus Device");
        // Montserrat Regular tam 20px
        lSubTitle.setForeColor(Colors.COLOR_WHITE);

        // INFO MODBVUS VIEW CONTAINER
        infoTemperature = new InfoModbvusViewContainer("Temperature", "-6.92° C", Colors.COLOR_GREEN_TEMP);
        infoRelativeHumidy = new InfoModbvusViewContainer("Relative Humidity", "46.46 %", Colors.COLOR_BLUE_HUMIDITY);
        infoWetBTemperature = new InfoModbvusViewContainer("Wet Bulb Temperature", "-10.45° C", Colors.COLOR_GREEN_WBTEMP);
        infoDewPoin = new InfoModbvusViewContainer("Dew Point", "-2.56° C", Colors.COLOR_YELLOW);

        bConnect = new Button("Connect");
        // bConnect.setFont(Fonts.MontserratRegular17);
        // Montserrat Regular tam 17px
        bConnect.setBackForeColors(Colors.COLOR_GREEN_BUTTON, Colors.COLOR_WHITE);
        bConnect.setBorder(BORDER_ROUNDED);
        bConnect.setDoEffect(false);


        // ADDING THE ELEMENTS IN SCREEN
        add(lTitle, CENTER, TOP+MaterialConstants.GAP55);
        
        add(lSubTitle, CENTER, AFTER+MaterialConstants.GAP20);
        
        add(bConnect, CENTER, AFTER+MaterialConstants.GAP70, SCREENSIZE+MaterialConstants.GAP10, SCREENSIZE+MaterialConstants.GAP5);
        
        add(infoRelativeHumidy, CENTER-MaterialConstants.GAP140, AFTER+MaterialConstants.GAP50, SCREENSIZE+MaterialConstants.GAP25, SCREENSIZE+MaterialConstants.GAP10);
        add(infoTemperature, CENTER+MaterialConstants.GAP150, SAME, SCREENSIZE+MaterialConstants.GAP25, SCREENSIZE+MaterialConstants.GAP10);
        
        add(infoWetBTemperature, CENTER-MaterialConstants.GAP140, AFTER+MaterialConstants.GAP30, SCREENSIZE+MaterialConstants.GAP25, SCREENSIZE+MaterialConstants.GAP10);
        add(infoDewPoin, CENTER+MaterialConstants.GAP150, SAME, SCREENSIZE+MaterialConstants.GAP25, SCREENSIZE+MaterialConstants.GAP10);

        add(icLogo, RIGHT-MaterialConstants.GAP55, TOP+MaterialConstants.GAP40);


    }
}