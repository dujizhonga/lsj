package com.yrsoft.operate.service.impl;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

import com.yrsoft.common.support.Convert;
import com.yrsoft.common.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yrsoft.operate.entity.OStaff;
import com.yrsoft.operate.dao.OStaffDao;
import com.yrsoft.operate.service.OStaffService;



/**
 * 运营管理-人员 服务层实现
 * 
 * @author mz
 * @date 2019-02-23
 */
@Service
public class OStaffServiceImpl implements OStaffService
{
    @Autowired
    private OStaffDao oStaffDao;

	/**
     * 查询运营管理-人员信息
     * 
     * @param id 运营管理-人员ID
     * @return 运营管理-人员信息
     */
    @Override
	public JsonResult getOStaffById(String id)
	{
		OStaff oStaff = oStaffDao.selectOStaffById(id);
        if ( null == oStaff ) {
			return JsonResult.error(201,"暂无数据");
        }
	    return JsonResult.success(oStaff);
	}

    /**
     * 查询运营管理-人员列表
     * @param  page
     * @param  limit
     * @param oStaff 运营管理-人员信息
     * @return 运营管理-人员集合
     */
    @Override
    public JsonResult list(Integer page,Integer limit,OStaff oStaff)
    {
        //开启分页
        PageHelper.startPage(page,limit);

        //获取数据
        List<OStaff> lists =  oStaffDao.selectOStaffList(oStaff);
        if (null == lists || lists.isEmpty()){
            return JsonResult.error(201,"暂无数据");
        }

        PageInfo<OStaff> pageInfo = new PageInfo<>(lists);

        return JsonResult.createJsonResponse(pageInfo);
    }
	
    /**
     * 新增运营管理-人员
     * 
     * @param oStaff 运营管理-人员信息
     * @return 结果
     */
	@Override
	public JsonResult add(OStaff oStaff)
	{

        int result = oStaffDao.insertOStaff(oStaff);
        if (result == 0) {
            return JsonResult.error(201,"添加失败");
        }
        return JsonResult.success(200,"添加成功");
	}
	
	/**
     * 修改运营管理-人员
     * 
     * @param oStaff 运营管理-人员信息
     * @return 结果
     */
	@Override
	public JsonResult edit(OStaff oStaff)
	{
        int result = oStaffDao.updateOStaff(oStaff);
        if (result == 0) {
            return JsonResult.error(201,"更新失败");
        }
        return JsonResult.success(200,"更新成功");
	}

    /**
     * 删除运营管理-人员对象
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

        int result = oStaffDao.updateOStaffByIds(delete);
        if (result == 0) {
            return JsonResult.error(201,"删除失败");
        }
        return JsonResult.success(200,"删除成功");
    }

}
