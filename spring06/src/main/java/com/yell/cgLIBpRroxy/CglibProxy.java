package com.yell.cgLIBpRroxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * cgLib 动态代理
 *      采用的是继承思想，生成一个子类继承目标对象，（目标类不能用final修饰）
 */
public class CglibProxy {

    // 准备目标对象
    private Object target;

    // 通过构造器，传递目标对象
    public CglibProxy(Object target) {
        this.target = target;
    }

    /**
     *  得到代理对象
     * @return
     */
    public Object getProxy() {
        // 通过Enhancer对象，通过调用Enhance的create()方法，生成一个类(代理对象)
        Enhancer enhancer = new Enhancer();

        // 设置父类，（将目标对象设置为当前生成类的父类）
        enhancer.setSuperclass(target.getClass());


        MethodInterceptor methodInterceptor = new MethodInterceptor() {
            /**
             * 没当代理实例中的方法被调用一次，intercept就会执行一次
             * @param o
             * @param method
             * @param objects
             * @param methodProxy
             * @return
             * @throws Throwable
             */
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("intercept。。。");

                // 增强行为
                System.out.println("方法执行前");

                // 调用目标对象的方法
                Object object = methodProxy.invoke(target, objects);

                System.out.println("方法执行后");
                return object;
            }
        };

        // 设置拦截器
        enhancer.setCallback(methodInterceptor);
        // 返回生成的代理类
         return enhancer.create();

    }


}
