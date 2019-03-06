package com.yrsoft.member.dao;

import com.yrsoft.member.entity.MOwnerDriver;
import java.util.List;
import java.util.Map;
/**
 * 会员管理-车主司机关系 数据层
 * 
 * @author mz
 * @date 2019-02-23
 */
public interface MOwnerDriverDao
{
	/**
     * 查询会员管理-车主司机关系信息
     * 
     * @param id 会员管理-车主司机关系ID
     * @return 会员管理-车主司机关系信息
     */
	public MOwnerDriver selectMOwnerDriverById(String id);
	
	/**
     * 查询会员管理-车主司机关系列表
     * 
     * @param mOwnerDriver 会员管理-车主司机关系信息
     * @return 会员管理-车主司机关系集合
     */
	public List<MOwnerDriver> selectMOwnerDriverList(MOwnerDriver mOwnerDriver);
	
	/**
     * 新增会员管理-车主司机关系
     * 
     * @param mOwnerDriver 会员管理-车主司机关系信息
     * @return 结果
     */
	public int insertMOwnerDriver(MOwnerDriver mOwnerDriver);
	
	/**
     * 修改会员管理-车主司机关系
     * 
     * @param mOwnerDriver 会员管理-车主司机关系信息
     * @return 结果
     */
	public int updateMOwnerDriver(MOwnerDriver mOwnerDriver);
	
	/**
     * 删除会员管理-车主司机关系
     * 
     * @param id 会员管理-车主司机关系ID
     * @return 结果
     */
	public int updateMOwnerDriverByIds(Map<String, Object> param);

    /**
     * 删除会员管理-车主司机关系
     *
     * @param id 会员管理-车主司机关系ID
     * @return 结果
     */
    public int deleteMOwnerDriverById(Map<String, Object> param);
	
}