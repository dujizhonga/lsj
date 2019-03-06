package com.yrsoft.freight.service;

import com.yrsoft.common.utils.JsonResult;
import com.yrsoft.freight.entity.WayBill;


/**
 *
 * 功能描述: 方法注释
 *
 * @param:
 * @return: 
 * @auther: Guohaolong
 * @date: 2019年2月25日 下午5:53:42
 */
public interface WayBillService {
	public JsonResult selectByPage(Integer page,Integer limit,WayBill wayBill);
	public JsonResult queryById(String parmStr);
}
