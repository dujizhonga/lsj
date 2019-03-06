package com.yrsoft.tripartite.service.impl;

import cn.hutool.core.util.XmlUtil;
import cn.hutool.json.JSONUtil;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import com.yrsoft.common.bohai.InsureUtil;
import com.yrsoft.common.bohai.InsureVO;
import com.yrsoft.common.constant.UrlContants;
import com.yrsoft.common.utils.JsonResult;
import com.yrsoft.common.utils.ParamVC;
import com.yrsoft.common.utils.StringUtils;

import com.yrsoft.tripartite.dto.CarDTO;
import com.yrsoft.tripartite.dto.MMemberDTO;
import com.yrsoft.tripartite.dto.PInvoiceDTO;
import com.yrsoft.tripartite.dto.PWaybillDTO;
import com.yrsoft.tripartite.entity.*;
import com.yrsoft.tripartite.service.BoHaiInsuranceService;
import org.apache.servicecomb.provider.springmvc.reference.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.w3c.dom.Document;
import javax.xml.xpath.XPathConstants;
import java.io.ByteArrayInputStream;
import java.util.List;

@Component
public class BoHaiInsuranceServiceImpl implements BoHaiInsuranceService {
    //声明提供者请求对象
    private static RestTemplate restTemplate = RestTemplateBuilder.create();

    /**
     * 发送核保/投保报文
     * @param id 运单id
     * @return
     */
    @Override
    public JsonResult insure(String id) {
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("id",id);
        JsonResult updateJson = restTemplate.postForObject( UrlContants.PLATFORM+"pWaybill/updateInsuranceSendStateById", map, JsonResult.class);
        if(updateJson.getCode()==201){
            return JsonResult.error(201,"该运单已投保，不能重复投保");
        }else if(updateJson.getCode()==207){
            return JsonResult.error(201,"运单投保状态修改服务异常");
        }

        //查询运单信息
        String waybillJosn = restTemplate.postForObject( UrlContants.PLATFORM+"pWaybill/getWaybillById", map, String.class);
        PWaybillDTO pWaybillDTO = JSONUtil.toBean(waybillJosn, PWaybillDTO.class);
        if(pWaybillDTO.getCode()!=200){
            return JsonResult.error(201,"运单查询失败");
        }
        PWaybill pWaybill = pWaybillDTO.getData();

        //查询货运单信息
        map.clear();
        map.add("id",pWaybill.getInvoiceId());
        String  invoiceJson = restTemplate.postForObject(UrlContants.PLATFORM + "/pInvoice/getPInvoiceById", map, String.class);
        PInvoiceDTO pInvoiceDTO = JSONUtil.toBean(invoiceJson, PInvoiceDTO.class);
        if(pInvoiceDTO.getCode()!=200){
            return JsonResult.error(201,"货运单查询失败");
        }
        PInvoice pInvoice = pInvoiceDTO.getData();

        //查询车辆信息
        map.clear();
        map.add("id",pWaybill.getCarId());
        String carJson = restTemplate.postForObject(UrlContants.AUTH + "/car/getCarById", map, String.class);
        CarDTO carDTO = JSONUtil.toBean(carJson, CarDTO.class);
        if(carDTO.getCode()!=200){
            return JsonResult.error(201,"货运单查询失败");
        }
        Car car = carDTO.getData();

        //查询货主信息
        map.clear();
        map.add("id",pInvoice.getShipperId());
        String memberJosn = restTemplate.postForObject( UrlContants.MEMBER+"mMember/getMMemberById", map, String.class);
        MMemberDTO mMemberDTO = JSONUtil.toBean(memberJosn, MMemberDTO.class);
        if(mMemberDTO.getCode()!=200){
            return JsonResult.error(201,"运单查询失败");
        }
        MMember mMember= mMemberDTO.getData();

        //查询货主个人认证信息
        map.clear();
        map.add("memberId",pInvoice.getShipperId());
        map.add("status","1");
        JsonResult personJson = restTemplate.postForObject(UrlContants.AUTH + "person/list", map, JsonResult.class);
        List<Person> persons = ParamVC.objectToList(personJson.getData(), Person.class);

        //temp 1-个人投保，2-企业投保
        String temp=null;

        //查询货主企业认证信
        map.clear();
        map.add("memberId",pInvoice.getShipperId());
        map.add("status","1");
        JsonResult companyJson = restTemplate.postForObject(UrlContants.AUTH + "company/list", map, JsonResult.class);
        List<Company> companys =ParamVC.objectToList(companyJson.getData(), Company.class);

        Person person=null;
        Company company=null;

        if((null==persons || persons.isEmpty()) && (null==companys || companys.isEmpty())){
            return JsonResult.error(201,"货主认证信息不能为空");
        }else{
            if(null!=persons && !persons.isEmpty()){
                if(persons.size()>1){
                    return JsonResult.error(201,"货主个人认证信息查询异常");
                }
                person = persons.get(0);
            }
            if(null!=companys || !companys.isEmpty()){
                if(companys.size()>1){
                    return JsonResult.error(201,"货主企业认证信息查询异常");
                }
                temp="2";
                company= companys.get(0);
            }else {
                temp="1";
            }
        }


        //组装核保数据
        InsureVO insureVO=installData(pWaybill,pInvoice,car,mMember,person,company,temp);

        map.clear();
        map.add("id", StringUtils.getUUID());
        map.add("orderCode",insureVO.getWaybillNumber());
        map.add("memberId",pInvoice.getShipperId());

        //调用核保接口
        String erificationXml = InsureUtil.submitInsure(insureVO);
        map.add("insurancStep1Xml",erificationXml);
        //获取返回状态值
        String erificationCode = xmlParse(erificationXml, "/SQTBRequestXml/Header/PA_RSLT_CODE");

        if ("1000".equals(erificationCode)) {
            map.add("insuranceStep1Status","1");
            //核保成功
            // 从结果值获取投保单号
            String applyPolicyNo = xmlParse(erificationXml, "/SQTBRequestXml/Response/OrderInfo/PolicyInfo/ApplyPolicyNo");

            // 调用承保接口
            String underWriteXml = InsureUtil.generateInsure(applyPolicyNo, insureVO.getWaybillNumber(), insureVO.getUserName(),
                    insureVO.getInsureAmount(), insureVO.getInsureLimit());
            map.add("insurancStep2Xml",underWriteXml);
            //获取返回状态值
            String underWriteCode=xmlParse(underWriteXml, "/SQTBRequestXml/Header/PA_RSLT_CODE");

            if ("1000".equals(underWriteCode)) {
                //承保成功
                map.add("insuranceStep2Status","1");
            } else {
                //承保失败
                map.add("insuranceStep2Status","2");
            }
        } else {
            //核保失败
            map.add("insuranceStep1Status","2");
        }

        JsonResult jsonResult = restTemplate.postForObject(UrlContants.PLATFORM + "pBohaiInsuranceLog/add", map, JsonResult.class);

        if(jsonResult.getCode()==200){
            return JsonResult.success(200,"投保日志记录成功，投保详情请查看日志");
        }else {
            return JsonResult.error(201,"服务异常，投保日志记录失败");
        }
    }

