package com.yrsoft.delivery.controller;

import cn.hutool.http.HttpUtil;
import com.yrsoft.common.constant.UrlContants;
import com.yrsoft.common.utils.JsonResult;
import org.apache.servicecomb.provider.rest.common.RestSchema;
import org.apache.servicecomb.provider.springmvc.reference.RestTemplateBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import javax.ws.rs.core.MediaType;

/**
 * @author mz
 * @Title: TestController
 * @ProjectName lsj
 * @Description: TODO
 * @date 2019/3/114:28
 */
@RestSchema(schemaId = "test")
@RequestMapping(path = "/consumer/test", produces = MediaType.APPLICATION_JSON)
public class TestController {

    private static final Logger LOGGER = LoggerFactory.getLogger("TestController");

    private static final RestTemplate restTemplate = RestTemplateBuilder.create();


    @RequestMapping(path = "/hello",method = RequestMethod.GET)
    public JsonResult hello(String id){

        LOGGER.info("开始访问提供者，访问路径是{}",UrlContants.AUTH + "test/test");

        JsonResult result = restTemplate.getForObject(UrlContants.AUTH + "test/test", JsonResult.class);

        LOGGER.info("提供者返回内容{},解析data数据为{}",result,result.getData());

        return JsonResult.success("消费者返回成功");
    }

    @RequestMapping(path = "/getNetwork",method = RequestMethod.GET)
    public JsonResult getNetwork(){
        String body = HttpUtil.get("http://www.baidu.com",3000);
        LOGGER.info("访问外网的到的返回值是{}",body);
        return JsonResult.success();
    }

}
