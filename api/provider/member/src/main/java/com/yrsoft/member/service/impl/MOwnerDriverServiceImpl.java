package com.yrsoft.member.service.impl;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

import com.yrsoft.common.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yrsoft.common.support.Convert;
import com.yrsoft.member.entity.MOwnerDriver;
import com.yrsoft.member.dao.MOwnerDriverDao;
import com.yrsoft.member.service.MOwnerDriverService;



/**
 * 会员管理-车主司机关系 服务层实现
 * 
 * @author mz
 * @date 2019-02-23
 */
@Service
public class MOwnerDriverServiceImpl implements MOwnerDriverService
{
    @Autowired
    private MOwnerDriverDao mOwnerDriverDao;

	/**
     * 查询会员管理-车主司机关系信息
     * 
     * @param id 会员管理-车主司机关系ID
     * @return 会员管理-车主司机关系信息
     */
    @Override
	public JsonResult getMOwnerDriverById(String id)
	{
		MOwnerDriver mOwnerDriver = mOwnerDriverDao.selectMOwnerDriverById(id);
        if ( null == mOwnerDriver ) {
			return JsonResult.error(201,"暂无数据");
        }
	    return JsonResult.success(mOwnerDriver);
	}

    /**
     * 查询会员管理-车主司机关系列表
     * @param  page
     * @param  limit
     * @param mOwnerDriver 会员管理-车主司机关系信息
     * @return 会员管理-车主司机关系集合
     */
    @Override
    public JsonResult list(Integer page,Integer limit,MOwnerDriver mOwnerDriver)
    {
        //开启分页
        PageHelper.startPage(page,limit);

        //获取数据
        List<MOwnerDriver> lists =  mOwnerDriverDao.selectMOwnerDriverList(mOwnerDriver);
        if (null == lists || lists.isEmpty()){
            return JsonResult.error(201,"暂无数据");
        }

        PageInfo<MOwnerDriver> pageInfo = new PageInfo<>(lists);

        return JsonResult.createJsonResponse(pageInfo);
    }
	
    /**
     * 新增会员管理-车主司机关系
     * 
     * @param mOwnerDriver 会员管理-车主司机关系信息
     * @return 结果
     */
	@Override
	public JsonResult add(MOwnerDriver mOwnerDriver)
	{

        int result = mOwnerDriverDao.insertMOwnerDriver(mOwnerDriver);
        if (result == 0) {
            return JsonResult.error(201,"添加失败");
        }
        return JsonResult.success(200,"添加成功");
	}
	
	/**
     * 修改会员管理-车主司机关系
     * 
     * @param mOwnerDriver 会员管理-车主司机关系信息
     * @return 结果
     */
	@Override
	public JsonResult edit(MOwnerDriver mOwnerDriver)
	{
        int result = mOwnerDriverDao.updateMOwnerDriver(mOwnerDriver);
        if (result == 0) {
            return JsonResult.error(201,"更新失败");
        }
        return JsonResult.success(200,"更新成功");
	}

    /**
     * 删除会员管理-车主司机关系对象
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

        int result = mOwnerDriverDao.updateMOwnerDriverByIds(delete);
        if (result == 0) {
            return JsonResult.error(201,"删除失败");
        }
        return JsonResult.success(200,"删除成功");
    }

}
