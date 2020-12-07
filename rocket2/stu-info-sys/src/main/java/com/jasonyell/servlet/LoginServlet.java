package com.jasonyell.servlet;

import com.jasonyell.dao.UserDAO;
import com.jasonyell.model.User;
import com.jasonyell.util.JSONUtil;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @program: Fo
 * @description
 * @author: JasonYell
 * @create: 2020-11-09 14:36
 **/
@WebServlet("/user/login")
public class LoginServlet extends AbstractBaseServlet {
    @Override
    protected Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        User u = JSONUtil.read(req.getInputStream(), User.class);//前端请求的用户信息
        //数据库校验用户名密码
        User query = UserDAO.query(u);
        if(query == null)
            throw new RuntimeException("用户名或密码校验失败");
        //通过用户名密码查询到用户时，生成session，并将用户保存到session中
        HttpSession session = req.getSession();//=getSession(true)，没有session时，创建一个
        session.setAttribute("user", query);
        return null;
    }
}
