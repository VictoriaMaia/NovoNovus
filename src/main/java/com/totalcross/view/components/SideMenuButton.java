package com.totalcross.view.components;

import com.totalcross.util.Colors;
import com.totalcross.util.Fonts;
import sun.tools.jconsole.Plotter;
import totalcross.ui.Button;
import totalcross.ui.Control;
import totalcross.ui.gfx.Color;
import totalcross.ui.gfx.Graphics;
import totalcross.ui.image.Image;
import totalcross.util.UnitsConverter;

public class SideMenuButton extends Button {
    Image image;
    String text;

    public SideMenuButton (String text, Image image) {
        setBackColor(0x373737);
        this.text = text;
        this.image = image;
        transparentBackground = true;
        setFont(Fonts.MontserratLight7);
        setForeColor(Colors.COLOR_WHITE);
    }

    @Override
    public int getPreferredWidth() {
        return UnitsConverter.toPixels(DP + 104);
    }

    @Override
    public int getPreferredHeight() {
        return UnitsConverter.toPixels(DP + 93);
    }

    @Override
    public void onPaint(Graphics g) {
        super.onPaint(g);
        int imgWidth = image.getWidth();
        int imgHeight = image.getHeight();
        int imgY = UnitsConverter.toPixels(DP + 26);
        g.drawImage(image, (getWidth()- imgWidth)/2, imgY);
        g.foreColor= Colors.COLOR_WHITE;
        g.drawText(
                text,
                (getWidth() - font.fm.stringWidth(text))/2,
                imgY + imgHeight + UnitsConverter.toPixels(DP + 9)
        );
    }
}
