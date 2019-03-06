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
import com.yrsoft.platform.entity.PInvoice;
import com.yrsoft.platform.entity.PInvoiceVo;
import com.yrsoft.platform.dao.PInvoiceDao;
import com.yrsoft.platform.service.PInvoiceService;



/**
 * 货运-货运单 服务层实现
 * 
 * @author mz
 * @date 2019-02-23
 */
@Service
public class PInvoiceServiceImpl implements PInvoiceService
{
    @Autowired
    private PInvoiceDao pInvoiceDao;

	/**
     * 查询货运-货运单信息
     * 
     * @param id 货运-货运单ID
     * @return 货运-货运单信息
     */
    @Override
	public JsonResult getPInvoiceById(String id)
	{
		PInvoice pInvoice = pInvoiceDao.selectPInvoiceById(id);
        if ( null == pInvoice ) {
			return JsonResult.error(201,"暂无数据");
        }
	    return JsonResult.success(pInvoice);
	}

    /**
     * 查询货运-货运单列表
     * @param  page
     * @param  limit
     * @param pInvoice 货运-货运单信息
     * @return 货运-货运单集合
     */
    @Override
    public JsonResult list(Integer page,Integer limit,PInvoice pInvoice)
    {
        //开启分页
        PageHelper.startPage(page,limit);

        //获取数据
        List<PInvoice> lists =  pInvoiceDao.selectPInvoiceList(pInvoice);
        if (null == lists || lists.isEmpty()){
            return JsonResult.error(201,"暂无数据");
        }

        PageInfo<PInvoice> pageInfo = new PageInfo<>(lists);

        return JsonResult.createJsonResponse(pageInfo);
    }
    
    @Override
    public JsonResult list(PInvoice pInvoice)
    {

        //获取数据
        List<PInvoice> lists =  pInvoiceDao.selectPInvoiceList(pInvoice);
        if (null == lists || lists.isEmpty()){
            return JsonResult.error(201,"暂无数据");
        }
        return JsonResult.createJsonResponse(lists);
    }
	
    /**
     * 新增货运-货运单
     * 
     * @param pInvoice 货运-货运单信息
     * @return 结果
     */
	@Override
	public JsonResult add(PInvoice pInvoice)
	{

        int result = pInvoiceDao.insertPInvoice(pInvoice);
        if (result == 0) {
            return JsonResult.error(201,"添加失败");
        }
        return JsonResult.success(200,"添加成功");
	}
	
	/**
     * 修改货运-货运单
     * 
     * @param pInvoice 货运-货运单信息
     * @return 结果
     */
	@Override
	public JsonResult edit(PInvoice pInvoice)
	{
        int result = pInvoiceDao.updatePInvoice(pInvoice);
        if (result == 0) {
            return JsonResult.error(201,"更新失败");
        }
        return JsonResult.success(200,"更新成功");
	}

    /**
     * 删除货运-货运单对象
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

        int result = pInvoiceDao.updatePInvoiceByIds(delete);
        if (result == 0) {
            return JsonResult.error(201,"删除失败");
        }
        return JsonResult.success(200,"删除成功");
    }
    
    /**
     * 我的货运单--货运单列表信息查询
     * @param page
     * @param limit
     * @param pInvoice
     * @return
     * @author:DU'JZ
     * @data:2019年2月27日 下午4:36:59 
     * @throws
     */
	@Override
	public JsonResult selectInvoice(Integer page,Integer limit,PInvoiceVo pInvoiceVo) {
		 //开启分页
        PageHelper.startPage(page,limit);

        //获取数据
        List<PInvoice> lists =  pInvoiceDao.selectInvoice(pInvoiceVo);
        if (null == lists || lists.isEmpty()){
            return JsonResult.error(201,"暂无数据");
        }

        PageInfo<PInvoice> pageInfo = new PageInfo<>(lists);

        return JsonResult.createJsonResponse(pageInfo);
	}
	
	/**
	 * 货运管理--我的货运单
	 * @param page
	 * @param limit
	 * @param pInvoice
	 * @return
	 * @author:DU'JZ
	 * @data:2019年2月27日 下午6:23:20 
	 * @throws
	 */
	@Override
	public JsonResult myPInvoiceInfo(Integer page, Integer limit, PInvoiceVo pInvoiceVo) {
		 //开启分页
        PageHelper.startPage(page,limit);

        //获取数据
        List<PInvoice> lists =  pInvoiceDao.myPInvoiceInfo(pInvoiceVo);
        if (null == lists || lists.isEmpty()){
            return JsonResult.error(201,"暂无数据");
        }

        PageInfo<PInvoice> pageInfo = new PageInfo<>(lists);

        return JsonResult.createJsonResponse(pageInfo);
	}

    /**
     * 查询运货中和已送达货运单数
     * @param id
     * @return
     */
    public JsonResult selectPInvoiceNumByState(String id){
        Map<String, Object> map = pInvoiceDao.selectPInvoiceNumByState(id);
        if(map.isEmpty()){
            return JsonResult.error(201,"查询失败");
        }
        return JsonResult.success(map);
    }
    /**
     * 查询货主名下车主运单数-货运单
     * 
     * @param pInvoice 货运-货运单信息
     * @return 结果
     */
	@Override
	public JsonResult selectWaybillCount(String shipperId,String ownerId) {
		PInvoice invoice = pInvoiceDao.selectWaybillCount(shipperId,ownerId);
        if ( null == invoice ) {
			return JsonResult.success();
        }
	    return JsonResult.success(invoice);
	}
    /**
     * 查询货运单地址
     * 
     * @param 货主id 
     * @return 货运-货运单地址
     */
	@Override
	public JsonResult selectInvoiceAddress(String shipperId) {
		PInvoice pInvoice = pInvoiceDao.selectInvoiceAddress(shipperId);
        if ( null == pInvoice ) {
			return JsonResult.success();
        }
	    return JsonResult.success(pInvoice);
	}

   

}
