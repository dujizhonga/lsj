package com.yrsoft.delivery.controller;
import org.apache.servicecomb.provider.rest.common.RestSchema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yrsoft.common.utils.JsonResult;
import com.yrsoft.delivery.service.GoodsInfoService;

import javax.ws.rs.core.MediaType;

/**
 * 发货页面货物列表查询接口
 * @author lu
 * @date 2019/03/04 10:23
 */
@RestSchema(schemaId = "goodsInfo")
@RequestMapping(path = "/api/goodsInfo", produces = MediaType.APPLICATION_JSON)
public class GoodsInfoController  {
	
	private static final Logger LOG = LoggerFactory.getLogger(GoodsInfoController.class);

    @Autowired
    private GoodsInfoService goodsInfoService;

    /**
    *
    * 功能描述: 发货页面货物列表查询
    *
    * @param: name 货物名称
    * @return: name 货物名称  id 货物id
    * @auther: lu
    * @date: 2019/03/32
    */
    @RequestMapping(value = "/getGoodsInfo", method = RequestMethod.POST)
    public JsonResult getGoodsInfo(String  paramStr){
    	LOG.info("开始查询---");
    	//检验参数
    	if(paramStr==null || paramStr.equals("")){
    		return JsonResult.error(201, "请输入参数");
    	}
    	return goodsInfoService.getGoodsInfo(paramStr);
    }
}
