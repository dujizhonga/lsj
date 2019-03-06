package com.yrsoft.freight.controller;

import com.yrsoft.freight.controller.IDemoController;
import org.apache.servicecomb.provider.rest.common.RestSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.yrsoft.freight.entity.Demo;
import com.yrsoft.freight.service.DemoService;

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
