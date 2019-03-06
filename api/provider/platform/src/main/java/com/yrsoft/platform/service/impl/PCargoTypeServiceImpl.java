package com.yrsoft.platform.service.impl;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

import com.yrsoft.common.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yrsoft.common.support.Convert;
import com.yrsoft.platform.entity.PCargoType;
import com.yrsoft.platform.dao.PCargoTypeDao;
import com.yrsoft.platform.service.PCargoTypeService;



/**
 * 货运-货物类别 服务层实现
 * 
 * @author mz
 * @date 2019-02-23
 */
@Service
public class PCargoTypeServiceImpl implements PCargoTypeService
{
    @Autowired
    private PCargoTypeDao pCargoTypeDao;

	/**
     * 查询货运-货物类别信息
     * 
     * @param id 货运-货物类别ID
     * @return 货运-货物类别信息
     */
    @Override
	public JsonResult getPCargoTypeById(String id)
	{
		PCargoType pCargoType = pCargoTypeDao.selectPCargoTypeById(id);
        if ( null == pCargoType ) {
			return JsonResult.error(201,"暂无数据");
        }
	    return JsonResult.success(pCargoType);
	}

    /**
     * 查询货运-货物类别列表
     * @param  page
     * @param  limit
     * @param pCargoType 货运-货物类别信息
     * @return 货运-货物类别集合
     */
    @Override
    public JsonResult list(Integer page,Integer limit,PCargoType pCargoType)
    {
        //开启分页
        PageHelper.startPage(page,limit);

        //获取数据
        List<PCargoType> lists =  pCargoTypeDao.selectPCargoTypeList(pCargoType);
        if (null == lists || lists.isEmpty()){
            return JsonResult.error(201,"暂无数据");
        }

        PageInfo<PCargoType> pageInfo = new PageInfo<>(lists);

        return JsonResult.createJsonResponse(pageInfo);
    }
	
    /**
     * 新增货运-货物类别
     * 
     * @param pCargoType 货运-货物类别信息
     * @return 结果
     */
	@Override
	public JsonResult add(PCargoType pCargoType)
	{

        int result = pCargoTypeDao.insertPCargoType(pCargoType);
        if (result == 0) {
            return JsonResult.error(201,"添加失败");
        }
        return JsonResult.success(200,"添加成功");
	}
	
	/**
     * 修改货运-货物类别
     * 
     * @param pCargoType 货运-货物类别信息
     * @return 结果
     */
	@Override
	public JsonResult edit(PCargoType pCargoType)
	{
        int result = pCargoTypeDao.updatePCargoType(pCargoType);
        if (result == 0) {
            return JsonResult.error(201,"更新失败");
        }
        return JsonResult.success(200,"更新成功");
	}

    /**
     * 删除货运-货物类别对象
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

        int result = pCargoTypeDao.updatePCargoTypeByIds(delete);
        if (result == 0) {
            return JsonResult.error(201,"删除失败");
        }
        return JsonResult.success(200,"删除成功");
    }

}
