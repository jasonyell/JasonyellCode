package com.yell;

import com.yell.service.AccountService;
import com.yell.service.TypeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @program: spring03
 * @description
 * @author: JasonYell
 * @create: 2021-03-24 00:42
 **/
public class Starter03 {
    public static void main(String[] args) {

        ApplicationContext ac = new ClassPathXmlApplicationContext("spring03.xml");

        TypeService typeService = (TypeService) ac.getBean("typeService");

        typeService.test();

    }
}
