package com.yrsoft.freight.dto;

import com.yrsoft.freight.entity.PInvoice;

import java.util.List;

public class PInvoiceListDTO extends BaseDTO {
    private List<PInvoice> data;

    public List<PInvoice> getData() {
        return data;
    }

    public void setData(List<PInvoice> data) {
        this.data = data;
    }
}
