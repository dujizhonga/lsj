package com.yrsoft.platform.controller;


import javax.ws.rs.core.MediaType;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.servicecomb.provider.rest.common.RestSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yrsoft.common.utils.JsonResult;
import com.yrsoft.common.utils.StringUtils;
import com.yrsoft.platform.entity.PWaybill;
import com.yrsoft.platform.entity.PWaybillVo;
import com.yrsoft.platform.service.PWaybillService;


/**
 * 货运-运单 信息操作处理
 * 
 * @author mz
 * @date 2019-02-23
 */
@RestSchema(schemaId = "pWaybill")
@RequestMapping(path = "/provider/pWaybill",produces = MediaType.APPLICATION_JSON)
public class PWaybillController
{

	@Autowired
	private PWaybillService pWaybillService;

    /**
     * 查询货运-运单一个
     */
	@RequestMapping(value = "/getPWaybillById",method = RequestMethod.POST)
	public JsonResult getPWaybillById(String id){
	    if (StringUtils.isBlank(id)){
	        return JsonResult.error(201,"请传入主键编号");
		}
		return pWaybillService.getPWaybillById(id);
	}
	 /**
     * 查询运单详情
     */
	@RequestMapping(value = "/getWaybillById",method = RequestMethod.POST)
	public JsonResult getWaybillById(String id){
	    if (StringUtils.isBlank(id)){
	        return JsonResult.error(201,"请传入主键编号");
		}
		return pWaybillService.getWaybillById(id);
	}


    /**
     * 查询货运-运单列表
     */
	@RequestMapping(value = "/list",method = RequestMethod.POST)
	public JsonResult list(Integer page,Integer limit,PWaybill pWaybill){
        page =  page != null ? page:0;
        limit =  limit != null ?limit:10;
	    try {
            return pWaybillService.list(page,limit,pWaybill);
        } catch (Exception e) {
        	e.printStackTrace();
            return JsonResult.error(207,"服务器错误");
        }
    }
	
	/**
	 * 根据货主id查询所有运单
	 * @param: @param page
	 * @param: @param limit
	 * @param: @param shipperId
	 * @param: @return
	 * @return: JsonResult
	 * @auther: shihh
	 * @date: 2019年2月27日下午2:53:30
	 */
	/*@RequestMapping(value = "/selectWaybill",method = RequestMethod.POST)
	public JsonResult listByShipperId(Integer page,Integer limit,String shipperId){
        page =  page != null ? page:0;
        limit =  limit != null ?limit:10;
	    try {
            return pWaybillService.listByShipperId(page, limit, shipperId);
        } catch (Exception e) {
            return JsonResult.error(207,"服务器错误");
        }
    }*/


    /**
     * 查询货运-运单列表的车辆列表不分页
     */
	@RequestMapping(value = "/listByInvoiceId",method = RequestMethod.POST)
	public JsonResult listByInvoiceId(PWaybill pWaybill){
     
	    try {
            return pWaybillService.listByInvoiceId(pWaybill);
        } catch (Exception e) {
        	e.printStackTrace();
            return JsonResult.error(207,"服务器错误");
        }
    }
	
	 /**
     * 查询货运-货主的车主下的运单列表
     */
	@RequestMapping(value = "/listByInvoiceIds",method = RequestMethod.POST)
	public JsonResult listByInvoiceIds(Integer page,Integer limit,String shipperId,String ownerId,String waybillNumber,String startTime,String endTime,String waybillState
			,String flag){
		 page =  page != null ? page:0;
	     limit =  limit != null ?limit:10;
	    try {
            return pWaybillService.listByInvoiceIds( page, limit,shipperId,ownerId, waybillNumber, startTime, endTime, waybillState
        			, flag);
        } catch (Exception e) {
        	e.printStackTrace();
            return JsonResult.error(207,"服务器错误");
        }
    }
    /**
     * 新增保存货运-运单
     */

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public JsonResult add(PWaybill pWaybill)
    {
        try {
            return pWaybillService.add(pWaybill);
        } catch (Exception e) {
        	e.printStackTrace();
            return JsonResult.error(207,"服务器错误");
        }
    }

