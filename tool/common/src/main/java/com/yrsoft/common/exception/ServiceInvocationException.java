package com.yrsoft.common.exception;

/**
 * 服务调用异常
 * @author Yhq
 * @date 2019/3/4 21:35
 */
public class ServiceInvocationException extends LSJExceptions {

    public ServiceInvocationException(int code) {
        super(code);
    }

    public ServiceInvocationException(int code, String message) {
        super(code, message);
    }
}
