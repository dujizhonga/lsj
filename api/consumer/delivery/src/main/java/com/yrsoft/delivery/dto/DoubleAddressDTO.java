package com.yrsoft.delivery.dto;

import com.yrsoft.delivery.vo.DoubleAddressVO;

/**
 * @author Yhq
 * @date 2019/3/4 14:17
 */
public class DoubleAddressDTO extends BaseDTO{

    private DoubleAddressVO doubleAddressVO;

    public DoubleAddressVO getDoubleAddressVO() {
        return doubleAddressVO;
    }

    public void setDoubleAddressVO(DoubleAddressVO doubleAddressVO) {
        this.doubleAddressVO = doubleAddressVO;
    }
}
