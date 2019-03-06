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
import com.yrsoft.platform.entity.PFreighRecords;
import com.yrsoft.platform.dao.PFreighRecordsDao;
import com.yrsoft.platform.service.PFreighRecordsService;



/**
 * 货运-支付运费记录 服务层实现
 * 
 * @author mz
 * @date 2019-02-23
 */
@Service
public class PFreighRecordsServiceImpl implements PFreighRecordsService
{
    @Autowired
    private PFreighRecordsDao pFreighRecordsDao;

	/**
     * 查询货运-支付运费记录信息
     * 
     * @param id 货运-支付运费记录ID
     * @return 货运-支付运费记录信息
     */
    @Override
	public JsonResult getPFreighRecordsById(String id)
	{
		PFreighRecords pFreighRecords = pFreighRecordsDao.selectPFreighRecordsById(id);
        if ( null == pFreighRecords ) {
			return JsonResult.error(201,"暂无数据");
        }
	    return JsonResult.success(pFreighRecords);
	}

    /**
     * 查询货运-支付运费记录列表
     * @param  page
     * @param  limit
     * @param pFreighRecords 货运-支付运费记录信息
     * @return 货运-支付运费记录集合
     */
    @Override
    public JsonResult list(Integer page,Integer limit,PFreighRecords pFreighRecords)
    {
        //开启分页
        PageHelper.startPage(page,limit);

        //获取数据
        List<PFreighRecords> lists =  pFreighRecordsDao.selectPFreighRecordsList(pFreighRecords);
        if (null == lists || lists.isEmpty()){
            return JsonResult.error(201,"暂无数据");
        }

        PageInfo<PFreighRecords> pageInfo = new PageInfo<>(lists);

        return JsonResult.createJsonResponse(pageInfo);
    }
	
    /**
     * 新增货运-支付运费记录
     * 
     * @param pFreighRecords 货运-支付运费记录信息
     * @return 结果
     */
	@Override
	public JsonResult add(PFreighRecords pFreighRecords)
	{

        int result = pFreighRecordsDao.insertPFreighRecords(pFreighRecords);
        if (result == 0) {
            return JsonResult.error(201,"添加失败");
        }
        return JsonResult.success(200,"添加成功");
	}
	
	/**
     * 修改货运-支付运费记录
     * 
     * @param pFreighRecords 货运-支付运费记录信息
     * @return 结果
     */
	@Override
	public JsonResult edit(PFreighRecords pFreighRecords)
	{
        int result = pFreighRecordsDao.updatePFreighRecords(pFreighRecords);
        if (result == 0) {
            return JsonResult.error(201,"更新失败");
        }
        return JsonResult.success(200,"更新成功");
	}

    /**
     * 删除货运-支付运费记录对象
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

        int result = pFreighRecordsDao.updatePFreighRecordsByIds(delete);
        if (result == 0) {
            return JsonResult.error(201,"删除失败");
        }
        return JsonResult.success(200,"删除成功");
    }

}
