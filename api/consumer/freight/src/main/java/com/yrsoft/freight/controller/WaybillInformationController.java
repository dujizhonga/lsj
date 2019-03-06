package com.yrsoft.freight.controller;

import javax.ws.rs.core.MediaType;

import org.apache.servicecomb.provider.rest.common.RestSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSONObject;
import com.yrsoft.common.utils.JsonResult;
import com.yrsoft.common.utils.ParamVC;
import com.yrsoft.freight.service.WaybillInformationService;

@RestSchema(schemaId = "waybillInformation")
@RequestMapping(path = "/api/waybillInformation", produces = MediaType.APPLICATION_JSON)
public class WaybillInformationController {
	
	@Autowired
	WaybillInformationService waybillInformationService;
	
	/**
	 * 查寻分页查找运单信息
	 * @param paraMap
	 * @return:JsonResult
	 * @author:DU'JZ
	 * @data:2019年2月23日 下午2:05:23 
	 * @throws
	 */
	@RequestMapping(value="/selectWaybillInformationList",method=RequestMethod.POST)
	public JsonResult selectWaybillInformationList(String paraMap) {
		
		return waybillInformationService.selectWaybillInformationByPage(paraMap);
	}
	
	/**
	 * 不分页查寻运单信息
	 * @param paraMap
	 * @return:JsonResult
	 * @author:DU'JZ
	 * @data:2019年2月28日 上午9:05:21 
	 * @throws
	 */
	@RequestMapping(value="/selectWaybillInformation",method=RequestMethod.POST)
	public JsonResult selectWaybillInformation(String paraMap) {
		
		return waybillInformationService.selectWaybillInformation(paraMap);
	}
	
	/**
	 * 对运单进行评价
	 * @param: @param paraMap
	 * @param: @return
	 * @return: JsonResult
	 * @auther: shihh
	 * @date: 2019年2月25日下午6:01:32
	 */
	@RequestMapping(value = "/addComments",method = RequestMethod.POST)
	public JsonResult addComments(String paramStr) {
		
		return waybillInformationService.addComments(paramStr);
	}
	/**
	 * 根据货主id查询所有运单
	 * @param: @param paraMap
	 * @param: @return
	 * @return: JsonResult
	 * @auther: shihh
	 * @date: 2019年2月26日下午2:24:17
	 */
	/*@RequestMapping(value = "/selectWaybillByShipperId",method = RequestMethod.POST)
	public JsonResult selectWaybillByShipperId(String paramStr) {
		
		return waybillInformationService.selectWaybillByShipperId(paramStr);
	}*/
	/**
	 * 运单列表双击显示货运单详情
	 * @param: @param paraMap
	 * @param: @return
	 * @return: JsonResult
	 * @auther: shihh
	 * @date: 2019年2月26日下午5:30:30
	 */
/*	@RequestMapping(value = "/selectPinvoiceById",method = RequestMethod.POST)
	public JsonResult selectWaybillById(String paramStr) {
		
		return waybillInformationService.selectPinvoiceById(paramStr);
	}
	*/
	/**
	 * 支付完保险费修改货运单信息<p>
	 * 修改货运单信息(保险费支付ID,保险费支付状态)<p>
	 * 根据保险费支付记录获得货运单支付状态<p>
	 * 
	 * @param paramStr
	 * 		      <p>waybillIds 运单ID(以逗号分隔)
	 * 		      <p>insuranceId 险费支付ID(单个的字符串)
	 * @return JsonResult
	 * @author WANGQI
	 * @date 2019年2月28日 下午5:32:45
	 */
	@RequestMapping(value = "/updateWaybillForInsurance",method = RequestMethod.POST)
	public JsonResult updateWaybillForInsurance(String paramStr) {
		//参数验证
        ParamVC pvc = ParamVC.jsonValidateAndConvert(paramStr,"waybillIds","insuranceId");
        if(!pvc.isLegal()){
            return JsonResult.error(201,pvc.getMessage());
        }
        JSONObject jsonObject = JSONObject.parseObject(paramStr);
        String waybillIds = jsonObject.getString("waybillIds"),
               insuranceId = jsonObject.getString("insuranceId");
        return waybillInformationService.updateWaybillForInsurance(waybillIds, insuranceId);
	}
}
