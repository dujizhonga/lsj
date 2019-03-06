package com.yrsoft.delivery.vo;

/**
 * 首次发货地址VO（包含收货地址和发货地址）
 * @author Yhq
 * @date 2019/3/4 14:15
 */
public class DoubleAddressVO {
    /**
     * 主键ID
     */
    private String deliverId;

    /**
     * 主键ID
     */
    private String takeId;

    /**
     * 货主ID
     */
    private String shipperId;
    /**
     * 发货省
     */
    private String deliverProvince;
    /**
     * 市
     */
    private String deliverCity;
    /**
     * 区
     */
    private String deliverArea;
    /**
     * 详细地址
     */
    private String deliverAddress;
    /**
     * 经度
     */
    private String deliverLng;
    /**
     * 维度
     */
    private String deliverLat;
    /**
     * 姓名
     */
    private String name;
    /**
     * 电话
     */
    private String phone;
    /**
     * 创建时间
     */
    private Integer createTime;
    /**
     * 修改时间
     */
    private Integer updateTime;
    /**
     * 默认地址状态（0：否 1：是）
     */
    private Integer deliverDefaultState;
    /**
     * 地址类型（0：发货地址 1：收货地址）
     */
    private Integer addressType;
    /**
     * 地址状态： 0-启用 1-停用
     */
    private Integer addressStatus;
    /**
     * 省-标识
     */
    private String deliverProvinceCode;
    /**
     * 市-标识
     */
    private String deliverCityCode;
    /**
     * 县-标识
     */
    private String deliverAreaCode;
    /**
     * 删除状态（0：未删除，1：已删除）
     */
    private Integer deleteFlag;
    /**
     * 发货省
     */
    private String takeProvince;
    /**
     * 市
     */
    private String takeCity;
    /**
     * 区
     */
    private String takeArea;
    /**
     * 详细地址
     */
    private String takeAddress;
    /**
     * 经度
     */
    private String takeLng;
    /**
     * 维度
     */
    private String takeLat;

    /**
     * 默认地址状态（0：否 1：是）
     */
    private Integer takeDefaultState;
    /**
     * 省-标识
     */
    private String takeProvinceCode;
    /**
     * 市-标识
     */
    private String takeCityCode;
    /**
     * 县-标识
     */
    private String takeAreaCode;

    public String getDeliverId() {
        return deliverId;
    }

    public void setDeliverId(String deliverId) {
        this.deliverId = deliverId;
    }

    public String getTakeId() {
        return takeId;
    }

    public void setTakeId(String takeId) {
        this.takeId = takeId;
    }

    public String getShipperId() {
        return shipperId;
    }

    public void setShipperId(String shipperId) {
        this.shipperId = shipperId;
    }

    public String getDeliverProvince() {
        return deliverProvince;
    }

    public void setDeliverProvince(String deliverProvince) {
        this.deliverProvince = deliverProvince;
    }

    public String getDeliverCity() {
        return deliverCity;
    }

    public void setDeliverCity(String deliverCity) {
        this.deliverCity = deliverCity;
    }

    public String getDeliverArea() {
        return deliverArea;
    }

    public void setDeliverArea(String deliverArea) {
        this.deliverArea = deliverArea;
    }

    public String getDeliverAddress() {
        return deliverAddress;
    }

    public void setDeliverAddress(String deliverAddress) {
        this.deliverAddress = deliverAddress;
    }

    public String getDeliverLng() {
        return deliverLng;
    }

    public void setDeliverLng(String deliverLng) {
        this.deliverLng = deliverLng;
    }

    public String getDeliverLat() {
        return deliverLat;
    }

    public void setDeliverLat(String deliverLat) {
        this.deliverLat = deliverLat;
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

    public Integer getDeliverDefaultState() {
        return deliverDefaultState;
    }

    public void setDeliverDefaultState(Integer deliverDefaultState) {
        this.deliverDefaultState = deliverDefaultState;
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

    public String getDeliverProvinceCode() {
        return deliverProvinceCode;
    }

    public void setDeliverProvinceCode(String deliverProvinceCode) {
        this.deliverProvinceCode = deliverProvinceCode;
    }

    public String getDeliverCityCode() {
        return deliverCityCode;
    }

    public void setDeliverCityCode(String deliverCityCode) {
        this.deliverCityCode = deliverCityCode;
    }

    public String getDeliverAreaCode() {
        return deliverAreaCode;
    }

    public void setDeliverAreaCode(String deliverAreaCode) {
        this.deliverAreaCode = deliverAreaCode;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public String getTakeProvince() {
        return takeProvince;
    }

    public void setTakeProvince(String takeProvince) {
        this.takeProvince = takeProvince;
    }

    public String getTakeCity() {
        return takeCity;
    }

    public void setTakeCity(String takeCity) {
        this.takeCity = takeCity;
    }

    public String getTakeArea() {
        return takeArea;
    }

    public void setTakeArea(String takeArea) {
        this.takeArea = takeArea;
    }

    public String getTakeAddress() {
        return takeAddress;
    }

    public void setTakeAddress(String takeAddress) {
        this.takeAddress = takeAddress;
    }

    public String getTakeLng() {
        return takeLng;
    }

    public void setTakeLng(String takeLng) {
        this.takeLng = takeLng;
    }

    public String getTakeLat() {
        return takeLat;
    }

    public void setTakeLat(String takeLat) {
        this.takeLat = takeLat;
    }

    public Integer getTakeDefaultState() {
        return takeDefaultState;
    }

    public void setTakeDefaultState(Integer takeDefaultState) {
        this.takeDefaultState = takeDefaultState;
    }

    public String getTakeProvinceCode() {
        return takeProvinceCode;
    }

    public void setTakeProvinceCode(String takeProvinceCode) {
        this.takeProvinceCode = takeProvinceCode;
    }

    public String getTakeCityCode() {
        return takeCityCode;
    }

    public void setTakeCityCode(String takeCityCode) {
        this.takeCityCode = takeCityCode;
    }

    public String getTakeAreaCode() {
        return takeAreaCode;
    }

    public void setTakeAreaCode(String takeAreaCode) {
        this.takeAreaCode = takeAreaCode;
    }
}
