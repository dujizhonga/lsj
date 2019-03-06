package com.yrsoft.platform.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.apache.servicecomb.provider.rest.common.RestSchema;
import javax.ws.rs.core.MediaType;

import com.yrsoft.common.utils.JsonResult;
import com.yrsoft.common.utils.StringUtils;
import com.yrsoft.platform.entity.PAssignApply;
import com.yrsoft.platform.service.PAssignApplyService;


/**
 * 货运-系统车辆分派申请 信息操作处理
 * 
 * @author mz
 * @date 2019-02-23
 */
@RestSchema(schemaId = "pAssignApply")
@RequestMapping(path = "/provider/pAssignApply",produces = MediaType.APPLICATION_JSON)
public class PAssignApplyController
{

	@Autowired
	private PAssignApplyService pAssignApplyService;

    /**
     * 查询货运-系统车辆分派申请一个
     */
	@RequestMapping(value = "/getPAssignApplyById",method = RequestMethod.POST)
	public JsonResult getPAssignApplyById(String id){
	    if (StringUtils.isBlank(id)){
	        return JsonResult.error(201,"请传入主键编号");
		}


		return pAssignApplyService.getPAssignApplyById(id);
	}


    /**
     * 查询货运-系统车辆分派申请列表
     */
	@RequestMapping(value = "/list",method = RequestMethod.POST)
	public JsonResult list(Integer page,Integer limit,PAssignApply pAssignApply){
        page =  page != null ? page:0;
        limit =  limit != null ?limit:10;
	    try {
            return pAssignApplyService.list(page,limit,pAssignApply);
        } catch (Exception e) {
            return JsonResult.error(207,"服务器错误");
        }
    }

    /**
     * 新增保存货运-系统车辆分派申请
     */

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public JsonResult add(PAssignApply pAssignApply)
    {
        try {
            return pAssignApplyService.add(pAssignApply);
        } catch (Exception e) {
            return JsonResult.error(207,"服务器错误");
        }
    }

    /**
     * 修改保存货运-系统车辆分派申请
     */

    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    public JsonResult edit(PAssignApply pAssignApply)
    {
        try {
            return pAssignApplyService.edit(pAssignApply);
        } catch (Exception e) {
            return JsonResult.error(207,"服务器错误");
        }

    }

    /**
     * 删除货运-系统车辆分派申请
     */
    @RequestMapping(value = "/remove",method = RequestMethod.POST)
    public JsonResult remove(String ids)
    {
        if (StringUtils.isBlank(ids)) {
            return JsonResult.error(201,"请传入要删除的编号");
        }
        try {
            return pAssignApplyService.remove(ids);
        } catch (Exception e) {
            return JsonResult.error(207,"服务器错误");
        }
    }
}
