package com.yrsoft.auth.service.impl;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

import com.yrsoft.common.support.Convert;
import com.yrsoft.common.utils.JsonResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yrsoft.auth.entity.Person;
import com.yrsoft.auth.dao.PersonDao;
import com.yrsoft.auth.service.PersonService;



/**
 * 认证管理-个人认证 服务层实现
 * 
 * @author mz
 * @date 2019-03-04
 */
@Service
public class PersonServiceImpl implements PersonService
{
    @Autowired
    private PersonDao personDao;

	/**
     * 查询认证管理-个人认证信息
     * 
     * @param id 认证管理-个人认证ID
     * @return 认证管理-个人认证信息
     */
    @Override
	public JsonResult getPersonById(String id)
	{
		Person person = personDao.selectPersonById(id);
        if ( null == person ) {
			return JsonResult.error(201,"暂无数据");
        }
	    return JsonResult.success(person);
	}

    /**
     * 查询认证管理-个人认证列表
     * @param  page
     * @param  limit
     * @param person 认证管理-个人认证信息
     * @return 认证管理-个人认证集合
     */
    @Override
    public JsonResult list(Integer page,Integer limit,Person person)
    {
        //开启分页
        PageHelper.startPage(page,limit);

        //获取数据
        List<Person> lists =  personDao.selectPersonList(person);
        if (null == lists || lists.isEmpty()){
            return JsonResult.error(201,"暂无数据");
        }

        PageInfo<Person> pageInfo = new PageInfo<>(lists);

        return JsonResult.createJsonResponse(pageInfo);
    }
	
    /**
     * 新增认证管理-个人认证
     * 
     * @param person 认证管理-个人认证信息
     * @return 结果
     */
	@Override
	public JsonResult add(Person person)
	{

        int result = personDao.insertPerson(person);
        if (result == 0) {
            return JsonResult.error(201,"添加失败");
        }
        return JsonResult.success(200,"添加成功");
	}
	
	/**
     * 修改认证管理-个人认证
     * 
     * @param person 认证管理-个人认证信息
     * @return 结果
     */
	@Override
	public JsonResult edit(Person person)
	{
        int result = personDao.updatePerson(person);
        if (result == 0) {
            return JsonResult.error(201,"更新失败");
        }
        return JsonResult.success(200,"更新成功");
	}

    /**
     * 删除认证管理-个人认证对象
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

        int result = personDao.updatePersonByIds(delete);
        if (result == 0) {
            return JsonResult.error(201,"删除失败");
        }
        return JsonResult.success(200,"删除成功");
    }

	@Override
	public JsonResult selectPersonByMemberId(String memberId) {
		Person p = personDao.selectPersonByMemberId(memberId);
		return JsonResult.success(p);
	}

}
