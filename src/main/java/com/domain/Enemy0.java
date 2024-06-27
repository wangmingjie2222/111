package com.domain;

import com.GameWin;
import com.utils.GameUtils;

import java.awt.*;

public class Enemy0 extends GameObj{
    public Enemy0() {
        super();
    }

    public Enemy0(Image img, int width, int height, int x, int y, double speed, GameWin frame) {
        super(img, width, height, x, y, speed, frame);
    }

    public Enemy0(Image img, int x, int y, double speed) {
        super(img, x, y, speed);
    }

    @Override
    public void paintSelf(Graphics gImage) {
        super.paintSelf(gImage);
        y += speed;
        // 检测碰撞 一级子弹
        for (Bullet bullet : GameUtils.heroBulletList) {
            if (this.getRec().intersects(bullet.getRec())) {
                // 创建爆炸对象，产生爆炸效果
                Boom boom = new Boom(x, y);
                GameUtils.booms.add(boom);
                GameUtils.removeObjs.add(boom);

                bullet.setX(-100);
                bullet.setY(-100);
                this.x = -111;
                this.y = -111;
                GameUtils.removeObjs.add(bullet);
                GameUtils.removeObjs.add(this);
                GameWin.score += 1;
            }
        }
        // 二级子弹
        for (SecondaryBullet bullet : GameUtils.secondaryBulletList) {
            if (this.getRec().intersects(bullet.getRec())) {
                // 创建爆炸对象，产生爆炸效果
                Boom boom = new Boom(x, y);
                GameUtils.booms.add(boom);
                GameUtils.removeObjs.add(boom);

                bullet.setX(-100);
                bullet.setY(-100);
                this.x = -111;
                this.y = -111;
                GameUtils.removeObjs.add(bullet);
                GameUtils.removeObjs.add(this);
                GameWin.score += 1;
            }
        }
    }

    @Override
    public Rectangle getRec() {
        return super.getRec();
    }
}
