package com.yrsoft.delivery.service.impl;



import org.apache.servicecomb.provider.springmvc.reference.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSONObject;
import com.yrsoft.common.constant.UrlContants;
import com.yrsoft.common.utils.JsonResult;
import com.yrsoft.common.utils.ParamVC;
import com.yrsoft.delivery.entity.SProtocol;
import com.yrsoft.delivery.service.ProtocolService;

/**
 * 协议合同查询接口
 * @author lu
 * @date 2019/2/23 11:32
 */
@Service
public class ProtocolServiceImpl implements ProtocolService{

    private static RestTemplate restTemplate = RestTemplateBuilder.create();

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
    @Override
	public JsonResult getProtocol(String  paramStr) {
    	
    	 //参数验证
    	//showSite：显示端 1：货主pc，2：货主app，3：车主app，4：油站
    	//flag：类型 0-投保须知 1-运输合同 2-用户协议
        ParamVC pvc = ParamVC.jsonValidateAndConvert(paramStr,"showSite","flag");
        if(!pvc.isLegal()){
            return JsonResult.error(201,pvc.getMessage());
        }
    	
		MultiValueMap<String, String> requestEntity = new LinkedMultiValueMap<>();
		requestEntity.add("page","1");
		requestEntity.add("limit","1");
		//显示端 1：货主pc，2：货主app，3：车主app，4：油站
		requestEntity.add("showSite",pvc.getKey("showSite"));
		//flag：类型 0-投保须知 1-运输合同 2-用户协议
		requestEntity.add("flag",pvc.getKey("flag"));
		//未删除删除状态（0：未删除，1：已删除）
		requestEntity.add("deleteFlag","0");
		//启用状态（0-启用 1-停用 )
		requestEntity.add("status","0");
		 //通过调用其他接口实现service
		JsonResult protocols = restTemplate.postForObject(UrlContants.SYSYTEM+"sProtocol/list",requestEntity,JsonResult.class);
		return protocols;
	}
}
