package com.yrsoft.platform.dao;

import com.yrsoft.platform.entity.PTransport;
import java.util.List;
import java.util.Map;
/**
 * 货运-运输单 数据层
 * 
 * @author mz
 * @date 2019-02-23
 */
public interface PTransportDao
{
	/**
     * 查询货运-运输单信息
     * 
     * @param id 货运-运输单ID
     * @return 货运-运输单信息
     */
	public PTransport selectPTransportById(String id);
	
	/**
     * 查询货运-运输单列表
     * 
     * @param pTransport 货运-运输单信息
     * @return 货运-运输单集合
     */
	public List<PTransport> selectPTransportList(PTransport pTransport);
	
	/**
     * 新增货运-运输单
     * 
     * @param pTransport 货运-运输单信息
     * @return 结果
     */
	public int insertPTransport(PTransport pTransport);
	
	/**
     * 修改货运-运输单
     * 
     * @param pTransport 货运-运输单信息
     * @return 结果
     */
	public int updatePTransport(PTransport pTransport);
	
	/**
     * 删除货运-运输单
     * 
     * @param id 货运-运输单ID
     * @return 结果
     */
	public int updatePTransportByIds(Map<String, Object> param);

    /**
     * 删除货运-运输单
     *
     * @param id 货运-运输单ID
     * @return 结果
     */
    public int deletePTransportById(Map<String, Object> param);
	
}