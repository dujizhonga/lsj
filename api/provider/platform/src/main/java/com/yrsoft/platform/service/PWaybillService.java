package com.yrsoft.platform.service;

import java.util.List;
import java.util.Map;

import com.yrsoft.common.utils.JsonResult;
import com.yrsoft.platform.entity.PWaybill;
import com.yrsoft.platform.entity.PWaybillVo;

/**
 * 货运-运单 服务层
 * 
 * @author mz
 * @date 2019-02-23
 */
public interface PWaybillService
{
	/**
     * 查询货运-运单信息
     * 
     * @param id 货运-运单ID
     * @return 货运-运单信息
     */
	public JsonResult getPWaybillById(String id);
	/**
     * 查询运单详情
     * 
     * @param id 货运-运单ID
     * @return 货运-运单信息
     */
	public JsonResult getWaybillById(String id);
	
	/**
     * 查询货运-运单列表
     * 
     * @param pWaybill 货运-运单信息
     * @return 货运-运单集合
     */
	public JsonResult list(Integer page, Integer limit, PWaybill pWaybill);
	
	/**
     * 查询运单列表某一条件下数据条数
     * 
     * @param pWaybill 货运-运单信息
     * @return 货运-运单集合
     */
	public JsonResult selectListCount(PWaybill pWaybill);
	
	/**
	 * 查寻货运单相关的运单信息；不分页
	 * @param pWaybill
	 * @return:JsonResult
	 * @author:DU'JZ
	 * @data:2019年2月25日 下午2:32:28 
	 * @throws
	 */
	public JsonResult listByInvoiceId(PWaybill pWaybill);
	/**
	 * 查寻货运单相关的运单信息
	 * @param pWaybill
	 * @return:JsonResult
	 */
	public JsonResult listByInvoiceIds(Integer page,Integer limit,String shipperId,String ownerId,String waybillNumber,String startTime,String endTime,String waybillState
			,String flag);
	
	/**
     * 新增货运-运单
     * 
     * @param pWaybill 货运-运单信息
     * @return 结果
     */
	public JsonResult add(PWaybill pWaybill);
	
	/**
     * 修改货运-运单
     * 
     * @param pWaybill 货运-运单信息
     * @return 结果
     */
	public JsonResult edit(PWaybill pWaybill);
	/**
     * 运单添加评论
     * shihh
     * @param pWaybill 货运-运单信息
     * @return 结果 
     */
	public JsonResult upPWaybill(PWaybillVo pWaybillVo);

    /**
     * 删除货运-运单信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public JsonResult remove(String ids);

	/**
	 *
	 * 通过id批量查询
	 *
	 * @param list
	 * @return
	 */
	List<PWaybill> getByIds(List<String> list);
	
	/**
	 * 根据货主id查询所有运单
	 * @param: @param page
	 * @param: @param limit
	 * @param: @param pWaybill
	 * @param: @return
	 * @return: JsonResult
	 * @auther: shihh
	 * @date: 2019年2月26日下午1:30:27
	 */
	/*public JsonResult listByShipperId(Integer page,Integer limit,String shipperId);*/
	
	/**
	 * 更新货运单状态<p>
	 * 
	 * @param  paramMap
	 * @return JsonResult
	 * @author WANGQI
	 * @date 2019年3月1日 上午11:15:25
	 */
	public JsonResult updateByIds(Map<String,Object> paramMap);
	
	
	/**
	 * 查询无车承运电子路单和资金流水单所需要的部分数据 <p>
	 * @param waybillId
	 * 		      货运单ID
	 * @return <code>JsonResult</code><p>
	 * 		         运单ID<p>
	 * 		         发货用户ID<p>
	 *         运输车辆ID<p>
	 *         车主ID<p>
	 *         订单编号<p>
	 *         订单创建时间<p>
	 *         装车后的出发时间<p>
	 *         到达时间<p>
	 *         收货人姓名<p>
	 *         货物出发地<p>
	 *         货物到达地<p>
	 *         订单金额<p>
	 *         货物重量<p>
	 *         出发地代码<p>
	 *         到达地代码<p>
	 *         司机ID<p>
	 * @author WANGQI
	 * @date 2019年3月4日 下午2:51:54
	 */
	public JsonResult selectTruckBrokerData(String waybillId);
	/**
	 * 将运单标记为已投保
	 * @param id
	 * @return
	 */
	public JsonResult updateInsuranceSendStateById(String id);
}
