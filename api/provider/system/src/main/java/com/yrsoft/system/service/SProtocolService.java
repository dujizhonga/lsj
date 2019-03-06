package com.yrsoft.system.service;

import com.yrsoft.system.entity.SProtocol;
import com.yrsoft.common.utils.JsonResult;
import java.util.List;
import java.util.Map;

/**
 * 系统-协议 服务层
 * 
 * @author mz
 * @date 2019-02-23
 */
public interface SProtocolService
{
	/**
     * 查询系统-协议信息
     * 
     * @param id 系统-协议ID
     * @return 系统-协议信息
     */
	public JsonResult getSProtocolById(String id);
	
	/**
     * 查询系统-协议列表
     * 
     * @param sProtocol 系统-协议信息
     * @return 系统-协议集合
     */
	public JsonResult list(Integer page, Integer limit, SProtocol sProtocol);
	
	/**
     * 新增系统-协议
     * 
     * @param sProtocol 系统-协议信息
     * @return 结果
     */
	public JsonResult add(SProtocol sProtocol);
	
	/**
     * 修改系统-协议
     * 
     * @param sProtocol 系统-协议信息
     * @return 结果
     */
	public JsonResult edit(SProtocol sProtocol);

    /**
     * 删除系统-协议信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public JsonResult remove(String ids);
	
}
