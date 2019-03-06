package com.yrsoft.platform.service;

import com.yrsoft.platform.entity.PCargoName;
import com.yrsoft.common.utils.JsonResult;

/**
 * 货运-货物名称 服务层
 * 
 * @author mz
 * @date 2019-02-23
 */
public interface PCargoNameService
{
	/**
     * 查询货运-货物名称信息
     * 
     * @param id 货运-货物名称ID
     * @return 货运-货物名称信息
     */
	public JsonResult getPCargoNameById(String id);
	
	/**
     * 查询货运-货物名称列表
     * 
     * @param pCargoName 货运-货物名称信息
     * @return 货运-货物名称集合
     */
	public JsonResult list(Integer page, Integer limit, PCargoName pCargoName);
	
	/**
     * 新增货运-货物名称
     * 
     * @param pCargoName 货运-货物名称信息
     * @return 结果
     */
	public JsonResult add(PCargoName pCargoName);
	
	/**
     * 修改货运-货物名称
     * 
     * @param pCargoName 货运-货物名称信息
     * @return 结果
     */
	public JsonResult edit(PCargoName pCargoName);

    /**
     * 删除货运-货物名称信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public JsonResult remove(String ids);

    /**
     * 查询货运-货物名称列表:根据货物名称查询货物列表
     */
	public JsonResult goodsInfoList(PCargoName pCargoName);
	
}
