package com.domain;

import com.GameWin;
import com.utils.GameUtils;

import java.awt.*;

public class SuperBoss extends GameObj{
    private static int HP = 30;
    public SuperBoss() {
        super();
    }

    public SuperBoss(Image img, int width, int height, int x, int y, double speed, GameWin frame) {
        super(img, width, height, x, y, speed, frame);
    }

    public SuperBoss(Image img, int x, int y, double speed) {
        super(img, x, y, speed);
    }

    public SuperBoss(int x, int y) {
        super(x, y);
    }

    @Override
    public void paintSelf(Graphics gImage) {
        super.paintSelf(gImage);
        if (y < 40) {
            y += speed;
        }else {
            x += speed;
            if (x < 0 || x > 360) {
                speed = -speed;
            }
        }

        // 我方一级子弹和boss进行碰撞检测
        for (Bullet bullet : GameUtils.heroBulletList) {
            if (this.getRec().intersects(bullet.getRec()) && HP > 0) {
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
                bullet.setX(-100);
                bullet.setY(-100);
                GameUtils.removeObjs.add(bullet);
                this.x = -111;
                this.y = -111;
                GameUtils.removeObjs.add(this);
                GameWin.score += 30;
                GameWin.state = 4;
            }
        }
        // 二级子弹
        for (SecondaryBullet bullet : GameUtils.secondaryBulletList) {
            if (this.getRec().intersects(bullet.getRec()) && HP > 0) {
                bullet.setX(-100);
                bullet.setY(-100);
                GameUtils.removeObjs.add(bullet);
                HP-=3;
            }else if (this.getRec().intersects(bullet.getRec()) && HP <= 1){
                // 创建爆炸对象，产生爆炸效果
                Boom boom = new Boom(x, y);
                GameUtils.booms.add(boom);
                GameUtils.removeObjs.add(boom);

                bullet.setX(-100);
                bullet.setY(-100);
                GameUtils.removeObjs.add(bullet);
                this.x = -111;
                this.y = -111;
                GameUtils.removeObjs.add(this);
                GameWin.score += 30;
                GameWin.state = 4;
            }
        }
        // 白色矩形
        gImage.setColor(Color.WHITE);
        gImage.fillRect(200, 40, 200, 10);
        // 红色矩形
        gImage.setColor(Color.RED);
        gImage.fillRect(200, 40, HP * 200 / 30, 10);

        if (HP == 26) {
            img = GameUtils.SuperBossDown1;
        }else if (HP == 21) {
            img = GameUtils.SuperBossDown2;
        }else if (HP == 17) {
            img = GameUtils.SuperBossDown3;
        }else if (HP == 12) {
            img = GameUtils.SuperBossDown4;
        }else if (HP == 8) {
            img = GameUtils.SuperBossDown5;
        }else if (HP == 4) {
            img = GameUtils.SuperBossDown6;
        }
    }

    @Override
    public Rectangle getRec() {
        return super.getRec();
    }
}
