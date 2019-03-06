package com.yrsoft.auth.dao;


import com.yrsoft.auth.entity.Company;
import java.util.List;
import java.util.Map;
/**
 * 认证管理-企业认证 数据层
 * 
 * @author mz
 * @date 2019-03-05
 */
public interface CompanyDao
{
	/**
     * 查询认证管理-企业认证信息
     * 
     * @param id 认证管理-企业认证ID
     * @return 认证管理-企业认证信息
     */
	public Company selectCompanyById(String id);
	
	/**
     * 查询认证管理-企业认证列表
     * 
     * @param company 认证管理-企业认证信息
     * @return 认证管理-企业认证集合
     */
	public List<Company> selectCompanyList(Company company);
	
	/**
     * 新增认证管理-企业认证
     * 
     * @param company 认证管理-企业认证信息
     * @return 结果
     */
	public int insertCompany(Company company);
	
	/**
     * 修改认证管理-企业认证
     * 
     * @param company 认证管理-企业认证信息
     * @return 结果
     */
	public int updateCompany(Company company);
	
	/**
     * 删除认证管理-企业认证
     * 
     * @param param 认证管理-企业认证ID
     * @return 结果
     */
	public int updateCompanyByIds(Map<String, Object> param);

    /**
     * 删除认证管理-企业认证
     *
     * @param param 认证管理-企业认证ID
     * @return 结果
     */
    public int deleteCompanyById(Map<String, Object> param);
	
}