package com.yrsoft.tripartite.dto;

import com.yrsoft.tripartite.entity.Car;

public class CarDTO extends BaseDTO {
    private Car data;

    public Car getData() {
        return data;
    }

    public void setData(Car data) {
        this.data = data;
    }
}
