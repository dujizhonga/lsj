package com.yrsoft.common.utils;

import com.alibaba.fastjson.JSON;

import com.alibaba.fastjson.serializer.SerializerFeature;

import com.github.pagehelper.PageInfo;
import com.yrsoft.common.config.Global;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JsonResult {


	private int code;
	private String message;
	private Object data;
	private int totalPage;
	private int pageNum;
	private int pageSize;
	private long rowCount;

	public int getCode() {
		return code;
	}

	public JsonResult setCode(int code) {
		this.code = code;
		return this;
	}

	public String getMessage() {
		return message;
	}

	public JsonResult setMessage(String message) {
		this.message = message;
		return this;
	}

	public Object getData() {
		return data;
	}

	public JsonResult setData(Object data) {
		this.data = data;
		return this;
	}



	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public long getRowCount() {
		return rowCount;
	}

	public void setRowCount(long rowCount) {
		this.rowCount = rowCount;
	}

	/**
	 * 成功200
	 * 
	 * @return
	 */
	public static JsonResult success() {
		return new JsonResult().setCode(200).setMessage("success");
	}

	public static JsonResult success(Object data) {

		if (Global.getResponseAES()){
			data = AES.JM(JSON.toJSONString(data, SerializerFeature.WriteMapNullValue));
		}

		return success().setCode(200).setMessage("success").setData(
				data
		);
	}
	   public static JsonResult createResponse(int code, String message, Object data) {
	        JsonResult jor = new JsonResult();
	        jor.code = code;
	        jor.message = message;
			//对data进行加密
			jor.data = data;
	        return jor;
	    }

	public static JsonResult success(int code,String message) {
		return new JsonResult().setCode(code).setMessage(message);
	}
	
	/**
	 * 失败1
	 * 
	 * @param message
	 * @return
	 */
	public static JsonResult error(int code,String message) {
		return new JsonResult().setCode(code).setMessage(message);
	}

	/**
	 * 提示信息0
	 *
	 * @return
	 */
	public static JsonResult tipInfo() {
		return new JsonResult().setCode(0).setMessage("other");
	}

	// 分页
	public static JsonResult createJsonResponse(PageInfo<?> pageInfo) {
		JsonResult jor = new JsonResult();
		jor.code = 200;
		jor.message = "success";
		if (pageInfo != null) {
			jor.data = pageInfo;
			if (Global.getResponseAES()){
				jor.data = AES.JM(JSON.toJSONString(pageInfo.getList(), SerializerFeature.WriteMapNullValue));
			}else {
				jor.data = pageInfo.getList();
			}
			jor.pageNum = pageInfo.getPageNum();
			jor.pageSize = pageInfo.getPageSize();
			jor.rowCount = pageInfo.getTotal();
			jor.totalPage = pageInfo.getPages();
		}
		return jor;
	}

	public static JsonResult createJsonResponse(List<?> list) {
		JsonResult jor = new JsonResult();
		jor.code = 200;
		jor.message = "success";
		jor.data = list;
		if (Global.getResponseAES()){
			jor.data = AES.JM(JSON.toJSONString(list, SerializerFeature.WriteMapNullValue));
		}else {
			jor.data = list;
		}
		return jor;
	}

	@Override
	public String toString() {
		return "JsonResult{" +
				"code=" + code +
				", message='" + message + '\'' +
				", data=" + data +
				", totalPage=" + totalPage +
				", pageNum=" + pageNum +
				", pageSize=" + pageSize +
				", rowCount=" + rowCount +
				'}';
	}
}
