package com.yrsoft.platform.dao;

import com.yrsoft.platform.entity.PShippingAddress;
import java.util.List;
import java.util.Map;
/**
 * 货运-收发货地址 数据层
 * 
 * @author mz
 * @date 2019-02-23
 */
public interface PShippingAddressDao
{
	/**
     * 查询货运-收发货地址信息
     * 
     * @param id 货运-收发货地址ID
     * @return 货运-收发货地址信息
     */
	public PShippingAddress selectPShippingAddressById(String id);
	
	/**
     * 查询货运-收发货地址列表
     * 
     * @param pShippingAddress 货运-收发货地址信息
     * @return 货运-收发货地址集合
     */
	public List<PShippingAddress> selectPShippingAddressList(PShippingAddress pShippingAddress);
	
	/**
     * 新增货运-收发货地址
     * 
     * @param pShippingAddress 货运-收发货地址信息
     * @return 结果
     */
	public int insertPShippingAddress(PShippingAddress pShippingAddress);
	
	/**
     * 修改货运-收发货地址
     * 
     * @param pShippingAddress 货运-收发货地址信息
     * @return 结果
     */
	public int updatePShippingAddress(PShippingAddress pShippingAddress);
	
	/**
     * 删除货运-收发货地址
     * 
     * @param id 货运-收发货地址ID
     * @return 结果
     */
	public int updatePShippingAddressByIds(Map<String, Object> param);

    /**
     * 删除货运-收发货地址
     *
     * @param id 货运-收发货地址ID
     * @return 结果
     */
    public int deletePShippingAddressById(Map<String, Object> param);
    /**
     * 查询货运-查询最新收发货地址
     * 
     * @param shippingId 货主ID
     * @return 货运-收发货地址集合
     */
	public List<PShippingAddress> selectAddressNew(String shipperId);
	
}