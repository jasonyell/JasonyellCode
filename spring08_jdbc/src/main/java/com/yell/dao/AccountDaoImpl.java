package com.yell.dao;


import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @program: spring08_jdbc
 * @description
 * @author: JasonYell
 * @create: 2021-03-29 11:29
 **/
@Repository
public class AccountDaoImpl implements AccountDao {
    @Resource
    private JdbcTemplate jdbcTemplate;
    /**
     * 支出
     *      xx账户支出多少金额
     * @param outId
     * @param money
     * @return
     */

    @Override
    public Integer outMoney(Integer outId, Integer money) {
        String sql = "update tb_account set money = money - ? where account_id = ?";
        Integer row = jdbcTemplate.update(sql, money, outId);
        return row;
    }

    /**
     * 收入操作
     *      xx账户收入多少金额
     * @param inId
     * @param money
     * @return
     */
    @Override
    public Integer inMoney(Integer inId, Integer money) {
        String sql = "update tb_account set money = money + ? where account_id = ?";
        Integer row = jdbcTemplate.update(sql, money, inId);
        return row;
    }
}
