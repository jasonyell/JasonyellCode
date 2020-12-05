package com.jasonyell.servlet;

import com.jasonyell.model.Article;
import com.jasonyell.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;

/**
 * @program: 2020-08-12-网络-HTTP协议-博客系统
 * @description
 * @author: JasonYell
 * @create: 2020-10-10 10:14
 **/
@MultipartConfig
@WebServlet("/publish")
public class PublicServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");

        if (user == null) {
            resp.sendRedirect("/login.html");
            return;
        }

        req.setCharacterEncoding("utf-8");
        String title = req.getParameter("title");
        String content = req.getParameter("content");

        // 获取浏览器 图片 信息
        Part imagePart = req.getPart("image");
        // 将 图片 信息转化为字节流
        InputStream in = imagePart.getInputStream();

        byte[] buffer = new byte[1024];

        try (OutputStream os = new FileOutputStream("H:\\BitWeb\\2020-07-12-网络-HTTP协议-博客系统\\保存上传过来的文件\\hello.png")) {
            while (true) {
                int len = in.read(buffer);

                if (len == -1) {
                    // 读到EOS,所有数据全部读完
                    break;
                }
                os.write(buffer, 0, len);
            }
            os.flush();
        }

        try {
            Article.publish(user.id, title, content);
        } catch (SQLException e) {
            throw new ServletException(e);
        }

        resp.sendRedirect("/");
    }
}
