package com.yell.factory;

import com.yell.dao.UserDao;

/**
 * 实例化工厂  实例化
 *     1.定义工厂类
 *     2.定义方法，返回需要被实例化的bean对象
 */
public class InstanceFactory {
    /**
     * 普通方法
     * @return
     */
    public UserDao createDao() {
        System.out.println("实例化工厂实例化");
        return new UserDao();
    }
}
