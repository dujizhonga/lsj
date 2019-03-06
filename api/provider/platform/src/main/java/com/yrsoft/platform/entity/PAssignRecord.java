package com.yrsoft.platform.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
												
/**
 * 货运-分派记录表 p_assign_record
 *
 * @author mz
 * @date 2019-02-23
 */
public class PAssignRecord
{
private static final long serialVersionUID = 1L;

/** 主键id */
private String id;
/** 货运单id */
private String invoiceId;
/** fk:分派申请id */
private String applyId;
/** fk:分派车辆id */
private String carId;
/** 运单类型 0：指派单 1：系统单 */
private Integer waybillType;
/** 运单编号 */
private String waybillNum;
/** 创建时间 */
private Integer createTime;
/** 是否已被接：0未接，1已接  2已拒绝 */
private Integer isReceipt;
/** 过期状态 0：正常  1：过期 */
private Integer overdueStatus;
/** 是否自动（0-是 1-否） */
private Integer isAuto;
/** 响应时间 */
private Integer responseTime;
/** 删除状态（0：未删除，1：已删除） */
private Integer deleteFlag;

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
public void setApplyId(String applyId)
        {
        this.applyId = applyId;
        }

public String getApplyId()
        {
        return applyId;
        }
public void setCarId(String carId)
        {
        this.carId = carId;
        }

public String getCarId()
        {
        return carId;
        }
public void setWaybillType(Integer waybillType)
        {
        this.waybillType = waybillType;
        }

public Integer getWaybillType()
        {
        return waybillType;
        }
public void setWaybillNum(String waybillNum)
        {
        this.waybillNum = waybillNum;
        }

public String getWaybillNum()
        {
        return waybillNum;
        }
public void setCreateTime(Integer createTime)
        {
        this.createTime = createTime;
        }

public Integer getCreateTime()
        {
        return createTime;
        }
public void setIsReceipt(Integer isReceipt)
        {
        this.isReceipt = isReceipt;
        }

public Integer getIsReceipt()
        {
        return isReceipt;
        }
public void setOverdueStatus(Integer overdueStatus)
        {
        this.overdueStatus = overdueStatus;
        }

public Integer getOverdueStatus()
        {
        return overdueStatus;
        }
public void setIsAuto(Integer isAuto)
        {
        this.isAuto = isAuto;
        }

public Integer getIsAuto()
        {
        return isAuto;
        }
public void setResponseTime(Integer responseTime)
        {
        this.responseTime = responseTime;
        }

public Integer getResponseTime()
        {
        return responseTime;
        }
public void setDeleteFlag(Integer deleteFlag)
        {
        this.deleteFlag = deleteFlag;
        }

public Integer getDeleteFlag()
        {
        return deleteFlag;
        }

public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
	            .append("id", getId())
	            .append("invoiceId", getInvoiceId())
	            .append("applyId", getApplyId())
	            .append("carId", getCarId())
	            .append("waybillType", getWaybillType())
	            .append("waybillNum", getWaybillNum())
	            .append("createTime", getCreateTime())
	            .append("isReceipt", getIsReceipt())
	            .append("overdueStatus", getOverdueStatus())
	            .append("isAuto", getIsAuto())
	            .append("responseTime", getResponseTime())
	            .append("deleteFlag", getDeleteFlag())
	        .toString();
        }
        }