    /**
     * 核保数据组装
     * @param pWaybill 运单对象
     * @param pInvoice 货运单对象
     * @param car 车辆对象
     * @param mMember 货主对象
     * @param person 个人认证对象
     * @param company 企业认证对象
     * @param temp 个人/企业 标识
     * @return
     */
    private InsureVO installData(PWaybill pWaybill,PInvoice pInvoice,Car car,MMember mMember,Person person,Company company,String temp){
        //组装数据
        InsureVO insureVO=new InsureVO();
        insureVO.setTarget(temp);
        insureVO.setInsureType("1");
        insureVO.setWaybillNumber(pWaybill.getWaybillNumber());
        insureVO.setCarNum(car.getCarNumber());
        insureVO.setCarVin(car.getCarVin());
        insureVO.setCarLoad(car.getTotalTractionWeight());
        if(pInvoice.getId().length()==32){
            insureVO.setStartAddress(pInvoice.getStartProvince()+pInvoice.getStartCity() +pInvoice.getStartArea()+pInvoice.getStartAddress());
            insureVO.setArriveAddress(pInvoice.getArriveProvince()+pInvoice.getArriveCity() +pInvoice.getArriveArea()+pInvoice.getArriveAddress());
        }else{
            insureVO.setStartAddress(pInvoice.getStartAddress());
            insureVO.setStartAddress(pInvoice.getStartAddress());
        }
        if(insureVO.getTarget().equals("1")){
            insureVO.setIdCard(person.getIdCardCode());
            insureVO.setUserName(person.getName());
        }else if(insureVO.getTarget().equals("2")){
            insureVO.setIdCard(company.getBusinessLicenceCode());
            insureVO.setUserName(company.getCompanyName());
        }
        insureVO.setUserSex(mMember.getSex()==0?"1":"2");
        insureVO.setBirthday(mMember.getBirthday());
        insureVO.setTelephone(mMember.getTelephone());
        insureVO.setInsureAmount(String.valueOf(pInvoice.getBasicAmount()/100));
        insureVO.setInsureLimit(String.valueOf(pInvoice.getBasicAmount()*10));
        insureVO.setGoodsTypeName("普通货物");
        insureVO.setGoodsCount("1");
        insureVO.setGoodsRemark(pInvoice.getGoodsRemark());

        return insureVO;
    }

    /**
     * xml解析工具
     * @param xmlStr
     */
    private String  xmlParse(String xmlStr,String nodePath){
        Document doc =null;
        try {
            doc = XmlUtil.readXML(new ByteArrayInputStream(xmlStr.getBytes("utf-8")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 成功状态码，1000表示成功
        String resultCode  = XmlUtil.getByXPath(nodePath, doc, XPathConstants.STRING).toString();

        return resultCode;
    }

}
