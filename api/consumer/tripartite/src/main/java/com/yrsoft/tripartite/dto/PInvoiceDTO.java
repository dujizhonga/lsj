package com.yrsoft.tripartite.dto;


import com.yrsoft.tripartite.entity.PInvoice;

public class PInvoiceDTO extends BaseDTO {
    private PInvoice data;

    public PInvoice getData() {
        return data;
    }

    public void setData(PInvoice data) {
        this.data = data;
    }
}
