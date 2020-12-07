package com.jasonyell.service;

import com.jasonyell.model.Audio;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @program: 2020-08-11-tingshuFM
 * @description
 * @author: JasonYell
 * @create: 2020-11-30 02:15
 **/
@WebServlet("/audio/get")
public class AudioGetServlet extends HttpServlet {
    private AudioService audioService;

    @Override
    public void init() throws ServletException {
        audioService = new AudioService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String uuid = req.getParameter("uuid");

        Audio audio = null;
        try {
            audio = audioService.get(uuid);
            if (audio == null) {
                resp.sendError(404,"没有这个声音");
                return;
            }
        } catch (SQLException e) {
            throw new ServletException(e);
        }

        resp.setContentType(audio.contentType);
        ServletOutputStream outputStream = resp.getOutputStream();

        byte[] buf = new byte[1024];
        int len;

        while ((len = audio.inputStream.read(buf)) != -1) {
            outputStream.write(buf, 0, len);
        }
        audio.inputStream.close();

    }
}
