package com.yell.cgLIBpRroxy;

import com.yell.staticProxy.RentHouse;
import com.yell.staticProxy.User;

/**
 * @program: spring06
 * @description
 * @author: JasonYell
 * @create: 2021-03-26 02:22
 **/
public class CglibProxyTest {
    public static void main(String[] args) {
        // 目标对象
        RentHouse target = new User();

        //得到代理类
        CglibProxy cglibProxy = new CglibProxy(target);

        //得到目标对象的代理对象
        RentHouse proxy = (RentHouse) cglibProxy.getProxy();

        // 通过代理对象调用目标对象的方法
        proxy.toRentHourse();




    }
}
