package com.yrsoft.tripartite.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 认证管理-车辆认证表 a_car
 *
 * @author mz
 * @date 2019-02-23
 */
public class Car {
	private static final long serialVersionUID = 1L;

	/** 编号 */
	private String id;
	/** fk:车主id会员编号(会员表：编号) */
	private String memberId;
	/** 默认司机1 id member外键 */
	private String driver1Id;
	/** 默认司机2 id member外键 */
	private String driver2Id;
	/** 所有人姓名 */
	private String ownerName;
	/** 车牌号码 */
	private String carNumber;
	/** 机动车行驶证正本图片 */
	private String runCertificateImg;
	/** 机动车行驶证副本图片 */
	private String runCertificateImg2;
	/** 道路运输证图片 */
	private String transportCertificateImg;
	/** 车辆类别 */
	private String carTypeName;
	/** 燃油类别(0:柴油，1:天然气，3:无) */
	private Integer fuelType;
	/** 整备质量 */
	private String setupWeight;
	/** 总质量 */
	private String towWeight;
	/** 准牵引总质量/核定载重 */
	private String totalTractionWeight;
	/** 长度 */
	private String length;
	/** 宽度 */
	private String width;
	/** 高度 */
	private String height;
	/** 车辆品牌型号 */
	private String carModel;
	/** 发动机号码 */
	private String engineNum;
	/** 发证日期 */
	private String certificateTime;
	/** 报废日期 */
	private String scrapTime;
	/** 经营许可证号 */
	private String businessLicense;
	/** 道路运输证号 */
	private String transportLicense;
	/** 车辆识别代号 */
	private String carVin;
	/** 车辆认证状态（0：待审核，1：审核通过，2：审核拒绝） */
	private Integer status;
	/** 创建时间 */
	private Integer createTime;
	/** 0:新申请;1:旧申请 */
	private Integer newFlag;
	/** 审核时间 */
	private Integer checkTime;
	/** fk:审核人(员工表：编号) */
	private String checkUser;
	/** 审核意见 */
	private String description;
	/** 是否系统审核 默认0否，1是 */
	private Integer isSys;
	/** 车辆运货状态（0：空闲；1：等待运货；2：运货中） */
	private Integer runStatus;
	/** 禁用状态（0：启用，1禁用） */
	private Integer openStop;
	/** 是否佬司机原有数据（0：是 ，1：否） */
	private Integer isLsjData;
	/** 备案状态（0.未备案 1.已备案） */
	private Integer recordState;
	/** 注册日期 */
	private String registerTime;
	/** 车辆类型 0-半挂 1-全挂 */
	private Integer carType;
	/** ETC 状态 (0:未开通 1：已开通) */
	private Integer etcState;
	/** 删除状态(0：未删除，1：已删除) */
	private Integer deleteFlag;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setDriver1Id(String driver1Id) {
		this.driver1Id = driver1Id;
	}

	public String getDriver1Id() {
		return driver1Id;
	}

	public void setDriver2Id(String driver2Id) {
		this.driver2Id = driver2Id;
	}

	public String getDriver2Id() {
		return driver2Id;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}

	public String getCarNumber() {
		return carNumber;
	}

	public void setRunCertificateImg(String runCertificateImg) {
		this.runCertificateImg = runCertificateImg;
	}

	public String getRunCertificateImg() {
		return runCertificateImg;
	}

	public void setRunCertificateImg2(String runCertificateImg2) {
		this.runCertificateImg2 = runCertificateImg2;
	}

	public String getRunCertificateImg2() {
		return runCertificateImg2;
	}

	public void setTransportCertificateImg(String transportCertificateImg) {
		this.transportCertificateImg = transportCertificateImg;
	}

	public String getTransportCertificateImg() {
		return transportCertificateImg;
	}

	public void setCarTypeName(String carTypeName) {
		this.carTypeName = carTypeName;
	}

	public String getCarTypeName() {
		return carTypeName;
	}

	public void setFuelType(Integer fuelType) {
		this.fuelType = fuelType;
	}

	public Integer getFuelType() {
		return fuelType;
	}

	public void setSetupWeight(String setupWeight) {
		this.setupWeight = setupWeight;
	}

	public String getSetupWeight() {
		return setupWeight;
	}

	public void setTowWeight(String towWeight) {
		this.towWeight = towWeight;
	}

	public String getTowWeight() {
		return towWeight;
	}

	public void setTotalTractionWeight(String totalTractionWeight) {
		this.totalTractionWeight = totalTractionWeight;
	}

	public String getTotalTractionWeight() {
		return totalTractionWeight;
	}

