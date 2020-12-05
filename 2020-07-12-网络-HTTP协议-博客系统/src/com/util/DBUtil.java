package com.util;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @program: 2020-08-12-网络-HTTP协议-博客系统
 * @description
 * @author: JasonYell
 * @create: 2020-10-09 10:45
 **/
public class DBUtil {
    public static final DataSource dataSource = initDataSource();

    private static DataSource initDataSource() {
        MysqlDataSource mysqlDataSource = new MysqlDataSource();
        mysqlDataSource.setServerName("127.0.0.1");
        mysqlDataSource.setPort(3306);
        mysqlDataSource.setUser("root");
        mysqlDataSource.setPassword("1234");
        mysqlDataSource.setDatabaseName("hjb2_blog");
        mysqlDataSource.setCharacterEncoding("utf8");
        mysqlDataSource.setUseSSL(false);

        return mysqlDataSource;
    }


    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}
