package com.yrsoft.platform.service;

import com.yrsoft.common.utils.JsonResult;
import com.yrsoft.platform.entity.PBohaiInsuranceLog;


/**
 * 渤海保险承保记录 服务层
 * 
 * @author mz
 * @date 2019-03-06
 */
public interface PBohaiInsuranceLogService
{
	/**
     * 查询渤海保险承保记录信息
     * 
     * @param id 渤海保险承保记录ID
     * @return 渤海保险承保记录信息
     */
	public JsonResult getPBohaiInsuranceLogById(String id);
	
	/**
     * 查询渤海保险承保记录列表
     * 
     * @param pBohaiInsuranceLog 渤海保险承保记录信息
     * @return 渤海保险承保记录集合
     */
	public JsonResult list(Integer page, Integer limit, PBohaiInsuranceLog pBohaiInsuranceLog);
	
	/**
     * 新增渤海保险承保记录
     * 
     * @param pBohaiInsuranceLog 渤海保险承保记录信息
     * @return 结果
     */
	public JsonResult add(PBohaiInsuranceLog pBohaiInsuranceLog);
	
	/**
     * 修改渤海保险承保记录
     * 
     * @param pBohaiInsuranceLog 渤海保险承保记录信息
     * @return 结果
     */
	public JsonResult edit(PBohaiInsuranceLog pBohaiInsuranceLog);

    /**
     * 删除渤海保险承保记录信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public JsonResult remove(String ids);
	
}
