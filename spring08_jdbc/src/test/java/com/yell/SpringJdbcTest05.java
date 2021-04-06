package com.yell;

import com.yell.po.Account;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: spring08_jdbc
 * @description
 * @author: JasonYell
 * @create: 2021-03-29 13:41
 **/
public class SpringJdbcTest05 extends BasicJdcb {
    @Resource
    private JdbcTemplate jdbcTemplate;

    /**
     * 更新操作
     */
    @Test
    public void testUpdate() {

        String sql1 = "insert into tb_account (account_name,account_type,money,remark) values (?,?,?,?)";
        Integer row = jdbcTemplate.update(sql1, "jason", "中国银行", 1000, "工资");
        System.out.println(row);

    }

    /**
     * 修改操作
     */
    @Test
    public void testUpdate1() {

        String sql1 = "update tb_account set money = ? ,account_type=?  where account_id = ?";
        Integer row = jdbcTemplate.update(sql1, 2000, "浦发银行", 3);
        System.out.println(row);

    }

    /**
     * 删除操作
     */
    @Test
    public void testUpdate2() {

        String sql1 = "delete from tb_account where account_id = ?";
        Integer row = jdbcTemplate.update(sql1, 3);
        System.out.println(row);

    }

}
