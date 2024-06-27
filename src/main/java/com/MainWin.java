package com;

import com.domain.User;
import com.service.UserService;
import com.utils.GameUtils;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainWin extends JFrame {

    // 定义图片变量
    Image cacheImage = null;

    private UserService userService = new UserService();

    public MainWin() {

        // 创建按钮面板
        JPanel buttonPanel = new JPanel(null);
        buttonPanel.setPreferredSize(new Dimension(600, 800));
        // buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10)); // 设置布局为FlowLayout居中对齐，间距为10像素

        // 添加排行榜查询按钮
        ImageIcon leaderboardIcon = new ImageIcon(GameUtils.leaderboard);
        JButton leaderboardButton = new JButton(leaderboardIcon);
        leaderboardButton.setBounds(150, 400, 300, 160);
        leaderboardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showLeaderboard(); // 打开排行榜界面
            }
        });
        buttonPanel.add(leaderboardButton);

        // 添加开始游戏按钮
        ImageIcon startIcon = new ImageIcon(GameUtils.start);
        JButton startButton = new JButton(startIcon);
        startButton.setBounds(50, 640, 210, 91);
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GameWin();
            }
        });
        buttonPanel.add(startButton);

        // 添加退出游戏按钮
        ImageIcon exitIcon = new ImageIcon(GameUtils.exit);
        JButton exitButton = new JButton(exitIcon);
        exitButton.setBounds(350, 640, 210, 91);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // 关闭游戏窗口
                new LoginWin();
            }
        });
        buttonPanel.add(exitButton);

        this.add(buttonPanel);

        // 设置窗口大小
        this.setSize(600, 800);
        // 设置窗口位置
        this.setLocationRelativeTo(null);
        // 设置窗口标题
        this.setTitle("飞机大战");
        // 关闭窗口自动结束进程
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 设置窗口是否可见
        this.setVisible(true);

    }

    private void showLeaderboard() {
        // 创建一个新的窗口来显示排行榜
        JFrame leaderboardFrame = new JFrame("排行榜");
        leaderboardFrame.setSize(400, 400);
        leaderboardFrame.setLocationRelativeTo(null);

        // 创建一个表格来显示排行榜数据
        JTable table = new JTable();
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("用户名");
        model.addColumn("分数");

        ArrayList<User> users = userService.selectAll();

        for (User user : users) {
            Object[] row = {user.getUsername(), user.getScore()};
            model.addRow(row);
        }

        table.setModel(model);

        JScrollPane scrollPane = new JScrollPane(table);
        leaderboardFrame.add(scrollPane);

        // 设置窗口可见性
        leaderboardFrame.setVisible(true);
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

        cg.drawImage(GameUtils.bgImg, 0, 0,null);
        cg.drawImage(GameUtils.SuperBoss, 210, 50, null);
        cg.drawImage(GameUtils.heroImg, 265, 600, null);

        // 将双缓存图片绘制到窗口中
        g.drawImage(cacheImage, 0, 0, null);
    }

    public static void main(String[] args) {
        new MainWin();
    }
}
