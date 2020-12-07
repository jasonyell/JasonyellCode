package com.jasonyell.util;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @program: Fo
 * @description
 * @author: JasonYell
 * @create: 2020-11-03 03:29
 **/
public class DBUtil {

    /**
     * 数据库jdbc的操作步骤？
     * 1.创建数据库连接Connection
     * 2.创建操作命令对象Statement
     * 3.执行SQL
     * 4.如果是查询操作，处理结果集
     * 5.释放资源
     */

    private static final String URL = "jdbc:mysql://localhost:3306/stu_info?useUnicode=true&characterEncoding=utf8&useSSL=true&serverTimezone=UTC";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "1234";

    private static volatile DataSource DS;

    private DBUtil(){}

    private static DataSource getDataSource() {

        if (DS == null) {
            synchronized (DBUtil.class) {
                if (DS == null) {
                    DS = new MysqlDataSource();
                    ((MysqlDataSource) DS).setURL(URL);
                    ((MysqlDataSource) DS).setUser(USERNAME);
                    ((MysqlDataSource) DS).setPassword(PASSWORD);
                }
            }
        }
        return DS;
    }

    public static Connection getConnection(){
        try {
            return getDataSource().getConnection();
        } catch (SQLException e) {
            throw new RuntimeException("获取数据库连接失败", e);
        }
    }

    public static void close(Connection c, Statement s) {
        close(c, s, null);
    }

    public static void close(Connection c, Statement s, ResultSet r) {
        try {
            if (r != null) {
                r.close();
            }
            if (s != null) {
                s.close();
            }
            if (c != null) {
                c.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException("释放数据库资源出错" , e);
        }
    }

    /**
     private static DataSource dataSource = null;

     static {
     init();
     }

     private static void init() {
     MysqlDataSource mysqlDataSource = new MysqlDataSource();
     mysqlDataSource.setServerName("127.0.0.1");
     mysqlDataSource.setPort(3306);
     mysqlDataSource.setUser("root");
     mysqlDataSource.setPassword("1234");
     mysqlDataSource.setDatabaseName("stu_info");
     mysqlDataSource.setUseSSL(false);
     mysqlDataSource.setCharacterEncoding("utf-8");
     dataSource = mysqlDataSource;
     }

     public static Connection getConnection() throws SQLException {
     return dataSource.getConnection();
     }
     */
}
