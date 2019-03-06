package com.yrsoft.system.service;

import com.yrsoft.system.entity.SData;
import com.yrsoft.common.utils.JsonResult;
import java.util.List;
import java.util.Map;

/**
 * 系统-数据字典 服务层
 * 
 * @author mz
 * @date 2019-02-23
 */
public interface SDataService
{
	/**
     * 查询系统-数据字典信息
     * 
     * @param id 系统-数据字典ID
     * @return 系统-数据字典信息
     */
	public JsonResult getSDataById(String id);
	
	/**
     * 查询系统-数据字典列表
     * 
     * @param sData 系统-数据字典信息
     * @return 系统-数据字典集合
     */
	public JsonResult list(Integer page, Integer limit, SData sData);
	
	/**
     * 新增系统-数据字典
     * 
     * @param sData 系统-数据字典信息
     * @return 结果
     */
	public JsonResult add(SData sData);
	
	/**
     * 修改系统-数据字典
     * 
     * @param sData 系统-数据字典信息
     * @return 结果
     */
	public JsonResult edit(SData sData);

    /**
     * 删除系统-数据字典信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public JsonResult remove(String ids);

	/**
	 * 按类型查询-数据字典
	 * @param type
	 * @return
	 */
	public JsonResult selectDataByType(String type);
	
}
