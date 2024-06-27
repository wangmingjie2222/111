package com.domain;

import com.GameWin;
import com.utils.GameUtils;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Plane extends GameObj{
    LittleBoss littleBoss = new LittleBoss();

    public static int HP = 3;

    // 获得补给数量
    public int nums = 0;

    public Plane() {
        super();
    }

    public Plane(Image img, int width, int height, int x, int y, double speed, GameWin frame) {
        super(img, width, height, x, y, speed, frame);
        // 添加鼠标的移动事件
        this.frame.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                Plane.super.x = e.getX() - 50;
                Plane.super.y = e.getY() - 33;
            }
        });
    }

    public Plane(Image img, int x, int y, double speed) {
        super(img, x, y, speed);
    }

    @Override
    public void paintSelf(Graphics gImage) {
        super.paintSelf(gImage);
        // 检测碰撞
        // 我方飞机 和 敌方飞机0
        for (Enemy0 enemy0 : GameUtils.enemy0List) {
            if (this.getRec().intersects(enemy0.getRec()) && HP > 1) {
                enemy0.setX(-100);
                enemy0.setY(-100);
                GameUtils.removeObjs.add(enemy0);
                HP--;
            } else if (this.getRec().intersects(enemy0.getRec()) && HP <= 1) {
                // 创建爆炸对象，产生爆炸效果
                Boom boom = new Boom(x, y);
                GameUtils.booms.add(boom);
                GameUtils.removeObjs.add(boom);

                // 碰撞后把坐标移到第三象限就可以
                enemy0.setX(-100);
                enemy0.setX(-100);
                this.x = -111;
                this.y = -111;
                GameUtils.removeObjs.add(enemy0);
                GameUtils.removeObjs.add(this);
                GameWin.state = 3;
            }
        }
        // 我方飞机 和 敌方飞机1
        for (Enemy1 enemy1 : GameUtils.enemy1List) {
            if (this.getRec().intersects(enemy1.getRec()) && HP > 1) {
                enemy1.setX(-100);
                enemy1.setY(-100);
                GameUtils.removeObjs.add(enemy1);
                HP--;
            } else if (this.getRec().intersects(enemy1.getRec()) && HP <= 1) {
                // 创建爆炸对象，产生爆炸效果
                Boom boom = new Boom(x, y);
                GameUtils.booms.add(boom);
                GameUtils.removeObjs.add(boom);

                // 碰撞后把坐标移到第三象限就可以
                enemy1.setX(-100);
                enemy1.setX(-100);
                this.x = -111;
                this.y = -111;
                GameUtils.removeObjs.add(enemy1);
                GameUtils.removeObjs.add(this);
                GameWin.state = 3;
            }
        }
        // 我方飞机 和 敌方飞机1子弹
        for (Enemy1Bullet enemy1Bullet : GameUtils.enemy1BulletList) {
            if (this.getRec().intersects(enemy1Bullet.getRec()) && HP > 1) {
                enemy1Bullet.setX(-100);
                enemy1Bullet.setY(-100);
                GameUtils.removeObjs.add(enemy1Bullet);
                HP--;
            } else if (this.getRec().intersects(enemy1Bullet.getRec()) && HP <= 1) {
                // 创建爆炸对象，产生爆炸效果
                Boom boom = new Boom(x, y);
                GameUtils.booms.add(boom);
                GameUtils.removeObjs.add(boom);

                // 碰撞后把坐标移到第三象限就可以
                enemy1Bullet.setX(-100);
                enemy1Bullet.setX(-100);
                this.x = -111;
                this.y = -111;
                GameUtils.removeObjs.add(enemy1Bullet);
                GameUtils.removeObjs.add(this);
                GameWin.state = 3;
            }
        }

        // 敌方boss 和 我方飞机 碰撞 但敌方飞机不会消失
        if (this.getRec().intersects(littleBoss.getRec()) && HP > 1) {
            HP--;
        } else if (this.getRec().intersects(littleBoss.getRec()) && HP <= 1) {
            // 创建爆炸对象，产生爆炸效果
            Boom boom = new Boom(x, y);
            GameUtils.booms.add(boom);
            GameUtils.removeObjs.add(boom);

            this.x = -111;
            this.y = -111;
            GameUtils.removeObjs.add(this);
            GameWin.state = 3;
        }
        // 敌方boss左边子弹 和 我方飞机
        for (LittleBossBullet littleBossBullet : GameUtils.littleBossBulletLeftList) {
            if (this.getRec().intersects(littleBossBullet.getRec()) && HP > 1) {
                littleBossBullet.setX(-100);
                littleBossBullet.setY(-100);
                GameUtils.removeObjs.add(littleBossBullet);
                HP--;
            } else if (this.getRec().intersects(littleBossBullet.getRec()) && HP <= 1) {
                // 创建爆炸对象，产生爆炸效果
                Boom boom = new Boom(x, y);
                GameUtils.booms.add(boom);
                GameUtils.removeObjs.add(boom);

                littleBossBullet.setX(-100);
                littleBossBullet.setY(-100);
                GameUtils.removeObjs.add(littleBossBullet);
                this.x = -111;
                this.y = -111;
                GameUtils.removeObjs.add(this);
                GameWin.state = 3;
            }
        }

        // 敌方boss右边子弹 和 我方飞机
        for (LittleBossBullet littleBossBullet : GameUtils.littleBossBulletRightList) {
            if (this.getRec().intersects(littleBossBullet.getRec()) && HP > 1) {
                littleBossBullet.setX(-100);
                littleBossBullet.setY(-100);
                GameUtils.removeObjs.add(littleBossBullet);
                HP--;
            } else if (this.getRec().intersects(littleBossBullet.getRec()) && HP <= 1) {
                // 创建爆炸对象，产生爆炸效果
                Boom boom = new Boom(x, y);
                GameUtils.booms.add(boom);
                GameUtils.removeObjs.add(boom);

                littleBossBullet.setX(-100);
                littleBossBullet.setY(-100);
                GameUtils.removeObjs.add(littleBossBullet);
                this.x = -111;
                this.y = -111;
                GameUtils.removeObjs.add(this);
                GameWin.state = 3;
            }
        }

        // 敌方superBoss左边子弹 和 我方飞机
        for (SuperBossBullet bossBullet : GameUtils.SuperBossBulletLeftList) {
            if (this.getRec().intersects(bossBullet.getRec()) && HP > 1) {
                bossBullet.setX(-100);
                bossBullet.setY(-100);
                GameUtils.removeObjs.add(bossBullet);
                HP--;
            } else if (this.getRec().intersects(bossBullet.getRec()) && HP <= 1) {
                // 创建爆炸对象，产生爆炸效果
                Boom boom = new Boom(x, y);
                GameUtils.booms.add(boom);
                GameUtils.removeObjs.add(boom);

                bossBullet.setX(-100);
                bossBullet.setY(-100);
                GameUtils.removeObjs.add(bossBullet);
                this.x = -111;
                this.y = -111;
                GameUtils.removeObjs.add(this);
                GameWin.state = 3;
            }
        }

        // 敌方superBoss右边子弹 和 我方飞机
        for (SuperBossBullet bossBullet : GameUtils.SuperBossBulletRightList) {
            if (this.getRec().intersects(bossBullet.getRec()) && HP > 1) {
                bossBullet.setX(-100);
                bossBullet.setY(-100);
                GameUtils.removeObjs.add(bossBullet);
                HP--;
            } else if (this.getRec().intersects(bossBullet.getRec()) && HP <= 1) {
                // 创建爆炸对象，产生爆炸效果
                Boom boom = new Boom(x, y);
                GameUtils.booms.add(boom);
                GameUtils.removeObjs.add(boom);

                bossBullet.setX(-100);
                bossBullet.setY(-100);
                GameUtils.removeObjs.add(bossBullet);
                this.x = -111;
                this.y = -111;
                GameUtils.removeObjs.add(this);
                GameWin.state = 3;
            }
        }

        // 我方飞机 和 补给 补给消失，飞机不消失
        for (LittleBossSupply supply : GameUtils.littleBossSupplyList) {
            if (this.getRec().intersects(supply.getRec())) {
                supply.setX(-100);
                supply.setY(-100);
                GameUtils.removeObjs.add(supply);
                nums++;
            }
        }

        // 我方飞机血量
        for (bloodSupply bloodSupply : GameUtils.bloodSupplyList) {
            if (this.getRec().intersects(bloodSupply.getRec()) && HP < 3) {
                bloodSupply.setX(-100);
                bloodSupply.setY(-100);
                GameUtils.removeObjs.add(bloodSupply);
                HP++;
            }
        }

        // 白色矩形
        gImage.setColor(Color.WHITE);
        gImage.fillRect(260, 770, 90, 10);
        // 红色矩形
        gImage.setColor(Color.RED);
        gImage.fillRect(260, 770, HP * 90 / 3, 10);
    }

    @Override
    public Rectangle getRec() {
        return super.getRec();
    }
}
