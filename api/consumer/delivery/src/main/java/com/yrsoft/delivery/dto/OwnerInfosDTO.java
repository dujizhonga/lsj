package com.yrsoft.delivery.dto;

import java.util.List;

import com.yrsoft.delivery.vo.OwnerInfoListVO;

/**
 * @author Yxq
 * @date 2019/2/25 10:46
 */
public class OwnerInfosDTO extends BaseDTO {

    
    private List<OwnerInfoListVO> data;

	public List<OwnerInfoListVO> getData() {
		return data;
	}

	public void setData(List<OwnerInfoListVO> data) {
		this.data = data;
	}


	
}
