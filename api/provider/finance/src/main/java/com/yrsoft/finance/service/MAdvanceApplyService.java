package com.yrsoft.finance.service;

import com.yrsoft.common.utils.JsonResult;
import com.yrsoft.finance.entity.MAdvanceApply;

import java.util.List;
import java.util.Map;

/**
 * 会员管理-垫资申请 服务层
 * 
 * @author mz
 * @date 2019-02-23
 */
public interface MAdvanceApplyService
{
	/**
     * 查询会员管理-垫资申请信息
     * 
     * @param id 会员管理-垫资申请ID
     * @return 会员管理-垫资申请信息
     */
	public JsonResult getMAdvanceApplyById(String id);
	
	/**
     * 查询会员管理-垫资申请列表
     * 
     * @param mAdvanceApply 会员管理-垫资申请信息
     * @return 会员管理-垫资申请集合
     */
	public JsonResult list(Integer page, Integer limit, MAdvanceApply mAdvanceApply);
	
	/**
     * 新增会员管理-垫资申请
     * 
     * @param mAdvanceApply 会员管理-垫资申请信息
     * @return 结果
     */
	public JsonResult add(MAdvanceApply mAdvanceApply);
	
	/**
     * 修改会员管理-垫资申请
     * 
     * @param mAdvanceApply 会员管理-垫资申请信息
     * @return 结果
     */
	public JsonResult edit(MAdvanceApply mAdvanceApply);

    /**
     * 删除会员管理-垫资申请信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public JsonResult remove(String ids);
	
}
