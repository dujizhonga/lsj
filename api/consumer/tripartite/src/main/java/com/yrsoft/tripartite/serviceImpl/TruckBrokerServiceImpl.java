package com.yrsoft.tripartite.serviceImpl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.vvise.wccyclient.vo.RestResult;
import com.yrsoft.common.constant.UrlContants;
import com.yrsoft.common.truckBroker.TruckBrokerSendUtil;
import com.yrsoft.common.utils.JsonResult;
import com.yrsoft.common.utils.StringUtils;
import com.yrsoft.tripartite.service.TruckBrokerService;

@Service
public class TruckBrokerServiceImpl implements TruckBrokerService {
	
	@Autowired
	private RestTemplate template;

	
	
	@Override
	public RestResult sendWaybill(String orderCode, String orderCreateDate, String startDate, String arriveDate,String userName,String idCardNo,
			String startAddress, String receiveUserName,String  arriveAddress, String orderAmount, String carNumber,
			String loadWeight, String yszh,String driverName, String goodsName, String goodsWeight,
			String xkzh,String driverRecordName,String qualificationCode,
			String driverRecordTelephone, String startCityCode, String arriveCityCode) {
		RestResult rest = TruckBrokerSendUtil.sendWaybillData(orderCode, orderCreateDate, startDate, arriveDate, userName, idCardNo, startAddress, receiveUserName, arriveAddress, orderAmount, carNumber, loadWeight, yszh, driverName, goodsName, goodsWeight, xkzh,driverRecordName, qualificationCode, driverRecordTelephone, startCityCode, arriveCityCode);
		// 记录发送日志
		recordResponse("1",orderCode,rest.getCode(),String.valueOf(rest.getContent()));
		return rest;
		
	}

	@Override
	public RestResult sendFundFlow(String orderCode, String carrier, String vehicleNumber, int payway,
			String transcationAmount, String sequenceCode, String transcationDateTime) {
		RestResult rest = TruckBrokerSendUtil.sendFundFlowData(orderCode, carrier, vehicleNumber, payway, transcationAmount, sequenceCode, transcationDateTime);
		// 记录发送日志
		recordResponse("2",orderCode,rest.getCode(),String.valueOf(rest.getContent()));
		return rest;
	}

