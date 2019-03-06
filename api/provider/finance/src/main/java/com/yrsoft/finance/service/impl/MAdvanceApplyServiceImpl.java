package com.yrsoft.finance.service.impl;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

import com.yrsoft.common.support.Convert;
import com.yrsoft.common.utils.JsonResult;
import com.yrsoft.finance.dao.MAdvanceApplyDao;
import com.yrsoft.finance.entity.MAdvanceApply;
import com.yrsoft.finance.service.MAdvanceApplyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;



/**
 * 会员管理-垫资申请 服务层实现
 * 
 * @author mz
 * @date 2019-02-23
 */
@Service
public class MAdvanceApplyServiceImpl implements MAdvanceApplyService
{
    @Autowired
    private MAdvanceApplyDao mAdvanceApplyDao;

	/**
     * 查询会员管理-垫资申请信息
     * 
     * @param id 会员管理-垫资申请ID
     * @return 会员管理-垫资申请信息
     */
    @Override
	public JsonResult getMAdvanceApplyById(String id)
	{
		MAdvanceApply mAdvanceApply = mAdvanceApplyDao.selectMAdvanceApplyById(id);
        if ( null == mAdvanceApply ) {
			return JsonResult.error(201,"暂无数据");
        }
	    return JsonResult.success(mAdvanceApply);
	}

    /**
     * 查询会员管理-垫资申请列表
     * @param  page
     * @param  limit
     * @param mAdvanceApply 会员管理-垫资申请信息
     * @return 会员管理-垫资申请集合
     */
    @Override
    public JsonResult list(Integer page,Integer limit,MAdvanceApply mAdvanceApply)
    {
        //开启分页
        PageHelper.startPage(page,limit);

        //获取数据
        List<MAdvanceApply> lists =  mAdvanceApplyDao.selectMAdvanceApplyList(mAdvanceApply);
        if (null == lists || lists.isEmpty()){
            return JsonResult.error(201,"暂无数据");
        }

        PageInfo<MAdvanceApply> pageInfo = new PageInfo<>(lists);

        return JsonResult.createJsonResponse(pageInfo);
    }
	
    /**
     * 新增会员管理-垫资申请
     * 
     * @param mAdvanceApply 会员管理-垫资申请信息
     * @return 结果
     */
	@Override
	public JsonResult add(MAdvanceApply mAdvanceApply)
	{

        int result = mAdvanceApplyDao.insertMAdvanceApply(mAdvanceApply);
        if (result == 0) {
            return JsonResult.error(201,"添加失败");
        }
        return JsonResult.success(200,"添加成功");
	}
	
	/**
     * 修改会员管理-垫资申请
     * 
     * @param mAdvanceApply 会员管理-垫资申请信息
     * @return 结果
     */
	@Override
	public JsonResult edit(MAdvanceApply mAdvanceApply)
	{
        int result = mAdvanceApplyDao.updateMAdvanceApply(mAdvanceApply);
        if (result == 0) {
            return JsonResult.error(201,"更新失败");
        }
        return JsonResult.success(200,"更新成功");
	}

    /**
     * 删除会员管理-垫资申请对象
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

        int result = mAdvanceApplyDao.updateMAdvanceApplyByIds(delete);
        if (result == 0) {
            return JsonResult.error(201,"删除失败");
        }
        return JsonResult.success(200,"删除成功");
    }

}
