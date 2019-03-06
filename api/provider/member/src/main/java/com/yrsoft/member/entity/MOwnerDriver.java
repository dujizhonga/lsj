package com.yrsoft.member.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
						
/**
 * 会员管理-车主司机关系表 m_owner_driver
 *
 * @author mz
 * @date 2019-02-23
 */
public class MOwnerDriver
{
private static final long serialVersionUID = 1L;

/** 编号 */
private String id;
/** fk:车主id（会员表，编号） */
private String ownerId;
/** fk:司机id（会员表，编号） */
private String driverId;
/** 创建时间 */
private Integer createTime;
/** 删除标志(0：未删除，1：已删除) */
private Integer deleteFlag;
/** 是否确认(0：未确认，1：已确认) */
private Integer agree;

public void setId(String id)
        {
        this.id = id;
        }

public String getId()
        {
        return id;
        }
public void setOwnerId(String ownerId)
        {
        this.ownerId = ownerId;
        }

public String getOwnerId()
        {
        return ownerId;
        }
public void setDriverId(String driverId)
        {
        this.driverId = driverId;
        }

public String getDriverId()
        {
        return driverId;
        }
public void setCreateTime(Integer createTime)
        {
        this.createTime = createTime;
        }

public Integer getCreateTime()
        {
        return createTime;
        }
public void setDeleteFlag(Integer deleteFlag)
        {
        this.deleteFlag = deleteFlag;
        }

public Integer getDeleteFlag()
        {
        return deleteFlag;
        }
public void setAgree(Integer agree)
        {
        this.agree = agree;
        }

public Integer getAgree()
        {
        return agree;
        }

public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
	            .append("id", getId())
	            .append("ownerId", getOwnerId())
	            .append("driverId", getDriverId())
	            .append("createTime", getCreateTime())
	            .append("deleteFlag", getDeleteFlag())
	            .append("agree", getAgree())
	        .toString();
        }
        }
