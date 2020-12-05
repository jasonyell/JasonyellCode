package com.jasonyell.model;

import com.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @program: 2020-08-12-网络-HTTP协议-博客系统
 * @description
 * @author: JasonYell
 * @create: 2020-10-10 10:20
 **/
public class Article {
    public int authorId;
    public String authorUsername;

    public int id;
    public String title;
    public String  published_at;
    public String content;


    /**
     *   这个不能这么使用：原因：
     *      1. DateFormat  不是线程安全的
     *      2. 我们的 publish 实际上是运行在多线程环境下的
     *
     *   static DateFormat format = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
     *   public static void publish(int userID, String title, String content) {
     *  //得到当前时间
     *   Date date = new Date();
     *  String publishedAt = format.format(date);   //2020-07-12 11:42:38
     * }
     */

    public static void publish(int userID, String title, String content) throws SQLException {
        DateFormat format = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String publishedAt = format.format(date);   //2020-07-12 11:42:38

        try (Connection c = DBUtil.getConnection()) {

            String sql = "INSERT INTO article(user_id,title,content,published_at) VALUES (?,?,?,?)";

            try (PreparedStatement p = c.prepareStatement(sql)) {
                p.setInt(1,userID);
                p.setString(2,title);
                p.setString(3,content);
                p.setString(4,publishedAt);

                p.executeUpdate();
            }
        }
    }

    public static List<Article> list() throws SQLException {
        List<Article> articleList = new ArrayList<>();

        String sql = "SELECT\n" +
                "  users.id author_id,\n" +
                "  users.username author_username,\n" +
                "  article.id,\n" +
                "  title,\n" +
                "  published_at\n" +
                "from article join users on article.user_id = users.id\n" +
                "order by published_at desc;";

        try (Connection c = DBUtil.getConnection()) {
            try (PreparedStatement s = c.prepareStatement(sql)) {
                try (ResultSet r = s.executeQuery()) {
                    while (r.next()) {
                        Article article = new Article();
                        article.id = r.getInt("id");
                        article.authorId = r.getInt("author_id");
                        article.authorUsername = r.getString("author_username");
                        article.title = r.getString("title");
                        article.published_at = r.getString("published_at");

                        articleList.add(article);
                    }
                }
            }
            return articleList;
        }
    }

    public static Article get(int id) throws SQLException {
        try (Connection c = DBUtil.getConnection()) {
            String sql = "select title,content from article where id=?";
            try (PreparedStatement s = c.prepareStatement(sql)) {
                s.setInt(1, id);
                try (ResultSet su = s.executeQuery()) {

                    if (!su.next()) {
                        return null;
                    }

                    Article article = new Article();
                    article.title = su.getString("title");
                    article.content = su.getString("content");

                    return article;
                }
            }
        }
    }
}
