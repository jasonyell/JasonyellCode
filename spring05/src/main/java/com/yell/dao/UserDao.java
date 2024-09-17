package com.yell.dao;

import com.yell.po.User;
import org.springframework.stereotype.Repository;

/**
 *
 */
@Repository
public class UserDao {

//    设置姓名和密码
    private final String USERNAME = "admin";
    private final String USERPASSWORD = "123456";

    public User queryUserByName(String userName) {
//        判断用户名是否存在
        if (!USERNAME.equals(userName)) {
            return null;
        }

//        如果相等
        User user = new User();
        user.setPassword(USERPASSWORD);
        user.setUserId(1);
        user.setUsername(userName);

        return user;
    }



}
