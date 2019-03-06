package com.yrsoft.generate;

import org.apache.servicecomb.springboot.starter.provider.EnableServiceComb;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.DispatcherServletAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication(exclude=DispatcherServletAutoConfiguration.class)
//扫描三大组件
@ServletComponentScan
@EnableServiceComb
@MapperScan({"com.yrsoft.*.dao"})
public class GenerateApplication {

	public static void main(String[] args) {
		SpringApplication.run(GenerateApplication.class, args);
	}

}
