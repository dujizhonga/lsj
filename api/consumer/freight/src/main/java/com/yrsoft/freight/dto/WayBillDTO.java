package com.yrsoft.freight.dto;

import java.util.List;

import com.yrsoft.freight.vo.WayBillVO;

/**
 *
 * 功能描述: 方法注释
 *
 * @param:
 * @return: 
 * @auther: Guohaolong
 * @date: 2019年2月25日 下午5:40:43
 */
public class WayBillDTO extends BaseDTO{
	
	private List<WayBillVO> data;

	public List<WayBillVO> getData() {
		return data;
	}

	public void setData(List<WayBillVO> data) {
		this.data = data;
	}
	

}
