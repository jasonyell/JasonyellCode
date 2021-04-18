package com.yell;

import com.yell.config.IocConfig03;
import com.yell.config.IocConfig04;
import com.yell.service.AccountService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @program: springboot01
 * @description
 * @author: JasonYell
 * @create: 2021-04-07 01:45
 **/
public class Starter04 {
    public static void main(String[] args) {
        // 基于 java 配置类 获取spring上下文环境
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(IocConfig04.class);

        // 得到bean对象
        IocConfig04 iocConfig04 = ac.getBean(IocConfig04.class);

        iocConfig04.test();

    }
}
