package com;

import com.domain.User;
import com.service.UserService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterWin extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton registerButton;

    private LoginWin loginWin;

    private UserService userService = new UserService();

    public RegisterWin(LoginWin loginWin) {
        this.loginWin = loginWin;

        // 设置窗口标题
        setTitle("注册");

        // 创建用户名输入框和密码输入框
        usernameField = new JTextField(20);
        passwordField = new JPasswordField(20);

        // 创建注册按钮
        registerButton = new JButton("注册");
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                User user = new User();
                user.setUsername(username);
                user.setPassword(password);

                int num = userService.insert(user);
                if (num > 0) {
                    JOptionPane.showMessageDialog(RegisterWin.this, "注册成功");
                    // 关闭注册窗口
                    dispose();
                    // 返回登录页面
                    loginWin.setVisible(true);
                }else {
                    JOptionPane.showMessageDialog(RegisterWin.this, "用户名重复，请重新注册");
                }

            }
        });

        // 创建面板，并设置布局为网格布局
        JPanel panel = new JPanel(new GridLayout(3, 2));

        // 向面板中添加组件
        panel.add(new JLabel("用户名:"));
        panel.add(usernameField);
        panel.add(new JLabel("密码:"));
        panel.add(passwordField);
        panel.add(new JLabel()); // 空白占位
        panel.add(registerButton);

        // 将面板添加到窗口中
        add(panel);

        // 设置窗口属性
        setSize(300, 150); // 设置窗口大小
        setLocationRelativeTo(loginWin); // 设置窗口相对于登录窗口居中显示
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // 设置窗口关闭操作为关闭当前窗口

        // 显示窗口
        setVisible(true);
    }

    public RegisterWin() {
    }
}