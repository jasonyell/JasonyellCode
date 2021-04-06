package com.yell.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @program: springmvc01
 * @description
 * @author: JasonYell
 * @create: 2021-04-03 02:08
 **/
@Controller
public class TestController {

    @RequestMapping("test")
    public ModelAndView test() {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("name1","jason");
        modelAndView.addObject("name2","yell");

        modelAndView.setViewName("test");

        return modelAndView;
    }
}
