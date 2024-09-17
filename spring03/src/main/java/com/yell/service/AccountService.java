package com.yell.service;

import com.yell.dao.AccountDao;
import com.yell.dao.UserDao;

import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 *  SpringIOC 注入
 *      1.手动注入（装配）
 *          set 方法注入
 *          构造器注入
 *          静态工厂注入
 *          实例化工厂注入
 *      2.自动注入（装配)
 */
public class AccountService {
    // 主动实例化
    // AccountDao acDao = new AccountDao();

    // javaBean 对象手动注入 set 方法注入
    private AccountDao accountDao;

    // 提供set方法
    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    //  字符串类型
    private String host;

    public void setHost(String host) {
        this.host = host;
    }

    // 基本类型
    private Integer port;

    public void setPort(Integer port) {
        this.port = port;
    }

    //List
    private List<String> list;

    public void setList(List<String> list) {
        this.list = list;
    }

    public void printList() {
        list.forEach( v -> System.out.println(v));
    }

    // Map
    private Map<String, Object> map;

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public void printMap() {
        map.forEach((k, v) -> System.out.println(k + "," + v));
    }

    // properties
    private Properties properties;

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public void printProperties() {
        properties.forEach((k, v) -> System.out.println(k + "," + v));
    }

    public void test() {
        System.out.println("AccountService...");
        accountDao.test();
        System.out.println(host);
        System.out.println(port);
        printList();
        printMap();
        printProperties();

    }
}
