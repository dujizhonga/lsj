package com.yrsoft.delivery.service;
import com.yrsoft.common.utils.JsonResult;

/**
 * 查询所有自有车位置及基本信息
 * @author lu
 * @date 2019/2/25 
 */ 
public interface CarService {

	/**
     * 通过货主id查询自有车位置及基本信息
     *
     * @param param
     * @return 结果
     */
	public JsonResult selectCarByShipperId(Integer page,Integer limit,String shipperId);
	/**
	 * 功能描述: 指定范围内系统车位置及基本信息
	 * @param shipperId
	 * @param lat
	 * @param lnt
	 * @param distance
	 * @return
	 */

	public JsonResult getSysCar(String shipperId);
	

}
