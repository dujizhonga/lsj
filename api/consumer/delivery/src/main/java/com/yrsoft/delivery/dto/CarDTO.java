package com.yrsoft.delivery.dto;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.yrsoft.delivery.entity.Car;
import com.yrsoft.delivery.vo.CarInfoVO;



public class CarDTO extends BaseDTO{
	
	private String data;

	public   String getData() {
		return data;
	}

	public void setData( String data) {
		this.data = data;
	}
	
	
	public static List<Car> getWaybill(String data){
		JSONObject jsonObject = JSONObject.parseObject(data);
        String str=jsonObject.get("list").toString();
        List<Car> carList = JSONObject.parseArray(str,Car.class);    
		return carList;	       
	}
	
	
	public static PageInfo<CarInfoVO> getPage(String data){
		PageInfo<CarInfoVO> pageInfo=new PageInfo<>();
		JSONObject jsonObject = JSONObject.parseObject(data);
        pageInfo.setPageSize(Integer.valueOf(jsonObject.get("pageSize").toString()));
        pageInfo.setPageNum(Integer.valueOf(jsonObject.get("pageNum").toString()));
        pageInfo.setTotal(Integer.valueOf(jsonObject.get("total").toString()));
        pageInfo.setPages(Integer.valueOf(jsonObject.get("pages").toString()));
		return pageInfo;	       
	}
	
	
	
	



}
