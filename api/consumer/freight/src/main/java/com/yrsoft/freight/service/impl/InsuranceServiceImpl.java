package com.yrsoft.freight.service.impl;


import com.yrsoft.common.constant.UrlContants;
import com.yrsoft.common.utils.JsonResult;
import com.yrsoft.freight.service.InsuranceService;
import org.apache.servicecomb.provider.springmvc.reference.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import java.util.List;


@Component
public class InsuranceServiceImpl implements InsuranceService {
    //声明提供者请求对象
    private static RestTemplate restTemplate = RestTemplateBuilder.create();

    /**
     * 计算保险费
     * @param routeRange
     * @return
     */
    public JsonResult getInsuranceAmount(String routeRange){
        JsonResult insurance = selectInsuranceRule("INSURANCE");
        if(insurance.getCode()!=200){
            return JsonResult.error(201, "查询失败");
        }
        List<String> list =(List<String>) insurance.getData();

        //将距离字符串转化为数字
        float rg = Float.parseFloat(routeRange);

        String result=null;

        for (String li:list) {
            String[] array = li.split(",");
            if(array.length==0){
                return JsonResult.error(201, "数据字典异常，查询失败");
            }
            String ruleStr = array[0];
            String amount = array[1].substring(0, array[1].indexOf("元"));

            if(array[0].indexOf("<")!=-1){
                String km = ruleStr.substring(ruleStr.indexOf("<") + 1, ruleStr.indexOf("km"));
                float v = Float.parseFloat(km);
                if(rg<=v){
                    result=amount;
                    break;
                }
            }else if(array[0].indexOf("-")!=-1){
                String[] kms=ruleStr.substring(0,ruleStr.indexOf("km")).split("-");
                float v1 = Float.parseFloat(kms[0]);
                float v2 = Float.parseFloat(kms[1]);
                if(rg>v1 && rg<v2){
                    result=amount;
                    break;
                }
            }else if(array[0].indexOf(">")!=-1){
                String km =ruleStr.substring(ruleStr.indexOf(">")+1,ruleStr.indexOf("km"));
                float v = Float.parseFloat(km);
                if(rg>=v){
                    result=amount;
                    break;
                }
            }
        }
        if(null==result){
            return JsonResult.error(201,"保险费计算失败");
        }
        return JsonResult.success(result);
    }

    /**
     * 按类型查询-保险费规则
     * @param type
     * @return
     */
    public JsonResult selectInsuranceRule(String type){
        MultiValueMap<String, String> requestEntity = new LinkedMultiValueMap<>();
        requestEntity.add("type", type);
        JsonResult jsonResult = restTemplate.postForObject( UrlContants.SYSYTEM+"sData/selectDataByType", requestEntity, JsonResult.class);
        return jsonResult;
    }

}
