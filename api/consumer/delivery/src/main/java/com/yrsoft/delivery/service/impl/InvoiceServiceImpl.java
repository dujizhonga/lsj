package com.yrsoft.delivery.service.impl;
import java.text.DecimalFormat;
import java.util.List;

import org.apache.servicecomb.provider.springmvc.reference.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSONObject;
import com.yrsoft.common.constant.UrlContants;
import com.yrsoft.common.exception.LSJExceptions;
import com.yrsoft.common.utils.DateUtils;
import com.yrsoft.common.utils.GpsUtil;
import com.yrsoft.common.utils.JsonResult;
import com.yrsoft.common.utils.ParamVC;
import com.yrsoft.common.utils.StringUtils;
import com.yrsoft.delivery.dto.InvoiceAddressDTO;
import com.yrsoft.delivery.dto.ShippingsAddressDTO;
import com.yrsoft.delivery.entity.ShippingAddress;
import com.yrsoft.delivery.service.InvoiceService;
import com.yrsoft.delivery.vo.InvoiceAddressVO;

import cn.hutool.json.JSONUtil;

@Service
public class InvoiceServiceImpl implements InvoiceService {
	
	private static RestTemplate restTemplate = RestTemplateBuilder.create();
	@Override
	public JsonResult saveInvoice(String  paramStr) {
    	JSONObject jsonObject = JSONObject.parseObject(paramStr);
    	//参数验证
    	if(jsonObject.get("shipperId")==null || jsonObject.get("shipperId").equals("")){
    		return JsonResult.error(201, "请输入货主编号");
    	}
    	if(jsonObject.get("cargoNameId")==null || jsonObject.get("cargoNameId").equals("")){
    		return JsonResult.error(201, "请输入货物ID");
    	}
    	if(jsonObject.get("startProvince")==null || jsonObject.get("startProvince").equals("")){
    		return JsonResult.error(201, "请输入起始省");
    	}
    	if(jsonObject.get("startCity")==null || jsonObject.get("startCity").equals("")){
    		return JsonResult.error(201, "请输入起始市");
    	}
    	if(jsonObject.get("startArea")==null || jsonObject.get("startArea").equals("")){
    		return JsonResult.error(201, "请输入起始区");
    	}
    	if(jsonObject.get("startAddress")==null || jsonObject.get("startAddress").equals("")){
    		return JsonResult.error(201, "请输入起始地详细地址");
    	}
    	if(jsonObject.get("startLng")==null || jsonObject.get("startLng").equals("")){
    		return JsonResult.error(201, "请输入发货地经度");
    	}
    	if(jsonObject.get("startLat")==null || jsonObject.get("startLat").equals("")){
    		return JsonResult.error(201, "请输入发货地纬度");
    	}
    	if(jsonObject.get("arriveProvince")==null || jsonObject.get("arriveProvince").equals("")){
    		return JsonResult.error(201, "请输入目的省");
    	}
    	if(jsonObject.get("arriveCity")==null || jsonObject.get("arriveCity").equals("")){
    		return JsonResult.error(201, "请输入目的市");
    	}
    	if(jsonObject.get("arriveArea")==null || jsonObject.get("arriveArea").equals("")){
    		return JsonResult.error(201, "请输入目的区");
    	}
    	if(jsonObject.get("arriveAddress")==null || jsonObject.get("arriveAddress").equals("")){
    		return JsonResult.error(201, "请输入目的地详细地址");
    	}
    	if(jsonObject.get("arriveLng")==null || jsonObject.get("arriveLng").equals("")){
    		return JsonResult.error(201, "请输入目的地经度");
    	}
    	if(jsonObject.get("arriveLat")==null || jsonObject.get("arriveLat").equals("")){
    		return JsonResult.error(201, "请输入目的地纬度");
    	}
    	if(jsonObject.get("receiveUserName")==null || jsonObject.get("receiveUserName").equals("")){
    		return JsonResult.error(201, "请输入收货人姓名");
    	}
    	if(jsonObject.get("receiveUserTelephone")==null || jsonObject.get("receiveUserTelephone").equals("")){
    		return JsonResult.error(201, "请输入收货人电话");
    	}
    	if(jsonObject.get("goodsName")==null || jsonObject.get("goodsName").equals("")){
    		return JsonResult.error(201, "请输入货品名称");
    	}
    	if(jsonObject.get("goodsWeight")==null || jsonObject.get("goodsWeight").equals("")){
    		return JsonResult.error(201, "请输入货物重量");
    	}
    	if(jsonObject.get("goodsVolume")==null || jsonObject.get("goodsVolume").equals("")){
    		return JsonResult.error(201, "请输入体积");
    	}
    	if(jsonObject.get("basicAmount")==null || jsonObject.get("basicAmount").equals("")){
    		return JsonResult.error(201, "请输入单车运费");
    	}
    	if(jsonObject.get("insureAmount")==null || jsonObject.get("insureAmount").equals("")){
    		return JsonResult.error(201, "请输入单车保险费用");
    	}
    	
		MultiValueMap<String, Object> requestEntity = new LinkedMultiValueMap<>();
		//生成ID
		String id=StringUtils.getUUID();
		requestEntity.add("id", id);
		requestEntity.add("shipperId", jsonObject.get("shipperId").toString());
		requestEntity.add("cargoNameId",jsonObject.get("cargoNameId").toString());
		//生成货运单编号 
		requestEntity.add("invoiceNumber", StringUtils.getUUID());
		//发货信息
		requestEntity.add("startProvince", jsonObject.get("startProvince").toString());
		requestEntity.add("startCity", jsonObject.get("startCity").toString());
		requestEntity.add("startArea", jsonObject.get("startArea").toString());
		requestEntity.add("startAddress", jsonObject.get("startAddress").toString());
		requestEntity.add("startLng", jsonObject.get("startLng").toString());
		requestEntity.add("startLat", jsonObject.get("startLat").toString());
		//收货信息
		requestEntity.add("arriveProvince", jsonObject.get("arriveProvince").toString());
		requestEntity.add("arriveCity", jsonObject.get("arriveCity").toString());
		requestEntity.add("arriveArea", jsonObject.get("arriveArea").toString());
		requestEntity.add("arriveAddress", jsonObject.get("arriveAddress").toString());
		requestEntity.add("arriveLng", jsonObject.get("arriveLng").toString());
		requestEntity.add("arriveLat", jsonObject.get("arriveLat").toString());
		
		requestEntity.add("receiveUserName",jsonObject.get("receiveUserName").toString());
		requestEntity.add("receiveUserTelephone", jsonObject.get("receiveUserTelephone").toString());
		requestEntity.add("goodsName", jsonObject.get("goodsName").toString());
		requestEntity.add("goodsWeight", jsonObject.get("goodsWeight").toString());
		requestEntity.add("goodsVolume", jsonObject.get("goodsVolume").toString());
		//单车运费
		requestEntity.add("basicAmount", jsonObject.get("basicAmount").toString());
		//单车保险费用
		requestEntity.add("insureAmount", jsonObject.get("insureAmount").toString());
		//总运费
		requestEntity.add("basicAmountTotal", jsonObject.get("basicAmount").toString());
		//总保险费用
		requestEntity.add("insureAmountTotal", jsonObject.get("insureAmount").toString());
		//createTime 创建时间,
		requestEntity.add("createTime", DateUtils.getTimeMillis().toString());
		
        //单车运费
        long basicAmount = Long.parseLong(jsonObject.get("basicAmount").toString());
        //起始地经纬度
        double startLat = Double.parseDouble(jsonObject.get("startLng").toString());
        double startLng = Double.parseDouble(jsonObject.get("startLat").toString());
        //目的地经纬度
        double arriveLat = Double.parseDouble(jsonObject.get("arriveLng").toString());
        double arriveLnt = Double.parseDouble(jsonObject.get("arriveLat").toString());
        //计算两点间距离
       
		double distance1 = GpsUtil.getDistanceOfMeter(startLat, startLng, arriveLat, arriveLnt);
		//添加路线距离公里数
		DecimalFormat df = new DecimalFormat("0.000000");
	    String distance= df.format(distance1);
	    System.out.println(distance1);
		requestEntity.add("routeRange", distance);
		//计算单车保证金
		if(distance1 <=100) {
			requestEntity.add("marginAmount", "100");
		}else if(basicAmount * 0.01 <= 200) {
			requestEntity.add("marginAmount", "200");
		}else if(basicAmount * 0.01 > 200) {
			requestEntity.add("marginAmount", String.valueOf(Math.round(basicAmount * 0.01)));
		}
		
		JsonResult js = restTemplate.postForObject(UrlContants.PLATFORM+"pInvoice/add", requestEntity, JsonResult.class);
		if (js.getCode() != 200) {
            throw new LSJExceptions(js.getCode(), js.getMessage());
        }
		if(js.getCode() == 200) {
			return JsonResult.createResponse(js.getCode(), js.getMessage(), id);
		}
		return null;
	}
	/**
     * 查询货运单的默认地址
     *
     * @param address
     * @return
     */
	@Override
	public JsonResult selectInvoiceAddress(String shipperId) {
		
		MultiValueMap<String, String> requestEntity = new LinkedMultiValueMap<>();
        requestEntity.add("shipperId",  shipperId);
        //查询已完成运单的货单的最新地址
       String forObject = restTemplate.postForObject(UrlContants.PLATFORM+"pInvoice/selectInvoiceAddress", requestEntity, String.class);
        InvoiceAddressDTO inDTO = JSONUtil.toBean(forObject, InvoiceAddressDTO.class);
        
        //判断是否完成运单
        if (inDTO.getCode() == 200 ) {
            if(inDTO.getData()!=null) {
            	InvoiceAddressVO vo=inDTO.getData();
            	return JsonResult.success(vo);
            }else if(inDTO.getData()==null) {
            	//查询货主地址
            	String str = restTemplate.postForObject(UrlContants.PLATFORM+"pShippingAddress/selectAddressNew", requestEntity, String.class);
            	ShippingsAddressDTO saDTO = JSONUtil.toBean(str, ShippingsAddressDTO.class);
            	InvoiceAddressVO vo=new InvoiceAddressVO();
                if (saDTO.getCode() == 200 && saDTO.getData()==null ) {
                	return JsonResult.success(200, saDTO.getMessage());
                }
                if (saDTO.getCode() != 200) {
                    throw new RuntimeException(saDTO.getMessage());
                }
                List<ShippingAddress>  data = saDTO.getData();
                for (ShippingAddress s : data) {
                	
					vo.setId(s.getId());
					vo.setShipperId(shipperId);
					if(s.getAddressType()==0) {
						vo.setStartProvince(s.getProvince());
		            	vo.setStartCity(s.getCity());
		            	vo.setStartArea(s.getArea());
		            	vo.setStartLat(s.getLat());
		            	vo.setStartLng(s.getLng());
		            	vo.setStartAddress(s.getAddress());
                	}
					if(s.getAddressType()==1) {
						vo.setArriveProvince(s.getProvince());
		            	vo.setArriveCity(s.getCity());
		            	vo.setArriveArea(s.getArea());
		            	vo.setArriveLat(s.getLat());
		            	vo.setArriveLng(s.getLng());
		            	vo.setArriveAddress(s.getAddress());
		            	vo.setReceiveUserName(s.getName());
		            	vo.setReceiveUserTelephone(s.getPhone());
                	}
				}
                
                return JsonResult.success(vo);
            }
        }
        if (inDTO.getCode() != 200) {
            throw new RuntimeException(inDTO.getMessage());
        }
		return null;
	}
	
	/**
     * 查询货运单详情
     * @param id :货运单id
     * @return
     */
	@Override
	public JsonResult selectInvoiceInfo(String paramStr) {
		 //参数验证
        ParamVC pvc = ParamVC.jsonValidateAndConvert(paramStr,"id");
        if(!pvc.isLegal()){
            return JsonResult.error(201,pvc.getMessage());
        }
        String id=pvc.getKey("id");
        MultiValueMap<String, String> requestEntity = new LinkedMultiValueMap<>();
	    requestEntity.add("id", id);
		 //通过调用其他接口实现service
		JsonResult invoiceInfo = restTemplate.postForObject(UrlContants.PLATFORM+"pInvoice/getPInvoiceById",requestEntity,JsonResult.class);
		return invoiceInfo;
	}
}
