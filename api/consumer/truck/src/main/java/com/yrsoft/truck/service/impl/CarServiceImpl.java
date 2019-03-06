package com.yrsoft.truck.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.servicecomb.provider.springmvc.reference.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSONObject;
import com.yrsoft.common.constant.UrlContants;
import com.yrsoft.common.utils.JsonResult;
import com.yrsoft.truck.dto.CarInfoDTO;
import com.yrsoft.truck.dto.CarInfosDTO;
import com.yrsoft.truck.service.CarService;
import com.yrsoft.truck.vo.CarInfoVO;

import cn.hutool.json.JSONUtil;
import io.vertx.ext.web.handler.sockjs.impl.JsonCodec;

/**
 * 查询所有自有车位置及基本信息
 * 
 * @author yxq
 * @date 2019/2/25
 */
@Service
public class CarServiceImpl implements CarService {

	private static RestTemplate restTemplate = RestTemplateBuilder.create();

	/**
	 * 通过货主id查询车辆信息
	 *
	 * @param param
	 * @return 结果
	 */
	@Override
	public JsonResult selectCarByShipperId(String paramStr) {
		JSONObject jsonObject = JSONObject.parseObject(paramStr);
		String shipperId = jsonObject.getString("shipperId");
		Integer flag = jsonObject.getInteger("flag");
		if(flag ==null || flag.equals("")){
    		return JsonResult.error(201, "请输入查询标识");
    	}
		List<CarInfoVO> carInfos=new ArrayList<>();
		//flag 0-分页查询  1-不分页
		//查询货主关注的自有车辆列表
		if(flag==0) {
			Integer page = jsonObject.getInteger("page");
			Integer limit = jsonObject.getInteger("limit");
			if(shipperId ==null || shipperId.equals("")){
	    		return JsonResult.error(201, "请输入货主id");
	    	}
			if(null == page || null == limit ) {
				return JsonResult.success(201,"请传分页参数");
			}
			if(page<0 || limit < 0) {
				return JsonResult.success(201, "分页参数错误");
			}
			MultiValueMap<String, String> requestEntity = new LinkedMultiValueMap<>();
			requestEntity.add("shipperId", shipperId);
			requestEntity.set("page", String.valueOf(page));
			requestEntity.set("limit", String.valueOf(limit));
			requestEntity.set("carNumber", jsonObject.getString("carNumber"));
		   
			JsonResult forObject = restTemplate.postForObject(UrlContants.AUTH+"car/selectCarsInfo", requestEntity,JsonResult.class);
			return forObject;
		
		}else {
			//查询货主关注的所有自有车辆及车辆位置
			MultiValueMap<String, String> requestEntity = new LinkedMultiValueMap<>();
			requestEntity.add("shipperId", shipperId);
			String forObject = restTemplate.postForObject(UrlContants.AUTH+"car/selectCarInfo", requestEntity,String.class);
			CarInfosDTO carInfosDTO = JSONUtil.toBean(forObject, CarInfosDTO.class);
			if (carInfosDTO.getCode() == 201) {
				return JsonResult.success(carInfosDTO.getMessage());
			} else if (carInfosDTO.getCode() == 200) {
				List<CarInfoVO> datas = carInfosDTO.getData();
				for (CarInfoVO car : datas) {
					
					requestEntity.clear();
					requestEntity.add("id", car.getId());
					String str = restTemplate.postForObject(UrlContants.POSITION+"poCarPosition/getPoCarPositionById", requestEntity, String.class);
					CarInfoDTO carInfoDTO = JSONUtil.toBean(str, CarInfoDTO.class);
					if (carInfoDTO.getCode() == 201) {
						String lat="";
						String lng="";
						car.setLat(lat);
						car.setLng(lng);
					} else if (carInfoDTO.getCode() == 200) {
						
						CarInfoVO data = carInfoDTO.getData();
						car.setLat(data.getLat());
						car.setLng(data.getLng());
					}
				}
				System.out.println(datas);
				return JsonResult.success(datas);
			}
			return JsonResult.error(500, "系统 异常");
		}
	}
}
