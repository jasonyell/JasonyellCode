package com.yell.factory;

/**
 * 工厂接口：
 *      定义获取 bean 对象的方式
 */
public interface MyFactory {
    // 通过 id 属性获取 bean 对象
    public Object getBean(String id);
}
