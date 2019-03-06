package com.yrsoft.condemo.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author mz
 * @Title: Student
 * @ProjectName lsj
 * @Description: TODO
 * @date 2019/3/511:04
 */
@Component
@ConfigurationProperties(prefix = "test")
public class Student {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
