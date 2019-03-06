package com.yrsoft.tripartite.service;

import java.util.Map;

import com.vvise.wccyclient.vo.RestResult;
import com.yrsoft.common.utils.JsonResult;


/**
 * 无车承运人资金流水单发送<p>
 * 无车承运人电子路单发送<p>
 * 无车承运人发送数据日志记录<p>
 * 
 * @author WANGQI
 * @date 2019年3月1日 下午2:46:41
 */
public interface TruckBrokerService {
	
	/**
	 * 只是调用sendWaybill和sendFundFlow服务<p>
	 * 
	 * @param  waybillIds
	 * 		        货运单ID(逗号分割的)
	 * @return JsonResult
	 * @author WANGQI
	 * @date 2019年3月1日 下午3:07:42
	 */
	public JsonResult send(String waybillIds);
	
	/**
	 * 无车承运人电子路单发送<p>
	 * 
	 * @param 
	 * @return RestResult
	 * @author WANGQI
	 * @date 2019年3月1日 下午2:51:26
	 */
	public  RestResult sendWaybill(String orderCode, String orderCreateDate, String startDate, String arriveDate,String userName,String idCardNo,
			String startAddress, String receiveUserName,String  arriveAddress, String orderAmount, String carNumber,
			String loadWeight, String yszh,String driverName, String goodsName, String goodsWeight,
			String xkzh,String driverRecordName,String qualificationCode,
			String driverRecordTelephone, String startCityCode, String arriveCityCode);
	
	/**
	 * 无车承运人资金流水单发送<p>
	 * 
	 * @param 
	 * @return 
	 * @author WANGQI
	 * @date 2019年3月1日 下午2:54:13
	 */
	public RestResult sendFundFlow(String orderCode, String carrier, String vehicleNumber, int payway,
			String transcationAmount, String sequenceCode, String transcationDateTime);
	
	
	/**
	 * 
	 *
	 * @param waybillId
	 * @return <code>Map</code>  无车承运人电子路单及资金流水单所需要的所有数据
	 * @author WANGQI
	 * @date 2019年3月4日 下午3:55:00
	 */
	public Map<String,Object> getAllData(String waybillId);
}
