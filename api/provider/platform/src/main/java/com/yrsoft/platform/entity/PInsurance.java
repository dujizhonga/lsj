package com.yrsoft.platform.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
										
/**
 * 货运-保险费支付记录表 p_insurance
 *
 * @author mz
 * @date 2019-02-23
 */
public class PInsurance
{
private static final long serialVersionUID = 1L;

/** 主键 */
private String id;
/** 会员编号 */
private String memberId;
/** 支付类型(1：支付宝，2：微信，3：银联) */
private Integer payType;
/** 支付金额 */
private Long payMoney;
/** 支付时间 */
private Integer payTime;
/** 支付状态 0-待支付 1-成功 2-失败 */
private Integer payState;
/** 回调时间 */
private Integer notifyTime;
/** 回调内容 */
private String notifyContent;
/** 支付账号 */
private String payAccount;
/** 支付流水号，第三方机构返回的流水号，余额支付是自己系统生成的流水号 */
private String paySerialCode;

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
public void setPayType(Integer payType)
        {
        this.payType = payType;
        }

public Integer getPayType()
        {
        return payType;
        }
public void setPayMoney(Long payMoney)
        {
        this.payMoney = payMoney;
        }

public Long getPayMoney()
        {
        return payMoney;
        }
public void setPayTime(Integer payTime)
        {
        this.payTime = payTime;
        }

public Integer getPayTime()
        {
        return payTime;
        }
public void setPayState(Integer payState)
        {
        this.payState = payState;
        }

public Integer getPayState()
        {
        return payState;
        }
public void setNotifyTime(Integer notifyTime)
        {
        this.notifyTime = notifyTime;
        }

public Integer getNotifyTime()
        {
        return notifyTime;
        }
public void setNotifyContent(String notifyContent)
        {
        this.notifyContent = notifyContent;
        }

public String getNotifyContent()
        {
        return notifyContent;
        }
public void setPayAccount(String payAccount)
        {
        this.payAccount = payAccount;
        }

public String getPayAccount()
        {
        return payAccount;
        }
public void setPaySerialCode(String paySerialCode)
        {
        this.paySerialCode = paySerialCode;
        }

public String getPaySerialCode()
        {
        return paySerialCode;
        }

public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
	            .append("id", getId())
	            .append("memberId", getMemberId())
	            .append("payType", getPayType())
	            .append("payMoney", getPayMoney())
	            .append("payTime", getPayTime())
	            .append("payState", getPayState())
	            .append("notifyTime", getNotifyTime())
	            .append("notifyContent", getNotifyContent())
	            .append("payAccount", getPayAccount())
	            .append("paySerialCode", getPaySerialCode())
	        .toString();
        }
        }
