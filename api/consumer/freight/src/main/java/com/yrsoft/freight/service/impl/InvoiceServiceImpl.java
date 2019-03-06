package com.yrsoft.freight.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.servicecomb.provider.springmvc.reference.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yrsoft.common.config.Global;
import com.yrsoft.common.constant.UrlContants;
import com.yrsoft.common.utils.DateUtils;
import com.yrsoft.common.utils.ExcelUtils;
import com.yrsoft.common.utils.JsonResult;
import com.yrsoft.freight.vo.InvoiceWaybillsInfoVO;




@Component
public class InvoiceServiceImpl implements com.yrsoft.freight.service.InvoiceService{
    private static final RestTemplate restTemplate = RestTemplateBuilder.create();
    
    /**
     * 货运单列表
     * @param page 当前页
     * @param limit 页大小
     * @param pInvoice 查询对象
     * @return json返回结果对象
     */
    @Override
    public JsonResult selectByPage(String paraStr){
        //通过调用其他接口实现service
    	Map<String,String> maps = (Map)JSON.parse(paraStr); 
    	MultiValueMap<String, String> multiValueMap=new LinkedMultiValueMap<>();
    	for (String key : maps.keySet()) { 
    		multiValueMap.add(key, maps.get(key));
    	}
    	
    	/*if(page!=null){
    		multiValueMap.add("page", page);
    	}
    	if(limit!=null){
    		multiValueMap.add("limit", limit+"");
    	}
    	if(pInvoice!=null){
    		multiValueMap.add("invoiceNumber", pInvoice.getInvoiceNumber());
    		multiValueMap.add("startAddress", pInvoice.getStartAddress());
    		multiValueMap.add("arriveAddress", pInvoice.getArriveAddress());
    		multiValueMap.add("createTime", pInvoice.getCreateTime()+"");
    		multiValueMap.add("endTime", pInvoice.getEndTime()+"");
    		multiValueMap.add("status", pInvoice.getStatus()+"");
    	}*/
    	JsonResult f = restTemplate.postForObject(UrlContants.PLATFORM+"pInvoice/list",multiValueMap,JsonResult.class);
        return f;
    }
    
    /**
     * 货运单详情查询
     * @param id 货运单id
     * @return json结果对象
     */
    @Override
    public JsonResult selectDeatial(String paraStr){
    	Map<String,String> maps = (Map)JSON.parse(paraStr); 
    	MultiValueMap<String, String> multiValueMap=new LinkedMultiValueMap<>();
    	for (String key : maps.keySet()) { 
    		multiValueMap.add(key, maps.get(key));
    	}
    	//multiValueMap.add("id", id);
    	JsonResult f = restTemplate.postForObject(UrlContants.PLATFORM+"pInvoice/getPInvoiceById",multiValueMap,JsonResult.class);
    	
    	//获取货运单信息
    	LinkedHashMap<String, Object> link=(LinkedHashMap<String, Object>) f.getData();
    	String shipperId=(String) link.get("shipperId");
    	
    	//获取货主姓名
    	MultiValueMap<String, String> multiValueMap1=new LinkedMultiValueMap<>();
    	multiValueMap1.add("id", shipperId);
    	JsonResult m= restTemplate.postForObject(UrlContants.MEMBER+"mMember/getMMemberById",multiValueMap1,JsonResult.class);
    	
    	LinkedHashMap<String, Object> linkM=(LinkedHashMap<String, Object>) m.getData();
    	String shipperName=(String) linkM.get("realName");
    	link.put("shipperName", shipperName);
    	f.setData(link);
    	return f;
    }
    
    /**
     * 车辆历史坐标
     * @param page 当前页
     * @param limit 页大小
     * @param poCarPositionLog 车辆历史坐标对象
     * @return json返回对象
     */
    @Override
    public JsonResult selectCarPositionLog(String paraStr){
        //通过调用其他接口实现service
    	Map<String,String> maps = (Map)JSON.parse(paraStr); 
    	MultiValueMap<String, String> multiValueMap=new LinkedMultiValueMap<>();
    	for (String key : maps.keySet()) { 
    		multiValueMap.add(key, maps.get(key));
    	}
    	/*if(page!=null){
    		multiValueMap.add("page", page);
    	}
    	if(limit!=null){
    		multiValueMap.add("limit", limit+"");
    	}
    	if(poCarPositionLog!=null){
    		multiValueMap.add("carId", poCarPositionLog.getCarId());
    	}*/
    	JsonResult f = restTemplate.postForObject(UrlContants.POSITION+"poCarPositionLog/list",multiValueMap,JsonResult.class);
        return f;
    }
    
