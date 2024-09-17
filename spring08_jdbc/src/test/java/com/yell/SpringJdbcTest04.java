package com.yell;

import com.yell.po.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.nio.channels.AcceptPendingException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @program: spring08_jdbc
 * @description
 * @author: JasonYell
 * @create: 2021-03-29 13:41
 **/
public class SpringJdbcTest04 extends BasicJdcb {
    @Resource
    private JdbcTemplate jdbcTemplate;

    /**
     * 无参数查询
     */
    @Test
    public void testJdbc() {
        String sql = "select count(1) from tb_account";
        Integer total = jdbcTemplate.queryForObject(sql, Integer.class);
        System.out.println("总记录数"+total);
    }

    /**
     * 有参数查询
     */
    @Test
    public void testJdbc1() {
        String sql = "select count(1) from tb_account where account_id = ? and account_name =?";
        Integer total = jdbcTemplate.queryForObject(sql, Integer.class,1,"admin");
        System.out.println("总记录数"+total);
    }

    /**
     * 查询
     */
    @Test
    public void test() {
        String sql = "select account_name from tb_account where account_name = ?";
        //查询返回值是String
        String name1 = jdbcTemplate.queryForObject(sql, new String[]{"admin"}, String.class);
        String name2 = jdbcTemplate.queryForObject(sql, String.class, "admin");
        System.out.println(name1);
        System.out.println(name2);

        //查询返回值是对象
        String sql2 = "select * from tb_account where account_id = ?";
//        RowMapper rowMapper = new RowMapper() {
//            @Override
//            public Object mapRow(ResultSet resultSet, int i) throws SQLException {
//                Account account = new Account();
//                account.setAccountId(resultSet.getInt("account_id"));
//                account.setAccountName(resultSet.getString("account_name"));
//                account.setMoney(resultSet.getDouble("money"));
//                return account;
//            }
//        };

        RowMapper rowMapper = (resultSet,i) ->{
            Account account = new Account();
            account.setAccountId(resultSet.getInt("account_id"));
            account.setAccountName(resultSet.getString("account_name"));
            account.setMoney(resultSet.getDouble("money"));
            return account;
        };
        Account account = (Account) jdbcTemplate.queryForObject(sql2, rowMapper,1);
        System.out.println(account);


        // 查询集合
        List<Account> accountList = jdbcTemplate.query(sql2, (resultSet, i) -> {
            Account account1 = new Account();
            account.setAccountId(resultSet.getInt("account_id"));
            account.setAccountName(resultSet.getString("account_name"));
            account.setMoney(resultSet.getDouble("money"));
            return account1;
        }, 1);

        System.out.println(accountList);

    }
}
