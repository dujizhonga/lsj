package com.yrsoft.delivery.vo;

public class PcpCarVO {
	/** 主键id(与车辆id相同) */
	private String id;
	/** 坐标经度 */
	private String lng;
	/** 坐标纬度 */
	private String lat;
	/** 更新时间 */
	private String updateTime;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLng() {
		return lng;
	}
	public void setLng(String lng) {
		this.lng = lng;
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	@Override
	public String toString() {
		return "PcpCarVO [id=" + id + ", lng=" + lng + ", lat=" + lat + ", updateTime=" + updateTime + ", getId()="
				+ getId() + ", getLng()=" + getLng() + ", getLat()=" + getLat() + ", getUpdateTime()=" + getUpdateTime()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	

}
