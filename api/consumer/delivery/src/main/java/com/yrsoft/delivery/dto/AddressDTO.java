package com.yrsoft.delivery.dto;

import com.yrsoft.delivery.entity.Address;

/**
 * @author Yhq
 * @date 2019/2/25 10:46
 */
public class AddressDTO extends BaseDTO {

    private Address data;

    public Address getData() {
        return data;
    }

    public void setData(Address data) {
        this.data = data;
    }
}
