package com.yrsoft.member.service;

import com.yrsoft.member.entity.BoOwnerShipper;
import com.yrsoft.common.utils.JsonResult;
import java.util.List;
import java.util.Map;

/**
 * 会员管理-货主车主关系 服务层
 * 
 * @author mz
 * @date 2019-02-23
 */
public interface BoOwnerShipperService
{
	/**
     * 查询会员管理-货主车主关系信息
     * 
     * @param id 会员管理-货主车主关系ID
     * @return 会员管理-货主车主关系信息
     */
	public JsonResult getBoOwnerShipperById(String id);
	
	/**
     * 查询会员管理-货主车主关系列表
     * 
     * @param boOwnerShipper 会员管理-货主车主关系信息
     * @return 会员管理-货主车主关系集合
     */
	public JsonResult list(Integer page, Integer limit, BoOwnerShipper boOwnerShipper);
	
	/**
     * 新增会员管理-货主车主关系
     * 
     * @param boOwnerShipper 会员管理-货主车主关系信息
     * @return 结果
     */
	public JsonResult add(BoOwnerShipper boOwnerShipper);
	
	/**
     * 修改会员管理-货主车主关系
     * 
     * @param boOwnerShipper 会员管理-货主车主关系信息
     * @return 结果
     */
	public JsonResult edit(BoOwnerShipper boOwnerShipper);

    /**
     * 删除会员管理-货主车主关系信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public JsonResult remove(String ids);
    
    /**
     * 查询车主信息-货主车主关系
     *
     * @param 货主id 
     * @return 
     */
    public JsonResult selectOwnerInfo(String shipperId);
	
}
