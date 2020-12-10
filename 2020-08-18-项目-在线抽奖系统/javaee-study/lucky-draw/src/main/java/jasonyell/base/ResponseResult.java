package jasonyell.base;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class ResponseResult {
    /**
     * 定义异常，返回给前端湘阴状态码是200
     * 前端可以通过 success 字段， 判断是现实正常的业务数据，还是错误码+错误信息
     * 前端：
     *      if(相应数据.success){
     *          显示 data 字段的数据
     *      }else{
     *          显示 code 错误码 + 错误信息
     *      }
     *
     */
    private boolean success;
    private Object data;
    private String code;
    private String message;

    private ResponseResult() {

    }

    public static ResponseResult ok(Object o) {
        // 正常返回业务数据
        ResponseResult r = new ResponseResult();
        r.success = true;
        r.data = o;
        return r;
    }

    // 出现异常是，返回的数据
    public static ResponseResult error() {
        return error("ERR000","未知的错误，请联系管理人员");
    }

    public static ResponseResult error(String code, String message) {
        ResponseResult r = new ResponseResult();
        r.code = code;
        r.message = message;
        return r;
    }
}
