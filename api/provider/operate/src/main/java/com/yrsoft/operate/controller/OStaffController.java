package com.yrsoft.operate.controller;


import com.yrsoft.common.utils.JsonResult;
import com.yrsoft.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.apache.servicecomb.provider.rest.common.RestSchema;
import javax.ws.rs.core.MediaType;
import com.yrsoft.operate.entity.OStaff;
import com.yrsoft.operate.service.OStaffService;


/**
 * 运营管理-人员 信息操作处理
 * 
 * @author mz
 * @date 2019-02-23
 */
@RestSchema(schemaId = "oStaff")
@RequestMapping(path = "/test/oStaff",produces = MediaType.APPLICATION_JSON)
public class OStaffController
{

	@Autowired
	private OStaffService oStaffService;

    /**
     * 查询运营管理-人员一个
     */
	@RequestMapping(value = "/getOStaffById",method = RequestMethod.POST)
	public JsonResult getOStaffById(String id){
	    if (StringUtils.isBlank(id)){
	        return JsonResult.error(201,"请传入主键编号");
		}


		return oStaffService.getOStaffById(id);
	}


    /**
     * 查询运营管理-人员列表
     */
	@RequestMapping(value = "/list",method = RequestMethod.POST)
	public JsonResult list(Integer page,Integer limit,OStaff oStaff){
        page =  page != null ? page:0;
        limit =  limit != null ?limit:10;
	    try {
            return oStaffService.list(page,limit,oStaff);
        } catch (Exception e) {
            return JsonResult.error(207,"服务器错误");
        }
    }

    /**
     * 新增保存运营管理-人员
     */

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public JsonResult add(OStaff oStaff)
    {
        try {
            return oStaffService.add(oStaff);
        } catch (Exception e) {
            return JsonResult.error(207,"服务器错误");
        }
    }

    /**
     * 修改保存运营管理-人员
     */

    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    public JsonResult edit(OStaff oStaff)
    {
        try {
            return oStaffService.edit(oStaff);
        } catch (Exception e) {
            return JsonResult.error(207,"服务器错误");
        }

    }

    /**
     * 删除运营管理-人员
     */
    @RequestMapping(value = "/remove",method = RequestMethod.POST)
    public JsonResult remove(String ids)
    {
        if (StringUtils.isBlank(ids)) {
            return JsonResult.error(201,"请传入要删除的编号");
        }
        try {
            return oStaffService.remove(ids);
        } catch (Exception e) {
            return JsonResult.error(207,"服务器错误");
        }
    }
}
