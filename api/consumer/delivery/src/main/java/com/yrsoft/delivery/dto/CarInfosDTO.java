package com.yrsoft.delivery.dto;

import java.util.List;

import com.yrsoft.delivery.vo.CarInfosVO;

/**
 * @author Yxq
 * @date 2019/2/25 10:46
 */
public class CarInfosDTO extends BaseDTO {

	private List<CarInfosVO> data;

    public List<CarInfosVO> getData() {
        return data;
    }

    public void setData(List<CarInfosVO> data) {
        this.data = data;
    }
}
