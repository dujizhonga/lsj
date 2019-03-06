package com.yrsoft.prodemo.service;

import org.springframework.stereotype.Component;

import com.yrsoft.prodemo.dao.DemoMapper;
import com.yrsoft.prodemo.entity.Demo;

import javax.annotation.Resource;


@Component
public class DemoService {

    @Resource
    private DemoMapper demoMapper;

    public String helloworld(String name){

        //通过调用其他接口实现service
        return name;
    }

    public Demo getDemo(String id){
        Demo db = demoMapper.selectByPrimaryKey(id);
        return db;
    }
}
