package com.yrsoft.platform.controller;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.core.MediaType;

import org.apache.servicecomb.provider.rest.common.RestSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yrsoft.common.utils.JsonResult;
import com.yrsoft.common.utils.StringUtils;
import com.yrsoft.platform.entity.PInvoice;
import com.yrsoft.platform.entity.PInvoiceVo;
import com.yrsoft.platform.service.PInvoiceService;


/**
 * 货运-货运单 信息操作处理
 * 
 * @author mz
 * @date 2019-02-23
 */
@RestSchema(schemaId = "pInvoice")
@RequestMapping(path = "/provider/pInvoice",produces = MediaType.APPLICATION_JSON)
public class PInvoiceController
{

	@Autowired
	private PInvoiceService pInvoiceService;

    /**
     * 查询货运-货运单一个
     */
	@RequestMapping(value = "/getPInvoiceById",method = RequestMethod.POST)
	public JsonResult getPInvoiceById(String id){
	    if (StringUtils.isBlank(id)){
	        return JsonResult.error(201,"请传入主键编号");
		}


		return pInvoiceService.getPInvoiceById(id);
	}


    /**
     * 查询货运-货运单列表
     */
	@RequestMapping(value = "/list",method = RequestMethod.POST)
	public JsonResult list(Integer page,Integer limit,PInvoice pInvoice){
        page =  page != null ? page:0;
        limit =  limit != null ?limit:10;
	    try {
            return pInvoiceService.list(page,limit,pInvoice);
        } catch (Exception e) {
        	e.printStackTrace();
            return JsonResult.error(207,"服务器错误");
        }
    }
	
	/**
     * 查询货运-货运单列表不分页
     */
	@RequestMapping(value = "/invoiceList",method = RequestMethod.POST)
	public JsonResult invoiceList(PInvoice pInvoice){
	    try {
            return pInvoiceService.list(pInvoice);
        } catch (Exception e) {
        	e.printStackTrace();
            return JsonResult.error(207,"服务器错误");
        }
    }

    /**
     * 新增保存货运-货运单
     */

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public JsonResult add(PInvoice pInvoice)
    {
        try {
            return pInvoiceService.add(pInvoice);
        } catch (Exception e) {
        	e.printStackTrace();
            return JsonResult.error(207,"服务器错误");
        }
    }

    /**
     * 修改保存货运-货运单
     */

    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    public JsonResult edit(PInvoice pInvoice)
    {
        try {
            return pInvoiceService.edit(pInvoice);
        } catch (Exception e) {
        	e.printStackTrace();
            return JsonResult.error(207,"服务器错误");
        }

    }

    /**
     * 删除货运-货运单
     */
    @RequestMapping(value = "/remove",method = RequestMethod.POST)
    public JsonResult remove(String ids)
    {
        if (StringUtils.isBlank(ids)) {
            return JsonResult.error(201,"请传入要删除的编号");
        }
        try {
            return pInvoiceService.remove(ids);
        } catch (Exception e) {
        	e.printStackTrace();
            return JsonResult.error(207,"服务器错误");
        }
    }
    
    /**
     * 货运管理-货运单列表
     */
	@RequestMapping(value = "/selectInvoice",method = RequestMethod.POST)
	public JsonResult selectInvoice(Integer page,Integer limit,PInvoiceVo pInvoiceVo){
        page =  page != null ? page:0;
        limit =  limit != null ?limit:10;
	    try {
            return pInvoiceService.selectInvoice(page,limit,pInvoiceVo);
        } catch (Exception e) {
        	e.printStackTrace();
            return JsonResult.error(207,"服务器错误");
        }
    }
	
    
    /**
     * 货运管理-我的货运
     */
	@RequestMapping(value = "/myPInvoiceInfo",method = RequestMethod.POST)
	public JsonResult myPInvoiceInfo(Integer page,Integer limit,PInvoiceVo pInvoiceVo){
        page =  page != null ? page:0;
        limit =  limit != null ?limit:10;
	    try {
            return pInvoiceService.myPInvoiceInfo(page, limit, pInvoiceVo);
        } catch (Exception e) {
        	e.printStackTrace();
            return JsonResult.error(207,"服务器错误");
        }
    }
	
	/**
     * 查询运货中和已送达货运单数
     * @param id
     * @return
     */
    @RequestMapping(value = "/selectPInvoiceNumByState",method = RequestMethod.POST)
    public JsonResult selectPInvoiceNumByState(String id){
        if (StringUtils.isBlank(id)) {
            return JsonResult.error(201,"请传入货主id");
        }
        try {
            return pInvoiceService.selectPInvoiceNumByState(id);
        } catch (Exception e) {
        	e.printStackTrace();
            return JsonResult.error(207,"服务器错误");
        }
    }
    /**
     * 查询货主名下车主运单数-货运单
     * 
     * @param pInvoice 货运-货运单信息
     * @return 结果
     */
	@RequestMapping(value = "/selectWaybillCount",method = RequestMethod.POST)
	public JsonResult selectWaybillCount(String shipperId,String ownerId){
	    if (StringUtils.isBlank(shipperId)){
	        return JsonResult.error(201,"请传入货主id");
		}
	    if (StringUtils.isBlank(ownerId)){
	        return JsonResult.error(201,"请传入车主id");
		}
		return pInvoiceService.selectWaybillCount(shipperId, ownerId);
	}
    
    /**
     * 查询货运单地址
     * 
     * @param 货主id 
     * @return 货运-货运单地址
     */
	@RequestMapping(value = "/selectInvoiceAddress",method = RequestMethod.POST)
	public JsonResult selectInvoiceAddress(String shipperId){
	    if (StringUtils.isBlank(shipperId)){
	        return JsonResult.error(201,"请传入货主ID");
		}
		return pInvoiceService.selectInvoiceAddress(shipperId);
	}

    
}
