package com.yrsoft.platform.service;

import com.yrsoft.platform.entity.PShipmentsModel;
import com.yrsoft.common.utils.JsonResult;
import java.util.List;
import java.util.Map;

/**
 * 货运-货运模板 服务层
 * 
 * @author mz
 * @date 2019-02-23
 */
public interface PShipmentsModelService
{
	/**
     * 查询货运-货运模板信息
     * 
     * @param id 货运-货运模板ID
     * @return 货运-货运模板信息
     */
	public JsonResult getPShipmentsModelById(String id);
	
	/**
     * 查询货运-货运模板列表
     * 
     * @param pShipmentsModel 货运-货运模板信息
     * @return 货运-货运模板集合
     */
	public JsonResult list(Integer page, Integer limit, PShipmentsModel pShipmentsModel);
	
	/**
     * 新增货运-货运模板
     * 
     * @param pShipmentsModel 货运-货运模板信息
     * @return 结果
     */
	public JsonResult add(PShipmentsModel pShipmentsModel);
	
	/**
     * 修改货运-货运模板
     * 
     * @param pShipmentsModel 货运-货运模板信息
     * @return 结果
     */
	public JsonResult edit(PShipmentsModel pShipmentsModel);

    /**
     * 删除货运-货运模板信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public JsonResult remove(String ids);
	
}
