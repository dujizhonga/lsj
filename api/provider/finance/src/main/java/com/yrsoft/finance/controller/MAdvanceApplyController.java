package com.yrsoft.finance.controller;

import com.yrsoft.common.utils.JsonResult;
import com.yrsoft.common.utils.StringUtils;
import com.yrsoft.finance.entity.MAdvanceApply;
import com.yrsoft.finance.service.MAdvanceApplyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.apache.servicecomb.provider.rest.common.RestSchema;
import javax.ws.rs.core.MediaType;



/**
 * 会员管理-垫资申请 信息操作处理
 * 
 * @author mz
 * @date 2019-02-23
 */
@RestSchema(schemaId = "mAdvanceApply")
@RequestMapping(path = "/test/mAdvanceApply",produces = MediaType.APPLICATION_JSON)
public class MAdvanceApplyController
{

	@Autowired
	private MAdvanceApplyService mAdvanceApplyService;

    /**
     * 查询会员管理-垫资申请一个
     */
	@RequestMapping(value = "/getMAdvanceApplyById",method = RequestMethod.POST)
	public JsonResult getMAdvanceApplyById(String id){
	    if (StringUtils.isBlank(id)){
	        return JsonResult.error(201,"请传入主键编号");
		}


		return mAdvanceApplyService.getMAdvanceApplyById(id);
	}


    /**
     * 查询会员管理-垫资申请列表
     */
	@RequestMapping(value = "/list",method = RequestMethod.POST)
	public JsonResult list(Integer page,Integer limit,MAdvanceApply mAdvanceApply){
        page =  page != null ? page:0;
        limit =  limit != null ?limit:10;
	    try {
            return mAdvanceApplyService.list(page,limit,mAdvanceApply);
        } catch (Exception e) {
            return JsonResult.error(207,"服务器错误");
        }
    }

    /**
     * 新增保存会员管理-垫资申请
     */

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public JsonResult add(MAdvanceApply mAdvanceApply)
    {
        try {
            return mAdvanceApplyService.add(mAdvanceApply);
        } catch (Exception e) {
            return JsonResult.error(207,"服务器错误");
        }
    }

    /**
     * 修改保存会员管理-垫资申请
     */

    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    public JsonResult edit(MAdvanceApply mAdvanceApply)
    {
        try {
            return mAdvanceApplyService.edit(mAdvanceApply);
        } catch (Exception e) {
            return JsonResult.error(207,"服务器错误");
        }

    }

    /**
     * 删除会员管理-垫资申请
     */
    @RequestMapping(value = "/remove",method = RequestMethod.POST)
    public JsonResult remove(String ids)
    {
        if (StringUtils.isBlank(ids)) {
            return JsonResult.error(201,"请传入要删除的编号");
        }
        try {
            return mAdvanceApplyService.remove(ids);
        } catch (Exception e) {
            return JsonResult.error(207,"服务器错误");
        }
    }
}
