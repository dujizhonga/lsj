package com.yrsoft.delivery.dto;

import com.yrsoft.delivery.vo.OwnerInfoListVO;

/**
 * @author Yxq
 * @date 2019/2/25 10:46
 */
public class OwnerInfoDTO extends BaseDTO {

    private OwnerInfoListVO data;

    public OwnerInfoListVO getData() {
        return data;
    }

    public void setData(OwnerInfoListVO data) {
        this.data = data;
    }
}
