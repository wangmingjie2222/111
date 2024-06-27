package com.handler;

import com.GameWin;
import com.LoginWin;
import com.MainWin;
import com.RegisterWin;
import com.domain.User;
import com.service.UserService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginHandler implements ActionListener {
    private LoginWin loginWin;

    private UserService userService = new UserService();

    public LoginHandler(LoginWin loginWin) {
        this.loginWin = loginWin;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton jButton = (JButton) e.getSource();
        if (jButton.getText().equals("登录")) {
            String username = loginWin.getNameField().getText();
            String passowrd = loginWin.getPasswordField().getText();
            User user = new User();
            user.setUsername(username);
            user.setPassword(passowrd);
            boolean flag = userService.login(user);
            if (flag) {
                JOptionPane.showMessageDialog(loginWin, "登陆成功");
                // 关闭该窗口
                loginWin.dispose();
                // 打开游戏窗口
                SwingUtilities.invokeLater(MainWin::new);
            }else {
                JOptionPane.showMessageDialog(loginWin, "用户名或密码错误");
            }
        }else if (jButton.getText().equals("注册")){
            new RegisterWin(loginWin);
        }
    }
}
