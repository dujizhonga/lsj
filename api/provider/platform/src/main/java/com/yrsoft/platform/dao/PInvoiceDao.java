package com.yrsoft.platform.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.yrsoft.platform.entity.PInvoice;
import com.yrsoft.platform.entity.PInvoiceVo;
/**
 * 货运-货运单 数据层
 * 
 * @author mz
 * @date 2019-02-23
 */
public interface PInvoiceDao
{
	/**
     * 查询货运-货运单信息
     * 
     * @param id 货运-货运单ID
     * @return 货运-货运单信息
     */
	public PInvoice selectPInvoiceById(String id);
	
	/**
     * 查询货运-货运单列表
     * 
     * @param pInvoice 货运-货运单信息
     * @return 货运-货运单集合
     */
	public List<PInvoice> selectPInvoiceList(PInvoice pInvoice);
	
	/**
     * 新增货运-货运单
     * 
     * @param pInvoice 货运-货运单信息
     * @return 结果
     */
	public int insertPInvoice(PInvoice pInvoice);
	
	/**
     * 修改货运-货运单
     * 
     * @param pInvoice 货运-货运单信息
     * @return 结果
     */
	public int updatePInvoice(PInvoice pInvoice);
	
	/**
     * 删除货运-货运单
     * 
     * @param id 货运-货运单ID
     * @return 结果
     */
	public int updatePInvoiceByIds(Map<String, Object> param);

    /**
     * 删除货运-货运单
     *
     * @param id 货运-货运单ID
     * @return 结果
     */
    public int deletePInvoiceById(Map<String, Object> param);
    
    /**
     * 我的货运单--货运单列表信息
     * @param pInvoice
     * @return:List<PInvoice>
     * @author:DU'JZ
     * @data:2019年2月27日 下午3:29:15 
     * @throws
     */
    public List<PInvoice> selectInvoice(PInvoiceVo pInvoiceVo);
    
    /**
     * 我的货运单--货运单列表信息
     * @param pInvoice
     * @return:List<PInvoice>
     * @author:DU'JZ
     * @data:2019年2月27日 下午3:29:15 
     * @throws
     */
    public List<PInvoice> myPInvoiceInfo(PInvoiceVo pInvoiceVo);


	/**
	 * 查询运货中和已送达货运单数
	 * @param id
	 * @return
	 */
    public Map<String,Object> selectPInvoiceNumByState(String id);
    /**
     * 查询货主名下车主运单数-货运单
     * 
     * @param pInvoice 货运-货运单信息
     * @return 结果
     */
	public PInvoice selectWaybillCount(@Param("shipperId")String shipperId,@Param("ownerId")String ownerId);
    /**
     * 查询货运单地址
     * 
     * @param id 货运-货运单ID
     * @return 货运-货运单信息
     */
	public PInvoice selectInvoiceAddress(String shipperId);

	
	
}