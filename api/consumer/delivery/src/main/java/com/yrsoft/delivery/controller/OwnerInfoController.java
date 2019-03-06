package com.yrsoft.delivery.controller;

import javax.ws.rs.core.MediaType;

import org.apache.servicecomb.provider.rest.common.RestSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSONObject;
import com.yrsoft.common.exception.LSJExceptions;
import com.yrsoft.common.exception.NullParamException;
import com.yrsoft.common.utils.JsonResult;
import com.yrsoft.common.utils.StringUtils;
import com.yrsoft.delivery.service.OwnerInfoService;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.CseSpringDemoCodegen", date = "2019-01-29T01:51:08.429Z")
/**
 * @deprecated 车主信息管理
 * @author Yxq
 * @date 2019/2/25
 */
@RestSchema(schemaId = "ownerInfo")
@RequestMapping(path = "api/ownerInfo", produces = MediaType.APPLICATION_JSON)
public class OwnerInfoController {
	@Autowired
	private OwnerInfoService ownerInfoService;
	/**
     * 查询车主信息
     *
     * @param ids
     * @return
     */
    @RequestMapping(value = "/selectOwnerInfo", method = RequestMethod.POST)
    public JsonResult selectOwnerInfo( String paramStr) {
    	try {
    		//检验参数
	    	if(paramStr==null || paramStr.equals("")){
	    		return JsonResult.error(201, "请输入参数");
	    	}
			JSONObject jsonObject = JSONObject.parseObject(paramStr);
			String shipperId = jsonObject.getString("shipperId");
			Integer page = jsonObject.getInteger("page");
			Integer limit = jsonObject.getInteger("limit");
			if(shipperId ==null || shipperId.equals("")){
	    		return JsonResult.error(201, "请输入货主id");
	    	}
			if(null == page || null == limit ) {
				return JsonResult.error(201,"请传分页参数");
			}
			if(page<0 || limit < 0) {
				return JsonResult.error(201, "分页参数错误");
			}
            return ownerInfoService.selectOwnerInfo(page, limit,shipperId);
        } catch (NullParamException nullParamException) {
            return JsonResult.error(201, nullParamException.getMessage());
        } catch (LSJExceptions lsjExceptions) {
            return JsonResult.error(lsjExceptions.getCode(), lsjExceptions.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.error(500, "[系统异常]");
        }
    }
}

