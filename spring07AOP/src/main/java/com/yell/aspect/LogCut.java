package com.yell.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 定义切面：
 *      设置注解
 *      有切入点与通知的结合
 *
 *      定义切入点  Poincut
 *          规定需要拦截哪些方法，那些方法需要被处理
 *          @PoinCut("匹配规则")
 *
 *      定义通知
 *          前置通知 @Before
 *          返回通知 @AfterReturning
 *          异常通知 @AfterThrowing
 *          最终通知 @After
 *          环绕通知 @Around
 *
 */
@Component    // 将对象交给 IOC 容器维护
@Aspect // 当前是切面类
public class LogCut {
    /**
     * 切入点:匹配规则，规定什么方法被拦截，需要处理什么方法
     * 定义切入点
     *
     * @Poincut("匹配规则") AOP 切入点表达式简介
     * 1.执行任意公共方法：
     *      execution(public *(..))
     * 2.执行任意set方法
     *      execution(* set*(..))
     * 3.执行com.xxxx.service包下任意类的任意方法
     *      execution(* com.xxxx.service.*.*(..))
     * 4.执行com.xxxx.service包 以及子类包下任意类的任意方法
     *      execution(* com.xxxx.service..*.*(..))
     * <p>
     * 注：表达式中的第一个*表示的是方法的修饰范围
     * 可选值：private protected public （*表示所有范围）
     */
    @Pointcut("execution(* com.yell.service..*.*(..))")
    public void cut() { }

    /**
     * 定义通知
     *  方法执行前执行的通知
     */
    @Before(value = "cut()")
    public void before() {
        System.out.println("前置通知：方法执行前执行的通知");
    }

    /**
     * 定义返回通知
     *  方法正常执行完时执行的通知
     */
    @AfterReturning(value = "cut()")
    public void afterReturn() {
        System.out.println("返回通知。。方法正常执行完时执行的通知");
    }

    /**
     * 定义最终通知
     *  方法执行结束后执行的通知(无论方法是否可以正常执行)
     */
    @After(value = "cut()")
    public void after() {
        System.out.println("最终通知。。方法执行结束后执行的通知");
    }

    /**
     * 定义异常通知
     * 当方法执行抛出异常执行的通知
     */
    @AfterThrowing(value = "cut()", throwing = "e")
    public void throwReturn(Exception e) {
        System.out.println("异常通知。。。方法执行抛出异常执行的通知" + e.getMessage());
    }

    /**
     * 定义环绕通知
     *      声明环绕通知  并将通知应用到切入点上
     *      方法执行前后 通过环绕通知定义相应处理
     *      需要通过显式调用对应的方法，否则无法访问制定方法（pjp.proceed()）
     */
    @Around(value = "cut()")
    public Object around(ProceedingJoinPoint pjp) {
        System.out.println("环绕通知  前置通知");
        Object object = null;

        try{
//            需要通过显式调用对应的方法，否则无法访问制定方法（pjp.proceed()）
            object = pjp.proceed();
            //返回通知
            System.out.println("环绕通知-返回通知");
        }catch (Throwable throwable){
            throwable.printStackTrace();
            System.out.println("环绕通知-异常通知");
        }
        // 最终通知
        System.out.println("环绕通知 最终通知");
        return object;

    }





}
