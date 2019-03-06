package com.yrsoft.common.utils;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 作用:json参数 解析/验证/封装 工具
 * 作者：熊磊
 * 日期：20190227
 */
public class ParamVC {

    private boolean legal;

    private String message;

    private Map<String,String> resultMap;

    public boolean isLegal() {
        return legal;
    }

    public ParamVC setJson(boolean legal) {
        this.legal = legal;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public ParamVC setMessage(String message) {
        this.message = message;
        return this;
    }

    public Map<String, String> getResultMap() {
        return resultMap;
    }

    public ParamVC setResultMap(Map<String, String> resultMap) {
        this.resultMap = resultMap;
        return this;
    }

    public static ParamVC error(String message){
        return  new ParamVC().setJson(false).setMessage(message);
    }

    public static ParamVC success(Map<String, String> map) {
        return new ParamVC().setJson(true).setResultMap(map);
    }

    public String getKey(String key) {
        if(null==resultMap.get(key)){
            return null;
        }
        return resultMap.get(key).toString();
    }

    /**
     * 必传参数验证和封装
     * @param jsonStr json字符串
     * @param keys 需要非空验证的必传参数
     * @return
     */
    public static ParamVC jsonValidateAndConvert(String jsonStr, String... keys){
        if(StringUtils.isBlank(jsonStr)){
            return ParamVC.error("参数不能为空");
        }
        JSONObject jsonObject =null;
        try {
            jsonObject = JSONUtil.parseObj(jsonStr);
        }catch (Exception e){
            e.printStackTrace();
            return ParamVC.error("参数格式错误,请上传json格式参数");
        }
        HashMap<String, String> resultMap = toHashMap(jsonObject);

        for (int i = 0; i <keys.length ;i++) {
            String valueStr = resultMap.get(keys[i]);
            if(StringUtils.isBlank(valueStr)){
                return ParamVC.error("参数"+keys[i]+"不能为空");
            }
        }
        return ParamVC.success(resultMap);
    }

    /**
     * 必传参数验证和非必传参数封装
     * @param jsonStr json字符串
     * @param params 非必传参数数组,但至少一项不为空
     * @param keys 必传参数
     * @return
     */
    public static ParamVC jsonValidateAndConvert(String jsonStr, String[] params, String... keys){
        ParamVC paramResult = jsonValidateAndConvert(jsonStr, keys);
        if(!paramResult.isLegal()){
            return paramResult;
        }
        Map<String, String> resultMap = paramResult.getResultMap();

        int count=0;
        for (int i = 0; i <params.length ; i++) {
            String valueStr =resultMap.get(params[i]);
            if(StringUtils.isBlank(valueStr)){
                count++;
            }
        }
        if(count==params.length){
            String str="" ;
            for (int i = 0; i <params.length ; i++) {
                str+=params[i]+" ";
            }
            return ParamVC.error("参数 "+str+"至少一项不为空");
        }

        return ParamVC.success(resultMap);
    }

    private static HashMap<String, String> toHashMap(JSONObject jsonObject) {
        HashMap<String, String> data = new HashMap<String, String>();
        Set<String> keys = jsonObject.keySet();
        // 遍历jsonObject数据，添加到Map对象
        for (String key:keys) {
            String valueStr = StringUtils.objToStr(jsonObject.get(key));
            String value =StringUtils.isBlank(valueStr)?null:valueStr;
            data.put(key, value);
        }
        return data;
    }

    /**
     * 正则比对储值比例是否为百分数
     * @param str
     * @return
     */
    public static boolean match(String str,String regex) {
        //String regex = "\\d+(\\.\\d+)?%";//验证百分数
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }

    /**
     * 将object转为List
     * @param object
     * @return
     */
    public static <T> List<T> objectToList(Object object,Class<T> beanClass) {
        List<T> list =null;
        JSONObject jsonObject =null;
        try{
           jsonObject = JSONUtil.parseObj(object);
        }catch (Exception e){
           e.printStackTrace();
        }

        Object listOb = jsonObject.get("list");
        String temp=null;
        if(null==listOb){
            if(null!=object){
                temp = JSONUtil.toJsonStr(object);
            }else{
                return null;
            }
        }else{
            temp=listOb.toString();
        }
        JSONArray jsonArray = JSONUtil.parseArray(temp);

        if (jsonArray.size() > 0) {
            list=new ArrayList<>();
            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject job = jsonArray.getJSONObject(i);  // 遍历 jsonarray 数组，把每一个对象转成 json 对象
                T ot = JSONUtil.toBean(job, beanClass);
                list.add(ot);
            }
        }
        return list;
    }
}
