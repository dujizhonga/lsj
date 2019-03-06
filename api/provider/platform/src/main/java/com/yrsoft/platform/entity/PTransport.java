package com.yrsoft.platform.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
															
/**
 * 货运-运输单表 p_transport
 *
 * @author mz
 * @date 2019-02-23
 */
public class PTransport
{
private static final long serialVersionUID = 1L;

/** 主键ID */
private String id;
/** 运单id(fk:运单) */
private String waybillId;
/** 司机id(fk:会员) */
private String driverId;
/** 司机确认更换驾驶（0：不确认，1：确认） */
private Integer changeDriving;
/** 创建时间 */
private Integer createTime;
/** 开始时间 */
private Integer startTime;
/** 开始地点 */
private String startAddress;
/** 开始经度 */
private String startLongitude;
/** 开始纬度 */
private String startLatitude;
/** 结束时间 */
private Integer endTime;
/** 结束地点 */
private String endAddress;
/** 结束经度 */
private String endLongitude;
/** 结束纬度 */
private String endLatitude;
/** 有效标志（0：有效，1：无效） */
private Integer isEffective;
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
public void setWaybillId(String waybillId)
        {
        this.waybillId = waybillId;
        }

public String getWaybillId()
        {
        return waybillId;
        }
public void setDriverId(String driverId)
        {
        this.driverId = driverId;
        }

public String getDriverId()
        {
        return driverId;
        }
public void setChangeDriving(Integer changeDriving)
        {
        this.changeDriving = changeDriving;
        }

public Integer getChangeDriving()
        {
        return changeDriving;
        }
public void setCreateTime(Integer createTime)
        {
        this.createTime = createTime;
        }

public Integer getCreateTime()
        {
        return createTime;
        }
public void setStartTime(Integer startTime)
        {
        this.startTime = startTime;
        }

public Integer getStartTime()
        {
        return startTime;
        }
public void setStartAddress(String startAddress)
        {
        this.startAddress = startAddress;
        }

public String getStartAddress()
        {
        return startAddress;
        }
public void setStartLongitude(String startLongitude)
        {
        this.startLongitude = startLongitude;
        }

public String getStartLongitude()
        {
        return startLongitude;
        }
public void setStartLatitude(String startLatitude)
        {
        this.startLatitude = startLatitude;
        }

public String getStartLatitude()
        {
        return startLatitude;
        }
public void setEndTime(Integer endTime)
        {
        this.endTime = endTime;
        }

public Integer getEndTime()
        {
        return endTime;
        }
public void setEndAddress(String endAddress)
        {
        this.endAddress = endAddress;
        }

public String getEndAddress()
        {
        return endAddress;
        }
public void setEndLongitude(String endLongitude)
        {
        this.endLongitude = endLongitude;
        }

public String getEndLongitude()
        {
        return endLongitude;
        }
public void setEndLatitude(String endLatitude)
        {
        this.endLatitude = endLatitude;
        }

public String getEndLatitude()
        {
        return endLatitude;
        }
public void setIsEffective(Integer isEffective)
        {
        this.isEffective = isEffective;
        }

public Integer getIsEffective()
        {
        return isEffective;
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
	            .append("waybillId", getWaybillId())
	            .append("driverId", getDriverId())
	            .append("changeDriving", getChangeDriving())
	            .append("createTime", getCreateTime())
	            .append("startTime", getStartTime())
	            .append("startAddress", getStartAddress())
	            .append("startLongitude", getStartLongitude())
	            .append("startLatitude", getStartLatitude())
	            .append("endTime", getEndTime())
	            .append("endAddress", getEndAddress())
	            .append("endLongitude", getEndLongitude())
	            .append("endLatitude", getEndLatitude())
	            .append("isEffective", getIsEffective())
	            .append("deleteFlag", getDeleteFlag())
	        .toString();
        }
        }
