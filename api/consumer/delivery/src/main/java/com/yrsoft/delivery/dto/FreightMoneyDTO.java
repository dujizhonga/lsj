package com.yrsoft.delivery.dto;

import com.yrsoft.delivery.entity.PWaybill;

import java.util.List;

/**
 * @author Yhq
 * @date 2019/2/25 16:49
 */
public class FreightMoneyDTO extends BaseDTO {

    private List<PWaybill> data;

    public List<PWaybill> getData() {
        return data;
    }

    public void setData(List<PWaybill> data) {
        this.data = data;
    }
}
