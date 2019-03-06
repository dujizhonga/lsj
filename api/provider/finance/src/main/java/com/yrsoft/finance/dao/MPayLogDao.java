package com.yrsoft.finance.dao;

import java.util.List;
import java.util.Map;

import com.yrsoft.finance.entity.MPayLog;
/**
 * 会员管理-支付记录 数据层
 * 
 * @author mz
 * @date 2019-02-23
 */
public interface MPayLogDao
{
	/**
     * 查询会员管理-支付记录信息
     * 
     * @param id 会员管理-支付记录ID
     * @return 会员管理-支付记录信息
     */
	public MPayLog selectMPayLogById(String id);
	
	/**
     * 查询会员管理-支付记录列表
     * 
     * @param mPayLog 会员管理-支付记录信息
     * @return 会员管理-支付记录集合
     */
	public List<MPayLog> selectMPayLogList(MPayLog mPayLog);
	
	/**
     * 新增会员管理-支付记录
     * 
     * @param mPayLog 会员管理-支付记录信息
     * @return 结果
     */
	public int insertMPayLog(MPayLog mPayLog);
	
	/**
     * 修改会员管理-支付记录
     * 
     * @param mPayLog 会员管理-支付记录信息
     * @return 结果
     */
	public int updateMPayLog(MPayLog mPayLog);
	
	/**
     * 删除会员管理-支付记录
     * 
     * @param id 会员管理-支付记录ID
     * @return 结果
     */
	public int updateMPayLogByIds(Map<String, Object> param);

    /**
     * 删除会员管理-支付记录
     *
     * @param id 会员管理-支付记录ID
     * @return 结果
     */
    public int deleteMPayLogById(Map<String, Object> param);
	
}