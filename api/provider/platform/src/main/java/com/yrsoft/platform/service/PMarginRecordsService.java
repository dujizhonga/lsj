package com.yrsoft.platform.service;

import com.yrsoft.platform.entity.PMarginRecords;
import com.yrsoft.common.utils.JsonResult;
import java.util.List;
import java.util.Map;

/**
 * 货运-支付保证金记录 服务层
 * 
 * @author mz
 * @date 2019-02-23
 */
public interface PMarginRecordsService
{
	/**
     * 查询货运-支付保证金记录信息
     * 
     * @param id 货运-支付保证金记录ID
     * @return 货运-支付保证金记录信息
     */
	public JsonResult getPMarginRecordsById(String id);
	
	/**
     * 查询货运-支付保证金记录列表
     * 
     * @param pMarginRecords 货运-支付保证金记录信息
     * @return 货运-支付保证金记录集合
     */
	public JsonResult list(Integer page, Integer limit, PMarginRecords pMarginRecords);
	
	/**
     * 新增货运-支付保证金记录
     * 
     * @param pMarginRecords 货运-支付保证金记录信息
     * @return 结果
     */
	public JsonResult add(PMarginRecords pMarginRecords);
	
	/**
     * 修改货运-支付保证金记录
     * 
     * @param pMarginRecords 货运-支付保证金记录信息
     * @return 结果
     */
	public JsonResult edit(PMarginRecords pMarginRecords);

    /**
     * 删除货运-支付保证金记录信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public JsonResult remove(String ids);
	
}
