package com.yell.springmvc.controller;

import com.yell.springmvc.po.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.management.modelmbean.ModelMBeanOperationInfo;
import javax.servlet.http.HttpSession;

/**
 * @program: springmvc01
 * @description
 * @author: JasonYell
 * @create: 2021-04-04 02:05
 **/
@Controller
@RequestMapping("user")
public class UserController {

    @RequestMapping("login")
    public String login(Model model, HttpSession httpSession) {

        model.addAttribute("action", "用户登录");

        // 如果执行登录操作，则表示用户处于登录状态，设置session作用域
        User user = new User();
        user.setId(1);
        user.setUserName("admin");
        httpSession.setAttribute("user",user);

        return "success";
    }

    /**
     * 用户添加
     * @param model
     * @return
     */
    @RequestMapping("add")
    public String add(Model model) {
        model.addAttribute("action", "用户添加");
        return "success";
    }
    /**
     * 用户修改
     * @param model
     * @return
     */
    @RequestMapping("update")
    public String update(Model model) {
        model.addAttribute("action", "用户修改");
        return "success";
    }
    /**
     * 用户删除
     * @param model
     * @return
     */
    @RequestMapping("delete")
    public String delete(Model model) {
        model.addAttribute("action", "用户删除");
        return "success";
    }
}
