package com.yrsoft.position.controller;


import com.yrsoft.common.utils.JsonResult;
import com.yrsoft.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.apache.servicecomb.provider.rest.common.RestSchema;
import javax.ws.rs.core.MediaType;
import com.yrsoft.position.entity.PoCarPosition;
import com.yrsoft.position.service.PoCarPositionService;


/**
 * 位置-车辆位置及状态 信息操作处理
 * 
 * @author mz
 * @date 2019-02-23
 */
@RestSchema(schemaId = "poCarPosition")
@RequestMapping(path = "/provider/poCarPosition",produces = MediaType.APPLICATION_JSON)
public class PoCarPositionController
{

	@Autowired
	private PoCarPositionService poCarPositionService;

    /**
     * 查询位置-车辆位置及状态一个
     */
	@RequestMapping(value = "/getPoCarPositionById",method = RequestMethod.POST)
	public JsonResult getPoCarPositionById(String id){
	    if (StringUtils.isBlank(id)){
	        return JsonResult.error(201,"请传入主键编号");
		}


		return poCarPositionService.getPoCarPositionById(id);
	}


    /**
     * 查询位置-车辆位置及状态列表
     */
	@RequestMapping(value = "/list",method = RequestMethod.POST)
	public JsonResult list(Integer page,Integer limit,PoCarPosition poCarPosition){
        page =  page != null ? page:0;
        limit =  limit != null ?limit:10;
	    try {
            return poCarPositionService.list(page,limit,poCarPosition);
        } catch (Exception e) {
            return JsonResult.error(207,"服务器错误");
        }
    }

    /**
     * 新增保存位置-车辆位置及状态
     */

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public JsonResult add(PoCarPosition poCarPosition)
    {
        try {
            return poCarPositionService.add(poCarPosition);
        } catch (Exception e) {
            return JsonResult.error(207,"服务器错误");
        }
    }

    /**
     * 修改保存位置-车辆位置及状态
     */

    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    public JsonResult edit(PoCarPosition poCarPosition)
    {
        try {
            return poCarPositionService.edit(poCarPosition);
        } catch (Exception e) {
            return JsonResult.error(207,"服务器错误");
        }

    }

    /**
     * 删除位置-车辆位置及状态
     */
    @RequestMapping(value = "/remove",method = RequestMethod.POST)
    public JsonResult remove(String ids)
    {
        if (StringUtils.isBlank(ids)) {
            return JsonResult.error(201,"请传入要删除的编号");
        }
        try {
            return poCarPositionService.remove(ids);
        } catch (Exception e) {
            return JsonResult.error(207,"服务器错误");
        }
    }
}
