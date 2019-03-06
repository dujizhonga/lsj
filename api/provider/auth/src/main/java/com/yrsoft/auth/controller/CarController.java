package com.yrsoft.auth.controller;


import com.yrsoft.common.utils.JsonResult;
import com.yrsoft.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.apache.servicecomb.provider.rest.common.RestSchema;
import javax.ws.rs.core.MediaType;
import com.yrsoft.auth.entity.Car;
import com.yrsoft.auth.service.CarService;


/**
 * 认证管理-车辆认证 信息操作处理
 * 
 * @author mz
 * @date 2019-02-23
 */
@RestSchema(schemaId = "car")
@RequestMapping(path = "/provider/car",produces = MediaType.APPLICATION_JSON)
public class CarController
{

	@Autowired
	private CarService carService;

    /**
     * 查询认证管理-车辆认证一个
     */
	@RequestMapping(value = "/getCarById",method = RequestMethod.POST)
	public JsonResult getCarById(String id){
	    if (StringUtils.isBlank(id)){
	        return JsonResult.error(201,"请传入主键编号");
		}


		return carService.getCarById(id);
	}
	
	/**
     * 查询认证管理-车辆认证一个
     */
	@RequestMapping(value = "/getCarByIds",method = RequestMethod.POST)
	public JsonResult getCarByIds(String id){
	    if (StringUtils.isBlank(id)){
	        return JsonResult.error(201,"请传入主键编号");
		}
		return carService.getCarByIds(id);
	}
	
	/**
     * 查询车辆信息根据车主id
     */
	@RequestMapping(value = "/selectCarByOwnerId",method = RequestMethod.POST)
	public JsonResult selectCarByOwnerId(Integer page,Integer limit,String ownerId,String telephone,String ownerName,String carNumber){
		page =  page != null ? page:0;
        limit =  limit != null ?limit:10;
		if (StringUtils.isBlank(ownerId)){
	        return JsonResult.error(201,"请传入车主id主键编号");
		}
		return carService.selectCarByOwnerId(page,limit,ownerId,telephone,ownerName,carNumber);
	}


    /**
     * 查询认证管理-车辆认证列表
     */
	@RequestMapping(value = "/list",method = RequestMethod.POST)
	public JsonResult list(Integer page,Integer limit,Car car){
        page =  page != null ? page:0;
        limit =  limit != null ?limit:10;
	    try {
            return carService.list(page,limit,car);
        } catch (Exception e) {
            return JsonResult.error(207,"服务器错误");
        }
    }

    /**
     * 新增保存认证管理-车辆认证
     */

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public JsonResult add(Car car)
    {
        try {
            return carService.add(car);
        } catch (Exception e) {
            return JsonResult.error(207,"服务器错误");
        }
    }

    /**
     * 修改保存认证管理-车辆认证
     */

    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    public JsonResult edit(Car car)
    {
        try {
            return carService.edit(car);
        } catch (Exception e) {
            return JsonResult.error(207,"服务器错误");
        }

    }

    /**
     * 删除认证管理-车辆认证
     */
    @RequestMapping(value = "/remove",method = RequestMethod.POST)
    public JsonResult remove(String ids)
    {
        if (StringUtils.isBlank(ids)) {
            return JsonResult.error(201,"请传入要删除的编号");
        }
        try {
            return carService.remove(ids);
        } catch (Exception e) {
            return JsonResult.error(207,"服务器错误");
        }
    }
    
    /**
     * 通过货主id查询车辆信息和坐标位置
     *
     * @param param
     * @return 结果
     */
    @RequestMapping(value = "/selectSysCarInfo",method = RequestMethod.POST)
    public JsonResult selectSysCarInfo(String shipperId)
    {
        if (StringUtils.isBlank(shipperId)) {
            return JsonResult.error(201,"请传入货主的编号");
        }
        try {
            return carService.selectSysCarInfo(shipperId);
        } catch (Exception e) {
            return JsonResult.error(207,"服务器错误");
        }
    }
    /**
     * 通过货主id查询车辆信息(分页)
     *
     * @param param
     * @return 结果
     */
    @RequestMapping(value = "/selectCarsInfo",method = RequestMethod.POST)
    public JsonResult selectCarsInfo(Integer page,Integer limit,String shipperId,String carNumber)
    {
    	page =  page != null ? page:0;
        limit =  limit != null ?limit:10;
        if (StringUtils.isBlank(shipperId)) {
            return JsonResult.error(201,"请传入货主的编号");
        }
        try {
            return carService.selectCarsInfo(page,limit,shipperId,carNumber);
        } catch (Exception e) {
            return JsonResult.error(207,"服务器错误");
        }
    }
    /**
     * 通过货主id查询车辆信息
     *
     * @param param
     * @return 结果
     */
    @RequestMapping(value = "/selectCarInfo",method = RequestMethod.POST)
    public JsonResult selectCarInfo(String shipperId)
    {
        if (StringUtils.isBlank(shipperId)) {
            return JsonResult.error(201,"请传入货主的编号");
        }
        try {
            return carService.selectCarsInfo(shipperId);
        } catch (Exception e) {
            return JsonResult.error(207,"服务器错误");
        }
    }
}
