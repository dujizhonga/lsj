package com.yrsoft.tripartite.controller;

import javax.ws.rs.core.MediaType;

import org.apache.servicecomb.provider.rest.common.RestSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSONObject;
import com.yrsoft.common.utils.JsonResult;
import com.yrsoft.tripartite.service.TruckBrokerService;

/**
 * 无车承运人电子路单,资金流水单发送<p>
 * 
 * @author WANGQI
 * @date 2019年3月1日 下午2:31:24
 */
@RestSchema(schemaId = "truckBrokerController")
@RequestMapping(path = "api/truckBroker", produces = MediaType.APPLICATION_JSON)
public class TruckBrokerController {
	
	@Autowired
	private TruckBrokerService truckBrokerService;
	
	/**
	 * 发送无车承运人电子路单数据<p>
	 * 发送无车承运人资金流水单数据<p>
	 * 
	 * @param waybillIds 
	 * 		       运单ID(以逗号分割的字符串)
	 * @author WANGQI
	 * @date 2019年3月1日 下午2:36:08
	 */
	@RequestMapping(value="send",method=RequestMethod.POST)
	public JsonResult sendWaybillAndFundFlow(String paramStr) {
		if(StringUtils.isEmpty(paramStr)) {
			return JsonResult.success(201, "参数不能为空");
		}
		JSONObject json = JSONObject.parseObject(paramStr);
		String waybillIds = json.getString("waybillIds");
		synchronized (truckBrokerService) {
			return truckBrokerService.send(waybillIds);
		}
	}
}
