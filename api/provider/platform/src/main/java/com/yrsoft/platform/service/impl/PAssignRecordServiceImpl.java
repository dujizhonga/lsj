package com.yrsoft.platform.service.impl;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

import com.yrsoft.common.support.Convert;
import com.yrsoft.common.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yrsoft.platform.entity.PAssignRecord;
import com.yrsoft.platform.dao.PAssignRecordDao;
import com.yrsoft.platform.service.PAssignRecordService;



/**
 * 货运-分派记录 服务层实现
 * 
 * @author mz
 * @date 2019-02-23
 */
@Service
public class PAssignRecordServiceImpl implements PAssignRecordService
{
    @Autowired
    private PAssignRecordDao pAssignRecordDao;

	/**
     * 查询货运-分派记录信息
     * 
     * @param id 货运-分派记录ID
     * @return 货运-分派记录信息
     */
    @Override
	public JsonResult getPAssignRecordById(String id)
	{
		PAssignRecord pAssignRecord = pAssignRecordDao.selectPAssignRecordById(id);
        if ( null == pAssignRecord ) {
			return JsonResult.error(201,"暂无数据");
        }
	    return JsonResult.success(pAssignRecord);
	}

    /**
     * 查询货运-分派记录列表
     * @param  page
     * @param  limit
     * @param pAssignRecord 货运-分派记录信息
     * @return 货运-分派记录集合
     */
    @Override
    public JsonResult list(Integer page,Integer limit,PAssignRecord pAssignRecord)
    {
        //开启分页
        PageHelper.startPage(page,limit);

        //获取数据
        List<PAssignRecord> lists =  pAssignRecordDao.selectPAssignRecordList(pAssignRecord);
        if (null == lists || lists.isEmpty()){
            return JsonResult.error(201,"暂无数据");
        }

        PageInfo<PAssignRecord> pageInfo = new PageInfo<>(lists);

        return JsonResult.createJsonResponse(pageInfo);
    }
	
    /**
     * 新增货运-分派记录
     * 
     * @param pAssignRecord 货运-分派记录信息
     * @return 结果
     */
	@Override
	public JsonResult add(PAssignRecord pAssignRecord)
	{

        int result = pAssignRecordDao.insertPAssignRecord(pAssignRecord);
        if (result == 0) {
            return JsonResult.error(201,"添加失败");
        }
        return JsonResult.success(200,"添加成功");
	}
	
	/**
     * 修改货运-分派记录
     * 
     * @param pAssignRecord 货运-分派记录信息
     * @return 结果
     */
	@Override
	public JsonResult edit(PAssignRecord pAssignRecord)
	{
        int result = pAssignRecordDao.updatePAssignRecord(pAssignRecord);
        if (result == 0) {
            return JsonResult.error(201,"更新失败");
        }
        return JsonResult.success(200,"更新成功");
	}

    /**
     * 删除货运-分派记录对象
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

        int result = pAssignRecordDao.updatePAssignRecordByIds(delete);
        if (result == 0) {
            return JsonResult.error(201,"删除失败");
        }
        return JsonResult.success(200,"删除成功");
    }

}
