package com.jasonyell.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @program: Fo
 * @description
 * @author: JasonYell
 * @create: 2020-11-04 01:42
 **/

@Getter
@Setter
@ToString
public class Response {

    private boolean success;    // 业务是否处理成功
    private String code;        // 错误码
    private String message;     // 错误消息
    private Object data;        // 业务字段
    private String stackTrace;  // 出现异常时， 堆栈信息
    private Integer total;      // 分页操作时，需要的总数量


}
