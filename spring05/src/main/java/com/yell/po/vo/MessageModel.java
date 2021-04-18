package com.yell.po.vo;

/**
 * @program: spring05
 * @description
 * @author: JasonYell
 * @create: 2021-03-24 17:59
 **/
public class MessageModel {

    private Integer code; // 状态码 1=成功 2=失败
    private String msg; // 提示信息

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "MessageModel{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }
}
