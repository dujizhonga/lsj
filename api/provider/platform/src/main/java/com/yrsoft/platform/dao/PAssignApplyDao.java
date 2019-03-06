package com.yrsoft.platform.dao;

import com.yrsoft.platform.entity.PAssignApply;
import java.util.List;
import java.util.Map;
/**
 * 货运-系统车辆分派申请 数据层
 * 
 * @author mz
 * @date 2019-02-23
 */
public interface PAssignApplyDao
{
	/**
     * 查询货运-系统车辆分派申请信息
     * 
     * @param id 货运-系统车辆分派申请ID
     * @return 货运-系统车辆分派申请信息
     */
	public PAssignApply selectPAssignApplyById(String id);
	
	/**
     * 查询货运-系统车辆分派申请列表
     * 
     * @param pAssignApply 货运-系统车辆分派申请信息
     * @return 货运-系统车辆分派申请集合
     */
	public List<PAssignApply> selectPAssignApplyList(PAssignApply pAssignApply);
	
	/**
     * 新增货运-系统车辆分派申请
     * 
     * @param pAssignApply 货运-系统车辆分派申请信息
     * @return 结果
     */
	public int insertPAssignApply(PAssignApply pAssignApply);
	
	/**
     * 修改货运-系统车辆分派申请
     * 
     * @param pAssignApply 货运-系统车辆分派申请信息
     * @return 结果
     */
	public int updatePAssignApply(PAssignApply pAssignApply);
	
	/**
     * 删除货运-系统车辆分派申请
     * 
     * @param id 货运-系统车辆分派申请ID
     * @return 结果
     */
	public int updatePAssignApplyByIds(Map<String, Object> param);

    /**
     * 删除货运-系统车辆分派申请
     *
     * @param id 货运-系统车辆分派申请ID
     * @return 结果
     */
    public int deletePAssignApplyById(Map<String, Object> param);
	
}