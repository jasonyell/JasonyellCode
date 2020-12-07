package com.jasonyell.servlet;

import com.jasonyell.service.AudioService;
import com.jasonyell.service.BookService;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

/**
 * @program: 2020-08-11-tingshuFM
 * @description
 * @author: JasonYell
 * @create: 2020-11-29 22:22
 **/
@WebServlet("/upload/audio")
@MultipartConfig
public class AudioUploadServlet extends HttpServlet {
    private AudioService audioService;
    private BookService bookService;

    @Override
    public void init() throws ServletException {
        audioService = new AudioService();
        bookService = new BookService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        int sid = Integer.parseInt(req.getParameter("sid"));

        Part audio = req.getPart("audio");

        // 通过这个输入流，就可以读取到声音的所有数据
        // InputStream inputStream = audio.getInputStream();

        // 1. 保存声音，得到声音的 uuid 同时关联 sid
        resp.setContentType("utf-8");
        resp.setContentType("application/json");
        PrintWriter writer = resp.getWriter();
        try {
            String uuid = audioService.save(sid, audio);
            writer.printf("{\"uuid\":\"%s\"}%n", uuid);
        } catch (SQLException e) {
            e.printStackTrace();
            resp.setStatus(500);
            writer.printf("{\"reason\":\"%s\"}%n", e.getMessage());
        }


    }
}
