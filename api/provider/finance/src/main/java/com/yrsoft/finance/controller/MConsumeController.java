package com.yrsoft.finance.controller;

import com.yrsoft.common.utils.JsonResult;
import com.yrsoft.common.utils.StringUtils;
import com.yrsoft.finance.entity.MConsume;
import com.yrsoft.finance.service.MConsumeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.apache.servicecomb.provider.rest.common.RestSchema;
import javax.ws.rs.core.MediaType;


/**
 * 会员管理-消费记录（非三方） 信息操作处理
 * 
 * @author mz
 * @date 2019-02-23
 */
@RestSchema(schemaId = "mConsume")
@RequestMapping(path = "/test/mConsume",produces = MediaType.APPLICATION_JSON)
public class MConsumeController
{

	@Autowired
	private MConsumeService mConsumeService;

    /**
     * 查询会员管理-消费记录（非三方）一个
     */
	@RequestMapping(value = "/getMConsumeById",method = RequestMethod.POST)
	public JsonResult getMConsumeById(String id){
	    if (StringUtils.isBlank(id)){
	        return JsonResult.error(201,"请传入主键编号");
		}


		return mConsumeService.getMConsumeById(id);
	}


    /**
     * 查询会员管理-消费记录（非三方）列表
     */
	@RequestMapping(value = "/list",method = RequestMethod.POST)
	public JsonResult list(Integer page,Integer limit,MConsume mConsume){
        page =  page != null ? page:0;
        limit =  limit != null ?limit:10;
	    try {
            return mConsumeService.list(page,limit,mConsume);
        } catch (Exception e) {
            return JsonResult.error(207,"服务器错误");
        }
    }

    /**
     * 新增保存会员管理-消费记录（非三方）
     */

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public JsonResult add(MConsume mConsume)
    {
        try {
            return mConsumeService.add(mConsume);
        } catch (Exception e) {
            return JsonResult.error(207,"服务器错误");
        }
    }

    /**
     * 修改保存会员管理-消费记录（非三方）
     */

    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    public JsonResult edit(MConsume mConsume)
    {
        try {
            return mConsumeService.edit(mConsume);
        } catch (Exception e) {
            return JsonResult.error(207,"服务器错误");
        }

    }

    /**
     * 删除会员管理-消费记录（非三方）
     */
    @RequestMapping(value = "/remove",method = RequestMethod.POST)
    public JsonResult remove(String ids)
    {
        if (StringUtils.isBlank(ids)) {
            return JsonResult.error(201,"请传入要删除的编号");
        }
        try {
            return mConsumeService.remove(ids);
        } catch (Exception e) {
            return JsonResult.error(207,"服务器错误");
        }
    }
}
