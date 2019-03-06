package com.yrsoft.truck.vo;


																																							
/**
 * 认证管理-车辆认证表 a_car
 *
 * @author mz
 * @date 2019-02-23
 */
public class CarInfoVO
{

/** 编号 */
private String id;
/** fk:车主id会员编号(会员表：编号) */
private String memberId;
/** 默认司机1 id  member外键 */
private String driver1Id;
/** 所有人姓名 */
private String ownerName;
/** 车牌号码 */
private String carNumber;
/** 车辆类别 */
private String carTypeName;
/** 燃油类别(0:柴油，1:天然气，3:无) */
private Integer fuelType;
/** 總質量 */
private String towWeight;
/** 准牵引总质量/核定载重 */
private String totalTractionWeight;
/** 车辆品牌型号 */
private String carModel;
/** 车辆识别代号 */
private String carVin;
/** 车辆运货状态（0：空闲；1：等待运货；2：运货中） */
private Integer runStatus;
/** 车辆类型 0-半挂 1-全挂 */
private Integer carType;
/** ETC 状态  (0:未开通 1：已开通) */
private Integer etcState;
/** 删除状态(0：未删除，1：已删除) */
private Integer deleteFlag;

public String getTowWeight() {
	return towWeight;
}
public void setTowWeight(String towWeight) {
	this.towWeight = towWeight;
}
//司机信息
private String realName;//司机昵称
private String telephone;//司机电话
private String lng;//坐标经度
private String lat;//坐标纬度

public String getRealName() {
	return realName;
}
public void setRealName(String realName) {
	this.realName = realName;
}
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
public String getDriver1Id() {
	return driver1Id;
}
public void setDriver1Id(String driver1Id) {
	this.driver1Id = driver1Id;
}
public String getOwnerName() {
	return ownerName;
}
public void setOwnerName(String ownerName) {
	this.ownerName = ownerName;
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
public Integer getFuelType() {
	return fuelType;
}
public void setFuelType(Integer fuelType) {
	this.fuelType = fuelType;
}
public String getTotalTractionWeight() {
	return totalTractionWeight;
}
public void setTotalTractionWeight(String totalTractionWeight) {
	this.totalTractionWeight = totalTractionWeight;
}
public String getCarModel() {
	return carModel;
}
public void setCarModel(String carModel) {
	this.carModel = carModel;
}
public String getCarVin() {
	return carVin;
}
public void setCarVin(String carVin) {
	this.carVin = carVin;
}
public Integer getRunStatus() {
	return runStatus;
}
public void setRunStatus(Integer runStatus) {
	this.runStatus = runStatus;
}
public Integer getCarType() {
	return carType;
}
public void setCarType(Integer carType) {
	this.carType = carType;
}
public Integer getEtcState() {
	return etcState;
}
public void setEtcState(Integer etcState) {
	this.etcState = etcState;
}
public Integer getDeleteFlag() {
	return deleteFlag;
}
public void setDeleteFlag(Integer deleteFlag) {
	this.deleteFlag = deleteFlag;
}
public String getTelephone() {
	return telephone;
}
public void setTelephone(String telephone) {
	this.telephone = telephone;
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
@Override
public String toString() {
	return "CarInfoVO [id=" + id + ", memberId=" + memberId + ", driver1Id=" + driver1Id + ", ownerName=" + ownerName
			+ ", carNumber=" + carNumber + ", carTypeName=" + carTypeName + ", fuelType=" + fuelType + ", towWeight="
			+ towWeight + ", totalTractionWeight=" + totalTractionWeight + ", carModel=" + carModel + ", carVin="
			+ carVin + ", runStatus=" + runStatus + ", carType=" + carType + ", etcState=" + etcState + ", deleteFlag="
			+ deleteFlag + ", realName=" + realName + ", telephone=" + telephone + ", lng=" + lng + ", lat=" + lat
			+ "]";
}


       }
