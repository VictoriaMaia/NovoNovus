package com.totalcross.view;

import com.totalcross.util.Colors;
import com.totalcross.view.components.SideButtons;
import totalcross.ui.Container;
import totalcross.util.UnitsConverter;

public abstract class SideMenuContainerView extends Container {

    private Container content = new Container();
    static private SideButtons sideButtons = new SideButtons();

    public SideMenuContainerView() {

    }

    @Override
    public void initUI() {
        content.setBackColor(Colors.COLOR_BLACK);
        add(sideButtons, LEFT, TOP, UnitsConverter.toPixels(DP + 104), PARENTSIZE);
        add(content, AFTER, TOP, FILL, PARENTSIZE);
        onView(content);
    }

    public abstract void onView(Container content);

}

