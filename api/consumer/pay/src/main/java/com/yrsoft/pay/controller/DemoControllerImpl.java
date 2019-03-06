package com.yrsoft.pay.controller;

import org.apache.servicecomb.provider.rest.common.RestSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.yrsoft.pay.entity.Demo;
import com.yrsoft.pay.service.DemoService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.SwaggerDefinition;

import javax.ws.rs.core.MediaType;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.CseSpringDemoCodegen", date = "2019-01-29T01:51:08.429Z")

@RestSchema(schemaId = "condemo")
@RequestMapping(path = "/condemo", produces = MediaType.APPLICATION_JSON)
public class DemoControllerImpl implements IDemoController {

    @Autowired
    private DemoService demoService;

    @RequestMapping(value = "/getDemo",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    public Demo getDemo(@RequestParam(value = "id", required = true) String id){
        return demoService.getDemo(id);
    }
}