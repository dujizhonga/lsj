package com.yrsoft.freight.service;

import com.yrsoft.common.utils.JsonResult;
import com.yrsoft.common.utils.ParamVC;

public interface StoredRecordService {
    public JsonResult getStoredBaseInfomation(String id);

    public JsonResult addStoredRecords(ParamVC pvc) throws Exception;

    /**
     * 生产资料分配列表
     * @param: @param paramStr
     * @param: @return
     * @return: JsonResult
     * @auther: shihh
     * @date: 2019年2月28日下午1:58:58
     */
    public JsonResult SelectPStoredList(String paramStr);


   /* public JsonResult getStoredRecordsList();*/
    /**
     * 生产资料分配记录列表导出
     * @param: @param paramStr
     * @param: @return
     * @return: JsonResult
     * @auther: shihh
     * @date: 2019年3月1日下午1:54:54
     */
    public JsonResult exportPStoreds(String paramStr);
 
}
