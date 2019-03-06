package com.yrsoft.system.controller;

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
import com.yrsoft.system.entity.SProtocol;
import com.yrsoft.system.service.SProtocolService;


/**
 * 系统-协议 信息操作处理
 * 
 * @author mz
 * @date 2019-02-23
 */
@RestSchema(schemaId = "sProtocol")
@RequestMapping(path = "/provider/sProtocol",produces = MediaType.APPLICATION_JSON)
public class SProtocolController
{

	@Autowired
	private SProtocolService sProtocolService;

    /**
     * 查询系统-协议一个
     */
	@RequestMapping(value = "/getSProtocolById",method = RequestMethod.POST)
	public JsonResult getSProtocolById(String id){
	    if (StringUtils.isBlank(id)){
	        return JsonResult.error(201,"请传入主键编号");
		}


		return sProtocolService.getSProtocolById(id);
	}


    /**
     * 查询系统-协议列表
     */
	@RequestMapping(value = "/list",method = RequestMethod.POST)
	public JsonResult list(Integer page,Integer limit,SProtocol sProtocol){
        page =  page != null ? page:0;
        limit =  limit != null ?limit:10;
	    try {
            return sProtocolService.list(page,limit,sProtocol);
        } catch (Exception e) {
            return JsonResult.error(207,"服务器错误");
        }
    }

    /**
     * 新增保存系统-协议
     */

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public JsonResult add(SProtocol sProtocol)
    {
        try {
            return sProtocolService.add(sProtocol);
        } catch (Exception e) {
            return JsonResult.error(207,"服务器错误");
        }
    }

    /**
     * 修改保存系统-协议
     */

    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    public JsonResult edit(SProtocol sProtocol)
    {
        try {
            return sProtocolService.edit(sProtocol);
        } catch (Exception e) {
            return JsonResult.error(207,"服务器错误");
        }

    }

    /**
     * 删除系统-协议
     */
    @RequestMapping(value = "/remove",method = RequestMethod.POST)
    public JsonResult remove(String ids)
    {
        if (StringUtils.isBlank(ids)) {
            return JsonResult.error(201,"请传入要删除的编号");
        }
        try {
            return sProtocolService.remove(ids);
        } catch (Exception e) {
            return JsonResult.error(207,"服务器错误");
        }
    }
}
