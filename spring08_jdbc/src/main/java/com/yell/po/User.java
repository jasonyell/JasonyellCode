package com.yell.po;

/**
 * @program: spring08_jdbc
 * @description
 * @author: JasonYell
 * @create: 2021-03-29 23:57
 **/
public class User {
    private String userName;
    private Integer age;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
