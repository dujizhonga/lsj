package com.yrsoft.freight.service;

import com.yrsoft.common.utils.JsonResult;

public interface InsuranceService {
    public JsonResult getInsuranceAmount(String id);

    /**
     * 按类型查询-保险费规则
     * @param routeRange
     * @return
     */
    public JsonResult selectInsuranceRule(String routeRange);

}
