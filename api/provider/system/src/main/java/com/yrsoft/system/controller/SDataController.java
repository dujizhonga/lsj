package com.yrsoft.system.controller;


import com.yrsoft.common.utils.JsonResult;
import com.yrsoft.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.apache.servicecomb.provider.rest.common.RestSchema;
import javax.ws.rs.core.MediaType;
import com.yrsoft.system.entity.SData;
import com.yrsoft.system.service.SDataService;

import java.util.Map;


/**
 * 系统-数据字典 信息操作处理
 * 
 * @author mz
 * @date 2019-02-23
 */
@RestSchema(schemaId = "sData")
@RequestMapping(path = "/provider/sData",produces = MediaType.APPLICATION_JSON)
public class SDataController
{

	@Autowired
	private SDataService sDataService;

    /**
     * 查询系统-数据字典一个
     */
	@RequestMapping(value = "/getSDataById",method = RequestMethod.POST)
	public JsonResult getSDataById(String id){
	    if (StringUtils.isBlank(id)){
	        return JsonResult.error(201,"请传入主键编号");
		}


		return sDataService.getSDataById(id);
	}


    /**
     * 查询系统-数据字典列表
     */
	@RequestMapping(value = "/list",method = RequestMethod.POST)
	public JsonResult list(Integer page,Integer limit,SData sData){
        page =  page != null ? page:0;
        limit =  limit != null ?limit:10;
	    try {
            return sDataService.list(page,limit,sData);
        } catch (Exception e) {
            return JsonResult.error(207,"服务器错误");
        }
    }

    /**
     * 新增保存系统-数据字典
     */

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public JsonResult add(SData sData)
    {
        try {
            return sDataService.add(sData);
        } catch (Exception e) {
            return JsonResult.error(207,"服务器错误");
        }
    }

    /**
     * 修改保存系统-数据字典
     */

    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    public JsonResult edit(SData sData)
    {
        try {
            return sDataService.edit(sData);
        } catch (Exception e) {
            return JsonResult.error(207,"服务器错误");
        }

    }

    /**
     * 删除系统-数据字典
     */
    @RequestMapping(value = "/remove",method = RequestMethod.POST)
    public JsonResult remove(String ids)
    {
        if (StringUtils.isBlank(ids)) {
            return JsonResult.error(201,"请传入要删除的编号");
        }
        try {
            return sDataService.remove(ids);
        } catch (Exception e) {
            return JsonResult.error(207,"服务器错误");
        }
    }

    /**
     * 按类型查询-数据字典
     * @param type
     * @return
     */
    @RequestMapping(value = "/selectDataByType",method = RequestMethod.POST)
    public JsonResult selectDataByType(String type){
        try {
            return sDataService.selectDataByType(type);
        } catch (Exception e) {
            return JsonResult.error(207,"服务器错误");
        }
    }
}
