package com.jasonyell.util;

/**
 * @program: Fo
 * @description
 *
 *      ThreadLocal 是线程本地存储，在每个线程中都创建了一个 ThreadLocalMap 对象，
 *                  每个线程可以访问自己内部 ThreadLocalMap 对象内的 value。
 *      经典的使用场景是为每个线程分配一个 JDBC 连接 Connection。
 *      这样就可以保证每个线程的都在各自的 Connection 上进行数据库的操作，
 *      不会出现 A 线程关了 B 线程正在使用的 Connection;
 *      还有 Session 管理等问题
 *
 * @author: JasonYell
 * @create: 2020-11-15 01:08
 **/
public class ThreadLocalHolder {

    private static ThreadLocal<Integer> TOTAL = new ThreadLocal<>();

    public static ThreadLocal<Integer> getTOTAL() {
        return TOTAL;
    }

}
