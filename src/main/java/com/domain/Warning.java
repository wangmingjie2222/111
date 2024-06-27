package com.domain;

import com.GameWin;

import java.awt.*;

public class Warning extends GameObj {
    public Warning() {
        super();
    }

    public Warning(Image img, int width, int height, int x, int y, double speed, GameWin frame) {
        super(img, width, height, x, y, speed, frame);
    }

    public Warning(Image img, int x, int y, double speed) {
        super(img, x, y, speed);
    }

    public Warning(int x, int y) {
        super(x, y);
    }

    @Override
    public void paintSelf(Graphics gImage) {
        super.paintSelf(gImage);
    }
}
