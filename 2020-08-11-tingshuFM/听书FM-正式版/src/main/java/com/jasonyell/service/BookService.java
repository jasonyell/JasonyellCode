package com.jasonyell.service;

import com.jasonyell.dao.BookDao;
import com.jasonyell.dao.SectionDao;
import com.jasonyell.model.Book;
import com.jasonyell.model.User;


import java.sql.SQLException;

import java.util.List;


/**
 * @program: 2020-08-11-tingshuFM
 * @description
 * @author: JasonYell
 * @create: 2020-11-28 15:50
 **/
public class BookService {
    private BookDao bookDao;
    private SectionDao sectionDao;

    public BookService() {
        bookDao = new BookDao();
        sectionDao = new SectionDao();
    }

    public List<Book> list() throws SQLException {
        return bookDao.selectAll();
    }

    public Book post(String title, User user) throws SQLException {
        return bookDao.insert(user, title);
    }

    public Book get(int bid) throws SQLException {
        Book book = bookDao.selectByBid(bid);
        if (book == null) {
            return null;
        }

        book.sections = sectionDao.selectByBid(bid);
        
        return book;
    }

    public void addSection(int bid, String name) throws SQLException {
        sectionDao.insert(bid, name);
    }
}
