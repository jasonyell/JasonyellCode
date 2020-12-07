package com.jasonyell.servlet;

import com.jasonyell.service.BookService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @program: 2020-08-11-tingshuFM
 * @description
 * @author: JasonYell
 * @create: 2020-11-28 21:34
 **/
@WebServlet("/post-section")
public class SectionPostServlet extends HttpServlet {
    private BookService bookService;

    @Override
    public void init() throws ServletException {
        bookService = new BookService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        int bid = Integer.parseInt(req.getParameter("bid"));
        String name = req.getParameter("name");

        try {
            bookService.addSection(bid, name);
        } catch (SQLException e) {
            throw new ServletException(e);
        }
        resp.sendRedirect("/book.jsp?bid=" + bid);
    }
}
