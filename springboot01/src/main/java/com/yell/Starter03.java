package com.yell;

import com.yell.config.IocConfig02;
import com.yell.config.IocConfig03;
import com.yell.dao.AccountDao;
import com.yell.service.AccountService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @program: springboot01
 * @description
 * @author: JasonYell
 * @create: 2021-04-07 01:45
 **/
public class Starter03 {
    public static void main(String[] args) {
        // 基于 java 配置类 获取spring上下文环境
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(IocConfig03.class);

        // 得到bean对象
        IocConfig03 iocConfig03 = ac.getBean(IocConfig03.class);

//        iocConfig03.test();

        AccountService accountService = ac.getBean(AccountService.class);
        accountService.test();

    }
}
