package com.yrsoft.auth.service.impl;

import java.util.List;
import java.util.HashMap;
import java.util.Map;
import com.yrsoft.auth.dao.CompanyDao;
import com.yrsoft.auth.entity.Company;
import com.yrsoft.auth.service.CompanyService;
import com.yrsoft.common.support.Convert;
import com.yrsoft.common.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 认证管理-企业认证 服务层实现
 * 
 * @author mz
 * @date 2019-03-05
 */
@Service
public class CompanyServiceImpl implements CompanyService
{
    @Autowired
    private CompanyDao companyDao;

	/**
     * 查询认证管理-企业认证信息
     * 
     * @param id 认证管理-企业认证ID
     * @return 认证管理-企业认证信息
     */
    @Override
	public JsonResult getCompanyById(String id)
	{
		Company company = companyDao.selectCompanyById(id);
        if ( null == company ) {
			return JsonResult.error(201,"暂无数据");
        }
	    return JsonResult.success(company);
	}

    /**
     * 查询认证管理-企业认证列表
     * @param  page
     * @param  limit
     * @param company 认证管理-企业认证信息
     * @return 认证管理-企业认证集合
     */
    @Override
    public JsonResult list(Integer page,Integer limit,Company company)
    {
        //开启分页
        PageHelper.startPage(page,limit);

        //获取数据
        List<Company> lists =  companyDao.selectCompanyList(company);
        if (null == lists || lists.isEmpty()){
            return JsonResult.error(201,"暂无数据");
        }

        PageInfo<Company> pageInfo = new PageInfo<>(lists);

        return JsonResult.createJsonResponse(pageInfo);
    }
	
    /**
     * 新增认证管理-企业认证
     * 
     * @param company 认证管理-企业认证信息
     * @return 结果
     */
	@Override
	public JsonResult add(Company company)
	{

        int result = companyDao.insertCompany(company);
        if (result == 0) {
            return JsonResult.error(201,"添加失败");
        }
        return JsonResult.success(200,"添加成功");
	}
	
	/**
     * 修改认证管理-企业认证
     * 
     * @param company 认证管理-企业认证信息
     * @return 结果
     */
	@Override
	public JsonResult edit(Company company)
	{
        int result = companyDao.updateCompany(company);
        if (result == 0) {
            return JsonResult.error(201,"更新失败");
        }
        return JsonResult.success(200,"更新成功");
	}

    /**
     * 删除认证管理-企业认证对象
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

        int result = companyDao.updateCompanyByIds(delete);
        if (result == 0) {
            return JsonResult.error(201,"删除失败");
        }
        return JsonResult.success(200,"删除成功");
    }

}
