package com.yrsoft.systeminfo.service;

import com.yrsoft.common.utils.JsonResult;

public interface MessageService {
	JsonResult unReadMessageCount(String shipperId);
	JsonResult list(Integer page,Integer limit,String shipperId,String createTime);
	JsonResult updateToRead(String ids);
}
