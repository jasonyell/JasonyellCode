package com.yell.service;

import com.yell.dao.AccountDaoImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @program: spring08_jdbc
 * @description
 * @author: JasonYell
 * @create: 2021-03-29 11:27
 **/
@Service
public class AccountService {

    @Resource
    private AccountDaoImpl accountDao;

    /**
     * 事物的使用
     * @param outId
     * @param money
     * @param inId
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void updateTranfer(Integer outId, Integer money, Integer inId) {
        // 支出操作
        Integer row = accountDao.outMoney(outId, money);

//        int i = 1 / 0;

        // 收入操作
        Integer row2 = accountDao.inMoney(inId, money);

        if (row == 1 && row2 == 1) {
            System.out.println("成功");
        }else {
            System.out.println("失败");
        }

    }
}
