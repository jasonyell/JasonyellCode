package com.yell.po;

/**
 * Bean 对象
 *  用来接受配置文件（Spring.xml）中，bean 标签的 id 与 class 属性
 */
public class MyBean {
    private String id; // bean 标签的 id 属性值
    private String clazz;   // bean 标签的 class 属性值

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public MyBean(String id, String clazz) {
        this.id = id;
        this.clazz = clazz;
    }

    public MyBean() {
    }
}
