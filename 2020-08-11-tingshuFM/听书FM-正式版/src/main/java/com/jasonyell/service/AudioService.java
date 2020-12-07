package com.jasonyell.service;

import com.jasonyell.dao.AudioDao;
import com.jasonyell.model.Audio;

import javax.servlet.http.Part;
import java.io.IOException;
import java.sql.SQLException;
import java.util.UUID;

/**
 * @program: 2020-08-11-tingshuFM
 * @description
 * @author: JasonYell
 * @create: 2020-11-30 01:52
 **/
public class AudioService {
    private AudioDao audioDao;

    public AudioService() {
        audioDao = new AudioDao();
    }

    public String save(int sid, Part audio) throws IOException, SQLException {
        String uuid = UUID.randomUUID().toString();

        audioDao.insert(sid, uuid, audio.getContentType(), audio.getInputStream());

        return uuid;
    }

    public Audio get(String uuid) throws SQLException {
        return audioDao.select(uuid);
    }
}
