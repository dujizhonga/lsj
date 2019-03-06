package com.yrsoft.platform.entity;

/**
 * 无车承运人数据上报
 *
 * @author WANGQI
 * @date 2019-03-06
 */
public class TruckBrokerSendLog {
private String id;
/** 1.电子路单 2.资金流水单 */
private Integer type;
/**  */
private String orderCode;
/** 交通部返回报文中code-0000代表发送成功 */
private String code;
/** 交通部返回报文中content */
private String content;

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getType() {
		return type;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public String getOrderCode() {
		return orderCode;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getContent() {
		return content;
	}

}
