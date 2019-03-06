package com.yrsoft.platform.service;

import com.yrsoft.platform.entity.PFreighRecords;
import com.yrsoft.common.utils.JsonResult;
import java.util.List;
import java.util.Map;

/**
 * 货运-支付运费记录 服务层
 * 
 * @author mz
 * @date 2019-02-23
 */
public interface PFreighRecordsService
{
	/**
     * 查询货运-支付运费记录信息
     * 
     * @param id 货运-支付运费记录ID
     * @return 货运-支付运费记录信息
     */
	public JsonResult getPFreighRecordsById(String id);
	
	/**
     * 查询货运-支付运费记录列表
     * 
     * @param pFreighRecords 货运-支付运费记录信息
     * @return 货运-支付运费记录集合
     */
	public JsonResult list(Integer page, Integer limit, PFreighRecords pFreighRecords);
	
	/**
     * 新增货运-支付运费记录
     * 
     * @param pFreighRecords 货运-支付运费记录信息
     * @return 结果
     */
	public JsonResult add(PFreighRecords pFreighRecords);
	
	/**
     * 修改货运-支付运费记录
     * 
     * @param pFreighRecords 货运-支付运费记录信息
     * @return 结果
     */
	public JsonResult edit(PFreighRecords pFreighRecords);

    /**
     * 删除货运-支付运费记录信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public JsonResult remove(String ids);
	
}
