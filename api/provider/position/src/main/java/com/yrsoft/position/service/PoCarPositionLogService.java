package com.yrsoft.position.service;

import com.yrsoft.position.entity.PoCarPositionLog;
import com.yrsoft.common.utils.JsonResult;
import java.util.List;
import java.util.Map;

/**
 * 位置-车辆历史位置坐标 服务层
 * 
 * @author mz
 * @date 2019-02-23
 */
public interface PoCarPositionLogService
{
	/**
     * 查询位置-车辆历史位置坐标信息
     * 
     * @param id 位置-车辆历史位置坐标ID
     * @return 位置-车辆历史位置坐标信息
     */
	public JsonResult getPoCarPositionLogById(String id);
	
	/**
     * 查询位置-车辆历史位置坐标列表
     * 
     * @param poCarPositionLog 位置-车辆历史位置坐标信息
     * @return 位置-车辆历史位置坐标集合
     */
	public JsonResult list(Integer page, Integer limit, PoCarPositionLog poCarPositionLog);
	
	/**
     * 新增位置-车辆历史位置坐标
     * 
     * @param poCarPositionLog 位置-车辆历史位置坐标信息
     * @return 结果
     */
	public JsonResult add(PoCarPositionLog poCarPositionLog);
	
	/**
     * 修改位置-车辆历史位置坐标
     * 
     * @param poCarPositionLog 位置-车辆历史位置坐标信息
     * @return 结果
     */
	public JsonResult edit(PoCarPositionLog poCarPositionLog);

    /**
     * 删除位置-车辆历史位置坐标信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public JsonResult remove(String ids);
	
}
