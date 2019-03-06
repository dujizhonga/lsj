package com.yrsoft.platform.dao;

import com.yrsoft.platform.entity.PMarginRefund;
import java.util.List;
import java.util.Map;
/**
 * 货运-保证金退款申请 数据层
 * 
 * @author mz
 * @date 2019-02-23
 */
public interface PMarginRefundDao
{
	/**
     * 查询货运-保证金退款申请信息
     * 
     * @param id 货运-保证金退款申请ID
     * @return 货运-保证金退款申请信息
     */
	public PMarginRefund selectPMarginRefundById(String id);
	
	/**
     * 查询货运-保证金退款申请列表
     * 
     * @param pMarginRefund 货运-保证金退款申请信息
     * @return 货运-保证金退款申请集合
     */
	public List<PMarginRefund> selectPMarginRefundList(PMarginRefund pMarginRefund);
	
	/**
     * 新增货运-保证金退款申请
     * 
     * @param pMarginRefund 货运-保证金退款申请信息
     * @return 结果
     */
	public int insertPMarginRefund(PMarginRefund pMarginRefund);
	
	/**
     * 修改货运-保证金退款申请
     * 
     * @param pMarginRefund 货运-保证金退款申请信息
     * @return 结果
     */
	public int updatePMarginRefund(PMarginRefund pMarginRefund);
	
	/**
     * 删除货运-保证金退款申请
     * 
     * @param id 货运-保证金退款申请ID
     * @return 结果
     */
	public int updatePMarginRefundByIds(Map<String, Object> param);

    /**
     * 删除货运-保证金退款申请
     *
     * @param id 货运-保证金退款申请ID
     * @return 结果
     */
    public int deletePMarginRefundById(Map<String, Object> param);
	
}