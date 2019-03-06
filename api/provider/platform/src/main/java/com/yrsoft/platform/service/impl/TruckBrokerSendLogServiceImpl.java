package com.yrsoft.platform.service.impl;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yrsoft.common.support.Convert;
import com.yrsoft.common.utils.JsonResult;
import com.yrsoft.platform.dao.TruckBrokerSendLogDao;
import com.yrsoft.platform.entity.TruckBrokerSendLog;
import com.yrsoft.platform.service.TruckBrokerSendLogService;



/**
 * 无车承运人数据上报
 * 
 * @author WANGQI
 * @date 2019-03-06
 */
@Service
public class TruckBrokerSendLogServiceImpl implements TruckBrokerSendLogService
{
    @Autowired
    private TruckBrokerSendLogDao truckBrokerSendLogDao;
    @Override
	public JsonResult getTruckBrokerSendLogById(String id)
	{
		TruckBrokerSendLog truckBrokerSendLog = truckBrokerSendLogDao.selectTruckBrokerSendLogById(id);
        if ( null == truckBrokerSendLog ) {
			return JsonResult.error(201,"暂无数据");
        }
	    return JsonResult.success(truckBrokerSendLog);
	}

    @Override
    public JsonResult list(Integer page,Integer limit,TruckBrokerSendLog truckBrokerSendLog)
    {
        //开启分页
        PageHelper.startPage(page,limit);

        //获取数据
        List<TruckBrokerSendLog> lists =  truckBrokerSendLogDao.selectTruckBrokerSendLogList(truckBrokerSendLog);
        if (null == lists || lists.isEmpty()){
            return JsonResult.error(201,"暂无数据");
        }

        PageInfo<TruckBrokerSendLog> pageInfo = new PageInfo<>(lists);

        return JsonResult.createJsonResponse(pageInfo);
    }
	
	@Override
	public JsonResult add(TruckBrokerSendLog truckBrokerSendLog)
	{

        int result = truckBrokerSendLogDao.insertTruckBrokerSendLog(truckBrokerSendLog);
        if (result == 0) {
            return JsonResult.error(201,"添加失败");
        }
        return JsonResult.success(200,"添加成功");
	}
	
	@Override
	public JsonResult edit(TruckBrokerSendLog truckBrokerSendLog)
	{
        int result = truckBrokerSendLogDao.updateTruckBrokerSendLog(truckBrokerSendLog);
        if (result == 0) {
            return JsonResult.error(201,"更新失败");
        }
        return JsonResult.success(200,"更新成功");
	}

    @Override
    public JsonResult remove(String ids)
    {
        Map<String,Object> delete = new HashMap<>();
        //数据库删除字段必须为delFlag
        delete.put("delFlag",1);
        delete.put("ids",Convert.toStrArray(ids));

        int result = truckBrokerSendLogDao.updateTruckBrokerSendLogByIds(delete);
        if (result == 0) {
            return JsonResult.error(201,"删除失败");
        }
        return JsonResult.success(200,"删除成功");
    }

}
