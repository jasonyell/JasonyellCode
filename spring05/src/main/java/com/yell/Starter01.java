package com.yell;


import com.yell.controller.UserController;
import com.yell.dao.AccountDao;
import com.yell.po.vo.MessageModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.security.auth.login.AccountException;

/**
 * @program: spring05
 * @description
 * @author: JasonYell
 * @create: 2021-03-24 18:08
 **/
public class Starter01 {

    @Test
    public void login() {
        BeanFactory factory = new ClassPathXmlApplicationContext("spring.xml");
        UserController userController = (UserController) factory.getBean("userController");
        MessageModel messageModel = userController.userLogin("admin", "123456");
        System.out.println(messageModel);
    }

    @Test
    public void test() {
        BeanFactory factory = new ClassPathXmlApplicationContext("spring.xml");


        System.out.println( factory.getBean("accountDao"));
        System.out.println( factory.getBean("accountDao"));

//        判断指定的bean对象是否是单例
        System.out.println(factory.isSingleton("accountDao"));
    }


    @Test
    public void test1() {
        AbstractApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
//        关闭容器
        ac.close();
    }

}
