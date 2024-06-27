package com.domain;

import com.GameWin;

import java.awt.*;

public class SecondaryBullet extends GameObj{
    public SecondaryBullet() {
        super();
    }

    public SecondaryBullet(Image img, int width, int height, int x, int y, double speed, GameWin frame) {
        super(img, width, height, x, y, speed, frame);
    }

    public SecondaryBullet(Image img, int x, int y, double speed) {
        super(img, x, y, speed);
    }

    public SecondaryBullet(int x, int y) {
        super(x, y);
    }

    @Override
    public void paintSelf(Graphics gImage) {
        super.paintSelf(gImage);
        y -= speed;
    }

    @Override
    public Rectangle getRec() {
        return super.getRec();
    }
}
