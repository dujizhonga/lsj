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
import com.yrsoft.common.utils.StringUtils;
import com.yrsoft.delivery.service.AddressListService;
import com.yrsoft.delivery.service.GoodsInfoService;
/**
 * 发货页面货物列表查询接口
 * @author lu
 * @date 2019/03/04 10:23
 */
@Service
public class GoodsInfoServiceImpl implements GoodsInfoService {
	private static final RestTemplate restTemplate = RestTemplateBuilder.create();

	/**
    *
    * 功能描述: 发货页面货物列表查询
    *
    * @param: name 货物名称
    * @return: name 货物名称  id 货物id
    * @auther: lu
    * @date: 2019/03/32
    */
	@Override
	public JsonResult getGoodsInfo(String paramStr) {
		 //参数验证
        ParamVC pvc = ParamVC.jsonValidateAndConvert(paramStr,"name");
        if(!pvc.isLegal()){
            return JsonResult.error(201,pvc.getMessage());
        }
        
        String name=pvc.getKey("name");
		MultiValueMap<String, String> requestEntity = new LinkedMultiValueMap<>();
	    requestEntity.add("name", name);
		 //通过调用其他接口实现service
		JsonResult goodsInfo = restTemplate.postForObject(UrlContants.PLATFORM+"pCargoName/goodsInfoList",requestEntity,JsonResult.class);
		return goodsInfo;
	}

}
