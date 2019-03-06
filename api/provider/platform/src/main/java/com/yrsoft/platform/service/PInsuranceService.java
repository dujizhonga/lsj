package com.yrsoft.platform.service;

import com.yrsoft.platform.entity.PInsurance;
import com.yrsoft.common.utils.JsonResult;
import java.util.List;
import java.util.Map;

/**
 * 货运-保险费支付记录 服务层
 * 
 * @author mz
 * @date 2019-02-23
 */
public interface PInsuranceService
{
	/**
     * 查询货运-保险费支付记录信息
     * 
     * @param id 货运-保险费支付记录ID
     * @return 货运-保险费支付记录信息
     */
	public JsonResult getPInsuranceById(String id);
	
	/**
     * 查询货运-保险费支付记录列表
     * 
     * @param pInsurance 货运-保险费支付记录信息
     * @return 货运-保险费支付记录集合
     */
	public JsonResult list(Integer page, Integer limit, PInsurance pInsurance);
	
	/**
     * 新增货运-保险费支付记录
     * 
     * @param pInsurance 货运-保险费支付记录信息
     * @return 结果
     */
	public JsonResult add(PInsurance pInsurance);
	
	/**
     * 修改货运-保险费支付记录
     * 
     * @param pInsurance 货运-保险费支付记录信息
     * @return 结果
     */
	public JsonResult edit(PInsurance pInsurance);

    /**
     * 删除货运-保险费支付记录信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public JsonResult remove(String ids);
	
}
