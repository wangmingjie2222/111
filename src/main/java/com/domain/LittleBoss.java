package com.domain;

import com.GameWin;
import com.utils.GameUtils;

import java.awt.*;

public class LittleBoss extends GameObj{
    // Boss血量
    int HP = 15;
    public LittleBoss() {
        super();
    }

    public LittleBoss(Image img, int width, int height, int x, int y, double speed, GameWin frame) {
        super(img, width, height, x, y, speed, frame);
    }

    public LittleBoss(Image img, int x, int y, double speed) {
        super(img, x, y, speed);
    }

    public LittleBoss(int x, int y) {
        super(x, y);
    }

    @Override
    public void paintSelf(Graphics gImage) {
        super.paintSelf(gImage);
        if (y < 100) {
            y += speed;
        }else {
            x += speed;
            if (x > 400 || x < 10) {
                speed = -speed;
            }
        }
        // 小boss的血量为0会消失，否则不会消失 一级子弹
        for (Bullet bullet : GameUtils.heroBulletList) {
            if (this.getRec().intersects(bullet.getRec()) && HP > 1) {
                bullet.setX(-100);
                bullet.setY(-100);
                GameUtils.removeObjs.add(bullet);
                HP--;
            }else if (this.getRec().intersects(bullet.getRec()) && HP <= 1){
                // 创建爆炸对象，产生爆炸效果
                Boom boom = new Boom(x, y);
                GameUtils.booms.add(boom);
                GameUtils.removeObjs.add(boom);
                // 当敌方小boss被击毁
                // 出现补给品
                LittleBossSupply supply = new LittleBossSupply(this.x, this.y);
                GameUtils.littleBossSupplyList.add(supply);
                GameUtils.gameObjs.addAll(GameUtils.littleBossSupplyList);

                bullet.setX(-100);
                bullet.setY(-100);
                GameUtils.removeObjs.add(bullet);
                this.x = -111;
                this.y = -111;
                GameUtils.removeObjs.add(this);
                GameWin.score += 10;
            }
        }
        // 二级子弹
        for (SecondaryBullet bullet : GameUtils.secondaryBulletList) {
            if (this.getRec().intersects(bullet.getRec()) && HP > 1) {
                bullet.setX(-100);
                bullet.setY(-100);
                GameUtils.removeObjs.add(bullet);
                HP-=3;
            }else if (this.getRec().intersects(bullet.getRec()) && HP <= 1){
                // 创建爆炸对象，产生爆炸效果
                Boom boom = new Boom(x, y);
                GameUtils.booms.add(boom);
                GameUtils.removeObjs.add(boom);
                // 当敌方小boss被击毁
                // 出现补给品
                LittleBossSupply supply = new LittleBossSupply(this.x, this.y);
                GameUtils.littleBossSupplyList.add(supply);
                GameUtils.gameObjs.addAll(GameUtils.littleBossSupplyList);

                bullet.setX(-100);
                bullet.setY(-100);
                GameUtils.removeObjs.add(bullet);
                this.x = -111;
                this.y = -111;
                GameUtils.removeObjs.add(this);
                GameWin.score += 10;
            }
        }
    }

    @Override
    public Rectangle getRec() {
        return super.getRec();
    }
}
