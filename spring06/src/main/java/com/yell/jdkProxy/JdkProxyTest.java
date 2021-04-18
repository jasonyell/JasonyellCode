package com.yell.jdkProxy;

import com.yell.staticProxy.*;

/**
 * @program: spring06
 * @description
 * @author: JasonYell
 * @create: 2021-03-26 01:24
 **/
public class JdkProxyTest {
    public static void main(String[] args) {


        /*
        RentHouse target = new User();

////        获取代理类
//        JdkProxy jdkProxy = new JdkProxy(target);
//        //调用代理类中的方法，得到代理对象
//        RentHouse rentHouse = (RentHouse) jdkProxy.getProxy();
//        rentHouse.toRentHourse();

        Marry target2 = new User();
        JdkProxy jdkProxy1 = new JdkProxy(target2);
        Marry marry = (Marry) jdkProxy1.getProxy();

//        marry.toMarry();
        String str = marry.toMarry2("张三");
        System.out.println(str);*/

        // 没有实现接口类的目标对象
        User2 user2 = new User2();
        JdkProxy jdkProxy = new JdkProxy(user2);
        User2 proxy = (User2) jdkProxy.getProxy();
        proxy.test();

    }
}
