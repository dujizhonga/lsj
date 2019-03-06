package com.yrsoft.member.dao;

import com.yrsoft.member.entity.BoOwnerShipper;
import java.util.List;
import java.util.Map;
/**
 * 会员管理-货主车主关系 数据层
 * 
 * @author mz
 * @date 2019-02-23
 */
public interface BoOwnerShipperDao
{
	/**
     * 查询会员管理-货主车主关系信息
     * 
     * @param id 会员管理-货主车主关系ID
     * @return 会员管理-货主车主关系信息
     */
	public BoOwnerShipper selectBoOwnerShipperById(String id);
	
	/**
     * 查询会员管理-货主车主关系列表
     * 
     * @param boOwnerShipper 会员管理-货主车主关系信息
     * @return 会员管理-货主车主关系集合
     */
	public List<BoOwnerShipper> selectBoOwnerShipperList(BoOwnerShipper boOwnerShipper);
	
	/**
     * 新增会员管理-货主车主关系
     * 
     * @param boOwnerShipper 会员管理-货主车主关系信息
     * @return 结果
     */
	public int insertBoOwnerShipper(BoOwnerShipper boOwnerShipper);
	
	/**
     * 修改会员管理-货主车主关系
     * 
     * @param boOwnerShipper 会员管理-货主车主关系信息
     * @return 结果
     */
	public int updateBoOwnerShipper(BoOwnerShipper boOwnerShipper);
	
	/**
     * 删除会员管理-货主车主关系
     * 
     * @param id 会员管理-货主车主关系ID
     * @return 结果
     */
	public int updateBoOwnerShipperByIds(Map<String, Object> param);

    /**
     * 删除会员管理-货主车主关系
     *
     * @param id 会员管理-货主车主关系ID
     * @return 结果
     */
    public int deleteBoOwnerShipperById(Map<String, Object> param);
    /**
     * 查询车主信息-货主车主关系
     *
     * @param 货主id 
     * @return 
     */
    public List<BoOwnerShipper> selectOwnerInfo(String shipperId);
	
}