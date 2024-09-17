package com.yell.ssm;

import com.yell.ssm.exceptions.BusinessException;
import com.yell.ssm.exceptions.ParamsException;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 *
 */
//@Component
public class GlobalExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        ModelAndView modelAndView = new ModelAndView();
//        // 设置出现异常，需要跳转的页面
//        modelAndView.setViewName("error");
//        // 设置对应的异常信息
//        modelAndView.addObject("msg", "出现异常了...");

        /**
         * 设置自定义异常的处理方式
         */
        // 判断异常对应是否是指定的异常
        if (e instanceof ParamsException) {
            modelAndView.setViewName("params_error");
            ParamsException p = (ParamsException) e;
            modelAndView.addObject("msg", p.getMsg());
        } else if(e instanceof BusinessException){
            modelAndView.setViewName("business_error");
            BusinessException p = (BusinessException) e;
            modelAndView.addObject("msg", p.getMsg());
            modelAndView.addObject("code", p.getCode());
        }



        return modelAndView;
    }
}
