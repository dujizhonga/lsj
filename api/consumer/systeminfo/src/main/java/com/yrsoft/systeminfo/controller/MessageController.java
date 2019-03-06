package com.yrsoft.systeminfo.controller;

import javax.ws.rs.core.MediaType;

import org.apache.servicecomb.provider.rest.common.RestSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSONObject;
import com.yrsoft.common.utils.JsonResult;
import com.yrsoft.systeminfo.service.MessageService;

/**
 *货运所有消息及通知顶级接口<p>
 * 
 * @author WANGQI
 * @date 2019年2月23日 上午10:55:04
 */
@RestSchema(schemaId = "messageController")
@RequestMapping(path = "api/msg", produces = MediaType.APPLICATION_JSON)
public class MessageController {
	
	@Autowired
	private MessageService messageService;
	
	/**
	 * 查询货主未读的消息数量<p>
	 * 只统计w_news中is_read为1的记录<p>
	 *
	 * @param shipperId
	 * 		      货主ID
	 * @return JsonResult
	 * @author:WANGQI
	 * @date:2019年2月23日 上午11:01:58
	 */
	@RequestMapping(value="/unreadMessageCount",method=RequestMethod.POST)
	public JsonResult unReadMessageCount(String paramStr) {
		if(StringUtils.isEmpty(paramStr)) {
			return JsonResult.success(201, "参数不能为空");
		}
		String shipperId=null;
		try {
			JSONObject jsonObject = JSONObject.parseObject(paramStr);
			shipperId = jsonObject.getString("shipperId");
		} catch (Exception e) {
			e.printStackTrace();
			return JsonResult.success(201, "参数传递错误");
		}
		if(StringUtils.isEmpty(shipperId)) {
			return JsonResult.success(201, "货主ID不能为空");
		}
		return messageService.unReadMessageCount(shipperId);
	}
	
	/**
	 * 查询货主消息列表<p>
	 * is_read ASC,create_time DESC 排序<p>
	 * 
	 * @param page
	 * @param limit
	 * @param shipperId
	 *        货主ID
	 * @return JsonResult
	 * @author WANGQI
	 * @date 2019年2月26日 下午2:51:04
	 */
	@RequestMapping(value="/list",method=RequestMethod.POST)
	public JsonResult msgList(String paramStr) {
		if(StringUtils.isEmpty(paramStr)) {
			return JsonResult.success(201, "参数不能为空");
		}
		String shipperId=null;
		Integer page=null;
		Integer limit=null;
		JSONObject jsonObject = null;
		try {
			jsonObject = JSONObject.parseObject(paramStr);
			shipperId = jsonObject.getString("shipperId");
			page = jsonObject.getInteger("page");
			limit = jsonObject.getInteger("limit");
		} catch (Exception e) {
			e.printStackTrace();
			return JsonResult.success(201, "参数传递错误");
		}
		if(StringUtils.isEmpty(shipperId)) {
			return JsonResult.success(201, "货主ID不能为空");
		}
		if(null == page || null == limit ) {
			return JsonResult.success(201,"请传分页参数");
		}
		if(page<0 || limit < 0) {
			return JsonResult.success(201, "分页参数错误");
		}
		
		String createTime = jsonObject.getString("createTime");
		return messageService.list(page, limit, shipperId,createTime);
	}
	
	/**
	 * 更新未读消息为已读<p>
	 *
	 * @param ids 
	 * 		        消息ID
	 * @return JsonResult
	 * @author WANGQI
	 * @date 2019年2月26日 下午4:33:26
	 */
	@RequestMapping(value="/updateToRead",method=RequestMethod.POST)
	public JsonResult updateToRead(String paramStr) {
		if (StringUtils.isEmpty(paramStr)) {
			return JsonResult.success(201, "参数不能为空");
		}
		String ids=null;
		try {
			JSONObject jsonObject = JSONObject.parseObject(paramStr);
			ids = jsonObject.getString("ids");
		} catch (Exception e) {
			e.printStackTrace();
			return JsonResult.success(201, "参数传递错误");
		}
		if(StringUtils.isEmpty(ids)) {
			JsonResult.success(201, "请传入消息ID");
		}
		return messageService.updateToRead(ids);
	}
	
}
