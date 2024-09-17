package com.yell.springboot.controller;

import com.github.pagehelper.PageInfo;
import com.yell.springboot.po.User;
import com.yell.springboot.po.vo.ResultInfo;
import com.yell.springboot.query.UserQuery;
import com.yell.springboot.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @RestController 表示当前类中的方法的返回值是JSON格式，相当于Controller+ResponseBody
 * 设置了@RestController 类，方法上不需要再额外添加@ResponseBody注解，即可返回JSON格式
 */
@Api(tags = "用户模块")
@RestController // 返回 JSON 格式的 controller
public class UserController {
    @Resource
    private UserService userService;

    /**
     * 通过用户名查询用户对象
     * @param uname
     * @return
     */
    @GetMapping("user/name/{uname}")
    @ApiOperation(value = "根据用户名查询用户对象" ,notes="用户名称不能为空")
    @ApiImplicitParam(name = "uname", value = "用户名称", required = true, dataType = "String", paramType = "path")
    public User queryUserByName(@PathVariable String uname) {
        System.out.println("查询参数-->userName:" + uname);
        User user = userService.queryUserByName(uname);
        return user;
    }

    /**
     * 通过用户Id查询用户
     * @param id
     * @return
     */
    @GetMapping("user/{id}")
    @ApiOperation(value = "根据用户ID 查询用户对象")
    @ApiImplicitParam(name ="id",value="用户ID",required = true,paramType = "path")
    public User queryUserById(@PathVariable Integer id) {
        User user = userService.queryUserById(id);
        return user;
    }

    /**
     * 添加用户
     *      添加用@PostMapping("user")
     * @param user
     * @return
     */
    @PostMapping("user")
    @ApiOperation("添加用户")
    @ApiImplicitParam(name = "user",value="用户实体类",required = true,dataType = "User")
    public ResultInfo addUser(@RequestBody User user) {
        ResultInfo resultInfo = new ResultInfo();

//        try {
//            userService.addUser(user);
//        } catch (ParamsException p) {
//            p.printStackTrace();
//            resultInfo.setCode(p.getCode());
//            resultInfo.setMsg(p.getMsg());
//        } catch (Exception e) {
//            e.printStackTrace();
//            resultInfo.setCode(500);
//            resultInfo.setMsg("用户添加失败！");
//        }
        userService.addUser(user);
        return resultInfo;
    }

    @PostMapping("user02")
    @ApiOperation("添加用户")
    @ApiImplicitParam(name = "user",value="用户实体类",required = true,dataType = "User")
    public ResultInfo addUser02(@Valid User user) {
        ResultInfo resultInfo = new ResultInfo();
        userService.addUser(user);
        return resultInfo;
    }

    /**
     * 更新操作
     *      更新用@PutMapping
     * @param user
     * @return
     */
    @PutMapping("user")
    @ApiOperation("更新用户")
    @ApiImplicitParam(name = "user", value = "用户实体类", required = true, dataType = "User")
    public ResultInfo updateUser(@RequestBody User user) {
        ResultInfo resultInfo = new ResultInfo();
//        try {
//            userService.updateUser(user);
//        } catch (ParamsException p) {
//            p.printStackTrace();
//            resultInfo.setCode(p.getCode());
//            resultInfo.setMsg(p.getMsg());
//        } catch (Exception e) {
//            e.printStackTrace();
//            resultInfo.setCode(500);
//            resultInfo.setMsg("用户添加失败！");
//        }
        userService.updateUser(user);
        return resultInfo;
    }

//    @PutMapping("user")
//    @ApiOperation("更新用户")
//    @ApiImplicitParam(name = "user", value = "用户实体类", required = true, dataType = "User")
//    public User updateUser(@RequestBody User user) {
//        userService.updateUser(user);
//        return user;
//    }

    /**
     * 删除操作
     *      删除用 @DeleteMapping
     * @param userId
     * @return
     */
    @DeleteMapping("user/{userId}")
    @ApiOperation("删除用户")
    @ApiImplicitParam(name = "userId",value="用户Id")
    public ResultInfo deleteUser(@PathVariable Integer userId) {
        ResultInfo resultInfo = new ResultInfo();
//        try {
//            userService.deleteUser(userId);
//        } catch (ParamsException p) {
//            p.printStackTrace();
//            resultInfo.setCode(p.getCode());
//            resultInfo.setMsg(p.getMsg());
//        } catch (Exception e) {
//            e.printStackTrace();
//            resultInfo.setCode(500);
//            resultInfo.setMsg("用户添加失败！");
//        }
        userService.deleteUser(userId);
        return resultInfo;
    }

    /**
     * 分页及条件查询
     * @param userQuery
     * @return
     */
    @GetMapping("user/list")
    @ApiOperation("多条件查询用户列表")
    @ApiImplicitParam(name = "userQuery",value="用户查询对象")
    public PageInfo<User> queryUserList(UserQuery userQuery) {
        return userService.queryUserList(userQuery);
    }


}
