package com.yrsoft.delivery.service;



import org.apache.servicecomb.provider.springmvc.reference.RestTemplateBuilder;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.yrsoft.common.utils.DateUtils;
import com.yrsoft.common.utils.JsonResult;
import com.yrsoft.common.utils.StringUtils;
import com.yrsoft.delivery.entity.PShippingAddress;

/**
 *收发货地址添加
 * @author lu
 * @date 2019/2/25 
 */ 
public interface ShippingAddressService {

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
	public JsonResult addShippingAddress(String  paramStr);
}
