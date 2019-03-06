package com.yrsoft.finance.controller;

import com.yrsoft.common.utils.JsonResult;
import com.yrsoft.common.utils.StringUtils;
import com.yrsoft.finance.entity.MPayLog;
import com.yrsoft.finance.service.MPayLogService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.apache.servicecomb.provider.rest.common.RestSchema;
import javax.ws.rs.core.MediaType;

/**
 * 会员管理-支付记录 信息操作处理
 * 
 * @author mz
 * @date 2019-02-23
 */
@RestSchema(schemaId = "mPayLog")
@RequestMapping(path = "/provider/mPayLog",produces = MediaType.APPLICATION_JSON)
public class MPayLogController
{

	@Autowired
	private MPayLogService mPayLogService;

    /**
     * 查询会员管理-支付记录一个
     */
	@RequestMapping(value = "/getMPayLogById",method = RequestMethod.POST)
	public JsonResult getMPayLogById(String id){
	    if (StringUtils.isBlank(id)){
	        return JsonResult.error(201,"请传入主键编号");
		}


		return mPayLogService.getMPayLogById(id);
	}


    /**
     * 查询会员管理-支付记录列表
     */
	@RequestMapping(value = "/list",method = RequestMethod.POST)
	public JsonResult list(Integer page,Integer limit,MPayLog payLog){
	    try {
            return mPayLogService.list(page,limit,payLog);
        } catch (Exception e) {
            return JsonResult.error(207,"服务器错误");
        }
    }

    /**
     * 新增保存会员管理-支付记录
     */

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public JsonResult add(MPayLog mPayLog)
    {
        try {
            return mPayLogService.add(mPayLog);
        } catch (Exception e) {
            return JsonResult.error(207,"服务器错误");
        }
    }

    /**
     * 修改保存会员管理-支付记录
     */

    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    public JsonResult edit(MPayLog mPayLog)
    {
        try {
            return mPayLogService.edit(mPayLog);
        } catch (Exception e) {
            return JsonResult.error(207,"服务器错误");
        }

    }

    /**
     * 删除会员管理-支付记录
     */
    @RequestMapping(value = "/remove",method = RequestMethod.POST)
    public JsonResult remove(String ids)
    {
        if (StringUtils.isBlank(ids)) {
            return JsonResult.error(201,"请传入要删除的编号");
        }
        try {
            return mPayLogService.remove(ids);
        } catch (Exception e) {
            return JsonResult.error(207,"服务器错误");
        }
    }
}
