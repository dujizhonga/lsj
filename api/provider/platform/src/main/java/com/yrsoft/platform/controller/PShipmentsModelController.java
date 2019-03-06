package com.yrsoft.platform.controller;

import java.util.Arrays;
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
import com.yrsoft.platform.entity.PShipmentsModel;
import com.yrsoft.platform.service.PShipmentsModelService;


/**
 * 货运-货运模板 信息操作处理
 * 
 * @author mz
 * @date 2019-02-23
 */
@RestSchema(schemaId = "pShipmentsModel")
@RequestMapping(path = "/provider/pShipmentsModel",produces = MediaType.APPLICATION_JSON)
public class PShipmentsModelController
{

	@Autowired
	private PShipmentsModelService pShipmentsModelService;

    /**
     * 查询货运-货运模板一个
     */
	@RequestMapping(value = "/getPShipmentsModelById",method = RequestMethod.POST)
	public JsonResult getPShipmentsModelById(String id){
	    if (StringUtils.isBlank(id)){
	        return JsonResult.error(201,"请传入主键编号");
		}


		return pShipmentsModelService.getPShipmentsModelById(id);
	}


    /**
     * 查询货运-货运模板列表
     */
	@RequestMapping(value = "/list",method = RequestMethod.POST)
	public JsonResult list(Integer page,Integer limit,PShipmentsModel pShipmentsModel){
        page =  page != null ? page:0;
        limit =  limit != null ?limit:10;
	    try {
            return pShipmentsModelService.list(page,limit,pShipmentsModel);
        } catch (Exception e) {
            return JsonResult.error(207,"服务器错误");
        }
    }

    /**
     * 新增保存货运-货运模板
     */

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public JsonResult add(PShipmentsModel pShipmentsModel)
    {
        try {
            return pShipmentsModelService.add(pShipmentsModel);
        } catch (Exception e) {
            return JsonResult.error(207,"服务器错误");
        }
    }

    /**
     * 修改保存货运-货运模板
     */

    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    public JsonResult edit(PShipmentsModel pShipmentsModel)
    {
        try {
            return pShipmentsModelService.edit(pShipmentsModel);
        } catch (Exception e) {
            return JsonResult.error(207,"服务器错误");
        }

    }

    /**
     * 删除货运-货运模板
     */
    @RequestMapping(value = "/remove",method = RequestMethod.POST)
    public JsonResult remove(String ids)
    {
        if (StringUtils.isBlank(ids)) {

            return JsonResult.error(201,"请传入要删除的编号");
        }
        try {
            return pShipmentsModelService.remove(ids);
        } catch (Exception e) {
            return JsonResult.error(207,"服务器错误");
        }
    }
}
