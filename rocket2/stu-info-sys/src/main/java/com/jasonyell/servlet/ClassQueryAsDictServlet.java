package com.jasonyell.servlet;

import com.jasonyell.dao.ClassesDAO;
import com.jasonyell.model.Classes;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @program: Fo
 * @description
 * @author: JasonYell
 * @create: 2020-11-08 02:15
 **/
@WebServlet("/classes/queryAsDict")
public class ClassQueryAsDictServlet extends AbstractBaseServlet {
    @Override
    protected Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        List<Classes> list = ClassesDAO.queryAsDict();
        return list;
    }
}
