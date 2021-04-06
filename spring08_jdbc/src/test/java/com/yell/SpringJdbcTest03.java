package com.yell;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @program: spring08_jdbc
 * @description
 * @author: JasonYell
 * @create: 2021-03-29 13:41
 **/
@RunWith(SpringJUnit4ClassRunner.class) // 将Junit测试添加到spring环境中
@ContextConfiguration(locations = {"classpath:spring.xml"})

public class SpringJdbcTest03 {

    @Resource
    private JdbcTemplate jdbcTemplate;

    /**
     * 无参数查询
     */
    @Test
    public void testJdbc() {
        String sql = "select count(1) from t_user";
        Integer total = jdbcTemplate.queryForObject(sql, Integer.class);
        System.out.println("总记录数"+total);
    }

    /**
     * 有参数查询
     */
    @Test
    public void testJdbc1() {
        String sql = "select count(1) from t_user where id = ? and username =?";
        Integer total = jdbcTemplate.queryForObject(sql, Integer.class,1,"jason");
        System.out.println("总记录数"+total);
    }

}
