package com.jasonyell.dao;

import com.jasonyell.model.User;
import com.jasonyell.util.DBUtil;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;

/**
 * @program: 2020-08-11-tingshuFM
 * @description
 *     java 代码表示的 INSERT/SELECT/UPDATE/DELETE
 *
 *     关于用户的密码。不要明文密码
 *     如果泄露，所有用户全部泄露
 *     一般都是保存做完 hash 的密码（这里选择 sha-256 这个 hash 算法 ）
 * @author: JasonYell
 * @create: 2020-11-27 15:50
 **/
public class UserDao {
    public User insert(String username, String plainPassword) throws SQLException {
        String password = encrypt(plainPassword);

        String sql = "insert into users (username,password) values (?,?)";
        try (Connection c = DBUtil.getConnection()) {
            try (PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                ps.setString(1, username);
                ps.setString(2, password);
                ps.executeUpdate();
                try (ResultSet r = ps.getGeneratedKeys()) {
                    if (!r.next()) {
                        return null;
                    }
                    return new User(r.getInt(1), username);
                }
            }
        }
    }

    public User select(String username, String plainPassword) throws SQLException {
        String password = encrypt(plainPassword);

        String sql = "select uid from users where username = ? and password = ?";
        try (Connection c = DBUtil.getConnection()) {
            try (PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

                ps.setString(1, username);
                ps.setString(2, password);

                try (ResultSet rs = ps.executeQuery()) {
                    if (!rs.next()) {
                        return null;
                    }
                    return new User(rs.getInt(1), username);
                }
            }
        }
    }
    // 这个做法也不适合生产环境
    // 但至少比明文的情况安全
    private String encrypt(String plain) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");

            byte[] bytes = plain.getBytes();
            byte[] digest = messageDigest.digest(bytes);

            StringBuilder sb = new StringBuilder();

            for (byte b : digest) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        String s = "123";
        UserDao userDao = new UserDao();
        System.out.println(userDao.encrypt(s));
    }

}
