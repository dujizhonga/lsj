package com.yrsoft.auth.controller;


import com.yrsoft.auth.entity.Company;
import com.yrsoft.auth.service.CompanyService;
import com.yrsoft.common.utils.JsonResult;
import com.yrsoft.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.apache.servicecomb.provider.rest.common.RestSchema;
import javax.ws.rs.core.MediaType;



/**
 * 认证管理-企业认证 信息操作处理
 * 
 * @author mz
 * @date 2019-03-05
 */
@RestSchema(schemaId = "company")
@RequestMapping(path = "/provider/company",produces = MediaType.APPLICATION_JSON)
public class CompanyController
{

	@Autowired
	private CompanyService companyService;

    /**
     * 查询认证管理-企业认证一个
     */
	@RequestMapping(value = "/getCompanyById",method = RequestMethod.POST)
	public JsonResult getCompanyById(String id){
	    if (StringUtils.isBlank(id)){
	        return JsonResult.error(201,"请传入主键编号");
		}


		return companyService.getCompanyById(id);
	}


    /**
     * 查询认证管理-企业认证列表
     */
	@RequestMapping(value = "/list",method = RequestMethod.POST)
	public JsonResult list(Integer page, Integer limit, Company company){
        page =  page != null ? page:0;
        limit =  limit != null ?limit:10;
	    try {
            return companyService.list(page,limit,company);
        } catch (Exception e) {
            return JsonResult.error(207,"服务器错误");
        }
    }

    /**
     * 新增保存认证管理-企业认证
     */

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public JsonResult add(Company company)
    {
        try {
            return companyService.add(company);
        } catch (Exception e) {
            return JsonResult.error(207,"服务器错误");
        }
    }

    /**
     * 修改保存认证管理-企业认证
     */

    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    public JsonResult edit(Company company)
    {
        try {
            return companyService.edit(company);
        } catch (Exception e) {
            return JsonResult.error(207,"服务器错误");
        }

    }

    /**
     * 删除认证管理-企业认证
     */
    @RequestMapping(value = "/remove",method = RequestMethod.POST)
    public JsonResult remove(String ids)
    {
        if (StringUtils.isBlank(ids)) {
            return JsonResult.error(201,"请传入要删除的编号");
        }
        try {
            return companyService.remove(ids);
        } catch (Exception e) {
            return JsonResult.error(207,"服务器错误");
        }
    }
}
