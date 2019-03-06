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
import com.yrsoft.member.entity.MMember;
import com.yrsoft.member.dao.MMemberDao;
import com.yrsoft.member.service.MMemberService;



/**
 * 会员管理-会员 服务层实现
 * 
 * @author mz
 * @date 2019-02-23
 */
@Service
public class MMemberServiceImpl implements MMemberService
{
    @Autowired
    private MMemberDao mMemberDao;

	/**
     * 查询会员管理-会员信息
     * 
     * @param id 会员管理-会员ID
     * @return 会员管理-会员信息
     */
    @Override
	public JsonResult getMMemberById(String id)
	{
		MMember mMember = mMemberDao.selectMMemberById(id);
        if ( null == mMember ) {
			return JsonResult.error(201,"暂无数据");
        }
	    return JsonResult.success(mMember);
	}

    /**
     * 查询会员管理-会员列表
     * @param  page
     * @param  limit
     * @param mMember 会员管理-会员信息
     * @return 会员管理-会员集合
     */
    @Override
    public JsonResult list(Integer page,Integer limit,MMember mMember)
    {
        //开启分页
        PageHelper.startPage(page,limit);

        //获取数据
        List<MMember> lists =  mMemberDao.selectMMemberList(mMember);
        if (null == lists || lists.isEmpty()){
            return JsonResult.error(201,"暂无数据");
        }

        PageInfo<MMember> pageInfo = new PageInfo<>(lists);

        return JsonResult.createJsonResponse(pageInfo);
    }
	
    /**
     * 新增会员管理-会员
     * 
     * @param mMember 会员管理-会员信息
     * @return 结果
     */
	@Override
	public JsonResult add(MMember mMember)
	{

        int result = mMemberDao.insertMMember(mMember);
        if (result == 0) {
            return JsonResult.error(201,"添加失败");
        }
        return JsonResult.success(200,"添加成功");
	}
	
	/**
     * 修改会员管理-会员
     * 
     * @param mMember 会员管理-会员信息
     * @return 结果
     */
	@Override
	public JsonResult edit(MMember mMember)
	{
        int result = mMemberDao.updateMMember(mMember);
        if (result == 0) {
            return JsonResult.error(201,"更新失败");
        }
        return JsonResult.success(200,"更新成功");
	}

    /**
     * 删除会员管理-会员对象
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

        int result = mMemberDao.updateMMemberByIds(delete);
        if (result == 0) {
            return JsonResult.error(201,"删除失败");
        }
        return JsonResult.success(200,"删除成功");
    }

}
