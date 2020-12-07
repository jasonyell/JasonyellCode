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
 * @create: 2020-11-09 12:38
 **/
@WebServlet("/student/delete")
public class StudentDeleteServlet extends AbstractBaseServlet {
    @Override
    protected Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String[] ids = req.getParameterValues("ids");
        StudentDao.delete(ids);
        return null;
    }
}
