package com.utils;

import com.domain.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameUtils {
    // 开始游戏
    public static Image start = Toolkit.getDefaultToolkit().getImage("imgs/start.jpg");
    // 结束游戏
    public static Image exit = Toolkit.getDefaultToolkit().getImage("imgs/exit.png");

    // 获取主界面背景
    public static Image bgImg = Toolkit.getDefaultToolkit().getImage("imgs/ColorImages/bg/main.jpg");

    // 地图0
    public static Image map0Img = Toolkit.getDefaultToolkit().getImage("imgs/ColorImages/bg/bg0.jpg");

    // 地图1
    public static Image map1Img = Toolkit.getDefaultToolkit().getImage("imgs/ColorImages/bg/bg1.jpg");

    // 获取 敌机0 图片
    public static Image enemy0Img = Toolkit.getDefaultToolkit().getImage("imgs/ColorImages/enemy/enemy.png");
    // 获取 敌机0 爆炸图片
    public static Image enemyDown4Img = Toolkit.getDefaultToolkit().getImage("imgs/ColorImages/enemy/enemy_down4.png");
    // 敌机0集合
    public static List<Enemy0> enemy0List = new ArrayList<>();
    // 获取 敌机1 图片
    public static Image enemy1Img = Toolkit.getDefaultToolkit().getImage("imgs/ColorImages/enemy/enemy1.png");
    // 敌机1集合
    public static List<Enemy1> enemy1List = new ArrayList<>();

    // 获取我方飞机图片
    public static Image heroImg = Toolkit.getDefaultToolkit().getImage("imgs/ColorImages/hero/hero.png");

    // 获取我方飞机子弹图片
    public static Image heroBulletImg = Toolkit.getDefaultToolkit().getImage("imgs/ColorImages/bullet/bullet1.png");
    // 我方飞机子弹的集合
    public static List<Bullet> heroBulletList = new ArrayList<>();
    // 二级子弹图片
    public static Image heroSecondaryBulletImg = Toolkit.getDefaultToolkit().getImage("imgs/ColorImages/bullet/bullet2.png");
    // 二级子弹集合
    public static List<SecondaryBullet> secondaryBulletList = new ArrayList<>();

    // 获取 敌机1 子弹
    public static Image enemy1BulletImg = Toolkit.getDefaultToolkit().getImage("imgs/ColorImages/bullet/enemy_bullet1.png");
    // 敌机1 子弹的集合
    public static List<Enemy1Bullet> enemy1BulletList = new ArrayList<>();

    // 小boss
    public static Image littleBoss = Toolkit.getDefaultToolkit().getImage("imgs/ColorImages/enemy/boss.png");
    // 小boss子弹
    public static Image littleBossBullet = Toolkit.getDefaultToolkit().getImage("imgs/ColorImages/bullet/boss_bullet2.png");
    // 小boss左发射口子弹集合
    public static List<LittleBossBullet> littleBossBulletLeftList = new ArrayList<>();
    // 小boss右发射口子弹集合
    public static List<LittleBossBullet> littleBossBulletRightList = new ArrayList<>();
    // 小boss掉落补给
    public static Image littleBossSupply = Toolkit.getDefaultToolkit().getImage("imgs/ColorImages/hero/article1.png");
    // 补给集合
    public static List<LittleBossSupply> littleBossSupplyList = new ArrayList<>();
    // 血量回复补给
    public static Image bloodSupply = Toolkit.getDefaultToolkit().getImage("imgs/ColorImages/hero/hero_blood.png");
    // 补给集合
    public static List<bloodSupply> bloodSupplyList = new ArrayList<>();

    // 最终boss
    public static Image SuperBoss = Toolkit.getDefaultToolkit().getImage("imgs/ColorImages/enemy/super_boss.png");
    // 最终boss子弹
    public static Image SuperBossBullet = Toolkit.getDefaultToolkit().getImage("imgs/ColorImages/bullet/boss_bullet.png");
    // 最终boss左发射口子弹集合
    public static List<SuperBossBullet> SuperBossBulletLeftList = new ArrayList<>();
    // 最终boss右发射口子弹集合
    public static List<SuperBossBullet> SuperBossBulletRightList = new ArrayList<>();
    // 最终boss损坏程度1
    public static Image SuperBossDown1 = Toolkit.getDefaultToolkit().getImage("imgs/ColorImages/boom/super_boss_down1.png");
    // 最终boss损坏程度2
    public static Image SuperBossDown2 = Toolkit.getDefaultToolkit().getImage("imgs/ColorImages/boom/super_boss_down2.png");
    // 最终boss损坏程度3
    public static Image SuperBossDown3 = Toolkit.getDefaultToolkit().getImage("imgs/ColorImages/boom/super_boss_down3.png");
    // 最终boss损坏程度4
    public static Image SuperBossDown4 = Toolkit.getDefaultToolkit().getImage("imgs/ColorImages/boom/super_boss_down4.png");
    // 最终boss损坏程度5
    public static Image SuperBossDown5 = Toolkit.getDefaultToolkit().getImage("imgs/ColorImages/boom/super_boss_down5.png");
    // 最终boss损坏程度6
    public static Image SuperBossDown6 = Toolkit.getDefaultToolkit().getImage("imgs/ColorImages/boom/super_boss_down6.png");

    // 排行榜
    public static Image leaderboard = Toolkit.getDefaultToolkit().getImage("imgs/leader.png");

    // 警示标志
    public static Image warn = Toolkit.getDefaultToolkit().getImage("imgs/warn.png");

    // 所有元素集合
    public static List<GameObj> gameObjs = new ArrayList<>();

    // 移除元素的集合
    public static List<GameObj> removeObjs = new ArrayList<>();

    // 爆炸集合
    public static List<Boom> booms = new ArrayList<>();

    public static void drawWord(Graphics gImage, String str, Color color, int size, int x, int y) {
        gImage.setColor(color);
        gImage.setFont(new Font("仿宋", Font.BOLD, size));
        gImage.drawString(str, x, y);
    }
}