package com.yrsoft.platform.entity;

import java.math.BigDecimal;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 货运-货运单表 p_invoice
 *
 * @author mz
 * @date 2019-02-23
 */
public class PInvoiceVo {
	private static final long serialVersionUID = 1L;

	/** 主键id */
	private String id;
	/** 货主id(fk:会员) */
	private String shipperId;
	/** fk: p_cargo_name主键ID */
	private String cargoNameId;
	/** 货运单编号 */
	private String invoiceNumber;
	/** 货运单状态(1:未完成 ,2:完成) */
	private Integer status;
	/** 起始省 */
	private String startProvince;
	/** 起始市 */
	private String startCity;
	/** 起始区 */
	private String startArea;
	/** 起始地详细地址 */
	private String startAddress;
	/** 发货地经度 */
	private String startLng;
	/** 发货地纬度 */
	private String startLat;
	/** 目的省 */
	private String arriveProvince;
	/** 目的市 */
	private String arriveCity;
	/** 目的区 */
	private String arriveArea;
	/** 目的地详细地址 */
	private String arriveAddress;
	/** 目的地经度 */
	private String arriveLng;
	/** 目的地维度 */
	private String arriveLat;
	/** 收货人姓名 */
	private String receiveUserName;
	/** 收货人电话 */
	private String receiveUserTelephone;
	/** 货品名称 */
	private String goodsName;
	/** 货物数量 */
	private String goodsNumber;
	/** 货物重量 */
	private String goodsWeight;
	/** 数量单位 */
	private String numUnit;
	/** 体积 */
	private String goodsVolume;
	/** 货物描述 */
	private String goodsRemark;
	/** 申请车辆数 */
	private Integer applyCarNo;
	/** 指派车辆数 */
	private Integer assignCarNo;
	/** 实际响应指派车辆数 */
	private Integer actualAssignNum;
	/** 实际响应系统车辆数 */
	private Integer actualApplyNum;
	/** 呼叫车辆次数 */
	private Integer numberCall;
	/** 最后一次呼叫时间 */
	private Integer callTime;
	/** 单车保证金金额 */
	private Long marginAmount;
	/** 货运单类型（1.指派单 2.系统单 3：混合单）: */
	private Integer flag;
	/** 单车运费 */
	private Long basicAmount;
	/** 单车保险费用 */
	private Long insureAmount;
	/** 总运费 */
	private Long basicAmountTotal;
	/** 总保险费 */
	private Long insureAmountTotal;
	/** 订单生成时间 */
	private Integer createTime;
	/** 结束时间 */
	private Integer endTime;
	/** 路线距离公里数 */
	private BigDecimal routeRange;
	/** 删除状态(0：未删除，1：已删除) */
	private Integer deleteFlag;
	/** 已完成运单统计 */
	private Integer countWaybill;
	/** 是否允许删除按钮 ：0-允许删除，1-不允许删除 */
	private String deleteButton;

	/** 指派运单数 */
	private String assignNo;
	/** 系统运单数 */
	private String applyNo;

	/** 运单状态 0-未发货 1-已发货 2-已送达 3-已收货 4-已撤销 */
	private String waybillState;
	/**
	 * 车主id
	 */
	private String ownerId;
	/**
	 * 运单数
	 */
	private Integer waybillCount;
	
	
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


	public String getCargoNameId() {
		return cargoNameId;
	}


	public void setCargoNameId(String cargoNameId) {
		this.cargoNameId = cargoNameId;
	}


