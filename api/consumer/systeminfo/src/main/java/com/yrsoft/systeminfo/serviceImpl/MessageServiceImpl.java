package com.yrsoft.systeminfo.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.yrsoft.common.constant.Constants;
import com.yrsoft.common.constant.UrlContants;
import com.yrsoft.common.utils.JsonResult;
import com.yrsoft.systeminfo.service.MessageService;

@Service
public class MessageServiceImpl implements MessageService {
	@Autowired
	private RestTemplate template;
	
	@Override
	public JsonResult unReadMessageCount(String shipperId) {
		MultiValueMap<String, String> requestEntity = new LinkedMultiValueMap<>();
		requestEntity.set("shipperId", shipperId);
		JsonResult reseult = template.postForObject(
			UrlContants.WEBSITE+"wNews/count",
		    requestEntity,
		    JsonResult.class);
		return reseult;
	}
	
	@Override
	public JsonResult list(Integer page, Integer limit, String shipperId,String createTime) {
		MultiValueMap<String, String> requestEntity = new LinkedMultiValueMap<>();
		requestEntity.set("memberId", shipperId);
		requestEntity.set("page", String.valueOf(page));
		requestEntity.set("limit", String.valueOf(limit));
		requestEntity.set("createTime", createTime);
		JsonResult reseult = template.postForObject(
			UrlContants.WEBSITE+"wNews/listByOrder",
		    requestEntity,
		    JsonResult.class);
		return reseult;
	}

	@Override
	public JsonResult updateToRead(String ids) {
		MultiValueMap<String, String> requestEntity = new LinkedMultiValueMap<>();
		requestEntity.set("ids", ids);
		JsonResult reseult = template.postForObject(
				UrlContants.WEBSITE+"wNews/updateToRead",
			    requestEntity,
			    JsonResult.class);
		return reseult;
	}
}
