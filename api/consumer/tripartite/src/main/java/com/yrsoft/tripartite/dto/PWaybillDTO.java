package com.yrsoft.tripartite.dto;


import com.yrsoft.tripartite.entity.PWaybill;

public class PWaybillDTO extends BaseDTO{
    private PWaybill data;

    public PWaybill getData() {
        return data;
    }

    public void setData(PWaybill data) {
        this.data = data;
    }
}
