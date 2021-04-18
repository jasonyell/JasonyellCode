package com.yell.springboot.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yell.springboot.dao.UserDao;
import com.yell.springboot.po.User;
import com.yell.springboot.query.UserQuery;
import com.yell.springboot.util.AssertUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @program: springboot_mybatis
 * @description
 * @author: JasonYell
 * @create: 2021-04-13 02:04
 **/
@Service
public class UserService {

    @Resource
    private UserDao userDao;

    /**
     * 通过用户姓名查询对象
     * @param name
     * @return
     */
    public User queryUserByName(String name) {
        User user = userDao.queryUserByName(name);
        return user;
    }

    /**
     * 通过用户ID查询对象
     * @param id
     * @return
     */
    @Cacheable(value = "users",key = "#id")
    public User queryUserById(Integer id) {
        //抛出异常
        AssertUtil.isTrue(true,"自定义异常");
        User user = userDao.queryUserById(id);
        return user;
    }

    /**
     * 添加用户
     *  1.非空校验（用户名和密码是否为空）
     *      StringUtils.isBlank("字符串") 返回true，则表示为空
     *  2.用户名的唯一性（通过用户名查询用户记录）
     *          如果用户对象存在 则用户名不可用
     *  3.添加用户记录 判断受影响的行数
     * @param user
     */
    // 事务处理机制
    @Transactional(propagation = Propagation.REQUIRED)
    public void addUser(User user) {

        //非空判断    用户名和密码是否为空
        AssertUtil.isTrue(StringUtils.isBlank(user.getUserName()),"用户名不可为空");
        AssertUtil.isTrue(StringUtils.isBlank(user.getUserPwd()),"用户密码不可为空");
        // 验证用户名的唯一性（通过用户名查询用户记录)
        User temp = userDao.queryUserByName(user.getUserName());
        //判断指定用户名查询的用户对象是否存在
        AssertUtil.isTrue(null != temp,"用户名已存在，请重试");

        // 添加用户记录 判断受影响的行数
        AssertUtil.isTrue(userDao.addUser(user)<1,"用户添加失败");

    }

    /**
     * 更新操作
     *      1.非空校验 （用户和密码，用户ID）
     *      2.用户名的唯一性 (通过用户名查询用户对象)
     *             如果用户名不存在可用
     *             用户名存在
     *                  判断存在的用户是否是当前需要修改的记录(通过ID)
     *      3.更新用户记录 判断影响的行数
     * @param user
     */
    @Transactional(propagation = Propagation.REQUIRED)
    @CachePut(value = "users", key = "#user.userId")
    public User updateUser(User user) {
        //非空判断    用户名和密码是否为空
        AssertUtil.isTrue(StringUtils.isBlank(user.getUserName()),"用户名不可为空");
        AssertUtil.isTrue(StringUtils.isBlank(user.getUserPwd()),"用户密码不可为空");
        AssertUtil.isTrue(user.getUserId() == null, "系统异常,请重试!!!");

        // 验证用户名的唯一性（通过用户名查询用户记录)
        User temp = userDao.queryUserByName(user.getUserName());
        AssertUtil.isTrue(temp != null && !(user.getUserId().equals(temp.getUserId())), "用户名已存在请重试");

        // 更新操作
        AssertUtil.isTrue(userDao.updateUser(user) < 1, "更新失败");

        return user;
    }

    /**
     * 删除用户
     *      1. 判断 ID 是否为空
     *      2. 查询指定id的用户记录是否存在
     *      3.执行删除操作，判断受影响的行数
     * @param userId
     */
    @CacheEvict(value = "users",key="#userId")
    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteUser(Integer userId) {
        // 判断 ID 是否为空 查询指定id的用户记录是否存在
        AssertUtil.isTrue(userId == null || userDao.queryUserById(userId) == null, "待删除的记录不存在");
        // 执行删除操作
        AssertUtil.isTrue(userDao.deleteUser(userId) < 1, "删除失败");
    }

    /**
     * 分页查询用户集合
     * @param userQuery
     * @return
     */
    @Cacheable(value = "users",key="#userQuery.userName+'-'+#userQuery.pageNum+'-'+#userQuery.pageSize")
    public PageInfo<User> queryUserList(UserQuery userQuery) {
        // 开启分页
        PageHelper.startPage(userQuery.getPageNum(), userQuery.getPageSize());
        // 返回分页对象
        return new PageInfo<User>(userDao.queryUserList(userQuery));
    }

}
