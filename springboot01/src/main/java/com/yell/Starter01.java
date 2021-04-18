package com.yell;

import com.yell.config.IocConfig;
import com.yell.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @program: springboot01
 * @description
 * @author: JasonYell
 * @create: 2021-04-07 01:45
 **/
public class Starter01 {
    public static void main(String[] args) {
        // 基于 java 配置类 获取spring上下文环境
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(IocConfig.class);

        // 得到bean对象
        UserService userService = ac.getBean(UserService.class);

        userService.test();
    }
}
