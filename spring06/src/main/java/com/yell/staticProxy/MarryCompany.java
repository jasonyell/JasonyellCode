package com.yell.staticProxy;


/**
 * @program: spring06
 * @description
 * @author: JasonYell
 * @create: 2021-03-26 00:54
 **/
public class MarryCompany implements Marry {
    private Marry target;

    @Override
    public void toMarry() {
        target.toMarry();
    }

    @Override
    public String toMarry2(String userName) {
        return null;
    }

    // 通过带参构造的形参给目标角色赋值
    public MarryCompany(Marry target) {
        this.target = target;
    }
}
