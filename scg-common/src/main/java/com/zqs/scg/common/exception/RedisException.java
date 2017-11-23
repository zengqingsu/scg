package com.zqs.scg.common.exception;

/**
 * Redis异常信息
 */
public class RedisException extends RuntimeException{

    private static final long serialVersionUID = 3213018467774888279L;

    /** 异常代码 */
    protected Integer code;

    /** 异常消息 */
    protected String message;

    public RedisException() {
        super();
    }

    public RedisException(Integer code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }
    public RedisException(Integer code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
        this.message = message;
    }

    public RedisException(Throwable cause) {
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
