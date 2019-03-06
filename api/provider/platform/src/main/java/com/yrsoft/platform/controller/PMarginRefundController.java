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
import com.yrsoft.platform.entity.PMarginRefund;
import com.yrsoft.platform.service.PMarginRefundService;


/**
 * 货运-保证金退款申请 信息操作处理
 * 
 * @author mz
 * @date 2019-02-23
 */
@RestSchema(schemaId = "pMarginRefund")
@RequestMapping(path = "/provider/pMarginRefund",produces = MediaType.APPLICATION_JSON)
public class PMarginRefundController
{

	@Autowired
	private PMarginRefundService pMarginRefundService;

    /**
     * 查询货运-保证金退款申请一个
     */
	@RequestMapping(value = "/getPMarginRefundById",method = RequestMethod.POST)
	public JsonResult getPMarginRefundById(String id){
	    if (StringUtils.isBlank(id)){
	        return JsonResult.error(201,"请传入主键编号");
		}


		return pMarginRefundService.getPMarginRefundById(id);
	}


    /**
     * 查询货运-保证金退款申请列表
     */
	@RequestMapping(value = "/list",method = RequestMethod.POST)
	public JsonResult list(Integer page,Integer limit,PMarginRefund pMarginRefund){
        page =  page != null ? page:0;
        limit =  limit != null ?limit:10;
	    try {
            return pMarginRefundService.list(page,limit,pMarginRefund);
        } catch (Exception e) {
            return JsonResult.error(207,"服务器错误");
        }
    }

    /**
     * 新增保存货运-保证金退款申请
     */

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public JsonResult add(PMarginRefund pMarginRefund)
    {
        try {
            return pMarginRefundService.add(pMarginRefund);
        } catch (Exception e) {
            return JsonResult.error(207,"服务器错误");
        }
    }

    /**
     * 修改保存货运-保证金退款申请
     */

    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    public JsonResult edit(PMarginRefund pMarginRefund)
    {
        try {
            return pMarginRefundService.edit(pMarginRefund);
        } catch (Exception e) {
            return JsonResult.error(207,"服务器错误");
        }

    }

    /**
     * 删除货运-保证金退款申请
     */
    @RequestMapping(value = "/remove",method = RequestMethod.POST)
    public JsonResult remove(String ids)
    {
        if (StringUtils.isBlank(ids)) {
            return JsonResult.error(201,"请传入要删除的编号");
        }
        try {
            return pMarginRefundService.remove(ids);
        } catch (Exception e) {
            return JsonResult.error(207,"服务器错误");
        }
    }
}
