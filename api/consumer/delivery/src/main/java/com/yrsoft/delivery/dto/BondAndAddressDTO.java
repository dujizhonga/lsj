package com.yrsoft.delivery.dto;

import com.yrsoft.delivery.vo.BondAndAddressVO;

/**
 * @author Yhq
 * @date 2019/2/25 10:44
 */
public class BondAndAddressDTO extends BaseDTO {

    private BondAndAddressVO data;

    public BondAndAddressVO getData() {
        return data;
    }

    public void setData(BondAndAddressVO data) {
        this.data = data;
    }
}
