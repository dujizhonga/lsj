package com.yrsoft.platform.controller;


import com.yrsoft.common.utils.JsonResult;
import com.yrsoft.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.apache.servicecomb.provider.rest.common.RestSchema;
import javax.ws.rs.core.MediaType;
import com.yrsoft.platform.entity.PShippingAddress;
import com.yrsoft.platform.service.PShippingAddressService;


/**
 * 货运-收发货地址 信息操作处理
 * 
 * @author mz
 * @date 2019-02-23
 */
@RestSchema(schemaId = "pShippingAddress")
@RequestMapping(path = "/provider/pShippingAddress",produces = MediaType.APPLICATION_JSON)
public class PShippingAddressController
{

	@Autowired
	private PShippingAddressService pShippingAddressService;

    /**
     * 查询货运-收发货地址一个
     */
	@RequestMapping(value = "/getPShippingAddressById",method = RequestMethod.POST)
	public JsonResult getPShippingAddressById(String id){
	    if (StringUtils.isBlank(id)){
	        return JsonResult.error(201,"请传入主键编号");
		}


		return pShippingAddressService.getPShippingAddressById(id);
	}


    /**
     * 查询货运-收发货地址列表
     */
	@RequestMapping(value = "/list",method = RequestMethod.POST)
	public JsonResult list(Integer page,Integer limit,PShippingAddress pShippingAddress){
        page =  page != null ? page:0;
        limit =  limit != null ?limit:10;
	    try {
            return pShippingAddressService.list(page,limit,pShippingAddress);
        } catch (Exception e) {
            return JsonResult.error(207,"服务器错误");
        }
    }

    /**
     * 新增保存货运-收发货地址
     */

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public JsonResult add(PShippingAddress pShippingAddress)
    {
        try {
            System.out.println(pShippingAddress);
            return pShippingAddressService.add(pShippingAddress);
        } catch (Exception e) {
            return JsonResult.error(207,"服务器错误");
        }
    }

    /**
     * 修改保存货运-收发货地址
     */

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public JsonResult edit(PShippingAddress pShippingAddress)
    {
        try {
            return pShippingAddressService.edit(pShippingAddress);
        } catch (Exception e) {
            return JsonResult.error(207,"服务器错误");
        }

    }

    /**
     * 删除货运-收发货地址
     */
    @RequestMapping(value = "/remove",method = RequestMethod.POST)
    public JsonResult remove(String ids)
    {
        if (StringUtils.isBlank(ids)) {
            return JsonResult.error(201,"请传入要删除的编号");
        }
        try {
            return pShippingAddressService.remove(ids);
        } catch (Exception e) {
            return JsonResult.error(207,"服务器错误");
        }
    }
    /**
     * 查询货运-查询最新收发货地址
     * 
     * @param shippingId 货主ID
     * @return 货运-收发货地址集合
     */
    @RequestMapping(value = "/selectAddressNew",method = RequestMethod.POST)
	public JsonResult selectAddressNew(String shipperId){
	    if (StringUtils.isBlank(shipperId)){
	        return JsonResult.error(201,"请传入货主ID");
		}
		return pShippingAddressService.selectAddressNew(shipperId);
	}
}
