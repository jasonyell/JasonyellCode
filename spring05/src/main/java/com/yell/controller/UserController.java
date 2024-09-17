package com.yell.controller;

import com.yell.po.vo.MessageModel;
import com.yell.service.UserService;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.security.MessageDigest;

/**
 *
 */
@Controller
public class UserController {
    @Resource
    private UserService userService;

    public MessageModel userLogin(String userName, String userPasswrod) {
//        调用service层的方法
        MessageModel messageModel = userService.userLogin(userName, userPasswrod);

        return messageModel;

    }

}
