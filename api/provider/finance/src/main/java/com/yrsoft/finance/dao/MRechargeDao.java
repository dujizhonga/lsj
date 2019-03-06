package com.yrsoft.finance.dao;

import java.util.List;
import java.util.Map;

import com.yrsoft.finance.entity.MRecharge;
/**
 * 会员管理-充值记录 数据层
 * 
 * @author mz
 * @date 2019-02-23
 */
public interface MRechargeDao
{
	/**
     * 查询会员管理-充值记录信息
     * 
     * @param id 会员管理-充值记录ID
     * @return 会员管理-充值记录信息
     */
	public MRecharge selectMRechargeById(String id);
	
	/**
     * 查询会员管理-充值记录列表
     * 
     * @param mRecharge 会员管理-充值记录信息
     * @return 会员管理-充值记录集合
     */
	public List<MRecharge> selectMRechargeList(MRecharge mRecharge);
	
	/**
     * 新增会员管理-充值记录
     * 
     * @param mRecharge 会员管理-充值记录信息
     * @return 结果
     */
	public int insertMRecharge(MRecharge mRecharge);
	
	/**
     * 修改会员管理-充值记录
     * 
     * @param mRecharge 会员管理-充值记录信息
     * @return 结果
     */
	public int updateMRecharge(MRecharge mRecharge);
	
	/**
     * 删除会员管理-充值记录
     * 
     * @param id 会员管理-充值记录ID
     * @return 结果
     */
	public int updateMRechargeByIds(Map<String, Object> param);

    /**
     * 删除会员管理-充值记录
     *
     * @param id 会员管理-充值记录ID
     * @return 结果
     */
    public int deleteMRechargeById(Map<String, Object> param);
	
}