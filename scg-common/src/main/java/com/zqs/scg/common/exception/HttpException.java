package com.zqs.scg.common.exception;

/**
 * Created by Administrator on 2017/3/31.
 */
public class HttpException extends RuntimeException{
    
    private static final long serialVersionUID = 4553476685751332235L;
    /** 异常代码 */
    protected Integer code;

    /** 异常消息 */
    protected String message;

    public HttpException() {
        super();
    }

    public HttpException(Integer code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }
    public HttpException(Integer code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
        this.message = message;
    }

    public HttpException(Throwable cause) {
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
