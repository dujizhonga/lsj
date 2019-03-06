package com.yrsoft.position.service.impl;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

import com.yrsoft.common.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yrsoft.common.support.Convert;
import com.yrsoft.position.entity.PoCarPosition;
import com.yrsoft.position.dao.PoCarPositionDao;
import com.yrsoft.position.service.PoCarPositionService;



/**
 * 位置-车辆位置及状态 服务层实现
 * 
 * @author mz
 * @date 2019-02-23
 */
@Service
public class PoCarPositionServiceImpl implements PoCarPositionService
{
    @Autowired
    private PoCarPositionDao poCarPositionDao;

	/**
     * 查询位置-车辆位置及状态信息
     * 
     * @param id 位置-车辆位置及状态ID
     * @return 位置-车辆位置及状态信息
     */
    @Override
	public JsonResult getPoCarPositionById(String id)
	{
		PoCarPosition poCarPosition = poCarPositionDao.selectPoCarPositionById(id);
        if ( null == poCarPosition ) {
			return JsonResult.error(201,"暂无数据");
        }
	    return JsonResult.success(poCarPosition);
	}

    /**
     * 查询位置-车辆位置及状态列表
     * @param  page
     * @param  limit
     * @param poCarPosition 位置-车辆位置及状态信息
     * @return 位置-车辆位置及状态集合
     */
    @Override
    public JsonResult list(Integer page,Integer limit,PoCarPosition poCarPosition)
    {
        //开启分页
        PageHelper.startPage(page,limit);

        //获取数据
        List<PoCarPosition> lists =  poCarPositionDao.selectPoCarPositionList(poCarPosition);
        if (null == lists || lists.isEmpty()){
            return JsonResult.error(201,"暂无数据");
        }

        PageInfo<PoCarPosition> pageInfo = new PageInfo<>(lists);

        return JsonResult.createJsonResponse(pageInfo);
    }
	
    /**
     * 新增位置-车辆位置及状态
     * 
     * @param poCarPosition 位置-车辆位置及状态信息
     * @return 结果
     */
	@Override
	public JsonResult add(PoCarPosition poCarPosition)
	{

        int result = poCarPositionDao.insertPoCarPosition(poCarPosition);
        if (result == 0) {
            return JsonResult.error(201,"添加失败");
        }
        return JsonResult.success(200,"添加成功");
	}
	
	/**
     * 修改位置-车辆位置及状态
     * 
     * @param poCarPosition 位置-车辆位置及状态信息
     * @return 结果
     */
	@Override
	public JsonResult edit(PoCarPosition poCarPosition)
	{
        int result = poCarPositionDao.updatePoCarPosition(poCarPosition);
        if (result == 0) {
            return JsonResult.error(201,"更新失败");
        }
        return JsonResult.success(200,"更新成功");
	}

    /**
     * 删除位置-车辆位置及状态对象
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
        delete.put("ids",Convert.toStrArray(ids));

        int result = poCarPositionDao.updatePoCarPositionByIds(delete);
        if (result == 0) {
            return JsonResult.error(201,"删除失败");
        }
        return JsonResult.success(200,"删除成功");
    }

}
