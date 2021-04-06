package com.yell.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 切面(通过xml方式)
 *
 */
@Component    // 将对象交给 IOC 容器维护

public class LogCut02 {
    /**
     * 切入点:匹配规则，规定什么方法被拦截，需要处理什么方法
     * 定义切入点
     * 可选值：private protected public （*表示所有范围）
     */
    public void cut() { }

    /**
     * 定义通知
     *  方法执行前执行的通知
     */
    public void before() {
        System.out.println("前置通知：方法执行前执行的通知2");
    }

    /**
     * 定义返回通知
     *  方法正常执行完时执行的通知
     */
    public void afterReturn() {
        System.out.println("返回通知。。方法正常执行完时执行的通知2");
    }

    /**
     * 定义最终通知
     *  方法执行结束后执行的通知(无论方法是否可以正常执行)
     */
    public void after() {
        System.out.println("最终通知。。方法执行结束后执行的通知2");
    }

    /**
     * 定义异常通知
     * 当方法执行抛出异常执行的通知
     */
    public void throwReturn(Exception e) {
        System.out.println("异常通知。。。方法执行抛出异常执行的通知2" + e.getMessage());
    }

    /**
     * 定义环绕通知
     *      声明环绕通知  并将通知应用到切入点上
     *      方法执行前后 通过环绕通知定义相应处理
     *      需要通过显式调用对应的方法，否则无法访问制定方法（pjp.proceed()）
     */
    public Object around(ProceedingJoinPoint pjp) {
        System.out.println("环绕通知 - 前置通知2");
        Object object = null;
        try{
//            需要通过显式调用对应的方法，否则无法访问制定方法（pjp.proceed()）
            object = pjp.proceed();
            //返回通知
            System.out.println("环绕通知 - 返回通知2");
        }catch (Throwable throwable){
            throwable.printStackTrace();
            System.out.println("环绕通知 - 异常通知2");
        }
        // 最终通知
        System.out.println("环绕通知 最终通知2");
        return object;
    }





}
