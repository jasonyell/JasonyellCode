package com.yell.config;

import com.yell.annotation.MyComScan;
import com.yell.service.AccountService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.annotation.Resource;

// 自定义组合注解
@MyComScan("com.yell")
// 通过 @PropertySource 加载配置文件，结合 @Value 注解获取制定 key 的 value
@PropertySource(value = {"classpath:jdbc.properties","classpath:user.properties"})
public class IocConfig04 {

    @Value("${jdbc.driver}")
    private String driver;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String name;
    @Value("${jdbc.password}")
    private String pwd;
    @Value("${user.password}")
    private String userPwd;
    @Value("${user.userName}")
    private String userName;

    public void test() {
        System.out.println(driver + ". " + url);
        System.out.println(name + ". " + pwd);
        System.out.println(userName + ". " + userPwd);
    }

    @Resource
    private AccountService accountService;

}
