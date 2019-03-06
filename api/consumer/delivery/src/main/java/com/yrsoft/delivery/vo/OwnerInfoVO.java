package com.yrsoft.delivery.vo;

public class OwnerInfoVO {
	/** 
	 * 编号 
	 */
	private String id;
	/** 
	 * fk:货主编号（会员表：编号） 
	 * 
	 */
	private String shipperId;
	/** 
	 * fk:车主编号（会员表：编号）
	 * 
	 */
	private String ownerId;
	/**
	 * 有效状态（0：有效，1：无效） 
	 * 
	 */
	private Integer status;
	/**
	 * 昵称 
	 * 
	 */
	private String nickname;
	/**
	 * 电话
	 * 
	 */
	private String telephone;
	/**
	 * 车辆数 
	 * 
	 */
	private Integer carCount;
	/**
	 * 运单数量
	 * 
	 */
	private Integer waybillCount;
	private String waybillNumber;
	private String ownerName;
	private String carNumber;
	private String flag;
	private String waybillState;
	private String actualFreight;
	public String getWaybillNumber() {
		return waybillNumber;
	}
	public void setWaybillNumber(String waybillNumber) {
		this.waybillNumber = waybillNumber;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getCarNumber() {
		return carNumber;
	}
	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public String getWaybillState() {
		return waybillState;
	}
	public void setWaybillState(String waybillState) {
		this.waybillState = waybillState;
	}
	public String getActualFreight() {
		return actualFreight;
	}
	public void setActualFreight(String actualFreight) {
		this.actualFreight = actualFreight;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getShipperId() {
		return shipperId;
	}
	public void setShipperId(String shipperId) {
		this.shipperId = shipperId;
	}
	public String getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public Integer getCarCount() {
		return carCount;
	}
	public void setCarCount(Integer carCount) {
		this.carCount = carCount;
	}
	public Integer getWaybillCount() {
		return waybillCount;
	}
	public void setWaybillCount(Integer waybillCount) {
		this.waybillCount = waybillCount;
	}
	
}
