package com.yrsoft.auth.service;

import java.util.List;
import java.util.Map;

import com.yrsoft.auth.entity.Car;
import com.yrsoft.common.utils.JsonResult;

/**
 * 认证管理-车辆认证 服务层
 * 
 * @author mz
 * @date 2019-02-23
 */
public interface CarService
{
	/**
     * 查询认证管理-车辆认证信息
     * 
     * @param id 认证管理-车辆认证ID
     * @return 认证管理-车辆认证信息
     */
	JsonResult getCarById(String id);
	
	/**
     * 查询认证管理-车辆认证列表
     * 
     * @param car 认证管理-车辆认证信息
     * @return 认证管理-车辆认证集合
     */
	JsonResult list(Integer page, Integer limit, Car car);
	
	/**
     * 新增认证管理-车辆认证
     * 
     * @param car 认证管理-车辆认证信息
     * @return 结果
     */
	JsonResult add(Car car);
	
	/**
     * 修改认证管理-车辆认证
     * 
     * @param car 认证管理-车辆认证信息
     * @return 结果
     */
	JsonResult edit(Car car);

    /**
     * 删除认证管理-车辆认证信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    JsonResult remove(String ids);
    
    /**
     * 通过货主id查询车辆信息
     *
     * @param param
     * @return 结果
     */
    JsonResult selectCarsInfo(Integer page,Integer limit,String shipperId,String carNumber);
    //根据车辆id查询车主和车辆信息
	JsonResult getCarByIds(String id);
	//根据车主id查询车主和车辆信息
	JsonResult selectCarByOwnerId(Integer page,Integer limit,String ownerId,String telephone,String ownerName,String carNumber);
	
	 /**
     * 通过货主id查询系统车辆信息
     *
     * @param param
     * @return 结果
     */
    JsonResult selectSysCarInfo(String shipperId);
    /**
     * 通过货主id查询车辆信息
     *
     * @param param
     * @return 结果
     */
	JsonResult selectCarsInfo(String shipperId);
	
}
