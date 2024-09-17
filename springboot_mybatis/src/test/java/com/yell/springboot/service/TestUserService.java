package com.yell.springboot.service;

import com.yell.springboot.Starter;
import com.yell.springboot.query.UserQuery;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @program: springboot_mybatis
 * @description
 * @author: JasonYell
 * @create: 2021-04-15 02:28
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Starter.class})
public class TestUserService {

    private Logger log = LoggerFactory.getLogger(TestUserService.class);

    @Resource
    private UserService userService;

    /**
     * 单元测试进行前
     */
    @Before
    public void
    before(){ log.info("单元测试开始...");
    }

    /**
     * 单元测试
     */
    @Test
    public void test01(){
        log.info("用户记录：{}", userService.queryUserById(1).toString());
    }

    @Test
    public void test02(){
        log.info("用户记录：{}", userService.queryUserList(new UserQuery()).toString());
    }

    /**
     * 单元测试进行后
     */
    @After
    public void
    after(){ log.info("单元测试结束...");
    }
}
