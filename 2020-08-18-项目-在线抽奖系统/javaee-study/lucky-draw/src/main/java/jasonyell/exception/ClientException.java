package jasonyell.exception;

/**
 * @program: javaee-study
 * @description
 * @author: JasonYell
 * @create: 2020-12-11 03:03
 **/
public class ClientException extends BaseException {

    public ClientException(String code, String message) {
        super("CLI"+code, message);
    }

    public ClientException(String code, String message, Throwable cause) {
        super("CLI"+code, message, cause);
    }
}
