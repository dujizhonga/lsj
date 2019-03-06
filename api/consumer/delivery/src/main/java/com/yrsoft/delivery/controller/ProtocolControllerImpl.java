package com.yrsoft.delivery.controller;
import org.apache.servicecomb.provider.rest.common.RestSchema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yrsoft.common.utils.JsonResult;
import com.yrsoft.delivery.entity.SProtocol;
import com.yrsoft.delivery.service.ProtocolService;


import javax.ws.rs.core.MediaType;

/**
 * 协议合同查询接口
 * @author lu
 * @date 2019/2/23 11:32
 */
@RestSchema(schemaId = "protocol")
@RequestMapping(path = "/api/protocol", produces = MediaType.APPLICATION_JSON)
public class ProtocolControllerImpl  {
	
	private static final Logger LOG = LoggerFactory.getLogger(ProtocolControllerImpl.class);

    @Autowired
    private ProtocolService protocolService;

    /**
    *
    * 功能描述: 协议/合同查询
    *
    * @param: showSite：显示端 1：货主pc，2：货主app，3：车主app，4：油站
    *         flag：类型 0-投保须知 1-运输合同 2-用户协议
    * @return: protocolCopy：协议副文本
    * @auther: lu
    * @date: 2019/2/23
    */
    @RequestMapping(value = "/getProtocol", method = RequestMethod.POST)
    public JsonResult getProtocol(String  paramStr){
    	LOG.info("开始查询---");
    	//检验参数
    	if(paramStr==null || paramStr.equals("")){
    		return JsonResult.error(201, "请输入参数");
    	}
    	return protocolService.getProtocol(paramStr);
    }
}
