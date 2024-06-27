package com;

import com.domain.*;
import com.service.UserService;
import com.utils.GameUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class GameWin extends JFrame {

    /*
    * 设置游戏状态
    *   1：游戏中
    *   2：暂停
    *   3：失败
    *   4：通关
    * */
    public static int state = 1;

    // 定义图片变量
    Image cacheImage = null;

    // 背景图片
    BgObj map0 = new BgObj(GameUtils.map0Img, 0, -100, 1);
    // 我方飞机
    Plane plane = new Plane(GameUtils.heroImg, 100, 66, 290, 550, 0, this);

    // 小Boss
    LittleBoss littleBoss = new LittleBoss(GameUtils.littleBoss, 200, 140, 200, -300, 5, this);

    // 最终boss
    SuperBoss superBoss = new SuperBoss(GameUtils.SuperBoss, 200, 302, 200, -300, 3, this);

    // 警示标志
    Warning warning = new Warning(GameUtils.warn, 243, 252, 0, 150, 0, this);

    // 绘制次数
    int count = 1;

    // 积分
    public static int score = 0;

    private UserService userService = new UserService();

    public GameWin() {
        // 设置窗口大小
        this.setSize(600, 800);
        // 设置窗口位置
        this.setLocationRelativeTo(null);
        // 设置窗口标题
        this.setTitle("飞机大战");
        // 关闭窗口自动结束进程
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 键盘监听
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == 32) {
                    if (state == 1) {
                        state = 2;
                    }else if (state == 2) {
                        state = 1;
                    }
                }
            }
        });

        // 将所有要绘制的游戏物体添加到总体元素集合当中
        GameUtils.gameObjs.add(map0);
        GameUtils.gameObjs.add(plane);

        // 设置窗口是否可见
        this.setVisible(true);

        // 启动游戏循环线程
        Thread gameThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    if (state == 1) {
                        createObj();
                        repaint(); // 调用paint
                    }
                    try {
                        Thread.sleep(20);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        gameThread.start(); // 启动游戏线程
    }

    @Override
    public void paint(Graphics g) {
        // 初始化双缓存图片对象
        if (cacheImage == null) {
            cacheImage = createImage(600, 800);
        }
        // 获取双缓村图片对象画笔
        Graphics cg = cacheImage.getGraphics();
        cg.fillRect(0, 0, 600, 800);

        // 开始
        if(state == 1) {
            // 爆炸集合添加到全部元素集合中
            GameUtils.gameObjs.addAll(GameUtils.booms);

            for (int i = 0; i < GameUtils.gameObjs.size(); i++) {
                GameUtils.gameObjs.get(i).paintSelf(cg);
            }

            // 将移除元素从全部元素中移除，减小绘制压力
            GameUtils.gameObjs.removeAll(GameUtils.removeObjs);
            count++; // 统计绘制次数
        }
        // 暂停
        if (state == 2) {
            cg.drawImage(GameUtils.map0Img, 0, 0, null);
            GameUtils.drawWord(cg, "游戏暂停", Color.YELLOW, 30, 240, 350);
        }

        // 通关
        if (state == 3) {
            String username = LoginWin.nameField.getText();
            System.out.println(username);
            userService.updateScore(username);

            cg.drawImage(GameUtils.map0Img, 0, 0, null);
            GameUtils.drawWord(cg, "游戏失败", Color.RED, 30, 240, 350);
            GameUtils.drawWord(cg, "点击键盘上R 重新开始游戏", Color.BLUE, 30, 100, 420);

            this.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    int keyCode = e.getKeyCode();
                    if (keyCode == 82) {
                        dispose();
                        score = 0;
                        GameUtils.removeObjs.addAll(GameUtils.gameObjs);
                        new GameWin();
                        state = 1;
                    }
                }
            });
        }

        // 失败
        if (state == 4) {
            String username = LoginWin.nameField.getText();
            System.out.println(username);
            userService.updateScore(username);

            cg.drawImage(GameUtils.map0Img, 0, 0, null);
            GameUtils.drawWord(cg, "游戏通关", Color.GREEN, 30, 240, 350);
        }

        // 积分
        GameUtils.drawWord(cg, "积分："+score+"分", Color.BLUE, 40, 30, 100);
        // 将双缓存图片绘制到窗口中
        g.drawImage(cacheImage, 0, 0, null);
    }

    // 批量创建物体
    public void createObj() {
        // 控制我方飞机子弹发射速度
        if (count % 15 == 0) {
            if (plane.nums == 0){ // 一级子弹
                // 生成批量子弹
                GameUtils.heroBulletList.add(new Bullet(GameUtils.heroBulletImg,31, 68, plane.getX() + 30, plane.getY() - 30, 8, this));
                // 每次 new 出来的新对象，添加到所有元素集合当中
                GameUtils.gameObjs.add(GameUtils.heroBulletList.get(GameUtils.heroBulletList.size() - 1));
            }
            if (plane.nums == 1) { // 二级子弹
                GameUtils.secondaryBulletList.add(new SecondaryBullet(GameUtils.heroSecondaryBulletImg, 100, 100, plane.getX(), plane.getY() - 40, 8, this));
                GameUtils.gameObjs.add(GameUtils.secondaryBulletList.get(GameUtils.secondaryBulletList.size() - 1));
            }

        }
        // 生成敌方飞机
        // 0号飞机
        if (count % 30 == 0) {
            // 生成批量 敌机0
            GameUtils.enemy0List.add(new Enemy0(GameUtils.enemy0Img,102, 79, (int)(Math.random() * 10) * 60, 0, 5, this));
            // 每次 new 出来的新对象，添加到所有元素集合当中
            GameUtils.gameObjs.add(GameUtils.enemy0List.get(GameUtils.enemy0List.size() - 1));
        }

        // 1号飞机
        if (count % 50 == 0) {
            // 生成批量 敌机1
            GameUtils.enemy1List.add(new Enemy1(GameUtils.enemy1Img,102, 79, (int)(Math.random() * 10) * 60, 0, 3, this));
            // 每次 new 出来的新对象，添加到所有元素集合当中
            GameUtils.gameObjs.add(GameUtils.enemy1List.get(GameUtils.enemy1List.size() - 1));
        }
        // 控制子弹速率
        if (count % 30 == 0) {
            if (GameUtils.enemy1List.size() > 0) {
                // 敌机1出现，产生子弹
                GameUtils.enemy1BulletList.add(new Enemy1Bullet(
                        GameUtils.enemy1BulletImg, 18, 19,
                        GameUtils.enemy1List.get(GameUtils.enemy1List.size() - 1).getX() + 43,
                        GameUtils.enemy1List.get(GameUtils.enemy1List.size() - 1).getY() + 50,
                        6, this));
                // 每次 new 出来的新对象，添加到所有元素集合当中
                GameUtils.gameObjs.add(GameUtils.enemy1BulletList.get(GameUtils.enemy1BulletList.size() - 1));
            }
        }

        // 生成敌方boss
        if (!(GameUtils.gameObjs.contains(littleBoss)) && count == 1000) {
            GameUtils.gameObjs.add(littleBoss);
        }

        // 生成小boss子弹
        if (count % 120 == 0) {
            if (GameUtils.gameObjs.contains(littleBoss)) {
                GameUtils.littleBossBulletLeftList.add(new LittleBossBullet(GameUtils.littleBossBullet, 30, 50, littleBoss.getX(), littleBoss.getY() + 95, 4, this));
                GameUtils.gameObjs.add(GameUtils.littleBossBulletLeftList.get(GameUtils.littleBossBulletLeftList.size() - 1));
                GameUtils.littleBossBulletRightList.add(new LittleBossBullet(GameUtils.littleBossBullet, 30, 50, littleBoss.getX() + 180, littleBoss.getY() + 95, 4, this));
                GameUtils.gameObjs.add(GameUtils.littleBossBulletRightList.get(GameUtils.littleBossBulletRightList.size() - 1));
            }
        }

        // 生成SuperBoss
        if (count == 200 && !(GameUtils.gameObjs.contains(superBoss))) {
            GameUtils.gameObjs.add(superBoss);
        }

        // 生成SuperBoss子弹
        if (count % 150 == 0) {
            if (GameUtils.gameObjs.contains(superBoss)) {
                GameUtils.SuperBossBulletLeftList.add(new SuperBossBullet(GameUtils.SuperBossBullet, 40, 126, superBoss.getX() + 10, superBoss.getY() + 90, 5, this));
                GameUtils.gameObjs.add(GameUtils.SuperBossBulletLeftList.get(GameUtils.SuperBossBulletLeftList.size() - 1));
                GameUtils.SuperBossBulletRightList.add(new SuperBossBullet(GameUtils.SuperBossBullet, 40, 126, superBoss.getX() + 160, superBoss.getY() + 90, 5, this));
                GameUtils.gameObjs.add(GameUtils.SuperBossBulletRightList.get(GameUtils.SuperBossBulletRightList.size() - 1));
            }
        }

        // 警示标志出现时间
        if (count == 195 && !GameUtils.gameObjs.contains(warning)) {
            GameUtils.gameObjs.add(warning);
        }
        // 消失
        if (count == 2000) {
            GameUtils.removeObjs.add(warning);
        }

        // 血量补给
        if (count % 100 == 0) {
            GameUtils.bloodSupplyList.add(new bloodSupply(GameUtils.bloodSupply, 80, 45, (int)(Math.random() * 10) * 60, 0 ,7, this));
            GameUtils.gameObjs.add(GameUtils.bloodSupplyList.get(GameUtils.bloodSupplyList.size() - 1));
        }
    }

    public static void main(String[] args) {
        GameWin gameApp = new GameWin();
    }

}
