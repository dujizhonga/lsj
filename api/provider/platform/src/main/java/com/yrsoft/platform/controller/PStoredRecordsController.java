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
import com.yrsoft.platform.entity.PStoredRecords;
import com.yrsoft.platform.entity.PStoredRecordsVo;
import com.yrsoft.platform.service.PStoredRecordsService;


/**
 * 货运-储值记录 信息操作处理
 * 
 * @author mz
 * @date 2019-02-23
 */
@RestSchema(schemaId = "pStoredRecords")
@RequestMapping(path = "/provider/pStoredRecords",produces = MediaType.APPLICATION_JSON)
public class PStoredRecordsController
{

	@Autowired
	private PStoredRecordsService pStoredRecordsService;

    /**
     * 查询货运-储值记录一个
     */
	@RequestMapping(value = "/getPStoredRecordsById",method = RequestMethod.POST)
	public JsonResult getPStoredRecordsById(String id){
	    if (StringUtils.isBlank(id)){
	        return JsonResult.error(201,"请传入主键编号");
		}


		return pStoredRecordsService.getPStoredRecordsById(id);
	}


    /**
     * 查询货运-储值记录列表
     */
	@RequestMapping(value = "/list",method = RequestMethod.POST)
	public JsonResult list(Integer page,Integer limit,PStoredRecords pStoredRecords){
        page =  page != null ? page:0;
        limit =  limit != null ?limit:10;
	    try {
            return pStoredRecordsService.list(page,limit,pStoredRecords);
        } catch (Exception e) {
            return JsonResult.error(207,"服务器错误");
        }
    }

    /**
     * 新增保存货运-储值记录
     */

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public JsonResult add(PStoredRecords pStoredRecords)
    {
        try {
            return pStoredRecordsService.add(pStoredRecords);
        } catch (Exception e) {
            return JsonResult.error(207,"服务器错误");
        }
    }

    /**
     * 修改保存货运-储值记录
     */

    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    public JsonResult edit(PStoredRecords pStoredRecords)
    {
        try {
            return pStoredRecordsService.edit(pStoredRecords);
        } catch (Exception e) {
            return JsonResult.error(207,"服务器错误");
        }

    }

    /**
     * 删除货运-储值记录
     */
    @RequestMapping(value = "/remove",method = RequestMethod.POST)
    public JsonResult remove(String ids)
    {
        if (StringUtils.isBlank(ids)) {
            return JsonResult.error(201,"请传入要删除的编号");
        }
        try {
            return pStoredRecordsService.remove(ids);
        } catch (Exception e) {
            return JsonResult.error(207,"服务器错误");
        }
    }
    /**
     * 生产资料分配记录列表
     */
	@RequestMapping(value = "/getPSoredList",method = RequestMethod.POST)
	public JsonResult getPSoredList(Integer page,Integer limit,String shipperId){
        page =  page != null ? page:0;
        limit =  limit != null ?limit:10;
	    try {
            return pStoredRecordsService.getPSoredList(page,limit,shipperId);
        } catch (Exception e) {
            return JsonResult.error(207,"服务器错误");
        }
    }
	
	 /**
     * 生产资料分配记录单条记录详情
     */
	@RequestMapping(value = "/getPStoredById",method = RequestMethod.POST)
	public JsonResult getPStoredById(String id){
	    if (StringUtils.isBlank(id)){
	        return JsonResult.error(201,"请传入主键编号");
		}


		return pStoredRecordsService.getPSoredById(id);
	}
}
