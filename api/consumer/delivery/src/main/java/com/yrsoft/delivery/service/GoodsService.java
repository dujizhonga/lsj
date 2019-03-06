package com.yrsoft.delivery.service;

import com.yrsoft.delivery.vo.BondAndAddressVO;
import com.yrsoft.delivery.vo.FreightMoneyVO;

/**
 * 货物管理
 *
 * @author Yhq
 * @date 2019/2/23 14:07
 */
public interface GoodsService {

    /**
     * 查询货运单对应地址及保证金接口
     *
     * @return BondAndAddressVO
     */
    BondAndAddressVO getBondAndAddress(String invoiceId);

    /**
     *
     * 获取指派车和系统车的运费
     *
     * @return
     */
    FreightMoneyVO getFreightMoney(String ids);
}
