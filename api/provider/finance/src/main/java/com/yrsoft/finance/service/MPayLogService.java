package com.yrsoft.finance.service;

import com.yrsoft.common.utils.JsonResult;
import com.yrsoft.finance.entity.MPayLog;

/**
 * 会员管理-支付记录 服务层
 * 
 * @author mz
 * @date 2019-02-23
 */
public interface MPayLogService
{
	/**
     * 查询会员管理-支付记录信息
     * 
     * @param id 会员管理-支付记录ID
     * @return 会员管理-支付记录信息
     */
	public JsonResult getMPayLogById(String id);
	
	/**
     * 查询会员管理-支付记录列表
     * 
     * @param mPayLog 会员管理-支付记录信息
     * @return 会员管理-支付记录集合
     */
	public JsonResult list(Integer page, Integer limit, MPayLog mPayLog);
	
	/**
     * 新增会员管理-支付记录
     * 
     * @param mPayLog 会员管理-支付记录信息
     * @return 结果
     */
	public JsonResult add(MPayLog mPayLog);
	
	/**
     * 修改会员管理-支付记录
     * 
     * @param mPayLog 会员管理-支付记录信息
     * @return 结果
     */
	public JsonResult edit(MPayLog mPayLog);

    /**
     * 删除会员管理-支付记录信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public JsonResult remove(String ids);
	
}
