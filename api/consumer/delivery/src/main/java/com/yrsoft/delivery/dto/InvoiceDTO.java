package com.yrsoft.delivery.dto;

import com.yrsoft.delivery.entity.PInvoice;

/**
 * @author Yxq
 * @date 2019/2/25 
 */
public class InvoiceDTO extends BaseDTO {

    private PInvoice data;

    public PInvoice getData() {
        return data;
    }

    public void setData(PInvoice data) {
        this.data = data;
    }
}
