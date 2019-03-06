package com.yrsoft.platform.service.impl;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

import com.yrsoft.common.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yrsoft.common.support.Convert;
import com.yrsoft.platform.entity.PShippingAddress;
import com.yrsoft.platform.dao.PShippingAddressDao;
import com.yrsoft.platform.service.PShippingAddressService;



/**
 * 货运-收发货地址 服务层实现
 * 
 * @author mz
 * @date 2019-02-23
 */
@Service
public class PShippingAddressServiceImpl implements PShippingAddressService
{
    @Autowired
    private PShippingAddressDao pShippingAddressDao;

	/**
     * 查询货运-收发货地址信息
     * 
     * @param id 货运-收发货地址ID
     * @return 货运-收发货地址信息
     */
    @Override
	public JsonResult getPShippingAddressById(String id)
	{
		PShippingAddress pShippingAddress = pShippingAddressDao.selectPShippingAddressById(id);
        if ( null == pShippingAddress ) {
			return JsonResult.error(201,"暂无数据");
        }
	    return JsonResult.success(pShippingAddress);
	}

    /**
     * 查询货运-收发货地址列表
     * @param  page
     * @param  limit
     * @param pShippingAddress 货运-收发货地址信息
     * @return 货运-收发货地址集合
     */
    @Override
    public JsonResult list(Integer page,Integer limit,PShippingAddress pShippingAddress)
    {
        //开启分页
        PageHelper.startPage(page,limit);

        //获取数据
        List<PShippingAddress> lists =  pShippingAddressDao.selectPShippingAddressList(pShippingAddress);
        if (null == lists || lists.isEmpty()){
            return JsonResult.error(201,"暂无数据");
        }

        PageInfo<PShippingAddress> pageInfo = new PageInfo<>(lists);

        return JsonResult.createJsonResponse(pageInfo);
    }
	
    /**
     * 新增货运-收发货地址
     * 
     * @param pShippingAddress 货运-收发货地址信息
     * @return 结果
     */
	@Override
	public JsonResult add(PShippingAddress pShippingAddress)
	{

        int result = pShippingAddressDao.insertPShippingAddress(pShippingAddress);
        if (result == 0) {
            return JsonResult.error(201,"添加失败");
        }
        return JsonResult.success(200,"添加成功");
	}
	
	/**
     * 修改货运-收发货地址
     * 
     * @param pShippingAddress 货运-收发货地址信息
     * @return 结果
     */
	@Override
	public JsonResult edit(PShippingAddress pShippingAddress)
	{
        int result = pShippingAddressDao.updatePShippingAddress(pShippingAddress);
        if (result == 0) {
            return JsonResult.error(201,"更新失败");
        }
        return JsonResult.success(200,"更新成功");
	}

    /**
     * 删除货运-收发货地址对象
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

        int result = pShippingAddressDao.updatePShippingAddressByIds(delete);
        if (result == 0) {
            return JsonResult.error(201,"删除失败");
        }
        return JsonResult.success(200,"删除成功");
    }
    /**
     * 查询货运-查询最新收发货地址
     * 
     * @param shippingId 货主ID
     * @return 货运-收发货地址集合
     */
	@Override
	public JsonResult selectAddressNew(String shipper) {
		//获取数据
        List<PShippingAddress> lists =  pShippingAddressDao.selectAddressNew(shipper);
        if (null == lists || lists.isEmpty()){
            return JsonResult.success();
        }
        return JsonResult.success(lists);
	}

}
