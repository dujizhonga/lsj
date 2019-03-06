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
import com.yrsoft.platform.entity.PBohaiInsuranceLog;
import com.yrsoft.platform.dao.PBohaiInsuranceLogDao;
import com.yrsoft.platform.service.PBohaiInsuranceLogService;



/**
 * 渤海保险承保记录 服务层实现
 * 
 * @author mz
 * @date 2019-03-06
 */
@Service
public class PBohaiInsuranceLogServiceImpl implements PBohaiInsuranceLogService
{
    @Autowired
    private PBohaiInsuranceLogDao pBohaiInsuranceLogDao;

	/**
     * 查询渤海保险承保记录信息
     * 
     * @param id 渤海保险承保记录ID
     * @return 渤海保险承保记录信息
     */
    @Override
	public JsonResult getPBohaiInsuranceLogById(String id)
	{
		PBohaiInsuranceLog pBohaiInsuranceLog = pBohaiInsuranceLogDao.selectPBohaiInsuranceLogById(id);
        if ( null == pBohaiInsuranceLog ) {
			return JsonResult.error(201,"暂无数据");
        }
	    return JsonResult.success(pBohaiInsuranceLog);
	}

    /**
     * 查询渤海保险承保记录列表
     * @param  page
     * @param  limit
     * @param pBohaiInsuranceLog 渤海保险承保记录信息
     * @return 渤海保险承保记录集合
     */
    @Override
    public JsonResult list(Integer page,Integer limit,PBohaiInsuranceLog pBohaiInsuranceLog)
    {
        //开启分页
        PageHelper.startPage(page,limit);

        //获取数据
        List<PBohaiInsuranceLog> lists =  pBohaiInsuranceLogDao.selectPBohaiInsuranceLogList(pBohaiInsuranceLog);
        if (null == lists || lists.isEmpty()){
            return JsonResult.error(201,"暂无数据");
        }

        PageInfo<PBohaiInsuranceLog> pageInfo = new PageInfo<>(lists);

        return JsonResult.createJsonResponse(pageInfo);
    }
	
    /**
     * 新增渤海保险承保记录
     * 
     * @param pBohaiInsuranceLog 渤海保险承保记录信息
     * @return 结果
     */
	@Override
	public JsonResult add(PBohaiInsuranceLog pBohaiInsuranceLog)
	{

        int result = pBohaiInsuranceLogDao.insertPBohaiInsuranceLog(pBohaiInsuranceLog);
        if (result == 0) {
            return JsonResult.error(201,"添加失败");
        }
        return JsonResult.success(200,"添加成功");
	}
	
	/**
     * 修改渤海保险承保记录
     * 
     * @param pBohaiInsuranceLog 渤海保险承保记录信息
     * @return 结果
     */
	@Override
	public JsonResult edit(PBohaiInsuranceLog pBohaiInsuranceLog)
	{
        int result = pBohaiInsuranceLogDao.updatePBohaiInsuranceLog(pBohaiInsuranceLog);
        if (result == 0) {
            return JsonResult.error(201,"更新失败");
        }
        return JsonResult.success(200,"更新成功");
	}

    /**
     * 删除渤海保险承保记录对象
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

        int result = pBohaiInsuranceLogDao.updatePBohaiInsuranceLogByIds(delete);
        if (result == 0) {
            return JsonResult.error(201,"删除失败");
        }
        return JsonResult.success(200,"删除成功");
    }

}
