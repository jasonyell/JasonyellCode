package com.yell.service;

import com.yell.dao.TypeDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @program: spring04
 * @description
 * @author: JasonYell
 * @create: 2021-03-24 15:17
 **/
@Service
public class TypeService {
    // 自动注入
    @Resource
    private TypeDao typeDao;
    public void test() {
        System.out.println("typeService...");
        typeDao.test();

    }

}
