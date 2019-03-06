package com.yrsoft.platform.controller;

import java.util.List;

import com.yrsoft.common.utils.JsonResult;
import com.yrsoft.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.apache.servicecomb.provider.rest.common.RestSchema;
import javax.ws.rs.core.MediaType;
import com.yrsoft.platform.entity.PTransport;
import com.yrsoft.platform.service.PTransportService;


/**
 * 货运-运输单 信息操作处理
 * 
 * @author mz
 * @date 2019-02-23
 */
@RestSchema(schemaId = "pTransport")
@RequestMapping(path = "/provider/pTransport",produces = MediaType.APPLICATION_JSON)
public class PTransportController
{

	@Autowired
	private PTransportService pTransportService;

    /**
     * 查询货运-运输单一个
     */
	@RequestMapping(value = "/getPTransportById",method = RequestMethod.POST)
	public JsonResult getPTransportById(String id){
	    if (StringUtils.isBlank(id)){
	        return JsonResult.error(201,"请传入主键编号");
		}


		return pTransportService.getPTransportById(id);
	}


    /**
     * 查询货运-运输单列表
     */
	@RequestMapping(value = "/list",method = RequestMethod.POST)
	public JsonResult list(Integer page,Integer limit,PTransport pTransport){
        page =  page != null ? page:0;
        limit =  limit != null ?limit:10;
	    try {
            return pTransportService.list(page,limit,pTransport);
        } catch (Exception e) {
            return JsonResult.error(207,"服务器错误");
        }
    }

    /**
     * 新增保存货运-运输单
     */

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public JsonResult add(PTransport pTransport)
    {
        try {
            return pTransportService.add(pTransport);
        } catch (Exception e) {
            return JsonResult.error(207,"服务器错误");
        }
    }

    /**
     * 修改保存货运-运输单
     */

    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    public JsonResult edit(PTransport pTransport)
    {
        try {
            return pTransportService.edit(pTransport);
        } catch (Exception e) {
            return JsonResult.error(207,"服务器错误");
        }

    }

    /**
     * 删除货运-运输单
     */
    @RequestMapping(value = "/remove",method = RequestMethod.POST)
    public JsonResult remove(String ids)
    {
        if (StringUtils.isBlank(ids)) {
            return JsonResult.error(201,"请传入要删除的编号");
        }
        try {
            return pTransportService.remove(ids);
        } catch (Exception e) {
            return JsonResult.error(207,"服务器错误");
        }
    }
}
