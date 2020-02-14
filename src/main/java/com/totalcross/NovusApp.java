package com.totalcross;

import com.totalcross.view.*;
import com.totalcross.util.Images;
import com.totalcross.util.Colors;
import com.totalcross.util.Fonts;

import totalcross.ui.MainWindow;
import totalcross.ui.SideMenuContainer;
import totalcross.ui.icon.MaterialIcons;
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
		// Fonts.loadFonts();
		// Setting the screen font as the initialized font
        // MainWindow.setDefaultFont(Fonts.MontserratRegular12);
        

        SideMenuContainer.Item home = new SideMenuContainer.Item("Home", MaterialIcons._HOME, Colors.COLOR_RED, ()-> {return new HomeView();});
        SideMenuContainer.Item tela1 = new SideMenuContainer.Item("Grafics", MaterialIcons._HOME, Colors.COLOR_RED, ()-> {return new AnalogInputView();});
        SideMenuContainer.Item tela2 = new SideMenuContainer.Item("Infos", MaterialIcons._HOME, Colors.COLOR_RED, ()-> {return new ModbusView();});
        SideMenuContainer.Item tela3 = new SideMenuContainer.Item("Grafic", MaterialIcons._HOME, Colors.COLOR_RED, ()-> {return new AnalogOutView();});
        SideMenuContainer.Item tela4 = new SideMenuContainer.Item("Buttons", MaterialIcons._HOME, Colors.COLOR_RED, ()-> {return new DigitalInputView();});

        sideMenu = new SideMenuContainer(null, home, tela1, tela2, tela3, tela4);

        sideMenu.setBackColor(Colors.COLOR_BLACK);
        sideMenu.setForeColor(Colors.COLOR_BLACK);
        sideMenu.setItemForeColor(Colors.COLOR_BLACK);
        sideMenu.topMenu.drawSeparators = false;

        //add(icon, CENTER, TOP);
        add(sideMenu, LEFT, TOP, PARENTSIZE, PARENTSIZE);
        // Swapping to the container responsible for showing the home screen.
        // swap(new HomeView());
        // swap(new ModbusView());
        // swap(new AnalogOutView());
    }
}
