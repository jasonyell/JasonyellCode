package com.jasonyell.dao;

import com.jasonyell.model.Book;
import com.jasonyell.model.User;
import com.jasonyell.util.DBUtil;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: 2020-08-11-tingshuFM
 * @description
 * @author: JasonYell
 * @create: 2020-11-28 15:49
 **/
public class BookDao {
    public Book selectByBid(int bid) throws SQLException {
        String sql = "select bid, title, users.uid, users.username " +
                "     from books,users " +
                "     where books.uid = users.uid and bid = ?";

        try (Connection c = DBUtil.getConnection()) {
            try (PreparedStatement s = c.prepareStatement(sql)) {
                s.setInt(1, bid);
                try (ResultSet r = s.executeQuery()) {
                    if (!r.next()) {
                        return null;
                    }

                    User user = new User(r.getInt("uid"), r.getString("username"));
                    return new Book(r.getInt("bid"), user, r.getString("username"));
                }
            }
        }
    }

    public Book insert(User user, String title) throws SQLException {

        String sql = "insert into books (uid, title) values (?,?)";

        try (Connection c = DBUtil.getConnection()) {
            try (PreparedStatement s = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                s.setInt(1, user.uid);
                s.setString(2, title);

                s.executeUpdate();

                try (ResultSet r = s.getGeneratedKeys()) {
                    if (!r.next()) {
                        return null;
                    }
                    return new Book(r.getInt(1), user, title);
                }
            }
        }
    }

    public List<Book> selectAll() throws SQLException {
        // 联表查询
        String sql = "select bid, title, users.uid, users.username" +
                "     from books, users " +
                "     where books.uid = users.uid " +
                "     order by bid desc";

        List<Book> books = new ArrayList<>();

        try (Connection c = DBUtil.getConnection()) {
            try (PreparedStatement s = c.prepareStatement(sql)) {
                try (ResultSet r = s.executeQuery()) {
                    while (r.next()) {
                        User user = new User(r.getInt("uid"), r.getString("username"));
                        Book book = new Book(r.getInt("bid"), user, r.getString("title"));

                        books.add(book);
                    }
                }
            }
        }
        return books;
    }
}
