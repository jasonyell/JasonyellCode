package com.yell.springmvc.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *  拦截器的实现
 *      实现HandlerInterceptor接口
 */
public class MyInterceptor01 implements HandlerInterceptor{
    /**
     * 在 目标方法(Handler) 执行前 执行
     *      返回值：布尔类型
     *          如果返回true，执行目标方法
     *          如果返回false，阻止目标方法执行
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("在目标方法(Handler) 执行前，执行 --> myInterceptor01 -- preHandle");
        //目标方法不执行
//        return false;
        // 目标方法执行
        return true;
    }

    /**
     * 在 目标方法执行后，但是在视图生成前  执行
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("在目标方法(Handler) 执行前，执行 --> myInterceptor01 -- postHandle");
    }

    /**
     * 在目标方法执行后 视图生成后 执行
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("在目标方法(Handler) 执行后，执行 --> myInterceptor01 -- afterCompletion");
    }
}
