package com.yrsoft.delivery.dto;

import com.yrsoft.delivery.entity.ShippingAddress;

/**
 * @author Yxq
 * @date 2019/2/26
 */
public class ShippingAddressDTO extends BaseDTO {

    private ShippingAddress data;

    public ShippingAddress getData() {
        return data;
    }

    public void setData(ShippingAddress data) {
        this.data = data;
    }
}
