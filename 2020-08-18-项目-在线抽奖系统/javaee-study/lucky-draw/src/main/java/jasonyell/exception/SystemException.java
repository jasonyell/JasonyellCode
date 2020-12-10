package jasonyell.exception;

/**
 * @program: javaee-study
 * @description
 * @author: JasonYell
 * @create: 2020-12-11 03:04
 **/
public class SystemException extends BaseException {

    public SystemException(String code, String message) {
        super("sys" + code, message);
    }

    public SystemException(String code, String message, Throwable cause) {
        super("sys" + code, message, cause);
    }
}
