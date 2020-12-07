package com.jasonyell.dao;

import com.jasonyell.model.Classes;

import com.jasonyell.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: Fo
 * @description
 * @author: JasonYell
 * @create: 2020-11-08 02:24
 **/
public class ClassesDAO {
    public static List<Classes> queryAsDict() {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        List<Classes> list = new ArrayList<>();

        try {
            // 1. 获取数据库连接
            c = DBUtil.getConnection();
            // 复制粘贴进来的代码：ctrl + f 替换所有\n换行符,在需要空格的地方加上空格或 tab 锁紧，设置占位符
            String sql = "select id,classes_name,classes_graduate_year,classes_major from classes";
            // 2. 创建操作命令对象
            ps = c.prepareStatement(sql);
            // 3.执行SQL语句
            rs = ps.executeQuery();
            // 4. 查询结果集
            while (rs.next()) {
                Classes classes = new Classes();

                // 设置属性：通过结果集获取，并设置
                classes.setDictionaryTagKey(String.valueOf(rs.getInt("id")));

                classes.setDictionaryTagValue(rs.getString("classes_name"));
                classes.setClassesGraduateYear(rs.getString("classes_graduate_year"));
                classes.setClassesMajor(rs.getString("classes_major"));
                list.add(classes);

            }
            return list;
        } catch (Exception e) {
            throw new RuntimeException("查询班级数据字典出错", e);
        }finally {
            DBUtil.close(c, ps, rs);
        }
    }
}
