package com.yrsoft.website.service.impl;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

import com.yrsoft.common.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yrsoft.common.support.Convert;
import com.yrsoft.website.entity.WNews;
import com.yrsoft.website.dao.WNewsDao;
import com.yrsoft.website.service.WNewsService;



/**
 * 网站管理-消息 服务层实现
 * 
 * @author mz
 * @date 2019-02-23
 */
@Service
public class WNewsServiceImpl implements WNewsService
{
    @Autowired
    private WNewsDao wNewsDao;

	/**
     * 查询网站管理-消息信息
     * 
     * @param id 网站管理-消息ID
     * @return 网站管理-消息信息
     */
    @Override
	public JsonResult getWNewsById(String id)
	{
		WNews wNews = wNewsDao.selectWNewsById(id);
        if ( null == wNews ) {
			return JsonResult.error(201,"暂无数据");
        }
	    return JsonResult.success(wNews);
	}

    /**
     * 查询网站管理-消息列表
     * @param  page
     * @param  limit
     * @param wNews 网站管理-消息信息
     * @return 网站管理-消息集合
     */
    @Override
    public JsonResult list(Integer page,Integer limit,WNews wNews)
    {
        //开启分页
        PageHelper.startPage(page,limit);

        //获取数据
        List<WNews> lists =  wNewsDao.selectWNewsList(wNews);
        if (null == lists || lists.isEmpty()){
            return JsonResult.error(201,"暂无数据");
        }

        PageInfo<WNews> pageInfo = new PageInfo<>(lists);

        return JsonResult.createJsonResponse(pageInfo);
    }
	
    /**
     * 新增网站管理-消息
     * 
     * @param wNews 网站管理-消息信息
     * @return 结果
     */
	@Override
	public JsonResult add(WNews wNews)
	{

        int result = wNewsDao.insertWNews(wNews);
        if (result == 0) {
            return JsonResult.error(201,"添加失败");
        }
        return JsonResult.success(200,"添加成功");
	}
	
	/**
     * 修改网站管理-消息
     * 
     * @param wNews 网站管理-消息信息
     * @return 结果
     */
	@Override
	public JsonResult edit(WNews wNews)
	{
        int result = wNewsDao.updateWNews(wNews);
        if (result == 0) {
            return JsonResult.error(201,"更新失败");
        }
        return JsonResult.success(200,"更新成功");
	}

    /**
     * 更新网站消息<p>
     *
     * @param 
     * @return JsonResult
     */
    @Override
    public JsonResult update(Map<String,Object> paraMap)
    {
        int result = wNewsDao.updateWNewsByIds(paraMap);
        if (result == 0) {
            return JsonResult.error(201,"更新失败");
        }
        return JsonResult.success(200,"更新成功");
    }

	@Override
	public JsonResult countMessageByCondition(Map<String, Object> paraMap) {
		Integer rows = wNewsDao.countMessageByCondition(paraMap);
		return JsonResult.success(200, "success")
						  .setData(rows);
	}

	@Override
	public JsonResult selectNewsListByOrder(Map<String,Object> paramMap) {
		Integer page = Integer.valueOf(paramMap.get("page")+"");
		Integer limit = Integer.valueOf(paramMap.get("limit")+"");
		 //开启分页
        PageHelper.startPage(page,limit);

        //获取数据
        List<WNews> lists =  wNewsDao.selectNewsListByOrder(paramMap);
        if (null == lists || lists.isEmpty()){
            return JsonResult.error(201,"暂无数据");
        }

        PageInfo<WNews> pageInfo = new PageInfo<>(lists);

        return JsonResult.createJsonResponse(pageInfo);
	}

}
