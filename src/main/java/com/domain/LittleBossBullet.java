package com.domain;

import com.GameWin;

import java.awt.*;

public class LittleBossBullet extends GameObj{
    public LittleBossBullet() {
        super();
    }

    public LittleBossBullet(Image img, int width, int height, int x, int y, double speed, GameWin frame) {
        super(img, width, height, x, y, speed, frame);
    }

    public LittleBossBullet(Image img, int x, int y, double speed) {
        super(img, x, y, speed);
    }

    public LittleBossBullet(int x, int y) {
        super(x, y);
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
