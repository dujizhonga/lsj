package com.yrsoft.pay.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.yrsoft.common.constant.UrlContants;
import com.yrsoft.common.utils.JsonResult;
import com.yrsoft.pay.service.TranscationQueryService;

@Service
public class TranscationQueryImpl implements TranscationQueryService {
	@Autowired
	private RestTemplate template;

	@Override
	public JsonResult selectRechargeList(Integer page,Integer limit,String memberId) {
		MultiValueMap<String, String> requestEntity = new LinkedMultiValueMap<>();
		requestEntity.set("page", String.valueOf(page));
		requestEntity.set("limit", String.valueOf(limit));
		requestEntity.set("memberId", memberId);
		JsonResult reseult = template.postForObject(
			UrlContants.FINANCE+"mRecharge/list",
			requestEntity,
		    JsonResult.class);
		return reseult;
	}

	@Override
	public JsonResult selectPayList(Integer page,Integer limit,String memberId) {
		MultiValueMap<String, String> requestEntity = new LinkedMultiValueMap<>();
		requestEntity.set("page", String.valueOf(page));
		requestEntity.set("limit", String.valueOf(limit));
		requestEntity.set("memberId", memberId);
		requestEntity.set("payState",String.valueOf(1));
		JsonResult reseult = template.postForObject(
				UrlContants.FINANCE+"mPayLog/list",
				requestEntity,
			    JsonResult.class);
		return reseult;
	}
	
}
