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
import com.yrsoft.platform.entity.PMarginRecords;
import com.yrsoft.platform.dao.PMarginRecordsDao;
import com.yrsoft.platform.service.PMarginRecordsService;



/**
 * 货运-支付保证金记录 服务层实现
 * 
 * @author mz
 * @date 2019-02-23
 */
@Service
public class PMarginRecordsServiceImpl implements PMarginRecordsService
{
    @Autowired
    private PMarginRecordsDao pMarginRecordsDao;

	/**
     * 查询货运-支付保证金记录信息
     * 
     * @param id 货运-支付保证金记录ID
     * @return 货运-支付保证金记录信息
     */
    @Override
	public JsonResult getPMarginRecordsById(String id)
	{
		PMarginRecords pMarginRecords = pMarginRecordsDao.selectPMarginRecordsById(id);
        if ( null == pMarginRecords ) {
			return JsonResult.error(201,"暂无数据");
        }
	    return JsonResult.success(pMarginRecords);
	}

    /**
     * 查询货运-支付保证金记录列表
     * @param  page
     * @param  limit
     * @param pMarginRecords 货运-支付保证金记录信息
     * @return 货运-支付保证金记录集合
     */
    @Override
    public JsonResult list(Integer page,Integer limit,PMarginRecords pMarginRecords)
    {
        //开启分页
        PageHelper.startPage(page,limit);

        //获取数据
        List<PMarginRecords> lists =  pMarginRecordsDao.selectPMarginRecordsList(pMarginRecords);
        if (null == lists || lists.isEmpty()){
            return JsonResult.error(201,"暂无数据");
        }

        PageInfo<PMarginRecords> pageInfo = new PageInfo<>(lists);

        return JsonResult.createJsonResponse(pageInfo);
    }
	
    /**
     * 新增货运-支付保证金记录
     * 
     * @param pMarginRecords 货运-支付保证金记录信息
     * @return 结果
     */
	@Override
	public JsonResult add(PMarginRecords pMarginRecords)
	{

        int result = pMarginRecordsDao.insertPMarginRecords(pMarginRecords);
        if (result == 0) {
            return JsonResult.error(201,"添加失败");
        }
        return JsonResult.success(200,"添加成功");
	}
	
	/**
     * 修改货运-支付保证金记录
     * 
     * @param pMarginRecords 货运-支付保证金记录信息
     * @return 结果
     */
	@Override
	public JsonResult edit(PMarginRecords pMarginRecords)
	{
        int result = pMarginRecordsDao.updatePMarginRecords(pMarginRecords);
        if (result == 0) {
            return JsonResult.error(201,"更新失败");
        }
        return JsonResult.success(200,"更新成功");
	}

    /**
     * 删除货运-支付保证金记录对象
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

        int result = pMarginRecordsDao.updatePMarginRecordsByIds(delete);
        if (result == 0) {
            return JsonResult.error(201,"删除失败");
        }
        return JsonResult.success(200,"删除成功");
    }

}
