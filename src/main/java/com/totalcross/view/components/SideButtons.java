package com.totalcross.view.components;

import com.totalcross.util.Colors;
import com.totalcross.util.Images;
import com.totalcross.view.*;
import totalcross.ui.Container;
import totalcross.ui.MainWindow;
import totalcross.ui.event.ControlEvent;
import totalcross.ui.event.Event;
import totalcross.ui.event.EventHandler;
import totalcross.ui.event.EventType;
import totalcross.ui.event.PressListener;
import totalcross.ui.gfx.Color;
import totalcross.ui.image.Image;

import java.util.ArrayList;

public class SideButtons extends Container {

    ArrayList<SideMenuButton> buttons = new ArrayList<SideMenuButton>();

    public SideButtons() {
        backColor = Color.BLACK;
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
    }
}