package com.yrsoft.delivery.service;

import com.yrsoft.common.utils.JsonResult;
/**
 * 查询收发货地址
 * @author party
 *
 */

public interface AddressListService {
	JsonResult getAddressList(Integer page, Integer limit, String shipperId,String addressType);
}
