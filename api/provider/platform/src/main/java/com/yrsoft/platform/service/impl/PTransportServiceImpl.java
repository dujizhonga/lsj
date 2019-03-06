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
import com.yrsoft.platform.entity.PTransport;
import com.yrsoft.platform.dao.PTransportDao;
import com.yrsoft.platform.service.PTransportService;



/**
 * 货运-运输单 服务层实现
 * 
 * @author mz
 * @date 2019-02-23
 */
@Service
public class PTransportServiceImpl implements PTransportService
{
    @Autowired
    private PTransportDao pTransportDao;

	/**
     * 查询货运-运输单信息
     * 
     * @param id 货运-运输单ID
     * @return 货运-运输单信息
     */
    @Override
	public JsonResult getPTransportById(String id)
	{
		PTransport pTransport = pTransportDao.selectPTransportById(id);
        if ( null == pTransport ) {
			return JsonResult.error(201,"暂无数据");
        }
	    return JsonResult.success(pTransport);
	}

    /**
     * 查询货运-运输单列表
     * @param  page
     * @param  limit
     * @param pTransport 货运-运输单信息
     * @return 货运-运输单集合
     */
    @Override
    public JsonResult list(Integer page,Integer limit,PTransport pTransport)
    {
        //开启分页
        PageHelper.startPage(page,limit);

        //获取数据
        List<PTransport> lists =  pTransportDao.selectPTransportList(pTransport);
        if (null == lists || lists.isEmpty()){
            return JsonResult.error(201,"暂无数据");
        }

        PageInfo<PTransport> pageInfo = new PageInfo<>(lists);

        return JsonResult.createJsonResponse(pageInfo);
    }
	
    /**
     * 新增货运-运输单
     * 
     * @param pTransport 货运-运输单信息
     * @return 结果
     */
	@Override
	public JsonResult add(PTransport pTransport)
	{

        int result = pTransportDao.insertPTransport(pTransport);
        if (result == 0) {
            return JsonResult.error(201,"添加失败");
        }
        return JsonResult.success(200,"添加成功");
	}
	
	/**
     * 修改货运-运输单
     * 
     * @param pTransport 货运-运输单信息
     * @return 结果
     */
	@Override
	public JsonResult edit(PTransport pTransport)
	{
        int result = pTransportDao.updatePTransport(pTransport);
        if (result == 0) {
            return JsonResult.error(201,"更新失败");
        }
        return JsonResult.success(200,"更新成功");
	}

    /**
     * 删除货运-运输单对象
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

        int result = pTransportDao.updatePTransportByIds(delete);
        if (result == 0) {
            return JsonResult.error(201,"删除失败");
        }
        return JsonResult.success(200,"删除成功");
    }

}
