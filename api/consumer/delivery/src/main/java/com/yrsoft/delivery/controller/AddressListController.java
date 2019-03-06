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
import com.yrsoft.delivery.service.AddressListService;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.CseSpringDemoCodegen", date = "2019-01-29T01:51:08.429Z")
@RestSchema(schemaId = "addressList")
@RequestMapping(path = "/api/addressList", produces = MediaType.APPLICATION_JSON)
public class AddressListController {
	@Autowired
	private AddressListService addressListService;

	/**
	 * 查詢地址列表
	 * 
	 * @param shipperId
	 * @return JsonResult
	 * @author dwh
	 * @date:19/2/25
	 * 
	 */
	@RequestMapping(value = "/getAddressList", produces = { "application/json" }, method = RequestMethod.POST)
	public JsonResult getAddressList(String paramStr) {
		if (StringUtils.isEmpty(paramStr)) {
			return JsonResult.success(201, "参数不能为空");
		}
		JSONObject jsonObject = JSONObject.parseObject(paramStr);
		
		String addressType = jsonObject.getString("addressType");
		String shipperId = jsonObject.getString("shipperId");
		if (shipperId == null) {
			return JsonResult.success(201, "货主ID不能为空");
		}
		if (addressType == null) {
			return JsonResult.success(201, "收发货类型不能为空");
		}
		Integer page = jsonObject.getInteger("page");
		Integer limit = jsonObject.getInteger("limit");
		if (null == page || null == limit) {
			return JsonResult.success(201, "请传分页参数");
		}
		if (page < 0 || limit < 0) {
			return JsonResult.success(201, "分页参数错误");
		}
		try {
			return addressListService.getAddressList(page, limit, shipperId,addressType);
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
