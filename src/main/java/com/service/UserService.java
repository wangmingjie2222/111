package com.service;

import com.GameWin;
import com.domain.User;
import com.utils.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;

public class UserService {
    public boolean login(User user) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = JDBCUtils.getConnection();
            String sql = "select * from user where username = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getUsername());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                    return true;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils.release(connection, preparedStatement, resultSet);
        }
        return false;
    }

    public int insert(User user) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int num = 0;
        try {
            connection = JDBCUtils.getConnection();
            String sql = "insert into user(username, password) values (?, ?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            num  = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(connection, preparedStatement);
        }
        return num;
    }

    // 查询分数
    public ArrayList<User> selectAll() {
        ArrayList<User> users = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = JDBCUtils.getConnection();
            String sql = "select username,score from user order by score desc";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String username = resultSet.getString("username");
                int score = resultSet.getInt("score");
                User user = new User();
                user.setUsername(username);
                user.setScore(score);

                users.add(user);
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils.release(connection, statement, resultSet);
        }
        return users;
    }

    // 上传分数
    public void updateScore(String username) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int num = 0;
        try {
            connection = JDBCUtils.getConnection();
            String sql = "update user set score = ? where username = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, GameWin.score);
            preparedStatement.setString(2, username);
            num  = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(connection, preparedStatement);
        }
    }
}
