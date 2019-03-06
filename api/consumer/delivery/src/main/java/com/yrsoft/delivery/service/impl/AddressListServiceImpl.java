package com.yrsoft.delivery.service.impl;

import org.apache.servicecomb.provider.springmvc.reference.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.yrsoft.common.constant.UrlContants;
import com.yrsoft.common.utils.JsonResult;
import com.yrsoft.delivery.service.AddressListService;

@Service
public class AddressListServiceImpl implements AddressListService {
	private static final RestTemplate restTemplate = RestTemplateBuilder.create();

	@Override
	public JsonResult getAddressList(Integer page, Integer limit, String shipperId,String addressType) {
		MultiValueMap<String, String> requestEntity = new LinkedMultiValueMap<>();
		if (shipperId != null) {
			requestEntity.set("shipperId", shipperId);
		}
		requestEntity.set("addressType", addressType);
		requestEntity.set("page", String.valueOf(page));
		requestEntity.set("limit", String.valueOf(limit));

		// JsonResult reseult = restTemplate.postForObject(Constants.URL_PREFIX
		// +"pShippingAddress/list", requestEntity,
		// JsonResult.class);
		JsonResult reseult = restTemplate.postForObject(UrlContants.PLATFORM + "pShippingAddress/list", requestEntity,
				JsonResult.class);
		return reseult;
	}

}
