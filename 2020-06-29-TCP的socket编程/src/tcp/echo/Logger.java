package tcp.echo;

import java.util.Date;

/**
 * @program: 2020-06-29-TCP的socket编程
 * @description
 *      打印日子的代码 封装
 * @author: JasonYell
 * @create: 2020-09-16 02:24
 **/
public class Logger {
    public static void debug(String message) {
        System.out.printf("%s:%s: DEBUG :%s%n",Thread.currentThread().getName(), new Date(),message);
    }
    public static void error(String message) {
        System.out.printf("%s:%s:%s: ERROW :%s%n",Thread.currentThread().getName() ,new Date(),message);
    }
}
