package com.jasonyell.servlet;

import com.jasonyell.dao.StudentDao;
import com.jasonyell.model.Student;
import com.jasonyell.util.JSONUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @program: Fo
 * @description
 * @author: JasonYell
 * @create: 2020-11-09 12:14
 **/
@WebServlet("/student/add")
public class StudentAddServlet extends AbstractBaseServlet {
    @Override
    protected Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        Student s = JSONUtil.read(req.getInputStream(), Student.class);
        StudentDao.insert(s);
        return null;
    }
}
