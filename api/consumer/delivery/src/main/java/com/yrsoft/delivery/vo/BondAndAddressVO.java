package com.yrsoft.delivery.vo;

import java.math.BigDecimal;

/**
 * 查证金和收发货地址VO
 *
 * @author Yhq
 * @date 2019/2/23 14:09
 */
public class BondAndAddressVO {

    /**
     * 货运单id
     */
    private String id;

    /**
     * 起始省
     */
    private String startProvince;
    /**
     * 起始市
     */
    private String startCity;
    /**
     * 起始区
     */
    private String startArea;
    /**
     * 起始地详细地址
     */
    private String startAddress;

    /**
     * 发货地经度
     */
    private String startLng;
    /**
     * 发货地纬度
     */
    private String startLat;
    /**
     * 目的省
     */
    private String arriveProvince;
    /**
     * 目的市
     */
    private String arriveCity;
    /**
     * 目的区
     */
    private String arriveArea;
    /**
     * 目的地详细地址
     */
    private String arriveAddress;
    /**
     * 目的地经度
     */
    private String arriveLng;
    /**
     * 目的地维度
     */
    private String arriveLat;

    /**
     * 保证金
     */
    private Double bondMoney;

    /**
     * 公里数
     */
    private String routeRange;

    /**
     * 单车运费
     */
    private Long basicAmount;

    /**
     * 申请车辆数
     */
    private Integer applyCarNo;

    /**
     * 单车保证金金额
     */
    private Long marginAmount;

    @Override
    public String toString() {
        return "BondAndAddressVO{" +
                "id='" + id + '\'' +
                ", startProvince='" + startProvince + '\'' +
                ", startCity='" + startCity + '\'' +
                ", startArea='" + startArea + '\'' +
                ", startAddress='" + startAddress + '\'' +
                ", startLng='" + startLng + '\'' +
                ", startLat='" + startLat + '\'' +
                ", arriveProvince='" + arriveProvince + '\'' +
                ", arriveCity='" + arriveCity + '\'' +
                ", arriveArea='" + arriveArea + '\'' +
                ", arriveAddress='" + arriveAddress + '\'' +
                ", arriveLng='" + arriveLng + '\'' +
                ", arriveLat='" + arriveLat + '\'' +
                ", bondMoney=" + bondMoney +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStartProvince() {
        return startProvince;
    }

    public void setStartProvince(String startProvince) {
        this.startProvince = startProvince;
    }

    public String getStartCity() {
        return startCity;
    }

    public void setStartCity(String startCity) {
        this.startCity = startCity;
    }

    public String getStartArea() {
        return startArea;
    }

    public void setStartArea(String startArea) {
        this.startArea = startArea;
    }

    public String getStartAddress() {
        return startAddress;
    }

    public void setStartAddress(String startAddress) {
        this.startAddress = startAddress;
    }

    public String getStartLng() {
        return startLng;
    }

    public void setStartLng(String startLng) {
        this.startLng = startLng;
    }

    public String getStartLat() {
        return startLat;
    }

    public void setStartLat(String startLat) {
        this.startLat = startLat;
    }

    public String getArriveProvince() {
        return arriveProvince;
    }

    public void setArriveProvince(String arriveProvince) {
        this.arriveProvince = arriveProvince;
    }

    public String getArriveCity() {
        return arriveCity;
    }

    public void setArriveCity(String arriveCity) {
        this.arriveCity = arriveCity;
    }

    public String getArriveArea() {
        return arriveArea;
    }

    public void setArriveArea(String arriveArea) {
        this.arriveArea = arriveArea;
    }

    public String getArriveAddress() {
        return arriveAddress;
    }

    public void setArriveAddress(String arriveAddress) {
        this.arriveAddress = arriveAddress;
    }

    public String getArriveLng() {
        return arriveLng;
    }

    public void setArriveLng(String arriveLng) {
        this.arriveLng = arriveLng;
    }

    public String getArriveLat() {
        return arriveLat;
    }

    public void setArriveLat(String arriveLat) {
        this.arriveLat = arriveLat;
    }

    public Double getBondMoney() {
        return bondMoney;
    }

    public void setBondMoney(Double bondMoney) {
        this.bondMoney = bondMoney;
    }

    public String getRouteRange() {
        return routeRange;
    }

    public void setRouteRange(String routeRange) {
        this.routeRange = routeRange;
    }

    public Long getBasicAmount() {
        return basicAmount;
    }

    public void setBasicAmount(Long basicAmount) {
        this.basicAmount = basicAmount;
    }

    public Integer getApplyCarNo() {
        return applyCarNo;
    }

    public void setApplyCarNo(Integer applyCarNo) {
        this.applyCarNo = applyCarNo;
    }

    public Long getMarginAmount() {
        return marginAmount;
    }

    public void setMarginAmount(Long marginAmount) {
        this.marginAmount = marginAmount;
    }
}
