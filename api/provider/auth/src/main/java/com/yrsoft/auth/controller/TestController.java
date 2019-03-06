package com.yrsoft.auth.controller;

import com.yrsoft.common.utils.JsonResult;
import org.apache.servicecomb.provider.rest.common.RestSchema;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author mz
 * @Title: TestController
 * @ProjectName lsj
 * @Description: TODO
 * @date 2019/3/114:42
 */
@RestSchema(schemaId = "TestController")
@RequestMapping(path = "/provider/test")
public class TestController {

    @RequestMapping(path = "/test",method = RequestMethod.GET)
    public JsonResult test(){

        return JsonResult.success("我是提供者===========");
    }
}
