package com.yrsoft.platform.service;

import com.yrsoft.platform.entity.PAssignRecord;
import com.yrsoft.common.utils.JsonResult;
import java.util.List;
import java.util.Map;

/**
 * 货运-分派记录 服务层
 * 
 * @author mz
 * @date 2019-02-23
 */
public interface PAssignRecordService
{
	/**
     * 查询货运-分派记录信息
     * 
     * @param id 货运-分派记录ID
     * @return 货运-分派记录信息
     */
	public JsonResult getPAssignRecordById(String id);
	
	/**
     * 查询货运-分派记录列表
     * 
     * @param pAssignRecord 货运-分派记录信息
     * @return 货运-分派记录集合
     */
	public JsonResult list(Integer page, Integer limit, PAssignRecord pAssignRecord);
	
	/**
     * 新增货运-分派记录
     * 
     * @param pAssignRecord 货运-分派记录信息
     * @return 结果
     */
	public JsonResult add(PAssignRecord pAssignRecord);
	
	/**
     * 修改货运-分派记录
     * 
     * @param pAssignRecord 货运-分派记录信息
     * @return 结果
     */
	public JsonResult edit(PAssignRecord pAssignRecord);

    /**
     * 删除货运-分派记录信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public JsonResult remove(String ids);
	
}
