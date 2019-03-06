package com.yrsoft.delivery.vo;
/**
 * 生成分派单记录VO
 * @author DWH
 * @date 2019/2/25 
 */
public class AssignRecordVO {
	/** 主键id */
	private String id;
	/** 货运单id */
	private String invoiceId;
	/** fk:分派申请id */
	private String applyId;
	/** fk:分派车辆id */
	private String carId;
	/** 运单类型 0：指派单 1：系统单 */
	private Integer waybillType;
	/** 运单编号 */
	private String waybillNum;
	/** 创建时间 */
	private Integer createTime;
	/** 是否已被接：0未接，1已接  2已拒绝 */
	private Integer isReceipt;
	/** 过期状态 0：正常  1：过期 */
	private Integer overdueStatus;
	/** 是否自动（0-是 1-否） */
	private Integer isAuto;
	/** 响应时间 */
	private Integer responseTime;
	/** 删除状态（0：未删除，1：已删除） */
	private Integer deleteFlag;
	
	private Integer callCarNum;
	
	public Integer getCallCarNum() {
		return callCarNum;
	}
	public void setCallCarNum(Integer callCarNum) {
		this.callCarNum = callCarNum;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getInvoiceId() {
		return invoiceId;
	}
	public void setInvoiceId(String invoiceId) {
		this.invoiceId = invoiceId;
	}
	public String getApplyId() {
		return applyId;
	}
	public void setApplyId(String applyId) {
		this.applyId = applyId;
	}
	public String getCarId() {
		return carId;
	}
	public void setCarId(String carId) {
		this.carId = carId;
	}
	public Integer getWaybillType() {
		return waybillType;
	}
	public void setWaybillType(Integer waybillType) {
		this.waybillType = waybillType;
	}
	public String getWaybillNum() {
		return waybillNum;
	}
	public void setWaybillNum(String waybillNum) {
		this.waybillNum = waybillNum;
	}
	public Integer getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Integer createTime) {
		this.createTime = createTime;
	}
	public Integer getIsReceipt() {
		return isReceipt;
	}
	public void setIsReceipt(Integer isReceipt) {
		this.isReceipt = isReceipt;
	}
	public Integer getOverdueStatus() {
		return overdueStatus;
	}
	public void setOverdueStatus(Integer overdueStatus) {
		this.overdueStatus = overdueStatus;
	}
	public Integer getIsAuto() {
		return isAuto;
	}
	public void setIsAuto(Integer isAuto) {
		this.isAuto = isAuto;
	}
	public Integer getResponseTime() {
		return responseTime;
	}
	public void setResponseTime(Integer responseTime) {
		this.responseTime = responseTime;
	}
	public Integer getDeleteFlag() {
		return deleteFlag;
	}
	public void setDeleteFlag(Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	@Override
	public String toString() {
		return "AssignRecordVO [id=" + id + ", invoiceId=" + invoiceId + ", applyId=" + applyId + ", carId=" + carId
				+ ", waybillType=" + waybillType + ", waybillNum=" + waybillNum + ", createTime=" + createTime
				+ ", isReceipt=" + isReceipt + ", overdueStatus=" + overdueStatus + ", isAuto=" + isAuto
				+ ", responseTime=" + responseTime + ", deleteFlag=" + deleteFlag + ", getId()=" + getId()
				+ ", getInvoiceId()=" + getInvoiceId() + ", getApplyId()=" + getApplyId() + ", getCarId()=" + getCarId()
				+ ", getWaybillType()=" + getWaybillType() + ", getWaybillNum()=" + getWaybillNum()
				+ ", getCreateTime()=" + getCreateTime() + ", getIsReceipt()=" + getIsReceipt()
				+ ", getOverdueStatus()=" + getOverdueStatus() + ", getIsAuto()=" + getIsAuto() + ", getResponseTime()="
				+ getResponseTime() + ", getDeleteFlag()=" + getDeleteFlag() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	

}
