package com.yrsoft.finance.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
							
/**
 * 会员管理-消费记录（非三方）表 m_consume
 *
 * @author mz
 * @date 2019-02-23
 */
public class MConsume
{
private static final long serialVersionUID = 1L;

/** 主键ID */
private String id;
/** 会员id */
private String memberId;
/** 支付项id */
private String payId;
/** 消费金额(单位：分) */
private Long consumeAmount;
/** 消费类型  1-运费 2-保证金 3 -油卡购买 4-车辆加油 */
private Integer consumeWay;
/** 支付类型 1-保证金 2-现金余额 3-垫支 4-垫资 5-油卡余额 */
private Integer payType;
/** 消费时间 */
private Long consumeTime;

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
public void setPayId(String payId)
        {
        this.payId = payId;
        }

public String getPayId()
        {
        return payId;
        }
public void setConsumeAmount(Long consumeAmount)
        {
        this.consumeAmount = consumeAmount;
        }

public Long getConsumeAmount()
        {
        return consumeAmount;
        }
public void setConsumeWay(Integer consumeWay)
        {
        this.consumeWay = consumeWay;
        }

public Integer getConsumeWay()
        {
        return consumeWay;
        }
public void setPayType(Integer payType)
        {
        this.payType = payType;
        }

public Integer getPayType()
        {
        return payType;
        }
public void setConsumeTime(Long consumeTime)
        {
        this.consumeTime = consumeTime;
        }

public Long getConsumeTime()
        {
        return consumeTime;
        }

public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
	            .append("id", getId())
	            .append("memberId", getMemberId())
	            .append("payId", getPayId())
	            .append("consumeAmount", getConsumeAmount())
	            .append("consumeWay", getConsumeWay())
	            .append("payType", getPayType())
	            .append("consumeTime", getConsumeTime())
	        .toString();
        }
        }
