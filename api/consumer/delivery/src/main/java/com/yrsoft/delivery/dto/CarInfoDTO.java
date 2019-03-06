package com.yrsoft.delivery.dto;

import com.yrsoft.delivery.vo.CarInfosVO;

/**
 * @author Yxq
 * @date 2019/2/25 10:46
 */
public class CarInfoDTO extends BaseDTO {

    private CarInfosVO data;

    public CarInfosVO getData() {
        return data;
    }

    public void setData(CarInfosVO data) {
        this.data = data;
    }
}
