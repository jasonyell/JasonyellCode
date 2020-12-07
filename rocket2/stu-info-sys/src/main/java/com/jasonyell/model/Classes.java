package com.jasonyell.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;


/**
 * @program: Fo
 * @description
 * @author: JasonYell
 * @create: 2020-11-05 00:03
 **/
@Setter
@Getter
@ToString
public class Classes extends DictionaryTag {
    private Integer id;
    private String classesName;
    private String classesGraduateYear;
    private String classesMajor;
    private String classesDesc;
    private Date createTime;
}
