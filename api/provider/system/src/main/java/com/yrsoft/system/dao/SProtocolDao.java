package com.yrsoft.system.dao;

import com.yrsoft.system.entity.SProtocol;
import java.util.List;
import java.util.Map;
/**
 * 系统-协议 数据层
 * 
 * @author mz
 * @date 2019-02-23
 */
public interface SProtocolDao
{
	/**
     * 查询系统-协议信息
     * 
     * @param id 系统-协议ID
     * @return 系统-协议信息
     */
	public SProtocol selectSProtocolById(String id);
	
	/**
     * 查询系统-协议列表
     * 
     * @param sProtocol 系统-协议信息
     * @return 系统-协议集合
     */
	public List<SProtocol> selectSProtocolList(SProtocol sProtocol);
	
	/**
     * 新增系统-协议
     * 
     * @param sProtocol 系统-协议信息
     * @return 结果
     */
	public int insertSProtocol(SProtocol sProtocol);
	
	/**
     * 修改系统-协议
     * 
     * @param sProtocol 系统-协议信息
     * @return 结果
     */
	public int updateSProtocol(SProtocol sProtocol);
	
	/**
     * 删除系统-协议
     * 
     * @param id 系统-协议ID
     * @return 结果
     */
	public int updateSProtocolByIds(Map<String, Object> param);

    /**
     * 删除系统-协议
     *
     * @param id 系统-协议ID
     * @return 结果
     */
    public int deleteSProtocolById(Map<String, Object> param);
	
}