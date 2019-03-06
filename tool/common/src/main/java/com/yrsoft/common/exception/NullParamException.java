package com.yrsoft.common.exception;

/**
 * 空参数异常
 * @author Yhq
 * @date 2019/2/25 10:24
 */
public class NullParamException extends LSJExceptions {
    public NullParamException(int code, String message) {
        super(code,message);
    }
}
