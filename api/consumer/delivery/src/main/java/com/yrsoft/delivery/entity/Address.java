package com.yrsoft.delivery.entity;

import java.io.Serializable;

/**
 * 收发货地址返回VO
 * @author Yhq
 * @date 2019/2/23 13:48
 */
public class Address implements Serializable {

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

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }

    public Integer getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Integer updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getDefaultState() {
        return defaultState;
    }

    public void setDefaultState(Integer defaultState) {
        this.defaultState = defaultState;
    }

    public Integer getAddressType() {
        return addressType;
    }

    public void setAddressType(Integer addressType) {
        this.addressType = addressType;
    }

    public Integer getAddressStatus() {
        return addressStatus;
    }

    public void setAddressStatus(Integer addressStatus) {
        this.addressStatus = addressStatus;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id='" + id + '\'' +
                ", shipperId='" + shipperId + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", area='" + area + '\'' +
                ", address='" + address + '\'' +
                ", lng='" + lng + '\'' +
                ", lat='" + lat + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", defaultState=" + defaultState +
                ", addressType=" + addressType +
                ", addressStatus=" + addressStatus +
                ", provinceCode='" + provinceCode + '\'' +
                ", cityCode='" + cityCode + '\'' +
                ", areaCode='" + areaCode + '\'' +
                ", deleteFlag=" + deleteFlag +
                '}';
    }
}
