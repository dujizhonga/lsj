package com.yrsoft.platform.dao;

import com.yrsoft.platform.entity.PShipmentsModel;
import java.util.List;
import java.util.Map;
/**
 * 货运-货运模板 数据层
 * 
 * @author mz
 * @date 2019-02-23
 */
public interface PShipmentsModelDao
{
	/**
     * 查询货运-货运模板信息
     * 
     * @param id 货运-货运模板ID
     * @return 货运-货运模板信息
     */
	public PShipmentsModel selectPShipmentsModelById(String id);
	
	/**
     * 查询货运-货运模板列表
     * 
     * @param pShipmentsModel 货运-货运模板信息
     * @return 货运-货运模板集合
     */
	public List<PShipmentsModel> selectPShipmentsModelList(PShipmentsModel pShipmentsModel);
	
	/**
     * 新增货运-货运模板
     * 
     * @param pShipmentsModel 货运-货运模板信息
     * @return 结果
     */
	public int insertPShipmentsModel(PShipmentsModel pShipmentsModel);
	
	/**
     * 修改货运-货运模板
     * 
     * @param pShipmentsModel 货运-货运模板信息
     * @return 结果
     */
	public int updatePShipmentsModel(PShipmentsModel pShipmentsModel);
	
	/**
     * 删除货运-货运模板
     * 
     * @param id 货运-货运模板ID
     * @return 结果
     */
	public int updatePShipmentsModelByIds(Map<String, Object> param);

    /**
     * 删除货运-货运模板
     *
     * @param id 货运-货运模板ID
     * @return 结果
     */
    public int deletePShipmentsModelById(Map<String, Object> param);
	
}