    /**
     * 一键收货
     * @param page 当前页
     * @param limit 页大小
     * @param invoiceId 货运单id
     * @param waybillNumbers 运单ID
     * @return waybillNumbers
     */
	@SuppressWarnings("unchecked")
	@Override
	public JsonResult takeDelivery(String paraStr) {
				
		Map<String, Object> resultMap = new HashMap<String, Object>();
		//把参数转换成json对象
		JSONObject jsonObject = JSONObject.parseObject(paraStr);	    
		//输入待收货列表
		JSONArray dataArray = null;
		if(null != jsonObject && null != jsonObject.get("list")){
			dataArray = JSONArray.parseArray(jsonObject.get("list").toString());
		}else {
			return JsonResult.error(201, "未提交任何待收货运单");
		}
	    
		if(dataArray.size()<1){
			  return JsonResult.error(201, "未提交任何待收货运单");
			}
		
		//单车提交处理
		if(dataArray.size()==1){	
			//查询运单信息
			LinkedHashMap<String, Object> waybillMap = this.queryWaybill(((JSONObject)dataArray.get(0)).get("id").toString());
			
			if(null != waybillMap.get("query_end") && (int)waybillMap.get("query_end") == 1){
				return JsonResult.error(207, "基础数据查询错误");
			}
			
			if(null != waybillMap && null != waybillMap.get("waybillState") && (int) waybillMap.get("waybillState") != 2){
				return JsonResult.error(201, "请勿重复收货");
			}
		}
		
		//已收货状态运单
		List<JSONObject> takedList = new ArrayList<JSONObject>();		
		//本次修改待收货运单
		List<JSONObject> justTakedList = new ArrayList<JSONObject>();
		//货运单id
		String  invoiceId = null;
		//获取当前系统时间，运单，货运单修改时间共用
		String sysTime = DateUtils.getTimeMillis().toString();	
		
		for(int i=0;i<dataArray.size();i++){
			JSONObject parData = (JSONObject) dataArray.get(i);
            //查询运单信息
			LinkedHashMap<String, Object> waybillMap = this.queryWaybill(parData.get("id").toString());
						
			if(null != waybillMap.get("query_end") && (int)waybillMap.get("query_end") == 1){
				return JsonResult.error(207, "基础数据查询错误");
			}
			//将非收货状态运单存入List中
			if(dataArray.size() != 1 && null != waybillMap && null != waybillMap.get("waybillState") && (int) waybillMap.get("waybillState") != 2){
				parData.put("waybillState", waybillMap.get("waybillState"));
				takedList.add(parData);
			}
			//处理待收货运单为收货状态
			if(null != waybillMap && null != waybillMap.get("waybillState") && (int) waybillMap.get("waybillState") == 2){
					 				
				//修改运单状态及实际运费
				MultiValueMap<String, String> waybillPar = new LinkedMultiValueMap<>();							    	
				//实际运费和预付运费对比
				if(null != parData.get("actualFreight") && (int)parData.get("actualFreight") <= (int)waybillMap.get("advanceFreight")){					
					waybillPar.add("actualFreight", parData.get("actualFreight").toString());				
				}else {
					waybillPar.add("actualFreight", waybillMap.get("advanceFreight").toString());
				}
				
					
				waybillPar.add("waybillState", "3");
	            waybillPar.add("confirmReceiptTime",sysTime );
				JsonResult waybillResult =  restTemplate.postForObject(UrlContants.PLATFORM+"pWaybill/edit",waybillPar,JsonResult.class);
				
				if(waybillResult.getCode() != 200){
		    		return JsonResult.error(207, "基础数据服务错误");
				} 
				
				//将更新的运单放入List中
				parData.put("waybillState", "3");
				justTakedList.add(parData);
				
				//判断修改货运单状态					
				//获取货运单id				
				if(i == 0){
					invoiceId = waybillMap.get("invoiceId").toString();
				}
				
			}			
		}
		
		//查询货运单下申请车、指派车总数量	
		MultiValueMap<String, String> invoicePra = new LinkedMultiValueMap<>();
		invoicePra.add("id", invoiceId);
    	JsonResult invoiceData = restTemplate.postForObject(UrlContants.PLATFORM+"pInvoice/getPInvoiceById",invoicePra,JsonResult.class);
    	if(invoiceData.getCode() != 200){
    		return JsonResult.error(207, "基础数据服务错误");
    	}
    	LinkedHashMap<String, Object> invoiceMap = (LinkedHashMap<String, Object>) invoiceData.getData();
    	int carNum = (int) invoiceMap.get("applyCarNo")+(int) invoiceMap.get("assignCarNo");
    	
    	//查询该货运单下运单已完成数量
    	MultiValueMap<String, String> waybillCountPra = new LinkedMultiValueMap<>();
    	waybillCountPra.add("invoiceId", invoiceId);
    	waybillCountPra.add("waybillState", "3");
    	JsonResult waybillCountData = restTemplate.postForObject(UrlContants.PLATFORM+"pWaybill/selectListCount",waybillCountPra,JsonResult.class);
    	if(waybillCountData.getCode() != 200){
    		return JsonResult.error(207, "基础数据服务错误");
    	}
    	LinkedHashMap<String, Object> countMap = (LinkedHashMap<String, Object>) waybillCountData.getData();
    	int waybillNum = (int) countMap.get("count");
    	
    	//判断数量，修改货运单
    	if(carNum == waybillNum){
    		//查询货运单下申请车、指派车数量	
			MultiValueMap<String, String> invoiceFreshPra = new LinkedMultiValueMap<>();
			invoiceFreshPra.add("id", invoiceId);
			invoiceFreshPra.add("status", "2");//TODO
			invoiceFreshPra.add("endTime", sysTime);					
	    	JsonResult invoiceFreshData = restTemplate.postForObject(UrlContants.PLATFORM+"pInvoice/edit",invoiceFreshPra,JsonResult.class);
	    	if(invoiceFreshData.getCode() != 200){
	    		return JsonResult.error(207, "基础数据服务错误");
	    	}
    	}
		
		resultMap.put("takedList", takedList);
		resultMap.put("justTakedList", justTakedList);
		return JsonResult.createResponse(200, "一键收货成功", resultMap);
	}
    
