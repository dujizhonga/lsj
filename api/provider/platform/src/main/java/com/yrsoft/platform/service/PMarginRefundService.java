package com.yrsoft.platform.service;

import com.yrsoft.platform.entity.PMarginRefund;
import com.yrsoft.common.utils.JsonResult;
import java.util.List;
import java.util.Map;

/**
 * 货运-保证金退款申请 服务层
 * 
 * @author mz
 * @date 2019-02-23
 */
public interface PMarginRefundService
{
	/**
     * 查询货运-保证金退款申请信息
     * 
     * @param id 货运-保证金退款申请ID
     * @return 货运-保证金退款申请信息
     */
	public JsonResult getPMarginRefundById(String id);
	
	/**
     * 查询货运-保证金退款申请列表
     * 
     * @param pMarginRefund 货运-保证金退款申请信息
     * @return 货运-保证金退款申请集合
     */
	public JsonResult list(Integer page, Integer limit, PMarginRefund pMarginRefund);
	
	/**
     * 新增货运-保证金退款申请
     * 
     * @param pMarginRefund 货运-保证金退款申请信息
     * @return 结果
     */
	public JsonResult add(PMarginRefund pMarginRefund);
	
	/**
     * 修改货运-保证金退款申请
     * 
     * @param pMarginRefund 货运-保证金退款申请信息
     * @return 结果
     */
	public JsonResult edit(PMarginRefund pMarginRefund);

    /**
     * 删除货运-保证金退款申请信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public JsonResult remove(String ids);
	
}
