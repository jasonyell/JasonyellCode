package com.yell.springmvc.po;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: springmvc01
 * @description
 * @author: JasonYell
 * @create: 2021-04-03 16:51
 **/

public class User {
    private Integer id;
    private String userName;
    private String userPwd;
    // 集合
    private List<String> strList = new ArrayList<>();

    //    map
    private Map<String, String> map = new HashMap<>();

    public List<String> getStrList() {
        return strList;
    }

    public void setStrList(List<String> strList) {
        this.strList = strList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", userPwd='" + userPwd + '\'' +
                ", strList=" + strList +
                ", map=" + map +
                '}';
    }
}
