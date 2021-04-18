package com.yell;

import com.yell.dao.UserDao;
import com.yell.factory.MyClassPathXmlApplication;
import com.yell.factory.MyFactory;
import com.yell.service.UserService;

/**
 * @program: spring02
 * @description
 *      模拟 springIOC 模拟Bean对象的实例化
 * @author: JasonYell
 * @create: 2021-03-23 02:10
 **/
public class App {
    public static void main(String[] args) {
        // 上下文环境
        MyFactory myFactory = new MyClassPathXmlApplication("spring.xml");

        // 得到实例化好的对象
        UserService userService = (UserService) myFactory.getBean("userService");
        UserDao userDao = (UserDao) myFactory.getBean("userDao");

        UserService userService02 = (UserService) myFactory.getBean("userService");
        // 实例化的对象是单例的
        System.out.println(userService);
        System.out.println(userService02);

        userDao.test();
        userService.test();

    }
}
