package com.yrsoft.auth.controller;

import com.yrsoft.common.utils.JsonResult;
import com.yrsoft.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.apache.servicecomb.provider.rest.common.RestSchema;
import javax.ws.rs.core.MediaType;
import com.yrsoft.auth.entity.Person;
import com.yrsoft.auth.service.PersonService;


/**
 * 认证管理-个人认证 信息操作处理
 * 
 * @author mz
 * @date 2019-03-04
 */
@RestSchema(schemaId = "person")
@RequestMapping(path = "/provider/auth/person",produces = MediaType.APPLICATION_JSON)
public class PersonController
{

	@Autowired
	private PersonService personService;

    /**
     * 查询认证管理-个人认证一个
     */
	@RequestMapping(value = "/getPersonById",method = RequestMethod.POST)
	public JsonResult getPersonById(String id){
	    if (StringUtils.isBlank(id)){
	        return JsonResult.error(201,"请传入主键编号");
		}


		return personService.getPersonById(id);
	}


    /**
     * 查询认证管理-个人认证列表
     */
	@RequestMapping(value = "/list",method = RequestMethod.POST)
	public JsonResult list(Integer page,Integer limit,Person person){
        page =  page != null ? page:0;
        limit =  limit != null ?limit:10;
	    try {
            return personService.list(page,limit,person);
        } catch (Exception e) {
            return JsonResult.error(207,"服务器错误");
        }
    }

    /**
     * 新增保存认证管理-个人认证
     */

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public JsonResult add(Person person)
    {
        try {
            return personService.add(person);
        } catch (Exception e) {
            return JsonResult.error(207,"服务器错误");
        }
    }

    /**
     * 修改保存认证管理-个人认证
     */

    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    public JsonResult edit(Person person)
    {
        try {
            return personService.edit(person);
        } catch (Exception e) {
            return JsonResult.error(207,"服务器错误");
        }

    }

    /**
     * 删除认证管理-个人认证
     */
    @RequestMapping(value = "/remove",method = RequestMethod.POST)
    public JsonResult remove(String ids)
    {
        if (StringUtils.isBlank(ids)) {
            return JsonResult.error(201,"请传入要删除的编号");
        }
        try {
            return personService.remove(ids);
        } catch (Exception e) {
            return JsonResult.error(207,"服务器错误");
        }
    }
    
    /**
     * 根据用户ID查询用户的个人认证信息<p>
     * @param memberId
     * @return JsonResult
     * @author WANGQI
     * @date 2019年3月4日 下午7:12:18
     */
    @RequestMapping(value = "/selectPersonByMemberId",method = RequestMethod.POST)
    public JsonResult selectPersonByMemberId(String memberId) {
    	return personService.selectPersonByMemberId(memberId);
    }
}
