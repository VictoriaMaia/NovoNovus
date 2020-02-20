package com.totalcross.view.components;

import com.totalcross.util.Colors;
import com.totalcross.util.Fonts;
import com.totalcross.util.Images;
import com.totalcross.view.*;

import totalcross.sys.Settings;
import totalcross.ui.Check;
import totalcross.ui.Container;
import totalcross.ui.Label;
import totalcross.ui.MainWindow;
import totalcross.ui.event.ControlEvent;
import totalcross.ui.event.Event;
import totalcross.ui.event.EventHandler;
import totalcross.ui.event.EventType;
import totalcross.ui.event.PressListener;
import totalcross.ui.event.UpdateListener;
import totalcross.ui.gfx.Color;
import totalcross.ui.image.Image;
import totalcross.util.UnitsConverter;

import java.util.ArrayList;

public class SideButtons extends Container {
    ArrayList<SideMenuButton> buttons = new ArrayList<SideMenuButton>();
    private Label lPresentaionMode = new Label("PRESENTATION\nMODE", CENTER);

    static int count;
    static int time;
    static boolean animate = false;
    static Check check = new Check();
    
    static UpdateListener updateListener = new UpdateListener(){
        
        @Override
        public void updateListenerTriggered(int elapsedMilliseconds) {
            if(animate) {
                time += elapsedMilliseconds;
                if(time > 15000) {
                    time = 0;
                    switch(count) {
                        case 0:
                        MainWindow.getMainWindow().swap(new AnalogInputView());
                        break;
                        case 1:
                        MainWindow.getMainWindow().swap(new ModbusView());
                        break;
                        case 2:
                        MainWindow.getMainWindow().swap(new AnalogOutView());
                        break;
                        case 3:
                        MainWindow.getMainWindow().swap(new DigitalInputView());
                        break;
                    }
                    count = (count + 1) % 5;
            }
        }
        }
    };


    public SideButtons() {
        backColor = Color.BLACK;
    
        check.setForeColor(Colors.COLOR_GREEN_BUTTON);
        check.transparentBackground = true;

        lPresentaionMode.setForeColor(Colors.COLOR_GREEN_BUTTON);
        lPresentaionMode.setFont(Fonts.MontserratLight7);
        lPresentaionMode.transparentBackground = true;


        MainWindow.getMainWindow().addUpdateListener(updateListener);
        
    }

    @Override
    public void initUI() {
        addButton("ANALOG INPUT", Images.iAnalogInputButton, new PressListener(){
            @Override
            public void controlPressed(ControlEvent e) {
                MainWindow.getMainWindow().swap(new AnalogInputView());
            }
        });
        addButton("MODBUS", Images.iModbusButton, new PressListener(){

            @Override
            public void controlPressed(ControlEvent e) {
                MainWindow.getMainWindow().swap(new ModbusView());
            }
        });
        addButton("ANALOG OUTPUT", Images.iAnalogOutputButton,new PressListener(){
            @Override
            public void controlPressed(ControlEvent e) {
                MainWindow.getMainWindow().swap(new AnalogOutView());
            }
        });
        addButton("DIGITAL INPUT", Images.iDigitalInputButton, new PressListener(){
            @Override
            public void controlPressed(ControlEvent e) {
                MainWindow.getMainWindow().swap(new DigitalInputView());
            }
        });
        addButton(" ", Images.iHomeButton, new PressListener(){
            @Override
            public void controlPressed(ControlEvent e) {
                MainWindow.getMainWindow().swap(new HomeView());
            }
        });

        add(check, LEFT+UnitsConverter.toPixels(DP + 40), BOTTOM - UnitsConverter.toPixels(DP + 30));
        add(lPresentaionMode, LEFT+UnitsConverter.toPixels(DP + 20), AFTER);
    }

    public void addButton(String text, Image image, PressListener pressListener) {
        SideMenuButton button = new SideMenuButton(text, image);
        button.addPressListener(pressListener);
        add(button, LEFT, AFTER, PARENTSIZE, PREFERRED);
        buttons.add(button);

    }

    @Override
    public <H extends EventHandler> void onEvent(Event<H> event) {
        if(event.type == EventType.PRESSED && event.target instanceof SideMenuButton) {
            for (SideMenuButton sideMenuButton:
                 buttons) {
                sideMenuButton.transparentBackground = true;
                sideMenuButton.repaintNow();
            }
            SideMenuButton smb = (SideMenuButton) event.target;
            smb.transparentBackground = false;
            smb.repaintNow();

         }

        
        if (event.target == check && (!Settings.fingerTouch || !hadParentScrolled()) ) {
            animate = check.isChecked();
        }
    }
}