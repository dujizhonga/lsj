package com.yrsoft.position.service.impl;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

import com.yrsoft.common.support.Convert;
import com.yrsoft.common.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yrsoft.position.entity.PoCarPositionLog;
import com.yrsoft.position.dao.PoCarPositionLogDao;
import com.yrsoft.position.service.PoCarPositionLogService;



/**
 * 位置-车辆历史位置坐标 服务层实现
 * 
 * @author mz
 * @date 2019-02-23
 */
@Service
public class PoCarPositionLogServiceImpl implements PoCarPositionLogService
{
    @Autowired
    private PoCarPositionLogDao poCarPositionLogDao;

	/**
     * 查询位置-车辆历史位置坐标信息
     * 
     * @param id 位置-车辆历史位置坐标ID
     * @return 位置-车辆历史位置坐标信息
     */
    @Override
	public JsonResult getPoCarPositionLogById(String id)
	{
		PoCarPositionLog poCarPositionLog = poCarPositionLogDao.selectPoCarPositionLogById(id);
        if ( null == poCarPositionLog ) {
			return JsonResult.error(201,"暂无数据");
        }
	    return JsonResult.success(poCarPositionLog);
	}

    /**
     * 查询位置-车辆历史位置坐标列表
     * @param  page
     * @param  limit
     * @param poCarPositionLog 位置-车辆历史位置坐标信息
     * @return 位置-车辆历史位置坐标集合
     */
    @Override
    public JsonResult list(Integer page,Integer limit,PoCarPositionLog poCarPositionLog)
    {
        //开启分页
        PageHelper.startPage(page,limit);

        //获取数据
        List<PoCarPositionLog> lists =  poCarPositionLogDao.selectPoCarPositionLogList(poCarPositionLog);
        if (null == lists || lists.isEmpty()){
            return JsonResult.error(201,"暂无数据");
        }

        PageInfo<PoCarPositionLog> pageInfo = new PageInfo<>(lists);

        return JsonResult.createJsonResponse(pageInfo);
    }
	
    /**
     * 新增位置-车辆历史位置坐标
     * 
     * @param poCarPositionLog 位置-车辆历史位置坐标信息
     * @return 结果
     */
	@Override
	public JsonResult add(PoCarPositionLog poCarPositionLog)
	{

        int result = poCarPositionLogDao.insertPoCarPositionLog(poCarPositionLog);
        if (result == 0) {
            return JsonResult.error(201,"添加失败");
        }
        return JsonResult.success(200,"添加成功");
	}
	
	/**
     * 修改位置-车辆历史位置坐标
     * 
     * @param poCarPositionLog 位置-车辆历史位置坐标信息
     * @return 结果
     */
	@Override
	public JsonResult edit(PoCarPositionLog poCarPositionLog)
	{
        int result = poCarPositionLogDao.updatePoCarPositionLog(poCarPositionLog);
        if (result == 0) {
            return JsonResult.error(201,"更新失败");
        }
        return JsonResult.success(200,"更新成功");
	}

    /**
     * 删除位置-车辆历史位置坐标对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public JsonResult remove(String ids)
    {
        Map<String,Object> delete = new HashMap<>();
        //数据库删除字段必须为delFlag
        delete.put("delFlag",1);
        delete.put("ids", Convert.toStrArray(ids));

        int result = poCarPositionLogDao.updatePoCarPositionLogByIds(delete);
        if (result == 0) {
            return JsonResult.error(201,"删除失败");
        }
        return JsonResult.success(200,"删除成功");
    }

}
