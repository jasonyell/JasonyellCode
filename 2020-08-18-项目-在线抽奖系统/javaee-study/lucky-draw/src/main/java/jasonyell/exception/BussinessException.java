package jasonyell.exception;

/**
 * @program: javaee-study
 * @description
 * @author: JasonYell
 * @create: 2020-12-11 03:04
 **/
public class BussinessException extends BaseException {

    public BussinessException(String code, String message) {
        super("bus" + code, message);
    }

    public BussinessException(String code, String message, Throwable cause) {
        super("bus" + code, message, cause);
    }
}
