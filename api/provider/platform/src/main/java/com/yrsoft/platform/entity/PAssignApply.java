package com.yrsoft.platform.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
										
/**
 * 货运-系统车辆分派申请表 p_assign_apply
 *
 * @author mz
 * @date 2019-02-23
 */
public class PAssignApply
{
private static final long serialVersionUID = 1L;

/** 主键id */
private String id;
/** 货运单id */
private String invoiceId;
/** 保证金支付id */
private String marginRecordsId;
/** 申请时间 */
private Integer createTime;
/** 车辆型号 */
private String carModel;
/** 需要车辆数 */
private Integer needNum;
/** 已分派车辆数 */
private Integer allotNum;
/** 已接单辆数 */
private Integer receiptNum;
/** 状态(0:等待分配 1:正在分配 2:分配完成) */
private Integer status;
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
public void setMarginRecordsId(String marginRecordsId)
        {
        this.marginRecordsId = marginRecordsId;
        }

public String getMarginRecordsId()
        {
        return marginRecordsId;
        }
public void setCreateTime(Integer createTime)
        {
        this.createTime = createTime;
        }

public Integer getCreateTime()
        {
        return createTime;
        }
public void setCarModel(String carModel)
        {
        this.carModel = carModel;
        }

public String getCarModel()
        {
        return carModel;
        }
public void setNeedNum(Integer needNum)
        {
        this.needNum = needNum;
        }

public Integer getNeedNum()
        {
        return needNum;
        }
public void setAllotNum(Integer allotNum)
        {
        this.allotNum = allotNum;
        }

public Integer getAllotNum()
        {
        return allotNum;
        }
public void setReceiptNum(Integer receiptNum)
        {
        this.receiptNum = receiptNum;
        }

public Integer getReceiptNum()
        {
        return receiptNum;
        }
public void setStatus(Integer status)
        {
        this.status = status;
        }

public Integer getStatus()
        {
        return status;
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
	            .append("marginRecordsId", getMarginRecordsId())
	            .append("createTime", getCreateTime())
	            .append("carModel", getCarModel())
	            .append("needNum", getNeedNum())
	            .append("allotNum", getAllotNum())
	            .append("receiptNum", getReceiptNum())
	            .append("status", getStatus())
	            .append("deleteFlag", getDeleteFlag())
	        .toString();
        }
        }
