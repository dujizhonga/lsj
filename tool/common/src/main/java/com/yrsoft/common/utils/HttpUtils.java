package com.yrsoft.common.utils;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

/**
 * 封装HttpEntity
 *
 * @author Yhq
 * @date 2019/2/25 16:19
 */
public class HttpUtils {

    /**
     * 获取封装raw请求参数
     *
     * @param o 任意可以被json序列号和反序列化的对象
     * @return
     */
    public static HttpEntity getHttpEntity(Object o) {
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Object> requestEntity = new HttpEntity<>(o, requestHeaders);
        return requestEntity;
    }
}
