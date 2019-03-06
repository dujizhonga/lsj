package com.yrsoft.delivery.service;

import com.yrsoft.common.utils.JsonResult;

/**
 * 发货页面货物列表查询接口
 * @author lu
 * @date 2019/03/04 10:23
 */
public interface GoodsInfoService {

	/**
    *
    * 功能描述: 发货页面货物列表查询
    *
    * @param: name 货物名称
    * @return: name 货物名称  id 货物id
    * @auther: lu
    * @date: 2019/03/32
    */
	JsonResult getGoodsInfo(String paramStr);

}
