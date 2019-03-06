package com.yrsoft.platform.dao;

import com.yrsoft.platform.entity.PCargoName;
import java.util.List;
import java.util.Map;
/**
 * 货运-货物名称 数据层
 * 
 * @author mz
 * @date 2019-02-23
 */
public interface PCargoNameDao
{
	/**
     * 查询货运-货物名称信息
     * 
     * @param id 货运-货物名称ID
     * @return 货运-货物名称信息
     */
	public PCargoName selectPCargoNameById(String id);
	
	/**
     * 查询货运-货物名称列表
     * 
     * @param pCargoName 货运-货物名称信息
     * @return 货运-货物名称集合
     */
	public List<PCargoName> selectPCargoNameList(PCargoName pCargoName);
	
	/**
     * 新增货运-货物名称
     * 
     * @param pCargoName 货运-货物名称信息
     * @return 结果
     */
	public int insertPCargoName(PCargoName pCargoName);
	
	/**
     * 修改货运-货物名称
     * 
     * @param pCargoName 货运-货物名称信息
     * @return 结果
     */
	public int updatePCargoName(PCargoName pCargoName);
	
	/**
     * 删除货运-货物名称
     * 
     * @param id 货运-货物名称ID
     * @return 结果
     */
	public int updatePCargoNameByIds(Map<String, Object> param);

    /**
     * 删除货运-货物名称
     *
     * @param id 货运-货物名称ID
     * @return 结果
     */
    public int deletePCargoNameById(Map<String, Object> param);

    /**
     * 查询货运-货物名称列表:根据货物名称查询货物列表
     */
	public List<PCargoName> goodsInfoList(Map<String, Object> infoMap);
	
}