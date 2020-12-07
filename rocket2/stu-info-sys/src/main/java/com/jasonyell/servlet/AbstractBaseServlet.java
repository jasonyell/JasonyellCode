package com.jasonyell.servlet;

import com.jasonyell.dao.DictionaryTagDao;
import com.jasonyell.model.DictionaryTag;
import com.jasonyell.model.Response;
import com.jasonyell.util.JSONUtil;
import com.jasonyell.util.ThreadLocalHolder;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;


/**
 * @program: Fo
 * @description
 * @author: JasonYell
 * @create: 2020-11-06 02:10
 **/
public abstract class AbstractBaseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);

    }

    // 模板方法：参照 HttpServlet 的 service() 方法和 doXXX() 方法关系，service 就是一个模板方法
    // 模板方法是提供一种统一的处理逻辑，在不同条件调用不同的方法(子类重写的方法):理解木板方法设计模式，理解多态
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 后面的接口，Servlet都是类似写法
        // 1.处理异常怎么处理为好？ 2.怎么样封装代码更加完善,进行统一设置编码，返回的数据格式统一处理异常
        //
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("application/json");

        PrintWriter pw = resp.getWriter();
        Response r = new Response();

        // HttpServletRequest对象.getParameter() 方法，可以获取哪些请求数据？  url 和 请求体，满足 k1 = v1 & k2 = v2
        // 一般说表单提交，表示的意思是请求的 Content-type 字段 x-www-form-urlencoded;
        // get 会怎么样？在 url 中； post 会怎么样？在请求体，格式为 k1 = v1 & k2 = v2
        // 表单不适用默认的方式时，比如手写前端代码 发送 ajax 请求，请求格式 application/json; 请求体，数据位JSON字符串
        // HttpServletRequest对象.getInputStream()通过输入流获取,请求体都可以获取到,怎么解析依赖自己代码实现

        try {
            Object o = process(req,resp);
            r.setSuccess(true);
            r.setCode("code200");
            r.setMessage("操作成功");
            r.setTotal(ThreadLocalHolder.getTOTAL().get());   // 不管是否分页操作，都获取当前线程的 total 变量
            r.setData(o);
        } catch (Exception e) {
            r.setCode("ERR500");
            r.setMessage(e.getMessage());
            StringWriter sw = new StringWriter();
            PrintWriter writer = new PrintWriter(sw);
            // 打印异常信息
            e.printStackTrace(writer);
            String stackTrace = sw.toString();
            System.err.println(stackTrace);    // 打印异常
            r.setStackTrace(stackTrace);
        }finally {
            ThreadLocalHolder.getTOTAL().remove(); // 在线程结束前，一定要记得删除变量，如果不删除，可能存在内存泄漏
        }
        pw.println(JSONUtil.write(r));
        pw.flush();
    }

    protected abstract Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception;



}
