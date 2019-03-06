package com.yrsoft.finance.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
									
/**
 * 会员管理-垫资申请表 m_advance_apply
 *
 * @author mz
 * @date 2019-02-23
 */
public class MAdvanceApply
{
private static final long serialVersionUID = 1L;

/** 主键id */
private String id;
/** fk:会员id(会员表id） */
private String memberId;
/** 垫资金额 */
private Long rechargeAmount;
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
/** 审核类型 0：自动审核 1：人工审核 */
private Integer isAutoCheck;

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
public void setRechargeAmount(Long rechargeAmount)
        {
        this.rechargeAmount = rechargeAmount;
        }

public Long getRechargeAmount()
        {
        return rechargeAmount;
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
	            .append("memberId", getMemberId())
	            .append("rechargeAmount", getRechargeAmount())
	            .append("createTime", getCreateTime())
	            .append("checkUseId", getCheckUseId())
	            .append("checkTime", getCheckTime())
	            .append("checkStatus", getCheckStatus())
	            .append("checkAdvise", getCheckAdvise())
	            .append("isAutoCheck", getIsAutoCheck())
	        .toString();
        }
        }
