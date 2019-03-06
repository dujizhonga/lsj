package com.yrsoft.platform.service.impl;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

import com.yrsoft.common.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yrsoft.common.support.Convert;
import com.yrsoft.platform.entity.PWaybill;
import com.yrsoft.platform.entity.PWaybillVo;
import com.yrsoft.platform.dao.PWaybillDao;
import com.yrsoft.platform.service.PWaybillService;



/**
 * 货运-运单 服务层实现
 * 
 * @author mz
 * @date 2019-02-23
 */
@Service
public class PWaybillServiceImpl implements PWaybillService
{
    @Autowired
    private PWaybillDao pWaybillDao;

	/**
     * 查询货运-运单信息
     * 
     * @param id 货运-运单ID
     * @return 货运-运单信息
     */
    @Override
	public JsonResult getPWaybillById(String id)
	{
		PWaybill pWaybill = pWaybillDao.selectPWaybillById(id);
        if ( null == pWaybill ) {
			return JsonResult.error(201,"暂无数据");
        }
	    return JsonResult.success(pWaybill);
	}

    /**
     * 查询货运-运单列表
     * @param  page
     * @param  limit
     * @param pWaybill 货运-运单信息
     * @return 货运-运单集合
     */
    @Override
    public JsonResult list(Integer page,Integer limit,PWaybill pWaybill)
    {
        //开启分页
        PageHelper.startPage(page,limit);

        //获取数据
        List<PWaybill> lists =  pWaybillDao.selectPWaybillList(pWaybill);
        if (null == lists || lists.isEmpty()){
            return JsonResult.error(201,"暂无数据");
        }

        PageInfo<PWaybill> pageInfo = new PageInfo<>(lists);

        return JsonResult.createJsonResponse(pageInfo);
    }
	
    /**
     * 查寻货运-查寻货运的运单信息，不分页查寻
     * @param pWaybill
     * @return
     * @author:DU'JZ
     * @data:2019年2月25日 下午2:35:02 
     * @throws
     */
    @Override
    public JsonResult listByInvoiceId(PWaybill pWaybill) {
        //获取数据
        List<PWaybill> lists =  pWaybillDao.selectPWaybillList(pWaybill);
        if (null == lists || lists.isEmpty()){
            return JsonResult.error(201,"暂无数据");
        }
        return JsonResult.createJsonResponse(lists);
	}
    
    @Override
    public JsonResult listByInvoiceIds(Integer page,Integer limit,String shipperId,String ownerId,String waybillNumber,
    		String startTime,String endTime,String waybillState
			,String flag) {
    	//开启分页
        PageHelper.startPage(page,limit);
        
    	Map<String,Object> map = new HashMap<>();
    	map.put("shipperId", shipperId);
    	map.put("ownerId", ownerId);
    	map.put("waybillNumber", waybillNumber);
    	map.put("startTime", startTime);
    	map.put("endTime", endTime);
    	map.put("waybillState", waybillState);
    	map.put("flag", flag);
        //获取数据
        List<PWaybillVo> lists =  pWaybillDao.listByInvoiceIds(map);
        if (null == lists || lists.isEmpty()){
            return JsonResult.error(201,"暂无数据");
        }
        PageInfo<PWaybillVo> pageInfo = new PageInfo<>(lists);

        return JsonResult.createJsonResponse(pageInfo);
	}
    /**
     * 新增货运-运单
     * 
     * @param pWaybill 货运-运单信息
     * @return 结果
     */
	@Override
	public JsonResult add(PWaybill pWaybill)
	{

        int result = pWaybillDao.insertPWaybill(pWaybill);
        if (result == 0) {
            return JsonResult.error(201,"添加失败");
        }
        return JsonResult.success(200,"添加成功");
	}
	
	/**
     * 修改货运-运单
     * 
     * @param pWaybill 货运-运单信息
     * @return 结果
     */
	@Override
	public JsonResult edit(PWaybill pWaybill)
	{
        int result = pWaybillDao.updatePWaybill(pWaybill);
        if (result == 0) {
            return JsonResult.error(201,"更新失败");
        }
        return JsonResult.success(200,"更新成功");
	}

	
	/**
     * 修改货运-运单
     * shihh
     * @param pWaybillVo 货运-运单信息
     * @return 结果
     */
	@Override
	public JsonResult upPWaybill(PWaybillVo pWaybillVo)
	{
        int result = pWaybillDao.upPWaybill(pWaybillVo);
        if (result == 0) {
            return JsonResult.error(201,"更新失败");
        }
        return JsonResult.success(200,"更新成功");
	}

    /**
     * 删除货运-运单对象
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
        delete.put("ids",Convert.toStrArray(ids));

        int result = pWaybillDao.updatePWaybillByIds(delete);
        if (result == 0) {
            return JsonResult.error(201,"删除失败");
        }
        return JsonResult.success(200,"删除成功");
    }

    @Override
    public List<PWaybill> getByIds(List<String> list) {
        return pWaybillDao.getByIds(list);
    }
   /**
    * 据货主id查询名下所有运单
    */
	/*@Override
	public JsonResult listByShipperId(Integer page, Integer limit, String shipperId) {
		 {
		        //开启分页
		        PageHelper.startPage(page,limit);
		        //获取数据
		        List<PWaybill> lists =  pWaybillDao.listByShipperId(shipperId);
		        if (null == lists || lists.isEmpty()){
		            return JsonResult.error(201,"暂无数据");
		        }
		        PageInfo<PWaybill> pageInfo = new PageInfo<>(lists);
		        return JsonResult.createJsonResponse(pageInfo);
		    }
	}*/

	@Override
	public JsonResult getWaybillById(String id) {
		{
			PWaybill pWaybill = pWaybillDao.selectWaybillById(id);
	        if ( null == pWaybill ) {
				return JsonResult.error(201,"暂无数据");
	        }
		    return JsonResult.success(pWaybill);
		}
	}

	@Override
	public JsonResult updateByIds(Map<String, Object> paramMap) {
		int row = pWaybillDao.updatePWaybillByIds(paramMap);
		if (row == 0) {
            return JsonResult.error(201,"更新失败");
        }
        return JsonResult.success(200,"更新成功");
	}

	@Override
	public JsonResult selectTruckBrokerData(String waybillId) {
		Map<String,Object> result = pWaybillDao.selectTruckBrokerData(waybillId);
		return JsonResult.createResponse(200, "查询成功", result);
	}

	@Override
	public JsonResult selectListCount(PWaybill pWaybill) {

		Map<String,Object> result  = new HashMap<String,Object>();
		result.put("count", pWaybillDao.selectListCount(pWaybill));
		return JsonResult.createResponse(200, "查询成功", result);
	}

    /**
     * 将运单标记为已投保
     * @param id
     * @return
     */
    public JsonResult updateInsuranceSendStateById(String id){
        int i = pWaybillDao.updateInsuranceSendStateById(id);
        if(i==0){
            return JsonResult.error(201,"修改失败");
        }else{
            return JsonResult.success(200,"修改成功");
        }
    }

}
