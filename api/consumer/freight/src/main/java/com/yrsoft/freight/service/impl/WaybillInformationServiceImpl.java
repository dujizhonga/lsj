package com.yrsoft.freight.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.servicecomb.provider.springmvc.reference.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSONObject;
import com.yrsoft.common.constant.Constants;
import com.yrsoft.common.constant.UrlContants;
import com.yrsoft.common.utils.JsonResult;
import com.yrsoft.common.utils.StringUtils;
import com.yrsoft.freight.entity.WaybillInformation;
import com.yrsoft.freight.service.WaybillInformationService;

/**
 * 
 * @ClassName:      WaybillInformationServiceImpl
 * @author:         Du'jizhong
 * @date:           2019年2月25日 上午9:16:33
 */
@Service
public class WaybillInformationServiceImpl implements WaybillInformationService {
	
	//声明提供者请求对象
	private static RestTemplate restTemplate = RestTemplateBuilder.create();

	
	/**
	 * 货运单-分页查寻运单列表信息
	 * @param paraMap
	 * @return
	 * @author:DU'JZ
	 * @data:2019年2月26日 上午11:30:29 
	 * @throws
	 */
	@Override
	public JsonResult selectWaybillInformationByPage(String paraMap) {
		//声明封装请求参数对象
		MultiValueMap<String, String> requestEntity = new LinkedMultiValueMap<>();
		//把参数转换成json对象
		JSONObject jsonObject = JSONObject.parseObject(paraMap);
		//分页查寻，判断limit是否传参
		if (!paraMap.contains("limit")) {		
			return JsonResult.error(201, "limit参数有误");
		}
		//分页查寻，判断page是否传参
		if (!paraMap.contains("page")) {
			return JsonResult.error(201, "page参数有误");
		}
		//循环遍历封装参数
		for (String key : jsonObject.keySet()) { 
			requestEntity.add(key, jsonObject.getString(key));
		}
		try {
			//运单请求数据
			ResponseEntity<String> waybillInformation = restTemplate.postForEntity(UrlContants.PLATFORM+"pWaybill/list", requestEntity, String.class);
			int code = waybillInformation.getStatusCodeValue(); 
			JSONObject body = JSONObject.parseObject(waybillInformation.getBody());
			JsonResult jsonResult = JSONObject.toJavaObject(body, JsonResult.class);
			if (code !=200) {	//判断链接基础数据请求返回结果是正常
				return JsonResult.error(207, "基础数据服务错误");
			}
			//基础数据执行是否正常
			if (body.getInteger("code") != 200) { 
				return jsonResult;
			}
			//返回基础数据是否为空
			if (jsonResult.getData() == null) {
				return jsonResult;
			}
			List<JSONObject> list = (List<JSONObject>)jsonResult.getData();
			List<WaybillInformation> waybillList = new ArrayList<WaybillInformation>();
			//遍历数据列表，封装其他参数
			for(JSONObject params : list) {
				WaybillInformation param = JSONObject.toJavaObject(params,WaybillInformation.class);
				String carId = param.getCarId();
				String ownerId = param.getOwnerId();
				requestEntity.clear();
				//封装车辆请求参数，并发送请求
				requestEntity.add("id", carId);
				ResponseEntity<String> carInfo = restTemplate.postForEntity(UrlContants.AUTH+"car/getCarById", requestEntity, String.class);
				int carCode = carInfo.getStatusCodeValue();
				JSONObject carBody = JSONObject.parseObject(carInfo.getBody());
				JSONObject carData = JSONObject.parseObject(carBody.getString("data"));
				if (carCode == 200) {
					if (carData != null) {
						//封装车辆参数
						param.setCarNum(carData.getString("carNumber"));
						param.setRunStatus(carData.getIntValue("runStatus"));
					}
				}
				//发送请求车主信息参数
				requestEntity.clear();
				requestEntity.add("id", ownerId);
				ResponseEntity<String> ownerInfo = restTemplate.postForEntity(UrlContants.MEMBER+"mMember/getMMemberById", requestEntity, String.class);
				int ownerCode = ownerInfo.getStatusCodeValue();
				JSONObject ownerBody = JSONObject.parseObject(ownerInfo.getBody());
				JSONObject ownerData = JSONObject.parseObject(ownerBody.getString("data"));
				//请求是否成功
				if (ownerCode == 200) {
					//请求的参数是否为空
					if (ownerData != null) {
						param.setOwnerName(ownerData.getString("realName"));//车主姓名;
						//判断车主电话是否为11位数字
						if (ownerData.getString("telephone") != null && ownerData.getString("telephone").length()>11) {
							//手机号中间四位替换成*
							String telephone = ownerData.getString("telephone");
							param.setOwnerTelephone(telephone.replaceAll("(\\d{3})\\d{4}(\\d{4})","$1****$2"));
						}else {
							param.setOwnerTelephone(ownerData.getString("telephone"));//车主电话,防止是座机电话;
						}
					}
				}
				waybillList.add(param);
			}
			//重新赋值list集合参数
			jsonResult.setData(waybillList);
			return jsonResult;
		} catch (RestClientException e) {
			e.printStackTrace();
			return JsonResult.error(500, "服务器错误");
		}
	}
	/**
	 * 货运单-运单列表信息  不分页查寻
	 * @param paraMap
	 * @return
	 * @author:DU'JZ
	 * @data:2019年2月25日 下午2:38:46 
	 * @throws
	 */
	@Override
	public JsonResult selectWaybillInformation(String paraMap) {
		//声明封装请求参数对象
		MultiValueMap<String, String> requestEntity = new LinkedMultiValueMap<>();
		//把参数转换成json对象
		JSONObject jsonObject = JSONObject.parseObject(paraMap);
		//根据货运单Id查寻运单，必传参数
		if (!paraMap.contains("invoiceId")) {
			return JsonResult.error(201, "invoiceId参数有误");
		}
		//循环遍历封装参数
		for (String key : jsonObject.keySet()) { 
			requestEntity.add(key, jsonObject.getString(key));
		}
		if (jsonObject.containsKey("runStatus")) {	//封装车辆运货状态参数
			requestEntity.add("runStatus", jsonObject.get("runStatus").toString());
		}
		try {
			//运单请求数据
			ResponseEntity<String> waybillInformation = restTemplate.postForEntity(UrlContants.PLATFORM+"pWaybill/listByInvoiceId", requestEntity, String.class);
			int code = waybillInformation.getStatusCodeValue();
			JSONObject body = JSONObject.parseObject(waybillInformation.getBody());
			JsonResult jsonResult = JSONObject.toJavaObject(body, JsonResult.class);
			if (code !=200) {	//判断链接基础数据请求返回结果是正常
				return JsonResult.error(207, "基础数据服务错误");
			}
			//基础数据执行是否正常
			if (body.getInteger("code") != 200) { 
				return jsonResult;
			}
			//返回基础数据是否为空
			if (jsonResult.getData() == null) {
				return jsonResult;
			}
			//请求货运单的目的地信息
			requestEntity.clear();
			requestEntity.add("id", jsonObject.getString("invoiceId"));
			ResponseEntity<String> invoiceInfo = restTemplate.postForEntity(UrlContants.PLATFORM+"pInvoice/getPInvoiceById", requestEntity, String.class);
			int invoiceCode = invoiceInfo.getStatusCodeValue();
			JSONObject invoiceBody = JSONObject.parseObject(invoiceInfo.getBody());
			JSONObject invoiceData = JSONObject.parseObject(invoiceBody.getString("data"));
			String invoiceLat = "";
			String invoiceLng = "";
			if (invoiceCode == 200) {
				if (invoiceData != null) {
					//封装车辆参数
					invoiceLat = invoiceData.getString("arriveLat");
					invoiceLng = invoiceData.getString("arriveLng");;
				}
			}
			List<JSONObject> list = (List<JSONObject>)jsonResult.getData();
			List<WaybillInformation> waybillList = new ArrayList<WaybillInformation>();
			//遍历数据列表，封装其他参数
			for(JSONObject params : list) {
				WaybillInformation param = JSONObject.toJavaObject(params,WaybillInformation.class);
				param.setInvoiceLat(invoiceLat);
				param.setInvoiceLng(invoiceLng);
				String carId = param.getCarId();
				requestEntity.clear();
				//封装车辆请求参数，并发送请求
				requestEntity.add("id", carId);
				ResponseEntity<String> carInfo = restTemplate.postForEntity(UrlContants.AUTH+"car/getCarById", requestEntity, String.class);
				int carCode = carInfo.getStatusCodeValue();
				JSONObject carBody = JSONObject.parseObject(carInfo.getBody());
				JSONObject carData = JSONObject.parseObject(carBody.getString("data"));
				if(carCode == 200){
					if (carData != null){
						//封装车辆参数
						param.setCarNum(carData.getString("carNumber"));
						param.setRunStatus(carData.getIntValue("runStatus"));
						param.setDriverId(carData.getString("driver1Id"));
					}
				}
				//发送请求车辆位置信息
				ResponseEntity<String> carPosition = restTemplate.postForEntity(UrlContants.POSITION+"poCarPosition/getPoCarPositionById", requestEntity, String.class);
				int carPositionCode = carInfo.getStatusCodeValue();
				JSONObject carPositionBody = JSONObject.parseObject(carPosition.getBody());
				JSONObject carPositionData = JSONObject.parseObject(carPositionBody.getString("data"));
				if (carPositionCode == 200) {
					if (carPositionData != null) {
						//封装车辆参数
						param.setLat(carPositionData.getString("lat"));
						param.setLng(carPositionData.getString("lng"));
					}
				}
				//发送请求司机信息参数
				if (param.getDriverId() != null) {
					requestEntity.clear();
					requestEntity.add("id",param.getDriverId());
					ResponseEntity<String> driverInfo = restTemplate.postForEntity(UrlContants.MEMBER+"mMember/getMMemberById", requestEntity, String.class);
					int driverCode = carInfo.getStatusCodeValue();
					JSONObject driverBody = JSONObject.parseObject(driverInfo.getBody());
					JSONObject driverData = JSONObject.parseObject(driverBody.getString("data"));
					//请求是否成功
					if (driverCode == 200) {
						//请求的参数是否为空
						if (driverData != null) {
							param.setDriverName(driverData.getString("realName"));//司机电话
							param.setDriverteleph(driverData.getString("telephone"));
						}
					}
				}
				//遍历一次，重新封装list集合
				waybillList.add(param);
			}
			//重新赋值list集合参数
			jsonResult.setData(waybillList);
			return jsonResult;
		} catch (RestClientException e) {
			e.printStackTrace();
			return JsonResult.error(500, "服务器错误");
		}
	}


