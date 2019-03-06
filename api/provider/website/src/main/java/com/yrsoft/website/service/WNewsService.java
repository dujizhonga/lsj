package com.yrsoft.website.service;

import com.yrsoft.website.entity.WNews;
import com.yrsoft.common.utils.JsonResult;
import java.util.Map;

/**
 * 网站管理-消息 服务层
 * 
 * @author mz
 * @date 2019-02-23
 */
public interface WNewsService
{
	/**
     * 查询网站管理-消息信息
     * 
     * @param id 网站管理-消息ID
     * @return 网站管理-消息信息
     */
	public JsonResult getWNewsById(String id);
	
	/**
     * 查询网站管理-消息列表
     * 
     * @param wNews 网站管理-消息信息
     * @return 网站管理-消息集合
     */
	public JsonResult list(Integer page, Integer limit, WNews wNews);
	
	/**
     * 新增网站管理-消息
     * 
     * @param wNews 网站管理-消息信息
     * @return 结果
     */
	public JsonResult add(WNews wNews);
	
	/**
     * 修改网站管理-消息
     * 
     * @param wNews 网站管理-消息信息
     * @return 结果
     */
	public JsonResult edit(WNews wNews);

	/**
	 * 更新消息<p>
	 *
	 * @param paraMap
	 * @return 
	 * @author WANGQI
	 * @date 2019年2月26日 下午4:19:09
	 */
    public JsonResult update(Map<String,Object> paraMap);
    
    /**
     * 根据条件查询消息行数<p>
     *
     * @param paraMap
     * @return JsonResult
     * @author WANGQI
     * @date:2019年2月23日 下午1:44:50
     */
    public JsonResult countMessageByCondition(Map<String, Object> paraMap);
	
    /**
     * 查询用户消息列表<p>
     * is_read ASC 排序,create_time DESC 排序<p>
     *
     * @param memberId
     * 		      用户ID
     * @param createTime
     * 		      列表查询第一条数据的创建时间,用于筛选分页查询第二页数据
     * @param page
     * @param limit
     * @return JsonResult
     * @author WANGQI
     * @date 2019年2月26日 上午11:32:12
     */
    public JsonResult selectNewsListByOrder(Map<String,Object> paramMap);
}
