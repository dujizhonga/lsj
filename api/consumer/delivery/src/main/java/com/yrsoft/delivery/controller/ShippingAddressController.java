
package com.yrsoft.delivery.controller;
import com.yrsoft.common.exception.LSJExceptions;
import com.yrsoft.common.exception.NullParamException;
import com.yrsoft.common.utils.JsonResult;
import org.apache.servicecomb.provider.rest.common.RestSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import com.yrsoft.delivery.entity.ShippingAddress;
import com.yrsoft.delivery.service.DeliveryAddress;
import com.yrsoft.delivery.service.ShippingAddressService;


import javax.ws.rs.core.MediaType;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.CseSpringDemoCodegen", date = "2019-01-29T01:51:08.429Z")
/**
 * 收发货地址
 * @author yxq
 * @date 2019/2/25
 */
@RestSchema(schemaId = "shippingAddress")
@RequestMapping(path = "api/shippingAddress", produces = MediaType.APPLICATION_JSON)
public class ShippingAddressController {
    @Autowired
    private DeliveryAddress deliveryAddress;
    /**
     * 修改收发货地址
     * @author yxq
     * @date 2019/2/25
     */
    @RequestMapping(value = "/updateShippingAddress", method = RequestMethod.POST)
        public JsonResult updateShippingAddress(String  paramStr){
    		try {
    			//检验参数
    	    	if(paramStr==null || paramStr.equals("")){
    	    		return JsonResult.error(201, "请输入参数");
    	    	}
                return deliveryAddress.updateAddress(paramStr);
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
