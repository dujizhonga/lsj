package com.yrsoft.delivery.service;

import com.yrsoft.common.utils.JsonResult;
/**
 * 查询保险费用
 * @author dwh
 * @date 2019/2/23 11:32
 */

public interface PremiumService {
	
	JsonResult getPremium(String parentId,String dataType);

}
