package com.yrsoft.member.dao;

import com.yrsoft.member.entity.MMember;
import java.util.List;
import java.util.Map;
/**
 * 会员管理-会员 数据层
 * 
 * @author mz
 * @date 2019-02-23
 */
public interface MMemberDao
{
	/**
     * 查询会员管理-会员信息
     * 
     * @param id 会员管理-会员ID
     * @return 会员管理-会员信息
     */
	public MMember selectMMemberById(String id);
	
	/**
     * 查询会员管理-会员列表
     * 
     * @param mMember 会员管理-会员信息
     * @return 会员管理-会员集合
     */
	public List<MMember> selectMMemberList(MMember mMember);
	
	/**
     * 新增会员管理-会员
     * 
     * @param mMember 会员管理-会员信息
     * @return 结果
     */
	public int insertMMember(MMember mMember);
	
	/**
     * 修改会员管理-会员
     * 
     * @param mMember 会员管理-会员信息
     * @return 结果
     */
	public int updateMMember(MMember mMember);
	
	/**
     * 删除会员管理-会员
     * 
     * @param id 会员管理-会员ID
     * @return 结果
     */
	public int updateMMemberByIds(Map<String, Object> param);

    /**
     * 删除会员管理-会员
     *
     * @param id 会员管理-会员ID
     * @return 结果
     */
    public int deleteMMemberById(Map<String, Object> param);
	
}