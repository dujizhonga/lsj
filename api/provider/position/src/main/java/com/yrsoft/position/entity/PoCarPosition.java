package com.yrsoft.position.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
				
/**
 * 位置-车辆位置及状态表 po_car_position
 *
 * @author mz
 * @date 2019-02-23
 */
public class PoCarPosition
{
private static final long serialVersionUID = 1L;

/** 主键id(与车辆id相同) */
private String id;
/** 坐标经度 */
private String lng;
/** 坐标纬度 */
private String lat;
/** 更新时间 */
private String updateTime;

public void setId(String id)
        {
        this.id = id;
        }

public String getId()
        {
        return id;
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
public void setUpdateTime(String updateTime)
        {
        this.updateTime = updateTime;
        }

public String getUpdateTime()
        {
        return updateTime;
        }

public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
	            .append("id", getId())
	            .append("lng", getLng())
	            .append("lat", getLat())
	            .append("updateTime", getUpdateTime())
	        .toString();
        }
        }
