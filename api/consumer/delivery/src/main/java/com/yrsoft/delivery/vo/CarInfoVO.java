package com.yrsoft.delivery.vo;

public class CarInfoVO {
	
	/** 编号 */
	private String id;
	/** fk:车主id会员编号(会员表：编号) */
	private String memberId;
	/** 车牌号码 */
	private String carNumber;
	/** 车辆类别 ：0：自有车辆*/
	private String carTypeName="0";
	/** 车辆品牌型号 */
	private String carModel;
	/** 禁用状态（0：启用，1禁用） */
	private Integer openStop;

	//车主/司机信息
	private String nickname;//车主/司机昵称
	private String telephone;//车主/司机电话
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getCarNumber() {
		return carNumber;
	}
	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}
	public String getCarTypeName() {
		return carTypeName;
	}
	public void setCarTypeName(String carTypeName) {
		this.carTypeName = carTypeName;
	}
	public String getCarModel() {
		return carModel;
	}
	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}
	public Integer getOpenStop() {
		return openStop;
	}
	public void setOpenStop(Integer openStop) {
		this.openStop = openStop;
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
	
	
	

}
