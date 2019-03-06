package com.yrsoft.truck.dto;

import com.yrsoft.truck.vo.CarInfoVO;

/**
 * @author Yxq
 * @date 2019/2/25 10:46
 */
public class CarInfoDTO extends BaseDTO {

    private CarInfoVO data;

    public CarInfoVO getData() {
        return data;
    }

    public void setData(CarInfoVO data) {
        this.data = data;
    }
}
