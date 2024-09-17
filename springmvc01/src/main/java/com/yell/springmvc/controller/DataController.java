package com.yell.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 设置请求域
 *      1.ModelAndView对象
 *          modelAndView.addObject(参数名,参数值)
 *      2.HttpServletRequest对象
 *          request.setAttribute(参数名，参数值)
 *      3.Model对象
 *          model.addAttribute(参数名，参数值)
 *      4.ModelMap对象
 *          modelMap.addAttribute(参数名，参数值)
 *      5.Map对象
 *          map.put(参数名，参数值)
 */
@Controller
@RequestMapping("data")
public class DataController {

    @RequestMapping("data01")
    public ModelAndView data01() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("uname", "admin");
        // 设置视图
        mv.setViewName("data");
        return mv;
    }

    @RequestMapping("data02")
    public ModelAndView data02(ModelAndView mv) {
        mv.addObject("uname2", "admin2");
        // 设置视图
        mv.setViewName("data");
        return mv;
    }

    /**
     * HttpServletRequest 对象
     *  request.setAttribute("", "");
     * @param request
     * @return
     */
    @RequestMapping("data03")
    public String data03(HttpServletRequest request) {
        request.setAttribute("uname", "admin3");
        return "data";
    }

    /**
     * Model对象
     *  model.addAttribute("", "");
     * @param model
     * @return
     */
    @RequestMapping("data04")
    public String data04(Model model) {
        model.addAttribute("uname", "admin4");
        return "data";
    }

    /**
     * ModelMap对象
     * @param modelMap
     * @return
     */
    @RequestMapping("data05")
    public String data05(ModelMap modelMap) {
        modelMap.addAttribute("uname", "admin5");
        return "data";
    }

    /**
     * Map 对象
     * @param map
     * @return
     */
    @RequestMapping("data06")
    public String data06(Map map) {
        map.put("uname", "admin6");
        return "data";
    }

}
