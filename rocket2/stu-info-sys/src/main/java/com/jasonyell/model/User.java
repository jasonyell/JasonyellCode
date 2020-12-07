package com.jasonyell.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;


/**
 * @program: Fo
 * @description
 * @author: JasonYell
 * @create: 2020-11-04 23:59
 **/
@Setter
@Getter
@ToString
public class User {
    private Integer id;

    /**
     * 用户账号
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 用户昵称
     */
    private String nickname;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 创建时间
     */
    private Date createTime;
}
