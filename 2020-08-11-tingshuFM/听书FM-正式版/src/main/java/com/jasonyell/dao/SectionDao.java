package com.jasonyell.dao;

import com.jasonyell.model.Section;
import com.jasonyell.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: 2020-08-11-tingshuFM
 * @description
 * @author: JasonYell
 * @create: 2020-11-28 15:49
 **/
public class SectionDao {

    public void insert(int bid, String name) throws SQLException {
        String sql = "insert into sections (bid, name) values (?, ?)";

        try (Connection c = DBUtil.getConnection()) {
            try (PreparedStatement s = c.prepareStatement(sql)) {
                s.setInt(1,bid);
                s.setString(2, name);

                s.executeUpdate();
                }
            }
        }

    public List<Section> selectByBid(int bid) throws SQLException {
        String sql = "select sections.sid, uuid, name" +
                " from sections left join audios on sections.sid = audios.sid" +
                " where bid = ? order by sections.sid";
        List<Section> sections = new ArrayList<>();
        try (Connection c = DBUtil.getConnection()) {
            try (PreparedStatement s = c.prepareStatement(sql)) {
                s.setInt(1,bid);

                try (ResultSet r = s.executeQuery()){
                    while (r.next()) {
                        Section section = new Section(
                                r.getInt("sid"),
                                r.getString("uuid"),
                                r.getString("name")
                        );
                        sections.add(section);
                    }
                }
            }
        }
        return sections;
    }
}
