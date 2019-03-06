package com.yrsoft.delivery.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.servicecomb.provider.springmvc.reference.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.deser.std.DateDeserializers;
import com.github.pagehelper.PageInfo;
import com.yrsoft.common.constant.UrlContants;
import com.yrsoft.common.utils.JsonResult;
import com.yrsoft.common.utils.StringUtils;
import com.yrsoft.delivery.dto.CarDTO;
import com.yrsoft.delivery.dto.OwnerInfoDTO;
import com.yrsoft.delivery.dto.OwnerInfosDTO;
import com.yrsoft.delivery.dto.WaybillCarDTO;
import com.yrsoft.delivery.dto.WaybillDTO;
import com.yrsoft.delivery.entity.Car;
import com.yrsoft.delivery.entity.PWaybill;
import com.yrsoft.delivery.service.OwnerInfoService;
import com.yrsoft.delivery.vo.CarInfoVO;
import com.yrsoft.delivery.vo.OwnerInfoListVO;
import com.yrsoft.delivery.vo.OwnerInfoVO;

import cn.hutool.json.JSONUtil;

/**
 * 车主信息详情查询接口
 * 
 * @author lu
 * @date 2019/2/26
 */
@Service
public class OwnerInfoServiceImpl implements OwnerInfoService {
	private static final RestTemplate restTemplate = RestTemplateBuilder.create();

