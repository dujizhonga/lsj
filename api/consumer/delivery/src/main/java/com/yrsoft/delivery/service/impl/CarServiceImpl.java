package com.yrsoft.delivery.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.servicecomb.provider.springmvc.reference.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.yrsoft.common.constant.UrlContants;
import com.yrsoft.common.utils.JsonResult;
import com.yrsoft.delivery.dto.CarInfoDTO;
import com.yrsoft.delivery.dto.CarInfosDTO;
import com.yrsoft.delivery.dto.PcpCarDTO;
import com.yrsoft.delivery.dto.SysCarDTO;
import com.yrsoft.delivery.service.CarService;
import com.yrsoft.delivery.vo.CarInfosVO;
<<<<<<< HEAD
import com.yrsoft.delivery.vo.Inglat;
=======
>>>>>>> 0e530f1b3e4ace38205138e9c7b67488b23faa10
import com.yrsoft.delivery.vo.SysCarVO;
import com.yrsoft.delivery.vo.SystemCarVO;

import cn.hutool.json.JSONUtil;

/**
 * 查询所有自有车位置及基本信息
 * 
 * @author lu
 * @date 2019/2/25
 */
@Service
public class CarServiceImpl implements CarService {

	private static RestTemplate restTemplate = RestTemplateBuilder.create();


	/**
	 * 功能描述: 指定范围内系统车位置及基本信息
	 * 
	 * @param shipperId
	 * @param lat
	 * @param lnt
	 * @param distance
	 * @return
	 */
	@Override
	public JsonResult getSysCar(String shipperId) {

		MultiValueMap<String, String> requestEntity = new LinkedMultiValueMap<>();
		// shipperId:货主id
		if (null != shipperId) {
			requestEntity.add("shipperId", shipperId);
		}
		// 通过调用其他接口实现service
		// 查询该货主下的系统车辆信息
		String forObject = restTemplate.postForObject(UrlContants.AUTH + "car/selectSysCarInfo", requestEntity,
				String.class);
		SysCarDTO sysCarDTO = JSONUtil.toBean(forObject, SysCarDTO.class);
		if (sysCarDTO.getCode() != 200) {
			throw new RuntimeException(sysCarDTO.getMessage());
		}
		// 货主非关注的系统车
		List<SysCarVO> sysCar = sysCarDTO.getData();
		List<SystemCarVO> listCarInfo = new ArrayList<>();
		for (int i = 0; i < sysCar.size(); i++) {
			// 车辆ID
			String id = sysCar.get(i).getId();
			MultiValueMap<String, String> request = new LinkedMultiValueMap<>();
			request.add("id", id);
<<<<<<< HEAD
			String carObject = restTemplate.postForObject(UrlContants.POSITION + "poCarPosition/getPoCarPositionById",
					request, String.class);
			PcpCarDTO pcpCarDTO = JSONUtil.toBean(carObject, PcpCarDTO.class);
=======
			String carObject = restTemplate.postForObject(
			UrlContants.POSITION + "poCarPosition/getPoCarPositionById", request, String.class);
			PcpCarDTO pcpCarDTO = JSONUtil.toBean(carObject, PcpCarDTO.class);
			String lnglat = pcpCarDTO.getData().getLng() +","+ pcpCarDTO.getData().getLat();
>>>>>>> 0e530f1b3e4ace38205138e9c7b67488b23faa10
			String Style = "";
			if (null != sysCar.get(i).getRunStatus() && 0 == sysCar.get(i).getRunStatus()) {
				Style = "1";
			} else {
				Style = "0";
			}
			String name = "系统车";
			SystemCarVO sysc = new SystemCarVO();
<<<<<<< HEAD
			Inglat Lnglat = new Inglat();
			Lnglat.setLat(pcpCarDTO.getData().getLat());
			Lnglat.setLng(pcpCarDTO.getData().getLng());
			sysc.setId(id);
			sysc.setLnglat(Lnglat);
=======
			sysc.setId(id);
			sysc.setLnglat(lnglat);
>>>>>>> 0e530f1b3e4ace38205138e9c7b67488b23faa10
			sysc.setId(Style);
			sysc.setName(name);
			sysc.setCarNumber(sysCar.get(i).getCarNumber());
			listCarInfo.add(sysc);
		}
		return JsonResult.success(listCarInfo);
	}
	
	@Override
	public JsonResult selectCarByShipperId(Integer page,Integer limit,String shipperId) {
		
		List<CarInfosVO> carInfos=new ArrayList<>();
		CarInfosVO carInfosVO=new CarInfosVO();
		MultiValueMap<String, String> requestEntity = new LinkedMultiValueMap<>();
		requestEntity.add("shipperId", shipperId);
		requestEntity.set("page", String.valueOf(page));
		requestEntity.set("limit", String.valueOf(limit));
		String forObject = restTemplate.postForObject(UrlContants.AUTH +"car/selectCarsInfo", requestEntity,
				String.class);
		System.out.println(forObject);
		CarInfosDTO carInfosDTO = JSONUtil.toBean(forObject, CarInfosDTO.class);
		if (carInfosDTO.getCode() == 201) {
			return JsonResult.success(carInfosDTO.getMessage());
		} else if (carInfosDTO.getCode() == 200) {
			List<CarInfosVO> datas = carInfosDTO.getData();
			for (CarInfosVO car : datas) {
				carInfosVO.setId(car.getId());
				carInfosVO.setMemberId(car.getMemberId());
				carInfosVO.setDriver1Id(car.getDriver1Id());
				carInfosVO.setNickname(car.getNickname());
				carInfosVO.setTelephone(car.getTelephone());
				carInfosVO.setCarModel(car.getCarModel());
				carInfosVO.setCarNumber(car.getCarNumber());
				carInfosVO.setRunStatus(car.getRunStatus());
				carInfosVO.setTowWeight(car.getTowWeight());
				requestEntity.clear();
				requestEntity.add("id", car.getId());
				String str = restTemplate.postForObject(UrlContants.AUTH +"poCarPosition/getPoCarPositionById", requestEntity, String.class);
				CarInfoDTO carInfoDTO = JSONUtil.toBean(str, CarInfoDTO.class);
				if (carInfoDTO.getCode() == 201) {
					String lat="";
					String lng="";
					carInfosVO.setLat(lat);
					carInfosVO.setLng(lng);
					carInfos.add(carInfosVO);
				} else if (carInfoDTO.getCode() == 200) {
					CarInfosVO data = carInfoDTO.getData();
					
					carInfosVO.setLat(data.getLat());
					carInfosVO.setLng(data.getLng());
					carInfos.add(carInfosVO);
				}
			}
			datas.add(carInfosVO);
			System.out.println(carInfos);
			return JsonResult.success(datas);
		}
		return JsonResult.error(500, "系统 异常");

	}
}
