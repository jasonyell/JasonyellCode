package com.yell.springboot.po.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @program: springboot_mybatis
 * @description
 * @author: JasonYell
 * @create: 2021-04-14 00:56
 **/
@ApiModel(description = "响应封装类")
public class ResultInfo {
    @ApiModelProperty(value = "状态码")
    private Integer code = 200;
    @ApiModelProperty(value = "提示信息")
    private String msg = "操作成功";
    @ApiModelProperty(value = "返回相应对象")
    private Object result;

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
    public Object getResult() {
        return result;
    }
    public void setResult(Object result) {
        this.result = result;
    }
}
