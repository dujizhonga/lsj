package com.yrsoft.auth.dao;

import com.yrsoft.auth.entity.Car;
import com.yrsoft.auth.entity.CarP;

import java.util.List;
import java.util.Map;
/**
 * 认证管理-车辆认证 数据层
 * 
 * @author mz
 * @date 2019-02-23
 */
public interface CarDao
{
	/**
     * 查询认证管理-车辆认证信息
     * 
     * @param id 认证管理-车辆认证ID
     * @return 认证管理-车辆认证信息
     */
	Car selectCarById(String id);
	
	/**
     * 查询认证管理-车辆认证列表
     * 
     * @param car 认证管理-车辆认证信息
     * @return 认证管理-车辆认证集合
     */
	List<Car> selectCarList(Car car);
	
	/**
     * 新增认证管理-车辆认证
     * 
     * @param car 认证管理-车辆认证信息
     * @return 结果
     */
	int insertCar(Car car);
	
	/**
     * 修改认证管理-车辆认证
     * 
     * @param car 认证管理-车辆认证信息
     * @return 结果
     */
	int updateCar(Car car);
	
	/**
     * 删除认证管理-车辆认证
     * 
     * @param id 认证管理-车辆认证ID
     * @return 结果
     */
	int updateCarByIds(Map<String, Object> param);

    /**
     * 删除认证管理-车辆认证
     *
     * @param id 认证管理-车辆认证ID
     * @return 结果
     */
    int deleteCarById(Map<String, Object> param);
    //根据车辆id查询车主和车辆信息
    CarP selectCarByIds(String id);
	//根据车主id查询车主和车辆信息
	List<CarP> selectCarByOwnerId(Map<String, Object> param);
    /**
     * 通过货主id查询系统车辆信息和坐标位置
     *
     * @param param
     * @return 结果
     */
    List<Car> selectSysCarInfo(Map<String, Object> param);
    /**
     * 通过货主id查询车辆信息
     *
     * @param param
     * @return 结果
     */
    List<Car> selectCarsInfo(Map<String, Object> param);
    /**
     * 通过货主id查询车辆信息
     *
     * @param param
     * @return 结果
     */
	List<Car> selectCarsInfo(Integer page, Integer limit, String shipperId);
	
}