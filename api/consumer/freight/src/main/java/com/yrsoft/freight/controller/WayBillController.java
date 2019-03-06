package com.yrsoft.freight.controller;

import javax.ws.rs.core.MediaType;

import org.apache.servicecomb.provider.rest.common.RestSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yrsoft.common.utils.JsonResult;
import com.yrsoft.freight.entity.WayBill;
import com.yrsoft.freight.service.WayBillService;

/**
 * 
 * @auther: Guohaolong
 * @date: 2019年2月25日 下午2:13:04
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.CseSpringDemoCodegen", date = "2019-01-29T01:51:08.429Z")
@RestSchema(schemaId = "wayBillController")
@RequestMapping(path = "/api/wayBill",produces = MediaType.APPLICATION_JSON)
public class WayBillController {
	
	    @Autowired
	    private WayBillService wayBillService;
	    /**
	     * 
	     * 运单列表
	     * @param page 当前页
	     * @param limit 页大小
	     * @param wayBill 查询对象
	     * @return json返回结果对象
	     */
	    @RequestMapping(value = "/selectByPage",method = RequestMethod.POST)
	    public JsonResult selectByPage(Integer page,Integer limit,WayBill wayBill){
			return wayBillService.selectByPage(page, limit, wayBill);	    	
	    }
	    
	    /**
	     * 
	     * 运单详情
	     * @param page 当前页
	     * @param limit 页大小
	     * @param id 查询对象
	     * @return json返回结果对象
	     */
	    @RequestMapping(value = "/queryById",method = RequestMethod.POST)
	    public JsonResult queryById(String paraStr){
			return wayBillService.queryById(paraStr);	    	
	    }
	    
	    	  
}
