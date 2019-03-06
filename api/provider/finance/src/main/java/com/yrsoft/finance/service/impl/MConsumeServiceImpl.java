package com.yrsoft.finance.service.impl;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

import com.yrsoft.common.utils.JsonResult;
import com.yrsoft.finance.dao.MConsumeDao;
import com.yrsoft.finance.entity.MConsume;
import com.yrsoft.finance.service.MConsumeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yrsoft.common.support.Convert;
/**
 * 会员管理-消费记录（非三方） 服务层实现
 * 
 * @author mz
 * @date 2019-02-23
 */
@Service
public class MConsumeServiceImpl implements MConsumeService
{
    @Autowired
    private MConsumeDao mConsumeDao;

	/**
     * 查询会员管理-消费记录（非三方）信息
     * 
     * @param id 会员管理-消费记录（非三方）ID
     * @return 会员管理-消费记录（非三方）信息
     */
    @Override
	public JsonResult getMConsumeById(String id)
	{
		MConsume mConsume = mConsumeDao.selectMConsumeById(id);
        if ( null == mConsume ) {
			return JsonResult.error(201,"暂无数据");
        }
	    return JsonResult.success(mConsume);
	}

    /**
     * 查询会员管理-消费记录（非三方）列表
     * @param  page
     * @param  limit
     * @param mConsume 会员管理-消费记录（非三方）信息
     * @return 会员管理-消费记录（非三方）集合
     */
    @Override
    public JsonResult list(Integer page,Integer limit,MConsume mConsume)
    {
        //开启分页
        PageHelper.startPage(page,limit);

        //获取数据
        List<MConsume> lists =  mConsumeDao.selectMConsumeList(mConsume);
        if (null == lists || lists.isEmpty()){
            return JsonResult.error(201,"暂无数据");
        }

        PageInfo<MConsume> pageInfo = new PageInfo<>(lists);

        return JsonResult.createJsonResponse(pageInfo);
    }
	
    /**
     * 新增会员管理-消费记录（非三方）
     * 
     * @param mConsume 会员管理-消费记录（非三方）信息
     * @return 结果
     */
	@Override
	public JsonResult add(MConsume mConsume)
	{

        int result = mConsumeDao.insertMConsume(mConsume);
        if (result == 0) {
            return JsonResult.error(201,"添加失败");
        }
        return JsonResult.success(200,"添加成功");
	}
	
	/**
     * 修改会员管理-消费记录（非三方）
     * 
     * @param mConsume 会员管理-消费记录（非三方）信息
     * @return 结果
     */
	@Override
	public JsonResult edit(MConsume mConsume)
	{
        int result = mConsumeDao.updateMConsume(mConsume);
        if (result == 0) {
            return JsonResult.error(201,"更新失败");
        }
        return JsonResult.success(200,"更新成功");
	}

    /**
     * 删除会员管理-消费记录（非三方）对象
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

        int result = mConsumeDao.updateMConsumeByIds(delete);
        if (result == 0) {
            return JsonResult.error(201,"删除失败");
        }
        return JsonResult.success(200,"删除成功");
    }

}
