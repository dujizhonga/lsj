package com.yrsoft.system.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
										
/**
 * 系统-数据字典表 s_data
 *
 * @author mz
 * @date 2019-02-23
 */
public class SData
{
private static final long serialVersionUID = 1L;

/** 主键 */
private String id;
/** 数据名称(如：男） */
private String dataName;
/** 数据值(如：1) */
private String dataValue;
/** 状态（0-启用 1-停用 ) */
private String status;
/** 顺序 */
private String sort;
/** 数据类型编码 */
private String dataType;
/** 创建时间 */
private Integer createTime;
/** 更新时间 */
private Integer updateTime;
/** 父类主键(说明：第一级为0) */
private String parentId;
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
public void setDataName(String dataName)
        {
        this.dataName = dataName;
        }

public String getDataName()
        {
        return dataName;
        }
public void setDataValue(String dataValue)
        {
        this.dataValue = dataValue;
        }

public String getDataValue()
        {
        return dataValue;
        }
public void setStatus(String status)
        {
        this.status = status;
        }

public String getStatus()
        {
        return status;
        }
public void setSort(String sort)
        {
        this.sort = sort;
        }

public String getSort()
        {
        return sort;
        }
public void setDataType(String dataType)
        {
        this.dataType = dataType;
        }

public String getDataType()
        {
        return dataType;
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
public void setParentId(String parentId)
        {
        this.parentId = parentId;
        }

public String getParentId()
        {
        return parentId;
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
	            .append("dataName", getDataName())
	            .append("dataValue", getDataValue())
	            .append("status", getStatus())
	            .append("sort", getSort())
	            .append("dataType", getDataType())
	            .append("createTime", getCreateTime())
	            .append("updateTime", getUpdateTime())
	            .append("parentId", getParentId())
	            .append("deleteFlag", getDeleteFlag())
	        .toString();
        }
        }
