package com.yell.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: springboot04
 * @description
 * @author: JasonYell
 * @create: 2021-04-12 02:10
 **/
@Controller
public class HelloController {

    @RequestMapping("index")
    public String index(HttpServletRequest request) {
        // 设置请求域
        request.setAttribute("msg", "Hello");
        return "index";
    }
}
