package com.yrsoft.platform.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
							
/**
 * 渤海保险承保记录表 p_bohai_insurance_log
 *
 * @author mz
 * @date 2019-03-06
 */
public class PBohaiInsuranceLog
{
private static final long serialVersionUID = 1L;

/**  */
private String id;
/** 运单号 */
private String orderCode;
/** 承保人ID */
private String memberId;
/** 核保返回结果 */
private String insurancStep1Xml;
/** 承保返回结果 */
private String insurancStep2Xml;
/** 1-成功，2-失败 */
private Integer insuranceStep1Status;
/** 1-成功，2-失败 */
private Integer insuranceStep2Status;

public void setId(String id)
        {
        this.id = id;
        }

public String getId()
        {
        return id;
        }
public void setOrderCode(String orderCode)
        {
        this.orderCode = orderCode;
        }

public String getOrderCode()
        {
        return orderCode;
        }
public void setMemberId(String memberId)
        {
        this.memberId = memberId;
        }

public String getMemberId()
        {
        return memberId;
        }
public void setInsurancStep1Xml(String insurancStep1Xml)
        {
        this.insurancStep1Xml = insurancStep1Xml;
        }

public String getInsurancStep1Xml()
        {
        return insurancStep1Xml;
        }
public void setInsurancStep2Xml(String insurancStep2Xml)
        {
        this.insurancStep2Xml = insurancStep2Xml;
        }

public String getInsurancStep2Xml()
        {
        return insurancStep2Xml;
        }
public void setInsuranceStep1Status(Integer insuranceStep1Status)
        {
        this.insuranceStep1Status = insuranceStep1Status;
        }

public Integer getInsuranceStep1Status()
        {
        return insuranceStep1Status;
        }
public void setInsuranceStep2Status(Integer insuranceStep2Status)
        {
        this.insuranceStep2Status = insuranceStep2Status;
        }

public Integer getInsuranceStep2Status()
        {
        return insuranceStep2Status;
        }

public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
	            .append("id", getId())
	            .append("orderCode", getOrderCode())
	            .append("memberId", getMemberId())
	            .append("insurancStep1Xml", getInsurancStep1Xml())
	            .append("insurancStep2Xml", getInsurancStep2Xml())
	            .append("insuranceStep1Status", getInsuranceStep1Status())
	            .append("insuranceStep2Status", getInsuranceStep2Status())
	        .toString();
        }
        }
