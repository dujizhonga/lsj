package com.yrsoft.finance.service;

import com.yrsoft.common.utils.JsonResult;
import com.yrsoft.finance.entity.MRecharge;

/**
 * 会员管理-充值记录 服务层
 * 
 * @author mz
 * @date 2019-02-23
 */
public interface MRechargeService
{
	/**
     * 查询会员管理-充值记录信息
     * 
     * @param id 会员管理-充值记录ID
     * @return 会员管理-充值记录信息
     */
	public JsonResult getMRechargeById(String id);
	
	/**
     * 查询会员管理-充值记录列表
     * 
     * @param mRecharge 会员管理-充值记录信息
     * @return 会员管理-充值记录集合
     */
	public JsonResult list(Integer page, Integer limit, MRecharge mRecharge);
	
	/**
     * 新增会员管理-充值记录
     * 
     * @param mRecharge 会员管理-充值记录信息
     * @return 结果
     */
	public JsonResult add(MRecharge mRecharge);
	
	/**
     * 修改会员管理-充值记录
     * 
     * @param mRecharge 会员管理-充值记录信息
     * @return 结果
     */
	public JsonResult edit(MRecharge mRecharge);

    /**
     * 删除会员管理-充值记录信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public JsonResult remove(String ids);
	
}
