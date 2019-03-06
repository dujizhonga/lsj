package com.yrsoft.platform.service;

import com.yrsoft.platform.entity.PCargoType;
import com.yrsoft.common.utils.JsonResult;
import java.util.List;
import java.util.Map;

/**
 * 货运-货物类别 服务层
 * 
 * @author mz
 * @date 2019-02-23
 */
public interface PCargoTypeService
{
	/**
     * 查询货运-货物类别信息
     * 
     * @param id 货运-货物类别ID
     * @return 货运-货物类别信息
     */
	public JsonResult getPCargoTypeById(String id);
	
	/**
     * 查询货运-货物类别列表
     * 
     * @param pCargoType 货运-货物类别信息
     * @return 货运-货物类别集合
     */
	public JsonResult list(Integer page, Integer limit, PCargoType pCargoType);
	
	/**
     * 新增货运-货物类别
     * 
     * @param pCargoType 货运-货物类别信息
     * @return 结果
     */
	public JsonResult add(PCargoType pCargoType);
	
	/**
     * 修改货运-货物类别
     * 
     * @param pCargoType 货运-货物类别信息
     * @return 结果
     */
	public JsonResult edit(PCargoType pCargoType);

    /**
     * 删除货运-货物类别信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public JsonResult remove(String ids);
	
}
