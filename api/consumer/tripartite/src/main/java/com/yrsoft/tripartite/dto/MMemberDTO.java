package com.yrsoft.tripartite.dto;


import com.yrsoft.tripartite.entity.MMember;

public class MMemberDTO extends BaseDTO{
    private MMember data;

    public MMember getData() {
        return data;
    }

    public void setData(MMember data) {
        this.data = data;
    }
}
