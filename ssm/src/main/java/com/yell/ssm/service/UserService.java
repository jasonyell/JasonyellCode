package com.yell.ssm.service;

import com.yell.ssm.dao.UserDao;
import com.yell.ssm.po.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jws.soap.SOAPBinding;

/**
 *
 */
@Service
public class UserService {
    @Resource
    private UserDao userDao;

    /**
     * 通过用户id查询用户对象
     * @param userId
     * @return
     */
    public User queryUserById(Integer userId) {
        User user = userDao.queryUserByUserId(userId);
        return user;
    }
}
