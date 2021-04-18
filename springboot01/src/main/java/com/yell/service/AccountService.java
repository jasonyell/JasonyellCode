package com.yell.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class AccountService {

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
}
