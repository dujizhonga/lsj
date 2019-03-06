package com.yrsoft.freight.service.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.servicecomb.provider.springmvc.reference.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSONObject;
import com.yrsoft.common.constant.UrlContants;
import com.yrsoft.common.utils.JsonResult;
import com.yrsoft.freight.entity.WayBill;
import com.yrsoft.freight.service.WayBillService;

/**
 *
 * 功能描述: 方法注释
 *
 * @param:
 * @return: 
 * @auther: Guohaolong
 * @date: 2019年2月25日 下午2:22:05
 */
@Service
public class WayBillServiceImpl implements WayBillService{
	
	private static RestTemplate restTemplate = RestTemplateBuilder.create();
	
	/**
     * 运单列表
     * @param page 当前页
     * @param limit 页大小
     * @param pInvoice 查询对象
     * @return json返回结果对象
     */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
    public JsonResult selectByPage(Integer page,Integer limit,WayBill wayBill){
		try {
			//包装查询运单表查询条件
	    	MultiValueMap<String, String> multiValueMap = new LinkedMultiValueMap<>();
	    	if(null != page ){
	    		multiValueMap.add("page", page+"");
	    	}
	    	if(null != limit){
	    		multiValueMap.add("limit", limit+"");
	    	}
	    	if(null != wayBill){
	    		multiValueMap.add("id",wayBill.getId() );
	    		multiValueMap.add("waybillNumber", wayBill.getWaybillNumber());
	    		multiValueMap.add("invoiceId", wayBill.getInvoiceId());
	    		multiValueMap.add("carId", wayBill.getCarId());
	    		multiValueMap.add("freightId", wayBill.getFreightId());
	    	}
	    	
//	    	/*************************测试代码****************************/
//	    	String fTest = restTemplate.postForObject(url+"provider/pWaybill/list",multiValueMap,String.class);
//	    	WayBillDTO sysCarDTO = JSONUtil.toBean(fTest, WayBillDTO.class);
//	    	System.out.println("*************************测试代码****************************");
//	    	System.out.println(sysCarDTO.getData().get(0).getPoundsImg1());
//	    	System.out.println(sysCarDTO.getData().get(0).getStar());
//	     	System.out.println("*************************测试代码****************************");
//	    	/*************************测试代码****************************/
//	    	
	    	
    	    //查询
    		JsonResult f = restTemplate.postForObject(UrlContants.PLATFORM+"pWaybill/list",multiValueMap,JsonResult.class);   	
   		    
    		if(f.getCode() != 200){
    			return JsonResult.error(207, "基础数据服务错误");
        	}
        	//取出转换数据为List<Map>类型       	
    		LinkedHashMap map = (LinkedHashMap) f.getData();   	        	
			List<LinkedHashMap<String, Object>> realData =  (ArrayList<LinkedHashMap<String,Object>>) map.get("list");       	
        	
			List<LinkedHashMap<String, Object>> dataList = new ArrayList<LinkedHashMap<String, Object>>();
        	
        	for(int i=0;i<realData.size();i++){
//        		//将map转为VO对象
//        		ObjectMapper mapper = new ObjectMapper();
//        		WayBillVO wV = (WayBillVO) mapper.convertValue(realData.get(i), WayBillVO.class);
        		LinkedHashMap<String, Object> dataMap = realData.get(i);
        		
        		//查询车牌及车主名称
        		LinkedHashMap<String, Object> waybillMap = this.searchPar( dataMap);
    	        if(null != waybillMap.get("returnStatus")){
    	        	return JsonResult.error(207, "基础数据服务错误");
    	        }
    	        
    	        //将dataMap放入返回List中
        		dataList.add(i, waybillMap);
        	}
        	//return处理结果
    		return f.setData(dataList); 
		} catch (RestClientException e) {
			return JsonResult.error(500, "服务器错误");
		} catch (Exception e) {			
			e.printStackTrace();
			return JsonResult.error(500, "服务器错误");
		}
			
    }
    
