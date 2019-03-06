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
import com.yrsoft.platform.entity.PAssignApply;
import com.yrsoft.platform.dao.PAssignApplyDao;
import com.yrsoft.platform.service.PAssignApplyService;



/**
 * 货运-系统车辆分派申请 服务层实现
 * 
 * @author mz
 * @date 2019-02-23
 */
@Service
public class PAssignApplyServiceImpl implements PAssignApplyService
{
    @Autowired
    private PAssignApplyDao pAssignApplyDao;

	/**
     * 查询货运-系统车辆分派申请信息
     * 
     * @param id 货运-系统车辆分派申请ID
     * @return 货运-系统车辆分派申请信息
     */
    @Override
	public JsonResult getPAssignApplyById(String id)
	{
		PAssignApply pAssignApply = pAssignApplyDao.selectPAssignApplyById(id);
        if ( null == pAssignApply ) {
			return JsonResult.error(201,"暂无数据");
        }
	    return JsonResult.success(pAssignApply);
	}

    /**
     * 查询货运-系统车辆分派申请列表
     * @param  page
     * @param  limit
     * @param pAssignApply 货运-系统车辆分派申请信息
     * @return 货运-系统车辆分派申请集合
     */
    @Override
    public JsonResult list(Integer page,Integer limit,PAssignApply pAssignApply)
    {
        //开启分页
        PageHelper.startPage(page,limit);

        //获取数据
        List<PAssignApply> lists =  pAssignApplyDao.selectPAssignApplyList(pAssignApply);
        if (null == lists || lists.isEmpty()){
            return JsonResult.error(201,"暂无数据");
        }

        PageInfo<PAssignApply> pageInfo = new PageInfo<>(lists);

        return JsonResult.createJsonResponse(pageInfo);
    }
	
    /**
     * 新增货运-系统车辆分派申请
     * 
     * @param pAssignApply 货运-系统车辆分派申请信息
     * @return 结果
     */
	@Override
	public JsonResult add(PAssignApply pAssignApply)
	{

        int result = pAssignApplyDao.insertPAssignApply(pAssignApply);
        if (result == 0) {
            return JsonResult.error(201,"添加失败");
        }
        return JsonResult.success(200,"添加成功");
	}
	
	/**
     * 修改货运-系统车辆分派申请
     * 
     * @param pAssignApply 货运-系统车辆分派申请信息
     * @return 结果
     */
	@Override
	public JsonResult edit(PAssignApply pAssignApply)
	{
        int result = pAssignApplyDao.updatePAssignApply(pAssignApply);
        if (result == 0) {
            return JsonResult.error(201,"更新失败");
        }
        return JsonResult.success(200,"更新成功");
	}

    /**
     * 删除货运-系统车辆分派申请对象
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

        int result = pAssignApplyDao.updatePAssignApplyByIds(delete);
        if (result == 0) {
            return JsonResult.error(201,"删除失败");
        }
        return JsonResult.success(200,"删除成功");
    }

}
