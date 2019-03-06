package com.yrsoft.delivery.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.servicecomb.provider.springmvc.reference.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.yrsoft.common.constant.UrlContants;
import com.yrsoft.common.utils.JPushUtli;
import com.yrsoft.common.utils.JsonResult;
import com.yrsoft.delivery.dto.AssignReDTO;
import com.yrsoft.delivery.dto.PInvoiceDTO;
import com.yrsoft.delivery.dto.SCarDTO;
import com.yrsoft.delivery.service.CallCarService;

import cn.hutool.json.JSONUtil;
@Service
public class CallCarServiceImpl implements CallCarService{
	
	private static RestTemplate restTemplate = RestTemplateBuilder.create();
	/**
	 * 功能描述: 呼叫车辆
	 * 
	 * @param id
	 * @param shipperId
	 * @return
	 */
	@Override
	public JsonResult callCar(String id, String shipperId) {
		MultiValueMap<String, String> requestEntity = new LinkedMultiValueMap<>();
		// 货运单主键ID
		if (null != id) {
			requestEntity.add("id", id);
		}
		String Object = restTemplate.postForObject(UrlContants.PLATFORM + "pInvoice/getPInvoiceById", requestEntity,
				String.class);
		PInvoiceDTO pDTO = JSONUtil.toBean(Object, PInvoiceDTO.class);
		Integer flag = pDTO.getData().getFlag();
		// 实际响应指派车辆数
		Integer acAssain = pDTO.getData().getActualAssignNum();
		// 实际响应系统车辆数
		Integer acApply = pDTO.getData().getActualApplyNum();
		// 申请车辆数
		Integer apply_car_no = pDTO.getData().getApplyCarNo();
		// 指派车辆数
		Integer assign_car_no = pDTO.getData().getAssignCarNo();
		// 呼叫车辆次数
		Integer number_call = pDTO.getData().getNumberCall();
		if (number_call == 0) {
			return JsonResult.error(777, "呼叫三次不能再呼叫");
		}
		MultiValueMap<String, String> request = new LinkedMultiValueMap<>();
		Integer ii = number_call - 1;
		request.add("numberCall", ii.toString());
		Long time = new Date().getTime() / 1000;
		request.add("callTime", time.intValue() + "");
		String O = restTemplate.postForObject(UrlContants.PLATFORM + "pInvoice/edit", request, String.class);
		// 给未响应指派单车辆推送弹窗
		MultiValueMap<String, String> reQuest = new LinkedMultiValueMap<>();
		reQuest.add("shipperId", id);
		Integer i = 0;
		reQuest.add("isReceipt", i.toString());

		String Obj = restTemplate.postForObject(UrlContants.PLATFORM + "pAssignRecord/list", reQuest, String.class);
		AssignReDTO aTO = JSONUtil.toBean(Obj, AssignReDTO.class);
		for (int zi = 0; zi < aTO.getData().size(); zi++) {
			//未响应的车辆ID
			String car_id = aTO.getData().get(zi).getCarId();
			MultiValueMap<String, String> car_Quest = new LinkedMultiValueMap<>();
			car_Quest.add("id", car_id);
			//未响应的车辆信息
			String carj = restTemplate.postForObject(UrlContants.PLATFORM + "pAssignRecord/getPAssignRecordById",
					car_Quest, String.class);
			SCarDTO car_mem = JSONUtil.toBean(carj, SCarDTO.class);
			Map<String, String> param = new HashMap<>();
			param.put("urlType", "2");
			//未响应的车主ID
			String alias = car_mem.getData().getMemberId().toString();
			JPushUtli.sendToAllC(JPushUtli.NEW_ORDER_TITLE, JPushUtli.NEW_ORDER_CONECT, param, alias);
		}
//		// 指派单
//		if (flag.equals(1)) {
//
//			// 给未响应指派单车辆推送弹窗
//			MultiValueMap<String, String> reQuest = new LinkedMultiValueMap<>();
//			reQuest.add("shipperId", id);
//			Integer i = 0;
//			reQuest.add("isReceipt", i.toString());

//			String Obj = restTemplate.postForObject(UrlContants.PLATFORM + "pAssignRecord/list", reQuest, String.class);
//			AssignReDTO aTO = JSONUtil.toBean(Obj, AssignReDTO.class);
//			for (int zi = 0; zi < aTO.getData().size(); zi++) {
//				String alias = "ww";
//				Map<String, String> param = new HashMap<>();
//				param.put("id", aTO.getData().get(zi).getCarId());
//				param.put("urlType", "2");
//				JPushUtli.sendToAllC(JPushUtli.NEW_ORDER_TITLE, JPushUtli.NEW_ORDER_CONECT, param, alias);
//			}
//			if (null != aTO) {
//				return JsonResult.success(aTO);
//			}
//			// 系统单
//		} else if (flag.equals(2)) {
//			// 用户点击申请车辆后没有车辆响应或响应车辆数不足，用户点击呼叫车辆该条信息继续发送到后台，运力部门进行分配；
//			// （用户点击申请车辆后有响应车辆但是不足，呼叫车辆数为申请车辆数减去已响应车辆数）；
//			Integer callNum = apply_car_no - acApply;
//			if (callNum > 0) {
//				AssignRecordVO a = new AssignRecordVO();
//				a.setCallCarNum(callNum);
//				return JsonResult.success(a);
//			}
//			// 混合单
//		} else if (flag.equals(3)) {
//			// 系统单与指派单并存：呼叫车辆不但推送指派单未响应车辆，还需基于申请车辆数推送至后台运力；（呼叫车辆数为申请车辆数减去已响应车辆数（系统单））
//			// 呼叫后并提示；
//
//			MultiValueMap<String, String> reQuest = new LinkedMultiValueMap<>();
//			reQuest.add("shipperId", id);
//			Integer i = 0;
//			reQuest.add("isReceipt", i.toString());
//			String Obj = restTemplate.postForObject(UrlContants.PLATFORM + "pAssignRecord/list", reQuest, String.class);
//			AssignReDTO aTO = JSONUtil.toBean(Obj, AssignReDTO.class);
//			Integer callNum = apply_car_no - acApply;
//			if (callNum > 0) {
//				return JsonResult.success(callNum);
//			}
//			if (null != aTO) {
//				return JsonResult.success(aTO);
//			}
//		}
		return JsonResult.success();
	}

}
