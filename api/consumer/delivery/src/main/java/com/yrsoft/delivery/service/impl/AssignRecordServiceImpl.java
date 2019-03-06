package com.yrsoft.delivery.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.servicecomb.provider.springmvc.reference.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSONObject;
import com.yrsoft.common.constant.UrlContants;
import com.yrsoft.common.utils.JsonResult;
import com.yrsoft.delivery.service.AssignRecordService;
import com.yrsoft.delivery.vo.SysCarVO;

import cn.hutool.json.JSONUtil;

@Service
public class AssignRecordServiceImpl implements AssignRecordService {
	private static final RestTemplate restTemplate = RestTemplateBuilder.create();

	@Override
	public JsonResult addAssignRecord(String ids, String invoiceId, String shipperId) throws Exception {
		// ids 车辆ID
		// invoiceId 货运单ID
		// shipperId 货主ID
		String[] idArray = ids.split(",");
		for (int i = 0; i < idArray.length; i++) {

			MultiValueMap<String, String> requestEntity = new LinkedMultiValueMap<>();
			requestEntity.add("id", idArray[i]);
			String forObject = restTemplate.postForObject(UrlContants.AUTH + "car/getCarById", requestEntity,
					String.class);
			SysCarVO sysCarDTO = JSONUtil.toBean(forObject, SysCarVO.class);
			List<String> carNum = new ArrayList<>();
			if (null != sysCarDTO.getRunStatus() && sysCarDTO.getRunStatus().equals(2)) {
				String carNumber = sysCarDTO.getCarNumber();
				carNum.set(i, carNumber);
			}
			if (!carNum.isEmpty()) {
				return JsonResult.success("这些车辆在运输中不能发单" + carNum);
			}
			MultiValueMap<String, String> request = new LinkedMultiValueMap<>();
			request.add("id", UUID.randomUUID().toString().replace("-", ""));
			request.add("invoiceId", invoiceId);
			request.add("carId", idArray[i]);
			request.add("waybillType", "0");
			Long time = new Date().getTime() / 1000;
			request.add("createTime", time.intValue() + "");
			ResponseEntity<String> resultStr = restTemplate.postForEntity(UrlContants.PLATFORM + "pAssignRecord/add",
					request, String.class);

			JSONObject jb = JSONObject.parseObject(resultStr.getBody());
			String code = jb.get("code").toString();
			if (code.equals("200")) {
				continue;
			} else {
				throw new RuntimeException("生成分派记录失败");
			}
		}
		return JsonResult.success(200, "生成分派记录成功");
	}
}


