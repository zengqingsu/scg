package com.zqs.scg.common.exception;

/**
 * 系统异常信息
 */
public class SystemException extends RuntimeException{

    private static final long serialVersionUID = 3682664120785686496L;

    /** 异常代码 */
    protected Integer code;

    /** 异常消息 */
    protected String message;

    public SystemException() {
        super();
    }

    public SystemException(Integer code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }
    public SystemException(Integer code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
        this.message = message;
    }

    public SystemException(Throwable cause) {
        super(cause);
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "errorCode: " + code + ", message: " + message;
    }
}
