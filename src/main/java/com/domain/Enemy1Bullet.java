package com.domain;

import com.GameWin;

import java.awt.*;

public class Enemy1Bullet extends GameObj{
    public Enemy1Bullet() {
        super();
    }

    public Enemy1Bullet(Image img, int width, int height, int x, int y, double speed, GameWin frame) {
        super(img, width, height, x, y, speed, frame);
    }

    public Enemy1Bullet(Image img, int x, int y, double speed) {
        super(img, x, y, speed);
    }

    @Override
    public void paintSelf(Graphics gImage) {
        super.paintSelf(gImage);
        y += speed;
    }

    @Override
    public Rectangle getRec() {
        return super.getRec();
    }
}
