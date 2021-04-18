package com.yell.staticProxy;

/**
 * 代理角色 -- 中介
 * 实现目标角色的行为，并增强用户行为
 */
public class Agency implements RentHouse {

    // 目标对象
    private RentHouse target;

    public Agency(RentHouse target) {
        this.target = target;
    }

    @Override
    public void toRentHourse() {
        // 功能扩展
        System.out.println("发布租房信息");

        // 实现目标角色的方法
        target.toRentHourse();

        // 功能的扩展
        System.out.println("准备合同");

    }
}
