package com.yrsoft.delivery.controller;
import org.apache.servicecomb.provider.rest.common.RestSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSONObject;
import com.yrsoft.common.utils.JsonResult;
import com.yrsoft.delivery.service.OwnerInfoService;

import javax.ws.rs.core.MediaType;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.CseSpringDemoCodegen", date = "2019-01-29T01:51:08.429Z")
/**
 * 车主信息详情查询接口
 * @author lu
 * @date 2019/2/26
 */
@RestSchema(schemaId = "ownerInfos")
@RequestMapping(path = "/api/ownerInfos", produces = MediaType.APPLICATION_JSON)
public class OwnerInfoControllerImpl{

    @Autowired
    private OwnerInfoService ownerInfoService;

    /**
    *
    * 功能描述: 车主信息详情查询接口
    *
    * @param: page:页数 必填
    *         limit:条数 必填
    *         shipperId:货主id 必填
    *         ownerId:车主id  必填
    *         type:查询类型：0：货主下的车主的运单信息  1：货主下的车主的车辆信息 必填
    *         waybillNumber：运单编号
    *         ownerName:车主名称
    *         telephone:车主电话
    *         startTime:起始时间
    *         endTime:结束时间
    *         waybillState:运单状态: 0-未发货 1-已发货 2-已送达 3-已收货 4-已撤销
    *         flag:运单类型  （0.指派单  1.系统单 ）
    *         carNumber:车牌号码
    * @return: 
    * @auther: lu
    * @date: 2019/2/26
    */
    @RequestMapping(value = "/getOwnerInfo", 
        method = RequestMethod.POST)
    public JsonResult getOwnerInfo(String paramStr){
    	//检验参数
    	if(paramStr==null || paramStr.equals("")){
    		return JsonResult.error(201, "请输入参数");
    	}
        return ownerInfoService.getOwnerInfo(paramStr);
    }
}
