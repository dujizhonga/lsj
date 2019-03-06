package com.yrsoft.delivery.controller;

import javax.ws.rs.core.MediaType;

import org.apache.servicecomb.provider.rest.common.RestSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSONObject;
import com.yrsoft.common.utils.JsonResult;
import com.yrsoft.common.utils.StringUtils;
import com.yrsoft.delivery.service.AssignRecordService;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.CseSpringDemoCodegen", date = "2019-01-29T01:51:08.429Z")
@RestSchema(schemaId = "assignRecordAdd")
@RequestMapping(path = "/api/assignRecordAdd", produces = MediaType.APPLICATION_JSON)
public class AssignRecordController {
	@Autowired
	private AssignRecordService assignRecordService;

	/**
	 * 新增分派记录
	 * 
	 * @param shipperIds
	 * @return JsonResult
	 * @author dwh
	 * @throws Exception
	 * @date:19/2/25
	 * 
	 */

	@RequestMapping(value = "/addAssignRecord", method = RequestMethod.POST)
	public JsonResult addAssignRecord(String paramStr) throws Exception {
		if (StringUtils.isEmpty(paramStr)) {
			return JsonResult.success(201, "参数不能为空");
		}
		JSONObject jsonObject = JSONObject.parseObject(paramStr);
		String invoiceId = jsonObject.getString("invoiceId");
		String ids = jsonObject.getString("ids");
		String shipperId=jsonObject.getString("shipperId");
		if (invoiceId == null) {
			return JsonResult.success(201, "货运单ID不能为空");
		}
		if (ids == null) {
			return JsonResult.success(201, "指派车辆ids不能为空");
		}
		if (shipperId == null) {
			return JsonResult.success(201, "货主ID不能为空");
		}
		try {
			return assignRecordService.addAssignRecord(ids, invoiceId,shipperId);
		} catch (Exception e) {
			e.printStackTrace();
			return JsonResult.error(207, "服务器错误");
		}

	}

}
