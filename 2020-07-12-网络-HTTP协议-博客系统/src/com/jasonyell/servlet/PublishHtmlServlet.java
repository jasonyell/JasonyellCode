package com.jasonyell.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @program: 2020-08-12-网络-HTTP协议-博客系统
 * @description
 * @author: JasonYell
 * @create: 2020-10-09 16:59
 **/
@WebServlet("/publish.html")
public class PublishHtmlServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Object user = session.getAttribute("user");

        if (user == null) {
            resp.sendRedirect("login.html");
            return;
        }

        String htmlContent = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>jasonyell说 | 发表文章</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <form method=\"post\" action=\"publish\" enctype=\"multipart/form-data\">\n" +
                "        <div>\n" +
                "            <label for=\"title\">标题</label>>\n" +
                "            <input type=\"text\" id=\"title\" name=\"title\">\n" +
                "        </div>\n" +
                "\n" +
                "        <div>\n" +
                "            <label for=\"content\">文章内容</label>>\n" +
                "            <textarea id =\"content\"name=\"content\"></textarea>>\n" +
                "        </div>\n" +
                "        <div>\n " +
                "             <label for=\"image\">图片</label>\n" +
                "             <input type=\"file\"id=\"image\"name=\"image\">" +
                "        </div>\n " +
                "\n" +
                "        <div>\n" +
                "            <button type=\"submit\">发表文章</button>\n" +
                "        </div>\n" +
                "        \n" +
                "    </form>\n" +
                "</body>\n" +
                "</html>";

        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().println(htmlContent);
    }
}