	/**
	 * 对运单进行评价
	 * @param: @param paraMap
	 * @param: @return
	 * @return: JsonResult
	 * @auther: shihh
	 * @date: 2019年2月26日上午11:34:47
	 */
	// 运单评价事务回滚
	@Transactional
	@Override
	public JsonResult addComments(String paramStr) {
		JSONObject paraMaps = JSONObject.parseObject(paramStr);
		String id[] = paraMaps.get("ids").toString().split(",");
		if (id.length < 1) {
			JsonResult.error(201, "运单id不能为空");
		}
		for (int i = 0; i < id.length; i++) {
			MultiValueMap<String, String> requestEntity = new LinkedMultiValueMap<>();

			// 评论星级（5：五星，4：四星.....
			if (StringUtils.isEmpty(paraMaps.getString("star").toString())) {
				JsonResult.error(201, "评价星级不能为空");
			}
			if (StringUtils.isEmpty(paraMaps.getString("comment").toString())) {
				JsonResult.error(201, "评价内容不能为空");
			}
			if (StringUtils.isEmpty(paraMaps.getString("evaluateOptions").toString())) {
				JsonResult.error(201, "评价选项不能为空");
			}
			if (StringUtils.isEmpty(paraMaps.getString("isComments").toString())) {
				JsonResult.error(201, "是否已经评价不能为空不能为空");
			}
			requestEntity.add("star", paraMaps.getString("star"));
			// 评价内容
			requestEntity.add("comment", paraMaps.getString("comment"));
			// 评价选项
			requestEntity.add("evaluateOptions", paraMaps.getString("evaluateOptions"));
			// 是否已评价修改为1 是否已评论（0：否，1是）
			requestEntity.add("isComments", paraMaps.getString("isComments"));
			// 运单id
			requestEntity.add("id", id[i].toString());
			try {
				ResponseEntity<String> f = restTemplate.postForEntity(UrlContants.PLATFORM+"pWaybill/addEvaluate", requestEntity,
						String.class);
				JSONObject jb = JSONObject.parseObject(f.getBody());
				String code = jb.get("code").toString();
				if (!code.equals("200")) {
					JsonResult.error(207, "第" + i + "条评价失败");
				}
			} catch (RestClientException e) {
				e.printStackTrace();
				return JsonResult.error(500, "服务器错误");
			}
		}
		return JsonResult.success(200, "运单评价成功");
	}

