package com.yell.springboot.util;

import com.yell.springboot.exception.ParamsException;

/**
 * 工具类
 */
public class AssertUtil {
    /**
     * 判断返回值是否为 true
     *  如果为true 抛出异常
     * @param flag
     * @param msg
     */
    public static void isTrue(boolean flag, String msg) {
        // 如果为true，则，抛出异常
        if (flag) {
            throw new ParamsException(msg);
        }
    }

}
