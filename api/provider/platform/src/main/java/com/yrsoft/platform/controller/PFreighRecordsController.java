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
import com.yrsoft.platform.entity.PFreighRecords;
import com.yrsoft.platform.service.PFreighRecordsService;


/**
 * 货运-支付运费记录 信息操作处理
 * 
 * @author mz
 * @date 2019-02-23
 */
@RestSchema(schemaId = "pFreighRecords")
@RequestMapping(path = "/provider/pFreighRecords",produces = MediaType.APPLICATION_JSON)
public class PFreighRecordsController
{

	@Autowired
	private PFreighRecordsService pFreighRecordsService;

    /**
     * 查询货运-支付运费记录一个
     */
	@RequestMapping(value = "/getPFreighRecordsById",method = RequestMethod.POST)
	public JsonResult getPFreighRecordsById(String id){
	    if (StringUtils.isBlank(id)){
	        return JsonResult.error(201,"请传入主键编号");
		}


		return pFreighRecordsService.getPFreighRecordsById(id);
	}


    /**
     * 查询货运-支付运费记录列表
     */
	@RequestMapping(value = "/list",method = RequestMethod.POST)
	public JsonResult list(Integer page,Integer limit,PFreighRecords pFreighRecords){
        page =  page != null ? page:0;
        limit =  limit != null ?limit:10;
	    try {
            return pFreighRecordsService.list(page,limit,pFreighRecords);
        } catch (Exception e) {
            return JsonResult.error(207,"服务器错误");
        }
    }

    /**
     * 新增保存货运-支付运费记录
     */

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public JsonResult add(PFreighRecords pFreighRecords)
    {
        try {
            return pFreighRecordsService.add(pFreighRecords);
        } catch (Exception e) {
            return JsonResult.error(207,"服务器错误");
        }
    }

    /**
     * 修改保存货运-支付运费记录
     */

    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    public JsonResult edit(PFreighRecords pFreighRecords)
    {
        try {
            return pFreighRecordsService.edit(pFreighRecords);
        } catch (Exception e) {
            return JsonResult.error(207,"服务器错误");
        }

    }

    /**
     * 删除货运-支付运费记录
     */
    @RequestMapping(value = "/remove",method = RequestMethod.POST)
    public JsonResult remove(String ids)
    {
        if (StringUtils.isBlank(ids)) {
            return JsonResult.error(201,"请传入要删除的编号");
        }
        try {
            return pFreighRecordsService.remove(ids);
        } catch (Exception e) {
            return JsonResult.error(207,"服务器错误");
        }
    }
}
