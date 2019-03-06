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
import com.yrsoft.member.entity.MOwnerDriver;
import com.yrsoft.member.service.MOwnerDriverService;


/**
 * 会员管理-车主司机关系 信息操作处理
 * 
 * @author mz
 * @date 2019-02-23
 */
@RestSchema(schemaId = "mOwnerDriver")
@RequestMapping(path = "/test/mOwnerDriver",produces = MediaType.APPLICATION_JSON)
public class MOwnerDriverController
{

	@Autowired
	private MOwnerDriverService mOwnerDriverService;

    /**
     * 查询会员管理-车主司机关系一个
     */
	@RequestMapping(value = "/getMOwnerDriverById",method = RequestMethod.POST)
	public JsonResult getMOwnerDriverById(String id){
	    if (StringUtils.isBlank(id)){
	        return JsonResult.error(201,"请传入主键编号");
		}


		return mOwnerDriverService.getMOwnerDriverById(id);
	}


    /**
     * 查询会员管理-车主司机关系列表
     */
	@RequestMapping(value = "/list",method = RequestMethod.POST)
	public JsonResult list(Integer page,Integer limit,MOwnerDriver mOwnerDriver){
        page =  page != null ? page:0;
        limit =  limit != null ?limit:10;
	    try {
            return mOwnerDriverService.list(page,limit,mOwnerDriver);
        } catch (Exception e) {
            return JsonResult.error(207,"服务器错误");
        }
    }

    /**
     * 新增保存会员管理-车主司机关系
     */

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public JsonResult add(MOwnerDriver mOwnerDriver)
    {
        try {
            return mOwnerDriverService.add(mOwnerDriver);
        } catch (Exception e) {
            return JsonResult.error(207,"服务器错误");
        }
    }

    /**
     * 修改保存会员管理-车主司机关系
     */

    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    public JsonResult edit(MOwnerDriver mOwnerDriver)
    {
        try {
            return mOwnerDriverService.edit(mOwnerDriver);
        } catch (Exception e) {
            return JsonResult.error(207,"服务器错误");
        }

    }

    /**
     * 删除会员管理-车主司机关系
     */
    @RequestMapping(value = "/remove",method = RequestMethod.POST)
    public JsonResult remove(String ids)
    {
        if (StringUtils.isBlank(ids)) {
            return JsonResult.error(201,"请传入要删除的编号");
        }
        try {
            return mOwnerDriverService.remove(ids);
        } catch (Exception e) {
            return JsonResult.error(207,"服务器错误");
        }
    }
}
