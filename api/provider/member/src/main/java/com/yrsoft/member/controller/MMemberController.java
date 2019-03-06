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
import com.yrsoft.member.entity.MMember;
import com.yrsoft.member.service.MMemberService;


/**
 * 会员管理-会员 信息操作处理
 * 
 * @author mz
 * @date 2019-02-23
 */
@RestSchema(schemaId = "mMember")
@RequestMapping(path = "/provider/mMember",produces = MediaType.APPLICATION_JSON)
public class MMemberController
{

	@Autowired
	private MMemberService mMemberService;

    /**
     * 查询会员管理-会员一个
     */
	@RequestMapping(value = "/getMMemberById",method = RequestMethod.POST)
	public JsonResult getMMemberById(String id){
	    if (StringUtils.isBlank(id)){
	        return JsonResult.error(201,"请传入主键编号");
		}


		return mMemberService.getMMemberById(id);
	}


    /**
     * 查询会员管理-会员列表
     */
	@RequestMapping(value = "/list",method = RequestMethod.POST)
	public JsonResult list(Integer page,Integer limit,MMember mMember){
        page =  page != null ? page:0;
        limit =  limit != null ?limit:10;
	    try {
            return mMemberService.list(page,limit,mMember);
        } catch (Exception e) {
            return JsonResult.error(207,"服务器错误");
        }
    }

    /**
     * 新增保存会员管理-会员
     */

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public JsonResult add(MMember mMember)
    {
        try {
            return mMemberService.add(mMember);
        } catch (Exception e) {
            return JsonResult.error(207,"服务器错误");
        }
    }

    /**
     * 修改保存会员管理-会员
     */

    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    public JsonResult edit(MMember mMember)
    {
        try {
            return mMemberService.edit(mMember);
        } catch (Exception e) {
            return JsonResult.error(207,"服务器错误");
        }

    }

    /**
     * 删除会员管理-会员
     */
    @RequestMapping(value = "/remove",method = RequestMethod.POST)
    public JsonResult remove(String ids)
    {
        if (StringUtils.isBlank(ids)) {
            return JsonResult.error(201,"请传入要删除的编号");
        }
        try {
            return mMemberService.remove(ids);
        } catch (Exception e) {
            return JsonResult.error(207,"服务器错误");
        }
    }
}