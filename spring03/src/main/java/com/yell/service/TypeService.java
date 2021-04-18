package com.yell.service;

import com.yell.dao.TypeDao;
import com.yell.dao.UserDao;
import org.w3c.dom.UserDataHandler;

/**
 * 构造器注入
 */
public class TypeService {

//    private TypeDao typeDao;
//    // 提供带参构造
//    public TypeService(TypeDao typeDao) {
//        this.typeDao = typeDao;
//    }

    private TypeDao typeDao;
    private UserDao userDao;
    private String name;

//    public TypeService(TypeDao typeDao, UserDao userDao) {
//        this.typeDao = typeDao;
//        this.userDao = userDao;
//    }


    public TypeService(TypeDao typeDao, UserDao userDao, String name) {
        this.typeDao = typeDao;
        this.userDao = userDao;
        this.name = name;
    }

    public void test() {
        System.out.println("TypeService...");
        typeDao.test();
        userDao.test();
        System.out.println(name);

    }
}
