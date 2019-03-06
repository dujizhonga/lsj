package com.yrsoft.condemo.controller;

import com.yrsoft.common.utils.JsonResult;
import org.apache.servicecomb.provider.rest.common.RestSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.yrsoft.condemo.entity.Demo;
import com.yrsoft.condemo.service.DemoService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.SwaggerDefinition;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import java.util.Map;


@RestSchema(schemaId = "DemoControllerImpl")
@RequestMapping(path = "/hello", produces = MediaType.APPLICATION_JSON)
public class DemoControllerImpl implements IDemoController {

    @Autowired
    private DemoService demoService;

    @RequestMapping(value = "/getDemo",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    public Demo getDemo(@RequestParam(value = "id", required = true) String id){
        return demoService.getDemo(id);
    }


        @RequestMapping(value = "/test", method = RequestMethod.POST)
        public JsonResult test(String id){

            return JsonResult.success(id);
    }
}