	/**
	 * 查询运单信息
	 * @param id
	 * @return
	 */
	@SuppressWarnings({ "unchecked" })
	public LinkedHashMap<String, Object> queryWaybill(String id){
		
		LinkedHashMap<String, Object> realData = null;
		
		MultiValueMap<String, String> waybillPar = new LinkedMultiValueMap<>();
		waybillPar.add("id", id);
    	JsonResult waybillResult =  restTemplate.postForObject(UrlContants.PLATFORM+"pWaybill/getPWaybillById",waybillPar,JsonResult.class);
    	if(waybillResult.getCode() != 200){
			//查询异常返回
    		realData = new LinkedHashMap<>();//TODO
    		realData.put("query_end", 1);
    		return realData;
		} 
    	
    	
    	
    	realData = (LinkedHashMap<String, Object>)waybillResult.getData();
    	     	   	
		return realData;		
	}
	
	/**
     * 已到位车辆信息查询及运费查询
     * @param page 当前页
     * @param limit 页大小
     * @param invoiceId 货运单id
     * @param waybillIds 运单ID
     * @param flag 车辆是否选择提交，0是1否
     * @return waybillNumbers
     */
	@SuppressWarnings("unchecked")
	@Override
	public JsonResult selectFreighPay(String params) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		//把参数转换成json对象
		JSONObject jsonObject = JSONObject.parseObject(params);								
		//封装请求参数
		MultiValueMap<String, String> invoicePar = new LinkedMultiValueMap<>();
		if(null != jsonObject && null != jsonObject.get("id")){
			invoicePar.add("invoiceId",jsonObject.get("id").toString());
		}else {
			return JsonResult.error(207, "请上传id");
		}
				    
