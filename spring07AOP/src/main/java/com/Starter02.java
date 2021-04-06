package com;

import com.yell.service.UserService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @program: spring07AOP
 * @description
 * @author: JasonYell
 * @create: 2021-03-27 16:37
 **/
public class Starter02 {
    public static void main(String[] args) {
        //  得到上下文环境
        BeanFactory factory = new ClassPathXmlApplicationContext("spring02.xml");
        //  获取bean对象
        UserService userService = (UserService) factory.getBean("userService");
        userService.test();

    }
}
