package com.yrsoft.auth.service;


import com.yrsoft.auth.entity.Company;
import com.yrsoft.common.utils.JsonResult;


/**
 * 认证管理-企业认证 服务层
 * 
 * @author mz
 * @date 2019-03-05
 */
public interface CompanyService
{
	/**
     * 查询认证管理-企业认证信息
     * 
     * @param id 认证管理-企业认证ID
     * @return 认证管理-企业认证信息
     */
	public JsonResult getCompanyById(String id);
	
	/**
     * 查询认证管理-企业认证列表
     * 
     * @param company 认证管理-企业认证信息
     * @return 认证管理-企业认证集合
     */
	public JsonResult list(Integer page, Integer limit, Company company);
	
	/**
     * 新增认证管理-企业认证
     * 
     * @param company 认证管理-企业认证信息
     * @return 结果
     */
	public JsonResult add(Company company);
	
	/**
     * 修改认证管理-企业认证
     * 
     * @param company 认证管理-企业认证信息
     * @return 结果
     */
	public JsonResult edit(Company company);

    /**
     * 删除认证管理-企业认证信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public JsonResult remove(String ids);
	
}
