package com.yrsoft.delivery.dto;

import java.util.List;

import com.yrsoft.delivery.entity.ShippingAddress;

/**
 * @author Yxq
 * @date 2019/2/26
 */
public class ShippingsAddressDTO extends BaseDTO {

    private List<ShippingAddress> data;

    public List<ShippingAddress> getData() {
        return data;
    }

    public void setData(List<ShippingAddress> data) {
        this.data = data;
    }
}