	public void setLength(String length) {
		this.length = length;
	}

	public String getLength() {
		return length;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public String getWidth() {
		return width;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getHeight() {
		return height;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public String getCarModel() {
		return carModel;
	}

	public void setEngineNum(String engineNum) {
		this.engineNum = engineNum;
	}

	public String getEngineNum() {
		return engineNum;
	}

	public void setCertificateTime(String certificateTime) {
		this.certificateTime = certificateTime;
	}

	public String getCertificateTime() {
		return certificateTime;
	}

	public void setScrapTime(String scrapTime) {
		this.scrapTime = scrapTime;
	}

	public String getScrapTime() {
		return scrapTime;
	}

	public void setBusinessLicense(String businessLicense) {
		this.businessLicense = businessLicense;
	}

	public String getBusinessLicense() {
		return businessLicense;
	}

	public void setTransportLicense(String transportLicense) {
		this.transportLicense = transportLicense;
	}

	public String getTransportLicense() {
		return transportLicense;
	}

	public void setCarVin(String carVin) {
		this.carVin = carVin;
	}

	public String getCarVin() {
		return carVin;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getStatus() {
		return status;
	}

	public void setCreateTime(Integer createTime) {
		this.createTime = createTime;
	}

	public Integer getCreateTime() {
		return createTime;
	}

	public void setNewFlag(Integer newFlag) {
		this.newFlag = newFlag;
	}

	public Integer getNewFlag() {
		return newFlag;
	}

	public void setCheckTime(Integer checkTime) {
		this.checkTime = checkTime;
	}

	public Integer getCheckTime() {
		return checkTime;
	}

	public void setCheckUser(String checkUser) {
		this.checkUser = checkUser;
	}

	public String getCheckUser() {
		return checkUser;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setIsSys(Integer isSys) {
		this.isSys = isSys;
	}

	public Integer getIsSys() {
		return isSys;
	}

	public void setRunStatus(Integer runStatus) {
		this.runStatus = runStatus;
	}

	public Integer getRunStatus() {
		return runStatus;
	}

	public void setOpenStop(Integer openStop) {
		this.openStop = openStop;
	}

	public Integer getOpenStop() {
		return openStop;
	}

	public void setIsLsjData(Integer isLsjData) {
		this.isLsjData = isLsjData;
	}

	public Integer getIsLsjData() {
		return isLsjData;
	}

	public void setRecordState(Integer recordState) {
		this.recordState = recordState;
	}

	public Integer getRecordState() {
		return recordState;
	}

	public void setRegisterTime(String registerTime) {
		this.registerTime = registerTime;
	}

	public String getRegisterTime() {
		return registerTime;
	}

	public void setCarType(Integer carType) {
		this.carType = carType;
	}

	public Integer getCarType() {
		return carType;
	}

	public void setEtcState(Integer etcState) {
		this.etcState = etcState;
	}

	public Integer getEtcState() {
		return etcState;
	}

	public void setDeleteFlag(Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public Integer getDeleteFlag() {
		return deleteFlag;
	}

	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).append("id", getId())
				.append("memberId", getMemberId()).append("driver1Id", getDriver1Id())
				.append("driver2Id", getDriver2Id()).append("ownerName", getOwnerName())
				.append("carNumber", getCarNumber()).append("runCertificateImg", getRunCertificateImg())
				.append("runCertificateImg2", getRunCertificateImg2())
				.append("transportCertificateImg", getTransportCertificateImg()).append("carTypeName", getCarTypeName())
				.append("fuelType", getFuelType()).append("setupWeight", getSetupWeight())
				.append("towWeight", getTowWeight()).append("totalTractionWeight", getTotalTractionWeight())
				.append("length", getLength()).append("width", getWidth()).append("height", getHeight())
				.append("carModel", getCarModel()).append("engineNum", getEngineNum())
				.append("certificateTime", getCertificateTime()).append("scrapTime", getScrapTime())
				.append("businessLicense", getBusinessLicense()).append("transportLicense", getTransportLicense())
				.append("carVin", getCarVin()).append("status", getStatus()).append("createTime", getCreateTime())
				.append("newFlag", getNewFlag()).append("checkTime", getCheckTime()).append("checkUser", getCheckUser())
				.append("description", getDescription()).append("isSys", getIsSys()).append("runStatus", getRunStatus())
				.append("openStop", getOpenStop()).append("isLsjData", getIsLsjData())
				.append("recordState", getRecordState()).append("registerTime", getRegisterTime())
				.append("carType", getCarType()).append("etcState", getEtcState()).append("deleteFlag", getDeleteFlag())
				.toString();
	}
}
