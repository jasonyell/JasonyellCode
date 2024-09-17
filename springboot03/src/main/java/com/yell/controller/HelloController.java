package com.yell.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @program: springboot03
 * @description
 * @author: JasonYell
 * @create: 2021-04-08 02:20
 **/
@Controller
public class HelloController {


    @RequestMapping("hello")
    @ResponseBody
    public String hello() {
        return "Hello SpringBoot";
    }
}
