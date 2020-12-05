package com.jasonyell.servlet;

import com.jasonyell.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @program: 2020-08-12-网络-HTTP协议-博客系统
 * @description
 * @author: JasonYell
 * @create: 2020-10-09 10:24
 **/
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User user;

        try {
            user = User.register(username, password);
        } catch (SQLException e) {
            throw new ServletException(e);
        }
        if (user == null) {
            resp.sendRedirect("register.html");
            return;
        }

        /**
         *  注册完了视为登录
         */
         HttpSession session = req.getSession();
         session.setAttribute("user",user);

         resp.sendRedirect("/");

/*
        注册完成后 还需要人工自行登录
        resp.sendRedirect("login.html");
*/


    }
}
