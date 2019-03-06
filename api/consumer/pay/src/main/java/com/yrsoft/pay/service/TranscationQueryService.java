package com.yrsoft.pay.service;

import com.yrsoft.common.utils.JsonResult;

public interface TranscationQueryService {
	JsonResult selectRechargeList(Integer page,Integer limit,String memberId);
	JsonResult selectPayList(Integer page,Integer limit,String memberId);
}
