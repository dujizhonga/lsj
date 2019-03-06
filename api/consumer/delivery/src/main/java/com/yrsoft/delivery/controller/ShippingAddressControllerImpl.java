package com.yrsoft.delivery.controller;
import org.apache.servicecomb.provider.rest.common.RestSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yrsoft.common.utils.JsonResult;
import com.yrsoft.delivery.entity.PShippingAddress;
import com.yrsoft.delivery.service.ShippingAddressService;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.core.MediaType;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.CseSpringDemoCodegen", date = "2019-01-29T01:51:08.429Z")
/**
 * 协议合同查询接口
 * @author lu
 * @date 2019/2/23 11:32
 */
@RestSchema(schemaId = "shipperAddress")
@RequestMapping(path = "/api/shippingAddress", produces = MediaType.APPLICATION_JSON)
public class ShippingAddressControllerImpl{

    @Autowired
    private ShippingAddressService shippingAddressService;

    /**
    *
    * 功能描述: 收发货地址添加
    *
    * @param: shipperId:货主id
			  province 省 ,
			  city 市 ,
			  area 区,
			  address 详细地址 ,
			  lng 经度,
			  lat 维度,
			  name 姓名,
			  phone 电话,
			  defaultState 默认地址状态（0：否 1：是）,
			  addressType 地址类型（0：发货地址 1：收货地址）,
    * @return: 
    * @auther: lu
    * @date: 2019/2/25
    */
    @RequestMapping(value = "/addShippingAddress", 
        method = RequestMethod.POST)
    public JsonResult addShippingAddress(String  paramStr){
    	
    	//检验参数
    	if(paramStr==null || paramStr.equals("")){
    		return JsonResult.error(201, "请输入参数");
    	}
        return shippingAddressService.addShippingAddress(paramStr);
    }
}
