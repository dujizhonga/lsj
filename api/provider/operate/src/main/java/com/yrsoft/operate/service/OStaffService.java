package com.yrsoft.operate.service;

import com.yrsoft.operate.entity.OStaff;
import com.yrsoft.common.utils.JsonResult;
import java.util.List;
import java.util.Map;

/**
 * 运营管理-人员 服务层
 * 
 * @author mz
 * @date 2019-02-23
 */
public interface OStaffService
{
	/**
     * 查询运营管理-人员信息
     * 
     * @param id 运营管理-人员ID
     * @return 运营管理-人员信息
     */
	public JsonResult getOStaffById(String id);
	
	/**
     * 查询运营管理-人员列表
     * 
     * @param oStaff 运营管理-人员信息
     * @return 运营管理-人员集合
     */
	public JsonResult list(Integer page, Integer limit, OStaff oStaff);
	
	/**
     * 新增运营管理-人员
     * 
     * @param oStaff 运营管理-人员信息
     * @return 结果
     */
	public JsonResult add(OStaff oStaff);
	
	/**
     * 修改运营管理-人员
     * 
     * @param oStaff 运营管理-人员信息
     * @return 结果
     */
	public JsonResult edit(OStaff oStaff);

    /**
     * 删除运营管理-人员信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public JsonResult remove(String ids);
	
}
