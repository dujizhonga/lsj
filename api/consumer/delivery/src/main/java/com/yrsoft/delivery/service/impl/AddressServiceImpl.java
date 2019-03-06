package com.yrsoft.delivery.service.impl;


import cn.hutool.core.lang.UUID;
import cn.hutool.json.JSONUtil;

import com.alibaba.fastjson.JSONObject;
import com.yrsoft.common.constant.Constants;
import com.yrsoft.common.constant.UrlContants;
import com.yrsoft.common.exception.LSJExceptions;
import com.yrsoft.common.exception.NullParamException;
import com.yrsoft.common.utils.DateUtils;
import com.yrsoft.common.utils.HttpUtils;
import com.yrsoft.common.utils.JsonResult;
import com.yrsoft.delivery.dto.AddressDTO;
import com.yrsoft.delivery.dto.DoubleAddressDTO;
import com.yrsoft.delivery.dto.ShippingAddressDTO;
import com.yrsoft.delivery.entity.Address;
import com.yrsoft.delivery.entity.ShippingAddress;
import com.yrsoft.delivery.service.DeliveryAddress;
import com.yrsoft.delivery.vo.DoubleAddressVO;
import org.apache.servicecomb.provider.springmvc.reference.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;


@Component
public class AddressServiceImpl implements DeliveryAddress {

    private static RestTemplate restTemplate = RestTemplateBuilder.create();

    @Override
    public Address saveAddress(Address address) {
        if (address == null) {
            throw new NullParamException(201, "address实例参数不能为空");
        }
        address.setId(UUID.randomUUID().toString().replace("-", ""));
        address.setDeleteFlag(0);
        address.setCreateTime(DateUtils.getNow());
        address.setUpdateTime(DateUtils.getNow());
        String json = restTemplate.postForObject(UrlContants.PLATFORM + "pShippingAddress/add", HttpUtils.getHttpEntity(address), String.class);
        AddressDTO addressDTO = JSONUtil.toBean(json, AddressDTO.class);
        if (addressDTO.getCode() != 200) {
            throw new LSJExceptions(addressDTO.getCode(), addressDTO.getMessage());
        }
        return addressDTO.getData();
    }
    /**
	 * 功能描述: 收发货地址更新
	 * 
	 * @param id
	 * @param shipperId
	 * @return
	 */
    @Override
	public JsonResult updateAddress(String paramStr) {
    	JSONObject jsonObject = JSONObject.parseObject(paramStr);
    	//参数验证
    	if(jsonObject.get("shipperId")==null || jsonObject.get("shipperId").equals("")){
    		return JsonResult.error(201, "请输入货主编号");
    	}
    	if(jsonObject.get("id")==null || jsonObject.get("id").equals("")){
    		return JsonResult.error(201, "请输入地址id");
    	}
    	if(jsonObject.get("addressStatus")==null || jsonObject.get("addressStatus").equals("")){
    		return JsonResult.error(201, "请输入地址类型");
    	}
    	
    	MultiValueMap<String, Object> requestEntity = new LinkedMultiValueMap<>();
    	requestEntity.add("id", jsonObject.get("id").toString());
    	requestEntity.add("shipperId", jsonObject.get("shipperId").toString());
    	
    	requestEntity.add("province", jsonObject.get("province").toString());
    	requestEntity.add("city", jsonObject.get("city").toString());
    	requestEntity.add("area", jsonObject.get("area").toString());
    	
    	requestEntity.add("address", jsonObject.get("address").toString());
    	requestEntity.add("lng", jsonObject.get("lng").toString());
    	requestEntity.add("lat", jsonObject.get("lat").toString());
    	
    	requestEntity.add("name", jsonObject.get("name").toString());
    	requestEntity.add("phone", jsonObject.get("phone").toString());
    	requestEntity.add("updateTime", DateUtils.getTimeMillis().toString());
    	requestEntity.add("defaultState", jsonObject.get("defaultState").toString());
    	requestEntity.add("addressType", jsonObject.get("addressType").toString());
    	requestEntity.add("addressStatus", jsonObject.get("addressStatus").toString());
    	/** 删除状态（0：未删除，1：已删除） */
    	requestEntity.add("deleteFlag", jsonObject.get("deleteFlag").toString());
    	//通过调用其他接口实现service
    	JsonResult js = restTemplate.postForObject(UrlContants.PLATFORM +"pShippingAddress/edit",requestEntity,JsonResult.class);
    	if (js.getCode() != 200) {
            throw new LSJExceptions(js.getCode(), js.getMessage());
        }
        return js;
	}

