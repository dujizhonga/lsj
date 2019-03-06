package com.yrsoft.platform.dao;

import com.yrsoft.platform.entity.PFreighRecords;
import java.util.List;
import java.util.Map;
/**
 * 货运-支付运费记录 数据层
 * 
 * @author mz
 * @date 2019-02-23
 */
public interface PFreighRecordsDao
{
	/**
     * 查询货运-支付运费记录信息
     * 
     * @param id 货运-支付运费记录ID
     * @return 货运-支付运费记录信息
     */
	public PFreighRecords selectPFreighRecordsById(String id);
	
	/**
     * 查询货运-支付运费记录列表
     * 
     * @param pFreighRecords 货运-支付运费记录信息
     * @return 货运-支付运费记录集合
     */
	public List<PFreighRecords> selectPFreighRecordsList(PFreighRecords pFreighRecords);
	
	/**
     * 新增货运-支付运费记录
     * 
     * @param pFreighRecords 货运-支付运费记录信息
     * @return 结果
     */
	public int insertPFreighRecords(PFreighRecords pFreighRecords);
	
	/**
     * 修改货运-支付运费记录
     * 
     * @param pFreighRecords 货运-支付运费记录信息
     * @return 结果
     */
	public int updatePFreighRecords(PFreighRecords pFreighRecords);
	
	/**
     * 删除货运-支付运费记录
     * 
     * @param id 货运-支付运费记录ID
     * @return 结果
     */
	public int updatePFreighRecordsByIds(Map<String, Object> param);

    /**
     * 删除货运-支付运费记录
     *
     * @param id 货运-支付运费记录ID
     * @return 结果
     */
    public int deletePFreighRecordsById(Map<String, Object> param);
	
}