package com.yell.springboot.dao;

import com.yell.springboot.po.User;
import com.yell.springboot.query.UserQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 */
@Repository
public interface UserDao {
    // 通过用户名 查询用户对象
    public User queryUserByName(String userName);

    // 查询操作
    public User queryUserById(Integer userId);

    // 添加操作
    public int addUser(User user);

    // 更新操作
    public int updateUser(User user);

    // 删除操作
    public int deleteUser(Integer userId);

    // 分页条件查询用户列表
    public List<User> queryUserList(UserQuery userQuery);
}
