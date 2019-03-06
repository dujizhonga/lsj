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
import com.yrsoft.delivery.service.CallCarService;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.CseSpringDemoCodegen", date = "2019-01-29T01:51:08.429Z")
@RestSchema(schemaId = "callCar")
@RequestMapping(path = "/api/callCar", produces = MediaType.APPLICATION_JSON)
public class CallCarController {
	@Autowired
	private CallCarService callCarService;
	/**
	 * 点击呼叫车辆按钮
	 * 
	 * @param String paramStr
	 * @return JsonResult
	 * @author dwh
	 * @throws Exception
	 * @date:19/2/27
	 * 
	 */

	@RequestMapping(value = "/call", method = RequestMethod.POST)
	public JsonResult addAssignRecord(String paramStr) throws Exception {
		if (StringUtils.isEmpty(paramStr)) {
			return JsonResult.success(201, "参数不能为空");
		}
		try {
			JSONObject jsonObject = JSONObject.parseObject(paramStr);
			String shipperId = jsonObject.getString("shipperId");
			String id = jsonObject.getString("id");
			if (shipperId == null || shipperId.equals("")) {
				return JsonResult.error(201, "请输入货主id");
			}
			if (id == null || id.equals("")) {
				return JsonResult.error(201, "请输入主键id");
			}
			return callCarService.callCar(id, shipperId);
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
