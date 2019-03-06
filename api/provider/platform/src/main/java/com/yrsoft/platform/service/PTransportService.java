package com.yrsoft.platform.service;

import com.yrsoft.platform.entity.PTransport;
import com.yrsoft.common.utils.JsonResult;
import java.util.List;
import java.util.Map;

/**
 * 货运-运输单 服务层
 * 
 * @author mz
 * @date 2019-02-23
 */
public interface PTransportService
{
	/**
     * 查询货运-运输单信息
     * 
     * @param id 货运-运输单ID
     * @return 货运-运输单信息
     */
	public JsonResult getPTransportById(String id);
	
	/**
     * 查询货运-运输单列表
     * 
     * @param pTransport 货运-运输单信息
     * @return 货运-运输单集合
     */
	public JsonResult list(Integer page, Integer limit, PTransport pTransport);
	
	/**
     * 新增货运-运输单
     * 
     * @param pTransport 货运-运输单信息
     * @return 结果
     */
	public JsonResult add(PTransport pTransport);
	
	/**
     * 修改货运-运输单
     * 
     * @param pTransport 货运-运输单信息
     * @return 结果
     */
	public JsonResult edit(PTransport pTransport);

    /**
     * 删除货运-运输单信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public JsonResult remove(String ids);
	
}
