package com.yrsoft.platform.dao;

import com.yrsoft.platform.entity.TruckBrokerSendLog;
import java.util.List;
import java.util.Map;
/**
 * 无车承运人数据上报 数据层
 * 
 * @author WANGQI
 * @date 2019-03-06
 */
public interface TruckBrokerSendLogDao {
	public TruckBrokerSendLog selectTruckBrokerSendLogById(String id);

	public List<TruckBrokerSendLog> selectTruckBrokerSendLogList(TruckBrokerSendLog truckBrokerSendLog);

	public int insertTruckBrokerSendLog(TruckBrokerSendLog truckBrokerSendLog);

	public int updateTruckBrokerSendLog(TruckBrokerSendLog truckBrokerSendLog);

	public int updateTruckBrokerSendLogByIds(Map<String, Object> param);

	public int deleteTruckBrokerSendLogById(Map<String, Object> param);

}