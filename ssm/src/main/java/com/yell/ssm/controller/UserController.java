package com.yell.ssm.controller;

import com.yell.ssm.po.User;
import com.yell.ssm.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * @program: ssm
 * @description
 * @author: JasonYell
 * @create: 2021-04-05 03:38
 **/
@Controller
@RequestMapping("user")
public class UserController {
    @Resource
    private UserService userService;

    /**
     * 通过用户 id 查询用户
     * @param userId
     * @param model
     * @return
     */
    @RequestMapping("queryUserByUserId")
    public String hello(Integer userId, Model model) {
        User user = userService.queryUserById(userId);

        // 设置数据类型
        model.addAttribute("user", user);

        return "hello";
    }
}
