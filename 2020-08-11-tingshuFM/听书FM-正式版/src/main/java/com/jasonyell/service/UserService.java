package com.jasonyell.service;

import com.jasonyell.dao.UserDao;
import com.jasonyell.model.User;

import java.sql.SQLException;

/**
 * @program: 2020-08-11-tingshuFM
 * @description
 *
 *    提供偏向业务角度的方法
 *
 * @author: JasonYell
 * @create: 2020-11-27 16:17
 **/
public class UserService {
    private UserDao userDao;

    public UserService() {
        userDao = new UserDao();
    }

    public User register(String username, String password) throws SQLException {
        return userDao.insert(username, password);
    }

    public User login(String username, String password) throws SQLException {
        return userDao.select(username, password);
    }


}
