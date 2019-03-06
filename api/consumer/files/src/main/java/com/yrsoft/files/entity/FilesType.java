package com.yrsoft.files.entity;

import java.util.List;

/**
 * @ClassName: FilesType
 * @Description:(这里用一句话描述这个类的作用)
 * @author: JiaoWen
 * @date: 2019/3/4
 */

public class FilesType {
    private String type;
    private List<String> params;

    public String getType() {
        return type;
    }

    public List<String> getParams() {
        return params;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setParams(List<String> params) {
        this.params = params;
    }

    @Override
    public String toString() {
        return "FilesType{" +
                "type='" + type + '\'' +
                ", params=" + params +
                '}';
    }
}
