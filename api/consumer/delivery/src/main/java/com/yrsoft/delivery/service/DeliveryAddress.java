package com.yrsoft.delivery.service;

import com.yrsoft.common.utils.JsonResult;
import com.yrsoft.delivery.entity.Address;
import com.yrsoft.delivery.entity.ShippingAddress;
import com.yrsoft.delivery.vo.DoubleAddressVO;

/**
 * 收发货地址管理
 *
 * @author Yhq
 * @date 2019/2/23 13:45
 */
public interface DeliveryAddress {

    /**
     * 保存收发货地址
     *
     * @param address
     * @return
     */
    Address saveAddress(Address address);
    /**
     * 修改收发货地址
     *
     * @param address
     * @return
     */
    public JsonResult updateAddress(String paramStr);


    /**
     * 首次发货（同时添加发货地址和收货地址）
     * @param doubleAddressVO
     * @return
     */
    DoubleAddressVO firstSaveAddress(DoubleAddressVO doubleAddressVO);
}
