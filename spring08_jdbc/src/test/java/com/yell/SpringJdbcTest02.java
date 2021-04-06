package com.yell;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @program: spring08_jdbc
 * @description
 * @author: JasonYell
 * @create: 2021-03-29 13:41
 **/

public class SpringJdbcTest02 {

    private JdbcTemplate jdbcTemplate;

    /**
     * 单元测试方法前执行
     */
    @Before
    public void init() {
        //获取上下文
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
        // 获取模板类
        jdbcTemplate = (JdbcTemplate) ac.getBean("jdbcTemplate");
    }
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
