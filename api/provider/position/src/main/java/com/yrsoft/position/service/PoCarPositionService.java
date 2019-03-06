package com.yrsoft.position.service;

import com.yrsoft.position.entity.PoCarPosition;
import com.yrsoft.common.utils.JsonResult;
import java.util.List;
import java.util.Map;

/**
 * 位置-车辆位置及状态 服务层
 * 
 * @author mz
 * @date 2019-02-23
 */
public interface PoCarPositionService
{
	/**
     * 查询位置-车辆位置及状态信息
     * 
     * @param id 位置-车辆位置及状态ID
     * @return 位置-车辆位置及状态信息
     */
	public JsonResult getPoCarPositionById(String id);
	
	/**
     * 查询位置-车辆位置及状态列表
     * 
     * @param poCarPosition 位置-车辆位置及状态信息
     * @return 位置-车辆位置及状态集合
     */
	public JsonResult list(Integer page, Integer limit, PoCarPosition poCarPosition);
	
	/**
     * 新增位置-车辆位置及状态
     * 
     * @param poCarPosition 位置-车辆位置及状态信息
     * @return 结果
     */
	public JsonResult add(PoCarPosition poCarPosition);
	
	/**
     * 修改位置-车辆位置及状态
     * 
     * @param poCarPosition 位置-车辆位置及状态信息
     * @return 结果
     */
	public JsonResult edit(PoCarPosition poCarPosition);

    /**
     * 删除位置-车辆位置及状态信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public JsonResult remove(String ids);
	
}
