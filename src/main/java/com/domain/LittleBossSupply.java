package com.domain;

import com.GameWin;
import com.utils.GameUtils;

import java.awt.*;

public class LittleBossSupply extends GameObj{
    public LittleBossSupply() {
        super();
    }

    public LittleBossSupply(Image img, int width, int height, int x, int y, double speed, GameWin frame) {
        super(img, width, height, x, y, speed, frame);
    }

    public LittleBossSupply(Image img, int x, int y, double speed) {
        super(img, x, y, speed);
    }

    public LittleBossSupply(int x, int y) {
        super(x, y);
    }

    @Override
    public void paintSelf(Graphics gImage) {
        super.img = GameUtils.littleBossSupply;
        super.width = 61;
        super.height = 58;
        super.paintSelf(gImage);
    }

    @Override
    public Rectangle getRec() {
        return super.getRec();
    }
}
