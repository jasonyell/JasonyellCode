package frank.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ResponseResult {

    private boolean success;
    private Object data;//success=true需要的业务数据
    private String code;//success=false需要的错误码及错误信息
    private String message;
}
