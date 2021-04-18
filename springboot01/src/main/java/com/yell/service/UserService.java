package com.yell.service;

import com.yell.dao.UserDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @program: springboot01
 * @description
 * @author: JasonYell
 * @create: 2021-04-07 01:41
 **/
@Service
public class UserService {

    @Resource
    private UserDao userDao;

    public void test() {
        System.out.println("userService...");

        userDao.test();
    }
}
