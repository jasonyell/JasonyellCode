package com.yell.service;

import com.yell.dao.UserDao;
import com.yell.po.User;
import com.yell.po.vo.MessageModel;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @program: spring05
 * @description
 * @author: JasonYell
 * @create: 2021-03-24 17:57
 **/
@Service
public class UserService {

    //    注入
    @Resource
    private UserDao userDao;

    public MessageModel userLogin(String userName, String userPassword) {
        MessageModel messageModel = new MessageModel();

//        参数的非空校验
        if (userName == null || "".equals(userName.trim())) {
            messageModel.setCode(0);
            messageModel.setMsg("用户名不能为空！");
            return messageModel;
        }
        if (userPassword == null || "".equals(userPassword.trim())) {
            messageModel.setCode(0);
            messageModel.setMsg("密码不能为空！");
            return messageModel;
        }

//        调用Dao层的查询方法，判断用户对象是否存在
        User user = userDao.queryUserByName(userName);
//        用户对向是否为空?
        if (user == null) {
            messageModel.setCode(0);
            messageModel.setMsg("用户名不能为空！");
            return messageModel;
        }
//        比较密码是否正确
        if (!"123456".equals(userPassword)) {
            messageModel.setCode(0);
            messageModel.setMsg("密码不能为空！");
            return messageModel;
        }

        messageModel.setCode(1);
        messageModel.setMsg("登陆成功");

        return messageModel;
    }
}
