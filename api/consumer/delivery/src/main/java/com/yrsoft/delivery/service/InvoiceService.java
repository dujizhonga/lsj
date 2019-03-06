package com.yrsoft.delivery.service;

import com.yrsoft.common.utils.JsonResult;
import com.yrsoft.delivery.entity.PInvoice;

/**
 * 货运单管理
 *
 * @author Yxq
 * @date 2019/2/25
 */
public interface InvoiceService {

    /**
     * 保存货运单
     *
     * @param invoice
     * @return
     */
    public JsonResult saveInvoice(String  paramStr);
    /**
     * 查询货运单的默认地址
     *
     * @param address
     * @return
     */
    public JsonResult selectInvoiceAddress(String paramStr);
    /**
     * 查询货运单详情
     * @param id :货运单id
     * @return
     */
	public JsonResult selectInvoiceInfo(String paramStr);
}
