package com.yrsoft.platform.dao;

import com.yrsoft.platform.entity.PCargoType;
import java.util.List;
import java.util.Map;
/**
 * 货运-货物类别 数据层
 * 
 * @author mz
 * @date 2019-02-23
 */
public interface PCargoTypeDao
{
	/**
     * 查询货运-货物类别信息
     * 
     * @param id 货运-货物类别ID
     * @return 货运-货物类别信息
     */
	public PCargoType selectPCargoTypeById(String id);
	
	/**
     * 查询货运-货物类别列表
     * 
     * @param pCargoType 货运-货物类别信息
     * @return 货运-货物类别集合
     */
	public List<PCargoType> selectPCargoTypeList(PCargoType pCargoType);
	
	/**
     * 新增货运-货物类别
     * 
     * @param pCargoType 货运-货物类别信息
     * @return 结果
     */
	public int insertPCargoType(PCargoType pCargoType);
	
	/**
     * 修改货运-货物类别
     * 
     * @param pCargoType 货运-货物类别信息
     * @return 结果
     */
	public int updatePCargoType(PCargoType pCargoType);
	
	/**
     * 删除货运-货物类别
     * 
     * @param id 货运-货物类别ID
     * @return 结果
     */
	public int updatePCargoTypeByIds(Map<String, Object> param);

    /**
     * 删除货运-货物类别
     *
     * @param id 货运-货物类别ID
     * @return 结果
     */
    public int deletePCargoTypeById(Map<String, Object> param);
	
}