	/**
     * 运单详情
     * @param page 当前页
     * @param limit 页大小
     * @param id 查询id
     * @return json返回结果对象
     */
	@Override
	public JsonResult queryById(String paramStr) {
		
		MultiValueMap<String, String> multiValueMap = new LinkedMultiValueMap<>();
		//把参数转换成json对象
//		JSONObject jsonObject = JSONObject.parseObject(paramStr);								
		//封装请求参数
//		if(null != jsonObject && null != jsonObject.get("id")){
//			multiValueMap.add("id", jsonObject.get("id").toString());
//		}else {
//			return JsonResult.error(207, "请上传id");
//		}
				
		multiValueMap.add("id", "1"); 	
    	    	
    	JsonResult f = restTemplate.postForObject(UrlContants.PLATFORM+"pWaybill/getPWaybillById",multiValueMap,JsonResult.class);
        
    	if(f.getCode() != 200){
			return JsonResult.error(207, "基础数据服务错误");
    	}
    	//取出转换数据为List<Map>类型       	
		@SuppressWarnings("unchecked")
		LinkedHashMap<String, Object> tempMap = (LinkedHashMap<String, Object>) f.getData();   	        	
	       		
    	//查询车牌及车主名称
		LinkedHashMap<String, Object> waybillMap = this.searchPar(tempMap);
        if(null != waybillMap.get("returnStatus")){
        	return JsonResult.error(207, "基础数据服务错误");
        }       
        
        //查询货运单信息
        MultiValueMap<String, String> invoiceCondition = new LinkedMultiValueMap<>();
							
		//封装请求参数
        invoiceCondition.add("id", waybillMap.get("invoiceId").toString());		
		//通过调用其他接口实现service    	
        
        JsonResult  invoiceInfo = restTemplate.postForObject(UrlContants.PLATFORM+"pInvoice/getPInvoiceById",invoiceCondition,JsonResult.class);
		
		if(invoiceInfo.getCode() != 200){
			return JsonResult.error(207, "基础数据服务错误");
		}
		
		//包装返回数据
		LinkedHashMap<String, Object> dataMap = new LinkedHashMap<String, Object>();
		dataMap.put("invoice", invoiceInfo.getData());
		dataMap.put("waybill", waybillMap);
		
    	return f.setData(dataMap);
	}
	
	@SuppressWarnings({"unchecked" })
	public LinkedHashMap<String, Object> searchPar(LinkedHashMap<String,Object> dataMap){
		
		MultiValueMap<String, String> carCondition = new LinkedMultiValueMap<>();  	    	
    	carCondition.add("id", dataMap.get("carId").toString());
    	//查询车辆信息
		JsonResult carInfo = restTemplate.postForObject(UrlContants.AUTH+"car/getCarById",carCondition,JsonResult.class);
		
		if(carInfo.getCode() != 200){
            dataMap.put("returnStatus", "车辆查询出错");			
		}
		//获取车辆信息map
		LinkedHashMap<String, Object> carMap = (LinkedHashMap<String, Object>) carInfo.getData();
		//返回数据中添加车辆牌照、车主id
		dataMap.put("carNumber", carMap.get("carNumber"));
		dataMap.put("memberId",carMap.get("memberId"));
//		       		
//		WayBillVO wayBillVO = new WayBillVO();
//		Car car = (Car) carInfo.getData();
//		wayBillVO.setCarNum(car.getCarNumber());
//		wayBillVO.setOwnerName(car.getOwnerName());
		
		//包装查询车主表查询条件
    	MultiValueMap<String, String> ownerCondition = new LinkedMultiValueMap<>(); 
    	ownerCondition.add("id", carMap.get("memberId").toString());
    	
		JsonResult  ownerInfo = restTemplate.postForObject(UrlContants.PLATFORM+"mMember/getMMemberById",ownerCondition,JsonResult.class);
		
		if(ownerInfo.getCode() != 200){
			dataMap.put("returnStatus", "车主查询出错");
		}
		//获取车主信息map
		LinkedHashMap<String, Object> ownerMap = (LinkedHashMap<String, Object>) ownerInfo.getData();
		//返回数据中添加车主名称
		dataMap.put("ownerName", ownerMap.get("realName"));	
		
		return dataMap;
	}
	
	
}
