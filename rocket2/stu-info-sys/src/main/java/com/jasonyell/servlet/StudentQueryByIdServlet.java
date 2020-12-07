package com.jasonyell.servlet;

import com.jasonyell.dao.StudentDao;
import com.jasonyell.model.Student;
import lombok.ToString;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @program: Fo
 * @description
 * @author: JasonYell
 * @create: 2020-11-08 02:49
 **/
@WebServlet("/student/queryById")
public class StudentQueryByIdServlet extends AbstractBaseServlet {
    @Override
    protected Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String id = req.getParameter("id");
        Student s = StudentDao.queryById(Integer.parseInt(id));
        return s;
    }
}
