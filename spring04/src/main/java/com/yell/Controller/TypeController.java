package com.yell.Controller;

import com.yell.service.TypeService;
import com.yell.util.TestUtil;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * @program: spring04
 * @description
 * @author: JasonYell
 * @create: 2021-03-24 15:16
 **/
@Controller
public class TypeController {

    @Resource
    private TypeService typeService;

    @Resource
    private TestUtil testUtil;

    public void test() {
        System.out.println("typeService...");
        typeService.test();
        testUtil.test();
    }
}
