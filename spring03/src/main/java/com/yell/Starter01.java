package com.yell;

import com.yell.dao.UserDao;
import com.yell.service.UserService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * springIOC Bean 对象向实例化
 *      1.构造器实例化
 *          默认使用构造器实例化，需要 bean 对象提供空构造，如果没有空构造则创建失败
 **/
public class Starter01 {
    public static void main(String[] args) {
        //1. 加载 spring上下文环境
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("spring.xml");
        // 得到 Bean 对象
//        UserService userService = (UserService) beanFactory.getBean("userService");

        UserDao userDao = (UserDao) beanFactory.getBean("userDao");
    }
}
