package com.yrsoft.freight.service;

import com.yrsoft.common.utils.JsonResult;

/**
 * 运单信息
 * @ClassName:      WaybillInformation
 * @author:         Du'jizhong
 * @date:           2019年2月25日 上午9:13:46
 */
public interface WaybillInformationService {
	
	/**
	 * 分页查寻运单列表信息；
	 * @param ParaMap
	 * @return:JsonResult
	 * @author:DU'JZ
	 * @data:2019年2月25日 上午9:14:57 
	 * @throws
	 */
	public JsonResult selectWaybillInformationByPage(String ParaMap);
	
	/**
	 * 不分页查寻货运单的运单信息
	 * @param ParaMap
	 * @return:JsonResult
	 * @author:DU'JZ
	 * @data:2019年2月25日 下午2:36:33 
	 * @throws
	 */
	public JsonResult selectWaybillInformation(String ParaMap);
	
	/**
	 * 对运单进行评价
	 * @param: @param paraMap
	 * @param: @return
	 * @return: JsonResult
	 * @auther: shihh
	 * @date: 2019年2月26日上午11:34:47
	 */
	public JsonResult addComments(String paramStr);
	/**
	 * 根据货主id查询所有订单
	 * @param: @param ParaMap
	 * @param: @return
	 * @return: JsonResult
	 * @auther: shihh
	 * @date: 2019年2月26日下午2:15:16
	 */
	/*public JsonResult selectWaybillByShipperId(String paramStr);*/
	
	/**
	 *	运单列表双击显示货运单详情
	 * @param: @param paraMap
	 * @param: @return
	 * @return: JsonResult
	 * @auther: shihh
	 * @date: 2019年2月26日下午3:47:14
	 */
	/*public JsonResult selectPinvoiceById(String paramStr);*/
	
	/**
	 * 支付完保险费修改货运单信息<p>
	 * 修改货运单信息(保险费支付ID,保险费支付状态)<p>
	 * 根据保险费支付记录获得货运单支付状态<p>
	 * 
	 * @param waybillIds 运单ID(以逗号分隔)
	 * @param insuranceId 险费支付ID(单个的字符串)		    
	 * @return JsonResult
	 * @author WANGQI
	 * @date 2019年2月28日 下午5:32:45
	 */
	public JsonResult updateWaybillForInsurance(String waybillIds,String insuranceId);
	
}
