package com.jasonyell.util;

import org.junit.Assert;
import org.junit.Test;

import javax.swing.*;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: Fo
 * @description
 * @author: JasonYell
 * @create: 2020-11-04 01:22
 **/
public class JSONUtilTest {
    @Test
    public void testWrite() {
        Map<String, String> map = new HashMap<>();
        map.put("1", "a");
        map.put("2", "b");
        map.put("3", "c");
        map.put("4", "d");
        String s = JSONUtil.write(map);
        System.out.println(s);
        Assert.assertNotNull(s);
    }

    @Test
    public void testRead() {
        InputStream is = getClass().getClassLoader().getResourceAsStream("test.json");
        Map<String, String> map = JSONUtil.read(is, HashMap.class);
        System.out.println(map);
        Assert.assertNotNull(map);

    }
}
