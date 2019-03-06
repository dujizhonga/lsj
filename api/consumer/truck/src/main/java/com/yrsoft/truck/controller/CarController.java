package com.yrsoft.truck.controller;
import javax.ws.rs.core.MediaType;

import org.apache.servicecomb.provider.rest.common.RestSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.yrsoft.common.exception.LSJExceptions;
import com.yrsoft.common.exception.NullParamException;
import com.yrsoft.common.utils.JsonResult;
import com.yrsoft.truck.service.CarService;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.CseSpringDemoCodegen", date = "2019-01-29T01:51:08.429Z")
/**
 * 查询所有自有车位置及基本信息
 * @author yxq
 * @date 2019/2/25
 */
@RestSchema(schemaId = "car")
@RequestMapping(path = "/api/car", produces = MediaType.APPLICATION_JSON)
public class CarController{

    @Autowired
    private CarService carService;

    /**
     * 查询车辆信息及坐标
     *
     * @param ids
     * @return
     */
    @PostMapping("/selectCarByShipperId")
    public JsonResult selectCarByShipperId (@RequestParam("paramStr") String paramStr){
		
		try {
			
            return carService.selectCarByShipperId(paramStr);
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
