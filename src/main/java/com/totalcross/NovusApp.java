package com.totalcross;

import com.totalcross.view.*;
import com.totalcross.util.Images;
import com.totalcross.util.Colors;
import com.totalcross.util.Fonts;

import totalcross.ui.MainWindow;
import totalcross.sys.Settings;

public class NovusApp extends MainWindow {
    
    public NovusApp() {
        setUIStyle(Settings.MATERIAL_UI);
        setBackColor(Colors.COLOR_BLACK);
    }

    @Override
    public void initUI() {
        // Initializing the images.
        Images.loadImages();
        // Initializing the fonts.
		// Fonts.loadFonts();
		// Setting the screen font as the initialized font
		// MainWindow.setDefaultFont(Fonts.MontserratRegular12);

        // Swapping to the container responsible for showing the home screen.
        // swap(new HomeView());
        swap(new ModbusView());
        // swap(new AnalogOutView());
    }
}
