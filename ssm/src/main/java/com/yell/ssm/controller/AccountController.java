package com.yell.ssm.controller;

import com.yell.ssm.po.Account;
import com.yell.ssm.service.AccountService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;


/**
 * RESTFUL URL
 *  GET请求               请求方式为GET，对应的注解是 @GetMapping
 *  POST请求              请求方式为POST，对应的注解是 @PostMapping
 *  PUT请求               请求方式为PUT，对应的注解是 @PutMapping
 *  DELETE请求            请求方式为DELETE，对应的注解是 @DeleteMapping
 *
 *  也可以通过RequestMapping(valus="" method = RequestMethod.请求方式)
 *
 *  @PathVariable 表示一个参数是一个参数路径，（参数的值通过路径传递的）
 *
 *  使用 postman 接口测试
 */

@Controller
public class AccountController {
    @Resource
    private AccountService accountService;

    /**
     * 查询用户
     * @param id
     * @return
     */
    @GetMapping("account/{id}")
//    @RequestMapping(value = "account/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Account queryAccountById(@PathVariable Integer id) {
        Account account = accountService.queryAccountById(id);
        return account;
    }

    /**
     * 删除账户
     * @param id
     * @return
     */
    @DeleteMapping("account/{id}")
    @ResponseBody
    public Map<String, String> deleteAccountById(@PathVariable Integer id) {
        Map<String, String> map = new HashMap<>();
        Integer row = accountService.deleteAccountById(id);
        if (row > 0) {
            map.put("code", "1");
            map.put("msg", "更新成功");
        }else {
            map.put("code", "0");
            map.put("msg", "失败");
        }
        return map;
    }

    /**
     * 添加账户
     * @param
     * @return
     */
    @PostMapping("account")
    @ResponseBody
    public Map<String, String> addAccountById(@RequestBody Account account) {
        Map<String, String> map = new HashMap<>();
        Integer row = accountService.addAccount(account);
        if (row > 0) {
            map.put("code", "1");
            map.put("msg", "添加成功");
        }else {
            map.put("code", "0");
            map.put("msg", "添加失败");
        }
        return map;
    }

    /**
     * 更新账户
     * @param
     * @return
     */
    @PutMapping("account")
    @ResponseBody
    public Map<String, String> updateAccountById(@RequestBody Account account) {
        Map<String, String> map = new HashMap<>();
        Integer row = accountService.updateAccount(account);
        if (row > 0) {
            map.put("code", "1");
            map.put("msg", "修改成功");
        }else {
            map.put("code", "0");
            map.put("msg", "修改失败");
        }
        return map;
    }





}
