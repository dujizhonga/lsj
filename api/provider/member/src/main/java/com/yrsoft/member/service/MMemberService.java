package com.yrsoft.member.service;

import com.yrsoft.member.entity.MMember;
import com.yrsoft.common.utils.JsonResult;
import java.util.List;
import java.util.Map;

/**
 * 会员管理-会员 服务层
 * 
 * @author mz
 * @date 2019-02-23
 */
public interface MMemberService
{
	/**
     * 查询会员管理-会员信息
     * 
     * @param id 会员管理-会员ID
     * @return 会员管理-会员信息
     */
	public JsonResult getMMemberById(String id);
	
	/**
     * 查询会员管理-会员列表
     * 
     * @param mMember 会员管理-会员信息
     * @return 会员管理-会员集合
     */
	public JsonResult list(Integer page, Integer limit, MMember mMember);
	
	/**
     * 新增会员管理-会员
     * 
     * @param mMember 会员管理-会员信息
     * @return 结果
     */
	public JsonResult add(MMember mMember);
	
	/**
     * 修改会员管理-会员
     * 
     * @param mMember 会员管理-会员信息
     * @return 结果
     */
	public JsonResult edit(MMember mMember);

    /**
     * 删除会员管理-会员信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public JsonResult remove(String ids);
	
}
