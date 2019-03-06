package com.yrsoft.common.exception;

/**
 * 佬司机统一业务异常，详细异常都继承该异常
 * @author Yhq
 * @date 2019/2/25 10:21
 */
public class LSJExceptions extends RuntimeException {

    private int code;

    public LSJExceptions(int code) {
        this.code = code;
    }

    public LSJExceptions(int code,String message) {
        super(message);
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
