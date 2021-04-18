package com.yell.jason.Controller;

import com.yell.jason.service.ResourceService;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * @program: spring04
 * @description
 * @author: JasonYell
 * @create: 2021-03-24 15:16
 **/
@Controller
public class ResourceController {

    @Resource
    private ResourceService resourceService;

    public void test() {
        System.out.println("resourceService...");
        resourceService.test();

    }
}
