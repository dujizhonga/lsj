package com.yrsoft.freight.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.servicecomb.provider.springmvc.reference.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yrsoft.common.constant.UrlContants;
import com.yrsoft.common.utils.DateUtils;
import com.yrsoft.common.utils.ExcelUtils;
import com.yrsoft.common.utils.JsonResult;
import com.yrsoft.common.utils.ParamVC;
import com.yrsoft.common.utils.StringUtils;
import com.yrsoft.freight.dto.BaseDTO;
import com.yrsoft.freight.dto.PInvoiceDTO;
import com.yrsoft.freight.entity.PInvoice;
import com.yrsoft.freight.entity.PStoredRecords;
import com.yrsoft.freight.service.StoredRecordService;

import cn.hutool.json.JSONUtil;

@Component
public class StoredRecordServiceImpl implements StoredRecordService {
	// 声明提供者请求对象
	private static RestTemplate restTemplate = RestTemplateBuilder.create();

	/**
	 * 查询储值基本信息
	 * 
	 * @param id
	 * @return JsonResult
	 */
	public JsonResult getStoredBaseInfomation(String id) {
		// 获取货运单信息
		MultiValueMap<String, String> requestEntity = new LinkedMultiValueMap<>();
		requestEntity.add("id", id);
		String json = restTemplate.postForObject(UrlContants.PLATFORM + "pInvoice/getPInvoiceById", requestEntity,
				String.class);

		// 将返回值json字符串转化为对象
		PInvoiceDTO pdo = JSONUtil.toBean(json, PInvoiceDTO.class);
		if (pdo.getCode() != 200) {
			return JsonResult.error(201, "货运单信息查询失败");
		}

		// 生成返回值对象
		Map<String, Object> resultMap = null;
		PInvoice pin = pdo.getData();
		if (StringUtils.isNotNull(pin)) {
			resultMap = new HashMap<>();
			resultMap.put("basicAmount", StringUtils.isNull(pin.getBasicAmount()) ? 0 : pin.getBasicAmount());
			resultMap.put("routeRange", StringUtils.isNull(pin.getRouteRange()) ? 0 : pin.getRouteRange());
		}
		return JsonResult.success(resultMap);
	}

	/**
	 * 生成储值分配记录
	 * 
	 * @param pvc
	 * @return JsonResult
	 * @throws Exception
	 */
	public JsonResult addStoredRecords(ParamVC pvc) throws Exception {
		// ids 运单id拼接字符串，逗号隔开
		String ids = pvc.getKey("ids");
		// etcScale etc储值百分比
		String etcScale = pvc.getKey("etcScale");
		// gasScale 气卡储值百分比
		String gasScale = pvc.getKey("gasScale");
		// oilScale 油卡储值百分比
		String oilScale = pvc.getKey("oilScale");

		String[] idArray = ids.split(",");
		for (int i = 0; i < idArray.length; i++) {
			MultiValueMap<String, String> requestEntity = new LinkedMultiValueMap<>();
			requestEntity.add("id", StringUtils.getUUID());
			requestEntity.add("waybillId", idArray[i]);
			requestEntity.add("etcScale", StringUtils.isNotBlank(etcScale) ? etcScale : "0");
			requestEntity.add("oilScale", StringUtils.isNotBlank(oilScale) ? oilScale : "0");
			requestEntity.add("gasScale", StringUtils.isNotBlank(gasScale) ? gasScale : "0");
			requestEntity.add("createTime", String.valueOf(DateUtils.getNow()));
			requestEntity.add("updateTime", "0");
			requestEntity.add("deleteFlag", "0");
			String json = restTemplate.postForObject(UrlContants.PLATFORM + "pStoredRecords/add", requestEntity,
					String.class);

			// 将返回值json字符串转化为对象
			BaseDTO bd = JSONUtil.toBean(json, BaseDTO.class);

			if (bd.getCode() == 200) {
				continue;
			} else {
				throw new RuntimeException("储值分派失败");
			}
		}
		return JsonResult.success(200, "储值分派成功");
	}

