package com.yrsoft.delivery.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
																			
/**
 * 货运-收发货地址表 p_shipping_address
 *
 * @author mz
 * @date 2019-02-23
 */
public class ShippingAddress
{
private static final long serialVersionUID = 1L;

/** 主键ID */
private String id;
/** 货主ID */
private String shipperId;
/** 省  */
private String province;
/** 市  */
private String city;
/** 区 */
private String area;
/** 详细地址  */
private String address;
/** 经度 */
private String lng;
/** 维度 */
private String lat;
/** 姓名 */
private String name;
/** 电话 */
private String phone;
/** 创建时间 */
private Integer createTime;
/** 修改时间  */
private Integer updateTime;
/** 默认地址状态（0：否 1：是） */
private Integer defaultState;
/** 地址类型（0：发货地址 1：收货地址） */
private Integer addressType;
/** 地址状态： 0-启用 1-停用 */
private Integer addressStatus;
/** 省-标识 */
private String provinceCode;
/** 市-标识 */
private String cityCode;
/** 县-标识 */
private String areaCode;
/** 删除状态（0：未删除，1：已删除） */
private Integer deleteFlag;
private Integer type;

public Integer getType() {
	return type;
}

public void setType(Integer type) {
	this.type = type;
}

public void setId(String id)
        {
        this.id = id;
        }

public String getId()
        {
        return id;
        }
public void setShipperId(String shipperId)
        {
        this.shipperId = shipperId;
        }

public String getShipperId()
        {
        return shipperId;
        }
public void setProvince(String province)
        {
        this.province = province;
        }

public String getProvince()
        {
        return province;
        }
public void setCity(String city)
        {
        this.city = city;
        }

public String getCity()
        {
        return city;
        }
public void setArea(String area)
        {
        this.area = area;
        }

public String getArea()
        {
        return area;
        }
public void setAddress(String address)
        {
        this.address = address;
        }

public String getAddress()
        {
        return address;
        }
public void setLng(String lng)
        {
        this.lng = lng;
        }

public String getLng()
        {
        return lng;
        }
public void setLat(String lat)
        {
        this.lat = lat;
        }

public String getLat()
        {
        return lat;
        }
public void setName(String name)
        {
        this.name = name;
        }

public String getName()
        {
        return name;
        }
public void setPhone(String phone)
        {
        this.phone = phone;
        }

public String getPhone()
        {
        return phone;
        }
public void setCreateTime(Integer createTime)
        {
        this.createTime = createTime;
        }

public Integer getCreateTime()
        {
        return createTime;
        }
public void setUpdateTime(Integer updateTime)
        {
        this.updateTime = updateTime;
        }

public Integer getUpdateTime()
        {
        return updateTime;
        }
public void setDefaultState(Integer defaultState)
        {
        this.defaultState = defaultState;
        }

public Integer getDefaultState()
        {
        return defaultState;
        }
public void setAddressType(Integer addressType)
        {
        this.addressType = addressType;
        }

public Integer getAddressType()
        {
        return addressType;
        }
public void setAddressStatus(Integer addressStatus)
        {
        this.addressStatus = addressStatus;
        }

public Integer getAddressStatus()
        {
        return addressStatus;
        }
public void setProvinceCode(String provinceCode)
        {
        this.provinceCode = provinceCode;
        }

public String getProvinceCode()
        {
        return provinceCode;
        }
public void setCityCode(String cityCode)
        {
        this.cityCode = cityCode;
        }

public String getCityCode()
        {
        return cityCode;
        }
public void setAreaCode(String areaCode)
        {
        this.areaCode = areaCode;
        }

public String getAreaCode()
        {
        return areaCode;
        }
public void setDeleteFlag(Integer deleteFlag)
        {
        this.deleteFlag = deleteFlag;
        }

public Integer getDeleteFlag()
        {
        return deleteFlag;
        }

public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
	            .append("id", getId())
	            .append("shipperId", getShipperId())
	            .append("province", getProvince())
	            .append("city", getCity())
	            .append("area", getArea())
	            .append("address", getAddress())
	            .append("lng", getLng())
	            .append("lat", getLat())
	            .append("name", getName())
	            .append("phone", getPhone())
	            .append("createTime", getCreateTime())
	            .append("updateTime", getUpdateTime())
	            .append("defaultState", getDefaultState())
	            .append("addressType", getAddressType())
	            .append("addressStatus", getAddressStatus())
	            .append("provinceCode", getProvinceCode())
	            .append("cityCode", getCityCode())
	            .append("areaCode", getAreaCode())
	            .append("deleteFlag", getDeleteFlag())
	        .toString();
        }
        }
