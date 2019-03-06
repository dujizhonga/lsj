package com.yrsoft.finance.dao;

import java.util.List;
import java.util.Map;

import com.yrsoft.finance.entity.MConsume;
/**
 * 会员管理-消费记录（非三方） 数据层
 * 
 * @author mz
 * @date 2019-02-23
 */
public interface MConsumeDao
{
	/**
     * 查询会员管理-消费记录（非三方）信息
     * 
     * @param id 会员管理-消费记录（非三方）ID
     * @return 会员管理-消费记录（非三方）信息
     */
	public MConsume selectMConsumeById(String id);
	
	/**
     * 查询会员管理-消费记录（非三方）列表
     * 
     * @param mConsume 会员管理-消费记录（非三方）信息
     * @return 会员管理-消费记录（非三方）集合
     */
	public List<MConsume> selectMConsumeList(MConsume mConsume);
	
	/**
     * 新增会员管理-消费记录（非三方）
     * 
     * @param mConsume 会员管理-消费记录（非三方）信息
     * @return 结果
     */
	public int insertMConsume(MConsume mConsume);
	
	/**
     * 修改会员管理-消费记录（非三方）
     * 
     * @param mConsume 会员管理-消费记录（非三方）信息
     * @return 结果
     */
	public int updateMConsume(MConsume mConsume);
	
	/**
     * 删除会员管理-消费记录（非三方）
     * 
     * @param id 会员管理-消费记录（非三方）ID
     * @return 结果
     */
	public int updateMConsumeByIds(Map<String, Object> param);

    /**
     * 删除会员管理-消费记录（非三方）
     *
     * @param id 会员管理-消费记录（非三方）ID
     * @return 结果
     */
    public int deleteMConsumeById(Map<String, Object> param);
	
}