package com.jasonyell.servlet;

import com.jasonyell.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @program: 2020-08-12-网络-HTTP协议-博客系统
 * @description
 * @author: JasonYell
 * @create: 2020-10-09 01:37
 **/
@WebServlet("")
public class indexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");

        String nav = "";

        if (user == null) {
            nav = "         <li><a href=\"register.html\">注册</a></li>\n" +
                    "       <li><a href=\"login.html\">登录</a></li>";
        } else {
            nav = "         <li>" + user.username + "</li>\n" +
                    "       <li><a href=\"publish.html\">发表文章</a></li>";
        }

        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();

        writer.println("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>jasonyell说</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <div class=\"navigator\">\n" +
                "        <o1>\n" +
                nav +
                "        </o1>\n" +
                "    </div>\n" +
                "\n" +
                "    <div id = \"article-list\">\n" +
                "        <!-- 如果没有文章-->\n" +
                "        没有任何文章，请发表一篇文章\n" +
                "        <!-- 如果有文章 -->\n" +
                "    </div>\n" +
                "<script src=\"/js/index.js\"charset=\"utf-8\"></script>" +
                "\n" +
                "</body>\n" +
                "</html>");
    }
}
