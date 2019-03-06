package com.yrsoft.delivery.controller;

import com.alibaba.fastjson.JSONObject;
import com.yrsoft.common.exception.LSJExceptions;
import com.yrsoft.common.exception.NullParamException;
import com.yrsoft.common.utils.JsonResult;
import com.yrsoft.delivery.entity.PInvoice;
import com.yrsoft.delivery.service.InvoiceService;
import org.apache.servicecomb.provider.rest.common.RestSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.ws.rs.core.MediaType;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.CseSpringDemoCodegen", date = "2019-01-29T01:51:08.429Z")
/**
 * @deprecated 货运单管理
 * @author Yxq
 * @date 2019/2/25
 */
@RestSchema(schemaId = "invoice")
@RequestMapping(path = "api/invoice", produces = MediaType.APPLICATION_JSON)
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;
    /**
     * 新增货运单
     *
     * @param address
     * @return
     */
    @RequestMapping(value = "/saveInvoice",method = RequestMethod.POST)
        public JsonResult saveInvoice(String  paramStr){
		try {
			//检验参数
	    	if(paramStr==null || paramStr.equals("")){
	    		return JsonResult.error(201, "请输入参数");
	    	}
            return invoiceService.saveInvoice(paramStr);
        } catch (NullParamException nullParamException) {
            return JsonResult.error(201, nullParamException.getMessage());
        } catch (LSJExceptions lsjExceptions) {
            return JsonResult.error(lsjExceptions.getCode(), lsjExceptions.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.error(500, "[系统异常]");
        }
	}
    
    /**
     * 查询货运单的默认地址
     *
     * @param address
     * @return
     */
    @RequestMapping(value = "/selectInvoiceAddress",method = RequestMethod.POST)
        public JsonResult selectInvoiceAddress(@RequestParam("paramStr") String paramStr){
		try {
			//检验参数
	    	if(paramStr==null || paramStr.equals("")){
	    		return JsonResult.error(201, "请输入参数");
	    	}
			JSONObject jsonObject = JSONObject.parseObject(paramStr);
			String shipperId = jsonObject.getString("shipperId");
            return invoiceService.selectInvoiceAddress(shipperId);
        } catch (NullParamException nullParamException) {
            return JsonResult.error(201, nullParamException.getMessage());
        } catch (LSJExceptions lsjExceptions) {
            return JsonResult.error(lsjExceptions.getCode(), lsjExceptions.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.error(500, "[系统异常]");
        }
	}
    
    /**
     * 查询货运单详情
     *
     * @param id  货运单id
     * @return
     */
    @RequestMapping(value = "/selectInvoiceInfo",method = RequestMethod.POST)
        public JsonResult selectInvoiceInfo(@RequestParam("paramStr") String paramStr){
    	
    	//检验参数
    	if(paramStr==null || paramStr.equals("")){
    		return JsonResult.error(201, "请输入参数");
    	}
            return invoiceService.selectInvoiceInfo(paramStr);
	}
}
