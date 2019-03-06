package com.yrsoft.pay.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
									
/**
 * 会员管理-充值记录表 m_recharge
 *
 * @author mz
 * @date 2019-02-23
 */
public class MRecharge
{
private static final long serialVersionUID = 1L;

/** 编号 */
private String id;
/** fk:会员编号(会员表，编号） */
private String memberId;
/** 支付流水号/支付项id */
private String orderId;
/** 充值类型(0：支付宝，1：微信，2：银联 ,3：运费结算,4:保证金退款,5:运费退款) */
private Integer rechargeType;
/** 充值金额 */
private Long rechargeAmount;
/** 充值时间 */
private Integer rechargeTime;
/** 支付状态 0：待支付 1：支付成功 2：支付失败 3:用户取消操作 5：未知 */
private Integer state;
/** 子账簿id */
private String fundAccId;
/** 备注 */
private String remarks;

private Integer page;
private Integer limit;

public void setId(String id)
        {
        this.id = id;
        }

public String getId()
        {
        return id;
        }
public void setMemberId(String memberId)
        {
        this.memberId = memberId;
        }

public String getMemberId()
        {
        return memberId;
        }
public void setOrderId(String orderId)
        {
        this.orderId = orderId;
        }

public String getOrderId()
        {
        return orderId;
        }
public void setRechargeType(Integer rechargeType)
        {
        this.rechargeType = rechargeType;
        }

public Integer getRechargeType()
        {
        return rechargeType;
        }
public void setRechargeAmount(Long rechargeAmount)
        {
        this.rechargeAmount = rechargeAmount;
        }

public Long getRechargeAmount()
        {
        return rechargeAmount;
        }
public void setRechargeTime(Integer rechargeTime)
        {
        this.rechargeTime = rechargeTime;
        }

public Integer getRechargeTime()
        {
        return rechargeTime;
        }
public void setState(Integer state)
        {
        this.state = state;
        }

public Integer getState()
        {
        return state;
        }
public void setFundAccId(String fundAccId)
        {
        this.fundAccId = fundAccId;
        }

public String getFundAccId()
        {
        return fundAccId;
        }
public void setRemarks(String remarks)
        {
        this.remarks = remarks;
        }

public String getRemarks()
        {
        return remarks;
        }

public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
	            .append("id", getId())
	            .append("memberId", getMemberId())
	            .append("orderId", getOrderId())
	            .append("rechargeType", getRechargeType())
	            .append("rechargeAmount", getRechargeAmount())
	            .append("rechargeTime", getRechargeTime())
	            .append("state", getState())
	            .append("fundAccId", getFundAccId())
	            .append("remarks", getRemarks())
	        .toString();
        }

public Integer getPage() {
	return page;
}

public void setPage(Integer page) {
	this.page = page;
}

public Integer getLimit() {
	return limit;
}

public void setLimit(Integer limit) {
	this.limit = limit;
}
        }
