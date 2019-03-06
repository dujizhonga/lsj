package com.yrsoft.auth.dao;

import com.yrsoft.auth.entity.Person;
import java.util.List;
import java.util.Map;
/**
 * 认证管理-个人认证 数据层
 * 
 * @author mz
 * @date 2019-03-04
 */
public interface PersonDao
{
	/**
     * 查询认证管理-个人认证信息
     * 
     * @param id 认证管理-个人认证ID
     * @return 认证管理-个人认证信息
     */
	public Person selectPersonById(String id);
	
	/**
     * 查询认证管理-个人认证列表
     * 
     * @param person 认证管理-个人认证信息
     * @return 认证管理-个人认证集合
     */
	public List<Person> selectPersonList(Person person);
	
	/**
     * 新增认证管理-个人认证
     * 
     * @param person 认证管理-个人认证信息
     * @return 结果
     */
	public int insertPerson(Person person);
	
	/**
     * 修改认证管理-个人认证
     * 
     * @param person 认证管理-个人认证信息
     * @return 结果
     */
	public int updatePerson(Person person);
	
	/**
     * 删除认证管理-个人认证
     * 
     * @param id 认证管理-个人认证ID
     * @return 结果
     */
	public int updatePersonByIds(Map<String,Object> param);

    /**
     * 删除认证管理-个人认证
     *
     * @param id 认证管理-个人认证ID
     * @return 结果
     */
    public int deletePersonById(Map<String,Object> param);
	
    /**
     * 根据用户ID查询用户的个人认证信息<p>
     * @param memberId
     * @return Person
     * @author WANGQI
     * @date 2019年3月4日 下午7:12:18
     */
    public Person selectPersonByMemberId(String memberId);
}