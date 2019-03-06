package com.yrsoft.system.service.impl;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

import com.yrsoft.common.support.Convert;
import com.yrsoft.common.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yrsoft.system.entity.SData;
import com.yrsoft.system.dao.SDataDao;
import com.yrsoft.system.service.SDataService;



/**
 * 系统-数据字典 服务层实现
 * 
 * @author mz
 * @date 2019-02-23
 */
@Service
public class SDataServiceImpl implements SDataService
{
    @Autowired
    private SDataDao sDataDao;

	/**
     * 查询系统-数据字典信息
     * 
     * @param id 系统-数据字典ID
     * @return 系统-数据字典信息
     */
    @Override
	public JsonResult getSDataById(String id)
	{
		SData sData = sDataDao.selectSDataById(id);
        if ( null == sData ) {
			return JsonResult.error(201,"暂无数据");
        }
	    return JsonResult.success(sData);
	}

    /**
     * 查询系统-数据字典列表
     * @param  page
     * @param  limit
     * @param sData 系统-数据字典信息
     * @return 系统-数据字典集合
     */
    @Override
    public JsonResult list(Integer page,Integer limit,SData sData)
    {
        //开启分页
        PageHelper.startPage(page,limit);

        //获取数据
        List<SData> lists =  sDataDao.selectSDataList(sData);
        if (null == lists || lists.isEmpty()){
            return JsonResult.error(201,"暂无数据");
        }

        PageInfo<SData> pageInfo = new PageInfo<>(lists);

        return JsonResult.createJsonResponse(pageInfo);
    }
	
    /**
     * 新增系统-数据字典
     * 
     * @param sData 系统-数据字典信息
     * @return 结果
     */
	@Override
	public JsonResult add(SData sData)
	{

        int result = sDataDao.insertSData(sData);
        if (result == 0) {
            return JsonResult.error(201,"添加失败");
        }
        return JsonResult.success(200,"添加成功");
	}
	
	/**
     * 修改系统-数据字典
     * 
     * @param sData 系统-数据字典信息
     * @return 结果
     */
	@Override
	public JsonResult edit(SData sData)
	{
        int result = sDataDao.updateSData(sData);
        if (result == 0) {
            return JsonResult.error(201,"更新失败");
        }
        return JsonResult.success(200,"更新成功");
	}

    /**
     * 删除系统-数据字典对象
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

        int result = sDataDao.updateSDataByIds(delete);
        if (result == 0) {
            return JsonResult.error(201,"删除失败");
        }
        return JsonResult.success(200,"删除成功");
    }

    /**
     * 按类型查询-数据字典
     * @param type
     * @return
     */
    public JsonResult selectDataByType(String type){
        List<String> list = sDataDao.selectDataByType(type);
        if(list.isEmpty()){
            return JsonResult.error(201,"暂无数据");
        }
        return JsonResult.success(list);
    }

}
