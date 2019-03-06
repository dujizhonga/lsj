package com.yrsoft.platform.dao;

import com.yrsoft.platform.entity.PAssignRecord;
import java.util.List;
import java.util.Map;
/**
 * 货运-分派记录 数据层
 * 
 * @author mz
 * @date 2019-02-23
 */
public interface PAssignRecordDao
{
	/**
     * 查询货运-分派记录信息
     * 
     * @param id 货运-分派记录ID
     * @return 货运-分派记录信息
     */
	public PAssignRecord selectPAssignRecordById(String id);
	
	/**
     * 查询货运-分派记录列表
     * 
     * @param pAssignRecord 货运-分派记录信息
     * @return 货运-分派记录集合
     */
	public List<PAssignRecord> selectPAssignRecordList(PAssignRecord pAssignRecord);
	
	/**
     * 新增货运-分派记录
     * 
     * @param pAssignRecord 货运-分派记录信息
     * @return 结果
     */
	public int insertPAssignRecord(PAssignRecord pAssignRecord);
	
	/**
     * 修改货运-分派记录
     * 
     * @param pAssignRecord 货运-分派记录信息
     * @return 结果
     */
	public int updatePAssignRecord(PAssignRecord pAssignRecord);
	
	/**
     * 删除货运-分派记录
     * 
     * @param id 货运-分派记录ID
     * @return 结果
     */
	public int updatePAssignRecordByIds(Map<String, Object> param);

    /**
     * 删除货运-分派记录
     *
     * @param id 货运-分派记录ID
     * @return 结果
     */
    public int deletePAssignRecordById(Map<String, Object> param);
	
}