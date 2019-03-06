package com.yrsoft.truck.dto;

import java.util.List;

import com.yrsoft.truck.vo.CarInfoVO;

/**
 * @author Yxq
 * @date 2019/2/25 10:46
 */
public class CarInfosDTO extends BaseDTO {

	private List<CarInfoVO> data;

    public List<CarInfoVO> getData() {
        return data;
    }

    public void setData(List<CarInfoVO> data) {
        this.data = data;
    }
}
