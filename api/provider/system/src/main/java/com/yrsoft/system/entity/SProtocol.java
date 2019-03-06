package com.yrsoft.system.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
									
/**
 * 系统-协议表 s_protocol
 *
 * @author mz
 * @date 2019-02-23
 */
public class SProtocol
{
private static final long serialVersionUID = 1L;

/** 主键id */
private String id;
/** 显示端 1：货主pc，2：货主app，3：车主app，4：油站 */
private Integer showSite;
/** 类型 0-投保须知 1-运输合同 2-用户协议 */
private Integer flag;
/** 协议副文本 */
private String protocolCopy;
/** 操作人id */
private String operatorId;
/** 创建时间 */
private Integer createTime;
/** 更新时间 */
private Integer updateTime;
/** 状态（0-启用 1-停用 ) */
private String status;
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
public void setShowSite(Integer showSite)
        {
        this.showSite = showSite;
        }

public Integer getShowSite()
        {
        return showSite;
        }
public void setFlag(Integer flag)
        {
        this.flag = flag;
        }

public Integer getFlag()
        {
        return flag;
        }
public void setProtocolCopy(String protocolCopy)
        {
        this.protocolCopy = protocolCopy;
        }

public String getProtocolCopy()
        {
        return protocolCopy;
        }
public void setOperatorId(String operatorId)
        {
        this.operatorId = operatorId;
        }

public String getOperatorId()
        {
        return operatorId;
        }
public void setCreateTime(Integer createTime)
        {
        this.createTime = createTime;
        }

public Integer getCreateTime()
        {
        return createTime;
        }
public void setUpdateTime(Integer updateTime)
        {
        this.updateTime = updateTime;
        }

public Integer getUpdateTime()
        {
        return updateTime;
        }
public void setStatus(String status)
        {
        this.status = status;
        }

public String getStatus()
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
	            .append("showSite", getShowSite())
	            .append("flag", getFlag())
	            .append("protocolCopy", getProtocolCopy())
	            .append("operatorId", getOperatorId())
	            .append("createTime", getCreateTime())
	            .append("updateTime", getUpdateTime())
	            .append("status", getStatus())
	            .append("deleteFlag", getDeleteFlag())
	        .toString();
        }
        }
