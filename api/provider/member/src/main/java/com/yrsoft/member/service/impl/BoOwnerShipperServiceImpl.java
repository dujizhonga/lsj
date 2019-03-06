package com.yrsoft.member.service.impl;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

import com.yrsoft.common.support.Convert;
import com.yrsoft.common.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.yrsoft.member.entity.BoOwnerShipper;
import com.yrsoft.member.dao.BoOwnerShipperDao;
import com.yrsoft.member.service.BoOwnerShipperService;



/**
 * 会员管理-货主车主关系 服务层实现
 * 
 * @author mz
 * @date 2019-02-23
 */
@Service
public class BoOwnerShipperServiceImpl implements BoOwnerShipperService
{
    @Autowired
    private BoOwnerShipperDao boOwnerShipperDao;

	/**
     * 查询会员管理-货主车主关系信息
     * 
     * @param id 会员管理-货主车主关系ID
     * @return 会员管理-货主车主关系信息
     */
    @Override
	public JsonResult getBoOwnerShipperById(String id)
	{
		BoOwnerShipper boOwnerShipper = boOwnerShipperDao.selectBoOwnerShipperById(id);
        if ( null == boOwnerShipper ) {
			return JsonResult.error(201,"暂无数据");
        }
	    return JsonResult.success(boOwnerShipper);
	}

    /**
     * 查询会员管理-货主车主关系列表
     * @param  page
     * @param  limit
     * @param boOwnerShipper 会员管理-货主车主关系信息
     * @return 会员管理-货主车主关系集合
     */
    @Override
    public JsonResult list(Integer page,Integer limit,BoOwnerShipper boOwnerShipper)
    {
        //开启分页
        PageHelper.startPage(page,limit);

        //获取数据
        List<BoOwnerShipper> lists =  boOwnerShipperDao.selectBoOwnerShipperList(boOwnerShipper);
        if (null == lists || lists.isEmpty()){
            return JsonResult.error(201,"暂无数据");
        }

        PageInfo<BoOwnerShipper> pageInfo = new PageInfo<>(lists);

        return JsonResult.createJsonResponse(pageInfo);
    }
	
    /**
     * 新增会员管理-货主车主关系
     * 
     * @param boOwnerShipper 会员管理-货主车主关系信息
     * @return 结果
     */
	@Override
	public JsonResult add(BoOwnerShipper boOwnerShipper)
	{

        int result = boOwnerShipperDao.insertBoOwnerShipper(boOwnerShipper);
        if (result == 0) {
            return JsonResult.error(201,"添加失败");
        }
        return JsonResult.success(200,"添加成功");
	}
	
	/**
     * 修改会员管理-货主车主关系
     * 
     * @param boOwnerShipper 会员管理-货主车主关系信息
     * @return 结果
     */
	@Override
	public JsonResult edit(BoOwnerShipper boOwnerShipper)
	{
        int result = boOwnerShipperDao.updateBoOwnerShipper(boOwnerShipper);
        if (result == 0) {
            return JsonResult.error(201,"更新失败");
        }
        return JsonResult.success(200,"更新成功");
	}

    /**
     * 删除会员管理-货主车主关系对象
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

        int result = boOwnerShipperDao.updateBoOwnerShipperByIds(delete);
        if (result == 0) {
            return JsonResult.error(201,"删除失败");
        }
        return JsonResult.success(200,"删除成功");
    }
    /**
     * 查询车主信息-货主车主关系
     *
     * @param 货主id 
     * @return 
     */
	@Override
	public JsonResult selectOwnerInfo(String shipperId) {
		List<BoOwnerShipper> ownerLists = boOwnerShipperDao.selectOwnerInfo(shipperId);
		if (null == ownerLists || ownerLists.isEmpty()){
            return JsonResult.error(201,"暂无数据");
        }

        PageInfo<BoOwnerShipper> pageInfo = new PageInfo<>(ownerLists);

        return JsonResult.createJsonResponse(pageInfo);
	}

}
