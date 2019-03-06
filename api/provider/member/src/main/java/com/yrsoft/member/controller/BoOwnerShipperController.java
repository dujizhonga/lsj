package com.yrsoft.member.controller;

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
import com.yrsoft.member.entity.BoOwnerShipper;
import com.yrsoft.member.service.BoOwnerShipperService;


/**
 * 会员管理-货主车主关系 信息操作处理
 * 
 * @author mz
 * @date 2019-02-23
 */
@RestSchema(schemaId = "boOwnerShipper")
@RequestMapping(path = "/provider/boOwnerShipper",produces = MediaType.APPLICATION_JSON)
public class BoOwnerShipperController
{

	@Autowired
	private BoOwnerShipperService boOwnerShipperService;

    /**
     * 查询会员管理-货主车主关系一个
     */
	@RequestMapping(value = "/getBoOwnerShipperById",method = RequestMethod.POST)
	public JsonResult getBoOwnerShipperById(String id){
	    if (StringUtils.isBlank(id)){
	        return JsonResult.error(201,"请传入主键编号");
		}


		return boOwnerShipperService.getBoOwnerShipperById(id);
	}


    /**
     * 查询会员管理-货主车主关系列表
     */
	@RequestMapping(value = "/list",method = RequestMethod.POST)
	public JsonResult list(Integer page,Integer limit,BoOwnerShipper boOwnerShipper){
        page =  page != null ? page:0;
        limit =  limit != null ?limit:10;
	    try {
            return boOwnerShipperService.list(page,limit,boOwnerShipper);
        } catch (Exception e) {
            return JsonResult.error(207,"服务器错误");
        }
    }

    /**
     * 新增保存会员管理-货主车主关系
     */

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public JsonResult add(BoOwnerShipper boOwnerShipper)
    {
        try {
            return boOwnerShipperService.add(boOwnerShipper);
        } catch (Exception e) {
            return JsonResult.error(207,"服务器错误");
        }
    }

    /**
     * 修改保存会员管理-货主车主关系
     */

    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    public JsonResult edit(BoOwnerShipper boOwnerShipper)
    {
        try {
            return boOwnerShipperService.edit(boOwnerShipper);
        } catch (Exception e) {
            return JsonResult.error(207,"服务器错误");
        }

    }

    /**
     * 删除会员管理-货主车主关系
     */
    @RequestMapping(value = "/remove",method = RequestMethod.POST)
    public JsonResult remove(String ids)
    {
        if (StringUtils.isBlank(ids)) {
            return JsonResult.error(201,"请传入要删除的编号");
        }
        try {
            return boOwnerShipperService.remove(ids);
        } catch (Exception e) {
            return JsonResult.error(207,"服务器错误");
        }
    }
    
    /**
     * 查询车主信息-货主车主关系列表
     */
	@RequestMapping(value = "/selectOwnerInfo",method = RequestMethod.POST)
	public JsonResult selectOwnerInfo(String shipperId){
	    try {
            return boOwnerShipperService.selectOwnerInfo(shipperId);
        } catch (Exception e) {
            return JsonResult.error(207,"服务器错误");
        }
    }
}
