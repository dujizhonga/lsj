package com.yrsoft.truck;

import org.apache.servicecomb.springboot.starter.provider.EnableServiceComb;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.DispatcherServletAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude= DispatcherServletAutoConfiguration.class)
@EnableServiceComb
@ComponentScan(basePackages = {"com.yrsoft.**"})
public class TruckApplocation {
    public static void main(String[] args) {
         SpringApplication.run(TruckApplocation.class,args);
    }
}
