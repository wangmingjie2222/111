package com.domain;

import com.GameWin;
import com.utils.GameUtils;

import java.awt.*;

public class bloodSupply extends GameObj{

    public bloodSupply() {
        super();
    }

    public bloodSupply(Image img, int width, int height, int x, int y, double speed, GameWin frame) {
        super(img, width, height, x, y, speed, frame);
    }

    public bloodSupply(Image img, int x, int y, double speed) {
        super(img, x, y, speed);
    }

    public bloodSupply(int x, int y) {
        super(x, y);
    }

    @Override
    public void paintSelf(Graphics gImage) {
        super.paintSelf(gImage);
        y += speed;

        for (Bullet bullet : GameUtils.heroBulletList) {
            if (this.getRec().intersects(bullet.getRec()) && Plane.HP < 3) {
                this.setX(-100);
                this.setY(-100);
                bullet.x = -111;
                bullet.y = -111;
                Plane.HP++;
                GameUtils.removeObjs.add(bullet);
                GameUtils.removeObjs.add(this);
            }
        }
    }

    @Override
    public Rectangle getRec() {
        return super.getRec();
    }
}
