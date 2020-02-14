package com.totalcross.view;

import com.totalcross.view.components.Circle;

import totalcross.ui.Container;
import totalcross.ui.event.ControlEvent;
import totalcross.ui.event.PressListener;
import totalcross.ui.gfx.Color;
import totalcross.util.UnitsConverter;

public class DigitalInputView extends SideMenuContainerView {

    Circle circle1;
    boolean circle1On;
    Circle circle2;


    public DigitalInputView() {
        setBackColor(Color.getRGB("1A1A1A"));
        circle1 = new Circle(Color.getRGB("12D50B"));
        circle1.addPressListener(new PressListener(){
            @Override
            public void controlPressed(ControlEvent e) {
                if(!circle1On) {
                    circle2.setColor(Color.getRGB("FFFFFF"));
                    circle1.setColor(Color.getRGB("12D50B"));
                    circle1On = !circle1On;
                }
            }
        });
        circle2 = new Circle(Color.getRGB("FFFFFF"));
        circle2.addPressListener(new PressListener(){
            @Override
            public void controlPressed(ControlEvent e) {
                if(circle1On) {
                    circle1.setColor(Color.getRGB("FFFFFF"));
                    circle2.setColor(Color.getRGB("D8E51D"));
                    circle1On = !circle1On;
                }
            }
        });
        circle1On = true;
    
    }


    @Override
    public void onView(Container content) {
        content.add(circle1, CENTER - UnitsConverter.toPixels(DP + 67), CENTER, DP + 90, DP + 90);
        content.add(circle2, CENTER + UnitsConverter.toPixels(DP + 68), CENTER, DP + 90, DP + 90);
    }
}