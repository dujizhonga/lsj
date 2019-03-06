package com.yrsoft.platform.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
																													
/**
 * 货运-货运模板表 p_shipments_model
 *
 * @author mz
 * @date 2019-02-23
 */
public class PShipmentsModel
{
private static final long serialVersionUID = 1L;

/** 主键id */
private String id;
/** 发货人 */
private String shipperId;
/** 收货人姓名 */
private String consigneeName;
/** 收货人电话 */
private String consigneePhone;
/** 发货地_省 */
private String shipperProvince;
/** 发货地_市 */
private String shipperCity;
/** 发货地_区 */
private String shipperArea;
/** 发货地_详细地址 */
private String shipperAddress;
/** 收货地_省 */
private String consigneeProvince;
/** 收货地_市 */
private String consigneeCity;
/** 收货地_区 */
private String consigneeArea;
/** 收货地_详细地址 */
private String consigneeAddress;
/** 发货地_经度 */
private String shipperLng;
/** 发货地_纬度 */
private String shipperLat;
/** 收货地_经度 */
private String consigneeLng;
/** 收货地_纬度 */
private String consigneeLat;
/** 货物名 */
private String cargo;
/** 货物重量 */
private String weight;
/** 货物体积 */
private String volume;
/**  */
private Integer type;
/** 创建时间 */
private Integer createTime;
/** 修改时间 */
private Integer updateTime;
/** 发货省——标识 */
private String shipperProvinceCode;
/** 发货市——标识 */
private String shipperCityCode;
/** 发货县——标识 */
private String shipperAreaCode;
/** 收货省——标识 */
private String consigneeProvinceCode;
/** 收货市——标识 */
private String consigneeCityCode;
/** 收货县——标识 */
private String consigneeAreaCode;
/** 删除状态（0：未删除，1：已删除） */
private Integer deleteFlag;

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
public void setConsigneeName(String consigneeName)
        {
        this.consigneeName = consigneeName;
        }

public String getConsigneeName()
        {
        return consigneeName;
        }
public void setConsigneePhone(String consigneePhone)
        {
        this.consigneePhone = consigneePhone;
        }

public String getConsigneePhone()
        {
        return consigneePhone;
        }
public void setShipperProvince(String shipperProvince)
        {
        this.shipperProvince = shipperProvince;
        }

public String getShipperProvince()
        {
        return shipperProvince;
        }
public void setShipperCity(String shipperCity)
        {
        this.shipperCity = shipperCity;
        }

public String getShipperCity()
        {
        return shipperCity;
        }
public void setShipperArea(String shipperArea)
        {
        this.shipperArea = shipperArea;
        }

public String getShipperArea()
        {
        return shipperArea;
        }
public void setShipperAddress(String shipperAddress)
        {
        this.shipperAddress = shipperAddress;
        }

public String getShipperAddress()
        {
        return shipperAddress;
        }
public void setConsigneeProvince(String consigneeProvince)
        {
        this.consigneeProvince = consigneeProvince;
        }

public String getConsigneeProvince()
        {
        return consigneeProvince;
        }
public void setConsigneeCity(String consigneeCity)
        {
        this.consigneeCity = consigneeCity;
        }

public String getConsigneeCity()
        {
        return consigneeCity;
        }
public void setConsigneeArea(String consigneeArea)
        {
        this.consigneeArea = consigneeArea;
        }

public String getConsigneeArea()
        {
        return consigneeArea;
        }
public void setConsigneeAddress(String consigneeAddress)
        {
        this.consigneeAddress = consigneeAddress;
        }

public String getConsigneeAddress()
        {
        return consigneeAddress;
        }
public void setShipperLng(String shipperLng)
        {
        this.shipperLng = shipperLng;
        }

public String getShipperLng()
        {
        return shipperLng;
        }
public void setShipperLat(String shipperLat)
        {
        this.shipperLat = shipperLat;
        }

public String getShipperLat()
        {
        return shipperLat;
        }
public void setConsigneeLng(String consigneeLng)
        {
        this.consigneeLng = consigneeLng;
        }

public String getConsigneeLng()
        {
        return consigneeLng;
        }
public void setConsigneeLat(String consigneeLat)
        {
        this.consigneeLat = consigneeLat;
        }

public String getConsigneeLat()
        {
        return consigneeLat;
        }
public void setCargo(String cargo)
        {
        this.cargo = cargo;
        }

public String getCargo()
        {
        return cargo;
        }
public void setWeight(String weight)
        {
        this.weight = weight;
        }

public String getWeight()
        {
        return weight;
        }
public void setVolume(String volume)
        {
        this.volume = volume;
        }

public String getVolume()
        {
        return volume;
        }
public void setType(Integer type)
        {
        this.type = type;
        }

public Integer getType()
        {
        return type;
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
public void setShipperProvinceCode(String shipperProvinceCode)
        {
        this.shipperProvinceCode = shipperProvinceCode;
        }

public String getShipperProvinceCode()
        {
        return shipperProvinceCode;
        }
public void setShipperCityCode(String shipperCityCode)
        {
        this.shipperCityCode = shipperCityCode;
        }

public String getShipperCityCode()
        {
        return shipperCityCode;
        }
public void setShipperAreaCode(String shipperAreaCode)
        {
        this.shipperAreaCode = shipperAreaCode;
        }

public String getShipperAreaCode()
        {
        return shipperAreaCode;
        }
public void setConsigneeProvinceCode(String consigneeProvinceCode)
        {
        this.consigneeProvinceCode = consigneeProvinceCode;
        }

public String getConsigneeProvinceCode()
        {
        return consigneeProvinceCode;
        }
public void setConsigneeCityCode(String consigneeCityCode)
        {
        this.consigneeCityCode = consigneeCityCode;
        }

public String getConsigneeCityCode()
        {
        return consigneeCityCode;
        }
public void setConsigneeAreaCode(String consigneeAreaCode)
        {
        this.consigneeAreaCode = consigneeAreaCode;
        }

public String getConsigneeAreaCode()
        {
        return consigneeAreaCode;
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
	            .append("consigneeName", getConsigneeName())
	            .append("consigneePhone", getConsigneePhone())
	            .append("shipperProvince", getShipperProvince())
	            .append("shipperCity", getShipperCity())
	            .append("shipperArea", getShipperArea())
	            .append("shipperAddress", getShipperAddress())
	            .append("consigneeProvince", getConsigneeProvince())
	            .append("consigneeCity", getConsigneeCity())
	            .append("consigneeArea", getConsigneeArea())
	            .append("consigneeAddress", getConsigneeAddress())
	            .append("shipperLng", getShipperLng())
	            .append("shipperLat", getShipperLat())
	            .append("consigneeLng", getConsigneeLng())
	            .append("consigneeLat", getConsigneeLat())
	            .append("cargo", getCargo())
	            .append("weight", getWeight())
	            .append("volume", getVolume())
	            .append("type", getType())
	            .append("createTime", getCreateTime())
	            .append("updateTime", getUpdateTime())
	            .append("shipperProvinceCode", getShipperProvinceCode())
	            .append("shipperCityCode", getShipperCityCode())
	            .append("shipperAreaCode", getShipperAreaCode())
	            .append("consigneeProvinceCode", getConsigneeProvinceCode())
	            .append("consigneeCityCode", getConsigneeCityCode())
	            .append("consigneeAreaCode", getConsigneeAreaCode())
	            .append("deleteFlag", getDeleteFlag())
	        .toString();
        }
        }
