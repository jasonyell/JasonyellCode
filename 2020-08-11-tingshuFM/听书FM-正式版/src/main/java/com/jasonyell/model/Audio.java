package com.jasonyell.model;

import java.io.InputStream;

/**
 * @program: 2020-08-11-tingshuFM
 * @description
 * @author: JasonYell
 * @create: 2020-11-30 02:17
 **/
public class Audio {
    public String contentType;
    public InputStream inputStream;

    public Audio(String type, InputStream content) {
        this.contentType = type;
        this.inputStream = content;
    }
}
