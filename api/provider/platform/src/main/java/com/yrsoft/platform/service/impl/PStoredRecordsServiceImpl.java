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
import com.yrsoft.platform.entity.PStoredRecords;
import com.yrsoft.platform.entity.PStoredRecordsVo;
import com.yrsoft.platform.dao.PStoredRecordsDao;
import com.yrsoft.platform.service.PStoredRecordsService;



/**
 * 货运-储值记录 服务层实现
 * 
 * @author mz
 * @date 2019-02-23
 */
@Service
public class PStoredRecordsServiceImpl implements PStoredRecordsService
{
    @Autowired
    private PStoredRecordsDao pStoredRecordsDao;

	/**
     * 查询货运-储值记录信息
     * 
     * @param id 货运-储值记录ID
     * @return 货运-储值记录信息
     */
    @Override
	public JsonResult getPStoredRecordsById(String id)
	{
		PStoredRecords pStoredRecords = pStoredRecordsDao.selectPStoredRecordsById(id);
        if ( null == pStoredRecords ) {
			return JsonResult.error(201,"暂无数据");
        }
	    return JsonResult.success(pStoredRecords);
	}

    /**
     * 查询货运-储值记录列表
     * @param  page
     * @param  limit
     * @param pStoredRecords 货运-储值记录信息
     * @return 货运-储值记录集合
     */
    @Override
    public JsonResult list(Integer page,Integer limit,PStoredRecords pStoredRecords)
    {
        //开启分页
        PageHelper.startPage(page,limit);

        //获取数据
        List<PStoredRecords> lists =  pStoredRecordsDao.selectPStoredRecordsList(pStoredRecords);
        if (null == lists || lists.isEmpty()){
            return JsonResult.error(201,"暂无数据");
        }

        PageInfo<PStoredRecords> pageInfo = new PageInfo<>(lists);

        return JsonResult.createJsonResponse(pageInfo);
    }
	
    /**
     * 新增货运-储值记录
     * 
     * @param pStoredRecords 货运-储值记录信息
     * @return 结果
     */
	@Override
	public JsonResult add(PStoredRecords pStoredRecords)
	{

        int result = pStoredRecordsDao.insertPStoredRecords(pStoredRecords);
        if (result == 0) {
            return JsonResult.error(201,"添加失败");
        }
        return JsonResult.success(200,"添加成功");
	}
	
	/**
     * 修改货运-储值记录
     * 
     * @param pStoredRecords 货运-储值记录信息
     * @return 结果
     */
	@Override
	public JsonResult edit(PStoredRecords pStoredRecords)
	{
        int result = pStoredRecordsDao.updatePStoredRecords(pStoredRecords);
        if (result == 0) {
            return JsonResult.error(201,"更新失败");
        }
        return JsonResult.success(200,"更新成功");
	}

    /**
     * 删除货运-储值记录对象
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

        int result = pStoredRecordsDao.updatePStoredRecordsByIds(delete);
        if (result == 0) {
            return JsonResult.error(201,"删除失败");
        }
        return JsonResult.success(200,"删除成功");
    }
    /**
     * 生产资料分配记录列表
     * shihh
     */
	@Override
	public JsonResult getPSoredList(Integer page, Integer limit, String shipperId) {
		//开启分页
        PageHelper.startPage(page,limit);

        //获取数据
        List<PStoredRecordsVo> lists =  pStoredRecordsDao.getPSoredList(shipperId);
        if (null == lists || lists.isEmpty()){
            return JsonResult.error(201,"暂无数据");
        }

        PageInfo<PStoredRecordsVo> pageInfo = new PageInfo<>(lists);

        return JsonResult.createJsonResponse(pageInfo);
	}
	
	@Override
	public JsonResult getPSoredById(String id) {
		PStoredRecordsVo pStoredRecords = pStoredRecordsDao.selectPStoredById(id);
        if ( null == pStoredRecords ) {
			return JsonResult.error(201,"暂无数据");
        }
	    return JsonResult.success(pStoredRecords);
	}

}