	/**
	 *
	 * 功能描述: 车主信息详情查询接口
	 *
	 * @param: shipperId:货主id
	 *             必填 ownerId:车主id 必填 type:查询类型：0：货主下的车主的运单信息 1：货主下的车主的车辆信息 必填
	 *             waybillNumber：运单编号 ownerName:车主名称 telephone:车主电话
	 *             startTime:起始时间 endTime:结束时间 waybillState:运单状态: 0-未发货 1-已发货
	 *             2-已送达 3-已收货 4-已撤销 flag:运单类型 （0.指派单 1.系统单 ） carNumber:车牌号码
	 * @return:
	 * @auther: lu
	 * @date: 2019/2/26
	 */
	@Override
	public JsonResult getOwnerInfo(String paramStr) {

		JSONObject jsonObject = JSONObject.parseObject(paramStr);
		// page:页数 必填
		if (jsonObject.get("page") == null || jsonObject.get("page").equals("")) {
			return JsonResult.error(201, "请输入页数");
		}

		// limit:条数 必填
		if (jsonObject.get("limit") == null || jsonObject.get("limit").equals("")) {
			return JsonResult.error(201, "请输入条数");
		}
		// shipperId:货主id
		if (jsonObject.get("shipperId") == null || jsonObject.get("shipperId").equals("")) {
			return JsonResult.error(201, "请输入货主编号");
		}

		// ownerId:车主id
		if (jsonObject.get("ownerId") == null || jsonObject.get("ownerId").equals("")) {
			return JsonResult.error(201, "请输入车主编号");
		}

		// type:查询类型：0：货主下的车主的运单信息 1：货主下的车主的车辆信息
		if (jsonObject.get("type") == null || jsonObject.get("type").equals("")) {
			return JsonResult.error(201, "请输入查询类型");
		}

		MultiValueMap<String, String> requestEntity = new LinkedMultiValueMap<>();
		requestEntity.add("shipperId", jsonObject.get("shipperId").toString());
		requestEntity.add("ownerId", jsonObject.get("ownerId").toString());
		requestEntity.add("page", jsonObject.get("page").toString());
		requestEntity.add("limit", jsonObject.get("limit").toString());
		// type:查询类型：0：货主下的车主的运单信息 1：货主下的车主的车辆信息
		if (Integer.valueOf(jsonObject.get("type").toString()) == 0) {

			// 返回的数据
			List<OwnerInfoVO> ownerInfos = new ArrayList<>();

			// waybillNumber：运单编号
			if (jsonObject.containsKey("waybillNumber")
					&& !StringUtils.isEmpty(jsonObject.get("waybillNumber").toString())) {
				requestEntity.add("waybillNumber", jsonObject.get("waybillNumber").toString());
			}
			// startTime:起始时间
			if (jsonObject.containsKey("startTime") && !StringUtils.isEmpty(jsonObject.get("startTime").toString())) {
				requestEntity.add("startTime", jsonObject.get("startTime").toString());
			}
			// endTime:结束时间
			if (jsonObject.containsKey("endTime") && !StringUtils.isEmpty(jsonObject.get("endTime").toString())) {
				requestEntity.add("endTime", jsonObject.get("endTime").toString());
			}
			// waybillState:运单状态: 0-未发货 1-已发货 2-已送达 3-已收货 4-已撤销
			if (jsonObject.containsKey("waybillState")
					&& !StringUtils.isEmpty(jsonObject.get("waybillState").toString())) {
				requestEntity.add("waybillState", jsonObject.get("waybillState").toString());
			}
			// flag:运单类型 （0.指派单 1.系统单 ）
			if (jsonObject.containsKey("flag") && !StringUtils.isEmpty(jsonObject.get("flag").toString())) {
				requestEntity.add("flag", jsonObject.get("flag").toString());
			}
			// 根据车主id查询该货主下的运单信息
			String waybillJson = restTemplate.postForObject(UrlContants.PLATFORM+"pWaybill/listByInvoiceIds",
					requestEntity, String.class);
			WaybillDTO waybillResult = JSONUtil.toBean(waybillJson, WaybillDTO.class);
			// 若等于201，则返回无数据
			if (waybillResult.getCode() == 201) {
				return JsonResult.success(null);
				// 若等于200,则返回数据
			} else if (waybillResult.getCode() == 200) {

				List<PWaybill> waybillList = WaybillDTO.getWaybill(waybillResult.getData());
				// 根据运单信息查询车辆信息
				for (int i = 0; i < waybillList.size(); i++) {
					OwnerInfoVO wnerInfo = new OwnerInfoVO();
					// 添加返回数据
					// 实际运费
					wnerInfo.setActualFreight(waybillList.get(i).getActualFreight().toString());
					// 运单类型
					wnerInfo.setFlag(waybillList.get(i).getFlag().toString());
					// 运单编号
					wnerInfo.setWaybillNumber(waybillList.get(i).getWaybillNumber());
					// 运单状态
					wnerInfo.setWaybillState(waybillList.get(i).getWaybillState().toString());

					// 根据车辆id查询车辆信息和车主信息
					MultiValueMap<String, String> carEntity = new LinkedMultiValueMap<>();
					String carIds = waybillList.get(i).getCarId();
					carEntity.add("id", carIds);
					String carJson = restTemplate.postForObject(UrlContants.AUTH+"car/getCarByIds",
							carEntity, String.class);
					WaybillCarDTO carResult = JSONUtil.toBean(carJson, WaybillCarDTO.class);
					if (carResult.getCode() == 201) {
						// 查询车牌号
						wnerInfo.setCarNumber("");
						// 车主名称
						wnerInfo.setOwnerName("");
						// 车主电话
						wnerInfo.setTelephone("");
					} else if (carResult.getCode() == 200) {
						// 查询车牌号
						wnerInfo.setCarNumber(carResult.getData().getCarNumber());
						// 车主名称
						wnerInfo.setOwnerName(carResult.getData().getOwnerName());
						// 车主电话
						wnerInfo.setTelephone(carResult.getData().getTelephone());
						ownerInfos.add(wnerInfo);
						PageInfo<OwnerInfoVO> pageInfo=WaybillDTO.getPage(waybillResult.getData());
						pageInfo.setList(ownerInfos);
						return JsonResult.createJsonResponse(pageInfo);
					}
					return JsonResult.error(500, "系统错误1");
				}
			}
			return JsonResult.error(500, "系统错误");
		}
		
		// type:查询类型：0：货主下的车主的运单信息 1：货主下的车主的车辆信息
		if (Integer.valueOf(jsonObject.get("type").toString()) == 1) {

			// 返回的数据
			List<CarInfoVO> carInfos = new ArrayList<>();
			// 搜索条件
			// ownerName:车主名称
			if (jsonObject.containsKey("ownerName") && !StringUtils.isEmpty(jsonObject.get("ownerName").toString())) {
				requestEntity.add("ownerName", jsonObject.get("ownerName").toString());
			}
			// telephone:车主电话
			if (jsonObject.containsKey("telephone") && !StringUtils.isEmpty(jsonObject.get("telephone").toString())) {
				requestEntity.add("telephone", jsonObject.get("telephone").toString());
			}
			// carNumber:车牌号码
			if (jsonObject.containsKey("carNumber") && !StringUtils.isEmpty(jsonObject.get("carNumber").toString())) {
				requestEntity.add("carNumber", jsonObject.get("carNumber").toString());
			}
			// 根据车主id查询车辆信息
			String ownerInfoJson = restTemplate.postForObject(UrlContants.AUTH+"car/selectCarByOwnerId",
					requestEntity, String.class);
			CarDTO carResult = JSONUtil.toBean(ownerInfoJson, CarDTO.class);
			if (carResult.getCode() == 201) {
				return JsonResult.success(null);
			} else if (carResult.getCode() == 200) {
				List<Car> carlList =CarDTO.getWaybill(carResult.getData());
				for (int i = 0; i < carlList.size(); i++) {
					CarInfoVO carInfo = new CarInfoVO();
					// 车牌号
					carInfo.setCarNumber(carlList.get(i).getCarNumber());
					// 车辆型号
					carInfo.setCarModel(carlList.get(i).getCarModel());
					// 车辆类型
					carInfo.setCarTypeName("0");
					// 车主名称
					carInfo.setNickname(carlList.get(i).getNickname());
					// 车主电话
					carInfo.setTelephone(carlList.get(i).getTelephone());
					// 车辆状态
					carInfo.setOpenStop(carlList.get(i).getOpenStop());
					carInfo.setMemberId(carlList.get(i).getMemberId());
					carInfo.setId(carlList.get(i).getId());
					carInfos.add(carInfo);
				}
				PageInfo<CarInfoVO> pageInfo=CarDTO.getPage(carResult.getData());
				pageInfo.setList(carInfos);
				
				return JsonResult.createJsonResponse(pageInfo);
			}
			return JsonResult.error(500, "系统异常！");
		}
		return JsonResult.error(201, "传入的查询类型错误！");
	}
	/**
     * 通过货主id查询关注车主信息列表
     *
     * @param shipperId 货主ID
     * @return 结果
     */
	@Override
	public JsonResult selectOwnerInfo(Integer page,Integer limit,String shipperId) {
		
		 MultiValueMap<String, String> requestEntity = new LinkedMultiValueMap<>();
	        requestEntity.add("shipperId", shipperId);
	        requestEntity.set("page", String.valueOf(page));
			requestEntity.set("limit", String.valueOf(limit));
	        //查询车主的基本信息
	        String forObject = restTemplate.postForObject(UrlContants.MEMBER+"boOwnerShipper/selectOwnerInfo", requestEntity, String.class);
	        OwnerInfosDTO ownerInfosDTO = JSONUtil.toBean(forObject, OwnerInfosDTO.class);
	        
	        System.out.println(ownerInfosDTO);
	        if (ownerInfosDTO.getCode() != 200) {
	            throw new RuntimeException(ownerInfosDTO.getMessage());
	        }
	      //返回车主信息集合
	        
	        List<OwnerInfoListVO> datas = ownerInfosDTO.getData();
	        //遍历车主查对应运单数量
	        for (OwnerInfoListVO owner : datas) {
	        	
	        	requestEntity.clear();
                requestEntity.add("ownerId",owner.getOwnerId());
                requestEntity.add("shipperId",owner.getShipperId());
                //查询该车主完成运单数
                String str = restTemplate.postForObject(UrlContants.PLATFORM+"pInvoice/selectWaybillCount", requestEntity, String.class);
                OwnerInfoDTO ownerInfoDTO = JSONUtil.toBean(str, OwnerInfoDTO.class);
                if(ownerInfoDTO.getCode() == 200) {
                	OwnerInfoListVO data = ownerInfoDTO.getData();
                	owner.setWaybillCount(data.getWaybillCount());
                }
                if(ownerInfoDTO.getCode() == 201 && ownerInfoDTO.getMessage().equals("暂无数据")) {
                	owner.setWaybillCount(0);
                }
                if (ownerInfoDTO.getCode() != 200) {
    	            throw new RuntimeException(ownerInfoDTO.getMessage());
    	        }
                ownerInfosDTO.setData(datas);
			}
	       
	        JsonResult result = new JsonResult();
	        //重新封装返回值
	        result.setCode(ownerInfosDTO.getCode());
	        result.setPageNum(ownerInfosDTO.getPageNum());
	        result.setData(datas);
	        result.setMessage(ownerInfosDTO.getMessage());
	        result.setPageSize(ownerInfosDTO.getPageSize());
	        result.setRowCount(ownerInfosDTO.getRowCount());
	        result.setTotalPage(ownerInfosDTO.getTotalPage());
	        return result;
					
	}
}
