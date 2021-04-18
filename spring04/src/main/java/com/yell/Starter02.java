package com.yell;

import com.yell.Controller.TypeController;
import com.yell.dao.AccountDao;
import org.springframework.beans.TypeConverter;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @program: spring04
 * @description
 * @author: JasonYell
 * @create: 2021-03-24 12:31
 **/
public class Starter02 {
    public static void main(String[] args) {

        BeanFactory factory = new ClassPathXmlApplicationContext("spring02.xml");

        TypeController typeController = (TypeController) factory.getBean("typeController");
        typeController.test();

    }
}
