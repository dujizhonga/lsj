package com.yrsoft.condemo.controller;

import com.yrsoft.common.utils.JsonResult;
import org.apache.servicecomb.provider.rest.common.RestSchema;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.ws.rs.core.MediaType;

/**
 * @author mz
 * @Title: Testy
 * @ProjectName lsj
 * @Description: TODO
 * @date 2019/3/416:30
 */
@RestSchema(schemaId = "Testy")
@RequestMapping(path = "/test",produces = MediaType.APPLICATION_JSON)
public class Testy {
    private static final Logger LOGGER = LoggerFactory.getLogger(Testy.class);

    @RequestMapping(value = "/testHello",method = RequestMethod.POST)
    public JsonResult testHello(String id){

        LOGGER.info("请求到达");

        return JsonResult.success("001");
    }
}
