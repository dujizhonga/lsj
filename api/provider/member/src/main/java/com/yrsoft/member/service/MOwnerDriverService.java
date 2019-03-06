package com.yrsoft.member.service;

import com.yrsoft.member.entity.MOwnerDriver;
import com.yrsoft.common.utils.JsonResult;
import java.util.List;
import java.util.Map;

/**
 * 会员管理-车主司机关系 服务层
 * 
 * @author mz
 * @date 2019-02-23
 */
public interface MOwnerDriverService
{
	/**
     * 查询会员管理-车主司机关系信息
     * 
     * @param id 会员管理-车主司机关系ID
     * @return 会员管理-车主司机关系信息
     */
	public JsonResult getMOwnerDriverById(String id);
	
	/**
     * 查询会员管理-车主司机关系列表
     * 
     * @param mOwnerDriver 会员管理-车主司机关系信息
     * @return 会员管理-车主司机关系集合
     */
	public JsonResult list(Integer page, Integer limit, MOwnerDriver mOwnerDriver);
	
	/**
     * 新增会员管理-车主司机关系
     * 
     * @param mOwnerDriver 会员管理-车主司机关系信息
     * @return 结果
     */
	public JsonResult add(MOwnerDriver mOwnerDriver);
	
	/**
     * 修改会员管理-车主司机关系
     * 
     * @param mOwnerDriver 会员管理-车主司机关系信息
     * @return 结果
     */
	public JsonResult edit(MOwnerDriver mOwnerDriver);

    /**
     * 删除会员管理-车主司机关系信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public JsonResult remove(String ids);
	
}
