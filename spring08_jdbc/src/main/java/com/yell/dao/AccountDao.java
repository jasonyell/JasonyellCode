package com.yell.dao;

/**
 * @program: spring08_jdbc
 * @description
 * @author: JasonYell
 * @create: 2021-03-29 11:25
 **/
public interface AccountDao {
    // 支出
    public Integer outMoney(Integer outId, Integer money);

    //收入
    public Integer inMoney(Integer inMoney, Integer money);
}
