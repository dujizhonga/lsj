package com.yrsoft.platform.service;

import com.yrsoft.platform.entity.PShippingAddress;
import com.yrsoft.common.utils.JsonResult;
import java.util.List;
import java.util.Map;

/**
 * 货运-收发货地址 服务层
 * 
 * @author mz
 * @date 2019-02-23
 */
public interface PShippingAddressService
{
	/**
     * 查询货运-收发货地址信息
     * 
     * @param id 货运-收发货地址ID
     * @return 货运-收发货地址信息
     */
	public JsonResult getPShippingAddressById(String id);
	
	/**
     * 查询货运-收发货地址列表
     * 
     * @param pShippingAddress 货运-收发货地址信息
     * @return 货运-收发货地址集合
     */
	public JsonResult list(Integer page, Integer limit, PShippingAddress pShippingAddress);
	
	/**
     * 新增货运-收发货地址
     * 
     * @param pShippingAddress 货运-收发货地址信息
     * @return 结果
     */
	public JsonResult add(PShippingAddress pShippingAddress);
	
	/**
     * 修改货运-收发货地址
     * 
     * @param pShippingAddress 货运-收发货地址信息
     * @return 结果
     */
	public JsonResult edit(PShippingAddress pShippingAddress);

    /**
     * 删除货运-收发货地址信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public JsonResult remove(String ids);
    /**
     * 查询货运-查询最新收发货地址
     * 
     * @param shippingId 货主ID
     * @return 货运-收发货地址集合
     */
	public JsonResult selectAddressNew(String shipperId);
	
}
