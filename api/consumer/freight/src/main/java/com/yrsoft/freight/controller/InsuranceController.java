package com.yrsoft.freight.controller;

import com.yrsoft.common.utils.JsonResult;
import com.yrsoft.common.utils.ParamVC;
import com.yrsoft.freight.service.InsuranceService;
import org.apache.servicecomb.provider.rest.common.RestSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.ws.rs.core.MediaType;

/**
 * 描述：
 * 作者：熊磊
 * 日期：20190225
 */
@RestSchema(schemaId = "insuranceController")
@RequestMapping(path = "/api/insuranceController", produces = MediaType.APPLICATION_JSON)
public class InsuranceController {
    @Autowired
    private InsuranceService insuranceService;

    /**
     * 计算保险费
     * @param paramStr
     * @return
     */
    @RequestMapping(value = "/getInsuranceAmount",method = RequestMethod.POST)
    public JsonResult getInsuranceAmount(String paramStr){
        //参数验证
        ParamVC pvc = ParamVC.jsonValidateAndConvert(paramStr,"routeRange");
        if(!pvc.isLegal()){
            return JsonResult.error(201,pvc.getMessage());
        }
        //获取参数
        String routeRange=pvc.getKey("routeRange");
        try{
            return insuranceService.getInsuranceAmount(routeRange);
        }catch (Exception e){
            e.printStackTrace();
            return JsonResult.error(207,"服务器错误");
        }
    }

    /**
     * 查询保险费规则
     * @param paramStr
     * @return
     */
    @RequestMapping(value = "/selectInsuranceRule",method = RequestMethod.POST)
    public JsonResult selectInsuranceRule(String paramStr){
        //参数验证
        ParamVC pvc = ParamVC.jsonValidateAndConvert(paramStr,"type");
        if(!pvc.isLegal()){
            return JsonResult.error(201,pvc.getMessage());
        }
        //获取参数
        String type=pvc.getKey("type");
        try{
            return insuranceService.selectInsuranceRule(type);
        }catch (Exception e){
            e.printStackTrace();
            return JsonResult.error(207,"服务器错误");
        }
    }



}