    	JsonResult invoiceResult =  restTemplate.postForObject(UrlContants.PLATFORM+"pInvoice/getPInvoiceById",invoicePar,JsonResult.class);
    	if(invoiceResult.getCode() != 200){
			return JsonResult.error(207, "基础数据查询出错");
		}
    	//添加单车运费
    	@SuppressWarnings("unchecked")
    	String basicAmount  = ((LinkedHashMap<String, Object>)invoiceResult.getData()).get("basicAmount").toString();
		resultMap.put("basicAmount", basicAmount);
		
		//创建数据返回对象
		List<InvoiceWaybillsInfoVO> dataList = new ArrayList<InvoiceWaybillsInfoVO>();
			               
		if (null != jsonObject.get("flag") && jsonObject.get("flag").equals("0")) {
		
			List<Object> waybillIds = JSON.parseArray(jsonObject.get("waybillIds").toString());  //运单id列表
			
			//遍历查询
			for(Object obj:waybillIds){
				InvoiceWaybillsInfoVO infoVO = new InvoiceWaybillsInfoVO();				
				//查询运单类表
				MultiValueMap<String, String> waybillPar = new LinkedMultiValueMap<>();
				waybillPar.add("id", obj.toString());
				JsonResult waybillResult =  restTemplate.postForObject(UrlContants.PLATFORM+"pWaybill/list",waybillPar,JsonResult.class);
				if(waybillResult.getCode() != 200){
					return JsonResult.error(207, "基础数据查询出错");
				}
				LinkedHashMap<String, Object> realData = (LinkedHashMap<String, Object>)waybillResult.getData();
				List<LinkedHashMap<String, Object>> wayBillInfo =  (ArrayList<LinkedHashMap<String,Object>>) realData.get("list");
				
				//获取运单支付状态
				infoVO.setWaybillState((Integer)wayBillInfo.get(0).get("waybillState"));
		        infoVO.setId(wayBillInfo.get(0).get("id").toString());
		        infoVO.setWaybillNumber(wayBillInfo.get(0).get("waybillNumber").toString());
				//查询车辆列表
				MultiValueMap<String, String> carPar = new LinkedMultiValueMap<>();
				carPar.add("id", wayBillInfo.get(0).get("carId").toString());
				JsonResult carResult =  restTemplate.postForObject(UrlContants.AUTH+"car/getCarById",carPar,JsonResult.class);
				if(carResult.getCode() != 200){
					return JsonResult.error(207, "基础数据查询出错");
				}
				//获取车辆牌照
				infoVO.setCarNumber(((LinkedHashMap<String, Object>)carResult.getData()).get("carNumber").toString());
				dataList.add(infoVO);
			}
			
		}
		//如果不是前端提交的运单id，查询当前货运单下所有带收货运单id
		if (null != jsonObject.get("flag") && jsonObject.get("flag").equals("1")) {
		
			MultiValueMap<String, String> waybillPar = new LinkedMultiValueMap<>();
			waybillPar.add("id", jsonObject.get("invoiceId").toString());			
			waybillPar.add("waybillState", "2");
			JsonResult waybillResult =  restTemplate.postForObject(UrlContants.PLATFORM+"pWaybill/listByInvoiceId",waybillPar,JsonResult.class);
		 	//将查询结果放入map中
			@SuppressWarnings("rawtypes")
    		LinkedHashMap map = (LinkedHashMap) waybillResult.getData();   	
        	
        	@SuppressWarnings("unchecked")
    		List<LinkedHashMap<String, Object>> realData =  (ArrayList<LinkedHashMap<String,Object>>) map.get("list");
        	
        	for(int i = 0;i<realData.size();i++){
        		InvoiceWaybillsInfoVO infoVO = new InvoiceWaybillsInfoVO();
        		infoVO.setId(realData.get(i).get("id").toString());
        		infoVO.setWaybillNumber(realData.get(i).get("waybillNumber").toString());
        		infoVO.setWaybillState((Integer)realData.get(i).get("waybillState"));
        		//查询车辆列表
				MultiValueMap<String, String> carPar = new LinkedMultiValueMap<>();
				carPar.add("id", realData.get(i).get("carId").toString());
				JsonResult carResult =  restTemplate.postForObject(UrlContants.IpTest+"provider/car/getCarById",carPar,JsonResult.class);
				if(carResult.getCode() != 200){
					return JsonResult.error(207, "基础数据查询出错");
				}
				//获取车辆牌照
				infoVO.setCarNumber(((LinkedHashMap<String, Object>)carResult.getData()).get("carNumber").toString());
				dataList.add(infoVO);
        	}
		}
		
