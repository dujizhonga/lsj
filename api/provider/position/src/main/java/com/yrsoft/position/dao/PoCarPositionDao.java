package com.yrsoft.position.dao;

import com.yrsoft.position.entity.PoCarPosition;
import java.util.List;
import java.util.Map;
/**
 * 位置-车辆位置及状态 数据层
 * 
 * @author mz
 * @date 2019-02-23
 */
public interface PoCarPositionDao
{
	/**
     * 查询位置-车辆位置及状态信息
     * 
     * @param id 位置-车辆位置及状态ID
     * @return 位置-车辆位置及状态信息
     */
	public PoCarPosition selectPoCarPositionById(String id);
	
	/**
     * 查询位置-车辆位置及状态列表
     * 
     * @param poCarPosition 位置-车辆位置及状态信息
     * @return 位置-车辆位置及状态集合
     */
	public List<PoCarPosition> selectPoCarPositionList(PoCarPosition poCarPosition);
	
	/**
     * 新增位置-车辆位置及状态
     * 
     * @param poCarPosition 位置-车辆位置及状态信息
     * @return 结果
     */
	public int insertPoCarPosition(PoCarPosition poCarPosition);
	
	/**
     * 修改位置-车辆位置及状态
     * 
     * @param poCarPosition 位置-车辆位置及状态信息
     * @return 结果
     */
	public int updatePoCarPosition(PoCarPosition poCarPosition);
	
	/**
     * 删除位置-车辆位置及状态
     * 
     * @param id 位置-车辆位置及状态ID
     * @return 结果
     */
	public int updatePoCarPositionByIds(Map<String, Object> param);

    /**
     * 删除位置-车辆位置及状态
     *
     * @param id 位置-车辆位置及状态ID
     * @return 结果
     */
    public int deletePoCarPositionById(Map<String, Object> param);
	
}