package com.yrsoft.delivery.service.impl;

import cn.hutool.json.JSONUtil;
import com.yrsoft.common.constant.UrlContants;
import com.yrsoft.common.exception.LSJExceptions;
import com.yrsoft.common.exception.ServiceInvocationException;
import com.yrsoft.delivery.dto.FreightMoneyDTO;
import com.yrsoft.delivery.entity.PWaybill;
import com.yrsoft.delivery.service.GoodsService;
import com.yrsoft.delivery.dto.BondAndAddressDTO;
import com.yrsoft.delivery.vo.BondAndAddressVO;
import com.yrsoft.delivery.vo.FreightMoneyVO;
import org.apache.servicecomb.provider.springmvc.reference.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * 货物/货运管理
 *
 * @author Yhq
 * @date 2019/2/23 14:18
 */
@Service
public class GoodsServiceImpl implements GoodsService {

    private static final RestTemplate restTemplate = RestTemplateBuilder.create();

    @Override
    public BondAndAddressVO getBondAndAddress(String invoiceId) {
        MultiValueMap<String, String> requestEntity = new LinkedMultiValueMap<>();
        requestEntity.add("id", invoiceId);
        String forObject = restTemplate.postForObject(UrlContants.PLATFORM + "pInvoice/getPInvoiceById", requestEntity, String.class);
        BondAndAddressDTO bondAndAddressDTO = JSONUtil.toBean(forObject, BondAndAddressDTO.class);
        if (bondAndAddressDTO.getCode() != 200) {
            throw new ServiceInvocationException(bondAndAddressDTO.getCode(),bondAndAddressDTO.getMessage());
        }
        BondAndAddressVO data = bondAndAddressDTO.getData();
        //如果小于等于100公里，根据单车计算，车辆数*100
        if (100 <= Integer.parseInt(data.getRouteRange())) {
            data.setBondMoney(100d * data.getApplyCarNo());
        } else {
            //大于100公里，车辆数*单车运费*0.1（与200取大）
            Long money = data.getApplyCarNo() * data.getBasicAmount() / 10L;
            if (200 > money) {
                data.setBondMoney(200d);
            } else {
                data.setBondMoney(money.doubleValue());
            }
        }
        return data;
    }

    @Override
    public FreightMoneyVO getFreightMoney(String ids) {
        MultiValueMap<String, String> requestEntity = new LinkedMultiValueMap<>();
        requestEntity.add("ids", ids);
        String forObject = restTemplate.postForObject(UrlContants.PLATFORM + "pWaybill/getByIds", requestEntity, String.class);
        FreightMoneyDTO freightMoneyDTO = JSONUtil.toBean(forObject, FreightMoneyDTO.class);
        if (freightMoneyDTO.getCode() != 200) {
            throw new ServiceInvocationException(freightMoneyDTO.getCode(),freightMoneyDTO.getMessage());
        }
        List<PWaybill> data = freightMoneyDTO.getData();
        long marginAmount = 0L;
        //获取单车保证金金额
        for (PWaybill p : data) {
            if (1 == p.getFlag()){
                requestEntity.clear();
                requestEntity.add("id",p.getInvoiceId());
                String str = restTemplate.postForObject(UrlContants.PLATFORM + "pInvoice/getPInvoiceById", requestEntity, String.class);
                BondAndAddressDTO fmDTO = JSONUtil.toBean(forObject, BondAndAddressDTO.class);
                marginAmount = fmDTO.getData().getMarginAmount();
                break;
            }
        }
        //指派车运费总金额
        long a = 0L;
        //系统车运费总金额
        long b = 0L;
        for (PWaybill p : data) {
            //指派车
            if (0 == p.getFlag()){
                a += p.getAdvanceFreight();
            }else {
                //系统车运费总金额（除去保证金）
                b += (p.getAdvanceFreight() - marginAmount);
            }
        }
        FreightMoneyVO freightMoneyVO = new FreightMoneyVO();
        freightMoneyVO.setAssignMoney(a);
        freightMoneyVO.setSystemMoney(b);
        return freightMoneyVO;
    }


}
