package com.yrsoft.finance.service.impl;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

import com.yrsoft.common.utils.JsonResult;
import com.yrsoft.finance.dao.MPayLogDao;
import com.yrsoft.finance.entity.MPayLog;
import com.yrsoft.finance.service.MPayLogService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yrsoft.common.support.Convert;
/**
 * 会员管理-支付记录 服务层实现
 * 
 * @author mz
 * @date 2019-02-23
 */
@Service
public class MPayLogServiceImpl implements MPayLogService
{
    @Autowired
    private MPayLogDao mPayLogDao;

	/**
     * 查询会员管理-支付记录信息
     * 
     * @param id 会员管理-支付记录ID
     * @return 会员管理-支付记录信息
     */
    @Override
	public JsonResult getMPayLogById(String id)
	{
		MPayLog mPayLog = mPayLogDao.selectMPayLogById(id);
        if ( null == mPayLog ) {
			return JsonResult.error(201,"暂无数据");
        }
	    return JsonResult.success(mPayLog);
	}

    /**
     * 查询会员管理-支付记录列表
     * @param  page
     * @param  limit
     * @param mPayLog 会员管理-支付记录信息
     * @return 会员管理-支付记录集合
     */
    @Override
    public JsonResult list(Integer page,Integer limit,MPayLog mPayLog)
    {
        //开启分页
        PageHelper.startPage(page,limit);

        //获取数据
        List<MPayLog> lists =  mPayLogDao.selectMPayLogList(mPayLog);
        if (null == lists || lists.isEmpty()){
            return JsonResult.error(201,"暂无数据");
        }

        PageInfo<MPayLog> pageInfo = new PageInfo<>(lists);

        return JsonResult.createJsonResponse(pageInfo);
    }
	
    /**
     * 新增会员管理-支付记录
     * 
     * @param mPayLog 会员管理-支付记录信息
     * @return 结果
     */
	@Override
	public JsonResult add(MPayLog mPayLog)
	{

        int result = mPayLogDao.insertMPayLog(mPayLog);
        if (result == 0) {
            return JsonResult.error(201,"添加失败");
        }
        return JsonResult.success(200,"添加成功");
	}
	
	/**
     * 修改会员管理-支付记录
     * 
     * @param mPayLog 会员管理-支付记录信息
     * @return 结果
     */
	@Override
	public JsonResult edit(MPayLog mPayLog)
	{
        int result = mPayLogDao.updateMPayLog(mPayLog);
        if (result == 0) {
            return JsonResult.error(201,"更新失败");
        }
        return JsonResult.success(200,"更新成功");
	}

    /**
     * 删除会员管理-支付记录对象
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

        int result = mPayLogDao.updateMPayLogByIds(delete);
        if (result == 0) {
            return JsonResult.error(201,"删除失败");
        }
        return JsonResult.success(200,"删除成功");
    }

}
