package com.yrsoft.platform.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
											
/**
 * 货运-保证金退款申请表 p_margin_refund
 *
 * @author mz
 * @date 2019-02-23
 */
public class PMarginRefund
{
private static final long serialVersionUID = 1L;

/** 主键ID */
private String id;
/** 分派申请记录id */
private String assignApplyId;
/** 货主id */
private String shipperId;
/** 保证金退还金额(单位：分) */
private Long refundAmount;
/** 申请提款原因 */
private String refundReason;
/** 创建时间 */
private Integer createTime;
/** fk:员工id(o_staff表id） */
private String checkUseId;
/** 充值时间 */
private Integer checkTime;
/** 审核状态 0：待审核 1：审核通过 2：审核拒绝 */
private Integer checkStatus;
/** 审核意见 */
private String checkAdvise;
/** 审核类型 0：人工审核 1：自动审核 */
private Integer isAutoCheck;

public void setId(String id)
        {
        this.id = id;
        }

public String getId()
        {
        return id;
        }
public void setAssignApplyId(String assignApplyId)
        {
        this.assignApplyId = assignApplyId;
        }

public String getAssignApplyId()
        {
        return assignApplyId;
        }
public void setShipperId(String shipperId)
        {
        this.shipperId = shipperId;
        }

public String getShipperId()
        {
        return shipperId;
        }
public void setRefundAmount(Long refundAmount)
        {
        this.refundAmount = refundAmount;
        }

public Long getRefundAmount()
        {
        return refundAmount;
        }
public void setRefundReason(String refundReason)
        {
        this.refundReason = refundReason;
        }

public String getRefundReason()
        {
        return refundReason;
        }
public void setCreateTime(Integer createTime)
        {
        this.createTime = createTime;
        }

public Integer getCreateTime()
        {
        return createTime;
        }
public void setCheckUseId(String checkUseId)
        {
        this.checkUseId = checkUseId;
        }

public String getCheckUseId()
        {
        return checkUseId;
        }
public void setCheckTime(Integer checkTime)
        {
        this.checkTime = checkTime;
        }

public Integer getCheckTime()
        {
        return checkTime;
        }
public void setCheckStatus(Integer checkStatus)
        {
        this.checkStatus = checkStatus;
        }

public Integer getCheckStatus()
        {
        return checkStatus;
        }
public void setCheckAdvise(String checkAdvise)
        {
        this.checkAdvise = checkAdvise;
        }

public String getCheckAdvise()
        {
        return checkAdvise;
        }
public void setIsAutoCheck(Integer isAutoCheck)
        {
        this.isAutoCheck = isAutoCheck;
        }

public Integer getIsAutoCheck()
        {
        return isAutoCheck;
        }

public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
	            .append("id", getId())
	            .append("assignApplyId", getAssignApplyId())
	            .append("shipperId", getShipperId())
	            .append("refundAmount", getRefundAmount())
	            .append("refundReason", getRefundReason())
	            .append("createTime", getCreateTime())
	            .append("checkUseId", getCheckUseId())
	            .append("checkTime", getCheckTime())
	            .append("checkStatus", getCheckStatus())
	            .append("checkAdvise", getCheckAdvise())
	            .append("isAutoCheck", getIsAutoCheck())
	        .toString();
        }
        }
