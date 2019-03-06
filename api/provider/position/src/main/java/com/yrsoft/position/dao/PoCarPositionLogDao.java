package com.yrsoft.position.dao;

import com.yrsoft.position.entity.PoCarPositionLog;
import java.util.List;
import java.util.Map;
/**
 * 位置-车辆历史位置坐标 数据层
 * 
 * @author mz
 * @date 2019-02-23
 */
public interface PoCarPositionLogDao
{
	/**
     * 查询位置-车辆历史位置坐标信息
     * 
     * @param id 位置-车辆历史位置坐标ID
     * @return 位置-车辆历史位置坐标信息
     */
	public PoCarPositionLog selectPoCarPositionLogById(String id);
	
	/**
     * 查询位置-车辆历史位置坐标列表
     * 
     * @param poCarPositionLog 位置-车辆历史位置坐标信息
     * @return 位置-车辆历史位置坐标集合
     */
	public List<PoCarPositionLog> selectPoCarPositionLogList(PoCarPositionLog poCarPositionLog);
	
	/**
     * 新增位置-车辆历史位置坐标
     * 
     * @param poCarPositionLog 位置-车辆历史位置坐标信息
     * @return 结果
     */
	public int insertPoCarPositionLog(PoCarPositionLog poCarPositionLog);
	
	/**
     * 修改位置-车辆历史位置坐标
     * 
     * @param poCarPositionLog 位置-车辆历史位置坐标信息
     * @return 结果
     */
	public int updatePoCarPositionLog(PoCarPositionLog poCarPositionLog);
	
	/**
     * 删除位置-车辆历史位置坐标
     * 
     * @param id 位置-车辆历史位置坐标ID
     * @return 结果
     */
	public int updatePoCarPositionLogByIds(Map<String, Object> param);

    /**
     * 删除位置-车辆历史位置坐标
     *
     * @param id 位置-车辆历史位置坐标ID
     * @return 结果
     */
    public int deletePoCarPositionLogById(Map<String, Object> param);
	
}