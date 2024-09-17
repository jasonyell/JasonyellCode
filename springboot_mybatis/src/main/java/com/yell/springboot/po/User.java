package com.yell.springboot.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

/**
 * @program: springboot_mybatis
 * @description
 * @author: JasonYell
 * @create: 2021-04-13 01:56
 **/
@ApiModel(description = "用户实体类")
public class User {

    @ApiModelProperty(value = "id", example = "0")
    private Integer userId;
    @ApiModelProperty(value = "用户名称")
    @NotBlank(message = "用户名不能为空")
    private String userName;

    // email 字段不是必须填写，但是如果不为空必须满足 email 格式
    @Email
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @ApiModelProperty(value = "用户密码")
    @NotBlank(message = "用户密码不能为空")
    @Length(min = 4,max=10,message = "密码长度最少4位，最长10位")
    private String userPwd;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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
}
