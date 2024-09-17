package com.yell;

import com.yell.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @program: spring08_jdbc
 * @description
 * @author: JasonYell
 * @create: 2021-03-29 15:24
 **/
public class Starter02 {
    public static void main(String[] args) {

        ApplicationContext ac = new ClassPathXmlApplicationContext("spring02.xml");
        AccountService accountService = (AccountService) ac.getBean("accountService");
        accountService.updateTranfer(1, 100, 2);
    }
}
