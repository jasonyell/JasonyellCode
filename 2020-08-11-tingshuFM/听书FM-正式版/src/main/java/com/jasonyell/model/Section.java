package com.jasonyell.model;

import java.util.Objects;

/**
 * @program: 2020-08-11-tingshuFM
 * @description
 * @author: JasonYell
 * @create: 2020-11-28 15:43
 **/
public class Section {
    public int sid;
    public String name;
    // 如果关联声音，uuid 就是保存声音的 uuid
    // 否则 uuid == null
    public String uuid;

    @Override
    public String toString() {
        return "Section{" +
                "uuid='" + uuid + '\'' +
                "name='" + name + '\'' +
                '}';
    }

    public Section() {
    }

    public Section(int sid, String uuid, String name) {
        this.sid = sid;
        this.uuid = uuid;
        this.name = name;
    }
}
