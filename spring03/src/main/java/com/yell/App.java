package com.yell;

import com.yell.dao.UserDao;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * @program: spring02
 * @description
 *      springIOC 加载配置文件
 *         1.单个配置文件加载
 *              相对路径
 *              绝对路径（了解）
 *         2.多个配置文件在家
 *              可变参数，可同时传入多个文件
 *              通过 import 导入，加载总配置文件
 * @author: JasonYell
 * @create: 2021-03-23 02:10
 **/
public class App {
    public static void main(String[] args) {
        /**
         * 单个文件加载
         */

        // 相对路径
//        ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
        // 绝对路径
//        ApplicationContext ac = new FileSystemXmlApplicationContext("H:\\BitWeb\\workspaces\\SpringStudy\\spring03\\src\\main\\resources\\spring.xml");

//        BeanFactory factory = new ClassPathXmlApplicationContext("spring.xml");

        /**
         * 多文件加载
         */
        // 通过可变参数
//        ApplicationContext ac = new ClassPathXmlApplicationContext("dao.xml","service.xml");
        // 通过 import 导入，加载总配置文件
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        UserDao userDao = (UserDao) ac.getBean("userDao");
        System.out.println(userDao);
        userDao.test();

    }
}
