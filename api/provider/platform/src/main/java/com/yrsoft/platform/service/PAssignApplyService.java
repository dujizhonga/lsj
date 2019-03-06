package com.yrsoft.platform.service;

import com.yrsoft.platform.entity.PAssignApply;
import com.yrsoft.common.utils.JsonResult;

/**
 * 货运-系统车辆分派申请 服务层
 * 
 * @author mz
 * @date 2019-02-23
 */
public interface PAssignApplyService
{
	/**
     * 查询货运-系统车辆分派申请信息
     * 
     * @param id 货运-系统车辆分派申请ID
     * @return 货运-系统车辆分派申请信息
     */
	public JsonResult getPAssignApplyById(String id);
	
	/**
     * 查询货运-系统车辆分派申请列表
     * 
     * @param pAssignApply 货运-系统车辆分派申请信息
     * @return 货运-系统车辆分派申请集合
     */
	public JsonResult list(Integer page, Integer limit, PAssignApply pAssignApply);
	
	/**
     * 新增货运-系统车辆分派申请
     * 
     * @param pAssignApply 货运-系统车辆分派申请信息
     * @return 结果
     */
	public JsonResult add(PAssignApply pAssignApply);
	
	/**
     * 修改货运-系统车辆分派申请
     * 
     * @param pAssignApply 货运-系统车辆分派申请信息
     * @return 结果
     */
	public JsonResult edit(PAssignApply pAssignApply);

    /**
     * 删除货运-系统车辆分派申请信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public JsonResult remove(String ids);
	
}
