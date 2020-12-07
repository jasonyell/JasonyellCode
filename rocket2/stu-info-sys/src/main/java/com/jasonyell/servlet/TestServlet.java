package com.jasonyell.servlet;

import com.jasonyell.model.Response;
import com.jasonyell.util.JSONUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: Fo
 * @description
 * @author: JasonYell
 * @create: 2020-11-04 01:54
 **/
@WebServlet("/test")
public class TestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("application/json");

        PrintWriter pw = resp.getWriter();
        Response r = new Response();
        r.setCode("code200");
        r.setMessage("操作成功");
        List<String> l = new ArrayList<>();
        l.add("A");
        l.add("B");
        l.add("C");
        r.setData(l);

        pw.println(JSONUtil.write(r));
        pw.flush();


    }
}
