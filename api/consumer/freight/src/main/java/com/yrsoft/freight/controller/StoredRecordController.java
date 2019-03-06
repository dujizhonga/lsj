package com.yrsoft.freight.controller;


import com.yrsoft.common.utils.JsonResult;
import com.yrsoft.common.utils.ParamVC;
import com.yrsoft.freight.service.StoredRecordService;

import io.swagger.util.Json;

import org.apache.servicecomb.provider.rest.common.RestSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.ws.rs.core.MediaType;

/**
 * 描述：运费储值
 * 作者：熊磊
 * 日期：20190225
 */
@RestSchema(schemaId = "storedRecordController")
@RequestMapping(path = "/api/storedRecordController", produces = MediaType.APPLICATION_JSON)
public class StoredRecordController {
    @Autowired
    private StoredRecordService storedRecordService;

    /**
     * 查询储值基本信息
     * @param paramStr
     * @return JsonResult
     */
    @RequestMapping(value = "/getStoredBaseInfomation",method = RequestMethod.POST)
    public JsonResult getStoredBaseInfomation(String paramStr){
        //参数验证
        ParamVC pvc = ParamVC.jsonValidateAndConvert(paramStr,"id");
        if(!pvc.isLegal()){
            return JsonResult.error(201,pvc.getMessage());
        }
        //获取参数
        String id=pvc.getKey("id");
        try{
            return storedRecordService.getStoredBaseInfomation(id);
        }catch (Exception e){
            e.printStackTrace();
            return JsonResult.error(207,"服务器错误");
        }

    }

    /**
     * 生成储值分配记录
     * @param paramStr
     * @return JsonResult
     */
    @RequestMapping(value = "/addStoredRecords", method = RequestMethod.POST)
    public JsonResult addStoredRecords(String paramStr){
        //参数验证
        String[] arrayStr ={"etcScale","gasScale","oilScale"};
        ParamVC pvc = ParamVC.jsonValidateAndConvert(paramStr,arrayStr,"ids");
        if(!pvc.isLegal()){
            return JsonResult.error(201,pvc.getMessage());
        }

        try{
            return storedRecordService.addStoredRecords(pvc);
        }catch (Exception e){
            e.printStackTrace();
            return JsonResult.error(207,"服务器错误");
        }
    }
    /**
     * 生产资料分配列表/
     * @param: @param paramStr
     * @param: @return
     * @return: JsonResult
     * @auther: shihh
     * @date: 2019年2月28日下午1:55:56
     */
    @RequestMapping(value = "/SelectPStoredList", method = RequestMethod.POST)
    public JsonResult SelectPStoredRecordsList(String paramStr) {
    	
    	return storedRecordService.SelectPStoredList(paramStr);	
    }
    
    /**
     * 生产资料分配列表到处
     * @param: @param paramStr
     * @param: @return
     * @return: JsonResult
     * @auther: shihh
     * @date: 2019年3月1日下午1:54:16
     */
    @RequestMapping(value = "/exportPStoredRecords",method = RequestMethod.POST)
    public JsonResult exportWaybill(String paramStr){
    	return storedRecordService.exportPStoreds(paramStr);
    }
    
  
    /*@RequestMapping(value = "/getStoredRecordsList", method = RequestMethod.POST)
    public JsonResult getStoredRecordsList(){
        //参数验证

        try{
            return storedRecordService.getStoredRecordsList();
        }catch (Exception e){
            e.printStackTrace();
            return JsonResult.error(207,"服务器错误");
        }
    }*/

}

