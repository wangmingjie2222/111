package com;

import com.handler.LoginHandler;
import com.service.UserService;

import javax.swing.*;
import java.awt.*;

public class LoginWin extends JFrame {

    // 账号
    JLabel nameLabel = new JLabel("用户名：");
    public static JTextField nameField = new JTextField();
    // 密码
    JLabel passwordLabel = new JLabel("密码：");
    JPasswordField passwordField = new JPasswordField();

    // 按钮
    JButton login = new JButton("登录");
    JButton register = new JButton("注册");

    private UserService userService = new UserService();

    public LoginWin() {
        LoginHandler loginHandler = new LoginHandler(this);

        JPanel panel = new JPanel(new GridLayout(3, 2));

        Font font = new Font("楷体", Font.PLAIN, 20);
        nameLabel.setFont(font);
        passwordLabel.setFont(font);
        login.setFont(font);
        register.setFont(font);
        nameField.setFont(font);
        passwordField.setFont(font);
        nameField.setPreferredSize(new Dimension(200, 30));
        passwordField.setPreferredSize(new Dimension(200, 30));

        // 添加鼠标点击事件
        login.addActionListener(loginHandler);
        register.addActionListener(loginHandler);

        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(register);
        panel.add(login);

        add(panel);

        this.setTitle("用户登录");
        this.setSize(400, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        LoginWin loginWin = new LoginWin();
    }

    public JLabel getNameLabel() {
        return nameLabel;
    }

    public void setNameLabel(JLabel nameLabel) {
        this.nameLabel = nameLabel;
    }

    public JTextField getNameField() {
        return nameField;
    }

    public void setNameField(JTextField nameField) {
        this.nameField = nameField;
    }

    public JLabel getPasswordLabel() {
        return passwordLabel;
    }

    public void setPasswordLabel(JLabel passwordLabel) {
        this.passwordLabel = passwordLabel;
    }

    public JTextField getPasswordField() {
        return passwordField;
    }

    public void setPasswordField(JPasswordField passwordField) {
        this.passwordField = passwordField;
    }
}
