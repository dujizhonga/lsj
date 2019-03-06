package com.yrsoft.freight.vo;

import java.io.Serializable;

/**
 *
 * 功能描述: 方法注释
 *
 * @param:
 * @return: 
 * @auther: Guohaolong
 * @date: 2019年2月27日 下午4:26:35
 */
public class InvoiceWaybillsInfoVO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/** 主键id */
	private String id;
	/** 运单编号 */
	private String waybillNumber;
	/** 车牌 */
	private String carNumber;
	/** 预付运费（单位：分） */
	private Long advanceFreight;
	/** 运单状态 0-未发货 1-已发货 2-已送达 3-已收货 4-已撤销 */
	private Integer waybillState;
	public Integer getWaybillState() {
		return waybillState;
	}
	public void setWaybillState(Integer waybillState) {
		this.waybillState = waybillState;
	}
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
	
	public String getCarNumber() {
		return carNumber;
	}
	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}
	public Long getAdvanceFreight() {
		return advanceFreight;
	}
	public void setAdvanceFreight(Long advanceFreight) {
		this.advanceFreight = advanceFreight;
	}
	

}
