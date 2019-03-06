package com.yrsoft.delivery.entity;


import com.yrsoft.delivery.dto.BaseDTO;
import com.yrsoft.delivery.entity.Address;

/**
 * 会员管理-货主车主关系表 bo_owner_shipper
 *
 * @author mz
 * @date 2019-02-23
 */
public class BoOwnerShipper extends BaseDTO {
	private Address data;

	public Address getData() {
		return data;
	}

	public void setData(Address data) {
		this.data = data;
	}
}
