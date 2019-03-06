package com.yrsoft.quartz;

import org.apache.servicecomb.springboot.starter.provider.EnableServiceComb;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.DispatcherServletAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude= DispatcherServletAutoConfiguration.class)
@EnableServiceComb
@MapperScan("com.yrsoft.quartz.dao")
@ComponentScan(basePackages = {"com.yrsoft.**"})
public class QuartzApplication {
    public static void main(String[] args) {
         SpringApplication.run(QuartzApplication.class,args);
    }
}
