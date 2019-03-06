package com.yrsoft.website.dao;

import com.yrsoft.website.entity.WNews;
import java.util.List;
import java.util.Map;
/**
 * 网站管理-消息 数据层
 * 
 * @author mz
 * @date 2019-02-23
 */
public interface WNewsDao
{
	/**
     * 查询网站管理-消息信息
     * 
     * @param id 网站管理-消息ID
     * @return 网站管理-消息信息
     */
	public WNews selectWNewsById(String id);
	
	/**
     * 查询网站管理-消息列表
     * 
     * @param wNews 网站管理-消息信息
     * @return 网站管理-消息集合
     */
	public List<WNews> selectWNewsList(WNews wNews);
	
	/**
     * 新增网站管理-消息
     * 
     * @param wNews 网站管理-消息信息
     * @return 结果
     */
	public int insertWNews(WNews wNews);
	
	/**
     * 修改网站管理-消息
     * 
     * @param wNews 网站管理-消息信息
     * @return 结果
     */
	public int updateWNews(WNews wNews);
	
	/**
     * 更新网站管理-消息
     * 
     * @param 消息ID数组,要更新的字段
     * @return 结果
     */
	public int updateWNewsByIds(Map<String, Object> param);

    /**
     * 删除网站管理-消息
     *
     * @param id 网站管理-消息ID
     * @return 结果
     */
    public int deleteWNewsById(Map<String, Object> param);
	
    /**
     * 根据条件查询消息行数<p>
     *
     * @param paraMap
     * @return 消息行数
     * @author:WANGQI
     * @date:2019年2月23日 下午1:44:50
     */
    public Integer countMessageByCondition(Map<String, Object> paraMap);
    
    /**
     * 查询用户消息列表<p>
     * is_read ASC 排序,create_time DESC 排序<p>
     *
     * @param memberId
     * @param createTime
     * @return {@code List<WNews>}
     * @author WANGQI
     * @date 2019年2月26日 上午11:32:12
     */
    public List<WNews> selectNewsListByOrder(Map<String,Object> paramMap);
}