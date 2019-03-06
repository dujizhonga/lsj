package com.yrsoft.delivery.controller;

import com.yrsoft.common.exception.LSJExceptions;
import com.yrsoft.common.exception.NullParamException;
import com.yrsoft.common.json.JSONObject;
import com.yrsoft.common.utils.JsonResult;
import com.yrsoft.delivery.entity.Address;
import com.yrsoft.delivery.entity.ShippingAddress;
import com.yrsoft.delivery.service.DeliveryAddress;
import com.yrsoft.delivery.vo.DoubleAddressVO;
import org.apache.servicecomb.provider.rest.common.RestSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.MediaType;

/**
 * @author Yhq
 * @date 2019/2/25 10:55
 */
@RestSchema(schemaId = "address")
@RequestMapping(path = "api/address", produces = MediaType.APPLICATION_JSON)
public class AddressController {

    @Autowired
    private DeliveryAddress deliveryAddress;

    /**
     * 添加收发货地址
     *
     * @param paramStr
     * @return
     */
    @PostMapping("post/addr")
    public JsonResult getBondAndAddress(@RequestParam("paramStr") String paramStr) {
        try {
            Address address = JSONObject.paramStrToBean(paramStr, Address.class, true);
            return JsonResult.success(deliveryAddress.saveAddress(address));
        } catch (NullParamException nullParamException) {
            return JsonResult.error(nullParamException.getCode(), nullParamException.getMessage());
        } catch (LSJExceptions lsjExceptions) {
            return JsonResult.error(lsjExceptions.getCode(), lsjExceptions.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.error(500, "[系统异常]");
        }
    }

    /**
     * 首次添加
     * @param paramStr
     * @return
     */
    @PostMapping("post/first/address")
    public JsonResult postFirstBondAndAddress(String paramStr) {
        try {
            DoubleAddressVO address = JSONObject.paramStrToBean(paramStr, DoubleAddressVO.class, true);
            return JsonResult.success(deliveryAddress.firstSaveAddress(address));
        } catch (NullParamException nullParamException) {
            return JsonResult.error(nullParamException.getCode(), nullParamException.getMessage());
        } catch (LSJExceptions lsjExceptions) {
            return JsonResult.error(lsjExceptions.getCode(), lsjExceptions.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.error(500, "[系统异常]");
        }
    }
}
