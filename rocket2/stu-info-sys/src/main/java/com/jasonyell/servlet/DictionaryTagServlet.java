package com.jasonyell.servlet;

import com.jasonyell.dao.DictionaryTagDao;
import com.jasonyell.model.DictionaryTag;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import java.util.List;

/**
 * @program: Fo
 * @description
 *
 *      1. servlet 路径一定要以 / 开口 否则启动 Tomcat 就会报错
 *          IllegalStateException
 *      2. 熟悉开发流程，可根据接口文档，数据库的定义等，知道在哪复制
 * @author: JasonYell
 * @create: 2020-11-04 23:45
 **/
@WebServlet("/dict/tag/query")
public class DictionaryTagServlet extends AbstractBaseServlet {

    @Override
    protected Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String key = req.getParameter("dictionaryKey");
        List<DictionaryTag> tags = DictionaryTagDao.query(key);
        return tags;
    }
}
