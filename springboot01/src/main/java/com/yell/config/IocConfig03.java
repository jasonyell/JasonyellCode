package com.yell.config;

import com.yell.dao.AccountDao;
import com.yell.service.AccountService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.annotation.Resource;


@Configuration  //标记当前类作为一个配置类，相当于xml配置文件 组合注解
@ComponentScan(value = "com.yell")  // 设置扫描包的范围
// 通过 @PropertySource 加载配置文件，结合 @Value 注解获取制定 key 的 value
@PropertySource(value = {"classpath:jdbc.properties","classpath:user.properties"})
public class IocConfig03 {

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
