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
import com.yrsoft.platform.entity.PCargoName;
import com.yrsoft.platform.dao.PCargoNameDao;
import com.yrsoft.platform.service.PCargoNameService;



/**
 * 货运-货物名称 服务层实现
 * 
 * @author mz
 * @date 2019-02-23
 */
@Service
public class PCargoNameServiceImpl implements PCargoNameService
{
    @Autowired
    private PCargoNameDao pCargoNameDao;

	/**
     * 查询货运-货物名称信息
     * 
     * @param id 货运-货物名称ID
     * @return 货运-货物名称信息
     */
    @Override
	public JsonResult getPCargoNameById(String id)
	{
		PCargoName pCargoName = pCargoNameDao.selectPCargoNameById(id);
        if ( null == pCargoName ) {
			return JsonResult.error(201,"暂无数据");
        }
	    return JsonResult.success(pCargoName);
	}

    /**
     * 查询货运-货物名称列表
     * @param  page
     * @param  limit
     * @param pCargoName 货运-货物名称信息
     * @return 货运-货物名称集合
     */
    @Override
    public JsonResult list(Integer page,Integer limit,PCargoName pCargoName)
    {
        //开启分页
        PageHelper.startPage(page,limit);

        //获取数据
        List<PCargoName> lists =  pCargoNameDao.selectPCargoNameList(pCargoName);
        if (null == lists || lists.isEmpty()){
            return JsonResult.error(201,"暂无数据");
        }

        PageInfo<PCargoName> pageInfo = new PageInfo<>(lists);

        return JsonResult.createJsonResponse(pageInfo);
    }
	
    /**
     * 新增货运-货物名称
     * 
     * @param pCargoName 货运-货物名称信息
     * @return 结果
     */
	@Override
	public JsonResult add(PCargoName pCargoName)
	{

        int result = pCargoNameDao.insertPCargoName(pCargoName);
        if (result == 0) {
            return JsonResult.error(201,"添加失败");
        }
        return JsonResult.success(200,"添加成功");
	}
	
	/**
     * 修改货运-货物名称
     * 
     * @param pCargoName 货运-货物名称信息
     * @return 结果
     */
	@Override
	public JsonResult edit(PCargoName pCargoName)
	{
        int result = pCargoNameDao.updatePCargoName(pCargoName);
        if (result == 0) {
            return JsonResult.error(201,"更新失败");
        }
        return JsonResult.success(200,"更新成功");
	}

    /**
     * 删除货运-货物名称对象
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

        int result = pCargoNameDao.updatePCargoNameByIds(delete);
        if (result == 0) {
            return JsonResult.error(201,"删除失败");
        }
        return JsonResult.success(200,"删除成功");
    }

    /**
     * 查询货运-货物名称列表:根据货物名称查询货物列表
     */
	@Override
	public JsonResult goodsInfoList(PCargoName pCargoName) {
		 Map<String,Object> infoMap = new HashMap<>();
		 infoMap.put("name", pCargoName.getName());
		 //删除状态（0：未删除，1：已删除）
		 infoMap.put("deleteFlag", 0);
        //获取数据
        List<PCargoName> lists =  pCargoNameDao.goodsInfoList(infoMap);
        if (null == lists || lists.isEmpty()){
            return JsonResult.error(201,"暂无数据");
        }

        return JsonResult.success(lists);
	}

}
