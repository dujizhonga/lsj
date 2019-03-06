package com.yrsoft.tripartite.controller;

import com.yrsoft.common.utils.JsonResult;
import com.yrsoft.common.utils.ParamVC;
import com.yrsoft.tripartite.service.BoHaiInsuranceService;
import org.apache.servicecomb.provider.rest.common.RestSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.ws.rs.core.MediaType;

@RestSchema(schemaId = "boHaiInsuranceController")
@RequestMapping(path = "/api/boHaiInsuranceController", produces = MediaType.APPLICATION_JSON)
public class BoHaiInsuranceController {
    @Autowired
    private BoHaiInsuranceService boHaiInsuranceService;

    @RequestMapping(value = "/insure",method = RequestMethod.POST)
    public JsonResult insure(String paramStr) {
        //参数验证
        ParamVC pvc = ParamVC.jsonValidateAndConvert(paramStr,"id");
        if(!pvc.isLegal()){
            return JsonResult.error(201,pvc.getMessage());
        }
        //获取参数
        String id=pvc.getKey("id");
        try{
            return boHaiInsuranceService.insure(id);
        }catch (Exception e){
            e.printStackTrace();
            return JsonResult.error(207,"服务器错误");
        }
    }
}
