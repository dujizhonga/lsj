package com.yrsoft.system.service.impl;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

import com.yrsoft.common.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yrsoft.common.support.Convert;
import com.yrsoft.system.entity.SProtocol;
import com.yrsoft.system.dao.SProtocolDao;
import com.yrsoft.system.service.SProtocolService;



/**
 * 系统-协议 服务层实现
 * 
 * @author mz
 * @date 2019-02-23
 */
@Service
public class SProtocolServiceImpl implements SProtocolService
{
    @Autowired
    private SProtocolDao sProtocolDao;

	/**
     * 查询系统-协议信息
     * 
     * @param id 系统-协议ID
     * @return 系统-协议信息
     */
    @Override
	public JsonResult getSProtocolById(String id)
	{
		SProtocol sProtocol = sProtocolDao.selectSProtocolById(id);
        if ( null == sProtocol ) {
			return JsonResult.error(201,"暂无数据");
        }
	    return JsonResult.success(sProtocol);
	}

    /**
     * 查询系统-协议列表
     * @param  page
     * @param  limit
     * @param sProtocol 系统-协议信息
     * @return 系统-协议集合
     */
    @Override
    public JsonResult list(Integer page,Integer limit,SProtocol sProtocol)
    {
        //开启分页
        PageHelper.startPage(page,limit);

        //获取数据
        List<SProtocol> lists =  sProtocolDao.selectSProtocolList(sProtocol);
        if (null == lists || lists.isEmpty()){
            return JsonResult.error(201,"暂无数据");
        }

        PageInfo<SProtocol> pageInfo = new PageInfo<>(lists);

        return JsonResult.createJsonResponse(pageInfo);
    }
	
    /**
     * 新增系统-协议
     * 
     * @param sProtocol 系统-协议信息
     * @return 结果
     */
	@Override
	public JsonResult add(SProtocol sProtocol)
	{

        int result = sProtocolDao.insertSProtocol(sProtocol);
        if (result == 0) {
            return JsonResult.error(201,"添加失败");
        }
        return JsonResult.success(200,"添加成功");
	}
	
	/**
     * 修改系统-协议
     * 
     * @param sProtocol 系统-协议信息
     * @return 结果
     */
	@Override
	public JsonResult edit(SProtocol sProtocol)
	{
        int result = sProtocolDao.updateSProtocol(sProtocol);
        if (result == 0) {
            return JsonResult.error(201,"更新失败");
        }
        return JsonResult.success(200,"更新成功");
	}

    /**
     * 删除系统-协议对象
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

        int result = sProtocolDao.updateSProtocolByIds(delete);
        if (result == 0) {
            return JsonResult.error(201,"删除失败");
        }
        return JsonResult.success(200,"删除成功");
    }

}
