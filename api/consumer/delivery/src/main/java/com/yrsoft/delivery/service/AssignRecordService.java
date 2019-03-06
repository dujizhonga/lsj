package com.yrsoft.delivery.service;

import com.yrsoft.common.utils.JsonResult;

/**
 * 生成分派单记录
 * 
 * @param ids(车辆ID),invoiceId
 * @author party
 *
 */
public interface AssignRecordService {
	JsonResult addAssignRecord(String ids, String invoiceId, String shipperId) throws Exception;

}