	/*@Override
	public JsonResult selectWaybillByShipperId(String paramStr) {
		String url = "http://localhost:8084";
		//声明封装请求参数对象
		MultiValueMap<String, String> requestEntity = new LinkedMultiValueMap<>();
				//把参数转换成json对象
		JSONObject paraMaps = JSONObject.parseObject(paramStr);
		//分页查寻，判断limit是否传参
		if (!paramStr.contains("limit")) {		
			return JsonResult.error(201, "limit参数有误");
		}
				//分页查寻，判断page是否传参
		if (!paramStr.contains("page")) {
			return JsonResult.error(201, "page参数有误");
		}
		if (StringUtils.isEmpty(paraMaps.getString("shipperId"))) {
			return JsonResult.error(201, "货主id不能为空");
		}
		//循环遍历封装参数
		for (String key : paraMaps.keySet()) { 
			requestEntity.add(key, paraMaps.getString(key));
		}
		requestEntity.add("limit", paraMaps.getString("limit"));
		requestEntity.add("page", paraMaps.getString("page"));
		requestEntity.add("shipperId", paraMaps.getString("shipperId"));
		try {
			ResponseEntity<String> waybillInformation = restTemplate.postForEntity(UrlContants.PLATFORM+"pWaybill/selectWaybill",requestEntity, String.class);
			int code = waybillInformation.getStatusCodeValue();
			JSONObject body = JSONObject.parseObject(waybillInformation.getBody());
			JsonResult jsonResult = JSONObject.toJavaObject(body, JsonResult.class);
			if (code !=200) {	//判断链接基础数据请求返回结果是正常
				return JsonResult.error(207, "基础数据服务错误");
			}
			
			if (body.getInteger("code") != 200) {
				return jsonResult;
			}
			if (jsonResult.getData() == null) {
				return jsonResult;
			}
			
			requestEntity.clear();
			List<JSONObject> list = (List<JSONObject>)jsonResult.getData();
			List<WaybillInformation> waybillList = new ArrayList<WaybillInformation>();
			for(JSONObject params : list) {
				WaybillInformation param = JSONObject.toJavaObject(params,WaybillInformation.class);
				String ownerId = param.getOwnerId();
				requestEntity.clear();
				requestEntity.add("id", ownerId);
				ResponseEntity<String> memberInfo = restTemplate.postForEntity(UrlContants.MEMBER+"mMember/getMMemberById", requestEntity, String.class);
				int memberCode = memberInfo.getStatusCodeValue();
				JSONObject memberBody = JSONObject.parseObject(memberInfo.getBody());
				JSONObject MemberData = JSONObject.parseObject(memberBody.getString("data"));
				if (memberCode == 200) {
					if (MemberData != null) {
						//封装车辆参数
						//车主电话
						param.setOwnerTelephone(MemberData.getString("telephone"));
						//车主名称
						param.setOwnerName(MemberData.getString("realName"));
					}
				}
				requestEntity.clear();
				requestEntity.add("id", param.getCarId());
				ResponseEntity<String> carInfo = restTemplate.postForEntity(UrlContants.AUTH+"car/getCarById", requestEntity, String.class);
				int carCode = carInfo.getStatusCodeValue();
				JSONObject carBody = JSONObject.parseObject(carInfo.getBody());
				JSONObject carData = JSONObject.parseObject(carBody.getString("data"));
				if (carCode == 200) {
					if (carData != null) {
						//车牌号
						param.setCarNum(carData.getString("carNumber"));
					}
				}
				waybillList.add(param);
			}
			jsonResult.setData(waybillList);
			return jsonResult;
		} catch (RestClientException e) {
			return JsonResult.error(500, "服务器错误");
		}
	}*/

