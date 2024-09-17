package com.yell.ssm.dao;

import com.yell.ssm.po.User;
import org.springframework.stereotype.Repository;

/**
 *
 */
@Repository
public interface UserDao {
    // 通过用户ID查询用户对象
    User queryUserByUserId(Integer userId);
}