		//封装并返回结果
		resultMap.put("list", dataList);	
		return JsonResult.createResponse(200, "查询成功", resultMap);
	}
    
	/**
     * 消息点击跳转信息查询
     * @param page 当前页
     * @param limit 页大小
     * @param waybillNumber 运单ID
     * @return Map 封装结果
     */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public JsonResult queryForMessageJump(String params) {
		Map result = new HashMap<String,Object>(); //返回结果
		try {
			MultiValueMap<String, String> waybillPar = new LinkedMultiValueMap<>();
			//获取参数
			//把参数转换成json对象
			JSONObject jsonObject = JSONObject.parseObject(params);								
			//封装请求参数
			if(null != jsonObject && null != jsonObject.get("id")){
				waybillPar.add("id", jsonObject.get("id").toString());
			}else {
				return JsonResult.error(207, "请上传id");
			}
			//封装查询条件					
			waybillPar.add("waybillNumber", jsonObject.get("waybillNumber").toString());
			JsonResult waybillResult =  restTemplate.postForObject(UrlContants.PLATFORM+"pWaybill/list",waybillPar,JsonResult.class);
			//将查询结果放入map中			
			LinkedHashMap map = (LinkedHashMap) waybillResult.getData();   	 		    	
			List<LinkedHashMap<String, Object>> realData =  (ArrayList<LinkedHashMap<String,Object>>) map.get("list");
	        //封装并返回结果
	    	result.put("invoiceId",  realData.get(0).get("invoiceId"));
	    	result.put("waybillState", realData.get(0).get("waybillState"));
		} catch (Exception e) {
			e.printStackTrace();
			return JsonResult.error(207, "查询异常");
		}		
    	return JsonResult.createResponse(200,"查询成功",result);
	}
   
    /**
     * 货运管理-货运单列表信息
     * 货运管理-发货单列表
     * @param paramStr
     * @return
     * @author:DU'JZ
     * @data:2019年2月27日 下午4:24:17 
     * @throws
     */
	@Override
	public JsonResult selectInvoiceInfoList(String paramStr) {
		JSONObject paramJson = JSONObject.parseObject(paramStr);
		//判断货主id必传
		if (!paramJson.containsKey("shipperId")) {
			return JsonResult.error(201, "shippperId参数未传");
		}
		MultiValueMap<String, String> multiValueMap=new LinkedMultiValueMap<>();
		for (String key : paramJson.keySet()) { 
    		multiValueMap.add(key, paramJson.getString(key));
    	}
		//货主id
		multiValueMap.add("shipperId", paramJson.getString("shipperId"));
		//货运单状态(1:未完成 ,2:完成)
		multiValueMap.add("status","1");
		//删除状态(0：未删除，1：已删除)
		multiValueMap.add("deleteFlag","0");
		try {
			ResponseEntity<String> invoiceInfo = restTemplate
					.postForEntity(UrlContants.PLATFORM+"pInvoice/selectInvoice", multiValueMap, String.class);
			int invoiceInfoCode = invoiceInfo.getStatusCodeValue();
			JSONObject invoiceInfoBody = JSONObject.parseObject(invoiceInfo.getBody());
			JsonResult jsonResult = JSONObject.toJavaObject(invoiceInfoBody, JsonResult.class);
			if (invoiceInfoCode != 200) { //判断链接基础数据请求返回结果是正常
				return JsonResult.error(207, "基础数据服务错误");
			}
			return jsonResult;
		} catch (Exception e) {
			e.printStackTrace();
			return JsonResult.error(500, "服务错误");
		}
	}
	
	/**
	 * 删除货运单
	 * @param paramStr
	 * @return
	 * @author:DU'JZ
	 * @data:2019年2月27日 下午5:13:05 
	 * @throws
	 */
	@Override
	public JsonResult deleteInvoiceById(String paramStr) {
		JSONObject paramJson = JSONObject.parseObject(paramStr);
		//判断货主id必传
		if (!paramJson.containsKey("invoiceId")) {
			return JsonResult.error(201, "invoiceId参数未传");
		}
		MultiValueMap<String, String> multiValueMap=new LinkedMultiValueMap<>();
		//循环遍历封装参数
		for (String key : paramJson.keySet()) { 
		    multiValueMap.add(key, paramJson.getString(key));
		}
		//货运单状态(1:未完成 ,2:完成)
		multiValueMap.add("status","1");
		//删除状态(0：未删除，1：已删除)
		multiValueMap.add("deleteFlag","0");
		try {
			ResponseEntity<String> invoiceInfo = restTemplate
					.postForEntity(UrlContants.PLATFORM+"pInvoice/getPInvoiceById", multiValueMap, String.class);
			int invoiceInfoCode = invoiceInfo.getStatusCodeValue();
			JSONObject invoiceInfoBody = JSONObject.parseObject(invoiceInfo.getBody());
			JsonResult jsonResult = JSONObject.toJavaObject(invoiceInfoBody, JsonResult.class);
			if (invoiceInfoCode != 200) { //判断链接基础数据请求返回结果是正常
				return JsonResult.error(207, "基础数据服务错误");
			}
			
			JSONObject invoice = JSONObject.parseObject(invoiceInfoBody.getString("data"));
			if (invoice == null) {
				return jsonResult;
			}
			//指派单数量
			String assignNo = invoice.getString("assignNo");
			//系统单数量
			String applyNo = invoice.getString("applyNo");
//			//指派车辆数量
//			int  assignCarNo = invoice.getIntValue("assignCarNo");
//			//系统车辆申请数量
//			int applyCarNo = invoice.getIntValue("applyCarNo");
			//重新封装货运单申请车和指派车数量，删除时，实际需要车辆数=运单数量
			multiValueMap.add("assignCarNo", assignNo);
			multiValueMap.add("applyCarNo", applyNo);
			ResponseEntity<String> invoiceInfoEdit = restTemplate.postForEntity(UrlContants.PLATFORM+"pInvoice/edit", multiValueMap, String.class);
			int invoiceInfoCodeEdit = invoiceInfo.getStatusCodeValue();
			JSONObject invoiceInfoBodyEdit = JSONObject.parseObject(invoiceInfoEdit.getBody());
			JsonResult jsonResultEdit = JSONObject.toJavaObject(invoiceInfoBodyEdit, JsonResult.class);
			if (invoiceInfoCodeEdit != 200) { //判断链接基础数据请求返回结果是正常
				return JsonResult.error(207, "基础数据服务错误");
			}
			return jsonResultEdit;
		} catch (Exception e) {
			e.printStackTrace();
			return JsonResult.error(500, "服务错误");
		}
	}
	
	/**
	 * 货运管理-我的货运单信息
	 * @param paramStr
	 * @return
	 * @author:DU'JZ
	 * @data:2019年2月27日 下午7:02:04 
	 * @throws
	 */
	@Override
	public JsonResult selectMyInvoiceInfo(String paramStr) {
		JSONObject paramJson = JSONObject.parseObject(paramStr);
		//判断货主id必传
		if (!paramJson.containsKey("shipperId")) {
			return JsonResult.error(201, "shipperId参数未传");
		}
		if (!paramJson.containsKey("waybillState")) {
			return JsonResult.error(201, "waybillState参数未传");
		}
		MultiValueMap<String, String> multiValueMap=new LinkedMultiValueMap<>();
		//循环遍历封装参数
		for (String key : paramJson.keySet()) { 
    		multiValueMap.add(key, paramJson.getString(key));
    	}
		//货运单状态(1:未完成 ,2:完成)
		multiValueMap.add("status","1");
		//删除状态(0：未删除，1：已删除)
		multiValueMap.add("deleteFlag","0");
		try {
			ResponseEntity<String> invoiceInfo = restTemplate
					.postForEntity(UrlContants.PLATFORM+"pInvoice/myPInvoiceInfo", multiValueMap, String.class);
			int invoiceInfoCode = invoiceInfo.getStatusCodeValue();
			JSONObject invoiceInfoBody = JSONObject.parseObject(invoiceInfo.getBody());
			JsonResult jsonResult = JSONObject.toJavaObject(invoiceInfoBody, JsonResult.class);
			if (invoiceInfoCode != 200) { //判断链接基础数据请求返回结果是正常
				return JsonResult.error(207, "基础数据服务错误");
			}
			return jsonResult;
		} catch (Exception e) {
			e.printStackTrace();
			return JsonResult.error(500, "服务错误");
		}
	}
	

	@Override
	public JsonResult exportWaybill(String paraStr){
		// TODO Auto-generated method stub
		
		//运单列表
		Map<String,String> maps = (Map)JSON.parse(paraStr); 
    	MultiValueMap<String, String> multiValueMap=new LinkedMultiValueMap<>();
    	if(maps!=null){
    		for (String key : maps.keySet()) { 
        		multiValueMap.add(key, maps.get(key));
        	}
    	}
    	JsonResult f = restTemplate.postForObject(Global.getUrl("test")+"provider/pWaybill/listByInvoiceId",multiValueMap,JsonResult.class);
    	
    	//运单列表塞车主名称，车主电话号，车牌号
    	List<Map<String,Object>> waybillList=(List<Map<String, Object>>) f.getData();
    	for(Map<String,Object> map : waybillList){
    		
    		///运单列表塞车主名称，车主电话号
    		MultiValueMap<String, String> multiValueMap1=new LinkedMultiValueMap<>();
        	multiValueMap1.add("id", (String) map.get("ownerId"));
        	JsonResult m = restTemplate.postForObject(Global.getUrl("member")+"provider/mMember/getMMemberById",multiValueMap1,JsonResult.class);
        	Map<String,Object> memmberMap=(Map<String, Object>) m.getData();
        	if(memmberMap!=null){
        		map.put("ownerName", memmberMap.get("realName"));
            	map.put("ownerPhon", memmberMap.get("telephone"));
        	}
        	
        	//运单列表塞车牌号
        	MultiValueMap<String, String> multiValueMap2=new LinkedMultiValueMap<>();
        	multiValueMap2.add("id", (String) map.get("carId"));
        	JsonResult car = restTemplate.postForObject(Global.getUrl("car")+"/provider/car/getCarById",multiValueMap2,JsonResult.class);
        	Map<String,Object> carMap=(Map<String, Object>) car.getData();
        	if(carMap!=null){
        		map.put("carNumber", carMap.get("carNumber"));
        	}
    	}
    	
    	//导出文件头列表
    	List<String> titleList=new ArrayList<>();
    	titleList.add("运单编号");
    	titleList.add("车主名称");
    	titleList.add("车主电话");
    	titleList.add("车牌号");
    	titleList.add("运单类型");
    	titleList.add("实际运费");
    	titleList.add("运单状态");
    	
    	//运单数据封装
    	List<Map<String, Object>> list=new ArrayList<>();
    	for(Map<String,Object> map : waybillList){
    		
    		//车主姓名/车主电话号查询筛选
			if(maps!=null&&maps.get("ownerName")!=null&&!"".equals(maps.get("ownerName"))){
    			if(!map.get("ownerName").equals(maps.get("ownerName"))){
    				continue;
    			}
    		}
    		if(maps!=null&&maps.get("ownerPhon")!=null&&!"".equals(maps.get("ownerPhon"))){
    			if(!map.get("ownerPhon").equals(maps.get("ownerPhon"))){
    				continue;
    			}
    		}
    		
    		Map<String,Object> waybillMap=new HashMap<>();
    		for(String mapKey:map.keySet()){
    			if(mapKey.equals("waybillNumber")){
    				waybillMap.put("运单编号", map.get(mapKey));
    			}
    			if(mapKey.equals("ownerName")){
    				waybillMap.put("车主名称", map.get(mapKey));
    			}
    			if(mapKey.equals("ownerPhon")){
    				waybillMap.put("车主电话", map.get(mapKey));
    			}
    			if(mapKey.equals("carNumber")){
    				waybillMap.put("车牌号", map.get(mapKey));
    			}
    			if(mapKey.equals("waybillState")){
    				if((map.get(mapKey)+"").equals("0")){
    					waybillMap.put("运单状态", "未发货");
    				}
    				if((map.get(mapKey)+"").equals("1")){
    					waybillMap.put("运单状态", "已发货");
    				}
    				if((map.get(mapKey)+"").equals("2")){
    					waybillMap.put("运单状态", "已送达");
    				}
    				if((map.get(mapKey)+"").equals("3")){
    					waybillMap.put("运单状态", "已收货");
    				}
    				if((map.get(mapKey)+"").equals("4")){
    					waybillMap.put("运单状态", "已撤销");
    				}
    			}
    			if(mapKey.equals("actualFreight")){
    				waybillMap.put("实际运费",Float.parseFloat(map.get(mapKey)+"")/100);
    			}
    			
    			if(mapKey.equals("flag")){
    				if((map.get(mapKey)+"").equals("0")){
    					waybillMap.put("运单类型", "指派单");
    				}
    				if((map.get(mapKey)+"").equals("1")){
    					waybillMap.put("运单类型", "系统单");
    				}
    				
    			}
    		}
    		list.add(waybillMap);
    	}
    	try {
			ExcelUtils.export("运单列表", titleList, list);
			return JsonResult.success();
		} catch (Exception e) {
			e.printStackTrace();
			return JsonResult.error(207,"服务器错误");
		}
	}

	@Override
	public JsonResult exportInvoice(String paraStr) {
		// TODO Auto-generated method stub
		
		//查询货运单列表
		Map<String,String> maps = (Map)JSON.parse(paraStr); 
    	MultiValueMap<String, String> multiValueMap=new LinkedMultiValueMap<>();
    	if(maps!=null){
    		for (String key : maps.keySet()) { 
        		multiValueMap.add(key, maps.get(key));
        	}
    	}
    	JsonResult f = restTemplate.postForObject(UrlContants.IpTest+"provider/pInvoice/invoiceList",multiValueMap,JsonResult.class);
    	List<Map<String,Object>> invoceList=(List<Map<String, Object>>) f.getData();
    	
    	//导出文件头列表
    	List<String> titleList=new ArrayList<>();
    	titleList.add("货运单编号");
    	titleList.add("起始地");
    	titleList.add("目的地");
    	titleList.add("车辆数");
    	titleList.add("每辆运费");
    	titleList.add("已完成运单个数");
    	titleList.add("订单状态");
    	
    	List<Map<String, Object>> list=new ArrayList<>();
    	for(Map<String, Object> map : invoceList){
    		Map<String,Object> invoceMap=new HashMap<>();
    		for(String mapKey:map.keySet()){
    			if(mapKey.equals("invoiceNumber")){
    				invoceMap.put("货运单编号", map.get(mapKey));
    			}
    			if(mapKey.equals("startAddress")){
    				invoceMap.put("起始地", map.get(mapKey));
    			}
    			
    			if(mapKey.equals("arriveAddress")){
    				invoceMap.put("目的地", map.get(mapKey));
    			}
    			if(mapKey.equals("applyCarNo")){
    				invoceMap.put("车辆数", map.get(mapKey));
    			}
    			if(mapKey.equals("basicAmount")){
    				invoceMap.put("每辆运费", map.get(mapKey));
    			}
    			if(mapKey.equals("countWaybill")){
    				invoceMap.put("已完成运单个数", map.get(mapKey));
    			}
    			if(mapKey.equals("status")){
    				if((map.get(mapKey)+"").equals("1")){
    					invoceMap.put("订单状态", "未完成");
    				}
    				if((map.get(mapKey)+"").equals("2")){
    					invoceMap.put("订单状态", "完成");
    				}
    			}
    		}
    		list.add(invoceMap);
    	}
    	try {
			ExcelUtils.export("货运单列表", titleList, list);
			return JsonResult.success();
		} catch (Exception e) {
			e.printStackTrace();
			return JsonResult.error(207,"服务器错误");
		}
	}

	/**
	 * 查询运货中和已送达货运单数
	 * @param id
	 * @return
	 */
	public JsonResult selectPInvoiceNumByState(String id){
		MultiValueMap<String, String> requestEntity = new LinkedMultiValueMap<>();
		requestEntity.add("id", id);
		JsonResult jsonResult = restTemplate.postForObject( UrlContants.PLATFORM+"pInvoice/selectPInvoiceNumByState", requestEntity, JsonResult.class);
		return jsonResult;
	}

}
