package com.yrsoft.freight.service;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import com.yrsoft.common.utils.JsonResult;

/**
 *
 * 功能描述: 方法注释
 *
 * @param:
 * @return: 
 * @auther: Guohaolong
 * @date: 2019年2月25日 下午7:47:24
 */
public interface InvoiceService {
	public JsonResult selectByPage(String params);
	public JsonResult selectDeatial(String params);
	public JsonResult selectCarPositionLog(String params);
	public JsonResult selectFreighPay(String params);
	public JsonResult takeDelivery(String params);
	public JsonResult queryForMessageJump(String params);
	public JsonResult exportWaybill(String params);
	public JsonResult exportInvoice(String params);

	/**
	 * 我的货运单--(删除按钮)
	 * @param paraStr
	 * @return:JsonResult
	 * @author:DU'JZ
	 * @data:2019年2月27日 下午2:41:19 
	 * @throws
	 */
	public JsonResult selectInvoiceInfoList(String paramStr);
	
	/**
	 * 删除货运单信息
	 * @param paramStr
	 * @return:JsonResult
	 * @author:DU'JZ
	 * @data:2019年2月27日 下午5:10:42 
	 * @throws
	 */
	public JsonResult deleteInvoiceById(String paramStr);
	
	   
	/**
	* 货运管理--我的货运列表表信息
	* @param paraStr
	* @return:JsonResult
	* @author:DU'JZ
	* @data:2019年2月27日 下午2:33:08 
	* @throws
	*/
	public JsonResult selectMyInvoiceInfo(String paramStr);
	public JsonResult selectPInvoiceNumByState(String id);

}
