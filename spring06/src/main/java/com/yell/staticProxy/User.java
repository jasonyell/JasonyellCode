package com.yell.staticProxy;

/**
 *  目标角色（真实角色） -- 租客
 */
public class User implements RentHouse,Marry {

    @Override
    public void toRentHourse() {
        System.out.println("我要租房子");
    }


    @Override
    public void toMarry() {
        System.out.println("我要结婚了");
    }

    @Override
    public String toMarry2(String userName) {
        System.out.println(userName + "二婚...");
        return"有返回值";
    }
}
