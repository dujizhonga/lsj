package com.yrsoft.delivery.service.impl;

import org.apache.servicecomb.provider.springmvc.reference.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.yrsoft.common.constant.UrlContants;
import com.yrsoft.common.utils.JsonResult;
import com.yrsoft.delivery.service.PremiumService;

@Service
public class PremiumServiceImpl implements PremiumService {
	private static final RestTemplate restTemplate = RestTemplateBuilder.create();
	@Override
	public JsonResult getPremium(String parentId, String dataType) {
		MultiValueMap<String, String> requestEntity = new LinkedMultiValueMap<>();
		if (parentId != null) {
			requestEntity.set("parentId", parentId);
		}
		if (dataType != null) {
			requestEntity.set("dataType", dataType);
		}
		JsonResult reseult = restTemplate.postForObject(UrlContants.SYSYTEM + "sData/list", requestEntity,
				JsonResult.class);
		return reseult;
	}

}
