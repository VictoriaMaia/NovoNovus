package com.totalcross.util;

import totalcross.sys.Settings;
import totalcross.ui.Control;
import totalcross.ui.dialog.MessageBox;
import totalcross.ui.image.Image;
import totalcross.util.UnitsConverter;

public class Images {
	// Declaring the variables.
	public static Image iTotalCrossLogoVertical, iTotalCrossLogoHorizontal;
	public static Image iModbusButton, iAnalogInputButton, iAnalogOutputButton, iDigitalInputButton, iHomeButton;

	static double scale015 = Settings.isIOS() ? 1 : 0.15;
	static double scale010 = Settings.isIOS() ? 1 : 0.13;
	
	public static void loadImages(){
		try {
			// Trying the initialize the variables.
            iTotalCrossLogoVertical = new Image("images/logo_oficial_vertical.png");
            iTotalCrossLogoVertical = iTotalCrossLogoVertical.scaledBy(scale015, scale015);	

            iTotalCrossLogoHorizontal = new Image("images/logo_oficial_horizontal_branca.png");
            iTotalCrossLogoHorizontal = iTotalCrossLogoHorizontal.scaledBy(scale010, scale010);
            iModbusButton = new Image("images/icone-01.png")
					.getScaledInstance(
							UnitsConverter.toPixels(Control.DP + 48),
							UnitsConverter.toPixels(Control.DP + 27)
					);
			iAnalogInputButton = new Image("images/icone-02.png")
					.getHwScaledInstance(
							UnitsConverter.toPixels(Control.DP + 38),
							UnitsConverter.toPixels(Control.DP + 27)
					);
			iAnalogOutputButton = new Image("images/icone-04.png")
					.getHwScaledInstance(
							UnitsConverter.toPixels(Control.DP + 30),
							UnitsConverter.toPixels(Control.DP + 26)
					);
			iDigitalInputButton = new Image("images/icone-03.png")
					.getHwScaledInstance(
							UnitsConverter.toPixels(Control.DP + 24),
							UnitsConverter.toPixels(Control.DP + 34)
					);
			iHomeButton = new Image("images/icone-05.png")
					.getHwScaledInstance(
							UnitsConverter.toPixels(Control.DP + 27),
							UnitsConverter.toPixels(Control.DP + 23)
					);


		} catch (Exception e) {
			MessageBox.showException(e, true);
		}	
	}
	
}