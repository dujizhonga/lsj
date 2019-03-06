package com.yrsoft.delivery.vo;
/**
 * 默认地址vo
 *
 * @author yxq
 * @date 2019-02-23
 */
public class InvoiceAddressVO {

	/** 主键id */
	private String id;
	/** 货主id(fk:会员) */
	private String shipperId;
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

	@Override
	public String toString() {
		return "InvoiceAddressVO [id=" + id + ", shipperId=" + shipperId + ", startProvince=" + startProvince
				+ ", startCity=" + startCity + ", startArea=" + startArea + ", startAddress=" + startAddress
				+ ", startLng=" + startLng + ", startLat=" + startLat + ", arriveProvince=" + arriveProvince
				+ ", arriveCity=" + arriveCity + ", arriveArea=" + arriveArea + ", arriveAddress=" + arriveAddress
				+ ", arriveLng=" + arriveLng + ", arriveLat=" + arriveLat + ", receiveUserName=" + receiveUserName
				+ ", receiveUserTelephone=" + receiveUserTelephone + "]";
	}

}
