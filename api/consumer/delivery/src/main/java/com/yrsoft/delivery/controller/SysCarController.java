package com.yrsoft.delivery.controller;

import javax.ws.rs.core.MediaType;

import org.apache.servicecomb.provider.rest.common.RestSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSONObject;
import com.yrsoft.common.exception.NullParamException;
import com.yrsoft.common.utils.JsonResult;
import com.yrsoft.common.utils.StringUtils;
import com.yrsoft.delivery.service.CarService;

/**
 * 
 * @author party
 *
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.CseSpringDemoCodegen", date = "2019-01-29T01:51:08.429Z")
@RestSchema(schemaId = "sysCar")
@RequestMapping(path = "/api/sysCar", produces = MediaType.APPLICATION_JSON)
public class SysCarController {
	@Autowired
	private CarService carService;

	/**
	 * 指定范围内系统车位置及基本信息查询
	 * 
	 * @return JsonResult
	 * @author dwh
	 * @throws Exception
	 * @date:19/2/25
	 * 
	 */

	@RequestMapping(value = "/getSysCar", method = RequestMethod.POST)
	public JsonResult addAssignRecord(String paramStr) throws Exception {

		try {
			if (StringUtils.isEmpty(paramStr)) {
				return JsonResult.success(201, "参数不能为空");
			}
			JSONObject jsonObject = JSONObject.parseObject(paramStr);

			String shipperId = jsonObject.getString("shipperId");
			if (StringUtils.isEmpty(shipperId)) {
				return JsonResult.success(201, "shipperId不能为空");
			}
			return carService.getSysCar(shipperId);
		} catch (NullParamException n) {
			return JsonResult.error(n.getCode(), n.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			return JsonResult.error(500, "[系统错误]");
		}
	}

}
