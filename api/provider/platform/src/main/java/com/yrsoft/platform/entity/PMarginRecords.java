package com.yrsoft.platform.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
						
/**
 * 货运-支付保证金记录表 p_margin_records
 *
 * @author mz
 * @date 2019-02-23
 */
public class PMarginRecords
{
private static final long serialVersionUID = 1L;

/** 主键ID */
private String id;
/** 货运单id */
private String invoiceId;
/** 支付记录id/消费记录id */
private String payId;
/** 保证金金额(单位：分) */
private Long marginAmount;
/** 支付方式 1:支付宝 2:微信 3:银联 4:现金余额 */
private Integer payWay;
/** 支付时间 */
private Integer payTime;

public void setId(String id)
        {
        this.id = id;
        }

public String getId()
        {
        return id;
        }
public void setInvoiceId(String invoiceId)
        {
        this.invoiceId = invoiceId;
        }

public String getInvoiceId()
        {
        return invoiceId;
        }
public void setPayId(String payId)
        {
        this.payId = payId;
        }

public String getPayId()
        {
        return payId;
        }
public void setMarginAmount(Long marginAmount)
        {
        this.marginAmount = marginAmount;
        }

public Long getMarginAmount()
        {
        return marginAmount;
        }
public void setPayWay(Integer payWay)
        {
        this.payWay = payWay;
        }

public Integer getPayWay()
        {
        return payWay;
        }
public void setPayTime(Integer payTime)
        {
        this.payTime = payTime;
        }

public Integer getPayTime()
        {
        return payTime;
        }

public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
	            .append("id", getId())
	            .append("invoiceId", getInvoiceId())
	            .append("payId", getPayId())
	            .append("marginAmount", getMarginAmount())
	            .append("payWay", getPayWay())
	            .append("payTime", getPayTime())
	        .toString();
        }
        }
