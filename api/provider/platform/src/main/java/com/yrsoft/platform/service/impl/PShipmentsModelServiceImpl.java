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
import com.yrsoft.platform.entity.PShipmentsModel;
import com.yrsoft.platform.dao.PShipmentsModelDao;
import com.yrsoft.platform.service.PShipmentsModelService;



/**
 * 货运-货运模板 服务层实现
 * 
 * @author mz
 * @date 2019-02-23
 */
@Service
public class PShipmentsModelServiceImpl implements PShipmentsModelService
{
    @Autowired
    private PShipmentsModelDao pShipmentsModelDao;

	/**
     * 查询货运-货运模板信息
     * 
     * @param id 货运-货运模板ID
     * @return 货运-货运模板信息
     */
    @Override
	public JsonResult getPShipmentsModelById(String id)
	{
		PShipmentsModel pShipmentsModel = pShipmentsModelDao.selectPShipmentsModelById(id);
        if ( null == pShipmentsModel ) {
			return JsonResult.error(201,"暂无数据");
        }
	    return JsonResult.success(pShipmentsModel);
	}

    /**
     * 查询货运-货运模板列表
     * @param  page
     * @param  limit
     * @param pShipmentsModel 货运-货运模板信息
     * @return 货运-货运模板集合
     */
    @Override
    public JsonResult list(Integer page,Integer limit,PShipmentsModel pShipmentsModel)
    {
        //开启分页
        PageHelper.startPage(page,limit);

        //获取数据
        List<PShipmentsModel> lists =  pShipmentsModelDao.selectPShipmentsModelList(pShipmentsModel);
        if (null == lists || lists.isEmpty()){
            return JsonResult.error(201,"暂无数据");
        }

        PageInfo<PShipmentsModel> pageInfo = new PageInfo<>(lists);

        return JsonResult.createJsonResponse(pageInfo);
    }
	
    /**
     * 新增货运-货运模板
     * 
     * @param pShipmentsModel 货运-货运模板信息
     * @return 结果
     */
	@Override
	public JsonResult add(PShipmentsModel pShipmentsModel)
	{

        int result = pShipmentsModelDao.insertPShipmentsModel(pShipmentsModel);
        if (result == 0) {
            return JsonResult.error(201,"添加失败");
        }
        return JsonResult.success(200,"添加成功");
	}
	
	/**
     * 修改货运-货运模板
     * 
     * @param pShipmentsModel 货运-货运模板信息
     * @return 结果
     */
	@Override
	public JsonResult edit(PShipmentsModel pShipmentsModel)
	{
        int result = pShipmentsModelDao.updatePShipmentsModel(pShipmentsModel);
        if (result == 0) {
            return JsonResult.error(201,"更新失败");
        }
        return JsonResult.success(200,"更新成功");
	}

    /**
     * 删除货运-货运模板对象
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

        int result = pShipmentsModelDao.updatePShipmentsModelByIds(delete);
        if (result == 0) {
            return JsonResult.error(201,"删除失败");
        }
        return JsonResult.success(200,"删除成功");
    }

}
