package com.yrsoft.freight.dto;

import com.yrsoft.freight.entity.PInvoice;

public class PInvoiceDTO extends BaseDTO {
    private PInvoice data;

    public PInvoice getData() {
        return data;
    }

    public void setData(PInvoice data) {
        this.data = data;
    }
}
