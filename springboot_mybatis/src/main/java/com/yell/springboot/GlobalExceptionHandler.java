package com.yell.springboot;

import com.yell.springboot.exception.ParamsException;
import com.yell.springboot.po.vo.ResultInfo;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;



/**
 * 全局异常处理类
 */
@ControllerAdvice   // 最常用的就是作为全局异常处理的切面类
public class GlobalExceptionHandler {
    /**
     * 处理异常的方法
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)  //在处理异常时标注在方法级别，代表当前方法处理的异常类型有哪些具体应用以Restful 接口为例，测试保存用户接口。
    @ResponseBody //返回JSON 格式
    public ResultInfo exceptionResolver(Exception e) {
        ResultInfo resultInfo = new ResultInfo();
        // 如果有异常、则设置异常信息
        resultInfo.setCode(300);
        resultInfo.setMsg("系统异常");

        // 判断异常的类型设置具体的异常信息
        if (e instanceof ParamsException) {
            ParamsException p = (ParamsException) e;
            resultInfo.setCode(p.getCode());
            resultInfo.setResult(p.getMsg());
        }

        return resultInfo;
    }

    /**
     * 处理自定参数异常
     */
    @ExceptionHandler(value = ParamsException.class)
    @ResponseBody
    public ResultInfo paramsExceptionResolver(ParamsException p) {
        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setCode(p.getCode());
        resultInfo.setMsg(p.getMsg());
        return resultInfo;
    }

    /**
     * 数据校验 异常绑定
     * @param b
     * @return
     */
    @ExceptionHandler(value = BindException.class)
    @ResponseBody
    public ResultInfo bindExceptionResolver(BindException b) {
        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setCode(300);
        resultInfo.setMsg(b.getBindingResult().getFieldError().getDefaultMessage());
        return resultInfo;
    }
}
