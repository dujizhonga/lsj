package com.yrsoft.member.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
							
/**
 * 会员管理-货主车主关系表 bo_owner_shipper
 *
 * @author mz
 * @date 2019-02-23
 */
public class BoOwnerShipper
{
private static final long serialVersionUID = 1L;

/** 编号 */
private String id;
/** fk:货主编号（会员表：编号） */
private String shipperId;
/** fk:车主编号（会员表：编号） */
private String ownerId;
/** fk:提交人（用户表：编号） */
private String applyId;
/** 提交时间 */
private Integer time;
/** 有效状态（0：有效，1：无效） */
private Integer status;
/** 来源（0：自主关注 1：平台推荐） */
private Integer sourceState;

public void setId(String id)
        {
        this.id = id;
        }

public String getId()
        {
        return id;
        }
public void setShipperId(String shipperId)
        {
        this.shipperId = shipperId;
        }

public String getShipperId()
        {
        return shipperId;
        }
public void setOwnerId(String ownerId)
        {
        this.ownerId = ownerId;
        }

public String getOwnerId()
        {
        return ownerId;
        }
public void setApplyId(String applyId)
        {
        this.applyId = applyId;
        }

public String getApplyId()
        {
        return applyId;
        }
public void setTime(Integer time)
        {
        this.time = time;
        }

public Integer getTime()
        {
        return time;
        }
public void setStatus(Integer status)
        {
        this.status = status;
        }

public Integer getStatus()
        {
        return status;
        }
public void setSourceState(Integer sourceState)
        {
        this.sourceState = sourceState;
        }

public Integer getSourceState()
        {
        return sourceState;
        }

public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
	            .append("id", getId())
	            .append("shipperId", getShipperId())
	            .append("ownerId", getOwnerId())
	            .append("applyId", getApplyId())
	            .append("time", getTime())
	            .append("status", getStatus())
	            .append("sourceState", getSourceState())
	        .toString();
        }
        }
