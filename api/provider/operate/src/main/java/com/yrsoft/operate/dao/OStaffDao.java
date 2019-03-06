package com.yrsoft.operate.dao;

import com.yrsoft.operate.entity.OStaff;
import java.util.List;
import java.util.Map;
/**
 * 运营管理-人员 数据层
 * 
 * @author mz
 * @date 2019-02-23
 */
public interface OStaffDao
{
	/**
     * 查询运营管理-人员信息
     * 
     * @param id 运营管理-人员ID
     * @return 运营管理-人员信息
     */
	public OStaff selectOStaffById(String id);
	
	/**
     * 查询运营管理-人员列表
     * 
     * @param oStaff 运营管理-人员信息
     * @return 运营管理-人员集合
     */
	public List<OStaff> selectOStaffList(OStaff oStaff);
	
	/**
     * 新增运营管理-人员
     * 
     * @param oStaff 运营管理-人员信息
     * @return 结果
     */
	public int insertOStaff(OStaff oStaff);
	
	/**
     * 修改运营管理-人员
     * 
     * @param oStaff 运营管理-人员信息
     * @return 结果
     */
	public int updateOStaff(OStaff oStaff);
	
	/**
     * 删除运营管理-人员
     * 
     * @param id 运营管理-人员ID
     * @return 结果
     */
	public int updateOStaffByIds(Map<String, Object> param);

    /**
     * 删除运营管理-人员
     *
     * @param id 运营管理-人员ID
     * @return 结果
     */
    public int deleteOStaffById(Map<String, Object> param);
	
}