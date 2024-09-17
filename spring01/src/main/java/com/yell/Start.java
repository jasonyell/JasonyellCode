package com.yell;

import com.yell.Dao.UserDao;
import com.yell.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @program: spring01
 * @description
 * @author: JasonYell
 * @create: 2021-03-23 01:00
 **/
public class Start {
    public static void main(String[] args) {
//        UserService userService = new UserService();
//        userService.test();

        // 得到 Spring 的上下文环境
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");

        // 得到对应的实例化对象
        UserService userService = (UserService) ac.getBean("userService");
        userService.test();

        UserDao userDao = (UserDao) ac.getBean("userDao");
        userDao.test();

    }
}
