package com.yrsoft.delivery.service;

import com.yrsoft.common.utils.JsonResult;
import com.yrsoft.delivery.entity.SProtocol;

/**
 * 协议合同查询接口
 * @author lu
 * @date 2019/2/23 11:32
 */

public interface ProtocolService {

    /**
    *
    * 功能描述: 协议/合同查询
    *
    * @param: showSite：显示端 1：货主pc，2：货主app，3：车主app，4：油站
    *         flag：类型 0-投保须知 1-运输合同 2-用户协议
    * @return: protocolCopy：协议副文本
    * @auther: lu
    * @date: 2019/2/23
    */
	public JsonResult getProtocol(String  paramStr);
}
