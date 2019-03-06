package com.yrsoft.files;

import org.apache.servicecomb.springboot.starter.provider.EnableServiceComb;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.DispatcherServletAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude= DispatcherServletAutoConfiguration.class)
@EnableServiceComb
@ComponentScan(basePackages = {"com.yrsoft.**"})
public class FilesApplocation {
    public static void main(String[] args) {

         SpringApplication.run(FilesApplocation.class,args);
    }
}
