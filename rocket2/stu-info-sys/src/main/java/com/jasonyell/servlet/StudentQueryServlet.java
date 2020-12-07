package com.jasonyell.servlet;

import com.jasonyell.dao.StudentDao;
import com.jasonyell.model.Page;
import com.jasonyell.model.Student;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;

/**
 * @program: Fo
 * @description
 * @author: JasonYell
 * @create: 2020-11-06 02:33
 **/
@WebServlet("/student/query")
public class StudentQueryServlet extends AbstractBaseServlet {
    @Override
    protected Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        Page p = Page.parse(req);
        List<Student> students = StudentDao.query(p);
        return students;
    }
}
