package com.yrsoft.delivery.service.impl;



import org.apache.servicecomb.provider.springmvc.reference.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSONObject;
import com.yrsoft.common.constant.UrlContants;
import com.yrsoft.common.utils.DateUtils;
import com.yrsoft.common.utils.JsonResult;
import com.yrsoft.common.utils.StringUtils;
import com.yrsoft.delivery.entity.PShippingAddress;
import com.yrsoft.delivery.service.ShippingAddressService;

/**
 *收发货地址添加
 * @author lu
 * @date 2019/2/25 
 */ 
@Service
public class ShippingAddressServiceImpl implements ShippingAddressService{

    private static RestTemplate restTemplate = RestTemplateBuilder.create();

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
    @Override
	public JsonResult addShippingAddress(String  paramStr) {
    	JSONObject jsonObject = JSONObject.parseObject(paramStr);
    	//shipperId:货主id
    	if(jsonObject.get("shipperId")==null || jsonObject.get("shipperId").equals("")){
    		return JsonResult.error(201, "请输入货主编号");
    	}
    	
    	// province 省 ,
    	if(jsonObject.get("province")==null || jsonObject.get("province").equals("")){
    		return JsonResult.error(201, "请输入省名称");
    	}
    	//area 区,
    	if(jsonObject.get("area")==null || jsonObject.get("area").equals("")){
    		return JsonResult.error(201, "请输入区名称");
    	}
    	
    	//address 详细地址 ,
    	if(jsonObject.get("address")==null ||jsonObject.get("address").equals("")){
    		return JsonResult.error(201, "请输入详细地址");
    	}
    	//lng 经度
    	if(jsonObject.get("lng")==null || jsonObject.get("lng").equals("")){
    		return JsonResult.error(201, "请输入经度");
    	}
    	
    	//lat 维度,
    	if(jsonObject.get("lat")==null || jsonObject.get("lat").equals("")){
    		return JsonResult.error(201, "请输入维度");
    	}
    	//name 姓名,
    	if(jsonObject.get("name")==null || jsonObject.get("name").equals("")){
    		return JsonResult.error(201, "请输入姓名");
    	}
    	
    	//phone 电话,
    	if(jsonObject.get("phone")==null || jsonObject.get("phone").equals("")){
    		return JsonResult.error(201, "请输入电话");
    	}
    	//defaultState 默认地址状态（0：否 1：是）,
    	if(jsonObject.get("defaultState")==null || jsonObject.get("defaultState").equals("")){
    		return JsonResult.error(201, "请输入默认地址状态");
    	}
    	
    	// addressType 地址类型（0：发货地址 1：收货地址）,
    	if(jsonObject.get("addressType")==null || jsonObject.get("addressType").equals("")){
    		return JsonResult.error(201, "请输入协地址类型");
    	}
		MultiValueMap<String, String> requestEntity = new LinkedMultiValueMap<>();
		//id
		requestEntity.add("id", StringUtils.getUUID());
		//shipperId:货主id
		requestEntity.add("shipperId",jsonObject.get("shipperId").toString());
		// province 省 ,
		requestEntity.add("province", jsonObject.get("province").toString());
		// city 市 ,
		requestEntity.add("city", jsonObject.get("city").toString());
		//area 区,
		requestEntity.add("area", jsonObject.get("area").toString());
		//address 详细地址 ,
		requestEntity.add("address", jsonObject.get("address").toString());
		//lng 经度,
		requestEntity.add("lng", jsonObject.get("lng").toString());
		//lat 维度,
		requestEntity.add("lat", jsonObject.get("lat").toString());
		//name 姓名,
		requestEntity.add("name", jsonObject.get("name").toString());
		//phone 电话,
		requestEntity.add("phone",jsonObject.get("phone").toString());
		//createTime 创建时间,
		requestEntity.add("createTime", DateUtils.getTimeMillis().toString());
		//defaultState 默认地址状态（0：否 1：是）,
		requestEntity.add("defaultState", jsonObject.get("defaultState").toString());
		//addressType 地址类型（0：发货地址 1：收货地址）,
		requestEntity.add("addressType", jsonObject.get("addressType").toString());
		//addressStatus地址状态： 0-启用 1-停用,
		requestEntity.add("addressStatus","0");
		//deleteFlag删除状态（0：未删除，1：已删除）,
		requestEntity.add("deleteFlag","0");
		//通过调用其他接口实现service
		JsonResult shippingAddress = restTemplate.postForObject(UrlContants.PLATFORM+"pShippingAddress/add",requestEntity,JsonResult.class);
		return shippingAddress;
	}
}
