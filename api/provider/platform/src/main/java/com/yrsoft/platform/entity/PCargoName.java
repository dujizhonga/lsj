package com.yrsoft.platform.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
							
/**
 * 货运-货物名称表 p_cargo_name
 *
 * @author mz
 * @date 2019-02-23
 */
public class PCargoName
{
private static final long serialVersionUID = 1L;

/** 主键id */
private String id;
/** 货物类型id */
private String cargoTypeId;
/** 货物名称 */
private String name;
/** 创建时间 */
private Integer createTime;
/** 修改时间 */
private Integer updateTime;
/** 操作人 */
private String operatorId;
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
public void setCargoTypeId(String cargoTypeId)
        {
        this.cargoTypeId = cargoTypeId;
        }

public String getCargoTypeId()
        {
        return cargoTypeId;
        }
public void setName(String name)
        {
        this.name = name;
        }

public String getName()
        {
        return name;
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
public void setOperatorId(String operatorId)
        {
        this.operatorId = operatorId;
        }

public String getOperatorId()
        {
        return operatorId;
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
	            .append("cargoTypeId", getCargoTypeId())
	            .append("name", getName())
	            .append("createTime", getCreateTime())
	            .append("updateTime", getUpdateTime())
	            .append("operatorId", getOperatorId())
	            .append("deleteFlag", getDeleteFlag())
	        .toString();
        }
        }
