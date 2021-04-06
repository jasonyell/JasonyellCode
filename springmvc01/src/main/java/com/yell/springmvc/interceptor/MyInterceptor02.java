package com.yell.springmvc.interceptor;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *   拦截器实现
 *      继承 HandlerInterceptorAdapter 适配器
 */
public class MyInterceptor02 extends HandlerInterceptorAdapter {
    /**
     * 在目标方法执行前执行
     *      true 执行
     *      false 不执行
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("在目标方法执行器那执行 --> MyInterceptor02 ");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("在目标方法(Handler) 执行前，执行 --> MyInterceptor02 -- postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("在目标方法(Handler) 执行后，执行 --> MyInterceptor02 -- afterCompletion");
    }
}
