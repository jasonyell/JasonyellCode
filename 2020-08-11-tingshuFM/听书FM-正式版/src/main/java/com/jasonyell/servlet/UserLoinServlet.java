package com.jasonyell.servlet;

import com.jasonyell.model.User;
import com.jasonyell.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @program: 2020-08-11-tingshuFM
 * @description
 * @author: JasonYell
 * @create: 2020-11-28 15:39
 **/
@WebServlet("/login")
public class UserLoinServlet extends HttpServlet {
    private UserService userService;

    @Override
    public void init() throws ServletException {
        // Servlet 生命周期的内容
        userService = new UserService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 最开始加上 字符集不容易出问题
        req.setCharacterEncoding("utf-8");

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        // 未做参数正确性检查

        try {
            User user = userService.login(username, password);
            if (user == null) {
                // 没有注册成功
                // 没有做太多应用性考虑，没告诉为什么用户名错误
                resp.sendRedirect("/login.html");
                return;
            }

            // 把当前用户种入 session 中，下次资源访问时携带的登录用户信息
            HttpSession session = req.getSession();
            session.setAttribute("user", user);

            // 跳转回首页
            resp.sendRedirect("/");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
