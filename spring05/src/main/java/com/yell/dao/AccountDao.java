package com.yell.dao;

import org.springframework.beans.factory.InitializingBean;

/**
 * @program: spring05
 * @description
 * @author: JasonYell
 * @create: 2021-03-24 18:29
 **/
public class AccountDao implements InitializingBean {

//        当bean对象实例化时调用
//    public void init() {
//        System.out.println("AccountDao实例化了");
//    }



    public void test() {
        System.out.println("AccountDao...");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("AccountDao实例化了");
    }

    public void destroy() {
        System.out.println("bean对象被销毁了、、、");
    }
}
