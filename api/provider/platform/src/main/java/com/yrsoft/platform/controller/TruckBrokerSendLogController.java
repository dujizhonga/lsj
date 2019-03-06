package com.yrsoft.platform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.apache.servicecomb.provider.rest.common.RestSchema;
import javax.ws.rs.core.MediaType;

import com.yrsoft.common.utils.JsonResult;
import com.yrsoft.common.utils.StringUtils;
import com.yrsoft.platform.entity.TruckBrokerSendLog;
import com.yrsoft.platform.service.TruckBrokerSendLogService;


/**
 * 无车承运人数据上报
 * 
 * @author WANGQI
 * @date 2019-03-06
 */
@RestSchema(schemaId = "truckBrokerSendLog")
@RequestMapping(path = "/provider/platform/truckBrokerSendLog",produces = MediaType.APPLICATION_JSON)
public class TruckBrokerSendLogController
{

	@Autowired
	private TruckBrokerSendLogService truckBrokerSendLogService;

	@RequestMapping(value = "/getTruckBrokerSendLogById",method = RequestMethod.POST)
	public JsonResult getTruckBrokerSendLogById(String id){
	    if (StringUtils.isBlank(id)){
	        return JsonResult.error(201,"请传入主键编号");
		}
		return truckBrokerSendLogService.getTruckBrokerSendLogById(id);
	}

	@RequestMapping(value = "/list",method = RequestMethod.POST)
	public JsonResult list(Integer page,Integer limit,TruckBrokerSendLog truckBrokerSendLog){
        page =  page != null ? page:0;
        limit =  limit != null ?limit:10;
	    try {
            return truckBrokerSendLogService.list(page,limit,truckBrokerSendLog);
        } catch (Exception e) {
            return JsonResult.error(207,"服务器错误");
        }
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public JsonResult add(TruckBrokerSendLog truckBrokerSendLog)
    {
        try {
            return truckBrokerSendLogService.add(truckBrokerSendLog);
        } catch (Exception e) {
            return JsonResult.error(207,"服务器错误");
        }
    }

    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    public JsonResult edit(TruckBrokerSendLog truckBrokerSendLog)
    {
        try {
            return truckBrokerSendLogService.edit(truckBrokerSendLog);
        } catch (Exception e) {
            return JsonResult.error(207,"服务器错误");
        }

    }

    @RequestMapping(value = "/remove",method = RequestMethod.POST)
    public JsonResult remove(String ids)
    {
        if (StringUtils.isBlank(ids)) {
            return JsonResult.error(201,"请传入要删除的编号");
        }
        try {
            return truckBrokerSendLogService.remove(ids);
        } catch (Exception e) {
            return JsonResult.error(207,"服务器错误");
        }
    }
}
