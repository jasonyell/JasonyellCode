package com.yell.service;

import com.yell.dao.AccountDao;
import com.yell.dao.IUserDao;
import com.yell.dao.UserDao;

import javax.annotation.Resource;

/**
 *   Spring IOC 自动注入
 *       @Resource  注解
 *          1.默认使用字段名查找 bean 标签 (属性字段名 与 bean 的 id 属性名一致)
 *          2.吐过属性字段名与bean标签的id属性值不一致 会使用class类型查找
 *          3.属性字段可以提供set方法，也可以不提供
 *          4.注解可以声明在属性字段名上或者set方法上
 *          5.可以通过注解的name属性查找方式，如果设置了name属性，则让 name 属性与 bean 标签的 id 属性值保持一致
 *          5.如果注入对象是接口，一个实现则正常实现，如果有多个实现，则需要使用 name 来制定对应的实现类对象
 */
public class UserService {

    //直接将声明在字段上
    @Resource
    private UserDao userDao;
    @Resource
    private AccountDao accountDao;

    // 接口注入
    @Resource(name="userDao01")
    private IUserDao iUserDao;

    public void test() {
        System.out.println("userService...");
        userDao.test();
        accountDao.test();
        iUserDao.test();

    }

}
