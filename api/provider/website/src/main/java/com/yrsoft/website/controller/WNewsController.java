package com.yrsoft.website.controller;


import com.yrsoft.common.support.Convert;
import com.yrsoft.common.utils.JsonResult;
import com.yrsoft.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.apache.servicecomb.provider.rest.common.RestSchema;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.core.MediaType;
import com.yrsoft.website.entity.WNews;
import com.yrsoft.website.service.WNewsService;


/**
 * 网站管理-消息 信息操作处理
 * 
 * @author mz
 * @date 2019-02-23
 */
@RestSchema(schemaId = "wNews")
@RequestMapping(path = "/provider/wNews",produces = MediaType.APPLICATION_JSON)
public class WNewsController
{

	@Autowired
	private WNewsService wNewsService;

    /**
     * 查询网站管理-消息一个
     */
	@RequestMapping(value = "/getWNewsById",method = RequestMethod.POST)
	public JsonResult getWNewsById(String id){
	    if (StringUtils.isBlank(id)){
	        return JsonResult.error(201,"请传入主键编号");
		}


		return wNewsService.getWNewsById(id);
	}


    /**
     * 查询网站管理-消息列表
     */
	@RequestMapping(value = "/list",method = RequestMethod.POST)
	public JsonResult list(Integer page,Integer limit,WNews wNews){
        page =  page != null ? page:0;
        limit =  limit != null ?limit:10;
	    try {
            return wNewsService.list(page,limit,wNews);
        } catch (Exception e) {
            return JsonResult.error(207,"服务器错误");
        }
    }

    /**
     * 新增保存网站管理-消息
     */

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public JsonResult add(WNews wNews)
    {
        try {
            return wNewsService.add(wNews);
        } catch (Exception e) {
            return JsonResult.error(207,"服务器错误");
        }
    }

    /**
     * 修改保存网站管理-消息
     */

    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    public JsonResult edit(WNews wNews)
    {
        try {
            return wNewsService.edit(wNews);
        } catch (Exception e) {
            return JsonResult.error(207,"服务器错误");
        }

    }

    /**
     * 删除网站管理-消息
     */
    @RequestMapping(value = "/updateToRead",method = RequestMethod.POST)
    public JsonResult remove(String ids)
    {
        if (StringUtils.isBlank(ids)) {
            return JsonResult.error(201,"请传入要删除的编号");
        }
        try {
        	Map<String,Object> paraMap = new HashMap<>();
        	paraMap.put("ids",Convert.toStrArray(ids));
        	paraMap.put("isRead",1);
            return wNewsService.update(paraMap);
        } catch (Exception e) {
            return JsonResult.error(207,"服务器错误");
        }
    }
    
    /**
     * 根据条件查询消息行数<p>
     *
     * @param paraMap
     * @return 消息行数
     * @author:WANGQI
     * @date:2019年2月23日 下午1:44:50
     */
    @RequestMapping(value = "/count",method = RequestMethod.POST)
    public JsonResult countMessageByCondition(String shipperId) {
    	Map<String,Object> paraMap = new HashMap<>();
    	paraMap.put("memberId", shipperId);
    	paraMap.put("isRead", 0);
    	return wNewsService.countMessageByCondition(paraMap);
    }
    
    /**
     * 查询用户消息列表<p>
     * is_read ASC 排序,create_time DESC 排序<p>
     *
     * @param memberId
     * 		      用户ID
     * @param page
     * @param limit
     * @return JsonResult
     * @author WANGQI
     * @date 2019年2月26日 上午11:32:12
     */
    @RequestMapping(value = "/listByOrder",method = RequestMethod.POST)
	public JsonResult listByOrder(Integer page,Integer limit,String memberId,String createTime){
        page =  page != null ? page:0;
        limit =  limit != null ?limit:10;
        Map<String,Object> paramMap = new HashMap<>();
        paramMap.put("page", page);
        paramMap.put("limit", limit);
        paramMap.put("memberId", memberId);
        paramMap.put("createTime", createTime);
	    try {
            return wNewsService.selectNewsListByOrder(paramMap);
        } catch (Exception e) {
            return JsonResult.error(207,"服务器错误");
        }
    }
}
