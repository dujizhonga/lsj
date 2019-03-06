package com.yrsoft.position.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
					
/**
 * 位置-车辆历史位置坐标表 po_car_position_log
 *
 * @author mz
 * @date 2019-02-23
 */
public class PoCarPositionLog
{
private static final long serialVersionUID = 1L;

/** 主键id */
private String id;
/** 车辆id */
private String carId;
/** 坐标经度 */
private String lng;
/** 坐标纬度 */
private String lat;
/** 记录时间 */
private Integer time;

public void setId(String id)
        {
        this.id = id;
        }

public String getId()
        {
        return id;
        }
public void setCarId(String carId)
        {
        this.carId = carId;
        }

public String getCarId()
        {
        return carId;
        }
public void setLng(String lng)
        {
        this.lng = lng;
        }

public String getLng()
        {
        return lng;
        }
public void setLat(String lat)
        {
        this.lat = lat;
        }

public String getLat()
        {
        return lat;
        }
public void setTime(Integer time)
        {
        this.time = time;
        }

public Integer getTime()
        {
        return time;
        }

public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
	            .append("id", getId())
	            .append("carId", getCarId())
	            .append("lng", getLng())
	            .append("lat", getLat())
	            .append("time", getTime())
	        .toString();
        }
        }
