package com.yrsoft.pay;

import org.apache.servicecomb.springboot.starter.provider.EnableServiceComb;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.DispatcherServletAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude= DispatcherServletAutoConfiguration.class)
@EnableServiceComb
@ComponentScan(basePackages = {"com.yrsoft.**"})
public class PayApplication {
    public static void main(String[] args) {
         SpringApplication.run(PayApplication.class,args);
    }
}
