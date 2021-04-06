package com.yell.ssm.controller;

import com.yell.ssm.exceptions.BusinessException;
import com.yell.ssm.exceptions.ParamsException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 全局异常处理
 *   需要处理异常的类，继承该类
 */
public class BaseController {
    /**
     * 这个方法是用来处理异常的
     * @param request
     * @param response
     * @param ex
     * @return
     */
    @ExceptionHandler
    public String resoverException(HttpServletRequest request, HttpServletResponse response, Exception ex){
        request.setAttribute("msg", "全局异常处理方式三 - 默认处理页面");
        //判断 异常的类型

        if(ex instanceof ParamsException){
            request.setAttribute("msg", "全局异常处理方式三 - ParamsException处理页面");
            return "params_error";
        }
        if(ex instanceof BusinessException){
            request.setAttribute("msg", "全局异常处理方式三 - BusinessException处理页面");
            return "business_error";
        }
        return "error";
    }
}
