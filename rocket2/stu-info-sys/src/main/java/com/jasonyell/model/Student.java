package com.jasonyell.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


import java.util.Date;

/**
 * @program: Fo
 * @description
 * @author: JasonYell
 * @create: 2020-11-04 23:56
 **/
@Getter
@Setter
@ToString
public class Student {
    private Integer id;
    private String studentName;
    private String studentNo;
    private String idCard;
    private String studentEmail;
    private Integer classesId;
    private Date createTime;
    private Classes classes;
}
