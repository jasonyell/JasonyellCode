package com.yell.jdkProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * JDK动态代理
 *      通过 Proxy 类中 newProxyInstance 返回一个代理类
 *
 *      注：使用JDK动态代理类，必须要有接口实现
 */
public class JdkProxy {

    //目标角色
    private Object target;

    // 通过带参构造，传递目标对象
    public JdkProxy(Object target) {
        this.target = target;
    }

    /**
     *  得到代理对象
     *      newProxyInstance() 返回指定接口的代理类的实例，该接口将方法调用分派给指定的调用处理程序。
     *      loader - 一个Classloader对象，定义由那个类加载器来定义代理类
     *      interfaces - 一个Interface对象的数组，表示的是我将要给我需要代理对象提供一组什么借口
     *      h - 一个InvocationHandler接口，表示代理实例的调用处理程序实现的接口， 每个代理实力都具有一个 关联的调用处理实例
     */

    public Object getProxy() {
        //        得到类加载器
        ClassLoader classLoader = this.getClass().getClassLoader();

        //        得到目标角色实现的接口数组
        Class[] interfaces = target.getClass().getInterfaces();

        //        一个InvocationHandler 接口
        InvocationHandler invocationHandler = new InvocationHandler() {
            /**
             * 当代理实例中对应的方法被调用时，invoke 方法就会执行一次
             *      1.调用目标对象的方法（返回Object）
             *      2.增强目标对象的行为
             * @param proxy 调用该实例的代理对象
             * @param method    目标对象的方法
             * @param args      目标对象方法的形参
             * @return
             * @throws Throwable
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                // System.out.println("invoke...");

                // 目标对象方法名
                // System.out.println(method.getName());


                // 目标对象的形参
                System.out.println(args[0]);

                // 目标增强
                System.out.println("方法执行前。。。");


                // 调用目标对象中的方法  invoke
                Object object = method.invoke(target, args);

                // 方法执行后
                System.out.println("方法执行后后");

                // 方法的返回值 (目标方法的返回值)
                return object;
            }
        };
        //得到代理实例(代理实例)
        Object proxy = Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);

        // 返回代理
        return proxy;
    }



}
