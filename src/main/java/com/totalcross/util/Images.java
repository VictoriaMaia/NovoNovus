package com.totalcross.util;

import totalcross.sys.Settings;
import totalcross.ui.dialog.MessageBox;
import totalcross.ui.image.Image;

public class Images {
	// Declaring the variables.
	public static Image iTotalCrossLogoVertical, iTotalCrossLogoHorizontal;

	static double scale015 = Settings.isIOS() ? 1 : 0.15;
	static double scale010 = Settings.isIOS() ? 1 : 0.13;
	
	public static void loadImages(){
		try {
			// Trying the initialize the variables.
            iTotalCrossLogoVertical = new Image("images/logo_oficial_vertical.png");
            iTotalCrossLogoVertical = iTotalCrossLogoVertical.scaledBy(scale015, scale015);	

            iTotalCrossLogoHorizontal = new Image("images/logo_oficial_horizontal_branca.png");
            iTotalCrossLogoHorizontal = iTotalCrossLogoHorizontal.scaledBy(scale010, scale010);	


		} catch (Exception e) {
			MessageBox.showException(e, true);
		}	
	}
	
}