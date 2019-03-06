package com.yrsoft.delivery.controller;

import javax.ws.rs.core.MediaType;

import org.apache.servicecomb.provider.rest.common.RestSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSONObject;
import com.yrsoft.common.exception.LSJExceptions;
import com.yrsoft.common.exception.NullParamException;
import com.yrsoft.common.utils.JsonResult;
import com.yrsoft.common.utils.StringUtils;
import com.yrsoft.delivery.service.PremiumService;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.CseSpringDemoCodegen", date = "2019-01-29T01:51:08.429Z")

@RestSchema(schemaId = "premium")
@RequestMapping(path = "/api/premium", produces = MediaType.APPLICATION_JSON)
public class PremiumController {

	@Autowired
	private PremiumService premiumService;

	/**
	 * 点击费用说明，查询字典表保险费相关系数
	 * 
	 * @param shipperId
	 * @return JsonResult
	 * @author dwh
	 * @date:19/2/25
	 * 
	 */

	@RequestMapping(value = "/getPremium", produces = { "application/json" }, method = RequestMethod.POST)
	public JsonResult getPremium(String paramStr) {

		if (StringUtils.isEmpty(paramStr)) {
			return JsonResult.success(201, "参数不能为空");
		}
		JSONObject jsonObject = JSONObject.parseObject(paramStr);
		String parentId = jsonObject.getString("parentId");
		String dataType = jsonObject.getString("dataType");
		try {
			return premiumService.getPremium(parentId,dataType);
		} catch (NullParamException nullParamException) {
			return JsonResult.error(201, nullParamException.getMessage());
		} catch (LSJExceptions lsjExceptions) {
			return JsonResult.error(lsjExceptions.getCode(), lsjExceptions.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			return JsonResult.error(500, "[系统异常]");
		}
	}

}
