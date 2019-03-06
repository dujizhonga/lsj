package com.yrsoft.delivery.service;

import com.yrsoft.common.utils.JsonResult;
/**
 * 车主信息详情查询接口
 * @author lu
 * @date 2019/2/26
 */
public interface OwnerInfoService {
	

	/**
    *
    * 功能描述: 车主信息详情查询接口
    *
    * @param: shipperId:货主id 必填
    *         ownerId:车主id 必填
    *         type:查询类型：0：货主下的车主的运单信息  1：货主下的车主的车辆信息 必填
    *         waybillNumber：运单编号
    *         ownerName:车主名称
    *         telephone:车主电话
    *         startTime:起始时间
    *         endTime:结束时间
    *         waybillState:运单状态: 0-未发货 1-已发货 2-已送达 3-已收货 4-已撤销
    *         flag:运单类型  （0.指派单  1.系统单 ）
    *         carNumber:车牌号码
    * @return: 
    * @auther: lu
    * @date: 2019/2/26
    */
	public JsonResult getOwnerInfo(String paramStr);
	/**
     * 通过货主id查询关注车主信息列表
     *
     * @param shipperId 货主ID
     * @return 结果
     */
	public JsonResult selectOwnerInfo(Integer page,Integer limit,String shipperId);
}
