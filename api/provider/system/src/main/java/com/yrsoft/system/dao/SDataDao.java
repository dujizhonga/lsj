package com.yrsoft.system.dao;

import com.yrsoft.system.entity.SData;
import java.util.List;
import java.util.Map;
/**
 * 系统-数据字典 数据层
 * 
 * @author mz
 * @date 2019-02-23
 */
public interface SDataDao
{
	/**
     * 查询系统-数据字典信息
     * 
     * @param id 系统-数据字典ID
     * @return 系统-数据字典信息
     */
	public SData selectSDataById(String id);
	
	/**
     * 查询系统-数据字典列表
     * 
     * @param sData 系统-数据字典信息
     * @return 系统-数据字典集合
     */
	public List<SData> selectSDataList(SData sData);
	
	/**
     * 新增系统-数据字典
     * 
     * @param sData 系统-数据字典信息
     * @return 结果
     */
	public int insertSData(SData sData);
	
	/**
     * 修改系统-数据字典
     * 
     * @param sData 系统-数据字典信息
     * @return 结果
     */
	public int updateSData(SData sData);
	
	/**
     * 删除系统-数据字典
     * 
     * @param id 系统-数据字典ID
     * @return 结果
     */
	public int updateSDataByIds(Map<String, Object> param);

    /**
     * 删除系统-数据字典
     *
     * @param id 系统-数据字典ID
     * @return 结果
     */
    public int deleteSDataById(Map<String, Object> param);

	/**
	 * 按类型查询-数据字典
	 * @param type
	 * @return
	 */
	public List<String> selectDataByType(String type);
	
}