package com.yrsoft.member.dao;

import com.yrsoft.member.entity.MMember;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
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
    /**
     * 通过用户电话和注册类型查询用户信息 
     * 
     * @param telephone   电话号码
     * @param registerType 注册类型
     * @return 会员管理-会员信息
     */
	public List<MMember> selectByTelAndRegisterType(@Param("telephone") String telephone,@Param("registerType")Integer registerType);
	
}