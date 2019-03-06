package com.yrsoft.platform.service;

import com.yrsoft.platform.entity.PInvoice;
import com.yrsoft.platform.entity.PInvoiceVo;
import com.yrsoft.common.utils.JsonResult;
import java.util.List;
import java.util.Map;

/**
 * 货运-货运单 服务层
 * 
 * @author mz
 * @date 2019-02-23
 */
public interface PInvoiceService
{
	/**
     * 查询货运-货运单信息
     * 
     * @param id 货运-货运单ID
     * @return 货运-货运单信息
     */
	public JsonResult getPInvoiceById(String id);
	
	/**
     * 查询货运-货运单列表
     * 
     * @param pInvoice 货运-货运单信息
     * @return 货运-货运单集合
     */
	public JsonResult list(Integer page, Integer limit, PInvoice pInvoice);
	
	public JsonResult list(PInvoice pInvoice);
	
	/**
     * 新增货运-货运单
     * 
     * @param pInvoice 货运-货运单信息
     * @return 结果
     */
	public JsonResult add(PInvoice pInvoice);
	
	/**
     * 修改货运-货运单
     * 
     * @param pInvoice 货运-货运单信息
     * @return 结果
     */
	public JsonResult edit(PInvoice pInvoice);

    /**
     * 删除货运-货运单信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public JsonResult remove(String ids);
    
    /**
     * 货运管理--货运单列表信息
     * @param pInvoice
     * @return:List<PInvoice>
     * @author:DU'JZ
     * @data:2019年2月27日 下午3:29:15 
     * @throws
     */
    public JsonResult selectInvoice(Integer page,Integer limit,PInvoiceVo pInvoiceVo);
    
    /**
     *货运管理-我的货运单
     * @param page
     * @param limit
     * @param pInvoice
     * @return:JsonResult
     * @author:DU'JZ
     * @data:2019年2月27日 下午5:48:18 
     * @throws
     */
    public JsonResult myPInvoiceInfo(Integer page,Integer limit,PInvoiceVo pInvoiceVo);
	
	/**
	 * 查询运货中和已送达货运单数
	 * @param id
	 * @return
	 */
	public JsonResult selectPInvoiceNumByState(String id);
	/**
     * 查询货主名下车主运单数-货运单
     * 
     * @param pInvoice 货运-货运单信息
     * @return 结果
     */
	public JsonResult selectWaybillCount(String shipperId,String ownerId);
	/**
     * 查询货运单地址
     * 
     * @param id 货运-货运单ID
     * @return 货运-货运单地址
     */
	public JsonResult selectInvoiceAddress(String shipperId);

	
	
}
