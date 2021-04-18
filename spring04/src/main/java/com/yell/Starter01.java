package com.yell;

import com.yell.dao.AccountDao;
import com.yell.service.UserService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @program: spring04
 * @description
 * @author: JasonYell
 * @create: 2021-03-24 12:31
 **/
public class Starter01 {
    public static void main(String[] args) {

        BeanFactory factory = new ClassPathXmlApplicationContext("spring.xml");

//        UserService userService = (UserService) factory.getBean("userService");
//        userService.test();

        AccountDao accountDao = (AccountDao) factory.getBean("accountDao");
        accountDao.test();

    }
}
