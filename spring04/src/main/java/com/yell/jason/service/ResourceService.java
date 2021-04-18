package com.yell.jason.service;

import com.yell.jason.dao.ResourceDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @program: spring04
 * @description
 * @author: JasonYell
 * @create: 2021-03-24 15:17
 **/
@Service
public class ResourceService {
    // 自动注入
    @Resource
    private ResourceDao resourceDao;
    public void test() {
        System.out.println("resourceService...");
        resourceDao.test();

    }

}