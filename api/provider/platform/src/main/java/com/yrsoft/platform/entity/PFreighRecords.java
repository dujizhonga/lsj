package com.yrsoft.platform.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
				
/**
 * 货运-支付运费记录表 p_freigh_records
 *
 * @author mz
 * @date 2019-02-23
 */
public class PFreighRecords
{
private static final long serialVersionUID = 1L;

/** 主键id */
private String id;
/** 货运单id */
private String invoiceId;
/** 支付金额(单位：分) */
private Long payAmount;
/** 支付时间 */
private Long payTime;

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
public void setPayAmount(Long payAmount)
        {
        this.payAmount = payAmount;
        }

public Long getPayAmount()
        {
        return payAmount;
        }
public void setPayTime(Long payTime)
        {
        this.payTime = payTime;
        }

public Long getPayTime()
        {
        return payTime;
        }

public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
	            .append("id", getId())
	            .append("invoiceId", getInvoiceId())
	            .append("payAmount", getPayAmount())
	            .append("payTime", getPayTime())
	        .toString();
        }
        }
