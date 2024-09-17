package com.yell;

import com.yell.config.IocConfig;
import com.yell.config.IocConfig02;
import com.yell.dao.AccountDao;
import com.yell.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @program: springboot01
 * @description
 * @author: JasonYell
 * @create: 2021-04-07 01:45
 **/
public class Starter02 {
    public static void main(String[] args) {
        // 基于 java 配置类 获取 spring 上下文环境
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(IocConfig02.class);

        // 得到bean对象
        IocConfig02 iocConfig02 = ac.getBean(IocConfig02.class);

        AccountDao accountDao01 = iocConfig02.accountDao();
        AccountDao accountDao02 = iocConfig02.accountDao();

        System.out.println(accountDao01 + "  " + accountDao02);


    }
}