	/*@Override
	public JsonResult selectPinvoiceById(String paramStr) {
		String url = "http://localhost:8080";
		MultiValueMap<String, String> requestEntity = new LinkedMultiValueMap<>();
		JSONObject paraMaps = JSONObject.parseObject(paramStr);
		if (StringUtils.isEmpty(paraMaps.getString("invoiceId"))) {
			return JsonResult.error(201, "货运单invoiceId不能为空");
		}
		//传入的货运单id
		requestEntity.add("id", paraMaps.getString("invoiceId"));
		try {
			ResponseEntity<String> waybillInformation = restTemplate.postForEntity(UrlContants.PLATFORM+"pInvoice/getPInvoiceById",
					requestEntity, String.class);
			int code = waybillInformation.getStatusCodeValue();
			if (code == 200) { // 判断链接基础数据请求返回结果是正常
				JSONObject body = JSONObject.parseObject(waybillInformation.getBody());
				JsonResult jsonResult = JSONObject.toJavaObject(body, JsonResult.class);
				return jsonResult;
			}
			return JsonResult.error(207, "基础数据服务错误");
		} catch (RestClientException e) {
			return JsonResult.error(500, "服务器错误");
		}
	}*/
	
	@Override
	public JsonResult updateWaybillForInsurance(String waybillIds,String insuranceId) {
		// 根据insuranceId获得运单保险费的支付状态
		MultiValueMap<String, String> requestEntity = new LinkedMultiValueMap<>();
		requestEntity.add("insuranceId",insuranceId);
		JsonResult json = restTemplate.postForObject(
				UrlContants.PLATFORM+"/provider/pInsurance/getPInsuranceById",
				requestEntity,
			    JsonResult.class);
		Object data = json.getData();
		JSONObject insuranceJson =  JSONObject.parseObject(String.valueOf(data));
		/*
		 * 保险费支付状态 	支付状态 0-待支付 1-成功 2-失败
		 * 运单保险费支付状态等同于运单保险费支付记录中的保险费支付状态
		 */
		Integer insurancePayState = insuranceJson.getInteger("payState");
		
		// 更新运单保险费支付状态
		requestEntity.add("ids", waybillIds);
		requestEntity.add("insurancePayState", String.valueOf(insurancePayState));
		
		restTemplate.postForObject(UrlContants.PLATFORM + "/provider/pWaybill/updateByIds", requestEntity,
				JsonResult.class);
		
		// 返回结果
		if (insurancePayState == 0) {
			return JsonResult.success(201, "待支付");
		} 
		if (insurancePayState == 1) {
			return JsonResult.success(200, "支付成功");
		} 
		return JsonResult.success(201,"支付失败");
		
	}
	
}
