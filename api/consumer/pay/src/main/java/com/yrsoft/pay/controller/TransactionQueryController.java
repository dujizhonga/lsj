package com.yrsoft.pay.controller;

import javax.ws.rs.core.MediaType;

import org.apache.servicecomb.provider.rest.common.RestSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSONObject;
import com.yrsoft.common.utils.JsonResult;
import com.yrsoft.pay.service.TranscationQueryService;

/**
 * 交易记录查询<p>
 * 
 * @author WANGQI
 * @date 2019年2月25日 上午9:15:50
 */

@RestSchema(schemaId = "transactionQueryController")
@RequestMapping(path = "api/tsQuery", produces = MediaType.APPLICATION_JSON)
public class TransactionQueryController {
	@Autowired
	private TranscationQueryService transcationQueryService;
	
	/**
	 * 查询货主的充值记录<p>
	 *
	 * @param paramStr
	 * @return JsonResult
	 * @author:WANGQI
	 * @date:2019年2月25日 下午4:36:35
	 */
	@RequestMapping(value="/rechargeList",method=RequestMethod.POST)
	public JsonResult selectRechargeList(String paramStr) {
		if(StringUtils.isEmpty(paramStr)) {
			return JsonResult.success(201, "参数不能为空");
		}
		String memberId=null;
		Integer page=null;
		Integer limit=null;
		try {
			JSONObject jsonObject = JSONObject.parseObject(paramStr);
			memberId = jsonObject.getString("memberId");
			page = jsonObject.getInteger("page");
			limit = jsonObject.getInteger("limit");
		} catch (Exception e) {
			e.printStackTrace();
			return JsonResult.success(201, "参数传递错误");
		}
		if(StringUtils.isEmpty(memberId)) {
			return JsonResult.success(201, "用户ID不能为空");
		}
		if(null == page || null == limit ) {
			return JsonResult.success(201,"请传分页参数");
		}
		if(page<0 || limit < 0) {
			return JsonResult.success(201, "分页参数错误");
		}
		return transcationQueryService.selectRechargeList(page, limit, memberId);
	}

	
	/**
	 * 查询货主的支付记录<p>
	 *
	 * @param paramStr
	 * @return JsonResult
	 * @author:WANGQI
	 * @date:2019年2月25日 下午4:37:13
	 */
	@RequestMapping(value = "/payList",method = RequestMethod.POST)
	public JsonResult selectPayList(String paramStr){
		if(StringUtils.isEmpty(paramStr)) {
			return JsonResult.success(201, "参数不能为空");
		}
		String memberId=null;
		Integer page=null;
		Integer limit=null;
		try {
			JSONObject jsonObject = JSONObject.parseObject(paramStr);
			memberId = jsonObject.getString("memberId");
			page = jsonObject.getInteger("page");
			limit = jsonObject.getInteger("limit");
		} catch (Exception e) {
			e.printStackTrace();
			return JsonResult.success(201, "参数传递错误");
		}
		if(StringUtils.isEmpty(memberId)) {
			return JsonResult.success(201, "用户ID不能为空");
		}
		if(null == page || null == limit ) {
			return JsonResult.success(201,"请传分页参数");
		}
		if(page<0 || limit < 0) {
			return JsonResult.success(201, "分页参数错误");
		}
		return transcationQueryService.selectPayList(page, limit, memberId);
    }
	
}
