package com.totalcross;

import com.totalcross.view.*;
import com.totalcross.util.Images;
import com.totalcross.util.Colors;
import com.totalcross.util.Fonts;

import totalcross.ui.MainWindow;
import totalcross.ui.SideMenuContainer;
import totalcross.sys.Settings;

public class NovusApp extends MainWindow {
    SideMenuContainer sideMenu;
    
    public NovusApp() {
        setUIStyle(Settings.MATERIAL_UI);
        setBackColor(Colors.COLOR_BLACK);
    }

    @Override
    public void initUI() {
        // Initializing the images.
        Images.loadImages();
        // Initializing the fonts.
        Fonts.loadFonts();

        swap(new HomeView());
    }
}
