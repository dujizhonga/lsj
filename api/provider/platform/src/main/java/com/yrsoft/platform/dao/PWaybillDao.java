package com.yrsoft.platform.dao;

import com.yrsoft.platform.entity.PWaybill;
import com.yrsoft.platform.entity.PWaybillVo;

import java.util.List;
import java.util.Map;
/**
 * 货运-运单 数据层
 * 
 * @author mz
 * @date 2019-02-23
 */
public interface PWaybillDao
{
	/**
     * 查询货运-运单信息
     * 
     * @param id 货运-运单ID
     * @return 货运-运单信息
     */
	public PWaybill selectPWaybillById(String id);
	/**
     * 查询运单详情
     * 
     * @param id 货运-运单ID
     * @return 货运-运单信息
     */
	public PWaybill selectWaybillById(String id);
	/**
     * 查询货运-运单列表
     * 
     * @param pWaybill 货运-运单信息
     * @return 货运-运单集合
     */
	public List<PWaybill> selectPWaybillList(PWaybill pWaybill);
	/**
     * 查询运单列表某一条件下数据条数
     * 
     * @param pWaybill 货运-运单信息
     * @return 货运-运单集合
     */
	public int selectListCount(PWaybill pWaybill);
	/**
	 * 据货主id查询名下所有运单
	 * @param: @param shipperId
	 * @param: @return
	 * @return: List<PWaybill>
	 * @auther: shihh
	 * @date: 2019年2月27日下午2:54:44
	 */
	/*public List<PWaybill> listByShipperId(String shipperId);*/
	
	/**
     * 新增货运-运单
     * 
     * @param pWaybill 货运-运单信息
     * @return 结果
     */
	public int insertPWaybill(PWaybill pWaybill);
	
	/**
     * 修改货运-运单
     * 
     * @param pWaybill 货运-运单信息
     * @return 结果
     */
	public int updatePWaybill(PWaybill pWaybill);
	
	/**
     * 运单添加评价
     * shihh
     * @param pWaybill 货运-运单信息
     * @return 结果
     */
	public int upPWaybill(PWaybillVo pWaybillvo);
	
	/**
     * 删除货运-运单
     * 
     * @param id 货运-运单ID
     * @return 结果
     */
	public int updatePWaybillByIds(Map<String, Object> param);

    /**
     * 删除货运-运单
     *
     * @param id 货运-运单ID
     * @return 结果
     */
    public int deletePWaybillById(Map<String, Object> param);

	/**
	 *
	 * 通过id批量查询
	 *
	 * @param list
	 * @return
	 */
	List<PWaybill> getByIds(List<String> list);

	//查询运单信息
	public List<PWaybillVo> listByInvoiceIds(Map<String,Object> map);
	
	/**
	 * 查询无车承运电子路单和资金流水单所需要的部分数据 <p>
	 * @param waybillId
	 * 		      货运单ID
	 * @return <code>Map</code><p>
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
	public Map<String,Object> selectTruckBrokerData(String waybillId);

	/**
	 * 将运单标记为已投保
	 * @param id
	 * @return
	 */
	public int updateInsuranceSendStateById(String id);
}