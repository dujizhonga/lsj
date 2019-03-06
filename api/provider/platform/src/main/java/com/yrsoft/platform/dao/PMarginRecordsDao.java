package com.yrsoft.platform.dao;

import com.yrsoft.platform.entity.PMarginRecords;
import java.util.List;
import java.util.Map;
/**
 * 货运-支付保证金记录 数据层
 * 
 * @author mz
 * @date 2019-02-23
 */
public interface PMarginRecordsDao
{
	/**
     * 查询货运-支付保证金记录信息
     * 
     * @param id 货运-支付保证金记录ID
     * @return 货运-支付保证金记录信息
     */
	public PMarginRecords selectPMarginRecordsById(String id);
	
	/**
     * 查询货运-支付保证金记录列表
     * 
     * @param pMarginRecords 货运-支付保证金记录信息
     * @return 货运-支付保证金记录集合
     */
	public List<PMarginRecords> selectPMarginRecordsList(PMarginRecords pMarginRecords);
	
	/**
     * 新增货运-支付保证金记录
     * 
     * @param pMarginRecords 货运-支付保证金记录信息
     * @return 结果
     */
	public int insertPMarginRecords(PMarginRecords pMarginRecords);
	
	/**
     * 修改货运-支付保证金记录
     * 
     * @param pMarginRecords 货运-支付保证金记录信息
     * @return 结果
     */
	public int updatePMarginRecords(PMarginRecords pMarginRecords);
	
	/**
     * 删除货运-支付保证金记录
     * 
     * @param id 货运-支付保证金记录ID
     * @return 结果
     */
	public int updatePMarginRecordsByIds(Map<String, Object> param);

    /**
     * 删除货运-支付保证金记录
     *
     * @param id 货运-支付保证金记录ID
     * @return 结果
     */
    public int deletePMarginRecordsById(Map<String, Object> param);
	
}