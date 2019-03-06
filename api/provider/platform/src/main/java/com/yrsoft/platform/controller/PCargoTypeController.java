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
import com.yrsoft.platform.entity.PCargoType;
import com.yrsoft.platform.service.PCargoTypeService;


/**
 * 货运-货物类别 信息操作处理
 * 
 * @author mz
 * @date 2019-02-23
 */
@RestSchema(schemaId = "pCargoType")
@RequestMapping(path = "/provider/pCargoType",produces = MediaType.APPLICATION_JSON)
public class PCargoTypeController
{

	@Autowired
	private PCargoTypeService pCargoTypeService;

    /**
     * 查询货运-货物类别一个
     */
	@RequestMapping(value = "/getPCargoTypeById",method = RequestMethod.POST)
	public JsonResult getPCargoTypeById(String id){
	    if (StringUtils.isBlank(id)){
	        return JsonResult.error(201,"请传入主键编号");
		}


		return pCargoTypeService.getPCargoTypeById(id);
	}


    /**
     * 查询货运-货物类别列表
     */
	@RequestMapping(value = "/list",method = RequestMethod.POST)
	public JsonResult list(Integer page,Integer limit,PCargoType pCargoType){
        page =  page != null ? page:0;
        limit =  limit != null ?limit:10;
	    try {
            return pCargoTypeService.list(page,limit,pCargoType);
        } catch (Exception e) {
            return JsonResult.error(207,"服务器错误");
        }
    }

    /**
     * 新增保存货运-货物类别
     */

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public JsonResult add(PCargoType pCargoType)
    {
        try {
            return pCargoTypeService.add(pCargoType);
        } catch (Exception e) {
            return JsonResult.error(207,"服务器错误");
        }
    }

    /**
     * 修改保存货运-货物类别
     */

    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    public JsonResult edit(PCargoType pCargoType)
    {
        try {
            return pCargoTypeService.edit(pCargoType);
        } catch (Exception e) {
            return JsonResult.error(207,"服务器错误");
        }

    }

    /**
     * 删除货运-货物类别
     */
    @RequestMapping(value = "/remove",method = RequestMethod.POST)
    public JsonResult remove(String ids)
    {
        if (StringUtils.isBlank(ids)) {
            return JsonResult.error(201,"请传入要删除的编号");
        }
        try {
            return pCargoTypeService.remove(ids);
        } catch (Exception e) {
            return JsonResult.error(207,"服务器错误");
        }
    }
}
