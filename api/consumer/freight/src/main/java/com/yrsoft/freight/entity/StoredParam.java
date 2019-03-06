package com.yrsoft.freight.entity;

public class StoredParam {
    private  String ids;//运单id字符串(用逗号隔开)
    private String oilScale;//加油费比例
    private String gasScale;//加气费比例
    private String etcScale;//ETC费比例

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }

    public String getOilScale() {
        return oilScale;
    }

    public void setOilScale(String oilScale) {
        this.oilScale = oilScale;
    }

    public String getGasScale() {
        return gasScale;
    }

    public void setGasScale(String gasScale) {
        this.gasScale = gasScale;
    }

    public String getEtcScale() {
        return etcScale;
    }

    public void setEtcScale(String etcScale) {
        this.etcScale = etcScale;
    }

}
