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
import com.yrsoft.platform.entity.PAssignRecord;
import com.yrsoft.platform.service.PAssignRecordService;


/**
 * 货运-分派记录 信息操作处理
 * 
 * @author mz
 * @date 2019-02-23
 */
@RestSchema(schemaId = "pAssignRecord")
@RequestMapping(path = "/provider/pAssignRecord",produces = MediaType.APPLICATION_JSON)
public class PAssignRecordController
{

	@Autowired
	private PAssignRecordService pAssignRecordService;

    /**
     * 查询货运-分派记录一个
     */
	@RequestMapping(value = "/getPAssignRecordById",method = RequestMethod.POST)
	public JsonResult getPAssignRecordById(String id){
	    if (StringUtils.isBlank(id)){
	        return JsonResult.error(201,"请传入主键编号");
		}


		return pAssignRecordService.getPAssignRecordById(id);
	}


    /**
     * 查询货运-分派记录列表
     */
	@RequestMapping(value = "/list",method = RequestMethod.POST)
	public JsonResult list(Integer page,Integer limit,PAssignRecord pAssignRecord){
        page =  page != null ? page:0;
        limit =  limit != null ?limit:10;
	    try {
            return pAssignRecordService.list(page,limit,pAssignRecord);
        } catch (Exception e) {
            return JsonResult.error(207,"服务器错误");
        }
    }

    /**
     * 新增保存货运-分派记录
     */

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public JsonResult add(PAssignRecord pAssignRecord)
    {
        try {
            return pAssignRecordService.add(pAssignRecord);
        } catch (Exception e) {
            return JsonResult.error(207,"服务器错误");
        }
    }

    /**
     * 修改保存货运-分派记录
     */

    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    public JsonResult edit(PAssignRecord pAssignRecord)
    {
        try {
            return pAssignRecordService.edit(pAssignRecord);
        } catch (Exception e) {
            return JsonResult.error(207,"服务器错误");
        }

    }

    /**
     * 删除货运-分派记录
     */
    @RequestMapping(value = "/remove",method = RequestMethod.POST)
    public JsonResult remove(String ids)
    {
        if (StringUtils.isBlank(ids)) {
            return JsonResult.error(201,"请传入要删除的编号");
        }
        try {
            return pAssignRecordService.remove(ids);
        } catch (Exception e) {
            return JsonResult.error(207,"服务器错误");
        }
    }
}
