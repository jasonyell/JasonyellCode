package com.jasonyell.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * @program: Fo
 * @description
 * @author: JasonYell
 * @create: 2020-11-05 00:01
 **/
@ToString
@Getter
@Setter
public class Dictionary {
    private Integer id;
    private String dictionaryKey;
    private String dictionaryValue;
    private String dictionaryDesc;
    private Date createTime;
}
