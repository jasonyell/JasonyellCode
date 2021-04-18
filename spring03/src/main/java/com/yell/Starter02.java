package com.yell;

import com.yell.dao.AccountDao;
import com.yell.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * set方式
 */
public class Starter02 {
    public static void main(String[] args) {

        ApplicationContext ac = new ClassPathXmlApplicationContext("spring02.xml");

        AccountService accountService = (AccountService)ac.getBean("accountService");

        accountService.test();

    }
}