	@Override
	public JsonResult send(String waybillIds) {
		List<String> waybillIdList = Arrays.asList(waybillIds);
		int size = waybillIdList.size();
		for (int i = 0; i < size; i++) {
			String waybillId = waybillIdList.get(i);
			Map<String, Object> dataMap = getAllData(waybillId);
			String orderCode = String.valueOf(dataMap.get("orderCode"));
			String orderCreateDate = String.valueOf(dataMap.get("orderCreateDate"));
			String startDate = String.valueOf(dataMap.get("startDate"));
			String arriveDate = String.valueOf(dataMap.get("arriveDate"));
			String userName = String.valueOf(dataMap.get("userName"));
			String idCardNo = String.valueOf(dataMap.get("idCardNo"));
			String startAddress = String.valueOf(dataMap.get("startAddress"));
			String receiveUserName = String.valueOf(dataMap.get("receiveUserName"));
			String arriveAddress = String.valueOf(dataMap.get("arriveAddress"));
			String orderAmount = String.valueOf(dataMap.get("orderAmount"));
			String carNumber = String.valueOf(dataMap.get("carNumber"));
			String loadWeight = String.valueOf(dataMap.get("loadWeight"));
			String yszh = String.valueOf(dataMap.get("yszh"));
			String driverName = String.valueOf(dataMap.get("driverName"));
			String goodsName = String.valueOf(dataMap.get("goodsName"));
			String goodsWeight = String.valueOf(dataMap.get("goodsWeight"));
			String xkzh = String.valueOf(dataMap.get("xkzh"));
			String driverRecordName = String.valueOf(dataMap.get("driverName"));
			String qualificationCode = String.valueOf(dataMap.get("businessLicense"));
			String driverRecordTelephone = String.valueOf(dataMap.get("driverTelephone"));
			String startCityCode = String.valueOf(dataMap.get("startCityCode"));
			String arriveCityCode = String.valueOf(dataMap.get("arriveCityCode"));
			String sequenceCode = String.valueOf(dataMap.get("sequenceCode"));
			String transcationDateTime = String.valueOf(dataMap.get("transcationDateTime"));
			int payWay = Integer.parseInt((dataMap.get("payway")+""));
			// 发送电子路单
			RestResult waybillSendResult = 
			sendWaybill(orderCode, orderCreateDate, startDate, 
					arriveDate, userName, idCardNo, 
					startAddress, receiveUserName, arriveAddress,
					orderAmount, carNumber, loadWeight, yszh,
					driverName, goodsName, goodsWeight, xkzh,
					driverRecordName, qualificationCode, driverRecordTelephone, 
					startCityCode, arriveCityCode) ;
			
			// 如果电子路单数据发送成功,再发送资金流水单数据
			if ("0000".equals(waybillSendResult.getCode())) {
				sendFundFlow(orderCode,userName,carNumber,payWay,orderAmount,sequenceCode,transcationDateTime);
			}
		}
		return JsonResult.success(200, "无车承运人数据发送完毕");
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getAllData(String waybillId) {
		MultiValueMap<String, String> requestEntity = new LinkedMultiValueMap<>();
		requestEntity.set("waybillId", waybillId);
		JsonResult reseult = template.postForObject(
		    UrlContants.PLATFORM+"pWaybill/selectTruckBrokerData",
		    requestEntity,
		    JsonResult.class);
		Object data = reseult.getData();
		
		
		Gson gson = new Gson();
		Map<String,Object> dataMap = new HashMap<String, Object>();
		dataMap = gson.fromJson(String.valueOf(data), dataMap.getClass());
		// 获得发货人的姓名,身份证号
		requestEntity.clear();
		requestEntity.set("memberId",String.valueOf(dataMap.get("shipperId")));
		JsonResult memberJson = template.postForObject(
			    UrlContants.AUTH+"auth/person/selectPersonByMemberId",
			    requestEntity,
			    JsonResult.class);
		Map<String,Object> shipperMap = new HashMap<String, Object>();
		shipperMap=gson.fromJson(String.valueOf(memberJson.getData()), shipperMap.getClass());
		
		// 根据车辆id车辆信息
		requestEntity.clear();
		requestEntity.set("id",String.valueOf(dataMap.get("carId")));
		JsonResult carJson =  template.postForObject(
			    UrlContants.AUTH+"car/getCarById",
			    requestEntity,
			    JsonResult.class);
		Map<String,Object> carMap = new HashMap<String, Object>();
		carMap = gson.fromJson(String.valueOf(carJson.getData()), carMap.getClass());
		
		// 根据车主会员ID查询车主信息
		requestEntity.clear();
		requestEntity.set("id",String.valueOf(dataMap.get("ownerId")));
		JsonResult ownerJson =  template.postForObject(
			    UrlContants.AUTH+"mMember/getMMemberById",
			    requestEntity,
			    JsonResult.class);
		Map<String,Object> ownerMap = new HashMap<String, Object>();
		ownerMap = gson.fromJson(String.valueOf(ownerJson.getData()), ownerMap.getClass());
		
		// 根据司机driverId查询司机信息
		requestEntity.clear();
		requestEntity.set("id",String.valueOf(dataMap.get("driverId")));
		JsonResult driverJson =  template.postForObject(
			    UrlContants.AUTH+"mMember/getMMemberById",
			    requestEntity,
			    JsonResult.class);
		Map<String,Object> driverMap = new HashMap<String, Object>();
		driverMap = gson.fromJson(String.valueOf(driverJson.getData()), driverMap.getClass());
		
		// 查询支付方式   f_pay_log
		requestEntity.clear();
		requestEntity.set("outTradeNo", waybillId);
		requestEntity.set("memberId",String.valueOf(dataMap.get("shipperId")));
		requestEntity.set("payState",String.valueOf(1));
		requestEntity.set("page", String.valueOf(1));
		requestEntity.set("limit", String.valueOf(1));
		JsonResult payLogJson =  template.postForObject(
			    UrlContants.FINANCE+"mPayLog/list",
			    requestEntity,
			    JsonResult.class);
		Map<String,Object> payLogMap = new HashMap<String, Object>();
		payLogMap = gson.fromJson(String.valueOf(payLogJson.getData()), payLogMap.getClass());
		
		// 发货人姓名
		dataMap.put("userName",shipperMap.get("realName"));
		// 身份证号
		dataMap.put("idCardNo",shipperMap.get("idCardCode"));
		// 车牌号
		dataMap.put("carNumber",carMap.get("carNumber"));
		// 车辆载重
		dataMap.put("loadWeight",carMap.get("totalTractionWight"));
		// 运输证号
		dataMap.put("yszh",carMap.get("transportLicense"));
		// 车主(车辆的拥有者)姓名 
		dataMap.put("ownerName",ownerMap.get("realName"));
		// 经营许可证号
		dataMap.put("xkzh", carMap.get("businessLicense"));
	    // 司机姓名
		dataMap.put("driverName",driverMap.get("realName"));
		// 司机电话
		dataMap.put("driverTelephone", driverMap.get("telephone"));
		// 支付方式
		dataMap.put("payway", payLogMap.get("payType"));
		// 支付流水号
		dataMap.put("sequenceCode", payLogMap.get("paySerialCode"));
		// 支付时间
		dataMap.put("transcationDateTime", payLogMap.get("payTime"));
		return  dataMap;
	}
	
	private void recordResponse(String type,String orderCode,String code,String content ) {
		MultiValueMap<String, String> requestEntity = new LinkedMultiValueMap<>();
		requestEntity.set("id", StringUtils.getUUID());
		requestEntity.set("type",type);
		requestEntity.set("orderCode", orderCode);
		requestEntity.set("code", code);
		requestEntity.set("content", content);
		template.postForObject(
			    UrlContants.PLATFORM+"platform/truckBrokerSendLog/add",
			    requestEntity,
			    JsonResult.class);
	}
}