	/**
	 * 生产资料分配列表
	 */
	@Override
	public JsonResult SelectPStoredList(String paramStr) {
		MultiValueMap<String, String> requestEntity = new LinkedMultiValueMap<>();
		// 把参数转换成json对象
		JSONObject paraMaps = JSONObject.parseObject(paramStr);
		// 分页查寻，判断limit是否传参
		if (!paraMaps.containsKey("limit")) {
			return JsonResult.error(201, "limit参数有误");
		}
		// 分页查寻，判断page是否传参
		if (!paraMaps.containsKey("page")) {
			return JsonResult.error(201, "page参数有误");
		}
		// 货主id
		if (StringUtils.isEmpty(paraMaps.getString("shipperId"))) {
			return JsonResult.error(201, "货主id不能为空");
		}
		requestEntity.add("limit", paraMaps.getString("limit"));
		requestEntity.add("page", paraMaps.getString("page"));
		requestEntity.add("shipperId", paraMaps.getString("shipperId"));
		try {
			ResponseEntity<String> pStoredRecords = restTemplate.postForEntity(
					UrlContants.PLATFORM+"pStoredRecords/getPSoredList", requestEntity, String.class);
			int code = pStoredRecords.getStatusCodeValue();
			JSONObject body = JSONObject.parseObject(pStoredRecords.getBody());
			JsonResult jsonResult = JSONObject.toJavaObject(body, JsonResult.class);
			if (code != 200) { // 判断链接基础数据请求返回结果是正常
				return JsonResult.error(207, "基础数据服务错误");
			}

			if (body.getInteger("code") != 200) {
				return jsonResult;
			}
			if (jsonResult.getData() == null) {
				return jsonResult;
			}

			requestEntity.clear();
			List<JSONObject> list = (List<JSONObject>) jsonResult.getData();
			List<PStoredRecords> pstoredRecordsLsit = new ArrayList<PStoredRecords>();
			for (JSONObject params : list) {
				PStoredRecords param = JSONObject.toJavaObject(params, PStoredRecords.class);
				String ownerId = param.getOwnerId();
				// 运单金额
				Long actualFreight = param.getActualFreight();
				// 储值总金额
				Double storedTotalSum = param.getStoredTotalSum();
				// 加油费比例
				Double oilScale = Double.parseDouble(param.getOilScale());
				// 加气费比例
				Double gasScale = Double.parseDouble(param.getGasScale());
				// ETC费比例
				Double etcScale = Double.parseDouble(param.getEtcScale());
			
				
				int StoredTypeNum = 0;
				if (oilScale > 0) {
					StoredTypeNum += 1;
				}

				if (gasScale > 0) {
					StoredTypeNum += 1;
				}
				if (etcScale > 0) {
					StoredTypeNum += 1;
				}
				// 存储储值类型数
				param.setStoredTypeNum(StoredTypeNum);
				// 计算储值总金额
				storedTotalSum = (oilScale + gasScale + etcScale) * actualFreight;
				// 存储储值总金额
				param.setStoredTotalSum(storedTotalSum);
				requestEntity.clear();
				requestEntity.add("id", ownerId);
				ResponseEntity<String> memberInfo = restTemplate.postForEntity(
						UrlContants.MEMBER+"mMember/getMMemberById", requestEntity, String.class);
				int memberCode = memberInfo.getStatusCodeValue();
				JSONObject memberBody = JSONObject.parseObject(memberInfo.getBody());
				JSONObject MemberData = JSONObject.parseObject(memberBody.getString("data"));
				if (memberCode == 200) {
					if (MemberData != null) {
						// 封装车辆参数
						// 车主电话
						param.setOwnerTelephone(MemberData.getString("telephone"));
						// 车主名称
						param.setOwnerName(MemberData.getString("realName"));
					}
				}
				requestEntity.clear();
				requestEntity.add("id", param.getCarId());
				ResponseEntity<String> carInfo = restTemplate
						.postForEntity(UrlContants.AUTH+"car/getCarById", requestEntity, String.class);
				int carCode = carInfo.getStatusCodeValue();
				JSONObject carBody = JSONObject.parseObject(carInfo.getBody());
				JSONObject carData = JSONObject.parseObject(carBody.getString("data"));
				if (carCode == 200) {
					if (carData != null) {
						// 车牌号
						param.setCarNum(carData.getString("carNumber"));
					}
				}
				pstoredRecordsLsit.add(param);
			}
			jsonResult.setData(pstoredRecordsLsit);
			return jsonResult;
		} catch (RestClientException e) {
			return JsonResult.error(500, "服务器错误");

		}
	}
	/**
	 * 生产资料分配记录列表导出
	 */
	@Override
	public JsonResult exportPStoreds(String paramStr) {
		Map<String, String> maps = (Map) JSON.parse(paramStr);
		MultiValueMap<String, String> requestEntity = new LinkedMultiValueMap<>();
		// 把参数转换成json对象
		JSONObject paraMaps = JSONObject.parseObject(paramStr);
		// 分页查寻，判断limit是否传参
		if (!paraMaps.containsKey("limit")) {
			return JsonResult.error(201, "limit参数有误");
		}
		// 分页查寻，判断page是否传参
		if (!paraMaps.containsKey("page")) {
			return JsonResult.error(201, "page参数有误");
		}
		// 货主id
		if (StringUtils.isEmpty(paraMaps.getString("shipperId"))) {
			return JsonResult.error(201, "货主id不能为空");
		}
		requestEntity.add("limit", paraMaps.getString("limit"));
		requestEntity.add("page", paraMaps.getString("page"));
		requestEntity.add("shipperId", paraMaps.getString("shipperId"));

		JsonResult f = restTemplate.postForObject(UrlContants.PLATFORM+"pStoredRecords/getPSoredList",
				requestEntity, JsonResult.class);
		List<Map<String, Object>> waybillList = (List<Map<String, Object>>) f.getData();
		for (Map<String, Object> map : waybillList) {
			// 运单金额
		    Long actualFreight =  Long.parseLong(map.get("actualFreight").toString());
			// 储值总金额
			Double storedTotalSum=0.0;
			// 加油费比例
			Double oilScale = Double.parseDouble(map.get("gasScale").toString());
			
			// 加气费比例
			Double gasScale = Double.parseDouble(map.get("gasScale").toString());
			// ETC费比例
			Double etcScale =  Double.parseDouble(map.get("etcScale").toString());
			int StoredTypeNum = 0;
			if (oilScale > 0) {
				StoredTypeNum += 1;
			}

			if (gasScale > 0) {
				StoredTypeNum += 1;
			}
			if (etcScale > 0) {
				StoredTypeNum += 1;
			}
			// 存储储值类型数
			map.put("StoredTypeNum", StoredTypeNum);
			// 计算储值总金额
			storedTotalSum = (oilScale + gasScale + etcScale) * actualFreight;
			// 存储储值总金额
			map.put("storedTotalSum", storedTotalSum);
			
			requestEntity.clear();
			requestEntity.add("id", (String) map.get("OwnerId"));
			ResponseEntity<String> memberInfo = restTemplate.postForEntity(
					UrlContants.MEMBER+"mMember/getMMemberById", requestEntity, String.class);
			int memberCode = memberInfo.getStatusCodeValue();
			JSONObject memberBody = JSONObject.parseObject(memberInfo.getBody());
			JSONObject MemberData = JSONObject.parseObject(memberBody.getString("data"));
			if (memberCode == 200) {
				if (MemberData != null) {
					// 封装车辆参数
					// 车主电话
					map.put("telephone", MemberData.getString("telephone"));
					// 车主名称
					map.put("realName", MemberData.getString("realName"));
				}
			}
			requestEntity.clear();
			requestEntity.add("id", (String) map.get("carId"));
			JsonResult car = restTemplate.postForObject(UrlContants.AUTH+"car/getCarById", requestEntity,
					JsonResult.class);
			Map<String, Object> carMap = (Map<String, Object>) car.getData();
			if (carMap != null) {
				map.put("carNumber", carMap.get("carNumber"));
			}

		}
		// 导出文件头列表
		List<String> titleList = new ArrayList<>();
		titleList.add("运单编号");
		titleList.add("车主电话");
		titleList.add("车牌号");
		titleList.add("储值类型数");
		titleList.add("总储值金额");
		titleList.add("运费(元)");
		titleList.add("车辆类型");
		titleList.add("储值时间");

		List<Map<String, Object>> list = new ArrayList<>();
		for (Map<String, Object> map : waybillList) {
			// 车主姓名/车主电话号查询筛选
			if (maps != null && maps.get("ownerName") != null && !"".equals(maps.get("ownerName"))) {
				if (!map.get("ownerName").equals(maps.get("ownerName"))) {
					continue;
				}
			}
			if (maps != null && maps.get("ownerPhon") != null && !"".equals(maps.get("ownerPhon"))) {
				if (!map.get("ownerPhon").equals(maps.get("ownerPhon"))) {
					continue;
				}
			}
			Map<String, Object> storedMap = new HashMap<>();
			for (String mapKey : map.keySet()) {
				if (mapKey.equals("waybillNumber")) {
					storedMap.put("运单编号", map.get(mapKey));
				}
				if (mapKey.equals("ownerPhon")) {
					storedMap.put("车主电话", map.get(mapKey));
				}
				if (mapKey.equals("carNumber")) {
					storedMap.put("车牌号", map.get(mapKey));
				}
				if (mapKey.equals("StoredTypeNum")) {
					storedMap.put("储值类型数", map.get(mapKey));
				}

				if (mapKey.equals("storedTotalSum")) {
					storedMap.put("储值总金额", map.get(mapKey));
				}
				if (mapKey.equals("actualFreight")) {
					storedMap.put("运费(元)", map.get(mapKey));
				}
				if (mapKey.equals("Subordinate")) {
					storedMap.put("车辆类型", map.get(mapKey));
				}
				if (mapKey.equals("createTime")) {
					storedMap.put("储值时间", map.get(mapKey));
				}
				

			}
			list.add(storedMap);

		}
		try {
			ExcelUtils.export("货运单列表", titleList, list);
			return JsonResult.success();
		} catch (Exception e) {
			e.printStackTrace();
			return JsonResult.error(207,"服务器错误");
		}
		

	}

	
}
