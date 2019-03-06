package com.yrsoft.freight.controller;



import javax.ws.rs.core.MediaType;

import org.apache.servicecomb.provider.rest.common.RestSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yrsoft.common.utils.JsonResult;
import com.yrsoft.common.utils.ParamVC;
import com.yrsoft.freight.service.InvoiceService;


@javax.annotation.Generated(value = "io.swagger.codegen.languages.CseSpringDemoCodegen", date = "2019-01-29T01:51:08.429Z")

@RestSchema(schemaId = "invoiceController")
@RequestMapping(path = "/api/invoiceController", produces = MediaType.APPLICATION_JSON)
public class InvoiceController{

    @Autowired
    private InvoiceService invoiceService;
    /**
     * 货运单列表
     * @param page 当前页
     * @param limit 页大小
     * @param pInvoice 查询对象
     * @return json返回结果对象
     */
    @RequestMapping(value = "/selectByPage",method = RequestMethod.POST)
    public JsonResult selectByPage(String paramStr){
    	return invoiceService.selectByPage(paramStr);
    }
    
    /**
     * 货运单详情查询
     * @param id 货运单id
     * @return json结果对象
     */
    @RequestMapping(value = "/selectDeatial",method = RequestMethod.POST)
    public JsonResult selectDeatial(String paramStr){
    	return invoiceService.selectDeatial(paramStr);
    }
    
    /**
     * 车辆历史坐标
     * @param page 当前页
     * @param limit 页大小
     * @param poCarPositionLog 车辆历史坐标对象
     * @return json返回对象
     */
    @RequestMapping(value = "/selectCarPositionLog",method = RequestMethod.POST)
    public JsonResult selectCarPositionLog(String paramStr){
    	return invoiceService.selectCarPositionLog(paramStr);
    }
    
    
    /**
     * 运单导出
     * @param paramStr 导出参数（id，waybillNumber,ownerName,ownerPhon,deliveryTime,confirmReceiptTime）
     * @param response 相应参数
     * @return
     */
    @RequestMapping(value = "/exportWaybill",method = RequestMethod.POST)
    public JsonResult exportWaybill(String paramStr){
    	return invoiceService.exportWaybill(paramStr);
    }
    
    /**
     * 货运单导出
     * @param paramStr 导出参数（id、invoiceNumber，startAddress，arriveAddress，createTime，endTime，status）
     * @param response 相应参数
     * @return
     */
    @RequestMapping(value = "/exportInvoice",method = RequestMethod.POST)
    public JsonResult exportInvoice(String paramStr){
    	return invoiceService.exportInvoice(paramStr);
    }
    
    
	/**
	 * 货运管理--货运单列表信息
	 * @param paraStr
	 * @return:JsonResult
	 * @author:DU'JZ
	 * @data:2019年2月27日 下午2:33:08 
	 * @throws
	 */
    @RequestMapping(value = "/selectInvoiceInfoList",method = RequestMethod.POST)
	public JsonResult selectInvoiceInfoList(String paramStr){
		return invoiceService.selectInvoiceInfoList(paramStr);
	}
    
    /**
     * 删除货运单
     * @param paramStr
     * @return:JsonResult
     * @author:DU'JZ
     * @data:2019年2月27日 下午5:09:54 
     * @throws
     */
    @RequestMapping(value = "/deleteInvoiceById",method = RequestMethod.POST)
    public JsonResult deleteInvoiceById(String paramStr) {
    	return invoiceService.deleteInvoiceById(paramStr);
    }
    
	/**
	 * 货运管理--我的货运列表表信息
	 * @param paraStr
	 * @return:JsonResult
	 * @author:DU'JZ
	 * @data:2019年2月27日 下午2:33:08 
	 * @throws
	 */
    @RequestMapping(value = "/selectMyInvoiceInfo",method = RequestMethod.POST)
	public JsonResult selectMyInvoiceInfo(String paramStr){
		return invoiceService.selectMyInvoiceInfo(paramStr);
	}
	
	 /**
     * 查询运货中和已送达货运单数
     * @param id
     * @return
     */
    @RequestMapping(value = "/selectPInvoiceNumByState",method = RequestMethod.POST)
    public JsonResult selectPInvoiceNumByState(String paramStr) {
        //参数验证
        ParamVC pvc = ParamVC.jsonValidateAndConvert(paramStr, "id");
        if (!pvc.isLegal()) {
            return JsonResult.error(201, pvc.getMessage());
        }
        //获取参数
        String id = pvc.getKey("id");
        try {
            return invoiceService.selectPInvoiceNumByState(id);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.error(207, "服务器错误");
        }
    }
    
    
    /**
     * 一键收货
     * @param page 当前页
     * @param limit 页大小
     * @param poCarPositionLog 车辆历史坐标对象
     * @return json返回对象
     */
    @RequestMapping(value = "/takeDelivery",method = RequestMethod.POST)
    public JsonResult takeDelivery(String paraStr){
    	return invoiceService.takeDelivery(paraStr);
    }
    
    /**
     * 一键收货页面查询
     * @param page 当前页
     * @param limit 页大小
     * @param poCarPositionLog 车辆历史坐标对象
     * @return json返回对象
     */
    @RequestMapping(value = "/selectFreighPay",method = RequestMethod.POST)
    public JsonResult selectFreighPay(String page){
    	return invoiceService.selectFreighPay(page);
    }    
    
    /**
     * 消息点击跳转信息查询
     * @param page 当前页
     * @param limit 页大小
     * @param poCarPositionLog 车辆历史坐标对象
     * @return json返回对象
     */
    @RequestMapping(value = "/queryForMessageJump",method = RequestMethod.POST)
    public JsonResult queryForMessageJump(String params){
    	return invoiceService.queryForMessageJump(params);
    }
    
}
