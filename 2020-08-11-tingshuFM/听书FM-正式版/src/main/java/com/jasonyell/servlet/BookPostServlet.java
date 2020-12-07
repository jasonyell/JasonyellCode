package com.jasonyell.servlet;

import com.jasonyell.model.Book;
import com.jasonyell.model.User;
import com.jasonyell.service.BookService;

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
 * @create: 2020-11-28 19:11
 **/
@WebServlet("/post-book")
public class BookPostServlet extends HttpServlet {
    private BookService bookService;

    @Override
    public void init() throws ServletException {
        bookService = new BookService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String title = req.getParameter("title");

        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) {
            resp.sendRedirect("/login.html");
            return;
        }
        try {
            Book book = bookService.post(title, user);
            if (book != null) {
                resp.sendRedirect("/book.jsp?bid=" + book.bid);
            } else {
                resp.sendRedirect("/add-book.jsp");
            }
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }
}
