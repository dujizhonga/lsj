package com.yrsoft.systeminfo.service;


import org.apache.servicecomb.provider.springmvc.reference.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.yrsoft.systeminfo.entity.Demo;


@Component
public class DemoService {

    private static RestTemplate restTemplate = RestTemplateBuilder.create();

    public Demo getDemo(String id){
        //通过调用其他接口实现service
        Demo demo = restTemplate.getForObject("http://794939da-a8e0-432c-ac49-e7b6a6316613.hswl20160918.cn-north-1.huaweicse.com/demoData/getDemo?id=" + id, Demo.class);
        return demo;
    }
}
