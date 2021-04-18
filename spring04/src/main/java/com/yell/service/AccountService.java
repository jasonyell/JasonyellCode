package com.yell.service;

import com.yell.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 *      @Autowired
 *          1.默认根据class类型查找，与属性字段名无关
 *          2.属性字段可以提供set方法 也可以不提供
 *          3.注解可以声明在字段名 或者 set方法
 *          4.@Qualifier(value = "")  可以结合注解的value 属性值设置注入对象的名称，如果设置了注解，则要求VALUSE值与bean的id属性值一致
 *
 */
public class AccountService {

    @Autowired
    @Qualifier(value = "ac")
    private AccountDao accountDao;

    public void test() {
        System.out.println("AccountService...");
        accountDao.test();
    }
}
