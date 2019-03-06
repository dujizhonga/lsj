package com.yrsoft.delivery.vo;
/**
 * 查证车主信息列表VO
 *
 * @author Yxq
 * @date 2019/2/27
 */
public class OwnerInfoListVO {
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
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
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
