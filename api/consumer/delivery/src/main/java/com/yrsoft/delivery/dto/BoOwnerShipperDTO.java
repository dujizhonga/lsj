package com.yrsoft.delivery.dto;

import java.util.List;

import com.yrsoft.delivery.entity.BoOwnerShipper;

/**
 * 会员管理-货主车主关系表 bo_owner_shipper
 *
 * @author mz
 * @date 2019-02-23
 */
public class BoOwnerShipperDTO extends BaseDTO {
	private List<BoOwnerShipper> data;

	public  List<BoOwnerShipper> getData() {
		return data;
	}

	public void setData( List<BoOwnerShipper> data) {
		this.data = data;
	}
}
