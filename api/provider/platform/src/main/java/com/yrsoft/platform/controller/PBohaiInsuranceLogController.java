package com.yrsoft.platform.controller;

import com.yrsoft.common.utils.JsonResult;
import com.yrsoft.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.apache.servicecomb.provider.rest.common.RestSchema;
import javax.ws.rs.core.MediaType;
import com.yrsoft.platform.entity.PBohaiInsuranceLog;
import com.yrsoft.platform.service.PBohaiInsuranceLogService;


/**
 * 渤海保险承保记录 信息操作处理
 * 
 * @author mz
 * @date 2019-03-06
 */
@RestSchema(schemaId = "pBohaiInsuranceLog")
@RequestMapping(path = "/provider/pBohaiInsuranceLog",produces = MediaType.APPLICATION_JSON)
public class PBohaiInsuranceLogController
{

	@Autowired
	private PBohaiInsuranceLogService pBohaiInsuranceLogService;

    /**
     * 查询渤海保险承保记录一个
     */
	@RequestMapping(value = "/getPBohaiInsuranceLogById",method = RequestMethod.POST)
	public JsonResult getPBohaiInsuranceLogById(String id){
	    if (StringUtils.isBlank(id)){
	        return JsonResult.error(201,"请传入主键编号");
		}


		return pBohaiInsuranceLogService.getPBohaiInsuranceLogById(id);
	}


    /**
     * 查询渤海保险承保记录列表
     */
	@RequestMapping(value = "/list",method = RequestMethod.POST)
	public JsonResult list(Integer page,Integer limit,PBohaiInsuranceLog pBohaiInsuranceLog){
        page =  page != null ? page:0;
        limit =  limit != null ?limit:10;
	    try {
            return pBohaiInsuranceLogService.list(page,limit,pBohaiInsuranceLog);
        } catch (Exception e) {
            return JsonResult.error(207,"服务器错误");
        }
    }

    /**
     * 新增保存渤海保险承保记录
     */

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public JsonResult add(PBohaiInsuranceLog pBohaiInsuranceLog)
    {
        try {
            return pBohaiInsuranceLogService.add(pBohaiInsuranceLog);
        } catch (Exception e) {
            return JsonResult.error(207,"服务器错误");
        }
    }

    /**
     * 修改保存渤海保险承保记录
     */

    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    public JsonResult edit(PBohaiInsuranceLog pBohaiInsuranceLog)
    {
        try {
            return pBohaiInsuranceLogService.edit(pBohaiInsuranceLog);
        } catch (Exception e) {
            return JsonResult.error(207,"服务器错误");
        }

    }

    /**
     * 删除渤海保险承保记录
     */
    @RequestMapping(value = "/remove",method = RequestMethod.POST)
    public JsonResult remove(String ids)
    {
        if (StringUtils.isBlank(ids)) {
            return JsonResult.error(201,"请传入要删除的编号");
        }
        try {
            return pBohaiInsuranceLogService.remove(ids);
        } catch (Exception e) {
            return JsonResult.error(207,"服务器错误");
        }
    }
}
