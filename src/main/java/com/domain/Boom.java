package com.domain;

import java.awt.*;

public class Boom extends GameObj{
    // 存放一串爆炸图
    static Image[] images = new Image[6];
    // 定义变量存储爆炸记录
    int count = 0;
    // 初始化
    static {
        for (int i = 0; i < images.length; i++) {
            images[i] = Toolkit.getDefaultToolkit().getImage("imgs/ColorImages/boom/boom0" + (i+1) + ".png");
        }
    }

    public Boom(int x, int y) {
        super(x, y);
    }

    @Override
    public void paintSelf(Graphics gImage) {
        if (count < 6) {
            super.img = images[count];
            super.paintSelf(gImage);
            count++;
        }
    }

}