    /**
     * 修改保存货运-运单
     */

    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    public JsonResult edit(PWaybill pWaybill)
    {
        try {
            return pWaybillService.edit(pWaybill);
        } catch (Exception e) {
        	e.printStackTrace();
            return JsonResult.error(207,"服务器错误");
        }

    }

    /**
     * 评价运单
     */
    @RequestMapping(value = "/addEvaluate",method = RequestMethod.POST)
    public JsonResult addEvaluate(PWaybillVo pWaybillVo)
    {
        try {
            return pWaybillService.upPWaybill(pWaybillVo);
        } catch (Exception e) {
        	e.printStackTrace();
            return JsonResult.error(207,"服务器错误");
        }

    }

    /**
     * 删除货运-运单
     */
    @RequestMapping(value = "/remove",method = RequestMethod.POST)
    public JsonResult remove(String ids)
    {
        if (StringUtils.isBlank(ids)) {
            return JsonResult.error(201,"请传入要删除的编号");
        }
        try {
            return pWaybillService.remove(ids);
        } catch (Exception e) {
        	e.printStackTrace();
            return JsonResult.error(207,"服务器错误");
        }
    }


    /**
     * 删除货运-运单
     */
    @RequestMapping(value = "/getByIds",method = RequestMethod.POST)
    public JsonResult getByIds(String ids)
    {
        if (StringUtils.isBlank(ids)) {
            return JsonResult.error(201,"请传入要删除的编号");
        }
        try {
            List<String> strings = Arrays.asList(ids.split(","));
            return JsonResult.success(pWaybillService.getByIds(strings));
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.error(207,"服务器错误");
        }
    }
    
    /**
     *	更新运单的保险费支付状态<p>
     *
     * @param waybillIds   运单ID(以逗号分隔)
     * @param insuranceId  保险费支付记录ID 
     * @param insurancePayState 保险费支付状态
     * @return JsonResult 
     * @author WANGQI
     * @date 2019年3月1日 上午11:30:38
     */
    @RequestMapping(value = "/updateByIds",method = RequestMethod.POST)
    public JsonResult updateByIds(String waybillIds,String insuranceId,Integer insurancePayState)  {
    	Map<String,Object> map = new HashMap<>();
    	map.put("ids", Arrays.asList(waybillIds));
    	map.put("insuranceId", insuranceId);
    	map.put("insurancePayState", insurancePayState);
    	JsonResult result = pWaybillService.updateByIds(map);
    	return result;
    }
    
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
    @RequestMapping(value = "/selectTruckBrokerData",method = RequestMethod.POST)
    public JsonResult selectTruckBrokerData(String waybillId) {
    	if(StringUtils.isEmpty(waybillId)) {
    		JsonResult.success(201, "货运单ID不能为空");
    	}
		return pWaybillService.selectTruckBrokerData(waybillId);
    }
    /**
   	 * 查询运单某条件下集合数量
   	 * @param pWaybill 运单信息
   	 * @return <code>JsonResult</code><p>
   	 * 		         数量count<p>		        
   	 * @author WANGQI
   	 * @date 2019年3月4日 下午2:51:54
   	 */
    @RequestMapping(value = "/selectListCount",method = RequestMethod.POST)
    public JsonResult selectListCount(PWaybill pWaybill) {
    	   try {
               return pWaybillService.selectListCount(pWaybill);
           } catch (Exception e) {
               return JsonResult.error(207,"服务器错误");
           }
       }

    /**
     * 将运单标记为已投保
     * @param id
     * @return
     */
    @RequestMapping(value = "/updateInsuranceSendStateById",method = RequestMethod.POST)
    public JsonResult updateInsuranceSendStateById(String id){
        try {
            return pWaybillService.updateInsuranceSendStateById(id);
        } catch (Exception e) {
            return JsonResult.error(207,"服务器错误");
        }
    }
}
