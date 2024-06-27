package com.domain;

import com.GameWin;

import java.awt.*;

public class Bullet extends GameObj {
    public Bullet() {
        super();
    }

    public Bullet(Image img, int width, int height, int x, int y, double speed, GameWin frame) {
        super(img, width, height, x, y, speed, frame);
    }

    public Bullet(Image img, int x, int y, double speed) {
        super(img, x, y, speed);
    }

    @Override
    public void paintSelf(Graphics gImage) {
        super.paintSelf(gImage);
        // 实现子弹的移动
        y -= speed;
    }

    @Override
    public Rectangle getRec() {
        return super.getRec();
    }
}
