package com.yrsoft.finance.controller;

import com.yrsoft.common.utils.JsonResult;
import com.yrsoft.common.utils.StringUtils;
import com.yrsoft.finance.entity.MRecharge;
import com.yrsoft.finance.service.MRechargeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.apache.servicecomb.provider.rest.common.RestSchema;

import javax.ws.rs.core.MediaType;
/**
 * 会员管理-充值记录 信息操作处理
 * 
 * @author mz
 * @date 2019-02-23
 */
@RestSchema(schemaId = "mRecharge")
@RequestMapping(path = "/provider/mRecharge",produces = MediaType.APPLICATION_JSON)
public class MRechargeController
{

	@Autowired
	private MRechargeService mRechargeService;

    /**
     * 查询会员管理-充值记录一个
     */
	@RequestMapping(value = "/getMRechargeById",method = RequestMethod.POST)
	public JsonResult getMRechargeById(String id){
	    if (StringUtils.isBlank(id)){
	        return JsonResult.error(201,"请传入主键编号");
		}


		return mRechargeService.getMRechargeById(id);
	}


    /**
     * 查询会员管理-充值记录列表
     */
	@RequestMapping(value = "/list",method = RequestMethod.POST)
	public JsonResult list(Integer page,Integer limit,String memberId){
		MRecharge mRecharge = new MRecharge();
		mRecharge.setMemberId(memberId);
		mRecharge.setState(1);
	    try {
            return mRechargeService.list(page,limit,mRecharge);
        } catch (Exception e) {
            return JsonResult.error(207,"服务器错误");
        }
    }

    /**
     * 新增保存会员管理-充值记录
     */

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public JsonResult add(MRecharge mRecharge)
    {
        try {
            return mRechargeService.add(mRecharge);
        } catch (Exception e) {
            return JsonResult.error(207,"服务器错误");
        }
    }

    /**
     * 修改保存会员管理-充值记录
     */

    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    public JsonResult edit(MRecharge mRecharge)
    {
        try {
            return mRechargeService.edit(mRecharge);
        } catch (Exception e) {
            return JsonResult.error(207,"服务器错误");
        }

    }

    /**
     * 删除会员管理-充值记录
     */
    @RequestMapping(value = "/remove",method = RequestMethod.POST)
    public JsonResult remove(String ids)
    {
        if (StringUtils.isBlank(ids)) {
            return JsonResult.error(201,"请传入要删除的编号");
        }
        try {
            return mRechargeService.remove(ids);
        } catch (Exception e) {
            return JsonResult.error(207,"服务器错误");
        }
    }
    
}
