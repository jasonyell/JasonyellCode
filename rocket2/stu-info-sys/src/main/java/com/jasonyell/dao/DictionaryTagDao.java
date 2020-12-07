package com.jasonyell.dao;

import com.jasonyell.model.DictionaryTag;
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
 * @create: 2020-11-05 01:52
 **/
public class DictionaryTagDao {

    public static List<DictionaryTag> query(String key) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<DictionaryTag> tags = new ArrayList<>();

        try {
            // 1. 获取数据库连接
            c = DBUtil.getConnection();
            // 复制粘贴进来的代码：ctrl + f 替换所有\n换行符,在需要空格的地方加上空格或 tab 锁紧，设置占位符
            String sql = "select concat(d.dictionary_key, dt.dictionary_tag_key) dictionary_tag_key, dt.dictionary_tag_value" +
                    "   from dictionary d" +
                    "       join dictionary_tag dt on d.id = dt.dictionary_id" +
                    "   where d.dictionary_key = ?";
            // 2. 创建操作命令对象
            ps = c.prepareStatement(sql);
            ps.setString(1, key);
            // 3.执行SQL语句
            rs = ps.executeQuery();
            // 4. 查询结果集
            while (rs.next()) {
                DictionaryTag tag = new DictionaryTag();
                tag.setDictionaryTagKey(rs.getString("dictionary_tag_key"));
                tag.setDictionaryTagValue(rs.getString("dt.dictionary_tag_value"));
                // 设置属性：通过结果集获取，并设置
                tags.add(tag);
            }
            return tags;
        } catch (Exception e) {
            throw new RuntimeException("查询数据字典标签出错", e);
        }finally {
            DBUtil.close(c, ps, rs);
        }

    }
}
