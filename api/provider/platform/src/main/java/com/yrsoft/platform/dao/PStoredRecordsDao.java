package com.yrsoft.platform.dao;

import com.yrsoft.platform.entity.PStoredRecords;
import com.yrsoft.platform.entity.PStoredRecordsVo;

import java.util.List;
import java.util.Map;
/**
 * 货运-储值记录 数据层
 * 
 * @author mz
 * @date 2019-02-23
 */
public interface PStoredRecordsDao
{
	/**
     * 查询货运-储值记录信息
     * 
     * @param id 货运-储值记录ID
     * @return 货运-储值记录信息
     */
	public PStoredRecords selectPStoredRecordsById(String id);
	
	
	/**
     * 查询货运-储值记录列表
     * 
     * @param pStoredRecords 货运-储值记录信息
     * @return 货运-储值记录集合
     */
	public List<PStoredRecords> selectPStoredRecordsList(PStoredRecords pStoredRecords);
	
	/**
	 * 生产资料分配记录列表
	 * @param: @param pStoredRecords
	 * @param: @return
	 * @return: List<PStoredRecords>
	 * @auther: shihh
	 * @date: 2019年3月1日上午10:51:13
	 */
	public List<PStoredRecordsVo> getPSoredList(String shipperId);
	
	/**
     * 批量新增货运-储值记录
     * 
     * @param list 货运-储值记录信息
     * @return 结果
     */
	public int insertPStoredRecordsList(List<PStoredRecords> list);

	/**
	 * 新增货运-储值记录
	 *
	 * @param pStoredRecords 货运-储值记录信息
	 * @return 结果
	 */
	public int insertPStoredRecords(PStoredRecords pStoredRecords);
	
	/**
     * 修改货运-储值记录
     * 
     * @param pStoredRecords 货运-储值记录信息
     * @return 结果
     */
	public int updatePStoredRecords(PStoredRecords pStoredRecords);
	
	/**
     * 删除货运-储值记录
     * 
     * @param id 货运-储值记录ID
     * @return 结果
     */
	public int updatePStoredRecordsByIds(Map<String, Object> param);

    /**
     * 删除货运-储值记录
     *
     * @param id 货运-储值记录ID
     * @return 结果
     */
    public int deletePStoredRecordsById(Map<String, Object> param);
    
    /**
     * 生产资料分配记录单条记录详情
     * @param: @param id
     * @param: @return
     * @return: PStoredRecordsVo
     * @auther: shihh
     * @date: 2019年3月1日下午3:13:55
     */
    public PStoredRecordsVo selectPStoredById(String id);
	
	
	
}