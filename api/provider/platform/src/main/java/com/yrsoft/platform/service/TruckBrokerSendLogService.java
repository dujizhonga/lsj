package com.yrsoft.platform.service;

import com.yrsoft.common.utils.JsonResult;
import com.yrsoft.platform.entity.TruckBrokerSendLog;


/**
 * 无车承运人数据上报
 * 
 * @author WANGQI
 * @date 2019-03-06
 */
public interface TruckBrokerSendLogService {
	public JsonResult getTruckBrokerSendLogById(String id);

	public JsonResult list(Integer page, Integer limit, TruckBrokerSendLog truckBrokerSendLog);

	public JsonResult add(TruckBrokerSendLog truckBrokerSendLog);

	public JsonResult edit(TruckBrokerSendLog truckBrokerSendLog);

	public JsonResult remove(String ids);
}
