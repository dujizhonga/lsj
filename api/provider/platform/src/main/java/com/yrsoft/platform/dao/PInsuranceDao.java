package com.yrsoft.platform.dao;

import com.yrsoft.platform.entity.PInsurance;
import java.util.List;
import java.util.Map;
/**
 * 货运-保险费支付记录 数据层
 * 
 * @author mz
 * @date 2019-02-23
 */
public interface PInsuranceDao
{
	/**
     * 查询货运-保险费支付记录信息
     * 
     * @param id 货运-保险费支付记录ID
     * @return 货运-保险费支付记录信息
     */
	public PInsurance selectPInsuranceById(String id);
	
	/**
     * 查询货运-保险费支付记录列表
     * 
     * @param pInsurance 货运-保险费支付记录信息
     * @return 货运-保险费支付记录集合
     */
	public List<PInsurance> selectPInsuranceList(PInsurance pInsurance);
	
	/**
     * 新增货运-保险费支付记录
     * 
     * @param pInsurance 货运-保险费支付记录信息
     * @return 结果
     */
	public int insertPInsurance(PInsurance pInsurance);
	
	/**
     * 修改货运-保险费支付记录
     * 
     * @param pInsurance 货运-保险费支付记录信息
     * @return 结果
     */
	public int updatePInsurance(PInsurance pInsurance);
	
	/**
     * 删除货运-保险费支付记录
     * 
     * @param id 货运-保险费支付记录ID
     * @return 结果
     */
	public int updatePInsuranceByIds(Map<String, Object> param);

    /**
     * 删除货运-保险费支付记录
     *
     * @param id 货运-保险费支付记录ID
     * @return 结果
     */
    public int deletePInsuranceById(Map<String, Object> param);
	
}