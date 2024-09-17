package com.yell.factory;

import com.yell.dao.UserDao;
import com.yell.service.UserService;

/**
 * 静态工厂实例化
 *      1.静态工厂类
 *      2.定义静态方法，并返回需要被实例化的Bean对象
 */
public class StaticFactory {
    /**
     * 静态方法
     * @return
     */
    public static UserService createService() {
        System.out.println("静态工厂实例化");
        return new UserService();
    }

    public static UserDao createDao() {
        return new UserDao();
    }

}
