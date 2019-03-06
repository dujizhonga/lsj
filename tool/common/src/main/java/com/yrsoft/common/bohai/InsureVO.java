package com.yrsoft.common.bohai;

import com.yrsoft.common.utils.StringUtils;

public class InsureVO {
    private String insureType;
    private String waybillNumber;
    private String target;
    private String carNum;
    private String carVin;
    private String carLoad;
    private String startAddress;
    private String arriveAddress;
    private String idCard;
    private String userName;
    private String userSex;
    private String birthday;
    private String telephone;
    private String insureAmount;
    private String insureLimit;
    private String goodsTypeName;
    private String goodsCount;
    private String goodsRemark;

    public String getInsureType() {
        return insureType;
    }

    public void setInsureType(String insureType) {
        this.insureType = insureType;
    }

    public String getWaybillNumber() {
        return waybillNumber;
    }

    public void setWaybillNumber(String waybillNumber) {
        this.waybillNumber = waybillNumber;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        if(StringUtils.isBlank(target)){
            target = "2";
        }
        this.target = target;
    }

    public String getCarNum() {
        return carNum;
    }

    public void setCarNum(String carNum) {
        if(StringUtils.isBlank(carNum)){
            carNum = "陕AD0000";
        }
        this.carNum = carNum;
    }

    public String getCarVin() {
        return carVin;
    }

    public void setCarVin(String carVin) {
        if(StringUtils.isBlank(carVin)){
            carVin = "FB112233";
        }
        this.carVin = carVin;
    }

    public String getCarLoad() {
        return carLoad;
    }

    public void setCarLoad(String carLoad) {
        if(StringUtils.isBlank(carLoad)){
            carLoad = "0";
        }
        this.carLoad = carLoad;
    }

    public String getStartAddress() {
        return startAddress;
    }

    public void setStartAddress(String startAddress) {
        if(StringUtils.isBlank(startAddress)){
            startAddress = "陕西省西安市长安区汇航广场A座";
        }
        this.startAddress = startAddress;
    }

    public String getArriveAddress() {
        return arriveAddress;
    }

    public void setArriveAddress(String arriveAddress) {
        if(StringUtils.isBlank(arriveAddress)){
            arriveAddress = "陕西省西安市长安区汇航广场A座";
        }
        this.arriveAddress = arriveAddress;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        if(StringUtils.isBlank(idCard)){
            idCard = "";
        }
        this.idCard = idCard;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        if(StringUtils.isBlank(userName)){
            userName = "张三";
        }
        this.userName = userName;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        if(StringUtils.isBlank(userSex)){
            userSex = "1";
        }
        this.userSex = userSex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        if(StringUtils.isBlank(birthday)){
            birthday = "1970-01-01";
        }
        this.birthday = birthday;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        if(StringUtils.isBlank(telephone)){
            telephone = "";
        }
        this.telephone = telephone;
    }

    public String getInsureAmount() {
        return insureAmount;
    }

    public void setInsureAmount(String insureAmount) {
        if(StringUtils.isBlank(insureAmount)){
            insureAmount = "0";
        }
        this.insureAmount = insureAmount;
    }

    public String getInsureLimit() {
        return insureLimit;
    }

    public void setInsureLimit(String insureLimit) {
        this.insureLimit = insureLimit;
    }

    public String getGoodsTypeName() {
        return goodsTypeName;
    }

    public void setGoodsTypeName(String goodsTypeName) {
        if(StringUtils.isBlank(goodsTypeName)){
            goodsTypeName = "普通货物";
        }
        this.goodsTypeName = goodsTypeName;
    }

    public String getGoodsCount() {
        return goodsCount;
    }

    public void setGoodsCount(String goodsCount) {
        if(StringUtils.isBlank(goodsCount)){
            goodsCount = "1";
        }
        this.goodsCount = goodsCount;
    }

    public String getGoodsRemark() {
        return goodsRemark;
    }

    public void setGoodsRemark(String goodsRemark) {
        if(StringUtils.isBlank(goodsRemark)){
            goodsRemark = "普通货物";
        }
        this.goodsRemark = goodsRemark;
    }
}
