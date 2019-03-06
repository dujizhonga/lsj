package com.yrsoft.auth.service.impl;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

import com.yrsoft.common.support.Convert;
import com.yrsoft.common.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yrsoft.auth.entity.Car;
import com.yrsoft.auth.entity.CarP;
import com.yrsoft.auth.dao.CarDao;
import com.yrsoft.auth.service.CarService;



/**
 * 认证管理-车辆认证 服务层实现
 * 
 * @author mz
 * @date 2019-02-23
 */
@Service
public class CarServiceImpl implements CarService
{
    @Autowired
    private CarDao carDao;

	/**
     * 查询认证管理-车辆认证信息
     * 
     * @param id 认证管理-车辆认证ID
     * @return 认证管理-车辆认证信息
     */
    @Override
	public JsonResult getCarById(String id)
	{
		Car car = carDao.selectCarById(id);
        if ( null == car ) {
			return JsonResult.error(201,"暂无数据");
        }
	    return JsonResult.success(car);
	}

    /**
     * 查询认证管理-车辆认证列表
     * @param  page
     * @param  limit
     * @param car 认证管理-车辆认证信息
     * @return 认证管理-车辆认证集合
     */
    @Override
    public JsonResult list(Integer page,Integer limit,Car car)
    {
        //开启分页
        PageHelper.startPage(page,limit);

        //获取数据
        List<Car> lists =  carDao.selectCarList(car);
        if (null == lists || lists.isEmpty()){
            return JsonResult.error(201,"暂无数据");
        }

        PageInfo<Car> pageInfo = new PageInfo<>(lists);

        return JsonResult.createJsonResponse(pageInfo);
    }
	
    /**
     * 新增认证管理-车辆认证
     * 
     * @param car 认证管理-车辆认证信息
     * @return 结果
     */
	@Override
	public JsonResult add(Car car)
	{

        int result = carDao.insertCar(car);
        if (result == 0) {
            return JsonResult.error(201,"添加失败");
        }
        return JsonResult.success(200,"添加成功");
	}
	
	/**
     * 修改认证管理-车辆认证
     * 
     * @param car 认证管理-车辆认证信息
     * @return 结果
     */
	@Override
	public JsonResult edit(Car car)
	{
        int result = carDao.updateCar(car);
        if (result == 0) {
            return JsonResult.error(201,"更新失败");
        }
        return JsonResult.success(200,"更新成功");
	}

    /**
     * 删除认证管理-车辆认证对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public JsonResult remove(String ids)
    {
        Map<String,Object> delete = new HashMap<>();
        //数据库删除字段必须为delFlag
        delete.put("delFlag",1);
        delete.put("ids", Convert.toStrArray(ids));

        int result = carDao.updateCarByIds(delete);
        if (result == 0) {
            return JsonResult.error(201,"删除失败");
        }
        return JsonResult.success(200,"删除成功");
    }
	@Override
	public JsonResult getCarByIds(String id) {
		CarP car = carDao.selectCarByIds(id);
        if ( null == car ) {
			return JsonResult.error(201,"暂无数据");
        }
	    return JsonResult.success(car);
	}

	@Override
	public JsonResult selectCarByOwnerId(Integer page,Integer limit,String ownerId,String telephone,String ownerName,String carNumber) {
		//开启分页
        PageHelper.startPage(page,limit);
		Map<String,Object> param = new HashMap<>();
	     //车主id
		 param.put("page", page);
		 param.put("limit", limit);
		 param.put("ownerId", ownerId);
		 param.put("telephone", telephone);
		 param.put("ownerName", ownerName);
		 param.put("carNumber", carNumber);
		List<CarP> car = carDao.selectCarByOwnerId(param);
        if ( null == car ) {
			return JsonResult.error(201,"暂无数据");
        }
        PageInfo<CarP> pageInfo = new PageInfo<>(car);

        return JsonResult.createJsonResponse(pageInfo);
	}
	@Override
	public JsonResult selectSysCarInfo(String shipperId) {
        Map<String,Object> shipperIdMap = new HashMap<>();
        //货主id
        shipperIdMap.put("shipperId", shipperId);

        List<Car>  result = carDao.selectSysCarInfo(shipperIdMap);
        if (result.size() < 0) {
            return JsonResult.error(201,"查询失败");
        }
        return JsonResult.success(result);
    }
	/**
     * 通过货主id（或车牌号）查询车辆信息
     *
     * @param param
     * @return 结果
     */
    @Override
    public JsonResult selectCarsInfo(Integer page,Integer limit,String shipperId,String carNumber)
    {
    	 //开启分页
        PageHelper.startPage(page,limit);
        Map<String,Object> map = new HashMap<>();
        //货主id
        map.put("shipperId", shipperId);
        map.put("carNumber", carNumber);
        map.put("page", page);
        map.put("limit", limit);
        List<Car>  result = carDao.selectCarsInfo(map);
        if (result.size() == 0) {
            return JsonResult.error(201,"暂无数据");
        }
        if (result.size() < 0) {
            return JsonResult.error(201,"查询失败");
        }
        PageInfo<Car> pageInfo = new PageInfo<>(result);
        return JsonResult.createJsonResponse(pageInfo);
    }
    /**
     * 通过货主id查询车辆信息及位置
     *
     * @param param
     * @return 结果
     */
    @Override
    public JsonResult selectCarsInfo(String shipperId)
    {
        Map<String,Object> shipperIdMap = new HashMap<>();
        //货主id
        shipperIdMap.put("shipperId", shipperId);
        

        List<Car>  result = carDao.selectCarsInfo(shipperIdMap);
        if (result.size() == 0) {
            return JsonResult.error(201,"暂无数据");
        }
        if (result.size() < 0) {
            return JsonResult.error(201,"查询失败");
        }
        return JsonResult.success(result);
    }
}
