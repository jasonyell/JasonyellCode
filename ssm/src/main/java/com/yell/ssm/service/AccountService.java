package com.yell.ssm.service;

import com.yell.ssm.dao.AccountDao;
import com.yell.ssm.po.Account;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 *
 */
@Service
public class AccountService {
    @Resource
    private AccountDao accountDao;

//    查询操作
    public Account queryAccountById(Integer id) {
        return accountDao.queryAccountById(id);
    }

    // 删除操作
    public Integer deleteAccountById(Integer id) {
        return accountDao.deleteAccountById(id);
    }

    //添加用户
    public Integer addAccount(Account account) {
        return accountDao.addAccount(account);
    }

    // 更新操作
    public Integer updateAccount(Account account) {
        return accountDao.updateAccount(account);
    }

}
