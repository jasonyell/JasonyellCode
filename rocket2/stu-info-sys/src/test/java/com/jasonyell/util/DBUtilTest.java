package com.jasonyell.util;

import org.junit.Assert;
import org.junit.Test;

/**
 * @program: Fo
 * @description
 * @author: JasonYell
 * @create: 2020-11-04 00:57
 **/
public class DBUtilTest {
    @Test
    public void testConnection() {
        Assert.assertNotNull(DBUtil.getConnection());
    }
}
