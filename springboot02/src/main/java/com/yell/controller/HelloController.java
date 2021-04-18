package com.yell.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 */
@Controller
public class HelloController {

    @RequestMapping("index")
    public String index(Model model) {
        model.addAttribute("msg", "hello SpringMVC");
        return "index";
    }

}
