package com.yrsoft.finance.service;

import com.yrsoft.common.utils.JsonResult;
import com.yrsoft.finance.entity.MConsume;

import java.util.List;
import java.util.Map;

/**
 * 会员管理-消费记录（非三方） 服务层
 * 
 * @author mz
 * @date 2019-02-23
 */
public interface MConsumeService
{
	/**
     * 查询会员管理-消费记录（非三方）信息
     * 
     * @param id 会员管理-消费记录（非三方）ID
     * @return 会员管理-消费记录（非三方）信息
     */
	public JsonResult getMConsumeById(String id);
	
	/**
     * 查询会员管理-消费记录（非三方）列表
     * 
     * @param mConsume 会员管理-消费记录（非三方）信息
     * @return 会员管理-消费记录（非三方）集合
     */
	public JsonResult list(Integer page, Integer limit, MConsume mConsume);
	
	/**
     * 新增会员管理-消费记录（非三方）
     * 
     * @param mConsume 会员管理-消费记录（非三方）信息
     * @return 结果
     */
	public JsonResult add(MConsume mConsume);
	
	/**
     * 修改会员管理-消费记录（非三方）
     * 
     * @param mConsume 会员管理-消费记录（非三方）信息
     * @return 结果
     */
	public JsonResult edit(MConsume mConsume);

    /**
     * 删除会员管理-消费记录（非三方）信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public JsonResult remove(String ids);
	
}
