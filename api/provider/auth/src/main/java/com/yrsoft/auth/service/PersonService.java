package com.yrsoft.auth.service;

import com.yrsoft.auth.entity.Person;
import com.yrsoft.common.utils.JsonResult;

/**
 * 认证管理-个人认证 服务层
 * 
 * @author mz
 * @date 2019-03-04
 */
public interface PersonService
{
	/**
     * 查询认证管理-个人认证信息
     * 
     * @param id 认证管理-个人认证ID
     * @return 认证管理-个人认证信息
     */
	public JsonResult getPersonById(String id);
	
	/**
     * 查询认证管理-个人认证列表
     * 
     * @param person 认证管理-个人认证信息
     * @return 认证管理-个人认证集合
     */
	public JsonResult list(Integer page,Integer limit,Person person);
	
	/**
     * 新增认证管理-个人认证
     * 
     * @param person 认证管理-个人认证信息
     * @return 结果
     */
	public JsonResult add(Person person);
	
	/**
     * 修改认证管理-个人认证
     * 
     * @param person 认证管理-个人认证信息
     * @return 结果
     */
	public JsonResult edit(Person person);

    /**
     * 删除认证管理-个人认证信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public JsonResult remove(String ids);
	
    /**
     * 根据用户ID查询用户的个人认证信息<p>
     * @param memberId
     * @return JsonResult
     * @author WANGQI
     * @date 2019年3月4日 下午7:12:18
     */
    public JsonResult selectPersonByMemberId(String memberId);
}
