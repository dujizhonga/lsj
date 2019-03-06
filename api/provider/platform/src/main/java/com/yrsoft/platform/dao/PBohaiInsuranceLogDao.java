package com.yrsoft.platform.dao;

import com.yrsoft.platform.entity.PBohaiInsuranceLog;
import java.util.List;
import java.util.Map;
/**
 * 渤海保险承保记录 数据层
 * 
 * @author mz
 * @date 2019-03-06
 */
public interface PBohaiInsuranceLogDao
{
	/**
     * 查询渤海保险承保记录信息
     * 
     * @param id 渤海保险承保记录ID
     * @return 渤海保险承保记录信息
     */
	public PBohaiInsuranceLog selectPBohaiInsuranceLogById(String id);
	
	/**
     * 查询渤海保险承保记录列表
     * 
     * @param pBohaiInsuranceLog 渤海保险承保记录信息
     * @return 渤海保险承保记录集合
     */
	public List<PBohaiInsuranceLog> selectPBohaiInsuranceLogList(PBohaiInsuranceLog pBohaiInsuranceLog);
	
	/**
     * 新增渤海保险承保记录
     * 
     * @param pBohaiInsuranceLog 渤海保险承保记录信息
     * @return 结果
     */
	public int insertPBohaiInsuranceLog(PBohaiInsuranceLog pBohaiInsuranceLog);
	
	/**
     * 修改渤海保险承保记录
     * 
     * @param pBohaiInsuranceLog 渤海保险承保记录信息
     * @return 结果
     */
	public int updatePBohaiInsuranceLog(PBohaiInsuranceLog pBohaiInsuranceLog);
	
	/**
     * 删除渤海保险承保记录
     * 
     * @param id 渤海保险承保记录ID
     * @return 结果
     */
	public int updatePBohaiInsuranceLogByIds(Map<String, Object> param);

    /**
     * 删除渤海保险承保记录
     *
     * @param id 渤海保险承保记录ID
     * @return 结果
     */
    public int deletePBohaiInsuranceLogById(Map<String, Object> param);
	
}