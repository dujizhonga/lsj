package com.yrsoft.platform.service;

import com.yrsoft.platform.entity.PStoredRecords;
import com.yrsoft.platform.entity.PStoredRecordsVo;
import com.yrsoft.common.utils.JsonResult;
import java.util.List;
import java.util.Map;

/**
 * 货运-储值记录 服务层
 * 
 * @author mz
 * @date 2019-02-23
 */
public interface PStoredRecordsService
{
	/**
     * 查询货运-储值记录信息
     * 
     * @param id 货运-储值记录ID
     * @return 货运-储值记录信息
     */
	public JsonResult getPStoredRecordsById(String id);
	
	/**
     * 查询货运-储值记录列表
     * 
     * @param pStoredRecords 货运-储值记录信息
     * @return 货运-储值记录集合
     */
	public JsonResult list(Integer page, Integer limit, PStoredRecords pStoredRecords);
	
	/**
     * 新增货运-储值记录
     * 
     * @param pStoredRecords 货运-储值记录信息
     * @return 结果
     */
	public JsonResult add(PStoredRecords pStoredRecords);
	
	/**
     * 修改货运-储值记录
     * 
     * @param pStoredRecords 货运-储值记录信息
     * @return 结果
     */
	public JsonResult edit(PStoredRecords pStoredRecords);

    /**
     * 删除货运-储值记录信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public JsonResult remove(String ids);
    
   /**
    * 生产资料分配
    * @param: @param page
    * @param: @param limit
    * @param: @param pStoredRecordsVo
    * @param: @return
    * @return: JsonResult
    * @auther: shihh
    * @date: 2019年3月1日上午10:46:14
    */
	public JsonResult getPSoredList(Integer page, Integer limit, String shipperId);
	
	/**
	 * 生产资料单挑详情
	 * @param: @param id
	 * @param: @return
	 * @return: JsonResult
	 * @auther: shihh
	 * @date: 2019年3月1日下午3:12:43
	 */
	public JsonResult getPSoredById(String id);
	
}
