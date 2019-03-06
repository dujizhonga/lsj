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
import com.yrsoft.platform.entity.PInsurance;
import com.yrsoft.platform.dao.PInsuranceDao;
import com.yrsoft.platform.service.PInsuranceService;



/**
 * 货运-保险费支付记录 服务层实现
 * 
 * @author mz
 * @date 2019-02-23
 */
@Service
public class PInsuranceServiceImpl implements PInsuranceService
{
    @Autowired
    private PInsuranceDao pInsuranceDao;

	/**
     * 查询货运-保险费支付记录信息
     * 
     * @param id 货运-保险费支付记录ID
     * @return 货运-保险费支付记录信息
     */
    @Override
	public JsonResult getPInsuranceById(String id)
	{
		PInsurance pInsurance = pInsuranceDao.selectPInsuranceById(id);
        if ( null == pInsurance ) {
			return JsonResult.error(201,"暂无数据");
        }
	    return JsonResult.success(pInsurance);
	}

    /**
     * 查询货运-保险费支付记录列表
     * @param  page
     * @param  limit
     * @param pInsurance 货运-保险费支付记录信息
     * @return 货运-保险费支付记录集合
     */
    @Override
    public JsonResult list(Integer page,Integer limit,PInsurance pInsurance)
    {
        //开启分页
        PageHelper.startPage(page,limit);

        //获取数据
        List<PInsurance> lists =  pInsuranceDao.selectPInsuranceList(pInsurance);
        if (null == lists || lists.isEmpty()){
            return JsonResult.error(201,"暂无数据");
        }

        PageInfo<PInsurance> pageInfo = new PageInfo<>(lists);

        return JsonResult.createJsonResponse(pageInfo);
    }
	
    /**
     * 新增货运-保险费支付记录
     * 
     * @param pInsurance 货运-保险费支付记录信息
     * @return 结果
     */
	@Override
	public JsonResult add(PInsurance pInsurance)
	{

        int result = pInsuranceDao.insertPInsurance(pInsurance);
        if (result == 0) {
            return JsonResult.error(201,"添加失败");
        }
        return JsonResult.success(200,"添加成功");
	}
	
	/**
     * 修改货运-保险费支付记录
     * 
     * @param pInsurance 货运-保险费支付记录信息
     * @return 结果
     */
	@Override
	public JsonResult edit(PInsurance pInsurance)
	{
        int result = pInsuranceDao.updatePInsurance(pInsurance);
        if (result == 0) {
            return JsonResult.error(201,"更新失败");
        }
        return JsonResult.success(200,"更新成功");
	}

    /**
     * 删除货运-保险费支付记录对象
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

        int result = pInsuranceDao.updatePInsuranceByIds(delete);
        if (result == 0) {
            return JsonResult.error(201,"删除失败");
        }
        return JsonResult.success(200,"删除成功");
    }

}