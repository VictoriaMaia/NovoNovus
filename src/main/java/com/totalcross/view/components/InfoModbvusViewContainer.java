package com.totalcross.view.components;

import com.totalcross.util.Fonts;
import com.totalcross.util.MaterialConstants;

import totalcross.ui.Container;
import totalcross.ui.Label;

public class InfoModbvusViewContainer extends Container {
    private String sTitle;
    private String sInfo;
    private Label lTitle;
    private Label lInfo;
    private int color;

    public InfoModbvusViewContainer(String sTitle, String sInfo, int color){
        this.sTitle = sTitle;
        this.sInfo = sInfo;
        this.color = color;
    }

    public void initUI(){
        setBorderStyle(BORDER_ROUNDED);
        borderColor = color; 
        setBackColor(color);

        lTitle = new Label(sTitle);
        // lTitle.setFont(Fonts.MontserratRegular12);

        lInfo = new Label(sInfo);
        // lInfo.setFont(Fonts.MontserratSemiBold12);

        add(lTitle, CENTER, TOP+MaterialConstants.GAP4);
        add(lInfo, CENTER, AFTER);


    }
}