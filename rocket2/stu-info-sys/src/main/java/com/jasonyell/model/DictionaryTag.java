package com.jasonyell.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * @program: Fo
 * @description
 * @author: JasonYell
 * @create: 2020-11-04 23:47
 **/
@Getter
@Setter
@ToString
//目标： 掌握开发流程
public class DictionaryTag {

    // 需要使用包装数据类型 Integer 为什么？ new 对象的时候，基本数据类型（int）的默认值可能会出现问题
    private Integer id;
    private String dictionaryTagKey;
    private String dictionaryTagValue;
    private Integer dictionaryId;
    // 一般日期类型 使用 java.util.Date 和数据库映射(默认的映射是 java.sql.xxx)
    private Date createTime;



}
