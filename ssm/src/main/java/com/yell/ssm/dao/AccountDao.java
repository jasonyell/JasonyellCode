package com.yell.ssm.dao;

import com.yell.ssm.po.Account;
import org.springframework.stereotype.Repository;

/**
 *
 */
@Repository
public interface AccountDao {
    //查询 通过 ID 查询用户对象
    public Account queryAccountById(Integer id);

    //删除 通过 ID 删除用户对象
    public Integer deleteAccountById(Integer id);

    //添加 添加用户对象
    public Integer addAccount(Account account);

    //修改 修改用户对象
    public Integer updateAccount(Account account);


}
