package com.domain;

import com.GameWin;

import java.awt.*;

public class BgObj extends GameObj{
    public BgObj() {
        super();
    }

    public BgObj(Image img, int width, int height, int x, int y, double speed, GameWin frame) {
        super(img, width, height, x, y, speed, frame);
    }

    public BgObj(Image img, int x, int y, double speed) {
        super(img, x, y, speed);
    }

    @Override
    public void paintSelf(Graphics gImage) {
        super.paintSelf(gImage);
        y += speed;
        if (y > 0) {
            y = 0;
        }
    }

    @Override
    public Rectangle getRec() {
        return super.getRec();
    }
}
