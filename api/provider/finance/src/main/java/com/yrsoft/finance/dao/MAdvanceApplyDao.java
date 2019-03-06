package com.yrsoft.finance.dao;

import java.util.List;
import java.util.Map;

import com.yrsoft.finance.entity.MAdvanceApply;
/**
 * 会员管理-垫资申请 数据层
 * 
 * @author mz
 * @date 2019-02-23
 */
public interface MAdvanceApplyDao
{
	/**
     * 查询会员管理-垫资申请信息
     * 
     * @param id 会员管理-垫资申请ID
     * @return 会员管理-垫资申请信息
     */
	public MAdvanceApply selectMAdvanceApplyById(String id);
	
	/**
     * 查询会员管理-垫资申请列表
     * 
     * @param mAdvanceApply 会员管理-垫资申请信息
     * @return 会员管理-垫资申请集合
     */
	public List<MAdvanceApply> selectMAdvanceApplyList(MAdvanceApply mAdvanceApply);
	
	/**
     * 新增会员管理-垫资申请
     * 
     * @param mAdvanceApply 会员管理-垫资申请信息
     * @return 结果
     */
	public int insertMAdvanceApply(MAdvanceApply mAdvanceApply);
	
	/**
     * 修改会员管理-垫资申请
     * 
     * @param mAdvanceApply 会员管理-垫资申请信息
     * @return 结果
     */
	public int updateMAdvanceApply(MAdvanceApply mAdvanceApply);
	
	/**
     * 删除会员管理-垫资申请
     * 
     * @param id 会员管理-垫资申请ID
     * @return 结果
     */
	public int updateMAdvanceApplyByIds(Map<String, Object> param);

    /**
     * 删除会员管理-垫资申请
     *
     * @param id 会员管理-垫资申请ID
     * @return 结果
     */
    public int deleteMAdvanceApplyById(Map<String, Object> param);
	
}