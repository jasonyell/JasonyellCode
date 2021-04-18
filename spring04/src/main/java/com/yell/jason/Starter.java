package com.yell.jason;

import com.yell.Controller.TypeController;
import com.yell.jason.Controller.ResourceController;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @program: spring04
 * @description
 * @author: JasonYell
 * @create: 2021-03-24 12:31
 **/
public class Starter {
    public static void main(String[] args) {

        BeanFactory factory = new ClassPathXmlApplicationContext("spring02.xml");

        ResourceController resourceController = (ResourceController) factory.getBean("resourceController");
        resourceController.test();

    }
}