	public String getInvoiceNumber() {
		return invoiceNumber;
	}


	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}


	public Integer getStatus() {
		return status;
	}


	public void setStatus(Integer status) {
		this.status = status;
	}


	public String getStartProvince() {
		return startProvince;
	}


	public void setStartProvince(String startProvince) {
		this.startProvince = startProvince;
	}


	public String getStartCity() {
		return startCity;
	}


	public void setStartCity(String startCity) {
		this.startCity = startCity;
	}


	public String getStartArea() {
		return startArea;
	}


	public void setStartArea(String startArea) {
		this.startArea = startArea;
	}


	public String getStartAddress() {
		return startAddress;
	}


	public void setStartAddress(String startAddress) {
		this.startAddress = startAddress;
	}


	public String getStartLng() {
		return startLng;
	}


	public void setStartLng(String startLng) {
		this.startLng = startLng;
	}


	public String getStartLat() {
		return startLat;
	}


	public void setStartLat(String startLat) {
		this.startLat = startLat;
	}


	public String getArriveProvince() {
		return arriveProvince;
	}


	public void setArriveProvince(String arriveProvince) {
		this.arriveProvince = arriveProvince;
	}


	public String getArriveCity() {
		return arriveCity;
	}


	public void setArriveCity(String arriveCity) {
		this.arriveCity = arriveCity;
	}


	public String getArriveArea() {
		return arriveArea;
	}


	public void setArriveArea(String arriveArea) {
		this.arriveArea = arriveArea;
	}


	public String getArriveAddress() {
		return arriveAddress;
	}


	public void setArriveAddress(String arriveAddress) {
		this.arriveAddress = arriveAddress;
	}


	public String getArriveLng() {
		return arriveLng;
	}


	public void setArriveLng(String arriveLng) {
		this.arriveLng = arriveLng;
	}


	public String getArriveLat() {
		return arriveLat;
	}


	public void setArriveLat(String arriveLat) {
		this.arriveLat = arriveLat;
	}


	public String getReceiveUserName() {
		return receiveUserName;
	}


	public void setReceiveUserName(String receiveUserName) {
		this.receiveUserName = receiveUserName;
	}


	public String getReceiveUserTelephone() {
		return receiveUserTelephone;
	}


	public void setReceiveUserTelephone(String receiveUserTelephone) {
		this.receiveUserTelephone = receiveUserTelephone;
	}


	public String getGoodsName() {
		return goodsName;
	}


	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}


	public String getGoodsNumber() {
		return goodsNumber;
	}


	public void setGoodsNumber(String goodsNumber) {
		this.goodsNumber = goodsNumber;
	}


	public String getGoodsWeight() {
		return goodsWeight;
	}


	public void setGoodsWeight(String goodsWeight) {
		this.goodsWeight = goodsWeight;
	}


	public String getNumUnit() {
		return numUnit;
	}


	public void setNumUnit(String numUnit) {
		this.numUnit = numUnit;
	}


	public String getGoodsVolume() {
		return goodsVolume;
	}


	public void setGoodsVolume(String goodsVolume) {
		this.goodsVolume = goodsVolume;
	}


	public String getGoodsRemark() {
		return goodsRemark;
	}


	public void setGoodsRemark(String goodsRemark) {
		this.goodsRemark = goodsRemark;
	}


	public Integer getApplyCarNo() {
		return applyCarNo;
	}


	public void setApplyCarNo(Integer applyCarNo) {
		this.applyCarNo = applyCarNo;
	}


	public Integer getAssignCarNo() {
		return assignCarNo;
	}


	public void setAssignCarNo(Integer assignCarNo) {
		this.assignCarNo = assignCarNo;
	}


	public Integer getActualAssignNum() {
		return actualAssignNum;
	}


	public void setActualAssignNum(Integer actualAssignNum) {
		this.actualAssignNum = actualAssignNum;
	}


	public Integer getActualApplyNum() {
		return actualApplyNum;
	}


	public void setActualApplyNum(Integer actualApplyNum) {
		this.actualApplyNum = actualApplyNum;
	}


	public Integer getNumberCall() {
		return numberCall;
	}


	public void setNumberCall(Integer numberCall) {
		this.numberCall = numberCall;
	}


	public Integer getCallTime() {
		return callTime;
	}


	public void setCallTime(Integer callTime) {
		this.callTime = callTime;
	}


	public Long getMarginAmount() {
		return marginAmount;
	}


	public void setMarginAmount(Long marginAmount) {
		this.marginAmount = marginAmount;
	}


	public Integer getFlag() {
		return flag;
	}


	public void setFlag(Integer flag) {
		this.flag = flag;
	}


	public Long getBasicAmount() {
		return basicAmount;
	}


	public void setBasicAmount(Long basicAmount) {
		this.basicAmount = basicAmount;
	}


	public Long getInsureAmount() {
		return insureAmount;
	}


	public void setInsureAmount(Long insureAmount) {
		this.insureAmount = insureAmount;
	}


	public Long getBasicAmountTotal() {
		return basicAmountTotal;
	}


	public void setBasicAmountTotal(Long basicAmountTotal) {
		this.basicAmountTotal = basicAmountTotal;
	}


	public Long getInsureAmountTotal() {
		return insureAmountTotal;
	}


	public void setInsureAmountTotal(Long insureAmountTotal) {
		this.insureAmountTotal = insureAmountTotal;
	}


	public Integer getCreateTime() {
		return createTime;
	}


	public void setCreateTime(Integer createTime) {
		this.createTime = createTime;
	}


	public Integer getEndTime() {
		return endTime;
	}


	public void setEndTime(Integer endTime) {
		this.endTime = endTime;
	}


	public BigDecimal getRouteRange() {
		return routeRange;
	}


	public void setRouteRange(BigDecimal routeRange) {
		this.routeRange = routeRange;
	}


	public Integer getDeleteFlag() {
		return deleteFlag;
	}


	public void setDeleteFlag(Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
	}


	public Integer getCountWaybill() {
		return countWaybill;
	}


	public void setCountWaybill(Integer countWaybill) {
		this.countWaybill = countWaybill;
	}


	public String getDeleteButton() {
		return deleteButton;
	}


	public void setDeleteButton(String deleteButton) {
		this.deleteButton = deleteButton;
	}


	public String getAssignNo() {
		return assignNo;
	}


	public void setAssignNo(String assignNo) {
		this.assignNo = assignNo;
	}


	public String getApplyNo() {
		return applyNo;
	}


	public void setApplyNo(String applyNo) {
		this.applyNo = applyNo;
	}


	public String getWaybillState() {
		return waybillState;
	}


	public void setWaybillState(String waybillState) {
		this.waybillState = waybillState;
	}


	public String getOwnerId() {
		return ownerId;
	}


	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}


	public Integer getWaybillCount() {
		return waybillCount;
	}


	public void setWaybillCount(Integer waybillCount) {
		this.waybillCount = waybillCount;
	}


	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).append("id", getId())
				.append("shipperId", getShipperId()).append("cargoNameId", getCargoNameId())
				.append("invoiceNumber", getInvoiceNumber()).append("status", getStatus())
				.append("startProvince", getStartProvince()).append("startCity", getStartCity())
				.append("startArea", getStartArea()).append("startAddress", getStartAddress())
				.append("startLng", getStartLng()).append("startLat", getStartLat())
				.append("arriveProvince", getArriveProvince()).append("arriveCity", getArriveCity())
				.append("arriveArea", getArriveArea()).append("arriveAddress", getArriveAddress())
				.append("arriveLng", getArriveLng()).append("arriveLat", getArriveLat())
				.append("receiveUserName", getReceiveUserName())
				.append("receiveUserTelephone", getReceiveUserTelephone()).append("goodsName", getGoodsName())
				.append("goodsNumber", getGoodsNumber()).append("goodsWeight", getGoodsWeight())
				.append("numUnit", getNumUnit()).append("goodsVolume", getGoodsVolume())
				.append("goodsRemark", getGoodsRemark()).append("applyCarNo", getApplyCarNo())
				.append("assignCarNo", getAssignCarNo()).append("actualAssignNum", getActualAssignNum())
				.append("actualApplyNum", getActualApplyNum()).append("numberCall", getNumberCall())
				.append("callTime", getCallTime()).append("marginAmount", getMarginAmount()).append("flag", getFlag())
				.append("basicAmount", getBasicAmount()).append("insureAmount", getInsureAmount())
				.append("basicAmountTotal", getBasicAmountTotal()).append("insureAmountTotal", getInsureAmountTotal())
				.append("createTime", getCreateTime()).append("endTime", getEndTime())
				.append("routeRange", getRouteRange()).append("deleteFlag", getDeleteFlag()).toString();
	}
}
