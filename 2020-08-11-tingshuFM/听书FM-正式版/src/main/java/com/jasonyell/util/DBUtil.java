package com.jasonyell.util;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @program: 2020-08-11-tingshuFM
 * @description
 *    单例模式 DBUtil
 * @author: JasonYell
 * @create: 2020-11-27 15:43
 **/
public class DBUtil {

    private static volatile DataSource dataSource = null;

    public static Connection getConnection() throws SQLException {
        if (dataSource == null) {
            synchronized ((DBUtil.class)) {
                if (dataSource == null) {
                    dataSource = initDataSource();
                }
            }
        }
        return dataSource.getConnection();
    }
    // 初始化 DataSource
    private static DataSource initDataSource() {

        MysqlDataSource mysqlDataSource = new MysqlDataSource();

        mysqlDataSource.setServerName("127.0.0.1");
        mysqlDataSource.setPort(3306);
        mysqlDataSource.setUser("root");
        mysqlDataSource.setPassword("1234");
        mysqlDataSource.setDatabaseName("hjb2_tingshu");
        mysqlDataSource.setCharacterEncoding("utf-8");
        mysqlDataSource.setUseSSL(false);

        return mysqlDataSource;
    }
}
