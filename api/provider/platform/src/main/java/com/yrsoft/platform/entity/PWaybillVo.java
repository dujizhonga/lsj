package com.yrsoft.platform.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 货运-运单表 p_waybill
 *
 * @author mz
 * @date 2019-02-23
 */
public class PWaybillVo {
	private static final long serialVersionUID = 1L;

	/** 主键id */
	private String id = "";
	/** 运单编号 */
	private String waybillNumber = "";
	/** 货运单id */
	private String invoiceId = "";
	/** 车主id */
	private String ownerId = "";
	/** 车辆id */
	private String carId = "";
	/** 运费id */
	private String freightId = "";
	/** 保险费支付记录id（p_insurance表id） */
	private String insuranceId = "";
	/** 预付运费（单位：分） */
	private Long advanceFreight = 0L;
	/** 实际运费(单位：分) */
	private Long actualFreight = 0L;
	/** 实际运费确认人(fk:员工表) */
	private String freightConfirmer = "";
	/** 实际运费确认时间 */
	private Integer freightConfirmationTime = 0;
	/** 实际运费确认意见 */
	private String freightConfirmationOpinion = "";
	/** 修改运费原因 */
	private String modifyCause = "";
	/** 磅单照片(发货前) */
	private String poundsImg1 = "";
	/** 磅单照片(送达后) */
	private String poundsImg2 = "";
	/** 磅单重量（发货前 单位：吨） */
	private String poundsNum1 = "";
	/** 磅单重量（送达后 单位：吨） */
	private String poundsNum2 = "";
	/** 运单创建时间 */
	private Integer createTime = 0;
	/** 发货时间 */
	private Integer deliveryTime = 0;
	/** 货物送达时间 */
	private Integer deliveryGoodsTime = 0;
	/** 确认收货时间 */
	private Integer confirmReceiptTime = 0;
	/** 运单类型（0.指派单 1.系统单 ） */
	private Integer flag = 0;
	/** 是否撤销运单(0：否，1：是) */
	private Integer isCancel = 0;
	/** 运单状态 0-未发货 1-已发货 2-已送达 3-已收货 4-已撤销 */
	private Integer waybillState = 0;
	/** 储值状态 0-否 1-是 */
	private Integer storedState = 0;
	/** 运单运费支付状态(0.未支付 1.已支付 2.支付中) */
	private Integer freightPayState = 0;
	/** 运费支付方式 （0-垫资 1-垫支 2-现金） */
	private Integer freightPayWay = 0;
	/** 运单保险费支付状态(0.未支付 1.已支付 2.支付中) */
	private Integer insurancePayState = 0;
	/** 是否已评论（0：否，1是） */
	private Integer isComments = 0;
	/** 评论星级（5：五星，4：四星.....） */
	private Integer star = 5;
	/** 评价内容 */
	private String comment = "";
	/** 评价选项 */
	private String evaluateOptions = "";
	/** 运单开票状态(0:未开票 1:开票中,2:已开票 ) */
	private Integer receiptStatus = 0;
	/** 删除状态（0：未删除，1：已删除） */
	private Integer deleteFlag = 0;
	/** 车牌号 */
	private String carNum = "";
	/** 司机1ID */
	private String driverId = "";
	/** 司机1姓名 */
	private String driverName = "";
	/** 司机2ID */
	private String driverId2 = "";
	/** 司机2姓名 */
	private String driverName2 = "";
	/** 车辆位置经度 */
	private String lng = "";
	/** 车辆位置维度 */
	private String lat = "";
	/** 车辆运货状态（0：空闲；1：等待收货；2：运货中）, */
	private int runStatus = 0;
	/** 货运单的目的经度 */
	private String invoiceLng = "";
	/** 货运单的目的纬度, */
	private String invoiceLat = "";
	/** 司机1电话, */
	private String driverteleph = "";
	/** 司机2电话, */
	private String driverteleph2 = "";
	/** 车主姓名 */
	private String realName= "";
	// 车主电话
	private String telephone= "";
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getWaybillNumber() {
		return waybillNumber;
	}
	public void setWaybillNumber(String waybillNumber) {
		this.waybillNumber = waybillNumber;
	}
	public String getInvoiceId() {
		return invoiceId;
	}
	public void setInvoiceId(String invoiceId) {
		this.invoiceId = invoiceId;
	}
	public String getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}
	public String getCarId() {
		return carId;
	}
	public void setCarId(String carId) {
		this.carId = carId;
	}
	public String getFreightId() {
		return freightId;
	}
	public void setFreightId(String freightId) {
		this.freightId = freightId;
	}
	public String getInsuranceId() {
		return insuranceId;
	}
	public void setInsuranceId(String insuranceId) {
		this.insuranceId = insuranceId;
	}
	public Long getAdvanceFreight() {
		return advanceFreight;
	}
	public void setAdvanceFreight(Long advanceFreight) {
		this.advanceFreight = advanceFreight;
	}
	public Long getActualFreight() {
		return actualFreight;
	}
	public void setActualFreight(Long actualFreight) {
		this.actualFreight = actualFreight;
	}
	public String getFreightConfirmer() {
		return freightConfirmer;
	}
	public void setFreightConfirmer(String freightConfirmer) {
		this.freightConfirmer = freightConfirmer;
	}
	public Integer getFreightConfirmationTime() {
		return freightConfirmationTime;
	}
	public void setFreightConfirmationTime(Integer freightConfirmationTime) {
		this.freightConfirmationTime = freightConfirmationTime;
	}
	public String getFreightConfirmationOpinion() {
		return freightConfirmationOpinion;
	}
	public void setFreightConfirmationOpinion(String freightConfirmationOpinion) {
		this.freightConfirmationOpinion = freightConfirmationOpinion;
	}
	public String getModifyCause() {
		return modifyCause;
	}
	public void setModifyCause(String modifyCause) {
		this.modifyCause = modifyCause;
	}
	public String getPoundsImg1() {
		return poundsImg1;
	}
	public void setPoundsImg1(String poundsImg1) {
		this.poundsImg1 = poundsImg1;
	}
	public String getPoundsImg2() {
		return poundsImg2;
	}
	public void setPoundsImg2(String poundsImg2) {
		this.poundsImg2 = poundsImg2;
	}
	public String getPoundsNum1() {
		return poundsNum1;
	}
	public void setPoundsNum1(String poundsNum1) {
		this.poundsNum1 = poundsNum1;
	}
	public String getPoundsNum2() {
		return poundsNum2;
	}
	public void setPoundsNum2(String poundsNum2) {
		this.poundsNum2 = poundsNum2;
	}
	public Integer getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Integer createTime) {
		this.createTime = createTime;
	}
	public Integer getDeliveryTime() {
		return deliveryTime;
	}
	public void setDeliveryTime(Integer deliveryTime) {
		this.deliveryTime = deliveryTime;
	}
	public Integer getDeliveryGoodsTime() {
		return deliveryGoodsTime;
	}
	public void setDeliveryGoodsTime(Integer deliveryGoodsTime) {
		this.deliveryGoodsTime = deliveryGoodsTime;
	}
	public Integer getConfirmReceiptTime() {
		return confirmReceiptTime;
	}
	public void setConfirmReceiptTime(Integer confirmReceiptTime) {
		this.confirmReceiptTime = confirmReceiptTime;
	}
	public Integer getFlag() {
		return flag;
	}
	public void setFlag(Integer flag) {
		this.flag = flag;
	}
	public Integer getIsCancel() {
		return isCancel;
	}
	public void setIsCancel(Integer isCancel) {
		this.isCancel = isCancel;
	}
	public Integer getWaybillState() {
		return waybillState;
	}
	public void setWaybillState(Integer waybillState) {
		this.waybillState = waybillState;
	}
	public Integer getStoredState() {
		return storedState;
	}
	public void setStoredState(Integer storedState) {
		this.storedState = storedState;
	}
	public Integer getFreightPayState() {
		return freightPayState;
	}
	public void setFreightPayState(Integer freightPayState) {
		this.freightPayState = freightPayState;
	}
	public Integer getFreightPayWay() {
		return freightPayWay;
	}
	public void setFreightPayWay(Integer freightPayWay) {
		this.freightPayWay = freightPayWay;
	}
	public Integer getInsurancePayState() {
		return insurancePayState;
	}
	public void setInsurancePayState(Integer insurancePayState) {
		this.insurancePayState = insurancePayState;
	}
	public Integer getIsComments() {
		return isComments;
	}
	public void setIsComments(Integer isComments) {
		this.isComments = isComments;
	}
	public Integer getStar() {
		return star;
	}
	public void setStar(Integer star) {
		this.star = star;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getEvaluateOptions() {
		return evaluateOptions;
	}
	public void setEvaluateOptions(String evaluateOptions) {
		this.evaluateOptions = evaluateOptions;
	}
	public Integer getReceiptStatus() {
		return receiptStatus;
	}
	public void setReceiptStatus(Integer receiptStatus) {
		this.receiptStatus = receiptStatus;
	}
	public Integer getDeleteFlag() {
		return deleteFlag;
	}
	public void setDeleteFlag(Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	public String getCarNum() {
		return carNum;
	}
	public void setCarNum(String carNum) {
		this.carNum = carNum;
	}
	public String getDriverId() {
		return driverId;
	}
	public void setDriverId(String driverId) {
		this.driverId = driverId;
	}
	public String getDriverName() {
		return driverName;
	}
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	public String getDriverId2() {
		return driverId2;
	}
	public void setDriverId2(String driverId2) {
		this.driverId2 = driverId2;
	}
	public String getDriverName2() {
		return driverName2;
	}
	public void setDriverName2(String driverName2) {
		this.driverName2 = driverName2;
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
	public int getRunStatus() {
		return runStatus;
	}
	public void setRunStatus(int runStatus) {
		this.runStatus = runStatus;
	}
	public String getInvoiceLng() {
		return invoiceLng;
	}
	public void setInvoiceLng(String invoiceLng) {
		this.invoiceLng = invoiceLng;
	}
	public String getInvoiceLat() {
		return invoiceLat;
	}
	public void setInvoiceLat(String invoiceLat) {
		this.invoiceLat = invoiceLat;
	}
	public String getDriverteleph() {
		return driverteleph;
	}
	public void setDriverteleph(String driverteleph) {
		this.driverteleph = driverteleph;
	}
	public String getDriverteleph2() {
		return driverteleph2;
	}
	public void setDriverteleph2(String driverteleph2) {
		this.driverteleph2 = driverteleph2;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	@Override
	public String toString() {
		return "PWaybillVo [id=" + id + ", waybillNumber=" + waybillNumber + ", invoiceId=" + invoiceId + ", ownerId="
				+ ownerId + ", carId=" + carId + ", freightId=" + freightId + ", insuranceId=" + insuranceId
				+ ", advanceFreight=" + advanceFreight + ", actualFreight=" + actualFreight + ", freightConfirmer="
				+ freightConfirmer + ", freightConfirmationTime=" + freightConfirmationTime
				+ ", freightConfirmationOpinion=" + freightConfirmationOpinion + ", modifyCause=" + modifyCause
				+ ", poundsImg1=" + poundsImg1 + ", poundsImg2=" + poundsImg2 + ", poundsNum1=" + poundsNum1
				+ ", poundsNum2=" + poundsNum2 + ", createTime=" + createTime + ", deliveryTime=" + deliveryTime
				+ ", deliveryGoodsTime=" + deliveryGoodsTime + ", confirmReceiptTime=" + confirmReceiptTime + ", flag="
				+ flag + ", isCancel=" + isCancel + ", waybillState=" + waybillState + ", storedState=" + storedState
				+ ", freightPayState=" + freightPayState + ", freightPayWay=" + freightPayWay + ", insurancePayState="
				+ insurancePayState + ", isComments=" + isComments + ", star=" + star + ", comment=" + comment
				+ ", evaluateOptions=" + evaluateOptions + ", receiptStatus=" + receiptStatus + ", deleteFlag="
				+ deleteFlag + ", carNum=" + carNum + ", driverId=" + driverId + ", driverName=" + driverName
				+ ", driverId2=" + driverId2 + ", driverName2=" + driverName2 + ", lng=" + lng + ", lat=" + lat
				+ ", runStatus=" + runStatus + ", invoiceLng=" + invoiceLng + ", invoiceLat=" + invoiceLat
				+ ", driverteleph=" + driverteleph + ", driverteleph2=" + driverteleph2 + ", realName=" + realName
				+ ", telephone=" + telephone + "]";
	}

}