    @Override
    @Transactional
    public DoubleAddressVO firstSaveAddress(DoubleAddressVO doubleAddressVO) {
        //构建发货地址对象
        Address address = getAddress(doubleAddressVO.getDeleteFlag(), doubleAddressVO.getDeliverDefaultState(), 0,doubleAddressVO.getShipperId());
        doubleAddressVO.setDeliverId(address.getId());
        address.setProvince(doubleAddressVO.getDeliverProvince());
        address.setCity(doubleAddressVO.getDeliverCity());
        address.setArea(doubleAddressVO.getDeliverArea());
        address.setAddress(doubleAddressVO.getDeliverAddress());
        address.setLat(doubleAddressVO.getDeliverLat());
        address.setLng(doubleAddressVO.getDeliverLng());
        address.setProvinceCode(doubleAddressVO.getDeliverProvinceCode());
        address.setCityCode(doubleAddressVO.getDeliverCityCode());
        address.setAreaCode(doubleAddressVO.getDeliverAreaCode());
        //添加发货地址
        String json = restTemplate.postForObject(Constants.URL_PREFIX + "pShippingAddress/add", HttpUtils.getHttpEntity(address), String.class);
        DoubleAddressDTO doubleAddressDTO = JSONUtil.toBean(json, DoubleAddressDTO.class);
        if (doubleAddressDTO.getCode() != 200){
            throw new LSJExceptions(doubleAddressDTO.getCode(), doubleAddressDTO.getMessage());
        }
        //构建收货地址对象
        Address address1 = getAddress(doubleAddressVO.getDeleteFlag(), doubleAddressVO.getTakeDefaultState(), 1,doubleAddressVO.getShipperId());
        doubleAddressVO.setTakeId(address1.getId());
        address1.setProvince(doubleAddressVO.getTakeProvince());
        address1.setCity(doubleAddressVO.getTakeCity());
        address1.setArea(doubleAddressVO.getTakeArea());
        address1.setAddress(doubleAddressVO.getTakeAddress());
        address1.setLat(doubleAddressVO.getTakeLat());
        address1.setLng(doubleAddressVO.getTakeLng());
        address1.setProvinceCode(doubleAddressVO.getTakeProvinceCode());
        address1.setCityCode(doubleAddressVO.getTakeCityCode());
        address1.setAreaCode(doubleAddressVO.getTakeAreaCode());
        address1.setName(doubleAddressVO.getName());
        address1.setPhone(doubleAddressVO.getPhone());
        String json1 = restTemplate.postForObject(Constants.URL_PREFIX + "pShippingAddress/add", HttpUtils.getHttpEntity(address1), String.class);
        DoubleAddressDTO doubleAddressDTO1 = JSONUtil.toBean(json, DoubleAddressDTO.class);
        if (doubleAddressDTO1.getCode() != 200){
            throw new LSJExceptions(doubleAddressDTO1.getCode(), doubleAddressDTO1.getMessage());
        }
        return doubleAddressVO;
    }

    private Address getAddress(int deleteFlag,int defaultState,int addressType,String shipperId){
        Address address = new Address();
        address.setId(UUID.randomUUID().toString().replace("-", ""));
        address.setShipperId(shipperId);
        address.setDeleteFlag(deleteFlag);
        address.setCreateTime(DateUtils.getNow());
        address.setUpdateTime(DateUtils.getNow());
        address.setDefaultState(defaultState);
        address.setAddressType(addressType);
        return address;
    }
}
