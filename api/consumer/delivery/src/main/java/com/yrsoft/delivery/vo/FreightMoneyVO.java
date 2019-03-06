package com.yrsoft.delivery.vo;

/**
 * 指派车运费和系统车运费
 *
 * @author Yhq
 * @date 2019/2/25 16:47
 */
public class FreightMoneyVO {

    /**
     * 指派车运费
     */
    private Long assignMoney;

    /**
     * 系统车运费
     */
    private Long systemMoney;

    public Long getAssignMoney() {
        return assignMoney;
    }

    public void setAssignMoney(Long assignMoney) {
        this.assignMoney = assignMoney;
    }

    public Long getSystemMoney() {
        return systemMoney;
    }

    public void setSystemMoney(Long systemMoney) {
        this.systemMoney = systemMoney;
    }
}
