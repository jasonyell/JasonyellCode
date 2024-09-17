package com.yell.ssm.controller;

import com.yell.ssm.exceptions.BusinessException;
import com.yell.ssm.exceptions.ParamsException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: ssm
 * @description
 * @author: JasonYell
 * @create: 2021-04-06 13:47
 **/
@Controller
public class HelloController extends BaseController {
    @RequestMapping("test")
    public String hello(Model model) {

//        int i = 1 / 0;
        if (true) {
            // 参数异常
//            throw new ParamsException("这是一个参数异常");
            // 业务异常
        throw new BusinessException(500,"这是一个业务异常");
        }



        return "test";
    }
}
