package com.yrsoft.delivery.dto;

import java.util.List;

import com.yrsoft.delivery.vo.AssignRecordVO;

public class AssignReDTO extends BaseDTO{
	private List<AssignRecordVO> data;

	public List<AssignRecordVO> getData() {
		return data;
	}

	public void setData(List<AssignRecordVO> data) {
		this.data = data;
	}
	

}
