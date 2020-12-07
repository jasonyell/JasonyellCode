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
 * @create: 2020-11-09 12:30
 **/
@WebServlet("/student/update")
public class StudentUpdateServlet extends AbstractBaseServlet {
    @Override
    protected Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        Student s = JSONUtil.read(req.getInputStream(), Student.class);
        StudentDao.update(s);
        return null;
    }
}

