package com.yrsoft.delivery.vo;

public class SysCarVO {
	/** 编号 */
	private String id;
	/** fk:车主id会员编号(会员表：编号) */
	private String memberId;
	/** 默认司机1 id  member外键 */
	private String driver1Id;
	/** 默认司机2 id  member外键 */
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
	/** ETC 状态  (0:未开通 1：已开通) */
	private Integer etcState;
	/** 删除状态(0：未删除，1：已删除) */
	private Integer deleteFlag;
	/** 坐标经度 */
	private String lng;
	/** 坐标纬度 */
	private String lat;
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
	public String getDriver2Id() {
		return driver2Id;
	}
	public void setDriver2Id(String driver2Id) {
		this.driver2Id = driver2Id;
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
	public String getRunCertificateImg() {
		return runCertificateImg;
	}
	public void setRunCertificateImg(String runCertificateImg) {
		this.runCertificateImg = runCertificateImg;
	}
	public String getRunCertificateImg2() {
		return runCertificateImg2;
	}
	public void setRunCertificateImg2(String runCertificateImg2) {
		this.runCertificateImg2 = runCertificateImg2;
	}
	public String getTransportCertificateImg() {
		return transportCertificateImg;
	}
	public void setTransportCertificateImg(String transportCertificateImg) {
		this.transportCertificateImg = transportCertificateImg;
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
	public String getSetupWeight() {
		return setupWeight;
	}
	public void setSetupWeight(String setupWeight) {
		this.setupWeight = setupWeight;
	}
	public String getTowWeight() {
		return towWeight;
	}
	public void setTowWeight(String towWeight) {
		this.towWeight = towWeight;
	}
	public String getTotalTractionWeight() {
		return totalTractionWeight;
	}
	public void setTotalTractionWeight(String totalTractionWeight) {
		this.totalTractionWeight = totalTractionWeight;
	}
	public String getLength() {
		return length;
	}
	public void setLength(String length) {
		this.length = length;
	}
	public String getWidth() {
		return width;
	}
	public void setWidth(String width) {
		this.width = width;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public String getCarModel() {
		return carModel;
	}
	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}
	public String getEngineNum() {
		return engineNum;
	}
	public void setEngineNum(String engineNum) {
		this.engineNum = engineNum;
	}
	public String getCertificateTime() {
		return certificateTime;
	}
	public void setCertificateTime(String certificateTime) {
		this.certificateTime = certificateTime;
	}
	public String getScrapTime() {
		return scrapTime;
	}
	public void setScrapTime(String scrapTime) {
		this.scrapTime = scrapTime;
	}
	public String getBusinessLicense() {
		return businessLicense;
	}
	public void setBusinessLicense(String businessLicense) {
		this.businessLicense = businessLicense;
	}
	public String getTransportLicense() {
		return transportLicense;
	}
	public void setTransportLicense(String transportLicense) {
		this.transportLicense = transportLicense;
	}
	public String getCarVin() {
		return carVin;
	}
	public void setCarVin(String carVin) {
		this.carVin = carVin;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Integer createTime) {
		this.createTime = createTime;
	}
	public Integer getNewFlag() {
		return newFlag;
	}
	public void setNewFlag(Integer newFlag) {
		this.newFlag = newFlag;
	}
	public Integer getCheckTime() {
		return checkTime;
	}
	public void setCheckTime(Integer checkTime) {
		this.checkTime = checkTime;
	}
	public String getCheckUser() {
		return checkUser;
	}
	public void setCheckUser(String checkUser) {
		this.checkUser = checkUser;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getIsSys() {
		return isSys;
	}
	public void setIsSys(Integer isSys) {
		this.isSys = isSys;
	}
	public Integer getRunStatus() {
		return runStatus;
	}
	public void setRunStatus(Integer runStatus) {
		this.runStatus = runStatus;
	}
	public Integer getOpenStop() {
		return openStop;
	}
	public void setOpenStop(Integer openStop) {
		this.openStop = openStop;
	}
	public Integer getIsLsjData() {
		return isLsjData;
	}
	public void setIsLsjData(Integer isLsjData) {
		this.isLsjData = isLsjData;
	}
	public Integer getRecordState() {
		return recordState;
	}
	public void setRecordState(Integer recordState) {
		this.recordState = recordState;
	}
	public String getRegisterTime() {
		return registerTime;
	}
	public void setRegisterTime(String registerTime) {
		this.registerTime = registerTime;
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
	@Override
	public String toString() {
		return "SysCarVO [id=" + id + ", memberId=" + memberId + ", driver1Id=" + driver1Id + ", driver2Id=" + driver2Id
				+ ", ownerName=" + ownerName + ", carNumber=" + carNumber + ", runCertificateImg=" + runCertificateImg
				+ ", runCertificateImg2=" + runCertificateImg2 + ", transportCertificateImg=" + transportCertificateImg
				+ ", carTypeName=" + carTypeName + ", fuelType=" + fuelType + ", setupWeight=" + setupWeight
				+ ", towWeight=" + towWeight + ", totalTractionWeight=" + totalTractionWeight + ", length=" + length
				+ ", width=" + width + ", height=" + height + ", carModel=" + carModel + ", engineNum=" + engineNum
				+ ", certificateTime=" + certificateTime + ", scrapTime=" + scrapTime + ", businessLicense="
				+ businessLicense + ", transportLicense=" + transportLicense + ", carVin=" + carVin + ", status="
				+ status + ", createTime=" + createTime + ", newFlag=" + newFlag + ", checkTime=" + checkTime
				+ ", checkUser=" + checkUser + ", description=" + description + ", isSys=" + isSys + ", runStatus="
				+ runStatus + ", openStop=" + openStop + ", isLsjData=" + isLsjData + ", recordState=" + recordState
				+ ", registerTime=" + registerTime + ", carType=" + carType + ", etcState=" + etcState + ", deleteFlag="
				+ deleteFlag + "]";
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
	
	

}
