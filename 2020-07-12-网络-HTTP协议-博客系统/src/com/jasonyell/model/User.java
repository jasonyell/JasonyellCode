package com.jasonyell.model;

import com.util.DBUtil;

import java.sql.*;

/**
 * @program: 2020-08-12-网络-HTTP协议-博客系统
 * @description
 * @author: JasonYell
 * @create: 2020-10-09 01:45
 **/
public class User {
    public int id;
    public String username;

    // 注册
    public static User register(String username, String password) throws SQLException {
        try (Connection c = DBUtil.getConnection()) {
            String sql = "INSERT INTO users (username, password) VALUES (?,?)";
            try (PreparedStatement s = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                s.setString(1, username);
                s.setString(2, password);

                s.executeUpdate();

                try (ResultSet r = s.getGeneratedKeys()) {
                    if (!r.next()) {
                        return null;
                    }

                    User user = new User();
                    user.id = r.getInt(1);
                    user.username = username;
                    return user;
                }
            }
        }
    }
    // 登录
    public static User login(String username, String password) throws SQLException {
        try (Connection c = DBUtil.getConnection()) {
            String sql = "SELECT id FROM users WHERE username = ? AND password = ? ";
            try (PreparedStatement s = c.prepareStatement(sql)) {
                s.setString(1, username);
                s.setString(2, password);

                try (ResultSet r = s.executeQuery()) {
                    if (!r.next()) {
                        return null;
                    }

                    User user = new User();
                    user.id = r.getInt("id");
                    user.username = username;
                    return user;
                }
            }
        }
    }
}
