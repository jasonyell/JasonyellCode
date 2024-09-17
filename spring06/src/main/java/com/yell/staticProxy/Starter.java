package com.yell.staticProxy;

/**
 *  静态代理：
 *      1.目标角色固定（只能做单一代理）
 *      2.程序执行前就要得到目标角色
 *      3.代理对象会在目标对象的基础上做一些扩展
 *      4.当有大量代理行为时，会产生大量代理类，可能产生“类爆炸”
 */
public class Starter {
    public static void main(String[] args) {
//        静态代理
//        获取目标角色
        RentHouse target = new User();

//        得到一个代理角色
        Agency agency = new Agency(target);

//        代理角色实现目标角色的行为
        agency.toRentHourse();

        // 目标角色
        Marry marry = new User();
        // 代理角色
        MarryCompany marryCompany = new MarryCompany(marry);
        marryCompany.toMarry();



    }
}
